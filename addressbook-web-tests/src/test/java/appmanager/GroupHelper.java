package appmanager;

import homework.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupFrom(GroupData groupData) {
    type(By.name("group_name"), groupData.name());
    type(By.name("group_header"), groupData.header());
    type(By.name("group_footer"), groupData.footer());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void returnToContactsPage() {
    click(By.linkText("Logout"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void submitContactsCreation() {
    click(By.linkText("home page"));
  }

  public void fillContactsFrom(ContactData contactData) {
    type(By.name("firstname"), contactData.firstname());
    type(By.name("lastname"), contactData.lastname());
    type(By.name("mobile"), contactData.mobile());
    type(By.name("email"), contactData.email());
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void type(By locator, String text) {
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void initContactsCreation() {
    wd.findElement(By.name("firstname")).clear();
  }

  public void selectContact() {
    click(By.xpath("//input[@id]"));
  }
  public void selectDelete() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void confirmAction() {
    wd.switchTo().alert().accept();
  }

  public void selectContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img"));
  }
}
