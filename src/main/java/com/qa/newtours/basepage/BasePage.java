package com.qa.newtours.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	Properties prop;
	WebDriver driver;

	
	public WebDriver init_driver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("safari")) {
			System.out.println("Safari not configured currently");
		}
		
		else {
			System.out.println(browserName+ "Browser not available");
		}
		
		return driver;
		
	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			
			//FileInputStream ip = new FileInputStream("/Users/sandeepnegi/eclipse-workspace/SplashmathDemoProject11/src/main/java/com/qa/splashmath/config/config.properties");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/newtours/config/config.properties");
			
			prop.load(ip);
		}catch (FileNotFoundException e) {
			System.out.println("Config file missing");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Property file missing");
		}
		
		return prop;
		
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}
