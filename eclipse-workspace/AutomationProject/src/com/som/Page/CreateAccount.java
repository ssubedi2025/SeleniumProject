package com.som.Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
	WebDriver driver;
	
	@FindBy(id = "email_create")
	private WebElement emailAdd;

	@FindBy(id = "SubmitCreate")
	private WebElement createAcc;
	
	@FindBy(xpath="//*[@id=\"create_account_error\"]/ol/li")
	private WebElement AlertMsg;
	
	public CreateAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		emailAdd.sendKeys(email);
	}
	
	public void createAccount() {
		createAcc.click();
	}
	public String displayErrorMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(AlertMsg));
		String errmsg = AlertMsg.getText();
		return errmsg;
	}
}
