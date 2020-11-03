package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.util.ElementUtil;

public class SamsungS20Page {

	WebDriver driver;

	// Locators
	By blackColor = By.xpath("//body/div[@id='content']/div[1]/div[1]/div[1]/div[1]/div[3]/"
			+ "div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]");

	By phoneSize = By.xpath("//p[contains(text(),'128GB')]");

	By paymentOptionBtn = By.xpath("//body/div[@id='content']/div[1]/div[1]/div[1]/div[1]/div[3]/"
			+ "div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");

	By promotionBtn = By
			.xpath("//body/div[@id='content']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/"
					+ "div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]");

	By continueBtn = By.xpath("//button[@id='ATC-Btn']");
	By zipCode = By.xpath("//input[@id='zipcode']");
	By confirmLocationBtn = By.xpath("//button[contains(text(),'Confirm Location')]");
	By newCustomerBtn = By.xpath("//button[contains(text(),'New Customer')]");

	// Constructor
	public SamsungS20Page(WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	public String getPageTitle() {
		return driver.getTitle();
	}

	public CustomizeYourDevicePage preOrderMethod() throws InterruptedException {
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, blackColor);
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, phoneSize);
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, paymentOptionBtn);
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, promotionBtn);
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, continueBtn);
		Thread.sleep(2000);
		ElementUtil.sendKeys(driver, zipCode, "07094");
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, confirmLocationBtn);
		Thread.sleep(2000);
		ElementUtil.clickOn(driver, newCustomerBtn);
		Thread.sleep(2000);
		return new CustomizeYourDevicePage(driver);
	}

}
