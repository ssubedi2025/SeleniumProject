package com.bishalkarki.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bishalkarki.Page.Login;
import com.bishalkarki.Page.Logout;
import com.bishalkarki.Page.SignIn;
import com.bishalkarki.Page.VerifyLogin;

public class VerifyLoginLogout {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.bishalkarki.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

	}

	@Test
	public void verifyLoginLogout() {
		try {
			SignIn sgn = new SignIn(driver);
			sgn.clickSigninBtn();

			Login lgn = new Login(driver);
			lgn.doLogin("xyz@gmail.com", "test123");

			VerifyLogin vl = new VerifyLogin(driver);
			String uname = vl.verifyUserName();
			String expectedName = "Xyz info";
			Assert.assertEquals(expectedName, uname);

			Logout lgo = new Logout(driver);
			lgo.doLogout();

		} catch (Exception e) {

		}

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
