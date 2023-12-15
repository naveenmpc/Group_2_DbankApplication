package pages;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {

public static WebDriver driver = null;
	
	public static WebDriver getDriver()
	{
		return driver;
	}

	@Before
	public static void getBrowser()
	{
	    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");	
	}
	
	@After
	public static void teardown()
	{
		driver.quit();
	}
	
	/*
	 * public void captureScreenshot(String fileName) { TakesScreenshot
	 * takesScreenshot = (TakesScreenshot) driver; File
	 * sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE); File destFile =
	 * new File(".Screenshots/"+fileName); try {
	 * FileUtils.copyFile(sourceFile,destFile); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * System.out.println("Screenshot saved successfully"); }
	 */
}
