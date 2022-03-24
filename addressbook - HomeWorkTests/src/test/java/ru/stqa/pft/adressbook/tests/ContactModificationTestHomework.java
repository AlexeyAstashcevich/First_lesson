package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.appmanager.TestBaseHomework;
import ru.stqa.pft.adressbook.model.*;

public class ContactModificationTestHomework extends TestBaseHomework {
  @Test
  public void contactModification(){
    app.getNavigationHelper().initContactModification();
    app.getContactHelper().fillNamesForms(new ContactDataBuilderHomeWork()
            .firstname("Alex")
            .middleName("Bolduin")
            .lastname("Bolduin")
            .nickname("Boldi")
            .builder());
    app.getNavigationHelper().addPhoto(new ContactDataBuilderHomeWork()
            .photoDirectory("C:\\Bolduin.jpg")
            .builder());
    app.getContactHelper().fillCompanyForms(new ContactDataBuilderHomeWork()
            .title("Boldo-Voldo")
            .company("Fox")
            .companyAddress("Usa, bryton beach 48")
            .builder());
    app.getContactHelper().fillPhonesForms(new ContactDataBuilderHomeWork()
            .homePhone("+78954523")
            .fax("None")
            .mobilePhone("+735645645")
            .workPhone("+2344234432")
            .builder());
    app.getContactHelper().fillEmailsForms(new ContactDataBuilderHomeWork()
            .email1("boldi@jojo.com")
            .email2("holo@gmail.com")
            .email3("gop@jojo.com")
            .builder());
    app.getNavigationHelper().fillHomepage(new ContactDataBuilderHomeWork()
            .homepage("yandex.ru")
            .builder());
    app.getContactHelper().fillBirthday(new ContactDataBuilderHomeWork()
            .day("15")
            .month("August")
            .year("1989")
            .builder());
    app.getContactHelper().fillAnyversary(new ContactDataBuilderHomeWork()
            .day("17")
            .month("August")
            .year("1989")
            .builder());
    app.getGroupHelper().chooseGroup(new ContactDataBuilderHomeWork()
            .group("Test1")
            .builder());
    app.getContactHelper().fillSecondaryAddress(new ContactDataBuilderHomeWork()
            .secondaryAdress("Usa, Briton beach")
            .builder());
    app.getContactHelper().fillSecondaryPhone(new ContactDataBuilderHomeWork()
            .secondaryPhone("48")
            .builder());
    app.getContactHelper().fillNotes(new ContactDataBuilderHomeWork()
            .notes("Best friend")
            .builder());
    app.getNavigationHelper().updateInformation();
    app.getNavigationHelper().goToHomepage();
  }
}
