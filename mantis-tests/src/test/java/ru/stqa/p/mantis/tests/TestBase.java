package ru.stqa.p.mantis.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.p.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;


public class TestBase {
  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", "chrome"));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"),
            "config_inc.php", "config_inc.php.bak" );
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }
}

