package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTest extends TestBase {
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

  }



  public String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream()
            .filter((s -> ! s.equals("")))
            .map(ContactPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
