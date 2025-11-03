package com.som.Test;

import org.testng.annotations.Test;

import com.som.Page.CreateAccount;
import com.som.Page.Register;
import com.som.Page.SignIn;

public class VerifyRegister extends Base {
	
	@Test
	public void getverifyRegister() {

		try {
			
			SignIn sg = new SignIn(exceptionDriver);
			sg.clickSigninBtn();
			
			CreateAccount ca = new CreateAccount(exceptionDriver);
			ca.enterEmail("cm@gmail.com");
			ca.createAccount();
			
			Register rg = new Register(exceptionDriver);
			rg.doRegistration("cat", "mat", "cm@gmail.com", "test123");
			
			
			
		} catch (Exception e) {

		}
	}
}
