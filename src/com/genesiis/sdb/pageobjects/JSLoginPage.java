package com.genesiis.sdb.pageobjects;

import org.openqa.selenium.*;

public class JSLoginPage {

	private static WebElement element = null;
	
	public static WebElement txt_UserName(WebDriver driver) {
		element = driver.findElement(By.id("lUname"));
		return element;
	}
	
	public static WebElement txt_Password(WebDriver driver) {
		element = driver.findElement(By.id("txtPassword"));
		return element;
	}
	
	public static WebElement btn_Login(WebDriver driver) {
		element = driver.findElement(By.id("login-button"));
		return element;
	}
	
}
