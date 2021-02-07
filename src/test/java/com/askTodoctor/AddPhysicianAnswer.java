package com.askTodoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.addquestions.AddAnswers;
import com.exceldata.ReadExcel;
import com.launchbrowser.LaunchChromeBrowser;

public class AddPhysicianAnswer extends AddAnswers {
   public static String[] strQuestionLink;
    public static int questionURLLink;
	public static void addPhyAnswer() throws Exception
	{try {
		anslist();
		Thread.sleep(3000);
		PhysicianLogin.loginToPhysician();
		//ReadExcel.readExcelData();
		Thread.sleep(6000);
		strQuestionLink = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(12).getStringCellValue().split(";");
		for(int questionURLLink=0;questionURLLink<=strQuestionLink.length-1;questionURLLink++){
		System.out.println(strQuestionLink.length);
		System.out.println(strQuestionLink[questionURLLink].toString());
		LaunchChromeBrowser.driver.get(strQuestionLink[questionURLLink].toString());
		Thread.sleep(6000);
		WebElement clickOnAnswer = LaunchChromeBrowser.driver.findElement(By.xpath("//span[text()='Answer']"));
		//WrapperClass.elementVisibility(clickOnAnswer);
		WrapperClass.elementClick(clickOnAnswer);
		clickOnAnswer.click();
		Thread.sleep(4000);
		WebElement hiddenElement = LaunchChromeBrowser.driver.findElement(By.xpath("//div[@Class='notranslate public-DraftEditor-content']"));
		System.out.println("Element located");
		String answerToPost[] = questionwiseAnswers.split("€");
		hiddenElement.sendKeys(answerToPost[questionURLLink]);
		/*Actions actions = new Actions(LaunchChromeBrowser.driver);
		 actions.keyDown(hiddenElement,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); 
		 System.out.println("Text Copied");
		Thread.sleep(5000); 
		//LaunchChromeBrowser.driver.findElement(By.xpath("(//*[@aria-hidden='true'])[12]")).click();
		LaunchChromeBrowser.driver.findElement(By.xpath("//div[@class='sc-psQdR gKPniN']//following-sibling::span[4]")).click();*/
		Thread.sleep(4000);
		LaunchChromeBrowser.driver.findElement(By.id("textField-additional_resource")).sendKeys(resourceLink);
		Thread.sleep(4000);
		WebElement Submit =LaunchChromeBrowser.driver.findElement(By.xpath("//button[@type='submit']"));
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(3000);
		System.out.println("clicked");
		
		}
		WrapperClass.driver.close();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		try {
			AddPhysicianAnswer.addPhyAnswer();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
