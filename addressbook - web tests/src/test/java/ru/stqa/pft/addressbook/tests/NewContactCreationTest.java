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
      int max = after.stream().max(Comparator.comparingInt(ContactData::getNameId)).get().getNameId();
      after.get(after.size() - 1).setNameId(max);
      before.add(after.get(after.size() - 1));
      Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

  }
}
