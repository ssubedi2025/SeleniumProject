package com.som.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateItemInCart {
	WebDriver driver;
	WebDriverWait wait;
	//click Tshirt
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement clickTshirt;
	//click image
	@FindBy(xpath = "//*[@id=\"product_list\"]/li/div/div[1]/div/a[1]/img")
	private WebElement clickImageTshirt;
	//click AddToCart
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	private WebElement clickAddCartAgain;
	//
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span[2]")
	private WebElement secondProdAdded;

	@FindBy(xpath = " //span[normalize-space()='Proceed to checkout']")
	private WebElement procdChekOut;

	@FindBy(xpath = "//span[@id='total_price_without_tax']")
	private WebElement totalPrice;

	@FindBy(xpath = "//a[@id='3_13_0_0']//i[@class='icon-trash']")
	private WebElement deleteFirstProd;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	private WebElement finalcheckout;

	@FindBy(xpath = " //p[@class='info-title']")
	private WebElement navToAddAddress;

	public UpdateItemInCart(WebDriver exceptonDriver) {
		PageFactory.initElements(exceptonDriver, this);
	}

	public void addTshirt() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickTshirt));

		clickTshirt.click();
	}

	public void clickImage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickImageTshirt));
		clickImageTshirt.click();
	}

	public void clkCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickAddCartAgain));
		clickAddCartAgain.click();
	}

	public void proChkOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(procdChekOut));
		String success = secondProdAdded.getText();
		System.out.println("displays" + success);
		procdChekOut.click();
	}

	public void totalPrc() {
		String price = totalPrice.getText();
		System.out.println(price);
	}

	public void delePrice() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(deleteFirstProd));
		deleteFirstProd.click();
	}

	public void fnlCheckOut() {
		finalcheckout.click();
		String address = navToAddAddress.getText();
		System.out.println(address);
	}

}
