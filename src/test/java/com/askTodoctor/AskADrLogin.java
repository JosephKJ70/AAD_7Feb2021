package com.askTodoctor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.addquestions.AddAnswers;
import com.addquestions.AddQuestionsAndHashTags;
import com.exceldata.ReadExcel;
import com.exceldata.WriteExcel;
import com.launchbrowser.LaunchChromeBrowser;

public class AskADrLogin extends ReadExcel{
	public static WebDriverWait wait;
	public static FileOutputStream fos;
	public static LaunchChromeBrowser lcb = new LaunchChromeBrowser();
public static void asdLogin() throws Exception {
	try {
		//readExcelData();
		//for(un=count;un<=ReadExcel.Sheet1.getLastRowNum();un++) {
		System.out.println("The number of customer questions added:"+AskADoctor_Main.un);
		lcb.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		lcb.driver.findElement(By.xpath("//a[text()='Login']")).click();
		System.out.println("The Number of Rows are:"+ReadExcel.Sheet1.getLastRowNum());
		String userName =ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(0).getStringCellValue();
		System.out.println("The UserName is:"+userName);
		String passWord = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(1).getStringCellValue();
		System.out.println("The password is:"+passWord);
		lcb.driver.findElement(By.id("textField-email")).sendKeys(userName);
		lcb.driver.findElement(By.id("textField-password")).sendKeys(passWord);
		wait= new WebDriverWait(lcb.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(lcb.driver.findElement(By.xpath("//span[text()='Login']"))));
		lcb.driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(4000);
		StringBuffer userQuestions = new StringBuffer();
		AddQuestionsAndHashTags.addUserQuestions(userQuestions);
				
			
}catch (IOException e) {
	e.printStackTrace();
	
}

}
}