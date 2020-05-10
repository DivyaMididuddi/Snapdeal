package com.snapdeal.genericlibraries;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtility {

	public static void OpenBrowser() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		

		
	}

}
