package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd)  {

        super(wd);
    }

    public void fillSecondaryAddress(ContactData secondaryAddressData) {
        type(secondaryAddressData.getSecondaryAdress(),By.name("address2"));
    }

    public void fillCompanyForms(ContactData contactData) {
        type(contactData.getTitle(),By.name("title"));
        type(contactData.getCompany(),By.name("company"));
        type(contactData.getCompanyAddress(),By.name("address"));
    }
    public void fillAnyversary(ContactData datesData) {
        click(By.name("aday"));
        select(By.name("aday"), datesData.getDay());
        click(By.xpath("//div[@id='content']/form/select[3]/option[19]"));
        click(By.name("amonth"));
        select(By.name("amonth"), datesData.getMonth());
        click(By.xpath("//div[@id='content']/form/select[4]/option[12]"));
        type(datesData.getYear(),By.name("ayear"));
    }

    public void fillBirthday(ContactData birthdayData) {
        click(By.name("bday"));
        select(By.name("bday"), birthdayData.getDay());
        click(By.xpath("//option[@value='15']"));
        click(By.name("bmonth"));
        select(By.name("bmonth"), birthdayData.getMonth());
        click(By.xpath("//option[@value='August']"));
        type(birthdayData.getYear(),By.name("byear"));
    }

    public void fillEmailsForms(ContactData emailsData) {
        type(emailsData.getEmail1(),By.name("email"));
        type(emailsData.getEmail2(),By.name("email2"));
        type(emailsData.getEmail3(),By.name("email3"));
    }

    public void fillNamesForms(ContactData namesData) {
        type(namesData.getFirstname(),By.name("firstname"));
        type(namesData.getMiddleName(),By.name("middlename"));
        type(namesData.getLastname(),By.name("lastname"));
        type(namesData.getNickname(),By.name("nickname"));
    }

    public void fillNotes(ContactData notesData) {
        type(notesData.getNotes(),By.name("notes"));
    }

    public void fillSecondaryPhone(ContactData secondaryPhoneData) {
        type(secondaryPhoneData.getSecondaryPhone(),By.name("phone2"));
    }

    public void fillPhonesForms(ContactData phonesData) {
        type(phonesData.getHomePhone(),By.name("home"));
        type(phonesData.getMobilePhone(),By.name("mobile"));
        type(phonesData.getWorkPhone(),By.name("work"));
        type(phonesData.getFax(),By.name("fax"));
    }
}





