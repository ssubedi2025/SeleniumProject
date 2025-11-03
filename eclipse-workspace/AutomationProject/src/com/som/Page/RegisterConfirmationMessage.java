package com.som.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterConfirmationMessage {

	@FindBy(css = "#center_column > p.alert.alert-success")
	private WebElement confTextMessage;

	public RegisterConfirmationMessage(WebDriver exceptonDriver) {
		PageFactory.initElements(exceptonDriver, this);
	}

	public String getconfText() {
		String confirmationMessage=confTextMessage.getText();
		return confirmationMessage;
	}
}
