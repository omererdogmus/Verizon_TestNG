package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.util.ElementUtil;

public class CustomizeYourDevicePage {

	WebDriver driver;

	// Locators

	By nextBtn = By.xpath("//button[contains(text(),'Next')]");
	By secondNextBtn = By.xpath("//button[@id='deviceProtectionBtn']");
	By acceptDeviceBtn = By.xpath("//button[@id='deviceSelectProtecionBtn']");

	// Constructor
	public CustomizeYourDevicePage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods

	public String getPageTitle() {
		return driver.getTitle();

	}

	public VerizonPlansPage customizePhone() throws InterruptedException {
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, nextBtn);
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, secondNextBtn);
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, acceptDeviceBtn);
		Thread.sleep(2000);
		return new VerizonPlansPage(driver);

	}

}
