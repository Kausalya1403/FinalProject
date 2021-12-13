package DemoShoppingWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CustomerService {
	
	WebDriver driver;
	  
	  @Test(priority = 0)
	  public void site1() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chris\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
	  }
	  
	  @Test(priority = 1)
	  public void ContactLink() {
		  WebElement contact = driver.findElement(By.linkText("Contact us"));
		  contact.click(); 
	  }
	  @Test(priority = 2)
	  public void Heading() {
		  WebElement subject = driver.findElement(By.id("id_contact"));
		  System.out.println(subject.getText());
		  Select select1 = new Select(subject);
		  select1.selectByValue("2");
		  System.out.println("You have choosen customer service");
		 
	  }
	  
	  @Test(priority = 3)
	  public void Email() {
		  WebElement emailaddress = driver.findElement(By.id("email"));
		  emailaddress.sendKeys("kous26@gmail.com"); 
	  }
	  
	  @Test(priority = 4) 
	  public void reference() {
		  WebElement ref = driver.findElement(By.id("id_order"));
		  ref.sendKeys("MLHMPNBUY"); 
	  }
	  
	  @Test(priority = 5)
	  public void message() throws InterruptedException {
		  WebElement information = driver.findElement(By.id("message"));
		  information.sendKeys("I did not receive my order yet. Please do help me regarding the same. I'm attaching the screenshot of order confirmation for your reference");
		  Thread.sleep(3000);
	  }
	  
	  @Test(priority = 6)
	  public void upload() {
		  WebElement choosefile = driver.findElement(By.xpath("//*[@id=\"fileUpload\"]"));
		  choosefile.sendKeys("C:\\Users\\chris\\OneDrive\\Documents\\selenium screenshots\\order.png");
		  System.out.println("File uploaded successfully");
		  
	  }
	  
	  @Test(dependsOnMethods= {"upload"})
	  public void send() throws InterruptedException
	  {
		  WebElement submitmessage = driver.findElement(By.id("submitMessage"));
		  submitmessage.click();
		  Thread.sleep(3000);
		  
	  }
	  
	  
  }

