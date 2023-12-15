package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BaseClass;
import pages.Search_TRN_ViewChecking_Page;
import pages.SignInPage;

public class SearchTRN_ViewChecking_step_def {

	SignInPage sip;
	Search_TRN_ViewChecking_Page strn;
	
	@Given("User is on View Checking page")
	public void user_is_on_view_checking_page() {
	    sip = new SignInPage(BaseClass.getDriver());
	    strn = new Search_TRN_ViewChecking_Page(BaseClass.getDriver());
	    sip.enterSignInDetails();
	    strn.clickonCheckingPage();
	}

	@Then("Validate Search box with valid TRN")
	public void validate_search_box_with_valid_trn() {
		strn.searchtrn("845586594");
	}

	@Then("Validate Search box with invalid TRN")
	public void validate_search_box_with_invalid_trn() {
		
		String expected_txt = "No matching records found";
		strn.searchtrn("845586877");
		Assert.assertEquals(strn.capturetext(), expected_txt);
	}

	
}
