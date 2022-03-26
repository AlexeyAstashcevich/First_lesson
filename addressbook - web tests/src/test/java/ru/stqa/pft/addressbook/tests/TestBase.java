package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected ApplicationManager app;

    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        app = new ApplicationManager(wd, BrowserType.IE);
        app.init();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }


}
