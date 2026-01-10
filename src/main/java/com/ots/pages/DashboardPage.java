package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By cart = By.xpath("//button[text()='Cart']");
	
	private By manage = By.xpath("//span[text()='Manage']");
	
	private By manageCourses = By.xpath("//a[normalize-space()='Manage Courses']");
	
	private By manageCategories = By.xpath("//a[normalize-space()='Manage Categories']");
	
	private By sideMenu = By.xpath("//img[@alt='menu']");
	
	private By logout = By.xpath("//button[text()='Sign out']");
	
	private By welcomeMessage = By.className("welcomeMessage");
	
	public void signoutFromApplication() {
		
		driver.findElement(sideMenu).click();
		
		driver.findElement(logout).click();
		
	}
	
	public String getWelcomeMessage() {
		
		String welcomeText = driver.findElement(welcomeMessage).getText();
		
		return welcomeText;
		
	}

}
