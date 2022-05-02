package ru.stqa.pft.srt.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private  String browser;
  private final Properties properties;
  private WebDriver wd;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mailHelper;
  private JamesHelper jamesHelper;


  public ApplicationManager(String browser) {
    this.browser = browser;
    this.properties = new Properties();
  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));
  }

  public void stop() {
    if(wd != null){
      wd.quit();
    }
  }

  public FtpHelper ftp(){
    if(ftp == null){
      ftp = new FtpHelper(this);
    }
    return ftp;
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

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }

  public WebDriver getDriver() {
    if(wd== null){
      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }


  public MailHelper mailHelper(){
    if (mailHelper==null){
      mailHelper= new MailHelper(this);
    }
    return mailHelper;
  }

  public JamesHelper james(){
    if(jamesHelper == null){
      jamesHelper= new JamesHelper(this);
    }
    return jamesHelper;
  }
}


