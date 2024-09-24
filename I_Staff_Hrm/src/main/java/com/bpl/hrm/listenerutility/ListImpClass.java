package com.bpl.hrm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactoryFinder;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bpl.hrm.webdriverutility.UtilityClassObject;

/**
 * This class contains implementation methods for testng listeners interface.
 * 
 * @author Anant
 */
public class ListImpClass implements ITestListener, ISuiteListener {
	public static ExtentReports report;
	public static ExtentTest test;
	public ExtentSparkReporter spark;
	@Override
	/**
	 * This method helps user to configure extent report, such as report
	 * location,report title,theme and system information.
	 */
	public void onStart(ISuite suite) {
		System.out.println("report config");
		// spark report configuration
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("I-Saff HRM Test Suite Result");
		spark.config().setReportName("Hrm Test report");
		spark.config().setTheme(Theme.DARK);

		// add environment info and create test in extent report
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "chrome");
		report.setSystemInfo("Automation Engineer", "Anant");
	}

	@Override
	/**
	 * This method helps user to take back up of report after test suite execution.
	 */
	public void onFinish(ISuite suite) {
		report.flush();
		test.log(Status.INFO, "==report backup==");
	}

	@Override
	/**
	 * This method helps user to get runtime information when test case starts and
	 * pass the information to extent report.
	 */
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "==>" + result.getMethod().getMethodName() + "<=STARTED=");
		UtilityClassObject.setTest(test);
	}

	@Override
	/**
	 * This method helps user to get runtime information when test case success and
	 * send the log to extent report.
	 */
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "==>" + result.getMethod().getMethodName() + "<=COMPLETED=");
	}

	@Override
	/**
	 * This method helps user to get screenshot and failure status at runtime when
	 * test case fails and sends failure log along with screenshot to extent report.
	 */
	public void onTestFailure(ITestResult result) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getWebDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testName + " " + time);
		test.log(Status.FAIL, "==>" + result.getMethod().getMethodName() + "<=FAILED=");
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
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}
