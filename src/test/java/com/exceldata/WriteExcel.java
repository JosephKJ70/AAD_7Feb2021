package com.exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.addquestions.AddQuestionsAndHashTags;
import com.askTodoctor.AskADrLogin;
import com.askTodoctor.WrapperClass;
import com.readHealthCenter.CaptureSpecialities;

public class WriteExcel {
	//public static String strQuesURL;
	public static FileInputStream fis=null;
	public static XSSFSheet Sheet1;
	public static XSSFWorkbook wb;
	public static File src;
	public static FileOutputStream fos;
	public static WrapperClass awc = new WrapperClass();
	public static int questionUrl;
	public static StringBuffer userQuestions = new StringBuffer();
	
	public static void writeExcelData() throws FileNotFoundException {
	try {
	System.out.println("Write Excel Data");
	src=new File("C:\\Users\\DoveMed\\Desktop\\AskADr.xlsx");
	fis = new FileInputStream(src);
	wb = new XSSFWorkbook(fis);
	Sheet1 = wb.getSheetAt(0);
	System.out.println("Write done");
	fos = new FileOutputStream(src);
	for(int dctitle=0;dctitle<=3;dctitle++) {
		Row row = Sheet1.createRow(dctitle);
    //for(int title=0;title<=1;title++) {
		Cell cell = row.createCell(12);
		cell.setCellValue("dcTitles");
	//}
	
	}
	
	/*//for(questionUrl=1;questionUrl<=10;questionUrl++) {
	Sheet1.getRow(1).createCell(4).setCellValue(AddQuestionsAndHashTags.strQuesURL); 
	//}
*/	
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			wb.write(fos);
			wb.close();
				
		} catch (IOException e) {
		e.printStackTrace();
		}
		System.out.println("Written done");
	}
	}

	public static void main(String[] args) throws FileNotFoundException {
		WriteExcel we = new WriteExcel();
		we.writeExcelData();

	}

}
