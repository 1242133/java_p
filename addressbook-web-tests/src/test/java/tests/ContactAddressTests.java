package tests;

import model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().stream().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactAddressTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String address) {
    return address.replaceAll("\\s", "");
  }
}