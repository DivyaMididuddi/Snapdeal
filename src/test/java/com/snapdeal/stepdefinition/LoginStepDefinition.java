package com.snapdeal.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.snapdeal.genericlibraries.BrowserUtility;
import com.snapdeal.genericlibraries.ExcelFile;
import com.snapdeal.pom.LoginPage;

import cucumber.api.java.en.*;

public class LoginStepDefinition extends BrowserUtility{
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	LoginPage loginpage = new LoginPage(driver);

	@Given("^Open ChromeBrowser and enter url$")
	public void open_ChromeBrowser_and_enter_url() throws InterruptedException, FileNotFoundException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ExcelFile.getExcelData("url"));

	}

	@Then("^click on sigin and login$")
	public void click_on_sigin_and_login() throws IOException {
		loginpage.signinButton();
	driver.get(ExcelFile.getExcelData("login"));

	}

	@Then("^enter username$")
	public void enter_username() throws IOException {
		loginpage.emailTxtField();

	}

	@When("^clicks on continue$")
	public void clicks_on_continue() {
		loginpage.continueButton();

	}

	@Then("^enter password$")
	public void enter_password() throws IOException {
		loginpage.passwordTxtField();

	}

	@When("^clicks on login$")
	public void clicks_on_login() throws IOException {
		loginpage.loginButton();

	}

	@Then("^homepage should be displayed$")
	public void homepage_should_be_displayed() throws InterruptedException {
		Thread.sleep(5000);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected="Online Shopping Site India - Shop Electronics, Mobiles, Men & Women Clothing, Shoes - www. Snapdeal.com";
		Assert.assertEquals(actual, expected);
		System.out.println("Homepage is displayed");
		Thread.sleep(2000);
		driver.close();

	}

}
