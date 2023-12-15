package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.SignInPage;
import pages.Withdraw_from_Account_Page;

public class Withdraw_step_def {

	Withdraw_from_Account_Page wd;
	SignInPage sip;
	
	@Given("User is on Withdraw page")
	public void user_is_on_withdraw_page() {
		sip = new SignInPage(BaseClass.getDriver());
	    wd = new Withdraw_from_Account_Page(BaseClass.getDriver());
	   sip.enterSignInDetails();
	    wd.clickonWithDraw();
	}

	@When("Validating Reset button of Withdraw page")
	public void validating_reset_button_of_withdraw_page() throws InterruptedException {
		wd.enterWithdrawDetails("Individual Checking (Standard Checking)", "20");
		Thread.sleep(3000);
		wd.clickonReset();
		Thread.sleep(3000);
		Assert.assertTrue(wd.validate_Reset_Btn(), "Assert failed- Reset button not working");
	}

	@Then("Validating Submit button without data")
	public void validating_submit_button_without_data() throws InterruptedException {

		wd.clickonSubmit();
		Thread.sleep(3000);
		/*Alert alert = driver.switchTo().alert();
		String actual_alert_txt=alert.getText();
		System.out.println(actual_alert_txt);
		String expected_alert_txt = "Please select an item in the list";
		Assert.assertEquals(actual_alert_txt, expected_alert_txt);
		*/
		Assert.assertTrue(wd.validate_dropdown(), "Assert failed- Reading empty fields");

	}

	@Then("Validating Submit button with Amount as zero")
	public void validating_submit_button_with_amount_as_zero() {
		wd.enterWithdrawDetails("Individual Checking (Standard Checking)", "0");
		wd.clickonSubmit();
		Assert.assertTrue(wd.validate_error(), "Assert failed- Accepting amount as 0");
		System.out.println(wd.captureError());
		//logger.error(wd.captureError());
	}

	@Then("Validating succesful Withdraw transaction with valid credentials")
	public void validating_succesful_withdraw_transaction_with_valid_credentials() {
		wd.enterWithdrawDetails("Individual Checking (Standard Checking)", "20");
		try {
		wd.clickonSubmit();
		}
		catch(Exception e)
		{
		Assert.assertFalse(wd.validate_dropdown(),"Assert failed- Unsuccessful Transaction");
		}
	}
	
}
