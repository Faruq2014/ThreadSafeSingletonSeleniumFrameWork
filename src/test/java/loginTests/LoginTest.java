package loginTests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import dbManager.GetDBdata;
import testBase.BaseTest;
import testBase.DriverFactory;

public class LoginTest extends BaseTest{
	@Test
	public void loginTest() {
		//String sid1 = "SELECT * FROM [FaruqAcademy].[dbo].[Students] where studentId=1";
				//String select = "SELECT * FROM Students";
				//String sid1 = "SELECT * FROM Students where studentId=1";
				String sid2 = "SELECT * FROM Students where studentId=2";
				String sid3 = " SELECT * FROM account where  first_name='Faruq' and last_name='Molla'";
				
				GetDBdata db = new GetDBdata();
				HashMap<String, String> dbData=db.getSqlResultInMap(sid3);
				//System.out.println(dbData.get("firstname"));
				//System.out.println(dbData.get("phone"));	
		WebDriver driver=DriverFactory.getInatance().getDriver();
		driver.findElement(By.id("email")).sendKeys(dbData.get("user_name"));
		driver.findElement(By.id("pass")).sendKeys(dbData.get("password"));
		driver.findElement(By.xpath("//a[starts-with(@id, 'u_0_2')]")).click();
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
