package com.launchbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {
	public static  WebDriver driver;
public static void browserLaunch() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DoveMed\\Downloads\\chromedriver_87\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}
	public static void main(String[] args) {
		LaunchChromeBrowser bl = new LaunchChromeBrowser();
		bl.browserLaunch();
		
  
	}

}
