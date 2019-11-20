package com.qa.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newtours.factory.TLDriverFactory;
import com.qa.newtours.utility.ElementUtility;

public class RegistrationPage extends TLDriverFactory {
	
	WebDriver driver = TLDriverFactory.getTLDriver();
	ElementUtility elementUtility;
	
	By firstName = By.name("firstName");
	By lastName = By.name("lastName");
	By phone= By.name("phone");
	By useremail = By.id("userName");
	By address1 = By.name("address1");
	By address2 = By.name("address2");
	By city = By.name("city");
	By state = By.name("state");
	By postalCode = By.name("postalCode");
	By username = By.id("email");
	By password = By.name("password");
	By confirmPassword = By.name("confirmPassword");
	By submitForm = By.name("register");
	By signInPage = By.xpath("(//table)[8]//tr[3]/td/p[2]");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForTitlePresent("Register: Mercury Tours", 20);
	}
	
	public String userRegistration() {
		elementUtility.doSendKeys(firstName, "qa");
		elementUtility.doSendKeys(lastName, "testing");
		elementUtility.doSendKeys(phone, "1234567890");
		elementUtility.doSendKeys(useremail, "qa@testing.com");
		elementUtility.doSendKeys(address1, "Lake City");
		elementUtility.doSendKeys(address2, "USA");
		elementUtility.doSendKeys(city, "jekiii");
		elementUtility.doSendKeys(state, "New York");
		elementUtility.doSendKeys(postalCode, "35801");
		elementUtility.doSendKeys(username, "testing");
		elementUtility.doSendKeys(password, "123456");
		elementUtility.doSendKeys(confirmPassword, "123456");
		elementUtility.doClick(submitForm);
		elementUtility.waitForElementPresent(signInPage, 20);
		
		return elementUtility.getText(signInPage);
		
	}
	
	public String title() {
		return elementUtility.getPageTitle();
	}
}
