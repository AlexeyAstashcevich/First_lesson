package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.util.concurrent.TimeUnit;

public class ApplicationManager extends HelperBase {
    private final String browser;
    private NavigationHelper navigationHelperHomework;
    private ContactHelper contactHelperHomework;
    private GroupHelper groupHelper;
    private GroupNavigation groupNavigation;
    private SessionHelper sessionHelper;

    public ApplicationManager(WebDriver wd, String browser) {
        super(wd);
        this.browser = browser;
    }


    public void init() {
        if(browser== BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        }else if  (browser== BrowserType.CHROME){
            wd = new ChromeDriver();
        }else if  (browser== BrowserType.IE){
            wd = new InternetExplorerDriver();
        }
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


