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
import com.qa.verizon.page.ShoppingCartPage;
import com.qa.verizon.page.SmartPhonesPage;
import com.qa.verizon.page.VerizonPlansPage;
import com.qa.verizon.util.Constant;

public class ShoppingCartPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	SmartPhonesPage smartPhonesPage;
	SamsungS20Page s20Page;
	CustomizeYourDevicePage cDevicePage;
	VerizonPlansPage vPlansPage;
	ShoppingCartPage sCartPage;

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
		vPlansPage = cDevicePage.customizePhone();
		sCartPage = vPlansPage.selectUnlimitedPlan();
		Thread.sleep(5000);
	}

	@Test
	public void verifyPageTitle() {
		String title = sCartPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constant.Shopping_Cart_Page_Title);
	}

	@Test
	public void verifyCorrectPhoneSelected() {
		sCartPage.printOutElements();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
