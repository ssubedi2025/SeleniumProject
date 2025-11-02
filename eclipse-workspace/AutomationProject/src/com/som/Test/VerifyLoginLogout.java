package com.som.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.som.Page.Login;
import com.som.Page.Logout;
import com.som.Page.SignIn;
import com.som.Page.VerifyLogin;

public class VerifyLoginLogout extends Base {
	

	@Test
	public void verifyLoginLogout() {
		try {
			SignIn sgn = new SignIn(exceptionDriver);
			sgn.clickSigninBtn();

			Login lgn = new Login(exceptionDriver);
			lgn.doLogin("QAT@gmail.com", "test123");

			VerifyLogin vl = new VerifyLogin(exceptionDriver);
			String uname = vl.verifyUserName();
			String expectedName = "QAT TEST";
			Assert.assertEquals(expectedName, uname);

			Logout lgo = new Logout(exceptionDriver);
			lgo.doLogout();

		} catch (Exception e) {

		}

	}

	
}
