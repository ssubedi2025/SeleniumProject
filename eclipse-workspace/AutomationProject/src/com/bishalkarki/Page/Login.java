package com.bishalkarki.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	private WebElement submitLogin;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void doLogin(String eadd, String epass) {

		emailField.sendKeys(eadd);
		passwordField.sendKeys(epass);
		submitLogin.click();

	}

}
