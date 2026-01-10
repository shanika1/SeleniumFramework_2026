package com.ots.helper;

import java.awt.desktop.ScreenSleepEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v141.page.model.Screenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver) {
		
		try {
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"/ScreenShots/Screenshot_"+Utility.getCurrentDateTime()+".png"));
			
			System.out.println("Captured Sceenshot "+System.getProperty("user.dir")+"/ScreenShots/Screenshot_"+Utility.getCurrentDateTime()+".png");
		
			
		} catch (IOException e) {
			
			System.out.println("Failed to capture screenshot" + e.getMessage());
		}
	}
	
	public static String captureScreenshot(WebDriver driver,String type) 
	{
		String screenshot=null;
		
		if(type.equalsIgnoreCase("base64")) 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			
		    screenshot=ts.getScreenshotAs(OutputType.BASE64);
			
		}
        return screenshot;
		
	}
	
	public static String getCurrentDateTime() {
		
		Date currentDate = new Date();
		
		SimpleDateFormat currentDateFormat = new SimpleDateFormat("dd_MM_yyyy_ss_mm_HH");
		
		String date = currentDateFormat.format(currentDate);
		
		return date;
		
	}
	
	
	
	public static void selectValuesFromList(WebDriver driver, String xpathExp, String valueToSelect, String year, String month) {
		
		boolean status = true;
		
		while(status) {
			
			String yearText = driver.findElement(By.className("ui-datepicker-year")).getText();
			
			String monthText = driver.findElement(By.className("ui-datepicker-month")).getText();
			
			if(yearText.equalsIgnoreCase(year) && monthText.equalsIgnoreCase(month)) {

			List<WebElement> allElements = driver.findElements(By.xpath(xpathExp));

			for(WebElement ele: allElements) {

				String elementText = ele.getText();

				System.out.println("Current Dates are " + elementText);

				if(elementText.equalsIgnoreCase(valueToSelect)) {

					ele.click();
					break;
				}
			}	
			
		}
			
		}

	}

	public static void selectValuesFromList(WebDriver driver, String xpathExp, String valueToSelect) {

		List<WebElement> allElements = driver.findElements(By.xpath(xpathExp));

		for(WebElement ele: allElements) {

			String elementText = ele.getText();

			System.out.println("Current Dates are " + elementText);

			if(elementText.equalsIgnoreCase(valueToSelect)) {

				ele.click();
				break;
			}
		}	

	}

	public static void selectValuesFromList(WebDriver driver, By element, String valueToSelect) {

		List<WebElement> allElements = driver.findElements(element);

		for(WebElement ele: allElements) {

			String elementText = ele.getText();

			System.out.println("Current Dates are " + elementText);

			if(elementText.equalsIgnoreCase(valueToSelect)) {

				ele.click();
				break;
			}
		}	

	}

	public static WebDriver startBrowser(String appUrl) {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(appUrl);

		return driver;

	}

	public static WebDriver startBrowser(String browser, String appUrl) {

		WebDriver driver = null;

		if(browser.equalsIgnoreCase("Chrome")) {

			driver  = new ChromeDriver();

		}
		else if(browser.equalsIgnoreCase("Firefox")) {

			driver  = new FirefoxDriver();

		}
		else if(browser.equalsIgnoreCase("Edge")) {

			driver  = new EdgeDriver();

		}
		else {

			System.out.println("Sorry - Currently we support only Chrome, Firefox and Edge browsers.");

		}

		driver.get(appUrl);

		return driver;

	}

}
