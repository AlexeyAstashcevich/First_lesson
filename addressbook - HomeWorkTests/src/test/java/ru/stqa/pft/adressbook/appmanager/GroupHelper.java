package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.ContactData;

public class GroupHelper extends HelpBase {

    public GroupHelper(WebDriver wd) {

        super(wd);
    }
    public void chooseGroup(ContactData groupData) {
      click(By.name("new_group"));
      select(By.name("new_group"),groupData.getGroup());
      click(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
    }
}
