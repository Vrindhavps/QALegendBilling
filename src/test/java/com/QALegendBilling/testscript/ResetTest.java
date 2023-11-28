package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages2;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.ResetPage;
import com.QALegendBilling.utilities.ExcelUtility;

public class ResetTest extends Base {
	LoginPage login;
	ResetPage reset;

	@Test(priority = 1, enabled = true, description = "tc_002_verifyResetPasswordField()", groups = { "Smoke" })
	public void tc_002_verifyResetPasswordField() // passed
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPage");
		String expErrorMessage = data.get(0).get(0);
		login = new LoginPage(driver);
		reset = login.clickonForgotPassword();
		reset.enterSubEmailID();
		reset.clickonPasswordReset();
		String actEmailMessage = reset.getInvalidEmailError();
		Assert.assertEquals(expErrorMessage, actEmailMessage, ErrorMessages2.INVALID_EMAIL_ID);

	}

}
