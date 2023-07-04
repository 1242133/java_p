package homework;

import org.testng.annotations.Test;
import tests.TestBase;

public class СontactDeletionTest extends TestBase {

  @Test
  public void testСontactDeletion() {
    app.getGroupHelper().selectContact();
    app.getGroupHelper().selectDelete();
    app.getGroupHelper().confirmAction();
  }
}
