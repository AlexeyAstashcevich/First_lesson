package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.getGroupHelper().goToGroup();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.goToGroupPage();
    app.logOut();

  }

}
