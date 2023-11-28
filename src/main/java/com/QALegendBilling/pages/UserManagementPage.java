package com.QALegendBilling.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.QALegendBilling.utilities.TestHelperUtility;

public class UserManagementPage extends TestHelperUtility {
	public WebDriver driver;

	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	


	

}
