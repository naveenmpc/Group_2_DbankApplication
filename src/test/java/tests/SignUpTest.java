package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SignUpPage;
import pages.TestBase;


public class SignUpTest extends TestBase
{
	SoftAssert soft = new SoftAssert();
	SignUpPage sup;
	
	@BeforeMethod
	public void setup()
	{
		//getBrowser();
		sup=new SignUpPage(driver);
	}
	
	Logger logger = LogManager.getLogger(this);
	@Test
	public void testSignUp() throws InterruptedException
	{
		logger.info("Testing Sign Up page");
		sup.clickonSignUpHere();
		Thread.sleep(3000);
		
		//Validating NextButton without providing any data
		logger.info("Validating NextButton without providing any data");
		sup.clickonNext();
		soft.assertTrue(sup.validate_Title_DrpDwn(), "Assert failed- Reading empty fields");
		
		//Validating Next button with already registered data
		logger.info("Validating NextButton without providing any data");
		sup.enterSignUpDetailsPage1("Ms.","Veena", "Shankar", "10/10/1978", "123-45-1234", "sanjanapmm263@gmail.com", "Veena@123", "Veena@123");
		sup.clickonNext();
		soft.assertTrue(sup.validate_Already_Registered_data(), "Assert failed- No error displayed");
		
		sup.enterSignUpDetailsPage1("Ms.","Veena", "Shankar", "10/10/1978", "163-76-7776", "sanjanapmm123@gmail.com", "Veena@123", "Veena@123");
		sup.clickonNext();
		
		//Validating RegisterButton without any data
		logger.info("Validating RegisterButton without any data");
		sup.clickonRegisterBtn();
		soft.assertTrue(sup.validate_address(), "Assert failed- Reading empty fields");
		
		//Register after giving all valid data fields
		sup.enterSignUpDetailsPage2("SwimmingPool Extension", "Malleshwearam", "Bengaluru", "511101", "India", "6666666666", "9999999999", "7777777777");
		sup.clickonRegisterBtn();
		
	soft.assertAll();
	}
	
}
