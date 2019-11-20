package com.qa.newtours.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {

	public static ChromeOptions getChromeOptions() {
		ChromeOptions cm = new ChromeOptions();
		cm.addArguments("--ignore-certificate-errors");
		cm.addArguments("--disable-popup-blocking");
		cm.addArguments("--incognito");
		
		return cm;
	}
	
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions of = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		of.setCapability(FirefoxDriver.PROFILE, profile);
		
		return of;
		
	}
}
