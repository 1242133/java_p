package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class СontactDeletionTest extends TestBase {

  @Test
  public void testСontactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Al", "Orlov", "89445556767", "a123@gmail.com", "test1"), true);
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().selectDelete();
    app.getContactHelper().confirmAction();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
