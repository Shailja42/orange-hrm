package addproduct.stepDefinations;

import java.awt.AWTException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.BaseTest;

public class LoginStepDef extends BaseTest {

	@Given("I landed on Ecommerece page")
	public void I_landed_on_walmart_page() throws IOException {
		
		launch();		
	}
	
	@Given ("^I login with username (.+) and password (.+)$")
	public void loggedin_with_username_and_password(String username, String password) throws InterruptedException
	{
		login(username, password);
	}
	
	
	
	@Then("^I add employee with firstname (.+) name and (.+) last name$")
	public void I_add_an_employee(String fname , String lname) throws AWTException {
		add_employee(fname,lname);
	   
	}
	
	@Then("I edit employee details")
	public void I_edit_employee_details() throws InterruptedException, AWTException
	{
		edit_employee();
	}

	

}
