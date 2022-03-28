package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class DeleteContactTest extends TestBase {

  @Test
  public void deleteContact(){
    app.getNavigationHelper().chooseContact();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().creationGroup(new GroupData("Test 1", null, null));
    }
    app. getNavigationHelper().deleteContact();
    app.getNavigationHelper().submitDeleteContact();
  }
}
