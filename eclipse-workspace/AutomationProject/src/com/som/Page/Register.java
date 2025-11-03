package com.som.Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id = "id_gender1")
	private WebElement title;
	
	@FindBy(id = "customer_firstname")
	private WebElement fName;
	
	@FindBy(id = "customer_lastname")
	private WebElement lName;
	
	@FindBy(id = "email")
	private WebElement emailadd;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "days")
	private WebElement dobD;
	
	@FindBy(id = "months")
	private WebElement dobM;
	
	@FindBy(id = "years")
	private WebElement dobY;
	
	@FindBy(css = "#submitAccount > span")
	private WebElement clickRegBtn;
	
	
	public Register(WebDriver exceptonDriver) {
		PageFactory.initElements(exceptonDriver, this);
		//selenium has inbuilt class PageFactory which has method init and initialize all the method
		// on this particular class on the driver.
	}
	
	//verify radio button is checked for Male 	
	public void doRegistration(String fname, String lname, String email, String passwd) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		title= wait.until(ExpectedConditions.elementToBeClickable(title));
		title.click();
		
		fName.sendKeys(fname);
		lName.sendKeys(lname);
		
		String emailfield=emailadd.getAttribute("value");
		if(emailfield != null && !emailfield.isEmpty()) {
			System.out.println("Emmail is already populated: " + emailfield);
		}else {
			
			System.out.println("New Email entered: " + email);
			emailadd.sendKeys(email);
			
		}
		
	//	emailadd.sendKeys(email);
		password.sendKeys(passwd);
		
		Select dobd = new Select(dobD);
		dobd.selectByValue("1");
		
		Select dobm = new Select(dobM);
		dobm.selectByValue("1");
		
		Select doby = new Select(dobY);
		doby.selectByValue("2000");
		
		clickRegBtn.click();
		
	}
	
	

}
