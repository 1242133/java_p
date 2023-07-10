package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactsFrom(new ContactData("Alexey", "Or", "89445556767", "a123@gmail.com", null), false);
    app.getContactHelper().submitContactsModification();
    app.getContactHelper().returnToContactsPage();
  }
}
