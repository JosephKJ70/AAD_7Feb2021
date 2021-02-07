package com.exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static FileInputStream fis;
	public static XSSFSheet Sheet1;
	public static XSSFWorkbook wb;
	public static File src;
	//public static WrapperClass awc = new WrapperClass();
	
	public static void readExcelData() throws Exception {
	try {
		// Read the data from Excel	
		         
		            	System.out.println("Hello");
		            	//awc.readPropertyFile();
					
					System.out.println("Read Excel Data");
					src = new File("C:\\Users\\DoveMed\\Desktop\\AskADr.xlsx");
					fis = new FileInputStream(src);
					wb = new XSSFWorkbook(fis);
					Sheet1 = wb.getSheetAt(0);
					System.out.println("The Total Number of articles present in Row:"+Sheet1.getLastRowNum());
					System.out.println("The Total Number of article present in Column:"+Sheet1.getRow(1).getLastCellNum());
					Thread.sleep(500);
					//return ;
					} catch (FileNotFoundException e) {
						e.getMessage();
		e.printStackTrace();
		System.out.println(e);
	}

}
public static void main(String[] args) {
	ReadExcel re = new ReadExcel();
	try {
		re.readExcelData();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
