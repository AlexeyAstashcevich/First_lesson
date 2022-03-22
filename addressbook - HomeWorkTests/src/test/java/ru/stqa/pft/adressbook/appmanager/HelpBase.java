package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelpBase {
  WebDriver wd;

  public HelpBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
      wd.findElement(locator).click();
  }

  protected void type(String username, By locator) {
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(username);
  }

  public void login(String username, String password) {
      type(username, By.name("user"));
      type(password,By.name("pass"));
      click(By.xpath("//input[@value='Login']"));
  }

  public void stop() {
      click(By.linkText("Logout"));
      wd.quit();
  }

  protected void select(By locator, String day) {
      new Select(wd.findElement(locator)).selectByVisibleText(day);
  }
}
