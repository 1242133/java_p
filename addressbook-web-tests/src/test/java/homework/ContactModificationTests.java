package homework;

import org.testng.annotations.Test;
import tests.TestBase;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getGroupHelper().selectContactModification();
    app.getGroupHelper().fillContactsFrom(new ContactData("Alexey", "Orlov", "89445556767", "a123@gmail.com"));
    app.getGroupHelper().submitContactsCreation();
    app.getGroupHelper().returnToContactsPage();
  }
}
