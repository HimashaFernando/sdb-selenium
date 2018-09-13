package com.genesiis.sdb.appmodule;

//20180913 init the class & implemented Execute() to use in JS sign in

import org.openqa.selenium.*;
import com.genesiis.sdb.pageobjects.*;
import com.genesiis.sdb.utility.*;

public class SignInAction {

public static void Execute(WebDriver driver) throws Exception {
		
		//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
		String userName = ExcelUtils.getCellData(2, 2);
		String password = ExcelUtils.getCellData(2, 3);
		
		TJHomePage.btn_JSLogin(driver).click();
	    JSLoginPage.txt_UserName(driver).sendKeys(userName);
	    JSLoginPage.txt_Password(driver).sendKeys(password);
	    JSLoginPage.btn_Login(driver).click();
	}
	
}
