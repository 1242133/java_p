package ru.stqa.p.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.p.addressbook.model.ContactData;
import ru.stqa.p.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToContactsPage() {
    click(By.linkText("home page"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void submitContactsCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactsFrom(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
    attach(By.name("photo"), contactData.getPhoto());


    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertEquals(contactData.getGroups().size(), 1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void type(By locator, String text) {
    if (text != null) {
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void initContactsCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int id) {
    click(By.cssSelector(String.format("input[name='selected[]'][value='%s']", id)));
  }

  public void selectGroupForAddById(int groupId) {
    click(By.cssSelector(String.format("select[name='to_group'] > option[value='%s']", groupId)));
  }

  public void selectGroupPageById(int groupId) {
    click(By.cssSelector(String.format("select[name='group'] > option[value='%s']", groupId)));
  }

  private void removeSelectedContactFromGroup() {
    click(By.xpath("//input[@name='remove']"));
  }

  public void addSelectedContactToGroup() {
    click(By.xpath("//input[@value='Add to']"));
  }

  public void selectDelete() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void confirmAction() {
    wd.switchTo().alert().accept();
  }

  public void submitContactsModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void create(ContactData contactData) {
    initContactsCreation();
    fillContactsFrom(contactData, true);
    submitContactsCreation();
    contactCache = null;
    returnToContactsPage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactsFrom(contact, false);
    submitContactsModification();
    contactCache = null;
    returnToContactsPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    selectDelete();
    contactCache = null;
    confirmAction();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }
  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> contactDataElements = element.findElements(By.cssSelector("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = contactDataElements.get(1).getText();
      String firstname = contactDataElements.get(2).getText();
      String allPhones = contactDataElements.get(5).getText();
      String allEmails = contactDataElements.get(4).getText();
      String address = contactDataElements.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address).withAllEmails(allEmails)
              .withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }

  public ContactData InfoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobile(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }
  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void addToGroup(int contactId, int groupId) {
    selectContactById(contactId);
    selectGroupForAddById(groupId);
    addSelectedContactToGroup();
    contactCache = null;
  }
  public void removeFromGroup(int contactId, int groupId) {
    selectGroupPageById(groupId);
    selectContactById(contactId);
    removeSelectedContactFromGroup();
  }
}
