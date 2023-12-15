package stepDefinitions;


import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.SignInPage;


public class Signin {

	SignInPage sip;
	
	@When("Enter username and password to Sign In and logout")
	public void enter_username_and_password(io.cucumber.datatable.DataTable dataTable) {

		sip = new SignInPage(BaseClass.getDriver());
		
		List<Map<String, String>> userList	= dataTable.asMaps(String.class, String.class);
			
			for(Map<String, String> e : userList) {
					 //System.out.println(e.get("Username"));
				sip.enterMultipleSignIn(e.get("Username"), e.get("Password"));
				try {
					sip.logout();
					}
					catch(Exception ex)
					{
						Assert.fail("Logout is not available - Hence Unsuccessful SignIn");
					}
			}

		}
	
	
}
