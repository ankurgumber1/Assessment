package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utill.SharedContext;

public class LoginPage {
	SharedContext context = SharedContext.getInstance();
   String getUserEmail,getUserPwd;
	private WebDriver driver;
    private By signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"); 
	private By userEmailID = By.id("email");
	private By userPwd = By.id("pass");
	private By signinBtn = By.id("send2");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUserCredentials() {
		getUserEmail=context.getUsername();
		getUserPwd=context.getPassword();
		fillInputdata(userEmailID,getUserEmail);
		fillInputdata(userPwd,getUserPwd);
	}

	public void clickOnSigninBtn() {
		clickAction(signinBtn);
	}
	
	public void clickOnSigninLink() {
		clickAction(signInLink);
		System.out.println("User Name : "+context.getUsername()+" Password "+context.getPassword());
	}
	
	public void fillInputdata(By ele,String inputData)
	{
		driver.findElement(ele).sendKeys(inputData);
	}
	
	public void clickAction(By ele)
	{
		driver.findElement(ele).click();
	}
}
