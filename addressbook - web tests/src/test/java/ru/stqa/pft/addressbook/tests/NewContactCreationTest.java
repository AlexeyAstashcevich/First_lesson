package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;

import java.util.HashSet;
import java.util.List;

public class NewContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation(){
    contactCreation(app);
  }

  public void contactCreation(ApplicationManager app) {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().addNewContact();
    ContactData contact = new ContactDataBuilder().firstname("Alex")
            .middleName("Bolduin")
            .lastname("Bolduin")
            .nickname("Boldi")
            .builder();
    app.getContactHelper().fillNamesForms(contact);
    app.getNavigationHelper().addPhoto(new ContactDataBuilder()
         .photoDirectory("resources/Bolduin.jpg")
         .builder());
    app.getContactHelper().fillCompanyForms(new ContactDataBuilder()
            .title("Boldo-Voldo")
            .company("Fox")
            .companyAddress("Usa, bryton beach 48")
            .builder());
    app.getContactHelper().fillPhonesForms(new ContactDataBuilder()
            .homePhone("+78954523")
            .fax("None")
            .mobilePhone("+735645645")
            .workPhone("+2344234432")
            .builder());
    app.getContactHelper().fillEmailsForms(new ContactDataBuilder()
            .email1("boldi@jojo.com")
            .email2("holo@gmail.com")
            .email3("gop@jojo.com")
            .builder());
    app.getNavigationHelper().fillHomepage(new ContactDataBuilder()
            .homepage("yandex.ru")
            .builder());
    app.getContactHelper().fillBirthday(new ContactDataBuilder()
            .day("15")
            .month("August")
            .year("1989")
            .builder());
    app.getContactHelper().fillAnyversary(new ContactDataBuilder()
            .day("17")
            .month("August")
            .year("1989")
            .builder());
    if(app.getGroupHelper().checkGroups()){
    app.getGroupHelper().chooseGroup(new ContactDataBuilder()
            .group("Test 1")
            .creation(true)
            .builder());}
    app.getContactHelper().fillSecondaryAddress(new ContactDataBuilder()
            .secondaryAdress("Usa, Briton beach")
            .builder());
    app.getContactHelper().fillSecondaryPhone(new ContactDataBuilder()
            .secondaryPhone("48")
            .builder());
    app.getContactHelper().fillNotes(new ContactDataBuilder()
            .notes("Best friend")
            .builder());
    app.getNavigationHelper().submitNewContact();
    app.getNavigationHelper().goToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    int max = after.stream().max((o1, o2) -> Integer.compare(o1.getNameId(),o2.getNameId())).get().getNameId();
    after.get(after.size()-1).setNameId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

  }

}
