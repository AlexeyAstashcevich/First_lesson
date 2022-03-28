package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

  @Test
  public void groupModification() {
    app.getNavigationHelper().goToGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().creationGroup(new GroupData("Test 1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupCreation(new GroupData("Test9", "Test4", "Test25"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().goToGroup();
  }

}
