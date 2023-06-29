package ru.stqa.p.addressbook;

import org.testng.annotations.Test;


public class СontactCreationTest extends TestContactBase {

  @Test
  public void testСontactCreation() throws Exception {
    gotoContactsPage();
    initContactsCreation();
    fillContactsFrom(new ContactData("Alexey", "Orlov", "89445556767", "a123@gmail.com"));
    submitContactsCreation();
    returnToContactsPage();
  }

}
