package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupHelper extends HelpBase {

    public GroupHelper(WebDriver wd) {

        super(wd);
    }
    public void chooseGroup(GroupData groupData) {
      click(By.name("new_group"));
      select(By.name("new_group"),groupData.getGroup());
    }
}
