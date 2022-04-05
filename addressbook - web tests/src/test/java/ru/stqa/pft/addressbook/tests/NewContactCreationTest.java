package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class NewContactCreationTest extends TestBase {


  @Test
  public void contactCreating() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().contactCreation(contactInfo);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size() + 1, after.size());
    after.sort(Comparator.comparing(ContactData::getNameId));
    ContactData created = after.get(after.size() - 1);
    Assert.assertEquals(contactInfo, created);

  }
}
