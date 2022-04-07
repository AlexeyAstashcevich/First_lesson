package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  public void chooseGroup(ContactData groupData) {
    if (groupData.isCreation()) {
      click(By.name("new_group"));
      select(By.name("new_group"), groupData.getGroup());
      click(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
    } else {
      Assert.assertFalse(isElemrntPresent(By.name("new group")));
    }
  }


  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    goToGroup();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupCreation(group);
    submitGroupModification();
    goToGroup();
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
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void goToGroup() {
    click(By.linkText("group page"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupCreation(group);
    submitGroupCreation();
    goToGroup();
  }

  public boolean isThereAGroup() {
    return isElemrntPresent(By.name("selected[]"));
  }


  public Set<GroupData> all() {
    Set<GroupData> groups = new HashSet<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupDataBuilder().withId(id).withName(name).build());
    }

    return groups;
  }


}

