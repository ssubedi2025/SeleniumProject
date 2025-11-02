package com.som.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	@FindBy(css = "a.logout[title='Log me out']")
	private WebElement logoutLink;

	public Logout(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void doLogout() {
		logoutLink.click();
	}

}
