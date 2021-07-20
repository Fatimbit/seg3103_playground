package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  @Test
  void test1() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }


  @Test
  public void testF1positive() {
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("loginId")).click();
    driver.findElement(By.id("loginId")).sendKeys("admin");
    driver.findElement(By.id("loginPasswd")).click();
    driver.findElement(By.id("loginPasswd")).sendKeys("password");
    driver.findElement(By.id("loginBtn")).click();
    driver.get("http://localhost:8080/admin");
    driver.findElement(By.id("addBook-category")).click();
    driver.findElement(By.id("addBook-category")).sendKeys("theater");
    driver.findElement(By.id("addBook-id")).click();
    driver.findElement(By.id("addBook-id")).sendKeys("12345");
    driver.findElement(By.id("addBook-title")).click();
    driver.findElement(By.id("addBook-title")).sendKeys("Fake Book");
    driver.findElement(By.id("addBook-authors")).click();
    driver.findElement(By.id("addBook-authors")).sendKeys("Someone");
    {
      WebElement element = driver.findElement(By.id("longDescription"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("longDescription"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("longDescription"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("longDescription")).click();
    driver.findElement(By.id("longDescription")).sendKeys("testing");
    driver.findElement(By.id("cost")).click();
    driver.findElement(By.id("cost")).sendKeys("9.0");
    driver.findElement(By.name("addBook")).click();
    {
      WebElement element = driver.findElement(By.name("addBook"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }

  @Test
  public void testF1negative() {
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("loginId")).click();
    driver.findElement(By.id("loginId")).sendKeys("admin");
    driver.findElement(By.id("loginPasswd")).click();
    driver.findElement(By.id("loginPasswd")).sendKeys("password");
    driver.findElement(By.id("loginBtn")).click();
    driver.get("http://localhost:8080/admin");
    driver.findElement(By.id("addBook-title")).click();
    driver.findElement(By.id("addBook-title")).sendKeys("Book Title");
    driver.findElement(By.id("addBook-authors")).click();
    driver.findElement(By.id("addBook-authors")).sendKeys("Person");
    driver.findElement(By.id("longDescription")).click();
    driver.findElement(By.id("longDescription")).sendKeys("I am testing it is 4:46 AM");
    driver.findElement(By.id("cost")).click();
    driver.findElement(By.id("cost")).sendKeys("9.0");
    driver.findElement(By.name("addBook")).click();
    {
      WebElement element = driver.findElement(By.name("addBook"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }

  @Test
  public void testF2positive() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("searchBtn")).click();
  }

  @Test
  public void testF2negative() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search-category-form")).click();
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("search")).sendKeys(".");
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.cssSelector("html")).click();
  }
  @Test
  public void testF3positive() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("order-alexander001")).click();
    driver.findElement(By.id("cartLink")).click();
  }

  @Test
  public void testF3negative() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("order-lewis001")).click();
    driver.findElement(By.id("order-lewis001")).click();
    driver.findElement(By.id("cartLink")).click();
  }
  @Test
  public void testF4positive() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("order-hall002")).click();
    driver.findElement(By.id("order-lewis001")).click();
    driver.findElement(By.id("cartLink")).click();
  }
  @Test
  public void testF4negative() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("cartLink")).click();
  }
  @Test
  public void testF5positive() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("order-lewis001")).click();
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.id("lewis001")).sendKeys("2");
    driver.findElement(By.name("updateOrder")).click();
  }

  @Test
  public void testF5negative() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("order-lewis001")).click();
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.id("lewis001")).sendKeys("2.5");
    driver.findElement(By.name("updateOrder")).click();
  }
  @Test
  public void testF6positive() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("order-rowling001")).click();
    driver.findElement(By.id("order-alexander001")).click();
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.name("checkout")).click();
  }

  @Test
  public void testF6negative() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/catalog");
    driver.findElement(By.id("cartLink")).click();
    driver.findElement(By.name("checkout")).click();
  }

  @Test
  public void testF7positive() {
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("loginId")).click();
    driver.findElement(By.id("loginId")).sendKeys("admin");
    driver.findElement(By.id("loginPasswd")).click();
    driver.findElement(By.id("loginPasswd")).sendKeys("password");
    driver.findElement(By.id("loginBtn")).click();
    driver.get("http://localhost:8080/admin");
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/admin/catalog");
    driver.findElement(By.id("del-alexander001")).click();
  }

  @Test
  public void testF7negative() {
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("loginId")).click();
    driver.findElement(By.id("loginId")).sendKeys("admin");
    driver.findElement(By.id("loginPasswd")).click();
    driver.findElement(By.id("loginPasswd")).sendKeys("password");
    driver.findElement(By.id("loginBtn")).click();
    driver.get("http://localhost:8080/admin");
    driver.findElement(By.id("searchBtn")).click();
    driver.get("http://localhost:8080/admin/catalog");
   // driver.findElement(By.id("del-fakeid")).click();
  }

  @Test
  public void testF8positive() {
    
  }

  @Test
  public void testF8negative() {
    
  }
}
