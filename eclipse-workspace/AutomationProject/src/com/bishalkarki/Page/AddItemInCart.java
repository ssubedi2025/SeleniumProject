package com.bishalkarki.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemInCart {
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement signin;
	
	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	private WebElement submitLogin;

	//click on WOMEN
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement clickWomanBtn;
	//select first item in shopping cart
	@FindBy(xpath = "//*[@id=\"product_list\"]/li[1]/div/div[1]/div/a[1]/img")
	private WebElement selectFirstItem;
	//Add First item in shopping cart
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	private WebElement addFirstInCart;
	//Verify product successfully added to your shopping cart
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span[2]")
	private WebElement verifyProductAdded;
	//Click on Continue shopping button
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	private WebElement clickContinueShoping;
	//Click on DRESSES button
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement clicDressesBtn;
	//Select Third Item Printed Summer Dress in shopping cart
	@FindBy(xpath = "//*[@id=\"product_list\"]/li[3]/div/div[1]/div/a[1]/img")
	private WebElement selectThirdItem;

	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	private WebElement addThirdInCart;
	//Verify there are 2 items in your cart
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/span/span[1]")
	private WebElement totalItemInCart;
	//Proceed to checkout 
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private WebElement proceedToCheckOut;
	
	//Verify Cart has 2 items total price
	@FindBy(id="total_price_without_tax")
	private WebElement totalPrice;

	public AddItemInCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSigninBtn() {
		signin.click();
	}

	public void doLogin(String eadd, String epass) {

		emailField.sendKeys(eadd);
		passwordField.sendKeys(epass);
		submitLogin.click();

	}
	public void clickWoman() {
		clickWomanBtn.click();
	}
	public void selectItem() {
		selectFirstItem.click();
	}
	public void addItem() {
		addFirstInCart.click();
	}
	public void verifyProductAdd() {
		String cart1 =verifyProductAdded.getText();
		System.out.println(cart1 + "displays");
		clickContinueShoping.click();
	}
	public void clickDresses() {
		clickWomanBtn.click();
	}
	public void selectItem2() {
		selectThirdItem.click();
		
	}
	public void addItem3() {
		addThirdInCart.click();
	}
	public void totalProdctInCart() {
		String totalprodincart =totalItemInCart.getText();
		System.out.println(totalprodincart + "displays");
	}
	public void contiueCheckOut() {
		proceedToCheckOut.click();
	}
	public void verifyTotalPrice() {
		String totalAmt = totalPrice.getText();
		System.out.println(totalAmt + "displays");
	}
}
