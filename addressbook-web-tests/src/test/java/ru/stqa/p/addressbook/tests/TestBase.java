package ru.stqa.p.addressbook.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.p.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", "chrome"));
  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
