package com.banking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class AddNewCustomer_03 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.ClickAddNewCustomer();
		addcust.custName("Muhaiminul");
		addcust.custgender("male");
		addcust.custdob("10","12","1999");
		Thread.sleep(5000);
		addcust.custaddress("Bangladesh");
		addcust.custcity("Dhaka");
		addcust.custstate("Notapplicable");
		addcust.custpinno("123456");
		addcust.custtelephoneno("017890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");

		logger.info("All information about customer not provided");
		addcust.custsubmit();
		logger.info("All information about customer provided");
		Thread.sleep(3000);
		
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result == true)
		{
			Assert.assertTrue(true);
			captureScreen(driver,"addNewCustomer");
			logger.info("test case passed....");
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"addNewCustomer");
			logger.info("test case failed....");
		}
		
		
		
	}
	
}
