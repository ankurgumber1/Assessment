package com.stepdefinitions;

import org.testng.Assert;

import com.drivermanager.DriverFactoryManager;
import com.pages.LoginPage;
import com.utill.SharedContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	String pageTitle;
	private SharedContext context;
	 LoginPage loginPage=new LoginPage(DriverFactoryManager.getDriver());
   
	
	//private LoginPage loginPage=new LoginPage(DriverFactoryManager.getDriver(),context);
	
	@Given("User is on login page")
    public void user_is_on_login_page() {

		DriverFactoryManager.getDriver().get("https://magento.softwaretestingboard.com/");
		loginPage.clickOnSigninLink();
		
    }

    @When("user gets the title of the login page")
    public void user_gets_the_title_of_the_login_page() {
        // Retrieve the page title
        pageTitle = loginPage.getLoginPageTitle();
    }

    @Then("login page title should be {string}")
    public void login_page_title_should_be(String expectedTitle) {
        // Validate the page title
       Assert.assertEquals(pageTitle,expectedTitle);
    }
    @When("user input the valid credentials")
    public void user_input_the_valid_credentials() {
    	loginPage.enterUserCredentials();
    }
    
    @When("user click on signin button")
    public void user_click_on_signin_button() {
    	loginPage.clickOnSigninBtn();
    }
    
}
