package com.pages;

import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utill.SharedContext;

public class RegistrationPage {

	private WebDriver driver;
    String randomfirstName,randomLastNameInput,randomEmail;
    private By createAccountLink = By.xpath("(//a[text()='Create an Account'])[1]"); 
	private By firstName = By.id("firstname");
	private By lastName = By.id("lastname");
	private By emailID = By.id("email_address");
	private By pwd = By.id("password");
	private By confirmPwd = By.id("password-confirmation");
	private By submitBtn = By.cssSelector("button.submit");
	private By loginInfo = By.xpath("//div[@class='box box-information']//p");
	private By  headerDownArrow = By.xpath("(//span[@class='customer-name'])[1]");
	private By logout = By.xpath("(//li[@class='authorization-link'])[1]/a");
	private By successMsg = By.xpath("//div[@data-ui-id='message-success']/div");
	SharedContext context = SharedContext.getInstance();

	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegistrationPageTitle() {
		return driver.getTitle();
	}
	
	public void fillRegistrationPage() {
		randomfirstName="Auto_"+generateRandomCharacters();
		randomLastNameInput="Last_"+generateRandomCharacters();
		randomEmail=randomfirstName+randomLastNameInput+"@gmail.com";
		 context.setUsername(randomEmail);
	     context.setPassword("TestUser@123");
		System.out.println("User Name : "+context.getUsername()+" Password "+context.getPassword());

		fillInputdata(firstName,randomfirstName);
		fillInputdata(lastName,randomLastNameInput);
		fillInputdata(emailID,randomEmail);
		fillInputdata(pwd,"TestUser@123");
		fillInputdata(confirmPwd,"TestUser@123");
	}

	public void submitRegistrationForm() {
		clickAction(submitBtn);
		System.out.println("User Name : "+context.getUsername()+" Password "+context.getPassword());
	}
	
	public void clickOnCreateAccountLink() {
		clickAction(createAccountLink);
	}
	
	
	public String getRegistrationSuccessMsg() {
    return driver.findElement(successMsg).getText();
	}
	
	
	public void signOff() {	
	clickAction(headerDownArrow);
	clickAction(logout);
	}

	
	public void fillInputdata(By ele,String inputData)
	{
		driver.findElement(ele).sendKeys(inputData);
	}
	
	public void clickAction(By ele)
	{
		driver.findElement(ele).click();
	}
	
	  public static String generateRandomCharacters() {
	        Random random = new Random();     
	        return random.ints(3, 'a', 'z' + 1)
	                .mapToObj(c -> String.valueOf((char) c))
	                .collect(Collectors.joining());
	    }
	
}
