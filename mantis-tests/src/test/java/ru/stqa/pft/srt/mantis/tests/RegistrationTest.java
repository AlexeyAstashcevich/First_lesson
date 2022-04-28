package ru.stqa.pft.srt.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

  @Test
  public void registrationTest(){
    app.registration().start("user 1", "user1@localhost.domain");

  }
}
