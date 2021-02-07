package com.askTodoctor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.launchbrowser.LaunchChromeBrowser;

public class WrapperClass extends LaunchChromeBrowser{
	public Properties property;
	public FileInputStream pf;
	public String UserName,PassWord,stgUrl,prodUrl,waqtailUrl;
	public static WebDriverWait wait=null;
	public static JavascriptExecutor executor;
		
	public void readPropertyFile() throws FileNotFoundException {
		try {
		pf = new FileInputStream(System.getProperty("user.dir")+"\\askADrconfig.properties");
		property = new Properties();
		property.load(pf);
		System.out.println("Read Properties file");
		this.UserName=property.getProperty("UserName");
		this.PassWord=property.getProperty("PassWord");
		this.stgUrl=property.getProperty("stgUrl");
		this.prodUrl=property.getProperty("prodUrl");
		this.waqtailUrl=property.getProperty("waqtailUrl");
		// print the datas
		System.out.println(property.getProperty("UserName"));
		System.out.println(property.getProperty("stgUrl"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void elementClick(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void elementVisibility(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void scrollIntoViewJavaScript(WebElement element) {
		executor = (JavascriptExecutor)WrapperClass.driver;
		((JavascriptExecutor)WrapperClass.driver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void main(String[] args) {
		WrapperClass awc = new WrapperClass();
		try {
			awc.readPropertyFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

