package com.qa.verizon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties properties;

	public WebDriver init_driver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
		}

		else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}

		else {
			System.out.println("Browser not found!");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}
	
	public Properties init_properties() {
		
		properties = new Properties();
		String path = "/Users/omererdogmus/Documents/eclipse-workspace/TestNG_Verizon2020/"
				+ "src/main/java/com/qa/verizon/config/config.properties";
		
		try {
			FileInputStream ip = new FileInputStream(path);
			properties.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Some issue with config properties... Please correct your config...!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

}
