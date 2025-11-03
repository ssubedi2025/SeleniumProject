package com.som.Test;

import org.testng.annotations.Test;

import com.som.Page.UpdateItemInCart;

public class VerifyUpdateItemInCart extends Base {
	
		
	@Test
	public void updateCart() {
		
		
		UpdateItemInCart uic = new UpdateItemInCart(exceptionDriver);
		uic.addTshirt();
		
		uic.clickImage();
		
		uic.clkCart();
		
		uic.proChkOut();
		
		uic.totalPrc();
		
		uic.delePrice();
		
		uic.fnlCheckOut();
	}
	
	

}
