package com.automator.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.automator.Modules.DemoWebShopControls;
import com.automator.Modules.NavbarModule;
import com.automator.Modules.RegistrationPageModule;
import com.automator.configs.BusinessParameters;

import io.github.bonigarcia.seljup.Options;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
@TestMethodOrder(OrderAnnotation.class)
class RegistrationTestCase {

	private WebDriver driver;
	private DemoWebShopControls webshop;
	
	@Options
	private ChromeOptions opts = new ChromeOptions();
	{
		opts.addArguments("keep-alive-for-test");
	}
	
	public RegistrationTestCase(ChromeDriver driver) {
		this.driver = driver;
		this.webshop = new DemoWebShopControls(driver);
	}
	
	@BeforeEach()
	public void initDriver() {
		 
	}
	
	
	
	@Test
	@Order(1)
	void testRegister() throws Exception {
		openBrowser();
		Thread.sleep(3000);
		assertThat(driver.getTitle(), is("Demo Web Shop"));
		NavbarModule navbar = this.webshop.getNavbar();
		navbar.register().click();;
		Thread.sleep(4000);
		RegistrationPageModule register = this.webshop.getRegistrationPage();
		register.selectGender("Male");
		register.enterFirstName("Mahmoud");
		register.enterLastName("Mosalam");
		register.enterEmail(BusinessParameters.USERNAME);
		register.enterPassword(BusinessParameters.PASSWORD);
		register.confirmPassword(BusinessParameters.PASSWORD);
		Thread.sleep(2000);
		register.clickRegister();
		Thread.sleep(5000);
		assertThat(register.success().getText(), is("Your registration completed"));
		register.continueBtn().click();
		Thread.sleep(3000);
		assertThat(navbar.account().getText(), is(BusinessParameters.USERNAME));
		closeBrowser();
	}
	
	@Test
	@Order(2)
	void testRegisterNegative() throws InterruptedException {
		openBrowser();
		Thread.sleep(3000);
		assertThat(driver.getTitle(), is("Demo Web Shop"));
		NavbarModule navbar = this.webshop.getNavbar();
		navbar.register().click();;
		Thread.sleep(4000);
		RegistrationPageModule register = this.webshop.getRegistrationPage();
		register.selectGender("Male");
		register.enterFirstName("Mahmoud");
		register.enterLastName("Mosalam");
		register.enterEmail(BusinessParameters.USERNAME);
		register.enterPassword(BusinessParameters.PASSWORD);
		register.confirmPassword(BusinessParameters.PASSWORD);
		Thread.sleep(2000);
		register.clickRegister();
		Thread.sleep(4000);
		assertThat(register.failure().getText(), is("The specified email already exists"));
		Thread.sleep(3000);
		closeBrowser();
	}
	
	
	void openBrowser() {
		driver.get(BusinessParameters.SUTURL);
		driver.manage().window().maximize();
	}
	
	void closeBrowser() {
		driver.close();
	}
	
	
	

}
