package com.askTodoctor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.launchbrowser.LaunchChromeBrowser;

public class PhysicianLogin extends LaunchChromeBrowser{
	public static WebDriverWait wait;
	public static void loginToPhysician() {
		try {
			Thread.sleep(2000);
		browserLaunch();
		//LaunchChromeBrowser.driver.get("https://stage.k8s.dovemed.com/ask-a-doctor/");
		LaunchChromeBrowser.driver.get("https://www.dovemed.com/ask-a-doctor/");
		Thread.sleep(2000);						
		WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
		WrapperClass.elementVisibility(login);
		System.out.println("Production Located");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//a[text()='Login']")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", login);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("textField-email")));
		//driver.findElement(By.id("textField-email")).sendKeys("kjjoseph_2004@yahoo.co.in");
		driver.findElement(By.id("textField-email")).sendKeys("tangella@dovemed.com");
			Thread.sleep(1000);
		//driver.findElement(By.id("textField-password")).sendKeys("#Conference2020");
		driver.findElement(By.id("textField-password")).sendKeys("Arizona123!");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
				
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		

	}

}
