package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerHomework extends HelpBaseHomework {

    private NavigationHelperHomework navigationHelperHomework;
    private ContactHelperHomework contactHelperHomework;
    private GroupHelperHomework groupHelperHomework;

    public ApplicationManagerHomework(WebDriver wd) {
        super(wd);
    }


    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        contactHelperHomework = new ContactHelperHomework(wd);
        navigationHelperHomework = new NavigationHelperHomework(wd);
        groupHelperHomework = new GroupHelperHomework(wd);
        login("admin", "secret");
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


    public NavigationHelperHomework getNavigationHelper() {
        return navigationHelperHomework;
    }

    public ContactHelperHomework getContactHelper() {
        return contactHelperHomework;
    }

    public GroupHelperHomework getGroupHelper() {
        return groupHelperHomework;
    }


}


