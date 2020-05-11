package com.snapdeal.stepdefinition;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.snapdeal.genericlibraries.ExcelFile;
import com.snapdeal.pom.GiftCardsPage;
import com.snapdeal.pom.HomePage;
import com.snapdeal.pom.LoginPage;

import cucumber.api.java.en.*;

public class BuyingGiftCardStepDefintion {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	GiftCardsPage giftpage = new GiftCardsPage(driver);

	@Given("^open ChromeBrowser and enter url$")
	public void open_ChromeBrowser_and_enter_url() throws IOException {
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ExcelFile.getExcelData("url"));

	}

	@Then("^clicks on Signin and clicks on Login$")
	public void clicks_on_Signin_and_clicks_on_Login() throws IOException {
		loginpage.signinButton();
		loginpage.login();

	}

	@Then("^enter Email$")
	public void enter_Email() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		loginpage.emailTxtField();

	}

	@Then("^Click on continue$")
	public void click_on_continue() {
		loginpage.continueButton();
	}

	@Then("^Enter Password$")
	public void enter_Password() throws IOException {
		loginpage.passwordTxtField();

	}

	@When("^clicks on log in button$")
	public void clicks_on_log_in_button() throws Throwable {
		loginpage.loginButton();

	}

	@Then("^Homepage should be displayed$")
	public void homepage_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		String actual = driver.getTitle();
		System.out.println(actual);
		System.out.println("Homepage is displayed");
	}

	@When("^clicks on Gift Cards$")
	public void clicks_on_Gift_Cards() {
		homepage.giftCardsIcon();

	}

	@Then("^Digital Entertainment page is displayed$")
	public void digital_Entertainment_page_is_displayed() {
		String actual = driver.getTitle();
		System.out.println(actual);

	}

	@Then("^select a gift card and click on it$")
	public void select_a_gift_card_and_click_on_it() {
		giftpage.giftCard();

	}

	@Then("^click on Buy Now$")
	public void click_on_Buy_Now() {
		Set<String> allwindows = driver.getWindowHandles();
		for (String currentwindow : allwindows) {
			driver.switchTo().window(currentwindow);
		}
		giftpage.buyNowBtn();

	}

	@Then("^enter data and click on save and continue$")
	public void enter_data_and_click_on_save_and_continue() throws InterruptedException {
		Thread.sleep(2000);
		giftpage.recipientName();
		giftpage.recipientEmail();
		giftpage.giftMessage();
		giftpage.nameTxtField();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)");
		Thread.sleep(2000);
		giftpage.saveAndContinuebtn();

	}

	@Then("^click on proceed to payment$")
	public void click_on_proceed_to_payment() throws InterruptedException {
		Thread.sleep(2000);
		giftpage.proceedToPayBtn();

	}

	@Then("^click on pay$")
	public void click_on_pay() throws InterruptedException {
		String actual = driver.getTitle();
		String expected = "Snapdeal Cart Checkout";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
		driver.quit();
	}

}
