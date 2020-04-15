package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
		
	@FindBy(xpath="//*[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[text()='Contacts']")
	WebElement contacts;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHomePage() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickContacts() {
		contacts.click();
		return new ContactsPage();
	}
}
