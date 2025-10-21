package com.bishalkarki.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bishalkarki.Page.AdvanceSerchFilter;
import com.bishalkarki.Page.Login;
import com.bishalkarki.Page.SignIn;

public class VerifyAdvanceSearchFilter {
	
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.bishalkarki.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

	}

	@Test
	public void verifyAdvanceSerchFilter() {
		try {
			SignIn sgn = new SignIn(driver);
			sgn.clickSigninBtn();

			Login lgn = new Login(driver);
			lgn.doLogin("xyz@gmail.com", "test123");

			AdvanceSerchFilter asf = new AdvanceSerchFilter(driver);
			asf.searchTextField();
			asf.clickSearchButton();
			asf.verifySearchDisplay();
		} catch (Exception e) {
			System.out.println("Exception details: " + e.getMessage());
		}

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
