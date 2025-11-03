package com.som.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {
	

	public static void takeScreenshot(WebDriver driver, String fileName) {
	    try {
	        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(src.toPath(), Paths.get("./screenshots/" + fileName + ".png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	}



