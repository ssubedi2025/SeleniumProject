package com.bishalkarki.Test;


import org.testng.annotations.Test;
import com.bishalkarki.Page.AdvanceSerchFilter;
import com.bishalkarki.Page.Login;
import com.bishalkarki.Page.SignIn;

public class VerifyAdvanceSearchFilter extends Base {
	
	
	@Test
	public void verifyAdvanceSerchFilter() {
		try {
			SignIn sgn = new SignIn(driver);
			sgn.clickSigninBtn();

			Login lgn = new Login(driver);
			lgn.doLogin("xyz@gmail.com", "test123");

			AdvanceSerchFilter asf = new AdvanceSerchFilter(driver);
			asf.searchTextField();
			asf.clickSearchButton();
			asf.verifySearchDisplay();
		} catch (Exception e) {
			System.out.println("Exception details: " + e.getMessage());
		}

	}

	

}
