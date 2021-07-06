package com.automator.tests;



import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.automator.Modules.DemoWebShopControls;
import com.automator.Modules.LoginModule;
import com.automator.Modules.NavbarModule;
import com.automator.configs.BusinessParameters;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SeleniumJupiter.class)
@TestMethodOrder(OrderAnnotation.class)
public class LoginTest {
	
	private WebDriver driver;
	private DemoWebShopControls demowebshop;
	
	public LoginTest(WebDriver driver) {
		this.driver = driver;
		this.demowebshop = new DemoWebShopControls(this.driver);
	}
	
	void openBrowser() {
		driver.get(BusinessParameters.SUTURL);
		driver.manage().window().maximize();
	}
	
	void closeBrowser() {
		driver.close();
	}
	
	@Test()
	@Order(1)
	public void testLogin() throws InterruptedException {
		openBrowser();
		Thread.sleep(2000);
		assertThat(driver.getTitle(), is("Demo Web Shop"));
		NavbarModule navbar = demowebshop.getNavbar();
		navbar.login().click();
		Thread.sleep(4000);
		LoginModule loginForm = demowebshop.getLoginPage();
		loginForm.enterUsername(BusinessParameters.USERNAME);
		loginForm.enterPassword(BusinessParameters.PASSWORD);
		loginForm.login().click();
		Thread.sleep(5000);
		assertThat(navbar.account().getText(), is(BusinessParameters.USERNAME));
		Thread.sleep(2000);
	}
}
