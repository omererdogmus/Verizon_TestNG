package com.qa.verizon.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author omererdogmus
 *
 */

public class ElementUtil {

	// common methods

	/**
	 * This method is used to handle Javascript alert
	 * 
	 * @param driver
	 * @return
	 */

	public static String getAlertText(WebDriver driver) {

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		return text;
	}
	
	/**
	 * 
	 * @param driver
	 * @return
	 */
	
	public static String alertConfirmBoxAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		return text;
	}
	
	/**
	 * 
	 * @param driver
	 * @return
	 */
	
	public static String alertConfirmBoxDismiss(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.dismiss();
		return text;
	}
	
	/**
	 * 
	 * @param driver
	 * @param text
	 * @param click
	 */
	
	public static void promptBoxAlertSendKeys(WebDriver driver,String text,String click) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		if(click.equals("ok")) {
			alert.accept();
		}
		else if(click.equals("cancel")) {
			alert.dismiss();
		}
		else {
			System.out.println("Please enter either ok or cancel");
		}
	}

	/**
	 * This method is used to launch browser
	 * 
	 * @param driver
	 * @param browserName
	 * @return
	 */

	public static WebDriver launchBrowser(WebDriver driver, String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser is not available " + browserName);
		}
		return driver;
	}

	/**
	 * URL
	 * 
	 * @param driver
	 * @param url
	 */

	public static void launchURL(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println("an exception occured while launching url");
		}
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */

	public static WebElement getElement(WebDriver driver, By locator) {

		waitForPresenceOfElement(driver, locator);
		WebElement element = driver.findElement(locator);
		return element;
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 */

	public static void waitForPresenceOfElement(WebDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */

	public static String getPageTitle(WebDriver driver) {

		return driver.getTitle();
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 */

	public static void clickOn(WebDriver driver, By locator) {

		driver.findElement(locator).click();
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @param keys
	 */

	public static void sendKeys(WebDriver driver, By locator, CharSequence... keys) {
		driver.findElement(locator).sendKeys(keys);
	}

	/**
	 * This method is used to take screenshot
	 * 
	 * @param driver
	 * @param pathName
	 * @throws IOException
	 */

	public static void takeScreenShot(WebDriver driver, String pathName) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(pathName);
		FileUtils.copyFile(source, destination);
	}

	/**
	 * 
	 * @param driver
	 */

	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}

	/**
	 * 
	 * @param driver
	 */

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 * @param locator
	 */
	public static void doubleClick(WebDriver driver, WebElement element, By locator) {
		Actions actions = new Actions(driver);
		element = driver.findElement(locator);
		actions.doubleClick(element).perform();
	}

	/**
	 * This method is used to select value from dropdown menu
	 * 
	 * @param driver
	 * @param locator
	 * @param index
	 * @param text
	 */

	public static void selectByIndex(WebDriver driver, By locator, int index, String text) {
		WebElement element = ElementUtil.getElement(driver, locator);
		Select select = new Select(element);
		select.selectByIndex(index);
		if (select.getFirstSelectedOption().getText().equals(text)) {
			System.out.println("Correct Selection");
		} else {
			System.out.println("Incorrect Selection");
		}
	}

	public static void chooseWithoutSelect(WebDriver driver, By locator, String text) {

		List<WebElement> elements = driver.findElements(locator);
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(text)) {
				elements.get(i).click();
			}
		}
	}
	
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectByText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

}

