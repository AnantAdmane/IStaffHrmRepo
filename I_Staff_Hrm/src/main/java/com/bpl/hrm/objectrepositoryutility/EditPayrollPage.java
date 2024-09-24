package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains object repository for all the web elements present on the
 * Edit payroll page.
 * 
 * @author Anant
 */
public class EditPayrollPage {
	WebDriver driver;

	/**
	 * This constructor helps to initialize all the located web elements in this
	 * class.
	 * 
	 * @param driver
	 */
	public EditPayrollPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Basic + VDA']/following-sibling::input[@type='text']")
	private WebElement basicPayEdt;

	@FindBy(xpath = "//label[text()='HRA']/following-sibling::input[@class='form-control']")
	private WebElement hraEdt;

	@FindBy(xpath = "//label[text()='Stat-Bonus']/following-sibling::input[@class='form-control']")
	private WebElement statEdt;

	@FindBy(xpath = "//label[text()='LTA']/following-sibling::input[@class='form-control']")
	private WebElement ltaEdt;

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//select[@name='status']")
	private WebElement statusDropdown;

	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement searchDropdown;
	
	@FindBy(xpath="\"//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),'Payroll S')]\"")
	private WebElement actMsg;
	
	public WebElement getActMsg()
	{
		return actMsg;
	}
	public WebElement getBasicPayEdt() {
		return basicPayEdt;
	}

	public WebElement getHraEdt() {
		return hraEdt;
	}

	public WebElement getStatEdt() {
		return statEdt;
	}

	public WebElement getLtaEdt() {
		return ltaEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStatusDropdown() {
		return statusDropdown;
	}

	public WebElement getSearchDropdown() {
		return searchDropdown;
	}
}
