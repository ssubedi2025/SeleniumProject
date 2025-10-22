package com.bishalkarki.Test;


import org.testng.annotations.Test;
import com.bishalkarki.Page.AddItemInCart;
public class VerifyAddItemInCart extends Base {

	@Test
	public void verifyAddItemIncart() {
		try {
		AddItemInCart aic = new AddItemInCart(driver);
		aic.clickWoman();
		aic.selectItem();
		aic.addItem();
		aic.verifyProductAdd();
		aic.clickDresses();
		aic.selectItem2();
		aic.addItem3();
		aic.totalProdctInCart();
		aic.contiueCheckOut();
		aic.verifyTotalPrice();
		
		}catch(Exception e) {
			System.out.println("Exception message " +e);
		}
	}

	

}
