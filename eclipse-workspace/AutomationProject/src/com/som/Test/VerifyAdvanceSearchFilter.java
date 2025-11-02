package com.som.Test;


import org.testng.annotations.Test;

import com.som.Page.AdvanceSerchFilter;
import com.som.Page.Login;
import com.som.Page.SignIn;

public class VerifyAdvanceSearchFilter extends Base {
	
	
	@Test
	public void verifyAdvanceSerchFilter() {
		try {
			SignIn sgn = new SignIn(driver);
			sgn.clickSigninBtn();

			Login lgn = new Login(driver);
			lgn.doLogin("QAT@gmail.com", "test123");

			AdvanceSerchFilter asf = new AdvanceSerchFilter(driver);
			asf.searchTextField();
			asf.clickSearchButton();
			asf.verifySearchDisplay();
		} catch (Exception e) {
			System.out.println("Exception details: " + e.getMessage());
		}

	}

	

}
