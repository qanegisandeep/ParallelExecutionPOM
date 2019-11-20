package com.qa.newtours.factory;

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

public class TLDriverFactory {
	
	Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	// set()
	public synchronized static void setTLDriver(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
			
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
		}
	}
	
	// get()
	public synchronized static WebDriver getTLDriver() {
		return tlDriver.get(); // it will return a webdriver instance
	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			
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
		File src = ((TakesScreenshot)getTLDriver()).getScreenshotAs(OutputType.FILE);
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
