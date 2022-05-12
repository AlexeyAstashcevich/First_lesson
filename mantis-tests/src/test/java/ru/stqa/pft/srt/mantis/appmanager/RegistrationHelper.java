package ru.stqa.pft.srt.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.srt.mantis.model.MailMessage;

import java.util.List;

public class RegistrationHelper extends HelperBase {
  private final WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
    super(app);
    this.wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(username, By.name("username"));
    type(email, By.name("email"));
    click(By.cssSelector("input[value='Зарегистрироваться']"));
  }

  public void finish(String confirmationLink, String password, String username) {
    wd.get(confirmationLink);
    type(username, By.name("realname"));
    type(password, By.name("password"));
    type(password, By.name("password_confirm"));
    click(By.cssSelector("span.bigger-110"));

  }

  public void changePassword(String user) {
    click(By.cssSelector("i.fa.fa-gears.menu-icon"));
    click(By.linkText("Управление пользователями"));
    click(By.linkText(user));
    click(By.xpath("//input[@value='Сбросить пароль']"));
  }

  public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter(m -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl"));
    type(username, By.name("username"));
    click(By.cssSelector("input[value='Вход']"));
    type(password, By.name("password"));
    click(By.cssSelector("input[value='Вход']"));
  }

}
