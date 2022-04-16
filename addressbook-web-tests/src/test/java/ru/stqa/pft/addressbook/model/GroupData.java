package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {


  private String name;
  private String header;
  private String footer;
  private int id;


  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public String getName() {
    return name;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public String getHeader() {
    return header;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public String getFooter() {
    return footer;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

}