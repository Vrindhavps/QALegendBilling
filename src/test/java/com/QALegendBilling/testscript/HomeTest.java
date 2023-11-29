package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages2;
import com.QALegendBilling.pages.AddPage;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.UserPage;
import com.QALegendBilling.utilities.ExcelUtility;
import com.QALegendBilling.utilities.RandomUtility;



public class HomeTest extends Base
{
	LoginPage login;
	HomePage home;
	AddPage add;
	UserPage users;
	
	
	@Test(priority = 1, enabled = true, description = "tc_005_verifyUserSearchWithValidData()", groups = { "Smoke" })
	public void tc_005_verifyUserSearchWithValidData() { //passed

		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expUserName = data.get(1).get(0);
		String expPassword = data.get(1).get(1);
		List<ArrayList<String>> userdata = ExcelUtility.excelDataReader("AddPage");
		String expPrefix = userdata.get(1).get(0);
		String expPerc = userdata.get(1).get(1);
		String fName=RandomUtility.getfName();
		String lName=RandomUtility.getlName();
		String eMail=RandomUtility.getRandomEmail();
		String userName=fName+lName;
		String userPassword = fName+"@123";
		String cUserPassword = userPassword;
		
		
		login = new LoginPage(driver);
		login.enterUsername(expUserName);
		login.enterUserPassword(expPassword);
		home =login.clickonLoginButton();
		home.clickonUserManagement();
		users = home.clickonUserMgUsers();
		add = home.clickAddButton();
		add.enterPrefix(expPrefix);
		add.enterfName(fName);
		add.enterlName(lName);
		add.enterPassword(userPassword);
		add.enterCPassword(cUserPassword);
		add.enterUserName(userName);
		add.entereMail(eMail);
		add.enterPercentage(expPerc);
	    add.clickSaveButton();
	    users.searchuser(userName);
	    String acttableUserName = users.getusername();
	    Assert.assertEquals(acttableUserName, userName,ErrorMessages2.USERNAME_NOT_FOUND);
		
		
	}
	
	@Test(priority=1,enabled=true,description="tc_004_verifyUserManagementtabs()",groups= {"Regression"})
	
	public void tc_004_verifyUserManagementtabs() { //passed
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expUserName = data.get(1).get(0);
		String expPassword = data.get(1).get(1);
	    login= new LoginPage(driver);
		login.enterUsername(expUserName);
		login.enterUserPassword(expPassword);
		home = login.clickonLoginButton();
		home.clickonUserManagement();
		Boolean usersstatus = home.checkUsersMenuIsDisplayed();
		Boolean rolesstatus = home.checkRolesMenuIsDisplayed();
		Boolean scastatus = home.checkSCAMenuIsDisplayed();
		Assert.assertTrue(usersstatus, ErrorMessages2.USER_MENU_NOT_FOUND);
		Assert.assertTrue(rolesstatus, ErrorMessages2.ROLES_MENU_NOT_FOUND);
		Assert.assertTrue(scastatus, ErrorMessages2.SALES_MENU_NOT_FOUND);
	}
	
	

}
