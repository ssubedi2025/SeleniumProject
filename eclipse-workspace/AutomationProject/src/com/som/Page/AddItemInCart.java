package com.som.Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemInCart {
	WebDriver driver;
	WebDriverWait wait;
	WebDriver exceptionDriver;

	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='Dresses']")
	private WebElement clickDresses;

	@FindBy(xpath = "//ul[@id='product_list']/li[1]/div/div[1]/div/a[@title='Printed Dress']")
	private WebElement clickImageDress;

	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	private WebElement clickAddtoCart;

	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div/span[2]")
	private WebElement prodctAddSucessMessage;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	private WebElement clickContinueShopping;

	@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
	private WebElement verifyCartProdct;

	public AddItemInCart(WebDriver exceptonDriver) {
		PageFactory.initElements(exceptonDriver, this);
	}

	public void dressPage() {
		clickDresses.click();

	}

	public void imageDressPage() {
		clickImageDress.click();
	}

	public void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickAddtoCart));
		clickAddtoCart.click();
	}

	public String successfulMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(prodctAddSucessMessage));
		return prodctAddSucessMessage.getText();

	}

	public void clickContinuShop() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(clickContinueShopping));
		clickContinueShopping.click();
	}

	public void confirmProductInCart() {
		// verifyCartProdct.isDisplayed();
		boolean status = false;
		if (verifyCartProdct.isDisplayed()) {
			status = true;
			System.out.println("Shopping is success");
		}
			if (status == false) {
				System.out.println("Shopping is not success");
			}
		
	}

}
