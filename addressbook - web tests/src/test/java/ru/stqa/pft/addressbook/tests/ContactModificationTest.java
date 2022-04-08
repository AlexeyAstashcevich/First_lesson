package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;


public class ContactModificationTest extends TestBase {


  @Test
  public void contactModification() {
    if (!app.goTo().isThereAContact()) {
      app.getContactHelper().contactCreation(contactInfo);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    int id = before.get(before.size()-1).getNameId();
    modificatedInfo.setNameId(id);
    app.getContactHelper().contactModification(modificatedInfo);
    List<ContactData> after = app.getContactHelper().getContactList();
    ContactData updated = after.stream().filter(x->x.getNameId()==id).findAny().get();
    Assert.assertEquals(after.size(),before.size());
    Assert.assertEquals(updated, modificatedInfo );
  }
}
