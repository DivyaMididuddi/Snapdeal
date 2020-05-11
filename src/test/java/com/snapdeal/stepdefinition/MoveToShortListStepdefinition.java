package com.snapdeal.stepdefinition;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.snapdeal.genericlibraries.ExcelFile;
import com.snapdeal.pom.HomePage;
import com.snapdeal.pom.LoginPage;
import com.snapdeal.pom.SportsPage;

import cucumber.api.java.en.*;

public class MoveToShortListStepdefinition {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	SportsPage sportspage = new SportsPage(driver);

	@Given("^open chromeBrowser and enter url$")
	public void open_chromeBrowser_and_enter_url() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ExcelFile.getExcelData("url"));
	}

	@Then("^click on signin and click on login$")
	public void click_on_signin_and_click_on_login() throws IOException {
		loginpage.signinButton();
		loginpage.login();

	}

	@Then("^Enter Email click on continue$")
	public void enter_Email_click_on_continue() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		loginpage.emailTxtField();
		loginpage.continueButton();

	}

	@When("^enters password click on login$")
	public void enters_password_click_on_login() throws IOException {
		loginpage.passwordTxtField();
		loginpage.loginButton();

	}

	@Then("^Homepage is displayed\\.$")
	public void homepage_is_displayed() throws InterruptedException {

		Thread.sleep(2000);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Online Shopping Site India - Shop Electronics, Mobiles, Men & Women Clothing, Shoes - www. Snapdeal.com";
		Assert.assertEquals(actual, expected);
		System.out.println("Homepage is displayed");

	}

	@Then("^click on SportsFitness$")
	public void click_on_SportsFitness() {

		homepage.sportsFitness();
	}

	@When("^clicks on Gym bags$")
	public void clicks_on_Gym_bags() {

		homepage.gymBags();

	}

	@Then("^Gym bags page is displayed$")
	public void gym_bags_page_is_displayed() {

		String actual = driver.getTitle();
		System.out.println(actual);
		System.out.println("Gym bags page is displayed");

	}

	@Then("^click On a product$")
	public void click_On_a_product() throws InterruptedException {
		sportspage.gymProduct();
	}

	@Then("^click on add to cart$")
	public void click_on_add_to_cart() throws InterruptedException {
		Set<String> allwindows = driver.getWindowHandles();
		for (String currentwindow : allwindows) {
			driver.switchTo().window(currentwindow);
		}
		WebElement addtocart = homepage.addToCart();
		addtocart.click();
		System.out.println("Product is added to cart");

	}

	@When("^clicks on view cart$")
	public void clicks_on_view_cart() {
		homepage.viewCart();
	}

	@Then("^click on move to shortlist$")
	public void click_on_move_to_shortlist() throws InterruptedException {
		sportspage.moveToShortList();
		sportspage.closeSymbol();

	}

	@Then("^click on profile$")
	public void click_on_profile() {
		homepage.account();

	}

	@Then("^click on shortlist$")
	public void click_on_shortlist() throws InterruptedException {
		homepage.shortList();
		System.out.println("shortlist page is displayed");
		Set<String> allwindows = driver.getWindowHandles();
		for (String currentwindow : allwindows) {
			Thread.sleep(2000);
			driver.switchTo().window(currentwindow).close();
		}
	}

}
