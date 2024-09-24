package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains object repository for all the web elements present on the
 * projects page.
 * 
 * @author Anant
 */
public class ProjectsPage {
	WebDriver driver;

	public ProjectsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement searchProjectDropdown;

	@FindBy(xpath = "//span[text()='Create Project']")
	private WebElement createProject;

	@FindBy(xpath = "//span[text()='Export Projects']")
	private WebElement exportProjects;

	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement dropdownele;

	@FindBy(xpath = "//input[@placeholder='Search by Project Id']")
	private WebElement searchProjectEdt;

	@FindBy(xpath = "//span[text()='Export Projects']")
	private WebElement exprortProject;

	@FindBy(xpath = "//input[@placeholder='Search by Project Name']")
	private WebElement searchBar;

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchProjectDropdown() {
		return searchProjectDropdown;
	}

	public WebElement getCreateProject() {
		return createProject;
	}

	public WebElement getExportProjects() {
		return exportProjects;
	}

	public WebElement getDropdownele() {
		return dropdownele;
	}

	public WebElement getSearchProjectEdt() {
		return searchProjectEdt;
	}

	public WebElement getExprortProject() {
		return exprortProject;
	}

	@FindBy(id = "fileType")
	private WebElement fileFormatDropdown;

	public WebElement getFileFormatDropdown() {
		return fileFormatDropdown;
	}

	@FindBy(xpath = "//button[text()='Download File']")
	private WebElement downloadBtn;

	public WebElement getDownloadBtn() {
		return downloadBtn;
	}

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deletePopUp;

	public WebElement getDeletePopUp() {
		return deletePopUp;
	}
	/**
	 * This method helps user to click on download button.
	 */
	public void clickOnDownloadButton() {
		downloadBtn.click();
	}
	/**
	 * This method helps user to click on delete button.
	 */
	public void clickOnDeletePopUp() {
		deletePopUp.click();
	}
}
