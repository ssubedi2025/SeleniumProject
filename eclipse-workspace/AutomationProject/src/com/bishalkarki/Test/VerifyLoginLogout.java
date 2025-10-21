package com.bishalkarki.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.bishalkarki.Page.Login;
import com.bishalkarki.Page.Logout;
import com.bishalkarki.Page.SignIn;
import com.bishalkarki.Page.VerifyLogin;

public class VerifyLoginLogout extends Base {
	

	@Test
	public void verifyLoginLogout() {
		try {
			SignIn sgn = new SignIn(driver);
			sgn.clickSigninBtn();

			Login lgn = new Login(driver);
			lgn.doLogin("QAT@gmail.com", "test123");

			VerifyLogin vl = new VerifyLogin(driver);
			String uname = vl.verifyUserName();
			String expectedName = "QA TEST";
			Assert.assertEquals(expectedName, uname);

			Logout lgo = new Logout(driver);
			lgo.doLogout();

		} catch (Exception e) {

		}

	}

	
}
