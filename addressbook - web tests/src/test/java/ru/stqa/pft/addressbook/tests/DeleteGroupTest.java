package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataBuilder;

import java.util.Set;


public class DeleteGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().group();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupDataBuilder().withName("Test 1").build());
    }
  }

  @Test
  public void testDeleteGroup() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(before.size() - 1, after.size());
    before.remove(deletedGroup);
    Assert.assertEquals(before, after);

  }


}



