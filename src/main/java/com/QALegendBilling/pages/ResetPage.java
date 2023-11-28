package com.QALegendBilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QALegendBilling.utilities.TestHelperUtility;

public class ResetPage extends TestHelperUtility {
	public WebDriver driver;

	public ResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private final String _emailField = "Email";
	@FindBy(id = _emailField)
	private WebElement emailField;
	
			private final String _subEmailField = "//input[@id='email']"; 
			@FindBy(xpath = _subEmailField ) 
			private WebElement subEmailField;
			

			private final String _sendPasswordReset = "//button[@class='btn btn-primary']";
			@FindBy(xpath = _sendPasswordReset ) 
			private WebElement sendPasswordReset;
			
	
	
	private final String _actEmailError = "//span[@class='help-block']/strong";
	@FindBy(xpath = _actEmailError)
	private WebElement actEmailError;
	
	
	
	public void clickonPasswordReset() {
		page.clickOnElement(sendPasswordReset);
	}
	
	public void enterSubEmailID() 
	{
		String emailID = random.getRandomEmail();
		page.enterText(subEmailField, emailID);
	}
	
	public String getInvalidEmailError()
	{
		wait.setHardWait();
		String actEmailErrorMessage = page.getElementText(actEmailError);
		return actEmailErrorMessage;
	}
}