package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getGroupNavigation().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupCreation(new GroupData("Test2", "Test3", "Test4"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().goToGroup();
    app.stop();
  }

}
