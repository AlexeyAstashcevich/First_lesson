package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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
    save(groups,new File(file));
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

  private  void save(List<GroupData> groups, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (GroupData group : groups) {
      writer.write(String.format("%s;%s:%s\n", group.getName(), group.getHeader(), group.getFooter()));
    }
    writer.close();
  }
}
