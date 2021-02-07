package com.addquestions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.askTodoctor.AddPhysicianAnswer;
import com.askTodoctor.AskADoctor_Main;
import com.askTodoctor.AskADrLogin;
import com.askTodoctor.AskADrLogout;
import com.askTodoctor.WrapperClass;
import com.exceldata.ReadExcel;
import com.exceldata.WriteExcel;
import com.launchbrowser.LaunchChromeBrowser;

public class AddQuestionsAndHashTags extends ReadExcel {
	public static  String strQuesURL;
	public static FileOutputStream fos;
	public static String tagValue;
	public static String[] innerTags = null;
	public static int i, innerValue;
	public static String strDCTags;
	WrapperClass awc = new WrapperClass();
	public static Row row;
	public static Cell cell;
	public static Robot robot = null;
	public static String userQuestionUrl,articleTitle;
	public static int quesCount;
	public static StringBuffer userQuestions = new StringBuffer();
	// **Article Titles**
	public static String userT[] = { "What is", "Who gets", "Risk Factors for", "Causes of", "Signs and Symptoms of",
			"Diagnosis of", "Complications of", "Treatment of", "Prevention of", "Prognosis of" };

	// **User Questions**
	public static String userQ[] = { "What is T1?", "Who gets T1?", "What are the Risk Factors for T1?", "What are the Causes of T1?",
			"What are the Signs and Symptoms of T1?", "How is T1 Diagnosed?",
			"What are the possible Complications of T1?", "How is T1 Treated?",
			"How can T1 be Prevented?", "What is the Prognosis of T1?" };

	
	public static void addUserQuestions(StringBuffer userQuestions) throws Exception {
		Random objGenerator = new Random();
		try {
			readExcelData();
			for (quesCount = 0; quesCount <= userT.length - 1; quesCount++) {
			 //try {
			System.out.println("The lenth of the question size is :" + userT.length);
			LaunchChromeBrowser.driver.findElement(By.xpath("//span[text()='Ask a question']")).click();
			Thread.sleep(4000);
			articleTitle = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(2).getStringCellValue();
			System.out.println("The Article Title is: " + articleTitle);
			LaunchChromeBrowser.driver.findElement(By.id("textField-title"))
					.sendKeys(userT[quesCount] + " " + articleTitle);
			Thread.sleep(4000);
			robot = new Robot();
			// Simulate key Events
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			WebElement tags = LaunchChromeBrowser.driver.findElement(By.xpath("(//input[@type='text'])[2]"));
			//strDCTags = ReadExcel.Sheet1.getRow(AskADrLogin.un).getCell(3).getStringCellValue().split(",");
			if((userT[quesCount].contains("What"))||((userT[quesCount].contains("Who")))){
				strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(3).getStringCellValue();
				System.out.println(strDCTags);
				}else if(userT[quesCount].contains("Risk Factors")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(4).getStringCellValue();
					System.out.println(strDCTags);	
				}else if(userT[quesCount].contains("Causes")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(5).getStringCellValue();
					System.out.println(strDCTags);	
				}else if(userT[quesCount].contains("Signs")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(6).getStringCellValue();
					System.out.println(strDCTags);	
				}else if(userT[quesCount].contains("Diagnosis of")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(7).getStringCellValue();
					System.out.println(strDCTags);	
				}else if(userT[quesCount].contains("Complications of")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(8).getStringCellValue();
					System.out.println(strDCTags);	
				}else if(userT[quesCount].contains("Treatment of")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(9).getStringCellValue();
					System.out.println(strDCTags);	
				}else if(userT[quesCount].contains("Prevention of")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(10).getStringCellValue();
					System.out.println(strDCTags);	
				}else if(userT[quesCount].contains("Prognosis of")){
					strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(11).getStringCellValue();
					System.out.println(strDCTags);	
				}			
			//System.out.println(strDCTags[quesCount].toString());
			innerTags = strDCTags.split(";");
			System.out.println("Inner tags lengh:" + innerTags.length);
			for (innerValue = 0; innerValue <= innerTags.length - 1; innerValue++) {
				tagValue = innerTags[innerValue];
				System.out.println("The Value:" + tagValue);
				Thread.sleep(3000);
				tags.sendKeys(innerTags[innerValue]);
				Thread.sleep(5000);
				WebElement dropdown = (new WebDriverWait(LaunchChromeBrowser.driver, 1000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator MuiAutocomplete-popupIndicatorOpen']")));
				Thread.sleep(5000);
				tags.sendKeys(Keys.ARROW_DOWN);	
				Thread.sleep(5000);
				tags.sendKeys(Keys.ENTER);
				Thread.sleep(4000);
			}
			String fullQuestion = userQ[quesCount].replaceAll("T1", articleTitle);
			System.out.println("The Replaced Question is:"+fullQuestion);
			LaunchChromeBrowser.driver.findElement(By.id("textField-description"))
					.sendKeys(fullQuestion);
			//for (int iCount = 0; iCount<=9; iCount++){ 
			
			int randomNumber = objGenerator.nextInt(9);
			System.out.println("Randon Number: "+randomNumber);
			if(randomNumber==0||randomNumber==1||randomNumber==3||randomNumber==5)
					 {
				//Thread.sleep(2000);
				WebElement anonymusClick= LaunchChromeBrowser.driver.findElement(By.xpath("//input[@type='checkbox']"));
				System.out.println("AnonymusClick focused");
				Thread.sleep(4000);
				anonymusClick.click();
			}
			 //}
			LaunchChromeBrowser.driver.findElement(By.xpath("//span[text()='Submit Question']")).click();
			Thread.sleep(4000);
			userQuestionUrl = LaunchChromeBrowser.driver.getCurrentUrl();
			System.out.println("The Current URL is: " + userQuestionUrl);
			userQuestions.append(userQuestionUrl);
			System.out.println("Current Url from excel :" + userQuestionUrl);
			if (!(quesCount == -1)) {
				strQuesURL = userQuestions.append(";").toString();
			}
			 }
			System.out.println("********" + strQuesURL);
			fos = new FileOutputStream("C:\\Users\\DoveMed\\Desktop\\AskADr.xlsx");
			Cell cell = Sheet1.getRow(AskADoctor_Main.un).createCell(12);
			cell.setCellValue(strQuesURL);
			Cell cell1 = Sheet1.getRow(AskADoctor_Main.un).createCell(15);
			cell1.setCellValue("Questions posted");
			wb.write(fos);
		}catch(Exception ex) {
			Cell cell = Sheet1.getRow(AskADoctor_Main.un).createCell(15);
			cell.setCellValue("not posted this is question section");
	ex.getMessage();
}finally {
	
	wb.close();
	System.out.println("Finally executed");
}
		//}
	}
	}

