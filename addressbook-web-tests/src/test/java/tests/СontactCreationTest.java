package tests;

import model.ContactData;
import org.testng.annotations.Test;
public class СontactCreationTest extends TestBase {
  @Test
  public void testСontactCreation() throws Exception {
    app.getNavigationHelper().gotoContactsPage();
    app.getGroupHelper().initContactsCreation();
    app.getGroupHelper().fillContactsFrom(new ContactData("Al", "Orlov", "89445556767", "a123@gmail.com"));
    app.getGroupHelper().submitContactsCreation();
    app.getGroupHelper().returnToContactsPage();
  }

}