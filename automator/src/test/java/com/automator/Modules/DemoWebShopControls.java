package com.automator.Modules;

import org.openqa.selenium.WebDriver;

public class DemoWebShopControls {
	
	private WebDriver driver;
	
	public DemoWebShopControls(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginModule getLoginPage() {
		return new LoginModule(driver);
	}
	
	public RegistrationPageModule getRegistrationPage() {
		return new RegistrationPageModule(driver);
	}
	
	public NavbarModule getNavbar() {
		return new NavbarModule(driver);
	}

}
