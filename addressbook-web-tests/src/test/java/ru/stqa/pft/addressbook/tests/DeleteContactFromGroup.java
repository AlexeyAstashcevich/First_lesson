package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase{
  @BeforeMethod
  public void ensurePredictions(){
    if (app.db().contacts().size()==0) {
      app.contact().contactCreation(contactInfo);
      app.goTo().group();
      if (app.db().groups().size() == 0) {
        app.group().create(new GroupData().withName("Test 0")
                .withHeader("Test9")
                .withFooter("Test27"));
      }
    }
  }
  @Test
  public void deleteContactFromGroup() {
    Contacts before = app.db().contacts();//in group
    int id = before.stream().mapToInt(ContactData::getNameId).max().getAsInt();
    app.contact().deleteContactFromGroup(id);
    Contacts after = app.db().contacts();// out of group with this id
    ContactData withoutGroup = before.stream().filter((x)->x.getNameId()==id).findAny().get();
    ContactData withGroup = after.stream().filter((x)->x.getNameId()==id).findAny().get();
    before.remove(withoutGroup);
    before.add(withGroup);
    assertThat(before, equalTo(after));
  }
}

