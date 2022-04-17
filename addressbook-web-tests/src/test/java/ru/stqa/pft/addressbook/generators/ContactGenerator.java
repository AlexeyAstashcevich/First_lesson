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
      JCommander jCommander =new JCommander(contactGenerator);
      try {
        jCommander.parse(args);
      }catch (ParameterException ex){
        jCommander.usage();
        return;
      }
      contactGenerator.run();
    }

    private void run() throws IOException {
      List <ContactData> contacts = generateContacts(count);
      if(format.equals("json")) {
        saveAsJson(contacts , new File(file));
      }else {
        System.out.println("Unrecognized format");
      }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {

      Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
      String json = gson.toJson(contacts);
      Writer writer = new FileWriter(file);
      writer.write(json);
      writer.close();
    }

    private  List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        contacts.add(new ContactDataBuilder()
                .firstname(String.format("Teste %s", i))
                .middleName(String.format("%s", i))
                .lastname(String.format("%s", i))
                .build());
      }
      return contacts;
    }
  }
