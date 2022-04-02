package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

  @Test
  public void groupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().creationGroup(new GroupData("Test 1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "Test9", "Test4", "Test25");
    app.getGroupHelper().fillGroupCreation(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().goToGroup();
    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    List<GroupData> after = app.getGroupHelper().getGroupList();
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after.size(), before.size());
    Assert.assertEquals(before, after);
  }

}
