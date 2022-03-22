package ru.stqa.pft.adressbook.model;

public class CompanysData {
  private final String title;
  private final String company;
  private final String companyAdress;

  public CompanysData(String title, String company, String companyAdress) {
    this.title = title;
    this.company = company;
    this.companyAdress = companyAdress;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getCompanyAdress() {
    return companyAdress;
  }
}
