package com.bpl.hrm.settingstest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bpl.hrm.basetest.BaseClass;
import com.bpl.hrm.objectrepositoryutility.HomePage;
import com.bpl.hrm.objectrepositoryutility.SettingsPage;
import com.bpl.hrm.webdriverutility.UtilityClassObject;
/**
 * This testng class contains test cases for Settings module. 
 * 
 * @author Anant
 */
public class BearerTokenGenerationTest extends BaseClass
{
	@Test(groups="systemTest")
	public void bearerTokenGeneration() throws Throwable 
	{
		HomePage hp=new HomePage(driver);
		hp.getSettingsTab().click();
		UtilityClassObject.getTest().log(Status.INFO,"Navigated to settings page");
		
		/** generate token **/
		SettingsPage sp=new SettingsPage(driver);
		sp.getGenerateBtn().click();
		String source=driver.getPageSource();
		String confirmationMsg="Token Generated Successfully";
		UtilityClassObject.getTest().log(Status.INFO,"Token generated");
		
		/** verification of token generation **/
		String actMsg=driver.findElement(By.xpath("//div[@class='row']//span")).getText();
		String expMsg="Token Generated Successfully";
		Assert.assertEquals(actMsg, expMsg);
		UtilityClassObject.getTest().log(Status.INFO,"Token generated");
	}
}
