package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().group();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("Test741")
                    .withHeader("Test9")
                    .withFooter("Test27"));
        }
    }

    @Test
    public void groupModification() {

        Groups before = app.db().groups();
        GroupData modifyGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifyGroup.getId())
                .withName("Test741")
                .withHeader("Test4")
                .withFooter("Test25");
        app.group().modify(group);
        assertThat(app.group().count(),equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(before.without(modifyGroup).withAdded(group), equalTo(after));
    }
}
