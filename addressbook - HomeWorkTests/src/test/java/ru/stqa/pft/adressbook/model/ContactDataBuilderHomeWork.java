package ru.stqa.pft.adressbook.model;

public class ContactDataBuilderHomeWork {

  private ContactDataHomeWork contactDataHomeWork = new ContactDataHomeWork();

  public ContactDataBuilderHomeWork title(String title) {
    contactDataHomeWork.setTitle(title);
    return this;
  }

  public ContactDataBuilderHomeWork company(String company) {
    contactDataHomeWork.setCompany(company);
    return this;
  }

  public ContactDataBuilderHomeWork companyAddress(String companyAddress) {
    contactDataHomeWork.setCompanyAddress(companyAddress);
    return this;
  }

  public ContactDataBuilderHomeWork email1(String email1) {
    contactDataHomeWork.setEmail1(email1);
    return this;
  }

  public ContactDataBuilderHomeWork email2(String email2) {
    contactDataHomeWork.setEmail2(email2);
    return this;
  }

  public ContactDataBuilderHomeWork email3(String email3) {
    contactDataHomeWork.setEmail3(email3);
    return this;

  }
  public ContactDataBuilderHomeWork firstname(String firstname) {
    contactDataHomeWork.setFirstname(firstname);
    return this;
  }

  public ContactDataBuilderHomeWork middleName(String middleName) {
    contactDataHomeWork.setMiddleName(middleName);
    return this;
  }

  public ContactDataBuilderHomeWork lastname(String lastname) {
    contactDataHomeWork.setLastname(lastname);
    return this;
  }

  public ContactDataBuilderHomeWork nickname(String nickname) {
    contactDataHomeWork.setNickname(nickname);
    return this;
  }

  public ContactDataBuilderHomeWork notes(String notes) {
    contactDataHomeWork.setNotes(notes);
    return this;
  }

  public ContactDataBuilderHomeWork homePhone(String homePhone) {
    contactDataHomeWork.setHomePhone(homePhone);
    return this;
  }

  public ContactDataBuilderHomeWork mobilePhone(String mobilePhone) {
    contactDataHomeWork.setMobilePhone(mobilePhone);
    return this;
  }

  public ContactDataBuilderHomeWork workPhone(String workPhone) {
    contactDataHomeWork.setWorkPhone(workPhone);
    return this;
  }

  public ContactDataBuilderHomeWork fax(String fax) {
    contactDataHomeWork.setFax(fax);
    return this;
  }


  public ContactDataBuilderHomeWork secondaryAdress(String secondaryAdress) {
    contactDataHomeWork.setSecondaryAdress(secondaryAdress);
    return this;
  }

  public ContactDataBuilderHomeWork secondaryPhone(String secondaryPhone) {
    contactDataHomeWork.setSecondaryPhone(secondaryPhone);
    return this;
  }

  public ContactDataBuilderHomeWork photoDirectory(String photoDirectory) {
    contactDataHomeWork.setPhotoDirectory(photoDirectory);
    return this;
  }

  public ContactDataBuilderHomeWork day(String day) {
    contactDataHomeWork.setDay(day);
    return this;
  }

  public ContactDataBuilderHomeWork month(String month) {
    contactDataHomeWork.setMonth(month);
    return this;
  }

  public ContactDataBuilderHomeWork year(String year) {
    contactDataHomeWork.setYear(year);
    return this;
  }

  public ContactDataBuilderHomeWork group(String group) {
    contactDataHomeWork.setGroup(group);
    return this;
  }

  public ContactDataBuilderHomeWork homepage(String homepage) {
    contactDataHomeWork.setHomepage(homepage);
    return this;
  }



  public ContactDataHomeWork builder() {
    return contactDataHomeWork;
  }
}