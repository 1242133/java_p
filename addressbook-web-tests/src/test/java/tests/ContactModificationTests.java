package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Al", "Orlov", "89445556767", "a123@gmail.com", "test1"), true);
    }
    app.getContactHelper().initContactModification(before - 1);
    app.getContactHelper().fillContactsFrom(new ContactData("Alexey", "Or", "89", "a123@gmail.com", null), false);
    app.getContactHelper().submitContactsModification();
    app.getContactHelper().returnToContactsPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
