package com.addquestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.askTodoctor.AskADoctor_Main;
import com.askTodoctor.AskADrLogin;
import com.askTodoctor.WrapperClass;
import com.exceldata.ReadExcel;
import com.launchbrowser.LaunchChromeBrowser;

import schemasMicrosoftComOfficeOffice.WrapcoordsAttribute;

public class AddAnswers extends ReadExcel {
		//StringBuffer sbf = new StringBuffer();
		public static String ansArticleTitleUrl,dcAnswers;
		public static String ansLists,setAnsLists,totalText;
		public static String resourceLink,dcArticle,questionwiseAnswers;
		public static StringBuffer totalAnswers = new StringBuffer();
		
		
				// **DC Questions**
		public static String dcuserQ[] = { "What is T1? (Definition/Background Information)", "Who gets T1? (Age and Sex Distribution)", "What are the Risk Factors for T1? (Predisposing Factors)", "What are the Causes of T1? (Etiology)",
				"What are the Signs and Symptoms of T1?", "How is T1 Diagnosed?",
				"What are the possible Complications of T1?", "How is T1 Treated?",
				"How can T1 be Prevented?", "What is the Prognosis of T1? (Outcomes/Resolutions)","Additional and Relevant Useful Information for T1:" };
		
	public static void anslist() throws Exception {
		
		readExcelData();
		//for(int z=1;z<=2;z++) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DoveMed\\Downloads\\chromedriver_87\\chromedriver.exe");
		LaunchChromeBrowser.driver = new ChromeDriver();
		LaunchChromeBrowser.driver.manage().window().maximize();
		
		ansArticleTitleUrl = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(13).getStringCellValue();
		dcArticle=ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(2).getStringCellValue();
		LaunchChromeBrowser.driver.get(ansArticleTitleUrl);
		Thread.sleep(4000);
		totalText=LaunchChromeBrowser.driver.findElement(By.xpath("//div[@class='rich-text']")).getText();
		
		StringBuffer totalAnswers = new StringBuffer();
			for(int i = 2;i<12;i++) {   
				WebElement question = LaunchChromeBrowser.driver.findElement(By.xpath("//div[@class='rich-text']/h2[1]"));
				WrapperClass.scrollIntoViewJavaScript(question);
				String dcFullQuestion = LaunchChromeBrowser.driver.findElement(By.xpath("//div[@class='rich-text']/h2["+(i)+"]")).getText();
				String dcFullQuestion1 = LaunchChromeBrowser.driver.findElement(By.xpath("//div[@class='rich-text']/h2["+(i+1)+"]")).getText();
				//System.out.println("The Replaced Question is:"+dcFullQuestion);
			   dcAnswers = StringUtils.substringBetween(totalText,dcFullQuestion,dcFullQuestion1);
			  // System.out.println("the between strin is:"+dcAnswers);	

			   totalAnswers.append(dcAnswers).toString();
			   if(!(i==12)) {
			   questionwiseAnswers = totalAnswers.append("€").toString();
			   resourceLink = LaunchChromeBrowser.driver.getCurrentUrl();
			   }
			}
			   System.out.println(questionwiseAnswers);			   
				LaunchChromeBrowser.driver.close();
		//}	
		//}	
		 
		
		}
	
	public static void main(String[] args) {
		try {
			AddAnswers.anslist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	/*public static String getAnsLists() {
		return ansLists;
	}
	public static void setAnsLists(String ansLists) {
		AddAnswers.ansLists = ansLists;
	}*/

}
