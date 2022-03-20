package ru.stqa.pft.adressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewContactCreationTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.get("http://localhost/addressbook/index.php");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testNewContactCreation() {
    addNewContact();
    fillNamesForms(new NamesData("Alex", "Bolduin", "Bolduin", "Boldi"));
    addPhoto(new PhotoData("C:\\Users\\zbvnr\\Downloads\\Bolduin.jpg"));
    fillCompanyForms(new CompanysData("Boldo-voldo", "Fox", "Usa, Loss Angeles , 34"));
    fillPhonesForms(new PhonesData("+7895454", "+1875643", "Artsit", "none"));
    fillEmailsForms(new EmailsData("boldi@gmail.com", "boldodi@yandex.com", "boldo@gaga.com"));
    fillHomepage(new HomepageData("yandex.ru"));
    fillBirthday(new BirthdayData("15", "August", "1989"));
    fillAnyversary(new AnyversaryData("17", "November", "1990"));
    chooseGroup(new GroupData("Test1"));
    fillSecondaryAddress(new SecondaryAddressData("Usa, Briton beach"));
    fillSecondaryPhone(new SecondaryPhoneData("48"));
    fillNotes(new NotesData("Best friend"));
    goToHomepage();

  }

  private void goToHomepage() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    wd.findElement(By.linkText("home page")).click();
  }

  private void fillNotes(NotesData notesData) {
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(notesData.getNotes());
  }

  private void fillSecondaryPhone(SecondaryPhoneData secondaryPhoneData) {
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(secondaryPhoneData.getSecondaryPhone());
  }

  private void fillSecondaryAddress(SecondaryAddressData secondaryAddressData) {
    wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).click();
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(secondaryAddressData.getSecondaryAdress());
  }

  private void chooseGroup(GroupData groupData) {
    wd.findElement(By.name("new_group")).click();
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupData.getGroup());
  }

  private void fillAnyversary(AnyversaryData anyversaryData) {
    wd.findElement(By.name("aday")).click();
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(anyversaryData.getDay());
    wd.findElement(By.xpath("//div[@id='content']/form/select[3]/option[19]")).click();
    wd.findElement(By.name("amonth")).click();
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(anyversaryData.getMonth());
    wd.findElement(By.xpath("//div[@id='content']/form/select[4]/option[12]")).click();
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(anyversaryData.getYear());
  }

  private void fillBirthday(BirthdayData birthdayData) {
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(birthdayData.getDay());
    wd.findElement(By.xpath("//option[@value='15']")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(birthdayData.getMonth());
    wd.findElement(By.xpath("//option[@value='August']")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(birthdayData.getYear());
  }

  private void fillHomepage(HomepageData homepageData) {
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(homepageData.getHomepage());
  }

  private void fillEmailsForms(EmailsData emailsData) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(emailsData.getEmail1());
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(emailsData.getEmail2());
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(emailsData.getEmail3());
  }

  private void fillPhonesForms(PhonesData phonesData) {
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(phonesData.getHomePhone());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(phonesData.getMobilePhone());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(phonesData.getWork());
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(phonesData.getFax());
  }

  private void fillCompanyForms(CompanysData companysData) {
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(companysData.getTitle());
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(companysData.getCompany());
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(companysData.getCompanyAdress());
  }

  private void addPhoto(PhotoData photoData) {
    wd.findElement(By.name("photo")).clear();
    wd.findElement(By.name("photo")).sendKeys(photoData.getPhotoDirectory());
  }

  private void fillNamesForms(NamesData namesData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(namesData.getFirstname());
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(namesData.getMiddlename());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(namesData.getLastname());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(namesData.getNickname());
  }

  private void addNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
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
}
