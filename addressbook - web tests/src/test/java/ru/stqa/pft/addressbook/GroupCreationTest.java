package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    goToGroup();
    initGroupCreation();
    fillGroupCreation(new GroupData("Test2", "Test3", "Test4"));
    submitGroupCreation();
    goToGroupPage();
  }

}
