package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeleteGroupTest extends TestBase {

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
    public void testDeleteGroup() {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.db().groups();
        assertThat(before.without(deletedGroup), equalTo(after));
        verifyGroupListInUi();
    }
}



