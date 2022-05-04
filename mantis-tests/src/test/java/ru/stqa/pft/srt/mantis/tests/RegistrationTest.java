package ru.stqa.pft.srt.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.srt.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class RegistrationTest extends TestBase {
  //@BeforeMethod
  public void startMailServer() {
    app.mailHelper().start();
  }

  @Test
  public void registrationTest() throws IOException, MessagingException {
    long now = System.currentTimeMillis();
    String email = String.format("user%s@localhost", now);
    String username = String.format("user%s", now);
    String password = "password";
    app.james().createUser(username, password);
    app.registration().start(username, email);
// List<MailMessage> mailMessages = app.mailHelper().waitForMail(2, 10000);
    List<MailMessage> mailMessages = app.james().waitForMail(username, password, 60000);
    String confirmationLink = app.registration().findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password, username);
    Assert.assertTrue(app.newSession().login(username, password));
  }


  //@AfterMethod(alwaysRun = true)
  public void closeMailServer() {
    app.mailHelper().stop();
  }
}
