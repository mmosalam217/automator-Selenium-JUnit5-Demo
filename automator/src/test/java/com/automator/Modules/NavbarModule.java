package com.automator.Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavbarModule {

	private WebDriver driver;

	public NavbarModule(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement register() {
		return this.driver.findElement(By.className("ico-register"));
	}
	
	public WebElement login() {
		return this.driver.findElement(By.className("ico-login"));
	}
	
	public WebElement logout() {
		return this.driver.findElement(By.className("ico-logout"));
	}
	
	public WebElement account() {
		return this.driver.findElement(By.className("account"));
	}
	
	public WebElement cart() {
		return this.driver.findElement(By.className("ico-cart"));
	}
}
