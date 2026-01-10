package com.ots.listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.ots.factory.BrowserFactory;
import com.ots.helper.Utility;


public class MyTestNGListners implements ITestListener{
	
	public void onTestSuccess(ITestResult result) 
	{
		
		ChainTestListener.log("LOG:INFO - Test Passed " + result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) 
	{
	    
		ChainTestListener.log("LOG:INFO - Test Failed " + result.getMethod().getMethodName());
		
		ChainTestListener.log("LOG:INFO - Exceptions " + result.getThrowable().getMessage());
		
		String base64=Utility.captureScreenshot(BrowserFactory.getDriver(), "base64");
		
		ChainTestListener.embed(base64,"image/png");
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		    
		ChainTestListener.log("LOG:INFO - Test Skipped " + result.getMethod().getMethodName());
		
		ChainTestListener.log("LOG:INFO - Exceptions " + result.getThrowable().getMessage());
		
	}

}
