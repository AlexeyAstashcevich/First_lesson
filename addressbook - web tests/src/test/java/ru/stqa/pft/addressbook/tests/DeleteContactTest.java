package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class DeleteContactTest extends TestBase {


  @Test
  public void deleteContact() {
    if (!app.goTo().isThereAContact()) {
      app.getContactHelper().contactCreation(contactInfo);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.goTo().chooseContact();
    app.goTo().deleteContact();
    app.goTo().submitDeleteContact();
    app.goTo().goHomeHeadear();
    List<ContactData> after = app.getContactHelper().getContactList();
    Comparator<? super ContactData> byId = Comparator.comparing(ContactData::getNameId);
    after.sort(byId);
    before.sort(byId);
    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }
}
