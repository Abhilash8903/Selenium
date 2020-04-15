package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPreviewPage;
import com.crm.qa.util.TestUtils;

public class ContactsPageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	NewContactPreviewPage previewPage;
	
	String sheetname = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.loginInclick();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//Thread.sleep(3000);
		//TestUtils.waitForelementToBeVisible(driver, driver.findElement(By.xpath("//span/a[contains(@href,'contacts')]")), ExplicitWait_TimeOut);
		TestUtils.waitForelementToBeVisible(driver, driver.findElement(By.xpath("//th[text()='Contact']")), ExplicitWait_TimeOut);
		contactsPage = homePage.clickContacts();
		//Thread.sleep(3000);
		
		TestUtils.waitForInvisibilityOfelement(driver, driver.findElement(By.xpath("//span/p[contains(text(),'Loading')]")), ExplicitWait_TimeOut);
	}
	
	@Test(priority=2)
	public void selectContactsByNameTest() throws InterruptedException {
		//driver.navigate().refresh();
		contactsPage.selectContactsByName("Rahul");
	}
	
//	@Test//(priority=2)
//	public void selectMultipleContactsByNameTest() throws InterruptedException {
//		//driver.navigate().refresh();
//		contactsPage.selectContactsByName("Amit");
//		contactsPage.selectContactsByName("Keerthan");
//		contactsPage.selectContactsByName("Abhilash");
//	}
	
	@DataProvider
	public Object[][] createContactTestData() {
		Object data[][] = TestUtils.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=1, dataProvider="createContactTestData")
	public void createContactTest(String fname, String lname, String company, String email) {
		previewPage = contactsPage.createContact(fname, lname, company, email);
		Assert.assertTrue(previewPage.ValidateContactPreviewPage());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
