package ru.stqa.p.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class СontactCreationTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.id("LoginForm")).submit();
  }

  @Test
  public void testСontactCreation() throws Exception {
    gotoContactsPage();
    initContactsCreation();
    fillContactsFrom(new GroupContact("Alexey", "Orlov", "89445556767", "a123@gmail.com"));
    submitContactsCreation();
    returnToContactsPage();
  }

  private void returnToContactsPage() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private void submitContactsCreation() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void fillContactsFrom(GroupContact groupContact) {
    wd.findElement(By.name("firstname")).sendKeys(groupContact.firstname());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(groupContact.lastname());
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(groupContact.mobile());
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(groupContact.email());
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void initContactsCreation() {
    wd.findElement(By.name("firstname")).clear();
  }

  private void gotoContactsPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
