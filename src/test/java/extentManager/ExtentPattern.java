package extentManager;

import com.aventstack.extentreports.ExtentTest;

public class ExtentPattern {
	// private constructor
	private ExtentPattern() {
		
	} // class level data type variable
	private static ExtentPattern extentInstance = new ExtentPattern();
	// static method to get access
	public static ExtentPattern getExtentInstance() {
		return extentInstance;	
	}
  // parallel threading 
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	//get the report
	public ExtentTest getExtent() {
		return extent.get();
	}
	// set the report
	public void setExtent(ExtentTest extentParam) {
		extent.set(extentParam);
	}
	public void closeExtent() {
		extent.remove();
	}
}
