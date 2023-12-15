package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Search_TRN_ViewSaving_Page;
import pages.SignInPage;
import pages.TestBase;

public class Search_TRN_View_Saving_Test extends TestBase {

	Search_TRN_ViewSaving_Page strn;
	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{
		sip=new SignInPage(driver);
		strn = new Search_TRN_ViewSaving_Page(driver);
		sip.enterSignInDetails();
	}
	
	Logger logger = LogManager.getLogger(this);
	@Test
	public void testSearchTRN_ViewSaving()
	{
		String expected_txt = "No matching records found";
		strn.clickSavingPage();
		strn.searchtrn("845586545");
		
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
