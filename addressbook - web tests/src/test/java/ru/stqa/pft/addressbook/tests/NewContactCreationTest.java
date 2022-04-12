package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class NewContactCreationTest extends TestBase {


  @Test
  public void contactCreating() {
    Contacts before = app.getContactHelper().getContactList();
    app.getContactHelper().contactCreation(contactInfo);
    Contacts after = app.getContactHelper().getContactList();
    ContactData created = after.stream().sorted(Comparator.comparing(ContactData::getNameId).reversed()).findFirst().get();
    Assert.assertEquals(contactInfo, created);
    assertThat(after, equalTo(before.withAdd(created)));

  }
}
