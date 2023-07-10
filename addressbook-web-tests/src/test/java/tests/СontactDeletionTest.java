package tests;

import org.testng.annotations.Test;

public class СontactDeletionTest extends TestBase {

  @Test
  public void testСontactDeletion() {
    app.getContactHelper().selectContact();
    app.getContactHelper().selectDelete();
    app.getContactHelper().confirmAction();
  }
}
