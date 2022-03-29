package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;



public class NavigationHelper extends HelperBase {
    ContactHelper contactHelper = new ContactHelper(wd);
    GroupHelper groupHelper = new GroupHelper(wd);

    public NavigationHelper(WebDriver wd) {

        super(wd);
    }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void goToHomepage() {
        if (isElemrntPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home page"));
    }

    public void fillHomepage(ContactData homepageData) {
        type(homepageData.getHomepage(), By.name("homepage"));
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void addPhoto(ContactData photoData) {
        insertPhoto(photoData.getPhotoDirectory());
    }

    public void chooseContact() {
        click(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
    }

    public void submitDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
    }

    public void updateInformation() {
        click(By.name("update"));
    }

    public void goToGroupPage() {
        if (!isElemrntPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElemrntPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void creationContact() {

        addNewContact();
        contactHelper.fillNamesForms(new ContactDataBuilder()
                .firstname("Alex")
                .middleName("Bolduin")
                .lastname("Bolduin")
                .nickname("Boldi")
                .builder());
        addPhoto(new ContactDataBuilder()
                .photoDirectory("C:\\Bolduin.jpg")
                .builder());
        contactHelper.fillCompanyForms(new ContactDataBuilder()
                .title("Boldo-Voldo")
                .company("Fox")
                .companyAddress("Usa, bryton beach 48")
                .builder());
        contactHelper.fillPhonesForms(new ContactDataBuilder()
                .homePhone("+78954523")
                .fax("None")
                .mobilePhone("+735645645")
                .workPhone("+2344234432")
                .builder());
        contactHelper.fillEmailsForms(new ContactDataBuilder()
                .email1("boldi@jojo.com")
                .email2("holo@gmail.com")
                .email3("gop@jojo.com")
                .builder());
        fillHomepage(new ContactDataBuilder()
                .homepage("yandex.ru")
                .builder());
        contactHelper.fillBirthday(new ContactDataBuilder()
                .day("15")
                .month("August")
                .year("1989")
                .builder());
        contactHelper.fillAnyversary(new ContactDataBuilder()
                .day("17")
                .month("August")
                .year("1989")
                .builder());
        if (isElemrntPresent(By.xpath("/html/body/div/div[4]/form/select[5]/option[2]"))){
       groupHelper.chooseGroup(new ContactDataBuilder()
             .group("Test 1")
             .creation(true)
             .builder());}
        contactHelper.fillSecondaryAddress(new ContactDataBuilder()
                .secondaryAdress("Usa, Briton beach")
                .builder());
        contactHelper.fillSecondaryPhone(new ContactDataBuilder()
                .secondaryPhone("48")
                .builder());
        contactHelper.fillNotes(new ContactDataBuilder()
                .notes("Best friend")
                .builder());
        submitNewContact();
        goToHomepage();

    }

    public boolean isThereAContact() {
        return isElemrntPresent(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
    }
}
