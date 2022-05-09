package ru.stqa.pft.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "address_in_groups")
public class ContactInGroup {
  @Id
  @Column(name = "id")
  private int id;
  @Column(name= "group_id")
  private int groupId;

  public int getId() {
    return id;
  }

  public ContactInGroup setId(int id) {
    this.id = id;
    return this;
  }

  public int getGroupId() {
    return groupId;
  }

  public ContactInGroup setGroupId(int groupId) {
    this.groupId = groupId;
    return  this;
  }
}
