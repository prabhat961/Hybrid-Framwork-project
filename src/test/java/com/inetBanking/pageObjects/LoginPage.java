package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name = "uid")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement passwordField;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/ul[1]/li[10]/a[1]")
	@CacheLookup
	WebElement LogOutBtn;
	
	public void setUserName(String uName) {
		UserName.sendKeys(uName);
	}
	public void setPassWord(String pWord) {
		passwordField.sendKeys(pWord);
	}
	public void clickSubmit() {
		LoginBtn.click();
	}
	public void clickLogOut() {
		LogOutBtn.click();
	}

}
