package DemoShoppingWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MyOrders {
	WebDriver driver;
	String[][] data = null;

	@DataProvider(name="order")
	public String[][] abc() throws BiffException, IOException
	{
		String [][] td = getExcelDAta();
		return td;
	}
	public String[][] getExcelDAta() throws BiffException, IOException
	{
		FileInputStream excel=new FileInputStream(new File("C:\\Users\\chris\\OneDrive\\Documents\\excel\\myorders.xls"));  
		//XSSFWorkbook workbook = new XSSFWorkbook();

		Workbook wb= Workbook.getWorkbook(excel);   
		Sheet sheet=wb.getSheet(0);  
		int row = sheet.getRows(); 
		int col = sheet.getColumns();
		
		System.out.println(row);
		System.out.println(col);

		String[][] testdata =new String[row-1][col];
		for(int i=1; i<row;i++) {
			for(int j=0; j<col;j++)
			{
				testdata[i-1][j]=sheet.getCell(j, i).getContents();

				//   System.out.println(testdata[j][i]);

			}
		}
		return testdata;

	}

	@Test(dataProvider = "order")
	public void login(String x, String y) throws InterruptedException// we are mapping it to String a using DataProvider 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chris\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=history");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(x);
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys(y);
		WebElement signin = driver.findElement(By.id("SubmitLogin"));
		signin.click(); 


		// to track order
		WebElement order = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a"));
		order.click();

		//to download invoice bill pdf

		WebElement invoicePDF = driver.findElement(By.className("history_invoice"));
		invoicePDF.click();
		//to wait till the download is complete
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods= {"login"})
	public void Download() {
		//to validate the file is downloaded or not

		File location = new File("C:\\Users\\chris\\Downloads");//using file class
		File[] totalFilesInlocation = location.listFiles();  //store files in array
		for(File checkpdf : totalFilesInlocation)
		{ //it checks all the files in the location
			if(checkpdf.getName().equals("IN154633.pdf")) 
			{
				System.out.println("File is downloaded successfully and present in the downloads folder");
				
			}
		}
	}


}



