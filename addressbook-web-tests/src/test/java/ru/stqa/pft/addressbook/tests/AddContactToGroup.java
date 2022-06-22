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
import java.util.stream.Collectors;


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
    Contacts contactsBefore = app.db().contacts();
    Set<ContactInGroup> contactsFromContactInGroupsTable = app.db().contactsInGroups();
    Set<Integer> listOfContactWithoutGroup = new HashSet<>();
    isContactInGroup(contactsBefore, contactsFromContactInGroupsTable, listOfContactWithoutGroup);
    int contactId = listOfContactWithoutGroup.iterator().next();
    GroupData group = app.db().groups().iterator().next();
    int groupId = group.getId();
    String groupValue = group.getName();
    app.contact().contactToGroup(contactId, groupValue);
    Contacts contactsAfterAdd = app.db().groups().stream().filter(x -> x.getId() == groupId).findAny().get().getContacts();
    Assert.assertTrue(contactsAfterAdd.stream().map(x->x.getNameId()).collect(Collectors.toList()).contains(contactId));
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
      if (listOfContactWithoutGroup.size() == 0) {
        app.contact().contactCreations(contactInfo);
        Contacts contact = app.db().contacts();
        int id = contact.stream().mapToInt(x -> x.getNameId()).max().getAsInt();
        listOfContactWithoutGroup.add(id);
        listOFContacts.add(contact.stream().filter((x) -> x.getNameId() == id).findAny().get());
      }
    }
  }

}





