package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewContactCreationTest extends TestBase {


    @Test
    public void contactCreating() {
        Contacts before = app.contact().all();
        app.contact().contactCreation(contactInfo);
        assertThat(app.group().count(),equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(after.stream().sorted(Comparator.comparing(ContactData::getNameId).reversed()).findFirst().get())));
    }
}
