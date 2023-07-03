package homework;

import org.testng.annotations.Test;
import tests.TestBase;
public class СontactCreationTest extends TestBase {
  @Test
  public void testСontactCreation() throws Exception {
    App.getNavigationHelper().gotoContactsPage();
    App.getGroupHelper().initContactsCreation();
    App.getGroupHelper().fillContactsFrom(new ContactData("Alexey", "Orlov", "89445556767", "a123@gmail.com"));
    App.getGroupHelper().submitContactsCreation();
    App.getGroupHelper().returnToContactsPage();
  }

}