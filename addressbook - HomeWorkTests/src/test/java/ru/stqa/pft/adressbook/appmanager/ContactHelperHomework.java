package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.*;

public class ContactHelperHomework extends HelpBaseHomework {
    public ContactHelperHomework(WebDriver wd)  {

        super(wd);
    }

    public void fillSecondaryAddress(ContactDataHomeWork secondaryAddressData) {
        type(secondaryAddressData.getSecondaryAdress(),By.name("address2"));
    }

    public void fillCompanyForms(ContactDataHomeWork contactDataHomeWork) {
        type(contactDataHomeWork.getTitle(),By.name("title"));
        type(contactDataHomeWork.getCompany(),By.name("company"));
        type(contactDataHomeWork.getCompanyAddress(),By.name("address"));
    }
    public void fillAnyversary(ContactDataHomeWork datesData) {
        click(By.name("aday"));
        select(By.name("aday"), datesData.getDay());
        click(By.xpath("//div[@id='content']/form/select[3]/option[19]"));
        click(By.name("amonth"));
        select(By.name("amonth"), datesData.getMonth());
        click(By.xpath("//div[@id='content']/form/select[4]/option[12]"));
        type(datesData.getYear(),By.name("ayear"));
    }

    public void fillBirthday(ContactDataHomeWork birthdayData) {
        click(By.name("bday"));
        select(By.name("bday"), birthdayData.getDay());
        click(By.xpath("//option[@value='15']"));
        click(By.name("bmonth"));
        select(By.name("bmonth"), birthdayData.getMonth());
        click(By.xpath("//option[@value='August']"));
        type(birthdayData.getYear(),By.name("byear"));
    }

    public void fillEmailsForms(ContactDataHomeWork emailsData) {
        type(emailsData.getEmail1(),By.name("email"));
        type(emailsData.getEmail2(),By.name("email2"));
        type(emailsData.getEmail3(),By.name("email3"));
    }

    public void fillNamesForms(ContactDataHomeWork namesData) {
        type(namesData.getFirstname(),By.name("firstname"));
        type(namesData.getMiddleName(),By.name("middlename"));
        type(namesData.getLastname(),By.name("lastname"));
        type(namesData.getNickname(),By.name("nickname"));
    }

    public void fillNotes(ContactDataHomeWork notesData) {
        type(notesData.getNotes(),By.name("notes"));
    }

    public void fillSecondaryPhone(ContactDataHomeWork secondaryPhoneData) {
        type(secondaryPhoneData.getSecondaryPhone(),By.name("phone2"));
    }

    public void fillPhonesForms(ContactDataHomeWork phonesData) {
        type(phonesData.getHomePhone(),By.name("home"));
        type(phonesData.getMobilePhone(),By.name("mobile"));
        type(phonesData.getWorkPhone(),By.name("work"));
        type(phonesData.getFax(),By.name("fax"));
    }
}





