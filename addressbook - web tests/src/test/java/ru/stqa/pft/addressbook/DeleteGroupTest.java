package ru.stqa.pft.addressbook;

import org.testng.annotations.*;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    goToGroup();
    selectGroup();
    deleteSelectedGroups();
    goToGroupPage();

  }

}
