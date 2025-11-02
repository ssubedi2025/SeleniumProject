package com.som.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.som.Page.CreateAccount;
import com.som.Page.SignIn;

public class VerifyRegisterConfirmation extends Base {

	@Test
	public void verifyRegistration() {

		try {

			SignIn signin = new SignIn(exceptionDriver);
			signin.clickSigninBtn();

			CreateAccount cac = new CreateAccount(exceptionDriver);
			cac.enterEmail("cm@gmail.com");
			cac.createAccount();
			
			String actualErrorMsg =cac.displayErrorMsg();
			String expectedMsg = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
			Assert.assertEquals(actualErrorMsg, expectedMsg);

	
		} catch (Exception e) {
			System.out.println("Exception details: " + e.getMessage());

		}

	}

	
}
