package com.genesiis.sdb.fulltest.jobseeker;

//20180913 HF init the test case to read parameters from excel sheet and execute in chrome driver

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import com.genesiis.sdb.utility.*;
import com.genesiis.sdb.appmodule.*;

public class JSLogin {

	private static WebDriver driver = null;
	
	@Test
	public void login() throws Exception {
		
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
		ExcelUtils.setExcelFile(Constant.testDataPath + Constant.jsLoginTestFile, "Sheet1");
		
		//path to the executable chrome driver file
		File f = new File("lib"+File.separator+"chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
		
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.navigate().to(Constant.url);
		driver.manage().window().maximize();
		SignInAction.Execute(driver);
		System.out.println("Login Successfully");
		//driver.quit();
		
		//This is to send the PASS value to the Excel sheet in the result column
		ExcelUtils.setCellData("Pass", 2, 4);
		
		
		
	}
	
}
