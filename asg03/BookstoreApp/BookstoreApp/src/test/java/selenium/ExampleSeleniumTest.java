package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;
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
    WebElement confirmation = driver.findElement(By.cssSelector("h2"));
    String expected = "Successfully";
    String actual = confirmation.getText();
    assertEquals(expected, getWords(actual)[0]);
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
    WebElement confirmation = driver.findElement(By.cssSelector("h2"));
    String expected = "Successfully";
    String actual = confirmation.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  @Test
  public void testF2positive() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("searchBtn")).click();

    WebElement confirmation = driver.findElement(By.cssSelector("h1"));
    String expected = "We";
    String actual = confirmation.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  @Test
  public void testF2negative() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("search-category-form")).click();
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("search")).sendKeys(".");
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.cssSelector("html")).click();

    WebElement confirmation = driver.findElement(By.cssSelector("h1"));
    String expected = "We";
    String actual = confirmation.getText();
    assertEquals(expected, getWords(actual)[0]);
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
 //   driver.findElement(By.id("order-bookthatdoesn'texist")).click();
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
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("loginId")).click();
    driver.findElement(By.id("loginId")).sendKeys("admin");
    driver.findElement(By.id("loginPasswd")).click();
    driver.findElement(By.id("loginPasswd")).sendKeys("password");
    driver.findElement(By.id("loginBtn")).click();
    driver.get("http://localhost:8080/admin");
    driver.findElement(By.id("addBook-category")).click();
    driver.findElement(By.id("addBook-category")).sendKeys("Test");
    driver.findElement(By.id("addBook-id")).click();
    driver.findElement(By.id("addBook-id")).sendKeys("54321");
    driver.findElement(By.id("addBook-title")).click();
    driver.findElement(By.id("addBook-title")).sendKeys("I\'m so tired");
    driver.findElement(By.id("addBook-authors")).click();
    driver.findElement(By.id("addBook-authors")).sendKeys("Fatimah");
    driver.findElement(By.id("longDescription")).click();
    driver.findElement(By.id("longDescription")).sendKeys("sleepy");
    driver.findElement(By.id("cost")).click();
    driver.findElement(By.id("cost")).sendKeys("6.0");
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
  public void testF8negative() {/*
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("loginId")).click();
    driver.findElement(By.id("loginId")).sendKeys("admin");
    driver.findElement(By.id("loginPasswd")).click();
    driver.findElement(By.id("loginPasswd")).sendKeys("WRONGpassword");
    driver.findElement(By.id("loginBtn")).click();
    driver.get("http://localhost:8080/admin");
    driver.findElement(By.id("addBook-category")).click();
    driver.findElement(By.id("addBook-category")).sendKeys("Test");
    driver.findElement(By.id("addBook-id")).click();
    driver.findElement(By.id("addBook-id")).sendKeys("54321");
    driver.findElement(By.id("addBook-title")).click();
    driver.findElement(By.id("addBook-title")).sendKeys("I\'m so tired");
    driver.findElement(By.id("addBook-authors")).click();
    driver.findElement(By.id("addBook-authors")).sendKeys("Fatimah");
    driver.findElement(By.id("longDescription")).click();
    driver.findElement(By.id("longDescription")).sendKeys("sleepy");
    driver.findElement(By.id("cost")).click();
    driver.findElement(By.id("cost")).sendKeys("6.0");
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
    }*/
  }
  @Test
  public void TC1_1(){
    loginAdmin();
    String actualUrl = "http://localhost:8080/admin";
    String expectedUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);
  }
  @Test
  public void TC1_2(){
    driver.get("http://localhost:8080/admin");

    WebElement username = driver.findElement(By.id("loginId"));
    username.sendKeys("test1");

    WebElement password = driver.findElement(By.id("loginPasswd"));
    password.sendKeys("test1");

    WebElement signIn = driver.findElement(By.id("loginBtn"));
    signIn.click();

    String actualUrl = "http://localhost:8080/login?error";
    String expectedUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);
    
    //Back to STEP 2 to log in again
    WebElement secondUsername = driver.findElement(By.id("loginId"));
    secondUsername.sendKeys("admin");

    WebElement secondPassword = driver.findElement(By.id("loginPasswd"));
    secondPassword.sendKeys("password");

    WebElement secondSignIn = driver.findElement(By.id("loginBtn"));
    secondSignIn.click();

    String newActualUrl = "http://localhost:8080/admin";
    String newExpectedUrl = driver.getCurrentUrl();
    assertEquals(newExpectedUrl, newActualUrl);

  }
  
  @Test
  public void TC2_1(){
    loginAdmin();
    
    WebElement signOut = driver.findElement(By.xpath("//div[@class='menu']/form[2]"));
    signOut.submit();

    String newActualUrl = "http://localhost:8080/login?logout";
    String newExpectedUrl = driver.getCurrentUrl();
    assertEquals(newExpectedUrl, newActualUrl);

  }
  @Test
  public void TC3_1(){
    loginAdmin();

    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("test3");

    WebElement bookId = driver.findElement(By.id("addBook-id"));
    bookId.sendKeys("test3");

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("test3");

    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("test3");

    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("10.0");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    WebElement feedback = driver.findElement(By.id("feedback"));

    String actualMessage = feedback.getText();
    String expectedMessage = "Successfully added book";

    assertEquals(expectedMessage, actualMessage);

    /*  WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("test3");
 */
    driver.get("http://localhost:8080/admin/catalog");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement deleteBtn = driver.findElement(By.id("del-test3"));
    deleteBtn.click(); 
  }

  @Test
  public void TC3_2(){
    loginAdmin();

    WebElement bookId = driver.findElement(By.id("addBook-id"));
    bookId.sendKeys("test3_2");

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("test3_2");

    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("test3_2");

    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("12.0");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    WebElement feedback = driver.findElement(By.cssSelector("h2"));

    String actualMessage = feedback.getText();
    String expectedMessage = "Validation errors";

    assertEquals(expectedMessage, actualMessage);
    
    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("test3_2");

    WebElement newAddBtn = driver.findElement(By.name("addBook"));
    newAddBtn.click();

    WebElement newFeedback = driver.findElement(By.cssSelector("h2"));

   // String newActualMessage = newFeedback.getText();
   // String newExpectedMessage = "Successfully added book";

   // assertEquals(newExpectedMessage, newActualMessage);
    
    driver.get("http://localhost:8080/admin/catalog");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement deleteBtn = driver.findElement(By.id("del-test3_2"));
    deleteBtn.click();
  }
  @Test
  public void TC3_3(){
    loginAdmin();

    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("test3_3");

    WebElement bookId = driver.findElement(By.id("addBook-id"));
    bookId.sendKeys("test3_3");

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("test3_3");

    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("test3_3");

    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("11.0");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    addBtn.click();

    WebElement newFeedback = driver.findElement(By.id("feedback"));

    String newActualMessage = newFeedback.getText();
    String neweExpectedMessage = "Book with same id already exist";

    assertEquals(neweExpectedMessage, newActualMessage);
    
    bookId.clear();
    bookId.sendKeys("id2021");

    WebElement addBtn3 = driver.findElement(By.name("addBook"));
    addBtn3.click();

    WebElement feedback = driver.findElement(By.id("feedback"));

    String actualMessage2 = feedback.getText();
    String expectedMessage2 = "Successfully added book";

    assertEquals(expectedMessage2, actualMessage2);
    
    driver.get("http://localhost:8080/admin/catalog");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement deleteBtn = driver.findElement(By.id("del-id2021"));
    deleteBtn.click();

    driver.navigate().refresh();

    WebElement deleteBtn2 = driver.findElement(By.id("del-test3_3"));
    deleteBtn2.click();

  }
  @Test
  public void TC4_1(){
    driver.get("http://localhost:8080/");
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("theater");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    String expectedMessage ="We currently have the following items in category 'theater'";
    String actualMessage = driver.findElement(By.cssSelector("h1")).getText();
    assertEquals(expectedMessage,actualMessage);
  }
  @Test
  public void TC4_2(){
    driver.get("http://localhost:8080/");
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    String expectedMessage ="We currently have the following items in category ''";
    String actualMessage = driver.findElement(By.cssSelector("h1")).getText();
    assertEquals(expectedMessage,actualMessage);
  }
  @Test
  public void TC4_3(){
    driver.get("http://localhost:8080/");
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("shows");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    String expectedMessage ="Sorry we do not have any item matching category 'shows' at this moment";
    String actualMessage = driver.findElement(By.cssSelector("h1")).getText();
    assertEquals(expectedMessage,actualMessage);
  }
  /* @Test
  public void TC5_1(){
       Boolean expectedResult = false;
       Boolean actualResult;
       driver.get("http://localhost:8080/admin/catalog");
       WebElement deleteBtn = driver.findElement(By.id("del-rowling001"));
       deleteBtn.click();
      
       try {
        WebElement deleteElement = driver.findElement(By.id("del-rowling001"));
        actualResult = true;
       }catch(Exception e){
        actualResult = false;
       }
       assertEquals(expectedResult,actualResult);
  } */
  @Test
  public void TC6_1(){
    driver.get("http://localhost:8080/");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    
    driver.get("http://localhost:8080/catalog");
    WebElement addCartBtn = driver.findElement(By.id("order-hall001"));
    addCartBtn.click();
    addCartBtn.click();

    WebElement cartBtn = driver.findElement(By.id("cartLink"));
    cartBtn.click();
    
    driver.get("http://localhost:8080/orderPage");
    WebElement bookAdded = driver.findElement(By.id("hall001"));

    String actualNumberOfBooksAdded = bookAdded.getAttribute("value");

    String expectedNumberOfBooksAdded = "2";

    assertEquals(expectedNumberOfBooksAdded, actualNumberOfBooksAdded);

    bookAdded.sendKeys("0");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();
  }
  @Test
  public void TC6_2(){
    driver.get("http://localhost:8080/");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    
    driver.get("http://localhost:8080/catalog");
    WebElement addCartBtn = driver.findElement(By.id("order-hall001"));
    addCartBtn.click();
    addCartBtn.click();

    WebElement cartBtn = driver.findElement(By.id("cartLink"));
    cartBtn.click();
    
    driver.get("http://localhost:8080/orderPage");
    WebElement bookAdded = driver.findElement(By.id("hall001"));

    String actualNumberOfBooksAdded = bookAdded.getAttribute("value");

    String expectedNumberOfBooksAdded = "2";

    assertEquals(expectedNumberOfBooksAdded, actualNumberOfBooksAdded);

    bookAdded.sendKeys("0");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();
  }
  
  @Test
  public void TC8_1(){
    driver.get("http://localhost:8080/");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    
    driver.get("http://localhost:8080/catalog");
    WebElement addCartBtn = driver.findElement(By.id("order-hall001"));
    addCartBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();
    
    driver.get("http://localhost:8080/orderPage");
    WebElement bookAdded = driver.findElement(By.id("hall001"));

    bookAdded.clear();
    bookAdded.sendKeys("2");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();

    WebElement newTotalCost = driver.findElement(By.id("tothall001"));

    String actualNewTotalCost = newTotalCost.getText();
    String expectedNewTotalCost = "$79.90";

    assertEquals(expectedNewTotalCost, actualNewTotalCost);
  }
  @Test
  public void TC8_2(){
    driver.get("http://localhost:8080/");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    
    driver.get("http://localhost:8080/catalog");
    
    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();
 
    driver.get("http://localhost:8080/orderPage");

    WebElement bookAdded = driver.findElement(By.id("hall001"));

    bookAdded.clear();
    bookAdded.sendKeys("0");
    

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();

    WebElement newTotalCost = driver.findElement(By.id("tothall001"));

    String actualNewTotalCost = newTotalCost.getText();
    String expectedNewTotalCost = "$0.00";

    assertEquals(expectedNewTotalCost, actualNewTotalCost);
  }
  @Test
  private void TC9_1(){
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement cartBtn = driver.findElement(By.id("cartLink"));
    cartBtn.click();

    WebElement checkoutBtn = driver.findElement(By.name("checkout"));
    checkoutBtn.click();

    String newActualUrl = "http://localhost:8080/checkout";
    String newExpectedUrl = driver.getCurrentUrl();
    assertEquals(newExpectedUrl, newActualUrl);
  }

  @Test
  public void TC10_1() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expectedText = "Welcome";
    String actualText = welcome.getText();
    assertEquals(expectedText, getWords(actualText)[0]);

    WebElement languageSelector = driver.findElement(By.id("locales"));
    languageSelector.click();

    WebElement frenchSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frenchSelector.click();

    welcome = driver.findElement(By.cssSelector("p"));
    expectedText = "Bienvenu";
    actualText = welcome.getText();
    assertEquals(expectedText, getWords(actualText)[0]);
  }
  private void loginAdmin() {

    driver.get("http://localhost:8080/admin");

    WebElement username = driver.findElement(By.id("loginId"));
    username.sendKeys("admin");

    WebElement password = driver.findElement(By.id("loginPasswd"));
    password.sendKeys("password");

    WebElement signIn = driver.findElement(By.id("loginBtn"));
    signIn.click();
  }

}
