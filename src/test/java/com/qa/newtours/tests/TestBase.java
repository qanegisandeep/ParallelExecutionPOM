package com.qa.newtours.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.newtours.factory.TLDriverFactory;

public class TestBase {
	
	@Parameters(value={"browser"})
	@BeforeMethod
	public void setUpTest(String browserName) {
		TLDriverFactory.setTLDriver(browserName);
		TLDriverFactory.getTLDriver().get("http://newtours.demoaut.com/");
		TLDriverFactory.getTLDriver().manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDownTest() {
		TLDriverFactory.getTLDriver().quit();
	}


}
