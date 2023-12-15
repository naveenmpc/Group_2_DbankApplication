package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.SignUpPage;

public class SignUp_Step_Def {

	//Logger logger = LogManager.getLogger(this);
	SoftAssert soft = new SoftAssert();
	SignUpPage sup;
	
	@Given("User is on SignUp page")
	public void user_is_on_sign_up_page() {
	   sup = new SignUpPage(BaseClass.getDriver());
	   //logger.info("Testing Sign Up page");
		sup.clickonSignUpHere();
	}

	@When("Check next button without any data")
	public void check_next_button_without_any_data() {
	
		sup.clickonNext();
		soft.assertTrue(sup.validate_Title_DrpDwn(), "Assert failed- Reading empty fields");
		
	}

	@Then("Check next button with already registered data")
	public void check_next_button_with_already_registered_data() {
		sup.enterSignUpDetailsPage1("Ms.","Veena", "Shankar", "10/10/1978", "123-45-1234", "pruthvishreesk58@gmail.com", "Veena@123", "Veena@123");
		sup.clickonNext();
		soft.assertTrue(sup.validate_Already_Registered_data(), "Assert failed- No error displayed");
	}

	@Then("Check next button with valid data")
	public void check_next_button_with_valid_data() {
		sup.enterSignUpDetailsPage1("Ms.","Veena", "Shankar", "10/10/1978", "166-54-8411", "pruthvihgfd@gmail.com", "Veena@123", "Veena@123");
		sup.clickonNext();
		
	}

	@Then("Check Register button without any data")
	public void check_register_button_without_any_data() {
		sup.clickonRegisterBtn();
		soft.assertTrue(sup.validate_address(), "Assert failed- Reading empty fields");
	}

	@Then("Check Register button with valid data")
	public void check_register_button_with_valid_data() throws InterruptedException {
		sup.enterSignUpDetailsPage2("SwimmingPool Extension", "Malleshwearam", "Bengaluru", "511101", "India", "6666666666", "9999999999", "7777777777");
		sup.clickonRegisterBtn();
		Thread.sleep(3000);
	}
	
}
