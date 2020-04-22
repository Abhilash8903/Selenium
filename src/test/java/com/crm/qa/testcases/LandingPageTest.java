package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LandingPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
	}
	
	@Test(priority=1, enabled = false)
	public void LandingPageTitleTest() {
		String landingPageTitle = landingPage.validatePageTitle();
		Assert.assertEquals(landingPageTitle,"Free CRM #1 cloud software for any business large or small", "Landing page title does not match");
	}
	
	@Test(priority=2, enabled = false)
	public void freeCRMLogoTest() {
		Assert.assertTrue(landingPage.validateLogo(),"Logo not displayed on landing page");
	}
	
	@Test(priority=3, enabled = false)
	public void LogInBtnClickTest() {
		loginPage = landingPage.loginInclick();
		Assert.assertTrue(loginPage.validateLoginPage(),"Login page is not displayed on clicking the 'Log In' button at landing page");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
