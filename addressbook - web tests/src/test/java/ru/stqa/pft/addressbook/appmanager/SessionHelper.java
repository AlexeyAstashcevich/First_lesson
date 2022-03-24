package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        wd.get("http://localhost/addressbook/index.php");
        type(username, By.name("user"));
        type(password, (By.name("pass")));
        click(By.xpath("/html/body/div/div[4]/form/input[3]"));
    }

}
