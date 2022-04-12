package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeleteContactTest extends TestBase {


  @Test
  public void deleteContact() {
    if (!app.goTo().isThereAContact()) {
      app.getContactHelper().contactCreation(contactInfo);
    }
    Contacts before = app.getContactHelper().getContactList();
    ContactData deletedContact = before.iterator().next();
    app.goTo().chooseContact();
    app.goTo().deleteContact();
    app.goTo().submitDeleteContact();
    app.goTo().goHomeHeadear();
    Contacts after = app.getContactHelper().getContactList();
   // assertThat(after, equalTo(before.without(deletedContact)));
    Assert.assertEquals(after,before.without(deletedContact));
  }
}
