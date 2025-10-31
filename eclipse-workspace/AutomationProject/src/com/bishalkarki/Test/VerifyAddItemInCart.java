package com.bishalkarki.Test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.bishalkarki.Page.AddItemInCart;
public class VerifyAddItemInCart extends Base {

	@Test
	public void verifyProdcutAddedInCart() 
	{
		try {
			AddItemInCart aic = new AddItemInCart(exceptionDriver);
		
		aic.dressPage();
		aic.imageDressPage();
		aic.addToCart();
		String successfulText=aic.successfulMessage();
		String expectedText = "Product successfully added to your shopping cart";
		Assert.assertEquals(successfulText, expectedText);
		
		

		aic.clickContinuShop();
		aic.confirmProductInCart();
		
		}catch(Exception e) {
			System.out.println("Exception message " +e);
		}
	}

	

}
