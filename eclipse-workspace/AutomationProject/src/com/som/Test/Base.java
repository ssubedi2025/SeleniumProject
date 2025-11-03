package com.som.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	 WebDriver exceptionDriver;
	



	@BeforeTest
	public void openBrowser() {
		
		exceptionDriver = new ChromeDriver();
		exceptionDriver.manage().window().maximize();
		exceptionDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		exceptionDriver.get("https://test.bishalkarki.com/index.php");

	}

//	@AfterTest
	public void closeBrowser() {
//		if (exceptionDriver != null) {
//			exceptionDriver.quit();
//		}
		exceptionDriver.close();

	}

}
