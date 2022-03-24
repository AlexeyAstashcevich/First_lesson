package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.ContactData;

public class NavigationHelper extends HelpBase {

    public NavigationHelper(WebDriver wd) {

       super(wd);
    }
    public void submitNewContact(){
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void goToHomepage() {
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
    public void getPhoto(){
        wd.findElement(By.name("photo")).sendKeys("C:\\Bolduin.jpg");
    }

    public void updateInformation() {
        click(By.name("update"));
    }
}
