package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * This class contains object repository for all the web elements present on the
 * settings page.
 * 
 * @author Anant
 */
public class SettingsPage {
	WebDriver driver;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement lifespanDropdown;

	@FindBy(xpath = "//button[text()='Generate New Token']")
	private WebElement generateBtn;

	public WebElement getGenerateBtn() {
		return generateBtn;
	}

	public WebElement getLifespanDropdown() {
		return lifespanDropdown;
	}

	/**
	 * This method helps user to select lifespan of dropdown.
	 * 
	 * @param ele
	 * @param text
	 */
	public void selectLifespan(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	/**
	 * This method performs action to click on generate token button.
	 */
	public void clickGenerateBtn() {
		generateBtn.click();
	}

}
