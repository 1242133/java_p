package homework;

import org.testng.annotations.Test;
import tests.TestBase;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getGroupHelper().selectContactModification();
    app.getGroupHelper().fillContacts(new ModContactData("Alexey", null, "89445556767", null));
    app.getGroupHelper().submitContactsCreation();
    app.getGroupHelper().returnToContactsPage();
  }
}
