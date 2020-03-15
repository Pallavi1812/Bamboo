package CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactUs {
	
	 static WebDriver driver;
	 
	@Test(priority=1,description="This test case Clicking on Contact us and matching the URL")
	public static void contactUS() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver.exe");
		 driver = new FirefoxDriver();
		Thread.sleep(3000);
		driver.get("https://www.bambooapp.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,7000)", "");
		
		((RemoteWebDriver) driver).findElementByLinkText("Contact Us").click();
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://www.bambooapp.com/contact-us/" );
		System.out.println("URL matching --> Part executed");
		
		
	}

	   @Test(priority=2,dataProvider="contact",description="This test case Filling the data of users")
	  public static void userData(String fname,String lname, String email,String pnum, String Description) {
		    driver.findElement(By.name("fname")).sendKeys(fname);
		    
	  }
	   
	   @Test(priority=3,description="This test case closing the browser")
	   static void closeBrowser() {
		   driver.quit();
	   }
	   
	   
	   @DataProvider(name = "Contactus")
		public Object [][] contact() {
			Object[][] data = new Object[2][6];
			
			data[0][0]="tanisha";  //Will pass
			   data[0][1]="Gupta";
			   data[0][2]="tanisha@yopmail.com";
			   data[0][3]="1234567890";
			   data[0][4]="Testing Purpose only! Please ignore it";
			  
			
			   data[1][0]="Himanshu";  //Will pass
			   data[1][1]="Rai";
			   data[1][2]="1234567890";
			   data[1][3]="himanshu@yopmail.com";
			   data[1][4]="Testing purpose only!Please ignore it";
			  
			   
			   
			return data;
		}
}
