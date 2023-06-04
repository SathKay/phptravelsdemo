package com.qa.phptravels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.phptravels.factory.DriverFactory;
import com.qa.phptravels.pages.AccountPage;
import com.qa.phptravels.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	AccountPage accPage;
	
	@BeforeTest
	public void setUp()
	{	
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
