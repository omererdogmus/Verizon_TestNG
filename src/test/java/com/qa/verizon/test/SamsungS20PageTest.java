package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SamsungS20Page;
import com.qa.verizon.page.SmartPhonesPage;
import com.qa.verizon.util.Constant;

public class SamsungS20PageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	SmartPhonesPage smartPhonesPage;
	SamsungS20Page s20Page;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		homePage = new HomePage(driver);
		smartPhonesPage = homePage.navigateToSmartPhones();
		s20Page = smartPhonesPage.clickOnPhoneLink();
		Thread.sleep(1000);
	}

	@Test(priority = 1, description = "verify page title")
	public void getPageTitle() {
		String title = s20Page.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constant.Samsung_S20_Page_Title);
	}
	
	@Test(priority = 2, description = "order button,zip code,location,new customer")
	public void preOrderComponents() throws InterruptedException {
		s20Page.preOrderMethod();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
