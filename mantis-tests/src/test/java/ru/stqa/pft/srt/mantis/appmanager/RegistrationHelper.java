package ru.stqa.pft.srt.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase {
  private WebDriver wd;
  public RegistrationHelper(ApplicationManager app) {
    super(app);
    this.wd = app.getDriver();
  }
  public void start(String username, String email){
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(username, By.name("username"));
    type(email, By.name("email"));
    click(By.cssSelector("input[value='Signup']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(password, By.name("password"));
    type(password, By.name("password_confirm"));
    click(By.cssSelector("input[value='Update User']"));

  }
}
