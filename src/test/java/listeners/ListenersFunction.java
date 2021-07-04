package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentManager.ExtentPattern;
import extentManager.ExtentReportManager;
import testBase.DriverFactory;

public class ListenersFunction implements ITestListener{
	static ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		test.assignAuthor("Faruq");
		test.assignDevice("Chrome");
		test.assignCategory("smoke");
		ExtentPattern.getExtentInstance().setExtent(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentPattern.getExtentInstance().getExtent().log(Status.PASS, 
				"pass "+result.getMethod().getMethodName());
		ExtentPattern.getExtentInstance().closeExtent();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentPattern.getExtentInstance().getExtent().log(Status.FAIL, 
				"Fail "+result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(getScreenshot(DriverFactory.getInatance().getDriver(), 
				result.getMethod().getMethodName()));
		ExtentPattern.getExtentInstance().closeExtent();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentPattern.getExtentInstance().getExtent().log(Status.SKIP, 
				"skipped "+result.getMethod().getMethodName());
		ExtentPattern.getExtentInstance().closeExtent();
	}

	@Override
	public void onStart(ITestContext context) {
		try {
			report=ExtentReportManager.createExtentReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	public static String getScreenshot(WebDriver driver, String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + screenShotName + System.currentTimeMillis()
				+ ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;

	}

}
