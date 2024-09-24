package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains object repository for all the web elements present on the
 * homepage.
 * 
 * @author Anant
 */
public class HomePage {
	WebDriver driver;

	/**
	 * This constructor helps to initialize all the web elements located in this
	 * class.
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[local-name()='svg'  and @class='svg-inline--fa fa-right-from-bracket ']")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	@FindBy(linkText = "Dashboard")
	private WebElement dashboardTab;

	@FindBy(linkText = "Projects")
	private WebElement projectsTab;

	@FindBy(linkText = "Employees")
	private WebElement employeesTab;

	@FindBy(linkText = "Payroll")
	private WebElement payrollTab;

	@FindBy(linkText = "Status")
	private WebElement statusTab;

	@FindBy(linkText = "Manage")
	private WebElement manageTab;

	@FindBy(linkText = "Settings")
	private WebElement settingsTab;

	@FindBy(linkText = "Resources")
	private WebElement resourcesTab;

	@FindBy(linkText = "About")
	private WebElement aboutTab;

	@FindBy(linkText = "Contact Admin")
	private WebElement contactAdmin;

	@FindBy(xpath = "//*[local-name()='svg' and @class='svg-inline--fa fa-users ']")
	private WebElement profilesTab;

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getDashboardTab() {
		return dashboardTab;
	}

	public WebElement getProjectsTab() {
		return projectsTab;
	}

	public WebElement getEmployeesTab() {
		return employeesTab;
	}

	public WebElement getPayrollTab() {
		return payrollTab;
	}

	public WebElement getStatusTab() {
		return statusTab;
	}

	public WebElement getManageTab() {
		return manageTab;
	}

	public WebElement getSettingsTab() {
		return settingsTab;
	}

	public WebElement getResourcesTab() {
		return resourcesTab;
	}

	public WebElement getAboutTab() {
		return aboutTab;
	}

	public WebElement getContactAdmin() {
		return contactAdmin;
	}

	public WebElement getProfilesTab() {
		return profilesTab;
	}
	/**
	 * This method helps user to click on log out button.
	 */
	public void logout() {
		logoutBtn.click();
	}
}
