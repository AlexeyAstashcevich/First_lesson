package ru.stqa.pft.adressbook.model;

public class PhonesData {
  private final String homePhone;
  private final String mobilePhone;
  private final String work;
  private final String fax;

  public PhonesData(String homePhone, String mobilePhone, String work, String fax) {
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.work = work;
    this.fax = fax;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }
}
