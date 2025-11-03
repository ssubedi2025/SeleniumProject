package com.som.Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceSerchFilter {
	WebDriver exceptionDriver;

	@FindBy(xpath = "//form[@id='searchbox']/input[4]")
	private WebElement textField;

	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//*[@id=\"product_list\"]/li[1]/div/div[2]/h5/a")
	private WebElement searchitemDisplay;

	public AdvanceSerchFilter(WebDriver exceptonDriver) {
		PageFactory.initElements(exceptonDriver, this);
	}

	public void searchTextField() {
		textField.sendKeys("Summer");
	}

	public void clickSearchButton() {
		searchBtn.click();
	}

	public void verifySearchDisplay() {

		if (searchitemDisplay.isDisplayed()) {
			String text = searchitemDisplay.getText();
			if (text.equals("Printed Summer Dress")) {
				System.out.println("Search Filter is Sucessfully displays item: " + text);
			} else {
				System.out.println("Search Filter don't displays");
			}
		}

	}

}
