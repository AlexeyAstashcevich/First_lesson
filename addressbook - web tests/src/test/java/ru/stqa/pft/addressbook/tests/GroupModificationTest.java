package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataBuilder;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    Groups before = app.group().all();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupDataBuilder()
            .withId(modifyGroup.getId())
            .withName("Test9")
            .withHeader("Test4")
            .withFooter("Test25")
            .build();
    app.group().modify(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(before.without(modifyGroup).withAdded(group), equalTo(after));
  }
}
