package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By userName = By.id("email1");
	
	private By password = By.name("password1");
	
	private By signInButton = By.xpath("//button[text()='Sign in']");
	
	private By newUserLink = By.linkText("New user? Signup");
	
	private By heading = By.xpath("//h2[text()='Sign In']");
	
	
	public RegistrationPage clickOnRegistrationLink() {
		
		driver.findElement(newUserLink).click();
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
		
		return registrationPage;
		
	}
	
	public boolean isHeaderPresent() {
		
		boolean status = driver.findElement(heading).isDisplayed();
		
		return status;
		
	}
	
	public DashboardPage loginToApplication(String user, String pass) {
		
		driver.findElement(userName).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signInButton).click();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		
		return dashboardPage;
		
	}

}
