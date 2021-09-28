package com.banking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TestCaseLogin extends BaseClass{

	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("Url is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			
			captureScreen(driver,"loginTest");
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTestfailed");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
	}
		
	
}
