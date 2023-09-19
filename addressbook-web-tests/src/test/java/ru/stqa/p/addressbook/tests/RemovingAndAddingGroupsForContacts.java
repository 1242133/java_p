package ru.stqa.p.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.p.addressbook.model.ContactData;
import ru.stqa.p.addressbook.model.Contacts;
import ru.stqa.p.addressbook.model.GroupData;
import ru.stqa.p.addressbook.model.Groups;

import java.util.stream.Collectors;

public class RemovingAndAddingGroupsForContacts extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
    app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstname("Alexey").withLastname("Orlov").withEmail("12ss"));
    }

    if (app.db().groups().size() == 0) {
    app.goTo().groupPage();
      app.group().create(new GroupData().withName("group").withHeader("header").withFooter("footer"));
    }
  }

  @Test
  public void testAddContactToGroup() {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData contactAdd = before.iterator().next();
    int contactId = contactAdd.getId();
    int groupId = groups.iterator().next().getId();

    if (groupHasContact(groupId, contactAdd)) {
      app.goTo().contactPage();
      app.contact().removeFromGroup(contactId, groupId);
    }

    app.goTo().contactPage();
    app.contact().addToGroup(contactId, groupId);
    
  }

  @Test
  public void testContactRemoveFromGroup() {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData contactForRemove = before.iterator().next();
    int contactId = contactForRemove.getId();
    int groupId = groups.iterator().next().getId();

    if (!groupHasContact(groupId, contactForRemove)) {
      app.goTo().contactPage();
      app.contact().addToGroup(contactId, groupId);
    }

    app.goTo().contactPage();
    app.contact().removeFromGroup(contactId, groupId);
    Contacts after = app.db().contacts();
    Assert.assertFalse(groupHasContact(groupId, MovedContact(contactId, after)));
  }

  public ContactData MovedContact(int contactId, Contacts contacts) {
    return contacts.stream().filter(c -> c.getId() == contactId)
            .collect(Collectors.toSet()).iterator().next();
  }

  public boolean groupHasContact(int groupId, ContactData contactAdd) {
    return contactAdd.getGroups().stream()
            .map((g) -> new GroupData().withId(g.getId())).collect(Collectors.toSet())
            .contains(new GroupData().withId(groupId));
  }
}
