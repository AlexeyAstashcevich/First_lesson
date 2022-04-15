package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTest extends TestBase {
    @BeforeMethod
    public void ensurePredictions(){
        if (!app.goTo().isThereAContact()) {
            app.contact().contactCreation(contactInfo);
        }
    }

    @Test
    public void contactModification() {
        Contacts before = app.contact().all();
        int id = before.stream().mapToInt((g) -> g.getNameId()).max().getAsInt();
        modificatedInfo.setNameId(id);
        app.contact().contactModification(modificatedInfo);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(before.stream().filter(x -> x.getNameId() == id).findAny().get())
                .withAdded(after.stream().filter(x -> x.getNameId() == id).findAny().get())));
    }
}
