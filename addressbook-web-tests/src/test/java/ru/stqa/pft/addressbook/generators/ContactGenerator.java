package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactGenerator {
    @Parameter(names = "-c", description = "Contacts count")
    public int count;
    @Parameter(names = "-f", description = "Target File")
    public String file;
    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
        ContactGenerator contactGenerator = new ContactGenerator();
        JCommander jCommander = new JCommander(contactGenerator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        contactGenerator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format");
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
       try (Writer writer = new FileWriter(file)){
           writer.write(json);
       }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactDataBuilder()
                    .firstname(String.format("Flry %s", i))
                    .middleName(String.format("Boomer %s", i))
                    .lastname(String.format("Popper %s", i))
                    .nickname(String.format("Boldi %s", i))
                    .photoDirectory("src/test/java/ru/stqa/pft/addressbook/resources/Bolduin.jpg")
                    .title(String.format("Boldo-Voldo %s", i))
                    .company(String.format("Fox %s", i))
                    .companyAddress(String.format("Usa, bryton beach 48 %s", i))
                    .homePhone(String.format("+78954523%s", i))
                    .fax(String.format("None%s", i))
                    .mobilePhone(String.format("+735645645%s", i))
                    .workPhone(String.format("+2344234432%s", i))
                    .email1(String.format("boldi@jojo%s.com",i))
                    .email2(String.format("holo@gmai%s.com",i))
                    .email3(String.format("gop@jojo%s.com",i))
                    .homepage(String.format("yandex%s.com",i))
//                    .birthday(LocalDate.of(1991, 5, 13))
//                    .anniversary(LocalDate.of(1889, 6, 12))
                   // .group(String.format("Test 1"))
//                    .creation(true)
                    .secondaryAdress(String.format("Usa, Briton beach %s",i))
                    // .secondaryPhone("48")
                    .notes(String.format("Best friend%s",i))
                    .build());
        }
        return contacts;
    }
}
