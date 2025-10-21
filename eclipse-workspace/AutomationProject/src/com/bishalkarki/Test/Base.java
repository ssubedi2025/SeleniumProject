package com.bishalkarki.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.bishalkarki.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
