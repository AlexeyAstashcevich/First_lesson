package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup()  {
    app.getGroupNavigation().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().goToGroup();
    app.logOut();

  }

}
