package com.QALegendBilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QALegendBilling.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _usernameField = "username";
	@FindBy(id = _usernameField)
	private WebElement usernameField;

	private final String _passwordField = "password";
	@FindBy(id = _passwordField)
	private WebElement passwordField;

	private final String _loginButton = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _loginButton)
	private WebElement loginButton;

	private final String _endTourButton = "//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _endTourButton)
	private WebElement endTourButton;

	private final String _subEmailField = "newsletter-email";
	@FindBy(id = _subEmailField)
	private WebElement subEmailField;

	private final String _forgotPassword = "//a[@class='btn btn-link']";
	@FindBy(xpath = _forgotPassword)
	private WebElement forgotPassword;

	public void enterUsername(String username) {
		wait.waitForElementToBeVisible(driver, usernameField);
		page.enterText(usernameField, username);
	}

	public void enterUserPassword(String password) {
		page.enterText(passwordField, password);
	}

	public HomePage clickonLoginButton() {
		page.clickOnElement(loginButton);
		page.clickOnElement(endTourButton);
		return new HomePage(driver);
	}

	public HomePage clickonLoginwithoutEndTourButton() {
		page.clickOnElement(loginButton);
		return new HomePage(driver);
	}

	public ResetPage clickonForgotPassword() {
		page.clickOnElement(forgotPassword);
		return new ResetPage(driver);
	}

	public void enterSubEmailID() {
		String emailID = random.getRandomEmail();
		page.enterText(subEmailField, emailID);
	}

	public String getLoginPageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}

	public void clickonLoginButton1() {
		page.clickOnElement(loginButton);
	}
}