package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Search_TRN_ViewChecking_Page;
import pages.SignInPage;
import pages.TestBase;

public class Search_TRN_View_Checking_Test extends TestBase {

	Search_TRN_ViewChecking_Page strn;
	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{
		sip=new SignInPage(driver);
		strn = new Search_TRN_ViewChecking_Page(driver);
		sip.enterSignInDetails();
	}
	
	Logger logger = LogManager.getLogger(this);
	@Test
	public void testSearchTRN_ViewChecking()
	{
		String expected_txt = "No matching records found";
		strn.clickonCheckingPage();
		strn.searchtrn("845586594");
	
		logger.info("Validating invalid TRN");
		//Validating invalid TRN
		strn.searchtrn("845586877");
		Assert.assertEquals(strn.capturetext(), expected_txt);
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
}
