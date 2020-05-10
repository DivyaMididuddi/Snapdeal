package com.snapdeal.stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.snapdeal.genericlibraries.ExcelFile;
import com.snapdeal.pom.LoginPage;
import com.snapdeal.pom.ProfilePage;

import cucumber.api.java.en.*;

public class OrderStepDefinition {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	LoginPage loginpage = new LoginPage(driver);
	ProfilePage profilepage = new ProfilePage(driver);

	@Given("^user opens ChromeBrowsr and enters url$")
	public void user_opens_ChromeBrowsr_and_enters_url() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ExcelFile.getExcelData("url"));
	}

	@When("^clicks on signin and clicks on login$")
	public void clicks_on_signin_and_clicks_on_login() throws IOException {
		loginpage.signinButton();
		driver.get(ExcelFile.getExcelData("login"));
	}

	@Then("^enters Email$")
	public void enters_Email() throws IOException {
		loginpage.emailTxtField();

	}

	@Then("^clicks on Continue$")
	public void clicks_on_Continue() {
		loginpage.continueButton();

	}

	@Then("^enters Password$")
	public void enters_Password() throws IOException {
		loginpage.passwordTxtField();

	}

	@Then("^click on login$")
	public void click_on_login() throws IOException {
		loginpage.loginButton();

	}

	@Then("^homePage is displayed$")
	public void homepage_is_displayed() throws InterruptedException {
		Thread.sleep(4000);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Online Shopping Site India - Shop Electronics, Mobiles, Men & Women Clothing, Shoes - www. Snapdeal.com";
		Assert.assertEquals(actual, expected);
		System.out.println("Homepage is displayed");

	}

	@Then("^clicks on profile$")
	public void clicks_on_profile() throws InterruptedException {
		Thread.sleep(2000);
		profilepage.account();

	}

	@Then("^click on orders$")
	public void click_on_orders() throws InterruptedException {
		Thread.sleep(2000);
		profilepage.orders();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("Orders page is diaplyed");
		Thread.sleep(2000);
		driver.close();

	}

}
