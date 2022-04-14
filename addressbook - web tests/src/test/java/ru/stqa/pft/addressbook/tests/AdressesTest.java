package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AdressesTest extends TestBase{
  @Test

  public void  adressesTest(){
    app.goTo().goHomeHeadear();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromEditorForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditorForm)));
    assertThat(contact.getAllAddress(),equalTo(contactDataFromEditorForm));
  }


    public String mergeEmails(ContactData contact) {
      return Arrays.asList(contact.getEmail1(),contact.getEmail2(),contact.getEmail3())
              .stream()
              .filter((s -> ! s.equals("")))
              .map(ContactPhoneTest::cleaned)
              .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
      return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
