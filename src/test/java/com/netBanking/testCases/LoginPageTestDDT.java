package com.netBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.netBanking.utilities.XLUtils;

public class LoginPageTestDDT extends BaseClass {
	
	@Test(dataProvider = "TestData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassWord(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		if(isAlertPresent()== true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Test Case failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Test Case passed");
			lp.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	

@DataProvider(name = "TestData")
String[][] getData() throws IOException{
	String path = System.getProperty("user.dir")+"/src/test/java/com/netBanking/testData/TestData.xlsx";
	int rowNum = XLUtils.getRowCount(path, "Sheet1");
	int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
	String[][] loginData = new String[rowNum][colCount];
	for (int i = 1; i <= rowNum;i++) {
		for(int j = 0; j < colCount; j++ ) {
			loginData [i - 1][j] = XLUtils.getCellData(path,"Sheet1", i, j);
		}
	}
	return loginData;
	}
}
