package com.automator.Modules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginModule {
	
	private WebDriver driver;
	
	public LoginModule(WebDriver driver) {
		this.driver = driver;
	}


	public void enterUsername(String username) {
		 this.driver.findElement(By.id("Email")).sendKeys(username);;
	}
	
	public void enterPassword(String password) {
		 this.driver.findElement(By.id("Password")).sendKeys(password);
	}
	
	public WebElement login() {
		return this.driver.findElement(By.className("login-button"));
	}
	
}
