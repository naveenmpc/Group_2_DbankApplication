package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pages.Deposit_into_Account_Page;
import pages.SignInPage;
import pages.TestBase;


public class Deposit_into_Account_Test extends TestBase {
	
	Deposit_into_Account_Page ds;
	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{
		sip=new SignInPage(driver);
		ds=new Deposit_into_Account_Page(driver);
		sip.enterSignInDetails();
	}
	
	Logger logger = LogManager.getLogger(this);
	@Test()
	public void testdeposit() throws InterruptedException
	{
		
		ds.clickonDeposit();
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "30");
		Thread.sleep(3000);
		
		//Validating Reset button
		logger.info("Checking Reset button");
		ds.clickonReset();
		Assert.assertTrue(ds.validate_Reset_Btn(), "Assert failed- Reset button not working");
		
		logger.info("Checking Submit button with empty fields ");
		//Validating Submit button without filling any fields
		ds.clickonSubmit();
		Thread.sleep(3000);
		Assert.assertTrue(ds.validate_dropdown(), "Assert failed- Reading empty fields");
		
		//Validating Submit button by providing Amount as 0
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "0");
		ds.clickonSubmit();
		Assert.assertTrue(ds.validate_error(), "Assert failed- Reading amount as 0");
		System.out.println(ds.captureError());
		logger.error(ds.captureError());
		
		//Provide valid data
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "9");
		ds.clickonSubmit();
	
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
}
