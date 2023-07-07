package tests;

import org.testng.annotations.Test;

public class СontactDeletionTest extends TestBase {

  @Test
  public void testСontactDeletion() {
    app.getGroupHelper().selectContact();
    app.getGroupHelper().selectDelete();
    app.getGroupHelper().confirmAction();
  }
}
