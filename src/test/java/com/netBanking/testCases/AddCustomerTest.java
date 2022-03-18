package com.netBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class AddCustomerTest extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("username entered");
		lp.setPassWord(password);
		logger.info("password entered");
		lp.clickSubmit();
		logger.info("login button clicked");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing User Information.......");
		addcust.enterCustomerName("Prabhat");
		addcust.custdob("17","11","1989");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("PAT");
		addcust.custstate("BIH");
		addcust.custpinno("800002");
		addcust.custtelephoneno("9035900819");
		
		String email=randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

	}
	
	
}
