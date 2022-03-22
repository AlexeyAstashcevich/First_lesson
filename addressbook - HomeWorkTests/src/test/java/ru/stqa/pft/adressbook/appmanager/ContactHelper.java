package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.*;

public class ContactHelper extends HelpBase{
    public ContactHelper(WebDriver wd)  {

        super(wd);
    }

    public void fillSecondaryAddress(SecondaryAddressData secondaryAddressData) {
        click(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
        type(secondaryAddressData.getSecondaryAdress(),By.name("address2"));
    }

    public void fillCompanyForms(CompanysData companysData) {
        type(companysData.getTitle(),By.name("title"));
        type(companysData.getCompany(),By.name("company"));
        type(companysData.getCompanyAdress(),By.name("address"));
    }
    public void fillAnyversary(AnyversaryData anyversaryData) {
        click(By.name("aday"));
        select(By.name("aday"), anyversaryData.getDay());
        click(By.xpath("//div[@id='content']/form/select[3]/option[19]"));
        click(By.name("amonth"));
        select(By.name("amonth"), anyversaryData.getMonth());
        click(By.xpath("//div[@id='content']/form/select[4]/option[12]"));
        type(anyversaryData.getYear(),By.name("ayear"));
    }

    public void fillBirthday(BirthdayData birthdayData) {
        click(By.name("bday"));
        select(By.name("bday"), birthdayData.getDay());
        click(By.xpath("//option[@value='15']"));
        click(By.name("bmonth"));
        select(By.name("bmonth"), birthdayData.getMonth());
        click(By.xpath("//option[@value='August']"));
        type(birthdayData.getYear(),By.name("byear"));
    }

    public void fillEmailsForms(EmailsData emailsData) {
        type(emailsData.getEmail1(),By.name("email"));
        type(emailsData.getEmail2(),By.name("email2"));
        type(emailsData.getEmail3(),By.name("email3"));
    }

    public void fillNamesForms(NamesData namesData) {
        type(namesData.getFirstname(),By.name("firstname"));
        type(namesData.getMiddlename(),By.name("middlename"));
        type(namesData.getLastname(),By.name("lastname"));
        type(namesData.getNickname(),By.name("nickname"));
    }

    public void fillNotes(NotesData notesData) {
        type(notesData.getNotes(),By.name("notes"));
    }

    public void fillSecondaryPhone(SecondaryPhoneData secondaryPhoneData) {
        type(secondaryPhoneData.getSecondaryPhone(),By.name("phone2"));
    }

    public void fillPhonesForms(PhonesData phonesData) {
        type(phonesData.getHomePhone(),By.name("home"));
        type(phonesData.getMobilePhone(),By.name("mobile"));
        type(phonesData.getWork(),By.name("work"));
        type(phonesData.getFax(),By.name("fax"));
    }
}





