package homework;

import org.testng.annotations.Test;
import tests.TestBase;
public class СontactCreationTest extends TestBase {
  @Test
  public void testСontactCreation() throws Exception {
    app.getNavigationHelper().gotoContactsPage();
    app.getGroupHelper().initContactsCreation();
    app.getGroupHelper().fillContactsFrom(new ContactData(null, "Orlov", "89445556767", "a123@gmail.com"));
    app.getGroupHelper().submitContactsCreation();
    app.getGroupHelper().returnToContactsPage();
  }

}