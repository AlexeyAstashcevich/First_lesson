package ru.stqa.pft.srt.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class ContactData {

  @Column(name = "Username")
  private String user;

  public String getUser() {
    return user;
  }

  public ContactData setUser(String user) {
    this.user = user;
    return this;
  }
}
