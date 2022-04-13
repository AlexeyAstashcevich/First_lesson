package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTest extends TestBase {


    @Test
    public void contactModification() {
        if (!app.goTo().isThereAContact()) {
            app.getContactHelper().contactCreation(contactInfo);
        }
        Contacts before = app.getContactHelper().getContactList();
        int id = before.stream().mapToInt((g) -> g.getNameId()).max().getAsInt();
        modificatedInfo.setNameId(id);
        app.getContactHelper().contactModification(modificatedInfo);
        Contacts after = app.getContactHelper().getContactList();
        assertThat(after, equalTo(before.without(before.stream().filter(x -> x.getNameId() == id).findAny().get())
                .withAdded(after.stream().filter(x -> x.getNameId() == id).findAny().get())));
    }
}
