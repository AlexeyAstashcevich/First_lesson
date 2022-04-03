package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class NewContactCreationTest extends TestBase {

  @Test

  public void contactCreating() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().getCreationContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    before.add(after.get(after.size() - 1));
    Comparator<? super ContactData> byId = Comparator.comparing(ContactData::getFirstname);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

  }
}
