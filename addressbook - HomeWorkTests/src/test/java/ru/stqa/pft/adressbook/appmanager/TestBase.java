package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected ApplicationManager app;

    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app = new ApplicationManager(wd);
        app.init();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }

}
