package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By nameField = By.id("name");
	
	private By emailField = By.name("email");
	
	private By passwordField = By.id("password");
	
	private By interest = By.xpath("//label[normalize-space()='AWS']");
	
	private By genderValue = By.xpath("//input[@value='Male']");
	
	private By stateValue = By.id("state");
	
	private By hobbiesValue = By.id("hobbies");
	
	private By signUpButton = By.xpath("//button[text()='Sign up']");
	
	public void enterUserName(String username) {
		
		driver.findElement(nameField).sendKeys(username);
		
	}
	
	public void enterEmail(String email) {
		
		driver.findElement(emailField).sendKeys(email);
		
	}
	
	public void enterPassword(String password) {
		
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void selectInterest() {
		
		driver.findElement(interest).click();
		
	}
	
	public void selectGender() {
		
		driver.findElement(genderValue).click();
	}
	
	public void selectState(String value) {
		
	    Select dropdown = new Select(driver.findElement(stateValue));
		dropdown.selectByVisibleText(value);
		
	}
	
	public void selectHobbies(String value) {
		
		Select dropdown = new Select(driver.findElement(hobbiesValue));
		dropdown.selectByVisibleText(value);
		
	}
	
	public void clickSignUp() {
		
		driver.findElement(signUpButton).click();
	}
	
	/*
	 * public void registerNewUser(String username, String email, String password,
	 * String interest, String gender, String state, String hobbies) {
	 * 
	 * 
	 * }
	 */

}
