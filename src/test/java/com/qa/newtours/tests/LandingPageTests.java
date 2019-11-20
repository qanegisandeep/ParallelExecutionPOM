package com.qa.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.newtours.factory.TLDriverFactory;
import com.qa.newtours.pages.NewTourLandingPage;


public class LandingPageTests extends TestBase{

	NewTourLandingPage newTourLandingPage;
		
	@Test
	public void verifyLandingPageTitle() {
			newTourLandingPage = new NewTourLandingPage(TLDriverFactory.getTLDriver());
			Assert.assertEquals(newTourLandingPage.title(), "Welcome: Mercury Tours", "Not on Registration page");
		}
	
}
