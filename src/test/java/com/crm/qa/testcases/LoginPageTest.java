package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	LandingPage landingPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		landingPage = new LandingPage();
		loginPage = landingPage.loginInclick();
				
		homePage= new HomePage();
	}
	
	@Test//(priority=1)
	public void validateLoginPageTitleTest() {
		Assert.assertEquals(loginPage.loginPageTitle(), "Cogmento CRM", "Login page title mismatch");
	}
	
	@Test//(priority=2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.validateHomePage(),true, "Login failed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
