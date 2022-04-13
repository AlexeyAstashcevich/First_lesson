package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeleteContactTest extends TestBase {


    @Test
    public void deleteContact() {
        if (!app.goTo().isThereAContact()) {
            app.contact().contactCreation(contactInfo);
        }
        Contacts before = app.contact().all();
        int id = before.stream().mapToInt(ContactData::getNameId).max().getAsInt();
        app.contact().deleteContact(id);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(before.stream().filter(x -> x.getNameId() == id).findAny().get())));
    }
}
