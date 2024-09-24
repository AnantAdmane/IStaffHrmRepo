package com.bpl.hrm.payrolltest;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.crypto.spec.OAEPParameterSpec;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bpl.hrm.basetest.BaseClass;
import com.bpl.hrm.objectrepositoryutility.EditPayrollPage;
import com.bpl.hrm.objectrepositoryutility.EmployeePage;
import com.bpl.hrm.objectrepositoryutility.HomePage;
import com.bpl.hrm.webdriverutility.UtilityClassObject;
/**
 * This testng class contains test cases for payroll module. 
 * 
 * @author Anant
 */
public class UpdatePayrollTest extends BaseClass
{
	@Test(groups="systemTest")
	/**
	 * This testng method performs the functionality to create employee and active payroll.
	 * @throws Throwable
	 */
	public void updatePayroll() throws Throwable
	{
		HomePage hp=new HomePage(driver);	
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		wLib.zoomOut();
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to Employee Page");
		
		/** navigate to employee page **/
		hp.getEmployeesTab().click();
		EmployeePage ep=new EmployeePage(driver);
		ep.getAddNewEmpBtn().click();
		String empName=ep.createEmployee();
		String xpath="//tbody/tr[*]/td[text()='"+empName+"']/following-sibling::td/a";
		wLib.waitTillVisibility(driver, driver.findElement(By.xpath("//div[@role='alert']")));
		String actMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Assert.assertEquals(actMsg, "User " + empName + " Successfully Created");
		UtilityClassObject.getTest().log(Status.INFO,"New Employee created "+empName);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to Payroll");
		hp.getPayrollTab().click();
		driver.findElement(By.xpath(xpath)).click();
		UtilityClassObject.getTest().log(Status.INFO,"Read payroll data from excel");
		EditPayrollPage epay=new EditPayrollPage(driver);
		
		/** create payroll for employee **/
		String basic=eLib.getDataFromExcel("Sheet2", 1, 2);
		String hra=eLib.getDataFromExcel("Sheet2", 1, 3);
		String lta=eLib.getDataFromExcel("Sheet2", 1, 4);
		String state=eLib.getDataFromExcel("Sheet2", 1, 5);
		epay.getBasicPayEdt().sendKeys(basic);
		epay.getHraEdt().sendKeys(hra);
		epay.getLtaEdt().sendKeys(lta);
		epay.getStatEdt().sendKeys(state);
		wLib.selectOption(driver,epay.getStatusDropdown(),"Active");
		epay.getSaveBtn().click();
		
		/** verify payroll updated **/
		String actMsg1=driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),'Payroll S')]")).getText();
		String xpathPayroll="//tbody/tr[*]/td[text()='"+empName+"']/following-sibling::td[4]";
		String actStatus = driver.findElement(By.xpath(xpathPayroll)).getText();
		Assert.assertEquals(actStatus, "Active");
		String empId=driver.findElement(By.xpath("//tbody/tr[*]/td[text()='"+empName+"']/preceding-sibling::td")).getText();
		Assert.assertEquals(actMsg1, empId+" Payroll Successfully Updated");
	}
}
