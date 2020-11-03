package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

	WebDriver driver;

	// Locators
	By checkOutText = By.xpath("//h1[contains(text(),'Continue to checkout.')]");

	By phoneName = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/"
			+ "div[7]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/h3[1]/span[1]");

	By dueAmount = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/"
			+ "div[7]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/p[2]");
	

	// Constructor
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void printOutElements() {
		WebElement text1 = driver.findElement(checkOutText);
		WebElement text2 = driver.findElement(phoneName);
		WebElement text3 = driver.findElement(dueAmount);
		System.out.println(text1.getText());
		System.out.println(text2.getText());
		System.out.println(text3.getText());
	}

}
