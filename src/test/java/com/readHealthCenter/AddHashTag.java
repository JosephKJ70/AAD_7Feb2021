package com.readHealthCenter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.askTodoctor.AskADoctor_Main;
import com.askTodoctor.AskADrLogin;
import com.exceldata.ReadExcel;
import com.launchbrowser.LaunchChromeBrowser;

public class AddHashTag extends ReadExcel {
public static WebDriverWait wait;
	public static void addToHashTag() {
	try {
	ReadExcel.readExcelData();
	wait = new WebDriverWait(LaunchChromeBrowser.driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(LaunchChromeBrowser.driver.findElement(By.xpath("//button[text()='Choose hash tag']"))));
	LaunchChromeBrowser.driver.findElement(By.xpath("//button[text()='Choose hash tag']")).click();
	String hashTag = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(6).getStringCellValue();
	wait.until(ExpectedConditions.visibilityOf(LaunchChromeBrowser.driver.findElement(By.id("id_q"))));
	LaunchChromeBrowser.driver.findElement(By.id("id_q")).sendKeys(hashTag);
	// Need to write balance script
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
