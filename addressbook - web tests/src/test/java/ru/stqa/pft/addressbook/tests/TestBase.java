package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;

import java.time.LocalDate;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(null, BrowserType.FIREFOX);
  protected ContactData contactInfo;
  protected ContactData modificatedInfo;
  WebDriver wd;

  @BeforeSuite(alwaysRun = true)
  public void setUp() {
    app.init();
    modificatedInfo = new ContactDataBuilder()
            .firstname("Jojo ")
            .middleName("Laini")
            .lastname("Lomper")
            .nickname("Lomovoz")
            .photoDirectory("resources/Jojo.jpg")
            .title("Bjo")
            .company("Kex")
            .companyAddress("Usa, malahon beach 42")
            .homePhone("+7124545")
            .fax("None")
            .mobilePhone("+754543543")
            .workPhone("+2348674556")
            .email1("Jojo@jojo.com")
            .email2("Jina@gmail.com")
            .email3("mocha@jojo.com")
            .homepage("yandex.ru")
            .birthday(LocalDate.of(1931, 2, 13))
            .anniversary(LocalDate.of(1823, 2, 17))
            .group("Test 1")
            .creation(false)
            .secondaryAdress("Usa, Kex beach")
            .secondaryPhone("11")
            .notes("Just woman")
            .build();

    contactInfo = new ContactDataBuilder()
            .firstname("Alex")
            .middleName("Bolduin")
            .lastname("Bolduin")
            .nickname("Boldi")
            .photoDirectory("resources/Bolduin.jpg")
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
            .secondaryPhone("48")
            .notes("Best friend")
            .build();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


}
