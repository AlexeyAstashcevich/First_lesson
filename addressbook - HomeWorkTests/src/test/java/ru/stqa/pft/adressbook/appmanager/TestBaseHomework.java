package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseHomework {

    protected ApplicationManagerHomework app;

    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app = new ApplicationManagerHomework(wd);
        app.init();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    public ApplicationManagerHomework getApp() {
        return app;
    }

}
