package ru.stqa.pft.srt.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.srt.mantis.appmanager.ApplicationManager;

import java.io.IOException;
import java.util.Properties;

public class TestBase {

  private static Properties properties;
  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME), properties);

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }
}



