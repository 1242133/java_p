package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class СontactCreationTest extends TestBase {
  @Test
  public void testСontactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Alexey").withLastname("Orlov").withMobile(null).withEmail(null).withGroup(null);
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testBadСontactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Alexe'").withLastname("Orlov").withMobile(null).withEmail(null).withGroup(null);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size())); assertThat(after, equalTo(before));
  }
}