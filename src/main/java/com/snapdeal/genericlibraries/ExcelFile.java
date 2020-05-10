package com.snapdeal.genericlibraries;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelFile {
	
	public static String getExcelData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelSheet/testdata.xlsx");
		
//		we are creating an XSSF workbook object for xslx Excel file
		Workbook wb=new XSSFWorkbook(fis);
	

		String url=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String login=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String emailid=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String password=wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		if(key.equalsIgnoreCase("url")) {
			return url;
		}
		else if(key.equalsIgnoreCase("login")) {
			return login;
			
		}
		else if(key.equalsIgnoreCase("emailid")) {
			return emailid;
			
		}
		else if(key.equalsIgnoreCase("password")) {
			return password;
		}
		return "";
		
		
	}


	

}
