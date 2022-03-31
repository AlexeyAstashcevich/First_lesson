package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;

public class NewContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation(){
    NewContactCreation(app);
  }

  public void NewContactCreation(ApplicationManager app) {
    app.getNavigationHelper().addNewContact();
    app.getContactHelper().fillNamesForms(new ContactDataBuilder()
            .firstname("Alex")
            .middleName("Bolduin")
            .lastname("Bolduin")
            .nickname("Boldi")
            .builder());
    app.getNavigationHelper().addPhoto(new ContactDataBuilder()
         .photoDirectory("addressbook - web tests/resources/Bolduin.jpg")
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

  }

}
