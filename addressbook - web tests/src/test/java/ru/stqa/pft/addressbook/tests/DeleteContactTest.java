package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class DeleteContactTest extends TestBase {
 NewContactCreationTest contactCreationTest = new NewContactCreationTest();
  @Test
  public void deleteContact(){
    if (! app.getNavigationHelper().isThereAContact()){
      contactCreationTest.NewContactCreation(app);
    }
    app.getNavigationHelper().chooseContact();
    app. getNavigationHelper().deleteContact();
    app.getNavigationHelper().submitDeleteContact();
  }
}
