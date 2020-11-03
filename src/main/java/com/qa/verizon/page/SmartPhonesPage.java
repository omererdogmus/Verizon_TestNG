package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;

public class SmartPhonesPage extends BasePage {

	WebDriver driver;

	// Locators
	By samsungS20 = By.id("tile_dev12920004");

	// Constructor
	public SmartPhonesPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public SamsungS20Page clickOnPhoneLink() {
		driver.findElement(samsungS20).click();
		return new SamsungS20Page(driver);
	}

}
