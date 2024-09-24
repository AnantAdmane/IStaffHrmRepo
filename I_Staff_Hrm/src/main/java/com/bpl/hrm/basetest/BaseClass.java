package com.bpl.hrm.basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bpl.hrm.databaseutility.DataBaseUtility;
import com.bpl.hrm.fileutility.ExcelUtility;
import com.bpl.hrm.fileutility.FileUtility;
import com.bpl.hrm.objectrepositoryutility.HomePage;
import com.bpl.hrm.objectrepositoryutility.LoginPage;
import com.bpl.hrm.webdriverutility.JavaUtility;
import com.bpl.hrm.webdriverutility.UtilityClassObject;
import com.bpl.hrm.webdriverutility.WebDriverUtility;

import lombok.experimental.UtilityClass;

/**
 * This class contains implementation for testng configuration annotations.
 * 
 * @author Anant
 */
@Listeners(com.bpl.hrm.listenerutility.ListImpClass.class)

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	/** This method helps user make connection with database **/
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		System.out.println("==connect to DB,Report config==");
		dLib.getDbconnection();
	}

	/** This method helps user to launch the browser **/
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)//(groups = { "smokeTest", "regressionTest","integrationTest","systemTest" })
	public void configBC( /*String BROWSER*/ ) throws Throwable {
		System.out.println("==Launch the Browser==");
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equals("edge"))
			driver = new EdgeDriver();
		else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		driver.manage().window().maximize();
		UtilityClassObject.setDriver(driver);
		wLib.waitForPageToLoad(driver, 10);
	}

	/**
	 * This method helps user to log in to application by getting credentials from
	 * from properties file or maven parameter
	 **/
	@BeforeMethod(alwaysRun = true)//(groups = { "smokeTest", "regressionTest","integrationTest","systemTest" })
	public void configBM() throws Throwable {
		System.out.println("==Login==");
		LoginPage lp = new LoginPage(driver);
		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	/** This method helps user to logout from app **/
	@AfterMethod(alwaysRun = true)//(groups = { "smokeTest", "regressionTest","integrationTest","systemTest" })
	public void configAM() throws Throwable {
		System.out.println("==logout==");
		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		//wLib.waitTillnvisibility(driver,driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),' Employee Successfully Updated ')]")));
		wLib.waitForElementPresent(driver, hp.getLogoutBtn());
		// wLib.mouseHoverAction(driver, hp.getLogoutBtn());
		//driver.findElement(By.cssSelector("div[class='user-icon']")).click();
		hp.getLogoutBtn().click();
		// hp.logout();
	}

	/** This method helps user to close the browser **/
	@AfterClass(alwaysRun = true)//(groups = { "smokeTest", "regressionTest","integrationTest","systemTest" })
	public void configAC() {
		System.out.println("==close browser==");
		driver.quit();
	}

	/** This method helps user close database connection **/
	@AfterSuite(alwaysRun = true)//(groups = { "smokeTest", "regressionTest","integrationTest","systemTest" })
	public void configAS() throws Throwable {
		System.out.println("==close db,report backup==");
		dLib.closeDbConnection();
	}

}
