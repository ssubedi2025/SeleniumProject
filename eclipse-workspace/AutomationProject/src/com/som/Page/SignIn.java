package com.bishalkarki.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement signin;
	
	
	public SignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickSigninBtn() {
		signin.click();
	}
}
