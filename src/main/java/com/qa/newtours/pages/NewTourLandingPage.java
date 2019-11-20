package com.qa.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newtours.factory.TLDriverFactory;
import com.qa.newtours.utility.ElementUtility;

public class NewTourLandingPage extends TLDriverFactory {

	WebDriver driver = TLDriverFactory.getTLDriver();
	ElementUtility elementUtility;
	
	By register = By.linkText("REGISTER");
	By username = By.name("userName");
	By password = By.name("password");
	By signIn = By.name("login");
	
	public NewTourLandingPage(WebDriver driver) {
		this.driver = driver ;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForTitlePresent("Welcome: Mercury Tours", 20);
	}
	
	public void clickRegistration() {
		elementUtility.waitForElementPresent(register, 20);
		elementUtility.doClick(register);
	}
	
	public RegistrationPage goToRegistrationPage() {
		clickRegistration();
		return new RegistrationPage(driver);
	}
	
	public String title() {
		return elementUtility.getPageTitle();
	}
}
