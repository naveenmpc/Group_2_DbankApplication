package tests;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;
import pages.TestBase;
import pages.Transfer_between_Accounts_Page;

public class Transfer_between_Accounts_Test extends TestBase{

	SignInPage sip;
	Transfer_between_Accounts_Page tba;
	
	@BeforeMethod
	public void setup()
	{
		sip = new SignInPage(driver);
		tba = new Transfer_between_Accounts_Page(driver);
		sip.enterSignInDetails();
	}
	
	@Test
	public void testTransfer()
	{
		tba.clickonTransferBetweenAcnts();
		
		//Validating Submit button without any data
		tba.clickonSubmit();
		Assert.assertTrue(tba.validate_fromAccount_DrpDwn(), "Assert failed- Reading empty fields");
		
		//Validating Reset button
		tba.enterAcntsDetails(1, 2, "10");
		tba.clickonReset();
		Assert.assertTrue(tba.validate_Reset_Btn(), "Assert failed- Reset button not working");
		
		//Validating Submit button amount as 0
		tba.enterAcntsDetails(1, 2, "0");
		tba.clickonSubmit();
		System.out.println(tba.captureError());
		
		Assert.assertTrue(tba.validate_fromAccount_DrpDwn(), "Assert failed- Accepting amount as 0");
		
		//Validating successful Transaction
		tba.enterAcntsDetails(2, 1, "20");
		try {
		tba.clickonSubmit();
		}
		catch(Exception e) {
		Assert.assertFalse(tba.validate_fromAccount_DrpDwn(), "Assert failed- Unsuccessful Transaction");
		}
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
	
	
}








