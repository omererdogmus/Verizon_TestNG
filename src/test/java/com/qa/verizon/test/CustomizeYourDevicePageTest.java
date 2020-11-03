package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.CustomizeYourDevicePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SamsungS20Page;
import com.qa.verizon.page.SmartPhonesPage;
import com.qa.verizon.util.Constant;

public class CustomizeYourDevicePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	SmartPhonesPage smartPhonesPage;
	SamsungS20Page s20Page;
	CustomizeYourDevicePage cDevicePage;
	
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
		cDevicePage = s20Page.preOrderMethod();
		Thread.sleep(1000);
	} 
	
	@Test(priority = 1, description = "verify page title")
	public void verifyPageTitle() {
		String title = cDevicePage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constant.Customize_Your_Device_Page_Title);
	}
	
	@Test(priority = 2, description = "customize device method")
	public void verifyCustomizePhoneSteps() throws InterruptedException {
		cDevicePage.customizePhone();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
