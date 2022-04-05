package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContactHelper extends HelperBase {

  GroupHelper groupHelper = new GroupHelper(wd);
  NavigationHelper navigationHelper = new NavigationHelper(wd);

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void fillSecondaryAddress(ContactData secondaryAddressData) {
    type(secondaryAddressData.getSecondaryAdress(), By.name("address2"));
  }

  public void fillCompanyForms(ContactData contactData) {
    type(contactData.getTitle(), By.name("title"));
    type(contactData.getCompany(), By.name("company"));
    type(contactData.getCompanyAddress(), By.name("address"));
  }

  public void fillAnyversary(LocalDate anniversary) {
    click(By.name("aday"));
    select(By.name("aday"), String.valueOf(anniversary.getDayOfMonth()));
    click(By.name("amonth"));
    select(By.name("amonth"), anniversary.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    type(String.valueOf(anniversary.getYear()), By.name("ayear"));
  }

  public void fillBirthday(LocalDate birthday) {
    click(By.name("bday"));
    select(By.name("bday"), String.valueOf(birthday.getDayOfMonth()));
    click(By.name("bmonth"));
    select(By.name("bmonth"), birthday.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    type(String.valueOf(birthday.getYear()), By.name("byear"));
  }

  public void fillEmailsForms(ContactData emailsData) {
    type(emailsData.getEmail1(), By.name("email"));
    type(emailsData.getEmail2(), By.name("email2"));
    type(emailsData.getEmail3(), By.name("email3"));
  }

  public void fillNamesForms(ContactData namesData) {
    type(namesData.getFirstname(), By.name("firstname"));
    type(namesData.getMiddleName(), By.name("middlename"));
    type(namesData.getLastname(), By.name("lastname"));
    type(namesData.getNickname(), By.name("nickname"));
  }

  public void fillNotes(ContactData notesData) {
    type(notesData.getNotes(), By.name("notes"));
  }

  public void fillSecondaryPhone(ContactData secondaryPhoneData) {
    type(secondaryPhoneData.getSecondaryPhone(), By.name("phone2"));
  }

  public void fillPhonesForms(ContactData phonesData) {
    type(phonesData.getHomePhone(), By.name("home"));
    type(phonesData.getMobilePhone(), By.name("mobile"));
    type(phonesData.getWorkPhone(), By.name("work"));
    type(phonesData.getFax(), By.name("fax"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.tagName("tr"));
    for (int i = 1; i < elements.size(); i++) {
      int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> colVals = elements.get(i).findElements(By.tagName("td"));
      contacts.add(new ContactDataBuilder()
              .nameId(id)
              .firstname(colVals.get(2).getText())
              .lastname(colVals.get(1).getText())
              .build());
    }
    return contacts;
  }

  public void contactCreation(ContactData contactData) {
    navigationHelper.addNewContact();
    fillNamesForms(contactData);
    navigationHelper.addPhoto(contactData);
    fillCompanyForms(contactData);
    fillPhonesForms(contactData);
    fillEmailsForms(contactData);
    navigationHelper.fillHomepage(contactData);
    fillBirthday(contactData.getBirthday());
    fillAnyversary(contactData.getAnniversary());
    if (groupHelper.checkGroups()) {
      String i = wd.findElement(By.name("new_group")).getText();
      if (i.contains("Test 1")) {
        groupHelper.chooseGroup(contactData);
      }
    }
    fillSecondaryAddress(contactData);
    fillSecondaryPhone(contactData);
    fillNotes(contactData);
    navigationHelper.submitNewContact();
    navigationHelper.goToHomepage();
  }
}





