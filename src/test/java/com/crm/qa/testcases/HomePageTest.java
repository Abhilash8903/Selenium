package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;;

public class HomePageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		landingPage = new LandingPage();
		loginPage = landingPage.loginInclick();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test//(priority=1)
	public void validateHomePageTitleTest() {
		Assert.assertEquals(homePage.validateHomePageTitle(), "Cogmento CRM", "Home Page title does not match");
	}
	
	@Test//(priority=2)
	public void NavigateToContactsTest() {
		contactsPage = homePage.clickContacts();
		Assert.assertEquals(contactsPage.validateContactsPage(), true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
