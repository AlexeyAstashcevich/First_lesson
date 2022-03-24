package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends HelperBase {

    private NavigationHelper navigationHelperHomework;
    private ContactHelper contactHelperHomework;
    private GroupHelper groupHelper;
    private GroupNavigation groupNavigation;
    private SessionHelper sessionHelper;

    public ApplicationManager(WebDriver wd) {
        super(wd);
    }


    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        contactHelperHomework = new ContactHelper(wd);
        navigationHelperHomework = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd);
        groupNavigation = new GroupNavigation(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
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


    public NavigationHelper getNavigationHelper() {
        return navigationHelperHomework;
    }

    public ContactHelper getContactHelper() {
        return contactHelperHomework;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public GroupNavigation getGroupNavigation() {
        return groupNavigation;
    }


}


