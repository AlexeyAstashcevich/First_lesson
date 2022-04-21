package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {
  @Column(name = "title")
  private String title;
  @Column(name = "company")
  private String company;
  @Column(name = "address")
  @Type(type = "text")
  private String companyAddress;
  @Column(name = "email")
  @Type(type = "text")
  private String email1;
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  @Expose
  @Column(name = "firstname")
  private String firstname;
  @Expose
  @Column(name = "middleName")
  private String middleName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return creation == that.creation && nameId == that.nameId && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(companyAddress, that.companyAddress) && Objects.equals(email1, that.email1) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(firstname, that.firstname) && Objects.equals(middleName, that.middleName) && Objects.equals(lastname, that.lastname) && Objects.equals(nickname, that.nickname) && Objects.equals(notes, that.notes) && Objects.equals(homePhone, that.homePhone) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(fax, that.fax) && Objects.equals(secondaryAdress, that.secondaryAdress) && Objects.equals(secondaryPhone, that.secondaryPhone) && Objects.equals(photo, that.photo) && Objects.equals(homepage, that.homepage) && Objects.equals(anniversary, that.anniversary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, company, companyAddress, email1, email2, email3, firstname, middleName, lastname, nickname, notes, homePhone, mobilePhone, workPhone, fax, secondaryAdress, secondaryPhone, photo, homepage, creation, nameId, anniversary);
  }

  @Expose
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "nickname")
  private String nickname;
  @Column(name = "notes")
  @Type(type = "text")
  private String notes;
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Column(name = "fax")
  @Type(type = "text")
  private String fax;
  @Column(name = "address2")
  @Type(type = "text")
  private String secondaryAdress;
  @Type(type = "text")
  @Column(name = "phone2")
  private String secondaryPhone;
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;
  @Transient
  private String group;
  @Column(name = "homepage")
  @Type(type = "text")
  private String homepage;
  @Transient
  private boolean creation;
  @Id
  @Column(name = "id")
  private int nameId;
  @Transient
  private LocalDate anniversary;
  @Transient
  private LocalDate birthday;
  @Transient
  private String allPhones;
  @Transient
  private String allEmails;
  @Transient
  private String allAddress;

  public String getAddress() {
    return allAddress;
  }

  public void setAllAddress(String allAddress) {
    this.allAddress = allAddress;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public void setAllEmails(String allEmails) {
    this.allEmails = allEmails;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public void setAllPhones(String allPhones) {
    this.allPhones = allPhones;
  }

  public int getNameId() {
    return nameId;
  }

  public void setNameId(int nameId) {
    this.nameId = nameId;
  }

  public boolean isCreation() {
    return creation;
  }

  public void setCreation(boolean creation) {
    this.creation = creation;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getSecondaryPhone() {
    return secondaryPhone;
  }

  public void setSecondaryPhone(String secondaryPhone) {
    this.secondaryPhone = secondaryPhone;
  }

  public String getSecondaryAdress() {
    return secondaryAdress;
  }

  public void setSecondaryAdress(String secondaryAdress) {
    this.secondaryAdress = secondaryAdress;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
  }

  public String getEmail1() {
    return email1;
  }

  public void setEmail1(String email1) {
    this.email1 = email1;
  }

  public String getEmail2() {
    return email2;
  }

  public void setEmail2(String email2) {
    this.email2 = email2;
  }

  public String getEmail3() {
    return email3;
  }

  public void setEmail3(String email3) {
    this.email3 = email3;
  }

  public LocalDate getAnniversary() {
    return anniversary;
  }

  public void setAnniversary(LocalDate anniversary) {
    this.anniversary = anniversary;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nameId=" + nameId +
            '}';
  }

}
