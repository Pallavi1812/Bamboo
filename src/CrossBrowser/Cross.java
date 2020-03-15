package CrossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross {
	
	WebDriver driver;
	
	@Test(priority=1,description="This test case executing three browsers Firefox,Chrome & Edge")
	
	@Parameters("browsers")
	public void setup(String browsers) throws Exception{
		
		//Check if parameter passed from TestNG is 'firefox'
		if(browsers.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browsers.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
				else if(browsers.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver","C:\\Users\\hp\\Downloads\\MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test(priority=2,description="This test case is opening URL in provided browsers")
	public void hitURL() throws Exception {
		Thread.sleep(3000);
		driver.get("https://www.bambooapp.com/");
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		driver.quit();

}
}
