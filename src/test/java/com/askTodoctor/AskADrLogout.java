package com.askTodoctor;

import org.openqa.selenium.By;

import com.launchbrowser.LaunchChromeBrowser;

public class AskADrLogout {

	public static void userLogout() {
		try {
		LaunchChromeBrowser.driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit'])[2]")).click();
		LaunchChromeBrowser.driver.findElement(By.xpath("//span[text()='Logout']")).click();
		Thread.sleep(2000);
		LaunchChromeBrowser.driver.close();
		
		} catch (InterruptedException e) {
			
		}
		
	}
	}
