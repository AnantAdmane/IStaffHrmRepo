package com.bpl.hrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains object repository for all the web elements present on the
 * login page.
 * 
 * @author Anant
 */
public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	private WebElement userEdt;
	
	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	@FindBy(id="inputPassword")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInBtn;
	/**
	 * This method helps user to login to application.
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url,String username, String password)
	{
		driver.get(url);
		userEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		signInBtn.click();
	}
}
