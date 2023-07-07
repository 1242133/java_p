package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getGroupHelper().initContactModification();
    app.getGroupHelper().fillContactsFrom(new ContactData("Alexey", "Or", "89445556767", "a123@gmail.com"));
    app.getGroupHelper().submitContactsModification();
    app.getGroupHelper().returnToContactsPage();
  }
}
