package com.ots.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public static Object[][] getLoginData(){
		
		System.out.println("LOG:INFO-Loading Data From Excel");
		
		Object[][] arr=ExcelUtility.getData("LoginDetails");
		
		System.out.println("LOG:INFO-Test Data is Ready");
		
		return arr;
		
	}


}
