	package testBase;
	
	import org.openqa.selenium.WebDriver;
	
	public class DriverFactory {
	//private constractor
		private DriverFactory() {
	
		}
		// class instance variable
		private static DriverFactory instance= new DriverFactory();
		
		// static method to access this class.
		public static DriverFactory getInatance() {
			return instance;
	
		}
		
		// making thread safe
		ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
		
		public WebDriver getDriver() {
			return driver.get();
		}
		public void setDriver(WebDriver browserParm) {
			driver.set(browserParm);
		}
		public void closeBrowser() {
			driver.get().close();
			driver.remove();
		}
	}
