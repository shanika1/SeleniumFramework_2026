package com.ots.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.ots.dataprovider.ConfigUtility;
import com.ots.factory.BrowserFactory;

public class BaseClass {
	
    public WebDriver driver;
	
	@BeforeMethod
	public void setup() 
	{
		System.out.println("LOG:INFO-Running Before Class");
		
		String browserName=ConfigUtility.readProperty("browser");
		
		String appURL=ConfigUtility.readProperty("qaenv");
		
		driver=BrowserFactory.startBrowser(browserName, appURL+"/login");
	}
	
	@AfterMethod
	public void tearDown() 
	{
		System.out.println("LOG:INFO-Running After Class");
		driver.quit();
		System.out.println("LOG:INFO-Session Closed");
	}

}
