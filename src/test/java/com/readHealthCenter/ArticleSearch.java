package com.readHealthCenter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.askTodoctor.AskADoctor_Main;
import com.askTodoctor.AskADrLogin;
import com.exceldata.ReadExcel;
import com.launchbrowser.LaunchChromeBrowser;

public class ArticleSearch extends ReadExcel {
	public static String dcExpectedTitle;
	public static JavascriptExecutor executor;
	public static WebDriverWait wait;
	public static int title;
	public static void dcArticleSearch() {
		try {
			wait=new WebDriverWait(LaunchChromeBrowser.driver,20);
			ReadExcel.readExcelData();
			String dcTitle = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(2).getStringCellValue();
			LaunchChromeBrowser.driver.findElement(By.id("menu-search-q")).sendKeys(dcTitle);
			wait.until(ExpectedConditions.elementToBeClickable(LaunchChromeBrowser.driver.findElement(By.xpath("//button[@type='submit']"))));
			LaunchChromeBrowser.driver.findElement(By.xpath("//button[@type='submit']")).click();
			List<WebElement> dcTitles = LaunchChromeBrowser.driver.findElements(By.xpath("(//table[@Class='listing']/tbody/tr/td[1])"));
			System.out.println("Size of the Elements"+dcTitles.size());
			for(title=1;title<=dcTitles.size();title++) {
				dcExpectedTitle = LaunchChromeBrowser.driver.findElement(By.xpath("(//table[@Class='listing']/tbody/tr/td[1])["+title+"]")).getText();
				//System.out.println(dcExpectedTitle);
				if(dcExpectedTitle.equalsIgnoreCase(dcTitle)) {
					wait.until(ExpectedConditions.elementToBeClickable(LaunchChromeBrowser.driver.findElement(By.xpath("//a[text()='"+dcTitle+"']"))));
					LaunchChromeBrowser.driver.findElement(By.xpath("//a[text()='"+dcTitle+"']")).click();
					break;
				}else {
					executor = (JavascriptExecutor)LaunchChromeBrowser.driver;
					LaunchChromeBrowser.driver.findElement(By.xpath("//a[@class='icon icon-arrow-right-after']")).click();
					List<WebElement> dcTitlesOnNextPage = LaunchChromeBrowser.driver.findElements(By.xpath("(//table[@Class='listing']/tbody/tr/td[1])"));
					System.out.println("Titles Count in Next Page:"+dcTitlesOnNextPage);
					dcTitles=dcTitlesOnNextPage;
					title = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
