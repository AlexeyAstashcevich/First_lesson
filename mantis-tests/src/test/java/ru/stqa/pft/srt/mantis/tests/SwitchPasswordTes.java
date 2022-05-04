package ru.stqa.pft.srt.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.srt.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

public class SwitchPasswordTes extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mailHelper().start();
  }

  @Test
  public void switchPassword() throws IOException {
    String user = app.getProperty("user.forChangePassword");
    String password = "password";
    app.registration().login(app.getProperty("web.loginName"), app.getProperty("web.loginPassword"));
    app.registration().changePassword(user);
    List<MailMessage> mailMessages = app.mailHelper().waitForMail(1, 100000);
    String confirmationLink = app.registration().findConfirmationLink(mailMessages, user + "@localhost");
    app.registration().finish(confirmationLink, password, user);
    Assert.assertTrue(app.newSession().login(user, password));
  }

  @AfterMethod(alwaysRun = true)
  public void closeMailServer() {
    app.mailHelper().stop();
  }
}
