package com.ots.factory;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ots.dataprovider.ConfigUtility;

public class BrowserFactory {
	
	static WebDriver driver = null;
	
	//getter method to get driver of current test
	public static WebDriver getDriver() 
	{
		return driver;
	}

	public static WebDriver startBrowser(String browser, String appUrl) {

		if(browser.equalsIgnoreCase("Chrome") || browser.equalsIgnoreCase("GC") || browser.equalsIgnoreCase("Google Chrome")) {
			
			ChromeOptions opt=new ChromeOptions();
			
			if(ConfigUtility.readProperty("headless").equalsIgnoreCase("true"))
			{
				opt.addArguments("--headless=new");
			}

			driver  = new ChromeDriver(opt);

		}
		else if(browser.equalsIgnoreCase("Firefox") || browser.equalsIgnoreCase("FF") || browser.equalsIgnoreCase("Mozila Firefox")) {

			driver  = new FirefoxDriver();

		}
		else if(browser.equalsIgnoreCase("Edge") || browser.equalsIgnoreCase("Microsoft Edge")) {

			driver  = new EdgeDriver();

		}
		else {

			System.out.println("Sorry - Currently we support only Chrome, Firefox and Edge browsers.");

		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigUtility.readProperty("pageLoadTime"))));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Integer.parseInt(ConfigUtility.readProperty("scriptTimeOut"))));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigUtility.readProperty("implicitWait"))));
		
		driver.manage().window().maximize();

		driver.get(appUrl);

		return driver;

	}
	
	
}
