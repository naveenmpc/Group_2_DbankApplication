package stepDefinitions;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.Direct_Payment_to_Visa_Page;
import pages.SignInPage;

public class Visa_Payment_step_def {

	SoftAssert soft = new SoftAssert();
	SignInPage sip;
	Direct_Payment_to_Visa_Page vp;
	
	@Given("User is on  Visa Direct Transfer page")
	public void user_is_on_visa_direct_transfer_page() {
	    sip = new SignInPage(BaseClass.getDriver());
	    vp = new Direct_Payment_to_Visa_Page(BaseClass.getDriver());
	    sip.enterSignInDetails();
	    vp.clickonVisaTransfer();
	}

	@Then("Validating Submit button without filling any fields")
	public void validating_submit_button_without_filling_any_fields() {
		vp.clickonSubmit();
		soft.assertTrue(vp.validate_select_Acnt(), "Assert failed- Reading empty fields");
	}

	@When("Validating Select Account drop-down without selecting actual account")
	public void validating_select_account_drop_down_without_selecting_actual_account() {
		vp.enterTransferDetails(0, "80");
		vp.clickonSubmit();
		soft.assertFalse(vp.ServiceError(), "Assert failed- Reading data without selecting Account");//fail
	}

	@Then("Validating Submit button with zero amount field")
	public void validating_submit_button_with_zero_amount_field() {
		vp.clickonVisaTransfer();
		  vp.enterTransferDetails(1, "0"); 
		  vp.clickonSubmit();
		  soft.assertFalse(vp.ServiceError(),"Assert failed - Accepting 0 amount");//fail
	}

	@Then("Validating Submit button with amount as decimals more than two")
	public void validating_submit_button_with_amount_as_decimals_more_than_two() {
		vp.clickonVisaTransfer();
		  vp.enterTransferDetails(1, "0.001"); 
		  vp.clickonSubmit();
		  soft.assertFalse(vp.ServiceError(), "Assert failed - Accepting any number of digits after decimal Amount");//fail
		  
	}

	@Then("Validating succesful Visa Direct Transfer transaction with valid credentials")
	public void validating_succesful_visa_direct_transfer_transaction_with_valid_credentials() {
		vp.clickonVisaTransfer();
		  vp.enterTransferDetails(1, "20"); 
		  vp.clickonSubmit();
		  soft.assertFalse(vp.ServiceError(), "Assert failed - Unsucessful transaction - service Unavailable");//fail
		 soft.assertAll();
	}
	
}
