package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtils;

public class LandingPage extends TestBase{
	
		
	@FindBy(xpath="//*[contains(@href,'ui.freecrm.com')]")
	WebElement logInBtn;
	
	@FindBy(xpath="//*[contains(@src,'cogtiny1')]")
	WebElement crmLogo;
	
	public LandingPage(){
		//super();
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return crmLogo.isDisplayed(); 
	}
	
	
	public LoginPage loginInclick() {
		
		TestUtils.customWait_PresenceOfElementLocated(driver, By.xpath("//*[contains(@href,'ui.freecrm.com')]"), ExplicitWait_TimeOut);
		TestUtils.waitForelementToBeVisible(driver, logInBtn, ExplicitWait_TimeOut);
		logInBtn.click();
		return new LoginPage();
	}
}
