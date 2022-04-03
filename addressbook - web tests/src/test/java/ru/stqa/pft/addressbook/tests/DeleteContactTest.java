package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;


public class DeleteContactTest extends TestBase {
  @Test
  public void deleteContact(){
    if (! app.getNavigationHelper().isThereAContact()){
     app.getContactHelper().getCreationContact();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().chooseContact();
    app. getNavigationHelper().deleteContact();
    app.getNavigationHelper().submitDeleteContact();
    app.getNavigationHelper().goToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Comparator<? super ContactData> byId= Comparator.comparing(ContactData::getFirstname);
    after.sort(byId);
    before.sort(byId);
    Assert.assertEquals(after,before);
  }
}
