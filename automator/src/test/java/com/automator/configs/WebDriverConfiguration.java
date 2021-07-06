package com.automator.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverConfiguration {
	private final String browser = BusinessParameters.BROWSER;
	
	public WebDriver getDriver() throws Exception {
		WebDriver driver = null;
		
		if(this.browser.toLowerCase().equals("chrome")) {
		 	System.setProperty("webdriver.chrome.driver","C:\\Users\\8418\\chromedriver.exe");
	    	driver = new ChromeDriver();
		}else if(this.browser.toLowerCase().equals("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\8418\\msedgedriver.exe");
	    	driver = new EdgeDriver();
		}else {
			throw new Exception("Browser not supported!");
		}
		return driver;
	}
	
	public String getSutURL() {
		return BusinessParameters.SUTURL;
	}
}
