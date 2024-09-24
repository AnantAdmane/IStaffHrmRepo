package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains object repository for all the web elements present on the
 * create object web page.
 * 
 * @author Anant
 */
public class CreateProjectPage {
	WebDriver driver;

	/**
	 * This constructor helps to initialize all the located web elements in this
	 * class.
	 * 
	 * @param driver
	 */
	public CreateProjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "projectName")

	private WebElement projectName;

	@FindBy(name = "createdBy")
	private WebElement managerName;

	@FindBy(xpath = "(//select[@name='status'])[2]")
	private WebElement status;

	public WebElement getProjectName() {
		return projectName;
	}

	public WebElement getManagerName() {
		return managerName;
	}

	public WebElement getStatus() {
		return status;
	}

	@FindBy(xpath = "//input[@value='Add Project']")
	private WebElement addProjectBtn;

	public WebElement getAddProjectBtn() {
		return addProjectBtn;
	}

	/**
	 * This method helps user to click on add project button.
	 */
	public void clickAddProjectBtn() {
		addProjectBtn.click();
	}

	/**
	 * This method method helps user to click on cancel button.
	 */
	public void clickCancelProjectBtn() {
		cancelBtn.click();
	}

	@FindBy(xpath = "(//input[@type='button'])[5]")
	private WebElement cancelBtn;

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
}
