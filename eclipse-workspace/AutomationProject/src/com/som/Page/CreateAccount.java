package com.bishalkarki.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	
	@FindBy(id = "email_create")
	private WebElement emailAdd;

	@FindBy(id = "SubmitCreate")
	private WebElement createAcc;
	
	public CreateAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		emailAdd.sendKeys(email);
	}
	
	public void createAccount() {
		createAcc.click();
	}
}
