package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {

        super(wd);
    }

    public void chooseGroup(ContactData groupData) {
        if (groupData.isCreation()) {
            click(By.name("new_group"));
            select(By.name("new_group"), groupData.getGroup());
            click(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
        }else {
            Assert.assertFalse(isElemrntPresent(By.name("new group")));
        }
    }

    public void submitGroupCreation () {
            click(By.name("submit"));
        }

        public void fillGroupCreation (GroupData groupData){
            type(groupData.getName(), By.name("group_name"));
            type(groupData.getHeader(), By.name("group_header"));
            type(groupData.getFooter(), By.name("group_footer"));
        }

        public void initGroupCreation () {
            click(By.name("new"));
        }

        public void deleteSelectedGroups () {
            click(By.xpath("//div[@id='content']/form/input[5]"));
        }

        public void selectGroup () {
            click(By.name("selected[]"));
        }

        public void goToGroup () {
            click(By.linkText("group page"));
        }

        public void initGroupModification () {
            click(By.name("edit"));
        }

        public void submitGroupModification () {
            click(By.name("update"));
        }

  public void creationGroup(GroupData group) {
      initGroupCreation();
      fillGroupCreation(group);
      submitGroupCreation();
      goToGroup();
  }

    public boolean isThereAGroup() {
        return isElemrntPresent(By.name("selected[]"));
    }
}

