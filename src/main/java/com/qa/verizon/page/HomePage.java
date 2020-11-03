package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.verizon.base.BasePage;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	// Locators
	By shopBtn = By.id("gnav20-Shop-L1");
	By smartPhonesBtn = By.id("gnav20-Shop-L3-1");
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Methods
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public SmartPhonesPage navigateToSmartPhones() {
		Actions actions = new Actions(driver);
		WebElement shop = driver.findElement(shopBtn);
		actions.moveToElement(shop);
		WebElement smartPhones = driver.findElement(smartPhonesBtn);
		actions.moveToElement(smartPhones);
		actions.click().build().perform();
		return new SmartPhonesPage(driver);
	}

}
