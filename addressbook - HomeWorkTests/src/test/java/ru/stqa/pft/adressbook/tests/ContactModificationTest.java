package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.appmanager.TestBase;
import ru.stqa.pft.adressbook.model.*;

public class ContactModificationTest extends TestBase {
  @Test
  public void contactModification(){
    app.getNavigationHelper().initContactModification();
    app.getContactHelper().fillNamesForms(new NamesData("Alex", "Bolduin", "Bolduin", "Boldi"));
    //app.getNavigationHelper().addPhoto(new PhotoData("C:\\Users\\Kakaperduk\\Downloads\\Bolduin.jpg"));
    app.getContactHelper().fillCompanyForms(new CompanysData("Boldo-voldo", "Fox", "Usa, Loss Angeles , 34"));
    app.getContactHelper().fillPhonesForms(new PhonesData("+7895454", "+1875643", "Artsit", "none"));
    app.getContactHelper().fillEmailsForms(new EmailsData("boldi@gmail.com", "boldodi@yandex.com", "boldo@gaga.com"));
    app.getNavigationHelper().fillHomepage(new HomepageData("yandex.ru"));
    app.getContactHelper().fillBirthday(new BirthdayData("15", "August", "1989"));
    app.getContactHelper().fillAnyversary(new AnyversaryData("17", "November", "1990"));
    app.getContactHelper().fillSecondaryAddress(new SecondaryAddressData("Usa, Briton beach"));
    app.getContactHelper().fillSecondaryPhone(new SecondaryPhoneData("48"));
    app.getContactHelper().fillNotes(new NotesData("Best friend"));
    app.getNavigationHelper().updateInformation();
    app.getNavigationHelper().goToHomepage();
  }
}
