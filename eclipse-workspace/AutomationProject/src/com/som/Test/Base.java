package com.som.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {
	WebDriver exceptionDriver;
	WebDriver driver;
//	WebDriverWait wait;

	@BeforeMethod
	public void openBrowser() {
		exceptionDriver = new ChromeDriver();
	//	capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		exceptionDriver.manage().window().maximize();
	//	driver.get("http://www.automationpractice.pl/index.php");
	
		exceptionDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		exceptionDriver.get("https://test.bishalkarki.com/index.php");
	

	}
	@AfterMethod       
	public void closeBrowser() 
	{
		if (exceptionDriver != null) {
			exceptionDriver.quit();
    }
		
	}

}
