package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.util.ElementUtil;

public class VerizonPlansPage {
	
	WebDriver driver;
	
	// Locators
	By playMoreUnlimitedBtn = By.xpath("//button[@id='\"select-plan-list-view-39385']");
	
	// Constructor
	public VerizonPlansPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Methods
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public ShoppingCartPage selectUnlimitedPlan() {
		ElementUtil.clickOn(driver, playMoreUnlimitedBtn);
		return new ShoppingCartPage(driver);
	}

	
	// switch to iframe
}
