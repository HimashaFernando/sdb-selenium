package com.genesiis.sdb.pageobjects;

import org.openqa.selenium.*;

public class TJHomePage {

	private static WebElement element = null;
	
	public static WebElement btn_JSLogin(WebDriver deiver) {
		
		element = deiver.findElement(By.id("headerbar-jslogin"));
		return element;
		
	}
	
}
