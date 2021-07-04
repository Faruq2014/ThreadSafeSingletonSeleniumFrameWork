package testingPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import testBase.BaseTest;
import testBase.DriverFactory;

public class LoginTest extends BaseTest{
	@Test
	public void loginTest() {
		
		WebDriver driver=DriverFactory.getInatance().getDriver();
		driver.findElement(By.id("email")).sendKeys("Faruq");
		driver.findElement(By.id("pass")).sendKeys("1234");
	}
	@Test
	public void assertURLTest() {
		System.out.println("Url test");
		WebDriver driver=DriverFactory.getInatance().getDriver();
		String actualURL="https://www.facebook.com1/";
		Assert.assertEquals(actualURL, driver.getCurrentUrl());
		
	}
	@Test
	public void skiipTitleTest() {
		System.out.println("Text test");
		WebDriver driver=DriverFactory.getInatance().getDriver();
		String txt=driver.getTitle().toUpperCase();
		System.out.println(txt);
		throw new SkipException(" We will build it latter. ");

	}
}
