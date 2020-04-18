package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtils;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//button[text()='Export']")
	WebElement exportBtn;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement newBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath="//div[@name='company']/input")
	WebElement company;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	WebElement element;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactsPage() {
		return exportBtn.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		
		element = driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]/preceding-sibling::td/div/input"));
		
		//TestUtils.customWait_PresenceOfElementLocated(driver, By.xpath("//td[contains(text(),'"+name+"')]/preceding-sibling::td/div/input") , ExplicitWait_TimeOut);
		//System.out.println("Printing contact name: " + driver.findElement(By.xpath("//tr[4]/td/following-sibling::td")).getText());
		
		TestUtils.clickUsingJavaScript(element);
        		
		
		//element.click();
	}
	
	public boolean contactSelectedValidation(String name) {
		return element.isSelected();
	}
	
	public NewContactPreviewPage createContact(String fname, String lname, String Company, String email) {
		
		newBtn.click();
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(Company);
		TestUtils.customWait_PresenceOfElementLocated(driver, By.xpath("//div[@name='company']//div/span"), ExplicitWait_TimeOut);
		driver.findElement(By.xpath("//div[@name='company']//div/span")).click();
		
		this.email.sendKeys(email);
		
		saveBtn.click();
		return new NewContactPreviewPage();
	}
}
