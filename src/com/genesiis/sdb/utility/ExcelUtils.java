package com.genesiis.sdb.utility;

//20180913 HF init the class to use in JS login test case to pass parameters from excel sheet

import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method 
	public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}

	}
	
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public static String getCellData(int RowNum, int ColNum){

			try{

			String CellData = excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }
    
    
    //This method is to write in the Excel cell, Row num and Col num are the parameters 
	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

			try{

  			row  = excelWSheet.getRow(RowNum);
			//Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			cell = row.getCell(ColNum);

			if (cell == null) {

				cell = row.createCell(ColNum);
				cell.setCellValue(Result);

				} else {

					cell.setCellValue(Result);

				}

			
				// Constant variables Test Data path and Test Data file name
  				FileOutputStream fileOut = new FileOutputStream(Constant.testDataPath + Constant.jsLoginTestFile);
  				excelWBook.write(fileOut);
  				fileOut.flush();
				fileOut.close();

				}catch(Exception e){

					throw (e);

			}

		}
	
}
