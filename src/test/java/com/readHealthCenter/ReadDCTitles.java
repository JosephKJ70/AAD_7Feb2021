package com.readHealthCenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDCTitles {
	public static FileInputStream fiss;
	public static XSSFSheet Sheet1;
	public static XSSFWorkbook wb;
	public static File src;
	
	public static void readDCExcelData() throws Exception {
	try {
							
					System.out.println("Read Excel Data");
					src = new File("C:\\Users\\DoveMed\\OneDrive\\Documents\\DCTitles.xlsx");
					fiss = new FileInputStream(src);
					wb = new XSSFWorkbook(fiss);
					Sheet1 = wb.getSheetAt(0);
					System.out.println("The Total Number of articles present in Row:"+Sheet1.getLastRowNum());
					System.out.println("The Total Number of article present in Column:"+Sheet1.getRow(1).getLastCellNum());
					Thread.sleep(500);
					} catch (FileNotFoundException e) {
						e.getMessage();
		e.printStackTrace();
		System.out.println(e);
	}

}
@SuppressWarnings("static-access")
public static void main(String[] args) {
	ReadDCTitles re = new ReadDCTitles();
	try {
		re.readDCExcelData();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
