package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(String text, By locator) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!existingText.equals(text)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }
    protected void insertPhoto(String dyrectory) {
        wd.findElement(By.name("photo")).sendKeys(new File(dyrectory).getAbsolutePath());
    }

    public void login(String username, String password) {
        type(username, By.name("user"));
        type(password, By.name("pass"));
        click(By.xpath("//input[@value='Login']"));
    }

    public void stop() {
        click(By.linkText("Logout"));
        wd.quit();
    }


    protected void select(By locator, String day) {
        new Select(wd.findElement(locator)).selectByVisibleText(day);
    }

    protected boolean isElemrntPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
