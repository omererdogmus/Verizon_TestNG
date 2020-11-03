package com.qa.verizon.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.util.Constant;

public class HomePageTest {

	HomePage homepage;
	WebDriver driver;
	BasePage basePage;
	Properties properties;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		homepage = new HomePage(driver);
	}

	@Test(priority = 1, description = "verify home page title")
	public void verifyPageTitle() {
		String title = homepage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constant.Home_Page_Title);
	}

	@Test(priority = 2, description = "navigate to smartphone page")
	public void navigateToSmartPhonePage() {
		homepage.navigateToSmartPhones();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
