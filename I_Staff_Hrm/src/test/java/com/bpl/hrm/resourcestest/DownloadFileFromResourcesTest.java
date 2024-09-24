package com.bpl.hrm.resourcestest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bpl.hrm.basetest.BaseClass;
import com.bpl.hrm.objectrepositoryutility.HomePage;
import com.bpl.hrm.objectrepositoryutility.ResourcesPage;
import com.bpl.hrm.webdriverutility.UtilityClassObject;
import com.bpl.hrm.objectrepositoryutility.HomePage;
/**
 * This testng class contains test cases for Resources module. 
 * 
 * @author Anant
 */
public class DownloadFileFromResourcesTest extends BaseClass
{
	@Test(groups="integrationTest")
	/**
	 * This method helps to download file from resources
	 * @throws Throwable
	 */
	public void downloadExcelFile() throws Throwable
	{
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to resource page");
		ResourcesPage rp=new ResourcesPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to home page");
		
		/**upload file**/
		HomePage hp=new HomePage(driver);
		hp.getResourcesTab().click();
		String fileName=eLib.getDataFromExcel("Sheet1", 7, 2);
		String path=eLib.getDataFromExcel("Sheet1", 7, 3);
		rp.getUploadFileBtn().click();
		rp.getUploadFile().sendKeys(path);
		rp.getFinalUpload().click();
		UtilityClassObject.getTest().log(Status.INFO,"File Uploaded");
		
		/**download file**/
		String xpath="//td[text()='"+fileName+"']/following-sibling::td/a[@class='download']";
		driver.findElement(By.xpath(xpath)).click();
		
		/**delete file**/
		UtilityClassObject.getTest().log(Status.INFO,"File deleted");
		String deleteXpath="//tbody/tr[*]/td[text()='"+fileName+"']/following-sibling::td/a[@class='delete']";
		driver.findElement(By.xpath(deleteXpath)).click();
		rp.getdeleteBtn().click();
		String xpath1="//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),' Successfully Deleted ')]";
		wLib.waitTillVisibility(driver, driver.findElement(By.xpath(xpath1)));
		String deleteConfirmation=driver.findElement(By.xpath(xpath1)).getText();
		Assert.assertEquals(deleteConfirmation, fileName +" File Successfully Deleted" );
	}
}
