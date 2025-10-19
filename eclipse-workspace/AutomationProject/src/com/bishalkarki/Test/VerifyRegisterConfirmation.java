package com.bishalkarki.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bishalkarki.Page.CreateAccount;
import com.bishalkarki.Page.Register;
import com.bishalkarki.Page.RegisterConfirmationMessage;
import com.bishalkarki.Page.SignIn;

public class VerifyRegisterConfirmation {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.bishalkarki.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

	}

	@Test
	public void verifyRegistration() {

		try {

			SignIn signin = new SignIn(driver);
			signin.clickSigninBtn();

			CreateAccount createAcc = new CreateAccount(driver);
			createAcc.enterEmail("rru@gmail.com");
			createAcc.createAccount();

			Register rg = new Register(driver);
			rg.doRegistration("Mike", "Wright", "rru@gmail.com", "testmike");

			RegisterConfirmationMessage rcm = new RegisterConfirmationMessage(driver);
			String confirmationText = rcm.getconfText();
			String expectedMessage = "Your account has been created.";
			Assert.assertEquals(confirmationText, expectedMessage);

		} catch (Exception e) {
			System.out.println("Exception details: " + e.getMessage());

		}

	}
}
