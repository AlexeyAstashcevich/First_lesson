package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.util.List;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  public void chooseGroup(ContactData groupData) {
    if (groupData.isCreation()) {
      click(By.name("new_group"));
      select(By.name("new_group"), String.valueOf(groupData.getGroup()));
      click(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
    } else {
      Assert.assertFalse(isElemrntPresent(By.name("new group")));
    }
  }


  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    goToGroup();
    groupCache = null;
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupCreation(group);
    submitGroupModification();
    goToGroup();
    groupCache= null;
  }


  public boolean checkGroups() {
    return isElemrntPresent(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
  }

  public boolean isThereTheGroup() {
    click(By.name("new_group"));
    return isElemrntPresent(By.xpath("//option[@value='[Test 1]']"));
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

  public void selectGroupById(int id) {
    click(By.cssSelector("input[value='" + id + "']"));
  }

  public int count(){
    return wd.findElements(By.name("selected[]")).size();
  }

  public void goToGroup() {
    click(By.linkText("groups"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    goToGroup();
    initGroupCreation();
    fillGroupCreation(group);
    submitGroupCreation();
    goToGroup();
    groupCache = null;
  }
  private Groups groupCache = null;

  public Groups all() {
    if(groupCache != null){
      return new Groups(groupCache);
    }
   groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return groupCache;
  }

  public boolean checkGroupForAdd() {
    return isElemrntPresent((By.name("group")));
  }


}

