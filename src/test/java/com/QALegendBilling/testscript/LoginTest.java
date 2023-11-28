package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages2;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.ResetPage;
import com.QALegendBilling.utilities.ExcelUtility;

public class LoginTest extends Base {
	LoginPage login;
	HomePage home;
	ResetPage reset;

	@Test(priority=1,enabled=true,description="verifyLoginUsingValidCredentials()",groups= {"Sanity"})

	public void tc_001_verifyLoginUsingValidCredentials() { //passed
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expUsername = data.get(1).get(0);
		String expPassword = data.get(1).get(1);
		login = new LoginPage(driver);
		login.enterUsername(expUsername);
		login.enterUserPassword(expPassword);
		home = login.clickonLoginButton();
		String actualUserName = home.getUserAccountName();
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("LoginPage");
		String expectedAccountName = data1.get(1).get(2);
		Assert.assertEquals(actualUserName, expectedAccountName, ErrorMessages2.INVALID_EMAIL_ID);
	}

	@Test(priority=1,enabled=true,description="tc_003_verifyNavigationToLoginPageClickingSignOut()",groups= {"Regression"})
	public void tc_003_verifyNavigationToLoginPageClickingSignOut() {  //passed
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expUsername = data.get(1).get(0);
		String expPassword = data.get(1).get(1);
		login = new LoginPage(driver);
		login.enterUsername(expUsername);
		login.enterUserPassword(expPassword);
		home = login.clickonLoginButton();
		home.clickonSignoutButton();

	}

}
