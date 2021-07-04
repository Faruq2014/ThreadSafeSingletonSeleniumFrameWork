package testBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import properties.PropertiesUpload;

public class BaseTest {
	BrowserFactory bfactory = new BrowserFactory();
	@BeforeMethod
	public void openApplication() throws Exception {
	String browser=PropertiesUpload.getPropertiesValuesByKey("Browser");
	String url=PropertiesUpload.getPropertiesValuesByKey("URL");
	WebDriver driverInstance=bfactory.createBrowserInstance(browser);
		DriverFactory.getInatance().setDriver(driverInstance);
		WebDriver driver=DriverFactory.getInatance().getDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
   @AfterMethod
	public void tearDown() {
		DriverFactory.getInatance().closeBrowser();
	}
}
