package com.bishalkarki.Test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.bishalkarki.Page.CreateAccount;
import com.bishalkarki.Page.Register;
import com.bishalkarki.Page.RegisterConfirmationMessage;
import com.bishalkarki.Page.SignIn;

public class VerifyRegisterConfirmation extends Base {

	@Test
	public void verifyRegistration() {

		try {

			SignIn signin = new SignIn(driver);
			signin.clickSigninBtn();

			CreateAccount createAcc = new CreateAccount(driver);
			createAcc.enterEmail("QAT@gmail.com");
			createAcc.createAccount();

			Register rg = new Register(driver);
			rg.doRegistration("QA", "TEST", "QAT@gmail.com", "test123");

			RegisterConfirmationMessage rcm = new RegisterConfirmationMessage(driver);
			String confirmationText = rcm.getconfText();
			String expectedMessage = "Your account has been created.";
			Assert.assertEquals(confirmationText, expectedMessage);

		} catch (Exception e) {
			System.out.println("Exception details: " + e.getMessage());

		}

	}

	
}
