package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupHelper {
    private  WebDriver wd;
    public GroupHelper(WebDriver wd) {

        this.wd = wd;
    }
    public void chooseGroup(GroupData groupData) {
      wd.findElement(By.name("new_group")).click();
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupData.getGroup());
    }
}
