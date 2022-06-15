package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;


public class AddContactToGroup extends TestBase {
  @BeforeMethod
  public void ensurePredictions() {
    if (app.db().contacts().size() == 0) {
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
  public void addContactToGroup() {
    Contacts contactsBefore = app.db().contacts();
    ContactData contactToGroup = contactsBefore.iterator().next();
    int contactId = contactToGroup.getNameId();
    GroupData group = app.db().groups().iterator().next();
    Contacts contactsInGroup = group.getContacts();
    int groupId = group.getId();
    String groupValue = group.getName();
    app.contact().contactToGroup(contactId, groupValue);
    Groups groupsList = app.db().groups();

  }

}





