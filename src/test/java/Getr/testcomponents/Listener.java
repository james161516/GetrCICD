package Getr.testcomponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Getr.Resources.ExtendReport;

public class Listener extends BaseTest implements ITestListener{
    ExtentTest test;
	ExtentReports extent = ExtendReport.ExtentReport();
	
	ThreadLocal<ExtentTest> Extentthread= new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		Extentthread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Extentthread.get().log(Status.PASS, "Test Case " +result.getMethod().getMethodName() + " is passed" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Extentthread.get().fail(result.getThrowable());
		
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Extentthread.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		Extentthread.get().log(Status.FAIL, "This test case is get Failed = " +result.getMethod().getMethodName() + " " );
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public static void main(String[] args) {
		

	}

}
