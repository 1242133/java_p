package ru.stqa.p.addressbook;

import org.testng.annotations.Test;
import tests.TestBase;

public class СontactDeletionTest extends TestBase {

  @Test
  public void testСontactDeletionTest() {
    app.getGroupHelper().selectContact();
    app.getGroupHelper().selectDelete();
    app.getGroupHelper().confirmAction();
  }
}
