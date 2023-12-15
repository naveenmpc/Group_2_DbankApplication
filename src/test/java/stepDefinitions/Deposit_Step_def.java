package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.Deposit_into_Account_Page;
import pages.SignInPage;

public class Deposit_Step_def {

	SignInPage sip;
	Deposit_into_Account_Page ds;
	
	@Given("User is on Deposit page")
	public void user_is_on_deposit_page() {
	    sip = new SignInPage(BaseClass.getDriver());
	    ds = new Deposit_into_Account_Page(BaseClass.getDriver());
	    sip.enterSignInDetails();
	    ds.clickonDeposit();
	}

	@When("Validating Reset button")
	public void validating_reset_button() {
		ds.clickonReset();
		Assert.assertTrue(ds.validate_Reset_Btn(), "Assert failed- Reset button not working");
	}

	@Then("Validating Submit button with no data")
	public void validating_submit_button_with_no_data() throws InterruptedException {
		ds.clickonSubmit();
		Thread.sleep(3000);
		Assert.assertTrue(ds.validate_dropdown(), "Assert failed- Reading empty fields");
		
	}

	@Then("Validating Submit button with Amount field as zero")
	public void validating_submit_button_with_amount_field_as_zero() {
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "0");
		ds.clickonSubmit();
		Assert.assertTrue(ds.validate_error(), "Assert failed- Reading amount as 0");
		System.out.println(ds.captureError());
		//logger.error(ds.captureError());
	}

	@Then("Validating succesful deposit transaction with valid credentials")
	public void validating_succesful_deposit_transaction_with_valid_credentials() {
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "9");
		ds.clickonSubmit();
	
	}

	
}
