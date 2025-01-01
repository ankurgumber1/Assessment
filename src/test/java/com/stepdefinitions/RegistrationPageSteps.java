package com.stepdefinitions;

import org.testng.Assert;

import com.drivermanager.DriverFactoryManager;
import com.pages.RegistrationPage;
import com.utill.SharedContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageSteps {
	String pageTitle;
	
     
	RegistrationPage regpage=new RegistrationPage(DriverFactoryManager.getDriver());
	    
	//private RegistrationPage regpage=new RegistrationPage(DriverFactoryManager.getDriver(),context);

	@Given("User is on registration page")
    public void user_is_on_registration_page() {
		DriverFactoryManager.getDriver().get("https://magento.softwaretestingboard.com/");
		 regpage.clickOnCreateAccountLink();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        // Retrieve the page title
        pageTitle = regpage.getRegistrationPageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        // Validate the page title
       Assert.assertEquals(pageTitle,expectedTitle);
    }
    
    @When("user fill the registration form from random generation data")
    public void user_fill_the_registration_form_from_random_generation_data() {
         regpage.fillRegistrationPage();
    }
    
    @When("user click on submit button")
    public void user_click_on_submit_button() {
         regpage.submitRegistrationForm();
    }
    
    @Then("user should get success message {string}")
    public void user_should_get_success_message(String expectedMsg) {
    	String actualSuccessMsg=regpage.getRegistrationSuccessMsg();
       Assert.assertEquals(actualSuccessMsg,expectedMsg);
    }

}
