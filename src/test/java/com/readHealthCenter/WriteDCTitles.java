package com.readHealthCenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.askTodoctor.WrapperClass;

public class WriteDCTitles extends CaptureDcTitleAndDetails {
	public static XSSFSheet Sheet1;
	public static XSSFWorkbook wb;
	public static File src;
	public static FileOutputStream fos;
	public static WrapperClass awc = new WrapperClass();
	public static StringBuffer userQuestions = new StringBuffer();
	public static String dcTitles;
	
	public static void writeDCExcelData() throws Exception {
			try {
			System.out.println("Write Excel Data");
			src=new File("C:\\Users\\DoveMed\\Desktop\\AskADr.xlsx");
			fos = new FileOutputStream(src);
			wb = new XSSFWorkbook();
			Sheet1 = wb.createSheet("DCHC");
			System.out.println("Sheet Created");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
			public static void writeDCSpecialityandTitle1(int rowCount, int columnCount) {
						
		//	for(int dctitle=1;dctitle<CaptureDcTitleAndDetails.totalDcTitleCount.size()+1;dctitle++) {
				for(int dctitle=0;dctitle<=3;dctitle++) {
			Row row = Sheet1.createRow(dctitle);
			//for(int title=0;title<CaptureDcTitleAndDetails.totalDcTitleCount.size()+1;title++) {
			for(int title=0;title<=2;title++) {
				Cell cell = row.createCell(title);
				cell.setCellValue("dcTitles");
				Cell cell1 = row.createCell(1);
				cell1.setCellValue("CaptureSpecialities.strTotalSpecialityNames");
				Cell cell2 = row.createCell(2);
				cell2.setCellValue("CaptureSpecialities.waqtailCurrentUrl");
			
			}
			}				
			try {
				wb.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
	}
		


	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		WriteDCTitles we = new WriteDCTitles();
		try {
			we.writeDCExcelData();
			we.writeDCSpecialityandTitle1(0,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}




