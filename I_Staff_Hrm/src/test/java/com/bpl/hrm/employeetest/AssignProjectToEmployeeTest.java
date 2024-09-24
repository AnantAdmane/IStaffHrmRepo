package com.bpl.hrm.employeetest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import com.bpl.hrm.webdriverutility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bpl.hrm.basetest.BaseClass;
import com.bpl.hrm.objectrepositoryutility.EmployeePage;
import com.bpl.hrm.objectrepositoryutility.HomePage;

/**
 * This testng class contains test cases for Employee module.
 * 
 * @author Anant
 */
public class AssignProjectToEmployeeTest extends BaseClass {
	@Test(groups = "integrationTest")
	/**
	 * This test method helps to create new employee and assign project.
	 * 
	 * @throws Throwable
	 */
	public void assignProjectToEmployee() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Home Page");
		HomePage hp = new HomePage(driver);
		/** zooming out the home page **/
		wLib.zoomOut();
		UtilityClassObject.getTest().log(Status.INFO, "Employee to Home Page");
		hp.getEmployeesTab().click();
		EmployeePage ep = new EmployeePage(driver);

		/** creating new employee **/
		ep.getAddNewEmpBtn().click();
		String empName = ep.createEmployee();
		UtilityClassObject.getTest().log(Status.INFO, "New Employee created with the name " + empName);

		/** verify employee creation **/
		wLib.waitTillVisibility(driver, driver.findElement(By.xpath("//div[@role='alert']")));
		String actMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		System.out.println("=========" + actMsg + "=========");
		Assert.assertEquals(actMsg, "User " + empName + " Successfully Created");
	}

	@Test(groups = "systemTest")
	/**
	 * This test method represents the test case to modify employee details.
	 * 
	 * @throws Throwable
	 */
	public void modifyEmpDetailsTest() throws Throwable {
		/** reading data from excel **/
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String empName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();
		String empEmail = eLib.getDataFromExcel("Sheet1", 1, 3);
		String empPhone = eLib.getDataFromExcel("Sheet1", 1, 4);
		String empUsername = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String empDesignation = eLib.getDataFromExcel("Sheet1", 1, 6);
		String empExp = eLib.getDataFromExcel("Sheet1", 1, 7);
		String newEmail = eLib.getDataFromExcel("Sheet1", 1, 3);
		String projectIndexString = eLib.getDataFromExcel("Sheet1", 1, 9);
		int intProjectIndex = Integer.parseInt(projectIndexString);

		/** creating new employee **/
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to home page");
		HomePage hp = new HomePage(driver);
		wLib.zoomOut();
		hp.getEmployeesTab().click();
		EmployeePage ep = new EmployeePage(driver);
		ep.getAddNewEmpBtn().click();
		ep.getEmpName().sendKeys(empName);
		ep.getEmpEmail().sendKeys(empEmail);
		ep.getEmpPhone().sendKeys(empPhone);
		ep.getEmpUsername().sendKeys(empUsername);
		ep.getEmpExperience().sendKeys(empExp);
		ep.getEmpDesignation().sendKeys(empDesignation);
		wLib.selectOption(driver, ep.getDropDown(), 3);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Employee Page");
		wLib.waitTillVisibility(driver, ep.getAddBtn());
		ep.getAddBtn().click();

		/** employee verification **/
		wLib.waitTillVisibility(driver, driver.findElement(By.xpath("//div[@role='alert']")));
		String actMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Assert.assertEquals(actMsg, "User " + empName + " Successfully Created");
		UtilityClassObject.getTest().log(Status.INFO, "New Employee added==>" + empName);

		/** modify employee detail **/
		driver.findElement(By.xpath("//tbody/tr/td[text()='" + empUsername + "']/..//td/a[@class='edit']")).click();
		wLib.waitTillVisibility(driver, ep.getEdtBtn());
		ep.getEdtBtn().clear();
		ep.getEdtBtn().sendKeys(newEmail);
		ep.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Employee details edited");

		/** verification for edit **/
		wLib.waitTillVisibility(driver, driver.findElement(By.xpath(
				"//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),' Successfully Updated ')]")));
		String edtConfirmationMsg = driver.findElement(By.xpath(
				"//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),' Successfully Updated ')]"))
				.getText();
		String empId = driver
				.findElement(By.xpath("//tbody/tr[*]/td[text()='" + empName + "']/preceding-sibling::td[1]")).getText();
		Assert.assertEquals(edtConfirmationMsg, empId + " Employee Successfully Updated");

	}
}
