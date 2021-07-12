package loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testBase.BaseTest;
import testBase.DriverFactory;

public class TitleAndURLTest extends BaseTest{
	@Test
	public void getTitle() {
		System.out.println("title test");
		WebDriver driver=DriverFactory.getInatance().getDriver();
		System.out.println(driver.getTitle());
		

	}
	@Test
	public void getURL() {
		System.out.println("Url test");
		WebDriver driver=DriverFactory.getInatance().getDriver();
		System.out.println(driver.getCurrentUrl());
	}
	@Test
	public void getText() {
		System.out.println("Text test");
		WebDriver driver=DriverFactory.getInatance().getDriver();
		String txt=driver.getTitle().toUpperCase();
		System.out.println(txt);

	}
}
