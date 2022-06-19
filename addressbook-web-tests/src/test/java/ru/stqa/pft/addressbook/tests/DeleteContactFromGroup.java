package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInGroup;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

public class DeleteContactFromGroup extends TestBase {
  @BeforeMethod
  public void ensurePredictions() {
    if (app.db().contacts().size() == 0) {
      app.contact().contactCreation(contactInfo);
      app.goTo().group();
      if (app.db().groups().stream().map(GroupData::getName).noneMatch(x -> x.equals("Test 0"))) {
        app.group().create(new GroupData().withName("Test 0").withHeader("Test9").withFooter("Test27"));
      }
    }
  }

  @Test
  public void deleteContactFromGroup() {
    Set<ContactInGroup> contactsFromContactInGroupsTable = app.db().contactsInGroups();
    Groups groups = app.db().groups();
    if (contactsFromContactInGroupsTable.size() < 1) {
      int id = app.db().contacts().stream().iterator().next().getNameId();
      String group = app.db().groups().stream().findAny().toString();
      app.contact().contactToGroup(id, group);
      contactsFromContactInGroupsTable = app.db().contactsInGroups();
    }
    ContactInGroup contact = contactsFromContactInGroupsTable.iterator().next();
    int contactId = contact.getId();
    int groupId = contact.getGroupId();
    String group = groups.stream().filter(x -> x.getId() == groupId).findAny().get().getName();
    Contacts contactsInGroup = groups.stream().filter(x -> x.getId() == groupId).findAny().get().getContacts();
    app.contact().deleteContactFromGroup(contactId, group);
    Contacts contactsAfterDeleted = app.db().groups().stream().filter(x -> x.getId() == groupId).findAny().get().getContacts();
    Assert.assertEquals(contactsAfterDeleted,
            contactsInGroup.without(contactsInGroup.stream().filter(x -> x.getNameId() == contactId).findAny().get()));
  }
}


