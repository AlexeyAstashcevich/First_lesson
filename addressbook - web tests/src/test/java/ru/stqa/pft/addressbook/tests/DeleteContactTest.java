package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class DeleteContactTest extends TestBase {
  @Test
  public void deleteContact(){
    if (! app.getNavigationHelper().isThereAContact()){
     app.getContactHelper().getCreationContact();
    }
    app.getNavigationHelper().chooseContact();
    app. getNavigationHelper().deleteContact();
    app.getNavigationHelper().submitDeleteContact();
  }
}
