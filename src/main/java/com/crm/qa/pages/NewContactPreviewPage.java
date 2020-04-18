package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactPreviewPage extends TestBase {
	
	@FindBy(xpath="//i[contains(@class,'red icon')]")
	WebElement redIcon;
	
	public NewContactPreviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateContactPreviewPage() {
		return redIcon.isDisplayed();
	}
}