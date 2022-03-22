package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.HomepageData;
import ru.stqa.pft.adressbook.model.PhotoData;

public class NavigationHelper {
    private  WebDriver wd;
    public NavigationHelper(WebDriver wd) {

        this.wd = wd;
    }
    public void goToHomepage() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        wd.findElement(By.linkText("home page")).click();
    }
    public void fillHomepage(HomepageData homepageData) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homepageData.getHomepage());
    }

    public void addNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void addPhoto(PhotoData photoData) {
        wd.findElement(By.name("photo")).clear();
        wd.findElement(By.name("photo")).sendKeys(photoData.getPhotoDirectory());
    }
}
