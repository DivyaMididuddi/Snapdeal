package com.snapdeal.stepdefinition;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.snapdeal.genericlibraries.ExcelFile;
import com.snapdeal.pom.AddressPage;
import com.snapdeal.pom.HomePage;
import com.snapdeal.pom.LoginPage;

import cucumber.api.java.en.*;

public class AddNewAddressStepDefinition {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	AddressPage addresspage = new AddressPage(driver);

	@Given("^Open chromeBrowser and enter url$")
	public void open_chromeBrowser_and_enter_url() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ExcelFile.getExcelData("url"));

	}

	@When("^clicks on sign in and login$")
	public void clicks_on_sign_in_and_login() throws IOException {
		loginpage.signinButton();
		driver.get(ExcelFile.getExcelData("login"));
	}

	@Then("^enter username and click on continue$")
	public void enter_username_and_click_on_continue() throws IOException {
		loginpage.emailTxtField();
		loginpage.continueButton();
	}

	@When("^enters password and click on Login button$")
	public void enters_password_and_click_on_Login_button() throws IOException {
		loginpage.passwordTxtField();
		loginpage.loginButton();
	}

	@Then("^Homepage is displayed$")
	public void homepage_is_displayed() throws InterruptedException {
		Thread.sleep(4000);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Online Shopping Site India - Shop Electronics, Mobiles, Men & Women Clothing, Shoes - www. Snapdeal.com";
		Assert.assertEquals(actual, expected);
		System.out.println("Homepage is displayed");

	}

	@Then("^click on account$")
	public void click_on_account() {
		homepage.account();
	}

	@Then("^cick on orders$")
	public void cick_on_orders() throws InterruptedException {
		homepage.orders();

	}

	@When("^clicks on saved addresses$")
	public void clicks_on_saved_addresses() {
		addresspage.savedAddress();

	}

	@Then("^Saved address page is displayed$")
	public void saved_address_page_is_displayed() {
		Set<String> allwindows = driver.getWindowHandles();
		for (String currentwindow : allwindows) {
			driver.switchTo().window(currentwindow);
		}
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected="Saved Addresses";
		Assert.assertEquals(actual, expected);
		System.out.println("Address page is displayed");
	}

	@Then("^click on Add New Address$")
	public void click_on_Add_New_Address() {
		addresspage.addNewAddressBtn();

	}

	@Then("^enter data and click on save\\.$")
	public void enter_data_and_click_on_save() throws InterruptedException {
		addresspage.zip();
		addresspage.fullName();
		addresspage.address();
		addresspage.landMark();
	//	addresspage.city();
	//	addresspage.state();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)");
		addresspage.mobile();
		addresspage.homeRadioBtn();
		addresspage.save();
		Thread.sleep(2000);
		driver.close();

	}

}
