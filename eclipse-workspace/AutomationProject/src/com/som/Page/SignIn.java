package com.som.Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {
WebDriver driver;
//	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	@FindBy(xpath=" //*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement clickSignIn;
	
	
	public SignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickSigninBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickSignIn));
		clickSignIn.click();
	}
}
