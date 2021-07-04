package extentManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import properties.PropertiesUpload;

public class ExtentReportManager {
	static ExtentReports extent;
	
public static ExtentReports createExtentReports() throws Exception {
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
	Date date = new Date();
	String formatEdDate = format.format(date);
	
	String reportPath = System.getProperty("user.dir")+
			"/Reports/ExtentReport_"+formatEdDate+".html";
	
	ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
	extent= new ExtentReports();
	extent.attachReporter(sparkReport);
	sparkReport.config().setDocumentTitle("Automation Test Reports");
	sparkReport.config().setTheme(Theme.DARK);
	sparkReport.config().setReportName("Facebook Automation Report");
	
	 extent.setSystemInfo("User Name",System.getProperty("user.name"));
	 extent.setSystemInfo("Tester Name","Sajid");
	 extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	 extent.setSystemInfo("User Location", System.getProperty("user.country"));
	extent.setSystemInfo("OS name", System.getProperty("os.name"));
	extent.setSystemInfo("OS version", System.getProperty("os.version"));
	extent.setSystemInfo("JDK version", System.getProperty("java.version"));
	extent.setSystemInfo("Selenium version", "3.141.59");
	extent.setSystemInfo("Maven version", "3.15"); // you can write any thing.
	extent.setSystemInfo("Executed on Environment: ", PropertiesUpload.getPropertiesValuesByKey("Browser"));
	extent.setSystemInfo("Executed on Browser: ",PropertiesUpload.getPropertiesValuesByKey("URL"));


		
	return extent; 	
}
}
