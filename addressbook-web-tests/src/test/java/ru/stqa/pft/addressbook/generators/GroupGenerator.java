package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupGenerator {
  @Parameter(names = "-c", description = "Groups count")
  public int count;
  @Parameter(names = "-f", description = "Target File")
  public String file;
  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {
    GroupGenerator groupGenerator = new GroupGenerator();
    JCommander jCommander =new JCommander(groupGenerator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    groupGenerator.run();
  }

  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    if (format.equals("csv")) {
      saveAsCsv(groups, new File(file));
    }else if (format.equals("xml")){
      saveAsXml(groups, new File(file));
    }else if(format.equals("json")){
      saveAsJson(groups, new File(file));
      System.out.println("Unrecognized format");
    }
  }

  private void saveAsXml(List<GroupData> groups, File file) throws IOException {

    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    String xml = xstream.toXML(groups);
    Writer writer = new FileWriter(file);
    xstream.alias("group", GroupData.class);
    writer.write(xml);
    writer.close();
  }

  private void saveAsJson(List<GroupData> groups, File file) throws IOException {

    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(groups);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private  List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withName(String.format("Test %s", i))
              .withFooter(String.format("%s", i))
              .withHeader(String.format("%s", i)));
    }
    return groups;
  }

  private  void saveAsCsv(List<GroupData> groups, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (GroupData group : groups) {
      writer.write(String.format("%s;%s:%s\n", group.getName(), group.getHeader(), group.getFooter()));
    }
    writer.close();
  }
}
