package DemoShoppingWebsite;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChoosingProducts {

	WebDriver driver;
	@BeforeSuite
	public void site() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chris\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test(priority = 0)
	public void Product1() throws InterruptedException {

		//maximize window
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Search box

		WebElement search = driver.findElement(By.id("search_query_top"));
		Actions act = new Actions(driver);
		act.moveToElement(search).click().perform();
		act.sendKeys("t shirt");
		act.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();

		//scroll down 

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		WebElement a = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		act.moveToElement(a).perform();

		WebElement more = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span"));
		more.click();
		js.executeScript("window.scrollBy(0,250)", "");
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//select quantity
		WebElement quantity = driver.findElement(By.className("icon-plus"));
		quantity.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(2000);

		//select size using select class (dropdown)

		WebElement dropdownvalue = driver.findElement(By.id("group_1"));
		Select select1 = new Select(dropdownvalue);
		select1.selectByValue("3");

		List<WebElement> optionlist = select1.getOptions();
		System.out.println("total sizes available are - " +optionlist.size());

		int size=optionlist.size(); 
		for (int i= 0;i<size;i++)
		{
			System.out.println(optionlist.get(i).getText());
		}

		Thread.sleep(2000);

		//choose color
		WebElement blue = driver.findElement(By.name("Blue"));
		blue.click();

		//add to cart

		WebElement cart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		cart.click();
		WebElement success = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
		System.out.println(success.getText());

		System.out.println("Product successfully added to your shopping cart");
		WebElement productdetails = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/div[2]"));
		System.out.println(productdetails.getText());
		//System.out.println("Product details are");
		//WebElement Productname = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_title\"]"));
		//System.out.println(Productname.getText());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		WebElement Continue = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
		System.out.println(Continue.getText());
		Continue.click();

	}

	@Test(priority = 1)
	public void Product2() throws InterruptedException {

		//adding second item to the cart
		WebElement women = driver.findElement(By.className("sf-with-ul"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(women).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		WebElement blouse = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a"));
		act2.moveToElement(blouse).perform();
		blouse.click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,400)", "");
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]"));
		dropdown2.click();
		WebElement instock = driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]/option[6]"));
		instock.click();
		WebElement size1 = driver.findElement(By.id("layered_id_attribute_group_2"));
		size1.click();

		WebElement compositions = driver.findElement(By.id("layered_id_feature_5"));
		compositions.click();
		WebElement styles = driver.findElement(By.id("layered_id_feature_11"));
		styles.click();
		WebElement shortsleeves = driver.findElement(By.xpath("//*[@id=\"layered_id_feature_17\"]"));
		shortsleeves.click();
		WebElement availability = driver.findElement(By.xpath("//*[@id=\"layered_quantity_1\"]"));
		availability.click();
		js2.executeScript("window.scrollBy(0,400)", "");
		WebElement manufacturer = driver.findElement(By.xpath("//*[@id=\"layered_manufacturer_1\"]"));
		manufacturer.click();
		WebElement condition = driver.findElement(By.xpath("//*[@id=\"layered_condition_new\"]"));
		condition.click();
		WebElement b = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		act2.moveToElement(b).perform();
		WebElement more1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span"));
		more1.click();

	}

	@Test(priority = 2)
	public void twitterwindow() throws InterruptedException {
		//new window
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,400)", "");
		String parentwindow = driver.getWindowHandle();
		WebElement tweet = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/p[7]/button[1]"));
		tweet.click();
		Set<String> handle = driver.getWindowHandles();
		for (String newwindow : handle) {
			driver.switchTo().window(newwindow);
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		driver.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		//wait.until(pageLoads);
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[3]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div[2]/form/div/div[1]/label"));
		phone.sendKeys("123456789");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[3]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div[2]/form/div/div[2]/label"));
		password.sendKeys("kausalya");
		System.out.println("The current window your working on is : " +driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);


		//to count all opened windows
		int countofwindows = driver.getWindowHandles().size();// with the help of size command we are getting count
		System.out.println("Total number of windows opened are : " +countofwindows);
		driver.switchTo().window(parentwindow);
		System.out.println("The current window your working on is : " +driver.getTitle());
	}

	@Test(priority = 3)

	public void product2continue() throws InterruptedException {

		//second product

		WebElement quantity2 = driver.findElement(By.className("icon-plus"));
		quantity2.click();
		WebElement dropdownvalue2 = driver.findElement(By.id("group_1"));
		Select select2 = new Select(dropdownvalue2);
		select2.selectByValue("3");

		WebElement cart2 = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		cart2.click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement success2 = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
		System.out.println(success2.getText());
		System.out.println();
		System.out.println("Product deatils");
		System.out.println();
		WebElement productdetails2 = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/div[2]"));
		System.out.println(productdetails2.getText());
		WebElement TotalProducts = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/h2/span[1]"));
		System.out.println(TotalProducts.getText());
		System.out.println();

		Thread.sleep(5000);
		WebElement proceed = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		proceed.click();
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,400)", "");
		WebElement check = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		check.click();

	}
	@Test(priority = 4)
	public void CreateAccount() throws InterruptedException {
		WebElement create = driver.findElement(By.name("email_create"));
		create.sendKeys("kous63@gmail.com");
		WebElement continue2 = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
		continue2.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(5000);
	}

	@Test(priority = 5)
	public void FillDetails() throws InterruptedException {

		WebElement mrs = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
		mrs.click();
		WebElement firstname = driver.findElement(By.name("customer_firstname"));
		firstname.sendKeys("kausalya");
		WebElement lastname = driver.findElement(By.name("customer_lastname"));
		lastname.sendKeys("K");
		WebElement passwrd = driver.findElement(By.name("passwd"));
		passwrd.sendKeys("Jyothi");

		//dropdown to select date of birth
		WebElement days = driver.findElement(By.name("days"));
		Select select3 = new Select(days);
		select3.selectByValue("14");

		WebElement months = driver.findElement(By.name("months"));
		//months.click();
		WebElement march = driver.findElement(By.xpath("//option[contains(text(),'March')]"));
		march.click();

		WebElement years = driver.findElement(By.name("years"));
		WebElement yr = driver.findElement(By.xpath("//option[contains(text(),'1999')]"));
		yr.click();

		//checkboxes
		WebElement offers = driver.findElement(By.name("optin"));
		offers.click();

		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys("Edubridge");

		WebElement address1 = driver.findElement(By.name("address1"));
		address1.sendKeys("1552, Periay nagar, BSA Road");

		WebElement address2 = driver.findElement(By.name("address2"));
		address2.sendKeys("frazer town");

		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Bangalore");

		WebElement state = driver.findElement(By.id("id_state"));
		WebElement stat = driver.findElement(By.xpath("//option[contains(text(),'Florida')]"));
		stat.click();

		WebElement postal = driver.findElement(By.id("postcode"));
		postal.sendKeys("00000");
		
		WebElement additional = driver.findElement(By.xpath("//*[@id=\"other\"]"));
		additional.sendKeys("Near Football Ground");
		
		WebElement homemobile = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		homemobile.sendKeys("6547812385");

		WebElement mobile = driver.findElement(By.name("phone_mobile"));
		mobile.sendKeys("854123789");

		//register

		WebElement register = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
		register.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(5000);

	}
	@Test(priority = 6)
	public void DeliveryAddress() throws InterruptedException {
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("window.scrollBy(0,400)", "");

		WebElement deliveryaddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]"));
		System.out.println(deliveryaddress.getText());

		WebElement comment = driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea"));
		comment.sendKeys("Please deliver the item on or before 15/12/2021");
		Thread.sleep(3000);
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		checkout.click();

	}
	@Test(priority = 7)
	public void TermsandConditions() throws InterruptedException {
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("window.scrollBy(0,400)", "");

		//hyperlink 

		WebElement terms = driver.findElement(By.partialLinkText("(Read the Terms of Service)"));
		terms.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		WebElement close = driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a"));
		close.click();

		WebElement agree = driver.findElement(By.name("cgv"));
		agree.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		js6.executeScript("window.scrollBy(0,150)", "");
		WebElement proceed2 = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button"));
		proceed2.click();

	}
	@Test(priority = 8)
	public void Paymentmethod() {
		WebElement choosepayment = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1"));
		System.out.println();
		System.out.println(choosepayment.getText());	
		WebElement payment = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		System.out.println("You have choosen - " +payment.getText());
		System.out.println();
		payment.click();
		JavascriptExecutor js7 = (JavascriptExecutor) driver;
		js7.executeScript("window.scrollBy(0,400)", "");

		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		confirm.click();

	}
	@Test(priority = 9)
	public void Orderconfirmation() throws IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js8.executeScript("window.scrollBy(0,385)", "");

		//to take screen shot
		TakeSnapshot(driver, "img");
		
		System.out.println("Order Confirmation - Screenshot is captured successfully");
	}

	//take screenshot of order confirmation

	private static void TakeSnapshot(WebDriver driver, String string) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot screenshot1=((TakesScreenshot)driver);
		File img = screenshot1.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img, new File("C:\\Users\\chris\\OneDrive\\Documents\\selenium screenshots\\orderconfirmation.png"));
	}
}
