package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactModificationTest extends TestBase {


  @Test
  public void contactModification() {
    if (!app.goTo().isThereAContact()) {
      app.getContactHelper().contactCreation(contactInfo);
    }
    Contacts before = app.getContactHelper().getContactList();
    int id = before.stream().mapToInt((g) -> g.getNameId()).max().getAsInt();
    ContactData modifyContact = before.iterator().next();
    modificatedInfo.setNameId(id);
    app.getContactHelper().contactModification(modificatedInfo);
    Contacts after = app.getContactHelper().getContactList();
    ContactData updated = after.stream().filter(x->x.getNameId()==id).findAny().get();
    assertThat(after.size(),equalTo(before.size()));
    assertThat(updated,equalTo(modificatedInfo));
    assertThat(after, equalTo(before.without(modifyContact).withAdd(updated)));
  }
}
