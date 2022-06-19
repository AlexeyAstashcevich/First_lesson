package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {

    super(wd);
  }

  public void submitNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void goToHomepage() {
    if (isElemrntPresent(By.id("maintable"))) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return;
    }
    click(By.linkText("home"));
  }

  public void goHomeHeadear(){
    click(By.cssSelector("html body div#container div#nav ul li a"));
  }

  public void fillHomepage(ContactData homepageData) {
    type(homepageData.getHomepage(), By.name("homepage"));
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void addPhoto(ContactData photoData) {
    insertPhoto(photoData.getPhoto());
  }

  public void chooseContactById(int id){
    click(By.id(String.valueOf(id)));
  }

  public void deleteContact() {
    click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
  }

  public void submitDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int id) {

    click(By.cssSelector("a[href='edit.php?id="+ id + "'] > img[src='icons/pencil.png']"));
  }
  public void updateInformation() {
    click(By.name("update"));
  }

  public void group() {
    if (!isElemrntPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElemrntPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void goHome() {
    click(By.id("logo"));
  }

  public boolean isThereAContact() {
    return isElemrntPresent(By.name("selected[]"));
  }

  public void addToGroup(String group) {
    click(By.name("to_group"));
    select(By.name("to_group"), group);
    click(By.name("add"));
  }

  public void chooseGroupForContacts(String group) {
    click(By.name("group"));
    select(By.name("group"), group);
   // new Select(wd.findElement(By.name("group"))).selectByVisibleText("Test 0");
  }

  public void remooveFromGroup() {
    click(By.name("remove"));
  }
}
