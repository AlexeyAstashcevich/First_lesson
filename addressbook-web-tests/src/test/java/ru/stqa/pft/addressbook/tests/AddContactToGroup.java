package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactInGroup;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.Set;


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
    Contacts allContactsListBeforeTheTest = app.db().contacts();
    Set<ContactInGroup> contactsInGroupsBeforeTheTest = app.db().contactsInGroups();
    Set<Integer> contactsWithoutGroupBeforeTheTest = new HashSet<>();
    isContactInGroup(allContactsListBeforeTheTest, contactsInGroupsBeforeTheTest, contactsWithoutGroupBeforeTheTest);
    int id = contactsWithoutGroupBeforeTheTest.stream().iterator().next();
    app.contact().contactToGroup(id);
    Contacts AllContactsListAfterTheTest = app.db().contacts();
    Set<ContactInGroup> contactsWithoutGroupsAfterTheTest = app.db().contactsInGroups();
    Set<Integer> contactsWithoutGrupsAfterTheTest = new HashSet<>();
    isContactInGroupAfter(AllContactsListAfterTheTest, contactsWithoutGroupsAfterTheTest, contactsWithoutGrupsAfterTheTest);
    Assert.assertFalse(contactsWithoutGrupsAfterTheTest.contains(AllContactsListAfterTheTest.stream().filter(x -> x.getNameId() == id).findAny().get()));

  }

  private void isContactInGroup(Contacts listOFContacts, Set<ContactInGroup> contactsFromContactInGroupsTable, Set<Integer> listOfContactWithoutGroup) {
    for (ContactData object : listOFContacts) {
      listOfContactWithoutGroup.add(object.getNameId());
    }

    for (ContactInGroup object : contactsFromContactInGroupsTable) {
      if (listOfContactWithoutGroup.contains(object.getId())) {
        listOfContactWithoutGroup.remove(object.getId());
      } else {
        listOfContactWithoutGroup.add(object.getId());
      }
    }
    if (listOfContactWithoutGroup.size() == 0) {
      app.contact().contactCreations(contactInfo);
      Contacts contact = app.db().contacts();
      int id = contact.stream().mapToInt(x -> x.getNameId()).max().getAsInt();
      listOfContactWithoutGroup.add(id);
      listOFContacts.add(contact.stream().filter((x) -> x.getNameId() == id).findAny().get());
    }
  }

  private void isContactInGroupAfter(Contacts listOFContacts, Set<ContactInGroup> contactsFromContactInGroupsTable, Set<Integer> listOfContactWithoutGroup) {
    for (ContactData object : listOFContacts) {
      listOfContactWithoutGroup.add(object.getNameId());
    }

    for (ContactInGroup object : contactsFromContactInGroupsTable) {
      if (listOfContactWithoutGroup.contains(object.getId())) {
        listOfContactWithoutGroup.remove(object.getId());
      } else {
        listOfContactWithoutGroup.add(object.getId());
      }
    }
  }
}
