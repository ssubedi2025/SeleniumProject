package com.som.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver exceptionDriver;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	private WebElement submitLogin;

	public Login(WebDriver excpetionDriver) {
		PageFactory.initElements(excpetionDriver, this);
	}

	public void doLogin(String eadd, String epass) {

		emailField.sendKeys(eadd);
		passwordField.sendKeys(epass);
		submitLogin.click();

	}

}
