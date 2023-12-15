package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.SignInPage;
import pages.Transfer_between_Accounts_Page;



public class Transfer_bw_Accounts_step_def {

	SignInPage sip;
	Transfer_between_Accounts_Page tba;
	
	@Given("User is on Transfer between Accounts page")
	public void user_is_on_transfer_between_accounts_page() {
	    sip = new SignInPage(BaseClass.getDriver());
	    tba = new Transfer_between_Accounts_Page(BaseClass.getDriver());
	    sip.enterSignInDetails();
	    tba.clickonTransferBetweenAcnts();
	}

	@When("Validating Reset button of Transfer between Accounts page")
	public void validating_reset_button_of_transfer_between_accounts_page() {
		tba.enterAcntsDetails(1, 2, "10");
		tba.clickonReset();
		Assert.assertTrue(tba.validate_Reset_Btn(), "Assert failed- Reset button not working");
	}

	@Then("Validating Submit button without any data")
	public void validating_submit_button_without_any_data() {
		tba.clickonSubmit();
		Assert.assertTrue(tba.validate_fromAccount_DrpDwn(), "Assert failed- Reading empty fields");
	}

	@Then("Validating Submit button with amount as zero")
	public void validating_submit_button_with_amount_as_zero() {
		tba.enterAcntsDetails(1, 2, "0");
		tba.clickonSubmit();
		System.out.println(tba.captureError());
		Assert.assertTrue(tba.validate_fromAccount_DrpDwn(), "Assert failed- Accepting amount as 0");

	}

	@Then("Validating succesful Transfer between Accounts transaction with valid credentials")
	public void validating_succesful_transfer_between_accounts_transaction_with_valid_credentials() {
		tba.enterAcntsDetails(2, 1, "20");
		try {
		tba.clickonSubmit();
		}
		catch(Exception e) {
		Assert.assertFalse(tba.validate_fromAccount_DrpDwn(), "Assert failed- Unsuccessful Transaction");
		}
	}
	
}
