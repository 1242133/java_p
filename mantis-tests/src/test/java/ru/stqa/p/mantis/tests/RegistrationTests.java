package ru.stqa.p.mantis.tests;

import org.testng.annotations.Test;

import static ru.stqa.p.mantis.tests.TestBase.app;

public class RegistrationTests {

  @Test
  public void testRegistration() {
    app.registration().start("user1", "user1@localhost.com.localdomain");
  }
}
