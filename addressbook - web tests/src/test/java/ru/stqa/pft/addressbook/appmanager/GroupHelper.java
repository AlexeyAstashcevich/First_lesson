package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {

        super(wd);
    }

    public void chooseGroup(ContactData groupData) {
        click(By.name("new_group"));
        select(By.name("new_group"), groupData.getGroup());
        click(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupCreation(GroupData groupData) {
        type(groupData.getName(), By.name("group_name"));
        type(groupData.getHeader(), By.name("group_header"));
        type(groupData.getFooter(), By.name("group_footer"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroup() {
        click(By.xpath("/html/body/div/div[4]/form/span[3]/input"));
    }

    public void goToGroup() {
        click(By.linkText("group page"));
    }

    public void initGroupModification() {
        click(By.linkText("edit"));
    }

    public void submitGroupModification() {
        click(By.linkText("update"));
    }
}

