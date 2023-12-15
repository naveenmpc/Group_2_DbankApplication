package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Direct_Payment_to_Visa_Page;
import pages.SignInPage;
import pages.TestBase;

public class Direct_Payment_to_Visa_Test extends TestBase {

	Direct_Payment_to_Visa_Page vp;
	SignInPage sip;
	SoftAssert soft = new SoftAssert();
	
	@BeforeMethod
	public void setup()
	{
		vp = new Direct_Payment_to_Visa_Page(driver);
		sip = new SignInPage(driver);
		sip.enterSignInDetails();
	}
	
	//Logger logger = LogManager.getLogger(this);
	@Test
	public void testVisaPayment() throws InterruptedException
	{
		
		vp.clickonVisaTransfer();
		
		//Validating Submit button with empty field
		vp.clickonSubmit();
		soft.assertTrue(vp.validate_select_Acnt(), "Assert failed- Reading empty fields");
		
		//driver.navigate().back();
		
		//Validating Select Account drop-down without selecting actual account
		vp.enterTransferDetails(0, "80");
		vp.clickonSubmit();
		soft.assertFalse(vp.ServiceError(), "Assert failed- Reading data without selecting Account");//fail
		
		
		  //Validating Submit button with amount as 0 
		  vp.clickonVisaTransfer();
		  vp.enterTransferDetails(1, "0"); 
		  vp.clickonSubmit();
		  soft.assertFalse(vp.ServiceError(),"Assert failed - Accepting 0 amount");//fail
		  
		  //Validating Submit button with amount as 0.001 
		  vp.clickonVisaTransfer();
		  vp.enterTransferDetails(1, "0.001"); 
		  vp.clickonSubmit();
		  soft.assertFalse(vp.ServiceError(), "Assert failed - Accepting any number of digits after decimal Amount");//fail
		  
		  //Validating Successful transfer 
		  vp.clickonVisaTransfer();
		  vp.enterTransferDetails(1, "20"); 
		  vp.clickonSubmit();
		  soft.assertFalse(vp.ServiceError(), "Assert failed - Unsucessful transaction - service Unavailable");//fail
		 
		soft.assertAll();
		
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
}
