package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.HomepageData;
import ru.stqa.pft.adressbook.model.PhotoData;

public class NavigationHelper extends HelpBase {

    public NavigationHelper(WebDriver wd) {

       super(wd);
    }
    public void goToHomepage() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
        click(By.linkText("home page"));
    }
    public void fillHomepage(HomepageData homepageData) {
        type(homepageData.getHomepage(), By.name("homepage"));
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void addPhoto(PhotoData photoData) {
        type(photoData.getPhotoDirectory(),By.name("photo"));
    }
}
