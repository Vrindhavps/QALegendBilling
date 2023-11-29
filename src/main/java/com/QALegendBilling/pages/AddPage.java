package com.QALegendBilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QALegendBilling.utilities.TestHelperUtility;

public class AddPage extends TestHelperUtility {
	public WebDriver driver;

	public AddPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _prefixField = "surname";
	@FindBy(id = _prefixField)
	private WebElement prefixField;

	private final String _fNameField = "first_name";
	@FindBy(id = _fNameField)
	private WebElement fNameField;

	private final String _lNameField = "last_name";
	@FindBy(id = _lNameField)
	private WebElement lNameField;

	private final String _eMailField = "email";
	@FindBy(id = _eMailField)
	private WebElement eMailField;

	private final String _roleField = "select2-role-container";
	@FindBy(id = _roleField)
	private WebElement roleField;

	private final String _usernameField = "username";
	@FindBy(id = _usernameField)
	private WebElement usernameField;

	private final String _passwordField = "password";
	@FindBy(id = _passwordField)
	private WebElement passwordField;

	private final String _confirmPasswordField = "confirm_password";
	@FindBy(id = _confirmPasswordField)
	private WebElement confirmPasswordField;

	private final String _salesPercentageField = "cmmsn_percent";
	@FindBy(id = _salesPercentageField)
	private WebElement salesPercentageField;

	private final String _fNameErrorMsgField = "first_name-error";
	@FindBy(id = _fNameErrorMsgField)
	private WebElement fNameErrorMsgField;

	private final String _eMailErrorMsgField = "email-error";
	@FindBy(id = _eMailErrorMsgField)
	private WebElement eMailErrorMsgField;

	private final String _passwordErrorMsgField = "password-error";
	@FindBy(id = _passwordErrorMsgField)
	private WebElement passwordErrorMsgField;

	private final String _cPasswordErrorMsgField = "confirm_password-error";
	@FindBy(id = _cPasswordErrorMsgField)
	private WebElement cPasswordErrorMsgField;

	private final String _saveButton = "submit_user_button";
	@FindBy(id = _saveButton)
	private WebElement saveButton;
	
	

	public void enterPrefix(String prefix) {
		wait.waitForElementToBeVisible(driver, prefixField);
		page.enterText(prefixField, prefix);

	}

	public void enterfName(String fName) {
		wait.waitForElementToBeVisible(driver, fNameField);
		page.enterText(fNameField, fName);
	}

	public void enterlName(String lName) {
		page.enterText(lNameField, lName);
	}

	public void entereMail(String eMail) {
		page.enterText(eMailField, eMail);
	}

	public void enterRole(String role) {
		page.enterText(roleField, role);
	}

	public void enterPassword(String password) {
		page.enterText(passwordField, password);
	}

	public void enterUserName(String username) {
		page.enterText(usernameField, username);
	}

	public void enterCPassword(String cPassword) {
		page.enterText(confirmPasswordField, cPassword);
	}

	public void enterPercentage(String percentage) {
		page.enterText(salesPercentageField, percentage);
	}
	
	public AddPage clickSaveButton() {
		//wait.setHardWait();
		page.clickOnElement(saveButton);
		return new AddPage(driver);
	}


	public String getfNameError() {
		wait.setHardWait();
		String actfNameErrorMsg = page.getElementText(fNameErrorMsgField);
		return actfNameErrorMsg;

	}

	public String geteMailError() {
		wait.setHardWait();
		String acteMailErrorMsg = page.getElementText(eMailErrorMsgField);
		return acteMailErrorMsg;
	}

	public String getpasswordError() {
		wait.setHardWait();
		String actpasswordErrorMsg = page.getElementText(passwordErrorMsgField);
		return actpasswordErrorMsg;
	}

	public String getcPasswordError() {
		wait.setHardWait();
		String actcPasswordErrorMsg = page.getElementText(cPasswordErrorMsgField);
		return actcPasswordErrorMsg;
	}
	
	
	
}
