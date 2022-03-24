package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.appmanager.TestBaseHomework;

public class DeleteContactTestHomework extends TestBaseHomework {
  @Test
  public void deleteContact(){
    app.getNavigationHelper().chooseContact();
    app. getNavigationHelper().deleteContact();
    app.getNavigationHelper().submitDeleteContact();
  }
}
