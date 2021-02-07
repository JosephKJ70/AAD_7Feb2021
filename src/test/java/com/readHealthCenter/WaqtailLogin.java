package com.readHealthCenter;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.askTodoctor.WrapperClass;
import com.launchbrowser.LaunchChromeBrowser;

public class WaqtailLogin extends LaunchChromeBrowser{
	public static WrapperClass wc = new WrapperClass();
	public static WebElement signIn;
	public static WebElement userName;
	public static void loginToWaqtail() {
		try {			
			wc.readPropertyFile();
			LaunchChromeBrowser.browserLaunch();
			driver.get(wc.waqtailUrl);
			userName = driver.findElement(By.id("id_username"));
			WrapperClass.elementVisibility(userName);
			userName.sendKeys(wc.UserName);
			driver.findElement(By.id("id_password")).sendKeys(wc.PassWord);
			signIn = driver.findElement(By.xpath("//em[text()='Sign in']"));
			WrapperClass.elementClick(signIn);
			signIn.click();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void clickOnPages(){
		WebElement clickPages = LaunchChromeBrowser.driver.findElement(By.xpath("(//a[@class='submenu-trigger icon icon-folder-open-inverse'])[1]"));
		WrapperClass.elementClick(clickPages);
		clickPages.click();		
	}
	public static void clickHomePage() {
		LaunchChromeBrowser.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement clickHomePage = LaunchChromeBrowser.driver.findElement(By.xpath("//a[@class='c-explorer__item__action ']/span/span[1]"));
		WrapperClass.elementClick(clickHomePage);
		clickHomePage.click();
	}
	public static void clickOnDiseaseAndConditions(){
		LaunchChromeBrowser.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement clickOnDc=LaunchChromeBrowser.driver.findElement(By.xpath("//h3[text()='Diseases & Conditions']"));
		WrapperClass.scrollIntoViewJavaScript(clickOnDc);
		WrapperClass.elementClick(clickOnDc);
		clickOnDc.click();
	}
	public static void main(String[] args) {
		try {
		WaqtailLogin.loginToWaqtail();
		WaqtailLogin.clickOnPages();
		WaqtailLogin.clickHomePage();
		WaqtailLogin.clickOnDiseaseAndConditions();	
		Thread.sleep(2000);
		//LaunchChromeBrowser.driver.get("https://www.dovemed.com/admin/pages/4/?p=21");  //temporary
		CaptureDcTitleAndDetails.captureDCTitle();
		//ArticleSearch.dcArticleSearch();
		//CaptureSpecialities.captureDCSpecialities();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
