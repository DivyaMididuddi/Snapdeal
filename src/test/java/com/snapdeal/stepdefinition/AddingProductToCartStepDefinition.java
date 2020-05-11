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

import cucumber.api.java.en.*;

public class AddingProductToCartStepDefinition {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);

	@Given("^open browser and enter url$")
	public void open_browser_and_enter_url() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ExcelFile.getExcelData("url"));

	}

	@When("^clicks on sign in and click on login$")
	public void clicks_on_sign_in_and_click_on_login() throws IOException {
		loginpage.signinButton();
		loginpage.login();
	}

	@Then("^enter email id$")
	public void enter_email_id() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		loginpage.emailTxtField();

	}

	@Then("^click on continue$")
	public void click_on_continue() {
		loginpage.continueButton();

	}

	@Then("^Enter password$")
	public void enter_password() throws IOException {
		loginpage.passwordTxtField();

	}

	@When("^clicks on Login button$")
	public void clicks_on_Login_button() throws IOException {
		loginpage.loginButton();

	}

	@Then("^HomePage is dispalyed\\.$")
	public void homepage_is_dispalyed() throws InterruptedException {

		Thread.sleep(2000);
		String actual = driver.getTitle();
		System.out.println(actual);
		System.out.println("Homepage is displayed");

	}

	@Then("^click on womens fashion$")
	public void click_on_womens_fashion() {
		homepage.womensFashion();

	}

	@When("^clicks on salwar kurtis$")
	public void clicks_on_salwar_kurtis() {
		homepage.salwarSuits();

	}

	@Then("^dress materials page is displayed$")
	public void dress_materials_page_is_displayed() {
		String actual = driver.getTitle();
		System.out.println(actual);
		System.out.println("Dreeses page is displayed");

	}

	@Then("^click on a product$")
	public void click_on_a_product() throws InterruptedException {
		homepage.product();

	}

	@Then("^click on Add To Cart$")
	public void click_on_Add_To_Cart() throws InterruptedException {

		Set<String> allwindows = driver.getWindowHandles();
		for (String currentwindow : allwindows) {
			driver.switchTo().window(currentwindow);
		}
		WebElement addtocart = homepage.addToCart();
		addtocart.click();
		System.out.println("Product is added to cart");

	}

	@Then("^Click on view cart$")
	public void click_on_view_cart() throws InterruptedException {
		homepage.viewCart();
		System.out.println("cart page is displayed");
		Thread.sleep(2000);
		driver.quit();

	}

}
