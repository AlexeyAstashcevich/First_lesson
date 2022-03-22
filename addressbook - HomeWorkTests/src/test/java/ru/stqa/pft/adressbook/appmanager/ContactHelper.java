package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.*;

public class ContactHelper {
    private WebDriver wd;

    public ContactHelper(WebDriver wd) {

        this.wd = wd;
    }

    public void fillSecondaryAddress(SecondaryAddressData secondaryAddressData) {
        wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).click();
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(secondaryAddressData.getSecondaryAdress());
    }

    public void fillCompanyForms(CompanysData companysData) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(companysData.getTitle());
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(companysData.getCompany());
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(companysData.getCompanyAdress());
    }
    public void fillAnyversary(AnyversaryData anyversaryData) {
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

    public void fillBirthday(BirthdayData birthdayData) {
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

    public void fillEmailsForms(EmailsData emailsData) {
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

    public void fillNamesForms(NamesData namesData) {
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

    public void fillNotes(NotesData notesData) {
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(notesData.getNotes());
    }

    public void fillSecondaryPhone(SecondaryPhoneData secondaryPhoneData) {
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(secondaryPhoneData.getSecondaryPhone());
    }

    public void fillPhonesForms(PhonesData phonesData) {
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
}





