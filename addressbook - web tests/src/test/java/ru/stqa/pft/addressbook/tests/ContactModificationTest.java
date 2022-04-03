package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;


public class ContactModificationTest extends TestBase {

  @Test
  public void contactModification(){
    if (! app.getNavigationHelper().isThereAContact()){
      app.getContactHelper().getCreationContact();
    }
    app.getNavigationHelper().initContactModification();
    app.getContactHelper().fillNamesForms(new ContactDataBuilder()
            .firstname("Alex")
            .middleName("Bolduin")
            .lastname("Bolduin")
            .nickname("Boldi")
            .build());
    app.getNavigationHelper().addPhoto(new ContactDataBuilder()
            .photoDirectory("resources/Bolduin.jpg")
            .build());
    app.getContactHelper().fillCompanyForms(new ContactDataBuilder()
            .title("Boldo-Voldo")
            .company("Fox")
            .companyAddress("Usa, bryton beach 48")
            .build());
    app.getContactHelper().fillPhonesForms(new ContactDataBuilder()
            .homePhone("+78954523")
            .fax("None")
            .mobilePhone("+735645645")
            .workPhone("+2344234432")
            .build());
    app.getContactHelper().fillEmailsForms(new ContactDataBuilder()
            .email1("boldi@jojo.com")
            .email2("holo@gmail.com")
            .email3("gop@jojo.com")
            .build());
    app.getNavigationHelper().fillHomepage(new ContactDataBuilder()
            .homepage("yandex.ru")
            .build());
    app.getContactHelper().fillBirthday(new ContactDataBuilder()
            .day("15")
            .month("August")
            .year("1989")
            .build());
    app.getContactHelper().fillAnyversary(new ContactDataBuilder()
            .day("17")
            .month("August")
            .year("1989")
            .build());
    if(app.getGroupHelper().checkGroups()){
    app.getGroupHelper().chooseGroup(new ContactDataBuilder()
            .group("Test 1")
            .creation(false)
            .build());}
    app.getContactHelper().fillSecondaryAddress(new ContactDataBuilder()
            .secondaryAdress("Usa, Briton beach")
            .build());
    app.getContactHelper().fillSecondaryPhone(new ContactDataBuilder()
            .secondaryPhone("48")
            .build());
    app.getContactHelper().fillNotes(new ContactDataBuilder()
            .notes("Best friend")
            .build());
    app.getNavigationHelper().updateInformation();
    app.getNavigationHelper().goToHomepage();
  }
}
