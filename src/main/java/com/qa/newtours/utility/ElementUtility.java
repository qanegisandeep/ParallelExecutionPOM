package com.qa.newtours.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtility {

	WebDriver driver ;
	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return element ;
	}
	
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void waitForElementPresent(By locator , int time) {
		WebDriverWait wait = new WebDriverWait(driver ,time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForTitlePresent(String title , int time) {
		WebDriverWait wait = new WebDriverWait(driver ,time);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	
	
	public String getText(By locator) {
		String elementText = null;
		try {
			elementText = getElement(locator).getText();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return elementText;
	}
	
	public String getCurrentUrl() {
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return currentUrl;
	}
	
	public String  getPageTitle() {
		return driver.getTitle();
	}
}
