package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataBuilder;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().group();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupDataBuilder().withName("Test 1").build();
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    group.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    assertThat(before,equalTo(after));
//    assertThat(after, equalTo(before.withAdded(group)));
  }
}
