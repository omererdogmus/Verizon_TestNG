package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartPhonesPage;
import com.qa.verizon.util.Constant;

public class SmartPhonesPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	SmartPhonesPage smartPhonesPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		homePage = new HomePage(driver);
		smartPhonesPage = homePage.navigateToSmartPhones();
		Thread.sleep(1000);
	}
	
	@Test(priority = 1, description = "verify page title")
	public void getPageTitle() {
		String title = smartPhonesPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constant.SmartPhone_Page_Title);
	}
	
	@Test(priority = 2, description = "selecting samsung s20 phone")
	public void clickOnLgPhone() {
		smartPhonesPage.clickOnPhoneLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
