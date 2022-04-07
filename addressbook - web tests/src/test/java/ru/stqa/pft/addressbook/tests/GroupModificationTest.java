package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataBuilder;
import java.util.Set;

public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().group();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupDataBuilder().withName("Test 1").build());
    }
  }

  @Test
  public void groupModification() {

    Set<GroupData> before = app.group().all();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupDataBuilder()
            .withId(modifyGroup.getId())
            .withName("Test9")
            .withHeader("Test4")
            .withFooter("Test25")
            .build();
    app.group().modify(group);
    before.remove(modifyGroup);
    before.add(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    Assert.assertEquals(before, after);
  }
}
