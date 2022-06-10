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
    Contacts before = app.db().contacts();
    Set<ContactInGroup> groups = app.db().contactsInGroups();
    Set<Integer> run = new HashSet<>();
    isContactInGroup(before, groups, run);
    int id = run.stream().iterator().next();
    app.contact().contactToGroup(id);
    Contacts after = app.db().contacts();
    Set<ContactInGroup> groupsAfter = app.db().contactsInGroups();
    Set<Integer> runAfter = new HashSet<>();
    isContactInGroupAfter(after, groupsAfter, runAfter);
    Assert.assertFalse(runAfter.contains(after.stream().filter(x -> x.getNameId() == id).findAny().get()));

  }

  private void isContactInGroup(Contacts before, Set<ContactInGroup> groups, Set<Integer> run) {
    for (ContactData object : before) {
      run.add(object.getNameId());
    }

    for (ContactInGroup object : groups) {
      if (run.contains(object.getId())) {
        run.remove(object.getId());
      } else {
        run.add(object.getId());
      }
    }
    if (run.size() == 0) {
      app.contact().contactCreations(contactInfo);
      Contacts contact = app.db().contacts();
      int id = contact.stream().mapToInt(x -> x.getNameId()).max().getAsInt();
      run.add(id);
      before.add(contact.stream().filter((x) -> x.getNameId() == id).findAny().get());
    }
  }

  private void isContactInGroupAfter(Contacts before, Set<ContactInGroup> groups, Set<Integer> run) {
    for (ContactData object : before) {
      run.add(object.getNameId());
    }

    for (ContactInGroup object : groups) {
      if (run.contains(object.getId())) {
        run.remove(object.getId());
      } else {
        run.add(object.getId());
      }
    }
  }
}
