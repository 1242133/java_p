package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class СontactDeletionTest extends TestBase {

  @Test
  public void testСontactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Al", "Orlov", "89445556767", "a123@gmail.com", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().selectDelete();
    app.getContactHelper().confirmAction();
  }
}
