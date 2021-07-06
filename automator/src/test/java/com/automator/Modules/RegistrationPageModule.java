package com.automator.Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageModule {

	private WebDriver driver;
	
	public RegistrationPageModule(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectGender(String gender) {
		if(gender.toLowerCase().equals("male")) {
			driver.findElement(By.id("gender-male")).click();
		}else if(gender.toLowerCase().equals("female")) {
			driver.findElement(By.id("gender-female")).click();
		}else {
			throw new IllegalArgumentException(gender + " is not an option.");
		}
	}
	
	public void enterFirstName(String firstname) {
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		driver.findElement(By.id("LastName")).sendKeys(lastname);
	}
	
	
	public void enterEmail(String email) {
		driver.findElement(By.id("Email")).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.id("Password")).sendKeys(password);
	}
	
	public void confirmPassword(String password) {
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
	}
	
	
	public void clickRegister() {
		driver.findElement(By.id("register-button")).click();
	}
	
	public WebElement continueBtn() {
		return this.driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input"));
	}
	
	public WebElement success() {
		return driver.findElement(By.className("result"));
	}
	
	public WebElement failure() {
		return this.driver.findElement(By.xpath("//*[text()='The specified email already exists']"));
		
	}

}
