package com.qa.newtours.tests;


import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.newtours.factory.TLDriverFactory;
import com.qa.newtours.pages.NewTourLandingPage;
import com.qa.newtours.pages.RegistrationPage;


public class RegistrationPageTests extends TestBase{
	
	NewTourLandingPage newTourLandingPage ;
	RegistrationPage registrationPage;
	
	@Test
	public void verifyUserRegistrationTest() {
		newTourLandingPage = new NewTourLandingPage(TLDriverFactory.getTLDriver());
		registrationPage = newTourLandingPage.goToRegistrationPage();
		Assert.assertEquals(registrationPage.userRegistration(), "Thank you for registering. You may now sign-in using the user name and password you've just entered.", "Registration failed");
	}
	
	@Test
	public void verifyRegistrationPageTitleTest() {
		newTourLandingPage = new NewTourLandingPage(TLDriverFactory.getTLDriver());
		registrationPage = newTourLandingPage.goToRegistrationPage();
		Assert.assertEquals(registrationPage.title(), "Register: Mercury Tours", "Not on Registration page");
	}
	
}
