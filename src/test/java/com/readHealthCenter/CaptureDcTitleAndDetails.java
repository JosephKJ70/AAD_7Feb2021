package com.readHealthCenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.askTodoctor.WrapperClass;
import com.launchbrowser.LaunchChromeBrowser;

public class CaptureDcTitleAndDetails extends WrapperClass {
	public static WebElement dcTitlesOneByOne;
	private static int i;
	public static int temp;
	public static String dcTitles;
	public static List<WebElement> totalDcTitleCount;
	public static XSSFSheet Sheet1;
	public static XSSFWorkbook wb;
	public static File src;
	public static FileOutputStream fos;
	public static int titlecount = 0;
	public static int rowCount;

	public static void captureDCTitle() throws Exception {
		try {
			System.out.println("Write Excel Data");
			src = new File("C:\\Users\\DoveMed\\OneDrive\\Documents\\DCTitles.xlsx");
			fos = new FileOutputStream(src);
			wb = new XSSFWorkbook();
			Sheet1 = wb.createSheet("DCHC");
			System.out.println("Sheet Created");

			totalDcTitleCount = driver.findElements(By.xpath("(//td[@class='title']/h2)"));
			System.out.println("Total Number of Dc Titles Count:" + totalDcTitleCount.size());
			for (i = 1, rowCount = 1; i <= totalDcTitleCount.size() - 1; i++, rowCount++) {
				StringBuffer totalSpecialityNames = new StringBuffer();
				WebElement dcTitlesOneByOne = driver
						.findElement(By.xpath("//*[@id='page-reorder-form']/table/tbody/tr[" + i + "]/td[2]/h2/a"));
				WrapperClass.scrollIntoViewJavaScript(dcTitlesOneByOne);
				dcTitles = dcTitlesOneByOne.getText();
				WrapperClass.elementClick(dcTitlesOneByOne);
				dcTitlesOneByOne.click();
				CaptureSpecialities.captureDCSpecialities(totalSpecialityNames);

				Row row = Sheet1.createRow(rowCount);
				for (int title = 0; title <= 2; title++) {
					Cell cell = row.createCell(0);
					cell.setCellValue(dcTitles);
					Cell cell1 = row.createCell(1);
					cell1.setCellValue(CaptureSpecialities.strTotalSpecialityNames);
					Cell cell2 = row.createCell(2);
					cell2.setCellValue(CaptureSpecialities.waqtailCurrentUrl);

				}

				LaunchChromeBrowser.driver.navigate().back();
				if (i == 50) {
					WebElement nextLink = LaunchChromeBrowser.driver
							.findElement(By.xpath("//a[@class='icon icon-arrow-right-after']"));
					WrapperClass.scrollIntoViewJavaScript(nextLink);
					WrapperClass.elementClick(nextLink);
					nextLink.click();
					temp = i;
					i = titlecount;
					titlecount = i;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally Block Executed");
			wb.write(fos);
			wb.close();
		}

	}

}
