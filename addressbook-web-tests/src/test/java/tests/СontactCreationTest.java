package tests;

import model.ContactData;
import org.testng.annotations.Test;
public class СontactCreationTest extends TestBase {
  @Test
  public void testСontactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactsCreation();
    app.getContactHelper().fillContactsFrom(new ContactData("Al", "Orlov", "89445556767", "a123@gmail.com", "test1"), true);
    app.getContactHelper().submitContactsCreation();
    app.getContactHelper().returnToContactsPage();
  }

}