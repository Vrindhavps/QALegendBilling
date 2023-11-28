package com.QALegendBilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QALegendBilling.utilities.TestHelperUtility;


public class UserPage extends TestHelperUtility {
	public WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _prefixField = "//input[@id='surname']";
	@FindBy(xpath = _prefixField)
	private WebElement prefixField;

	private final String _usernameField = "//input[@class='form-control input-sm']";
	@FindBy(xpath = _usernameField)
	private WebElement usernameField;

	private final String _uNameTableField = "//table[@id='users_table']//tbody//tr//td[1]";
	@FindBy(xpath = _uNameTableField)
	private WebElement uNameTableField;
	
	private final String _actUsernameField = "//a[@class='dropdown-toggle']//span";
	@FindBy(xpath = _actUsernameField)
	private WebElement actUsernameField;

	private final String _signoutButton = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']";
	@FindBy(xpath = _signoutButton)
	private WebElement signoutButton;

	private final String _deleteButton = "//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath = _deleteButton)
	private WebElement deleteButton;
	
	private final String _okdeleteButton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _okdeleteButton)
	private WebElement okdeleteButton;
	
	private final String _deleteErrorMsgField = "//td[@class='dataTables_empty']";
	@FindBy(xpath = _deleteErrorMsgField)
	private WebElement deleteErrorMsgField;
	
	private final String _HomeField = "//i[@class='fa fa-dashboard']//following-sibling::span";
	@FindBy(xpath = _HomeField)
	private WebElement HomeField;
	
	public void searchuser(String uName) {
		wait.waitForElementToBeVisible(driver, usernameField);
		page.enterText(usernameField, uName);
	}
	public String getusername()
	{
		wait.waitForElementToBeVisible(driver, uNameTableField);
		String uName = page.getElementText(uNameTableField);
    	return uName;
	}
	public boolean checkDeleteUserErrorIsDisplayed() {
	wait.waitForElementToBeVisible(driver, deleteErrorMsgField);
	Boolean userstatus = page.isDisplayed(deleteErrorMsgField);
	return userstatus;
}
	public HomePage clickonHomeMenu()
	{
		page.clickOnElement(HomeField);
		return new HomePage(driver); 
		
	}
	public void clickonDeleteButton()
	{
		wait.waitForElementToBeVisible(driver, deleteButton);
		page.clickOnElement(deleteButton);
	}
	public void clickonokDeleteButton() {
	   page.clickOnElement(okdeleteButton);
	}
}
