package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains object repository for all the web elements present on the
 * resources page.
 * 
 * @author Anant
 */
public class ResourcesPage {
	WebDriver driver;

	public ResourcesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Upload File']")
	private WebElement uploadFileBtn;

	public WebElement getUploadFileBtn() {
		return uploadFileBtn;
	}

	@FindBy(id = "upload-file")
	private WebElement uploadFile;

	public WebElement getUploadFile() {
		return uploadFile;
	}

	@FindBy(xpath = "//button[text()='Upload File']")
	private WebElement finalUpload;

	public WebElement getFinalUpload() {
		return finalUpload;
	}

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;

	public WebElement getdeleteBtn() {
		return deleteBtn;
	}
	/**
	 * This method helps user to click on delete button.
	 */
	public void clickOnDeletePopUp() {
		deleteBtn.click();
	}

}
