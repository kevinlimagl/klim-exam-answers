package autoapp.automation.stepDef;

import autoapp.automation.pages.PersonalInfoPage;
import autoapp.automation.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDef {

    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() throws Throwable {
        RegisterPage.openApplicaiton();
    }

    @When("^I click sign in$")
    public void i_click_sign_in() throws Throwable {
        RegisterPage.clickSignIn();
    }

    @And("^I create account with emailid \"([^\"]*)\"$")
    public void i_create_account_with_emailid(String emailId) throws Throwable {
        RegisterPage.createAccount(emailId);
        Thread.sleep(5000);
    }


    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(DataTable dataTable) throws Throwable {
        PersonalInfoPage.enterPersonalInformation(dataTable);
        Thread.sleep(5000);
    }

    
    @And("^I create an account with an invalid emailid \"([^\"]*)\"$")
    public void i_create_an_account_with_an_invalid_emailid(String emailId) throws Throwable {
        RegisterPage.createAccount(emailId);
        Thread.sleep(5000);
    }
    

	@Then("^I should see an invalid email error$")
	public void i_should_see_an_invalid_email_error() throws Throwable {
		RegisterPage.verifyInvalidErrorExist();
        Thread.sleep(5000);
	}
	
    @When("^I Navigate to Summer Dresses$")
    public void i_navigate_to_summer_dresses() throws Throwable {
        RegisterPage.navigateToSummerDresses();
    }
    
	@Then("^I should see the Summer Dresses selection$")
	public void i_should_see_the_Summer_Dresses_selection() throws Throwable {
		RegisterPage.verifyPrintedSummerDressTextExist();
        Thread.sleep(5000);
	}
	
    @And("^I use the quickview to add a blue dress to the cart$")
    public void i_use_the_quickview_to_add_a_blue_dress_to_the_cart() throws Throwable {
    	RegisterPage.addBlueSummerDressToCart();
        Thread.sleep(5000);
    }
    
	@Then("^I should see the correct item in the cart summary$")
	public void i_should_see_the_correct_item_in_the_cart_summary() throws Throwable {
		RegisterPage.verifyCartItems();
        Thread.sleep(5000);
	}

}

