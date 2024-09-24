package com.bpl.hrm.projectstest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bpl.hrm.basetest.BaseClass;
import com.bpl.hrm.objectrepositoryutility.CreateProjectPage;
import com.bpl.hrm.objectrepositoryutility.HomePage;
import com.bpl.hrm.objectrepositoryutility.ProjectsPage;
import com.bpl.hrm.webdriverutility.UtilityClassObject;
/**
 * This testng class contains test cases for Projects module. 
 * 
 * @author Anant
 */
public class ProjectsTest extends BaseClass
{
	@Test(groups="smokeTest")
	/**
	 * This test method contain test case to delete project.
	 * @throws Throwable
	 */
	public void deleteProject() throws Throwable
	{
		wLib.zoomOut();
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to Home Page");
		HomePage hp=new HomePage(driver);
		hp.getProjectsTab().click();
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to Project Page");
		ProjectsPage pp=new ProjectsPage(driver);
		pp.getCreateProject().click();
		
		/**reading test script data from excel sheet**/
		CreateProjectPage cpp=new CreateProjectPage(driver);
		String projectName1=eLib.getDataFromExcel("Sheet3", 1, 1)+jLib.getRandomNumber();
		String managerName=eLib.getDataFromExcel("Sheet3", 1, 2);
		
		/**create new project**/
		cpp.getProjectName().sendKeys(projectName1);
		cpp.getManagerName().sendKeys(managerName);
		String projectStatus=eLib.getDataFromExcel("Sheet3", 1, 3);
		wLib.selectOption(projectStatus, driver, cpp.getStatus());
		cpp.getAddProjectBtn().click();	
		UtilityClassObject.getTest().log(Status.INFO,"Project Created==> "+projectName1);
		wLib.waitTillnvisibility(driver, driver.findElement(By.xpath("//div[@role='alert']")));
		wLib.selectOption(driver,pp.getSearchProjectDropdown() ,"projectName" );
		pp.getSearchBar().sendKeys(projectName1);
		
		/**delete project**/
		driver.findElement(By.xpath("//tbody/tr[*]/td[text()='"+projectName1+"']/following-sibling::td/a[@class='delete']")).click();
		wLib.waitForElementPresent(driver, pp.getDeletePopUp());
		pp.getDeletePopUp().click();
		UtilityClassObject.getTest().log(Status.INFO,"Project Deleted==> "+projectName1);
		String actMsg=driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),'Project Successfully Deleted ')]")).getText();
		
		/**verify project deleted**/
		Assert.assertEquals(actMsg, projectName1+" Project Successfully Deleted");
	}
	
	@Test(groups="smokeTest")
	/**
	 * This test method contain test case to export projects details in pdf file.
	 * @throws Throwable
	 */
	public void exportProjectDetails() throws InterruptedException
	{
	UtilityClassObject.getTest().log(Status.INFO,"Navigate to home page");
	HomePage hp=new HomePage(driver);
	hp.getProjectsTab().click();
	UtilityClassObject.getTest().log(Status.INFO,"Navigate to projects page");
	ProjectsPage pp=new ProjectsPage(driver);
	pp.getExportProjects().click();
	wLib.selectOption(driver, pp.getFileFormatDropdown(), "pdf");
	pp.getDownloadBtn().click();
	UtilityClassObject.getTest().log(Status.INFO,"pdf file Downloaded");
	}
}

