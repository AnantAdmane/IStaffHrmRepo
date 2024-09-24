package com.bpl.hrm.webdriverutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains the web driver reusable methods.
 * 
 * @author Anant
 */
public class WebDriverUtility {
	public void waitTillVisibility(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitTillnvisibility(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	/**
	 * This method helps user to zoom out the web page
	 * 
	 * @throws Throwable
	 */
	public void zoomOut() throws Throwable {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
	}
	
	/**
	 * This methods helps user to give explicit wait based on the visibility of web
	 * element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method provides the functionality of implicit wait.
	 * 
	 * @param driver
	 * @param duration
	 */
	public void waitForPageToLoad(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	/**
	 * This method helps to perform switching windows based on partial url.
	 * 
	 * @param driver
	 * @param partialUrl
	 */
	public void switchTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it = allwin.iterator();
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	/**
	 * This method helps to switch windows based on title of the page.
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * This method helps user to switch the frame by index.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method helps user to switch the frame by frame element.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	/**
	 * This method helps user to switch the frame by frame title.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, String title) {
		driver.switchTo().frame(title);
	}

	/**
	 * This method helps user to perform mouse hovering actions.
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverClick(WebDriver driver, WebElement ele) {
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).click().build().perform();
	}

	/**
	 * This method helps user to perform mouse double click actions.
	 * 
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.doubleClick().perform();
		;
	}

	/**
	 * This method helps user to select option from dropdown based on index.
	 * 
	 * @param driver
	 * @param ele
	 * @param index
	 */
	public void selectOption(WebDriver driver, WebElement ele, int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
	}

	/**
	 * This method helps user to select option from dropdown based on text.
	 * 
	 * @param driver
	 * @param ele
	 * @param index
	 */
	public void selectOption(String text, WebDriver driver, WebElement ele) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	/**
	 * This method helps user to select option from dropdown based on value.
	 * 
	 * @param driver
	 * @param ele
	 * @param index
	 */
	public void selectOption(WebDriver driver, WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}

	/**
	 * This method performs scroll by operation.
	 * 
	 * @param driver
	 * @param ele
	 */
	public void scrollToEle(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollIntoView(true)", ele);
	}
}
