package com.QALegendBilling.testscript;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages2;
import com.QALegendBilling.pages.AddNewProductPage;
import com.QALegendBilling.pages.AddPage;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.UserPage;
import com.QALegendBilling.utilities.ExcelUtility;
import com.QALegendBilling.utilities.RandomUtility;

public class AddTest extends Base {
	HomePage home;
	LoginPage login;
	UserPage users;
	AddPage add;
	AddNewProductPage addnewproductpage;
	
	
	@Test(priority=1,enabled=true,description="tc_006_verifyErrorMessageDisplayedWithoutFillingMandatoryFieldinAddUser()",groups= {"Sanity"})
	
	public void tc_006_verifyErrorMessageDisplayedWithoutFillingMandatoryFieldinAddUser()//passed
	{
	
	List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
	String expUserName = data.get(1).get(0);
	String expPassword = data.get(1).get(1);
	List<ArrayList<String>> errordata =ExcelUtility.excelDataReader("AddPage");
	String expErrorMsg = errordata.get(1).get(2);
	
	login = new LoginPage(driver);
	login.enterUsername(expUserName);
	login.enterUserPassword(expPassword);
	home =login.clickonLoginButton();
	home.clickonUserManagement();
	users = home.clickonUserMgUsers();
	add= home.clickAddButton();
    add.clickSaveButton();
     
	String actfNameErrorMsg = add.getfNameError();
	String acteMailErrorMsg= add.geteMailError();
	String actpasswordErrorMsg = add.getpasswordError();
	String actcPasswordErrorMsg = add.getcPasswordError(); 
	Assert.assertEquals(actfNameErrorMsg, expErrorMsg,ErrorMessages2.INVALID_FNAME);
	Assert.assertEquals(acteMailErrorMsg, expErrorMsg,ErrorMessages2.INVALID_EMAIL);
	Assert.assertEquals(actpasswordErrorMsg, expErrorMsg,ErrorMessages2.INVALID_PASSWORD);
	Assert.assertEquals(actcPasswordErrorMsg, expErrorMsg,ErrorMessages2.INVALID_CPASSWORD);
	}
	
	@Test(priority=1,enabled=true,description="tc_007_verifyUserLoginWithNewlyAddedUser()",groups= {"Sanity"})
	public void tc_007_verifyUserLoginWithNewlyAddedUser() //Passed
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expUserName = data.get(1).get(0);
		String expPassword = data.get(1).get(1);
		List<ArrayList<String>> userdata = ExcelUtility.excelDataReader("AddPage");
		String expPrefix = userdata.get(1).get(0);
		String expPerc = userdata.get(1).get(1);
		String exphomePageTitle = userdata.get(1).get(3);
		String fName=RandomUtility.getfName();
		String lName=RandomUtility.getlName();
		String eMail=RandomUtility.getRandomEmail();
		String userName=fName+lName;
		String userPassword = fName+"@123";
		String cUserPassword = userPassword;
		
		
		login = new LoginPage(driver);
		login.enterUsername(expUserName);
		login.enterUserPassword(expPassword);
		home=login.clickonLoginButton();
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
		home=users.clickonHomeMenu();
		login=home.clickonSignoutButton();
		login.enterUsername(userName);
		login.enterUserPassword(userPassword);
		home = login.clickonLoginwithoutEndTourButton();
		String acthomeTitle = home.getHomePageTitle();
		Assert.assertEquals(acthomeTitle, exphomePageTitle,ErrorMessages2.INVALID_TITLE);
	    
		
	}
	
	@Test(priority = 1, enabled = true, description = "tc_008_verifyDeleteUser()", groups = { "Smoke" })
	public void tc_008_verifyDeleteUser() //passed
	{
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
		users =home.clickonUserMgUsers();
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
	    users.clickonDeleteButton();
	    users.clickonokDeleteButton();
	    Boolean actDeleteMessage = users.checkDeleteUserErrorIsDisplayed();
	    Assert.assertTrue(actDeleteMessage,ErrorMessages2.USER_NOT_FOUND);
		
	}
	
	@Test(priority = 1, enabled = true, description = "tc_009_verifyAddNewProduct()", groups = { "Smoke" })
	
	public void tc_009_verifyAddNewProduct() throws AWTException, InterruptedException {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(1).get(0);
		String exppassword = data.get(1).get(1);
		login = new LoginPage(driver);
		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.ClickonProducts();
		addnewproductpage = home.ClickonAddProduct();
		addnewproductpage.ClickonBrowse();
	}
	
	@Test(priority=1,enabled=true,description="tc_010_verifyShowEntries()",groups= {"Sanity"})
	public void tc_010_verifyShowEntries() //passed
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expUserName = data.get(1).get(0);
		String expPassword = data.get(1).get(1);
		login = new LoginPage(driver);
		login.enterUsername(expUserName);
		login.enterUserPassword(expPassword);
		home =login.clickonLoginButton();
		home.clickonUserManagement();
		users =home.clickonUserMgUsers();
		users.clickshowentries();
		users.selectEntries();
	    
	}
}