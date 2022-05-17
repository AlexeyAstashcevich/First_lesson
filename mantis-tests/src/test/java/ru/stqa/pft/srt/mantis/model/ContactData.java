package ru.stqa.pft.srt.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class ContactData {

  @Id
  @Column(name = "id")
  private int Id;

  @Column(name = "username")
  private String user;

  @Column(name = "email")
  private String email;

  public String getEmail() {
    return email;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getUser() {
    return user;
  }

  public ContactData setUser(String user) {
    this.user = user;
    return this;
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

}
