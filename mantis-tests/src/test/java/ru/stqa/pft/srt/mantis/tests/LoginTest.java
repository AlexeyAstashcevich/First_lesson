package ru.stqa.pft.srt.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.srt.mantis.appmanager.HttpSession;

import java.io.IOException;

public class LoginTest extends TestBase {
  @Test
  public void tesLogin() throws IOException {
    HttpSession session = app.newSession();
    Assert.assertTrue(session.login("administrator", "rooter"));
    Assert.assertTrue(session.isLoggedInAss("administrator"));
  }

}
