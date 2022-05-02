package ru.stqa.pft.srt.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.srt.mantis.model.MailMessage;

import java.util.List;

public class SwitchPasswordTes extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mailHelper().start();
  }

  @Test
  public void switchPassword(){
    String user = app.getProperty("user.forChangePassword");
    app.registration().changePassword(user);
    List<MailMessage> mailMessages = app.mailHelper().waitForMail(2, 10000);
  }

  @AfterMethod(alwaysRun = true)
  public void closeMailServer() {
    app.mailHelper().stop();
  }
}
