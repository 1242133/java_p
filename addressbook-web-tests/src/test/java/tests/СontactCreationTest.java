package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;
public class СontactCreationTest extends TestBase {
  @Test
  public void testСontactCreation() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Alexey", "Or", "89445556767", "a123@gmail.com", "test1"), true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }


}