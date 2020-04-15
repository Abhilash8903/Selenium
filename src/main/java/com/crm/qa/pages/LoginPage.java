package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement LogInBtn;
	
	public LoginPage(){
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPage() {
		return username.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un); //prop.getProperty("username")
		password.sendKeys(pwd); //prop.getProperty("password")
		LogInBtn.click();
		return new HomePage();
	}
}
