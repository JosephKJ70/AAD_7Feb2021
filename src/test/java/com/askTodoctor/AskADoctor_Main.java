package com.askTodoctor;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.addquestions.AddAnswers;
import com.addquestions.AddQuestionsAndHashTags;
import com.exceldata.ReadExcel;
import com.launchbrowser.LaunchChromeBrowser;

public class AskADoctor_Main extends ReadExcel{
	WebElement clickAskADr;
	public static FileOutputStream fos;
	public static LaunchChromeBrowser lcb = new LaunchChromeBrowser();	
	public static WrapperClass awc = new WrapperClass();
	public static WebDriverWait wait;
	public static int un=1;
	public static int count=1;
	
	public static void clickAskADr() {
		try {
			//allLocators();
			lcb.browserLaunch();
			awc.readPropertyFile();
			lcb.driver.get(awc.prodUrl);
		wait = new WebDriverWait(lcb.driver,20);
		lcb.driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		System.out.println("Ask A Doctor Located");
		WebElement askADr = lcb.driver.findElement(By.xpath("//a[@href='/ask-a-doctor/']"));
		wait.until(ExpectedConditions.elementToBeClickable(askADr));
		askADr.click();
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		}
	}
	public boolean isAlertPresent() throws Throwable 
	{ 
	    try 
	    { 
	        lcb.driver.switchTo().alert(); 
	        System.out.println("Alert Present");
	        return true; 
	        
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	    	System.out.println("NoAlert Present");
	    	Thread.sleep(1000);		
	    	Robot robot = new Robot();
	    	robot.mouseMove(100,50);
	    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    	Thread.sleep(1000);
	    	System.out.println("Test1");
	    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    	Thread.sleep(1000);
	    	robot.keyPress(KeyEvent.VK_ENTER);
	    	 System.out.println("Closed the windows popup");
	    	System.out.println("Completed");
	        return false; 
	    }   
	}
public static void main(String[] args) {
	try {
		ReadExcel.readExcelData();
	} catch (Exception e1) {
		e1.printStackTrace();
		
	}									
	for(un=count;un<=ReadExcel.Sheet1.getLastRowNum();un++) {
	try {
		AskADoctor_Main aad = new AskADoctor_Main();
	aad.clickAskADr();
	try {
		aad.isAlertPresent();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	AskADrLogin.asdLogin();
	AskADrLogout.userLogout();
	AddPhysicianAnswer.addPhyAnswer();
	
	} catch (Exception e) {				
		e.printStackTrace();
		
	}
		
	}
	}
	
}

