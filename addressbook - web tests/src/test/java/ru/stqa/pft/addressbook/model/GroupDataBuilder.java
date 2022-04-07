package ru.stqa.pft.addressbook.model;

public class GroupDataBuilder {
  GroupData groupData = new GroupData();

  public GroupDataBuilder withName(String withName) {
    groupData.setName(withName);
    return this;
  }

  public GroupDataBuilder withHeader(String withHeader) {
    groupData.setHeader(withHeader);
    return this;
  }

  public GroupDataBuilder withFooter(String withFooter) {
    groupData.setFooter(withFooter);
    return this;
  }

  public GroupDataBuilder withId(int withId) {
    groupData.setId(withId);
    return this;
  }

  public GroupData build() {
    return groupData;
  }

}
