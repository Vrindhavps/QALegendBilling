package com.QALegendBilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QALegendBilling.utilities.TestHelperUtility;



public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _emailField = "Email";
	@FindBy(id = _emailField)
	private WebElement emailField;

	private final String _actUsernameField = "//a[@class='dropdown-toggle']//span";
	@FindBy(xpath = _actUsernameField)
	private WebElement actUsernameField;

	private final String _signoutButton = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']";
	@FindBy(xpath = _signoutButton)
	private WebElement signoutButton;

	private final String _userManagement = "//a//span[@class='title'][1]";
	@FindBy(xpath = _userManagement)
	private WebElement userManagement;

	private final String _userManagementUsers = "//i[@class='fa fa-user']//following-sibling::span";
	@FindBy(xpath = _userManagementUsers)
	private WebElement userManagementUsers;

	private final String _userManagementRoles = "//i[@class='fa fa-briefcase']//following-sibling::span";
	@FindBy(xpath = _userManagementRoles)
	private WebElement userManagementRoles;

	private final String _userManagementSCA = "//i[@class='fa fa-handshake-o']//following-sibling::span";
	@FindBy(xpath = _userManagementSCA)
	private WebElement userManagementSCA;
	
	private final String _addButton = "//a[@class='btn btn-block btn-primary']//i[@class='fa fa-plus']";
	@FindBy(xpath = _addButton)
	private WebElement addButton;
	
	private final String _Products = "//i[@class='fa fa-cubes']//following-sibling::span";
	@FindBy(xpath = _Products)
	private WebElement Products;
	
	private final String _addProduct = "//a[text()='Add Product']";
	@FindBy(xpath = _addProduct)
	private WebElement addProduct;
	
	
	public String getUserAccountName() {
		wait.setHardWait(); 
		String actUserAccountName = page.getElementText(actUsernameField);
		return actUserAccountName;
	}

	public LoginPage clickonSignoutButton() {
		wait.waitForElementToBeVisible(driver, actUsernameField);
		page.clickOnElement(actUsernameField);
		wait.waitForElementToBeVisible(driver, signoutButton);
		page.clickOnElement(signoutButton);
		return new LoginPage(driver);
	}

	public void clickonUserManagement() {
		wait.waitForElementToBeVisible(driver, userManagement);
		page.clickOnElement(userManagement);
	}
	public UserPage clickonUserMgUsers()
	{
		wait.waitForElementToBeVisible(driver, userManagementUsers);
		page.clickOnElement(userManagementUsers);
		return new UserPage(driver);
	}

	public boolean checkUsersMenuIsDisplayed() {
		wait.waitForElementToBeVisible(driver, userManagementUsers);
		Boolean userstatus = page.isDisplayed(userManagementUsers);
		return userstatus;
	}

	public boolean checkRolesMenuIsDisplayed() {
		wait.waitForElementToBeVisible(driver, userManagementRoles);		
		Boolean rolestatus = page.isDisplayed(userManagementRoles);
	    return rolestatus;
	}

	public boolean checkSCAMenuIsDisplayed() {
		wait.waitForElementToBeVisible(driver, userManagementSCA);
		Boolean SCAstatus = page.isDisplayed(userManagementSCA);
		return SCAstatus;
	}
	public AddPage clickAddButton()
	{
		page.clickOnElement(addButton);
		return new AddPage(driver);
	}
	
	public String getHomePageTitle()
	{
		String homeTitle = page.getPageTitle(driver);
		return homeTitle;
	}
	public void ClickRolesunderUserManagement()
	{
		wait.waitForElementToBeVisible(driver, userManagementRoles);
		page.clickOnElement(userManagementRoles);
	}
	public void ClickonProducts()
	{
		wait.waitForElementToBeVisible(driver, Products);
		page.clickOnElement(Products);
	}
	public AddNewProductPage ClickonAddProduct()
	{
		wait.waitForElementToBeVisible(driver,addProduct);
		page.clickOnElement(addProduct);
		return new AddNewProductPage(driver);
		
	}
}
