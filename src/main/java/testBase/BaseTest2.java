package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import properties.PropertiesUpload;

public class BaseTest2 {
	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	public void openApp() throws Exception {
		String browser=PropertiesUpload.getPropertiesValuesByKey("Browser");
		WebDriver driverInstance=bf.createBrowserInstance(browser);
		
		DriverFactory.getInatance().setDriver(driverInstance);
		
		WebDriver driver=DriverFactory.getInatance().getDriver();
		String url=PropertiesUpload.getPropertiesValuesByKey("URL");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	 @AfterMethod
	public void tearDown() {
		DriverFactory.getInatance().closeBrowser();
	}
}
