package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BaseClass;
import pages.Search_TRN_ViewSaving_Page;
import pages.SignInPage;

public class SearchTRN_ViewSaving_step_def {

	SignInPage sip;
	Search_TRN_ViewSaving_Page strn;

	@Given("User is on View Savings page")
	public void user_is_on_view_savings_page() {
	   sip = new SignInPage(BaseClass.getDriver());
	   strn = new Search_TRN_ViewSaving_Page(BaseClass.getDriver());
	   sip.enterSignInDetails();
	   strn.clickSavingPage();
	}

	@Then("Validate Search box with valid TRN on View Savings")
	public void validate_search_box_with_valid_trn_on_view_savings() {
		
		strn.searchtrn("845586545");
	}

	@Then("Validate Search box with invalid TRN on View Savings")
	public void validate_search_box_with_invalid_trn_on_view_savings() {
		String expected_txt = "No matching records found";
		strn.searchtrn("845586877");
		Assert.assertEquals(strn.capturetext(), expected_txt);
	}
}
