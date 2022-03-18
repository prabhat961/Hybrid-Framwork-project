package com.netBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass {
	@Test
	public void loginTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("username entered");
		lp.setPassWord(password);
		logger.info("password entered");
		lp.clickSubmit();
		logger.info("login button clicked");
		//GTPL Bank Manager HomePage
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("Login test failed");
			
		}
		
	}

}
