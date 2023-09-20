package ru.stqa.p.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.p.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;
import static ru.stqa.p.mantis.tests.TestBase.app;

public class LoginTests {

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
