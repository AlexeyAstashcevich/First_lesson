package ru.stqa.pft.srt.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.srt.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

public class RegistrationTest extends TestBase{
  @BeforeMethod
  public void startMailServer(){
    app.mailHelper().start();
  }

  @Test
  public void registrationTest() throws IOException {
    String email = "user1@localhost.localdomain";
    String username = "user 1";
    app.registration().start(username, email);
    List<MailMessage> mailMessages =app.mailHelper().waitForMail(2,10000);
    String confirmationLink =findConfirmationLink(mailMessages, email);
    String password = "password";
    app.registration().finish(confirmationLink, password);
    Assert.assertTrue(app.newSession().login(username,password));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter(m -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void closeMailServer(){
    app.mailHelper().stop();
  }
}
