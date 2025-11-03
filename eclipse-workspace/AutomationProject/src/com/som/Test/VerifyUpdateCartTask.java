package com.som.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyUpdateCartTask {

	WebDriver driver;
	WebDriverWait wait;
	WebElement clkDress, firstProd, clkProdImg, successMsg, procedChekOut;
	WebElement iframe, clkAddToCart;
	WebElement summaryPage, finalCheckOut;
	WebElement updCartAddProd, deleteProd, removeProd, viewMyShopCart, alertMessage;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.bishalkarki.com/index.php?");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void doUpdateShoppingCart() {
		// click DRESSES on the menu Button
		clkDress = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		clkDress.click();

		// Mouse Hover on the image
		Actions actions = new Actions(driver);
		firstProd = driver.findElement(By.cssSelector(
				"#product_list > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-in-line.first-item-of-tablet-line.last-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img"));
		actions.moveToElement(firstProd).perform();
		// click Add to cart button

		// applying explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		clkProdImg = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#product_list > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-in-line.first-item-of-tablet-line.last-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")));
		clkProdImg.click();

		// verify Product successfully added to your shopping car
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		successMsg = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span.title")));
		String productAdded = successMsg.getText();
		System.out.println(productAdded);

		// click on Proceed to Checkout
		procedChekOut = driver.findElement(By.cssSelector(
				"#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span"));
		procedChekOut.click();

		// verify Summary displays
		summaryPage = driver.findElement(By.xpath("//*[@id=\"order_step\"]/li[1]/span"));
		summaryPage.getText();

		// final proceed to checkout
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		finalCheckOut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")));
		finalCheckOut.click();

		// Update ( Deleting product in shopping car)
		Actions act = new Actions(driver);
		deleteProd = driver
				.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
		act.moveToElement(deleteProd).perform();
		// applying explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		removeProd = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#header > div:nth-child(3) > div > div > div:nth-child(3) > div > div > div > div > dl > dt > span > a")));
		removeProd.click();

		// View my shopping cart
		viewMyShopCart = driver
				.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
		viewMyShopCart.click();

		// alert message displays verify it
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#center_column > p")));
		String removeSuccessMsg = alertMessage.getText();
		System.out.println("Shopping cart is update by deleteing prodcut: " + removeSuccessMsg);
		String expectedMessage = "Your shopping cart is empty.";
		Assert.assertEquals(removeSuccessMsg, expectedMessage);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
