package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bpl.hrm.fileutility.ExcelUtility;
import com.bpl.hrm.webdriverutility.JavaUtility;
import com.bpl.hrm.webdriverutility.WebDriverUtility;

/**
 * This class contains object repository for all the web elements present on the
 * employee web page.
 * 
 * @author Anant
 */
public class EmployeePage {
	WebDriver driver;

	/**
	 * This constructor helps to initialize all the located web elements in this
	 * class.
	 * 
	 * @param driver
	 */
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add New Employee']")
	private WebElement addNewEmpBtn;

	@FindBy(xpath = "//label[text()='Name*']/following-sibling::input")
	private WebElement empName;

	public WebElement getEmpName() {
		return empName;
	}

	@FindBy(xpath = "//label[text()='Email*']/following-sibling::input")
	private WebElement empEmail;

	public WebElement getEmpEmail() {
		return empEmail;
	}

	@FindBy(xpath = "//label[text()='Phone*']/following-sibling::input")
	private WebElement empPhone;

	public WebElement getEmpPhone() {
		return empPhone;
	}

	@FindBy(xpath = "//label[text()='Username*']/following-sibling::input")
	private WebElement empUserName;

	public WebElement getEmpUsername() {
		return empUserName;
	}

	@FindBy(xpath = "//label[text()='Designation*']/following-sibling::input")
	private WebElement empDesignation;

	public WebElement getEmpDesignation() {
		return empDesignation;
	}

	@FindBy(xpath = "//label[text()='Experience*']/following-sibling::input")
	private WebElement empExperience;

	public WebElement getEmpExperience() {
		return empExperience;
	}

	@FindBy(name = "project")
	private WebElement dropDown;

	public WebElement getDropDown() {
		return dropDown;
	}

	@FindBy(xpath = "//input[@value='Add']")
	private WebElement addBtn;

	public WebElement getAddBtn() {
		return addBtn;
	}

	@FindBy(xpath = "//input[@type='email']")
	private WebElement edtBtn;

	public WebElement getEdtBtn() {
		return edtBtn;
	}

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement confirmMsg;

	public WebElement getConfirmMsg() {
		return confirmMsg;
	}

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAddNewEmpBtn() {
		return addNewEmpBtn;
	}

	/**
	 * This method helps to create new employee
	 * 
	 * @param empName
	 * @param empEmail
	 * @param empPhoneNo
	 * @param empUsernamets
	 * @param designation
	 * @param empExp
	 * @param index
	 * @throws Throwable
	 */
	public String createEmployee() throws Throwable {
		/** reading data from excel sheet **/
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String empName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();
		String empEmail = eLib.getDataFromExcel("Sheet1", 1, 3);
		String empPhone = eLib.getDataFromExcel("Sheet1", 1, 4);
		String empUsername = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String empDesignation = eLib.getDataFromExcel("Sheet1", 1, 6);
		String empExp = eLib.getDataFromExcel("Sheet1", 1, 7);
		String newEmail = eLib.getDataFromExcel("Sheet1", 1, 3);
		String projectIndexString = eLib.getDataFromExcel("Sheet1", 1, 9);
		int intProjectIndex = Integer.parseInt(projectIndexString);
		/** sendind data to create employee **/
		getEmpName().sendKeys(empName);
		getEmpEmail().sendKeys(empEmail);
		getEmpPhone().sendKeys(empPhone);
		getEmpUsername().sendKeys(empUsername);
		getEmpExperience().sendKeys(empExp);
		getEmpDesignation().sendKeys(empDesignation);
		Select s = new Select(getDropDown());
		s.selectByIndex(intProjectIndex);
		Actions ac=new Actions(driver);
		ac.scrollToElement(addBtn);
		getAddBtn().click();
		return empName;
	}
}
