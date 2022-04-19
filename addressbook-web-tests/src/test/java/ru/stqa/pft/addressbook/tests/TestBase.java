package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  protected ContactData contactInfo;
  protected ContactData modificatedInfo;
  private final Properties properties;

  public TestBase() {
    properties = new Properties();
  }


  @BeforeSuite(alwaysRun = true)
  public void setUp() throws IOException {
    app.init();

    String target = System.getProperty("fileName", "modificationInfo");
    properties.load(new FileReader(String.format("src/test/java/ru/stqa/pft/addressbook/resources/%s.properties", target)));
    modificatedInfo = new ContactDataBuilder()
            .firstname(properties.getProperty("firstname"))
            .middleName(properties.getProperty("middleName"))
            .lastname(properties.getProperty("lastname"))
            .nickname(properties.getProperty("nickname"))
            .photoDirectory(properties.getProperty("photoDirectory"))
            .title(properties.getProperty("title"))
            .company(properties.getProperty("company"))
            .companyAddress(properties.getProperty("companyAddress"))
            .homePhone(properties.getProperty("homePhone"))
            .fax(properties.getProperty("fax"))
            .mobilePhone(properties.getProperty("mobilePhone"))
            .workPhone(properties.getProperty("workPhone"))
            .email1(properties.getProperty("email1"))
            .email2(properties.getProperty("email2"))
            .email3(properties.getProperty("email3"))
            .homepage(properties.getProperty("homepage"))
            .birthday(LocalDate.of(1931, 2, 13))
            .anniversary(LocalDate.of(1823, 2, 17))
            .group(properties.getProperty("firstname"))
            .creation(Boolean.valueOf(properties.getProperty("creation")))
            .secondaryAdress(properties.getProperty("secondaryAdress"))
            .secondaryPhone(properties.getProperty("secondaryPhone"))
            .notes(properties.getProperty("notes"))
            .build();


    target = System.getProperty("fileName", "contactCreationInfo");
    properties.load(new FileReader(String.format("src/test/java/ru/stqa/pft/addressbook/resources/%s.properties", target)));
    contactInfo = new ContactDataBuilder()
            .firstname(properties.getProperty("firstname"))
            .middleName(properties.getProperty("middleName"))
            .lastname(properties.getProperty("lastname"))
            .nickname("Boldi")
            .photoDirectory("src/test/java/ru/stqa/pft/addressbook/resources/Bolduin.jpg")
            .title("Boldo-Voldo")
            .company("Fox")
            .companyAddress("Usa, bryton beach 48")
            .homePhone("+78954523")
            .fax("None")
            .mobilePhone("+735645645")
            .workPhone("+2344234432")
            .email1("boldi@jojo.com")
            .email2("holo@gmail.com")
            .email3("gop@jojo.com")
            .homepage("yandex.ru")
            .birthday(LocalDate.of(1991, 5, 13))
            .anniversary(LocalDate.of(1889, 6, 12))
            .group("Test 1")
            .creation(true)
            .secondaryAdress("Usa, Briton beach")
            // .secondaryPhone("48")
            .notes("Best friend")
            .build();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.goTo().stop();
  }


}
