package tests;

import model.ContactData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().stream().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
  }

  public static String cleaned(String address) {
    return address.replaceAll("\\s", "");
  }
}