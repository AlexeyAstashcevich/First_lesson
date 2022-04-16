package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactInfoTest extends TestBase {
  @BeforeMethod
  public void ensurePredictions(){
    if (!app.goTo().isThereAContact()) {
      app.contact().contactCreation(contactInfo);
    }
  }

  @Test
  public void contactPhoneTest() {
    if (!app.goTo().isThereAContact()) {
      app.contact().contactCreation(contactInfo);
    }

    app.goTo().goHomeHeadear();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromEditorForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactDataFromEditorForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditorForm)));
    assertThat(contact.getAddress(), equalTo((contactDataFromEditorForm.getCompanyAddress())));

  }



  public String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream()
            .filter((s -> ! s.equals("")))
            .map(ContactInfoTest::cleanedPhones)
            .collect(Collectors.joining("\n"));
  }

  public String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream()
            .filter((s -> ! s.equals("")))
            .map(ContactInfoTest::cleanedEmails)
            .collect(Collectors.joining("\n"));
  }


  public static String cleanedPhones(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }


  public static String cleanedEmails(String phone) {
    return phone.replaceAll("\\s", "");
  }
}
