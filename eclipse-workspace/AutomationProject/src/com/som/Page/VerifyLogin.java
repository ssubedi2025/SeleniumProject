package com.som.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLogin {

	@FindBy(xpath = "//div[@class ='header_user_info']/a/span")
	private WebElement userName;

	public VerifyLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String verifyUserName() {
		String uname = userName.getText();
		return uname;
		
		
	
	}

}
