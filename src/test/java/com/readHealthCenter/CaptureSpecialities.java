package com.readHealthCenter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.exceldata.ReadExcel;
import com.launchbrowser.LaunchChromeBrowser;

public class CaptureSpecialities extends ReadExcel {
	public static int specialityCount;
	public static WebDriverWait wait;
	public static JavascriptExecutor executor;
	
	public static String strTotalSpecialityNames;
	public static String waqtailCurrentUrl;

	public static void captureDCSpecialities(StringBuffer totalSpecialityNames) throws Exception {
		try {
			
			waqtailCurrentUrl = LaunchChromeBrowser.driver.getCurrentUrl();
			executor = (JavascriptExecutor) LaunchChromeBrowser.driver;
			List<WebElement> totalSpecialityCount = LaunchChromeBrowser.driver
					.findElements(By.xpath("//div[@class='field model_choice_field select']"));
			System.out.println("Size of Speciality Count:" + totalSpecialityCount.size());
			for (specialityCount = 0; specialityCount <= totalSpecialityCount.size() - 2; specialityCount++) {
				wait = new WebDriverWait(LaunchChromeBrowser.driver, 20);
				wait.until(ExpectedConditions.visibilityOf(LaunchChromeBrowser.driver
						.findElement(By.id("id_article_speciality-" + specialityCount + "-speciality"))));
				executor.executeScript("arguments[0].scrollIntoView(true);", LaunchChromeBrowser.driver
						.findElement(By.id("id_article_speciality-" + specialityCount + "-speciality")));
				String specialityName = LaunchChromeBrowser.driver.findElement(By
						.xpath("//*[@id='id_article_speciality-" + specialityCount + "-speciality']/option[@selected]"))
						.getText();
				totalSpecialityNames.append(specialityName);
				if (!(specialityCount == totalSpecialityCount.size())) {
					strTotalSpecialityNames = totalSpecialityNames.append(";").toString();
				}
				System.out.println("The Speciality list are:" + strTotalSpecialityNames);
				
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
