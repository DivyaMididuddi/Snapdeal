package com.snapdeal.stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.snapdeal.genericlibraries.ExcelFile;
import com.snapdeal.pom.LoginPage;
import com.snapdeal.pom.ProfilePage;

import cucumber.api.java.en.*;

public class EGiftVocherStepDefinition {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverexecutable/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	LoginPage loginpage = new LoginPage(driver);
	ProfilePage profilepage = new ProfilePage(driver);

	@Given("^Open ChromeBrowser and enter URL$")
	public void open_ChromeBrowser_and_enter_URL() throws IOException {
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ExcelFile.getExcelData("url"));
	}

	@When("^clicks on sign in and click on Login$")
	public void clicks_on_sign_in_and_click_on_Login() throws IOException {
		loginpage.signinButton();
		driver.get(ExcelFile.getExcelData("login"));

	}

	@Then("^enter Emailid click on continue$")
	public void enter_Emailid_click_on_continue() throws IOException {

		loginpage.emailTxtField();
		loginpage.continueButton();
	}

	@Then("^enter password click on login$")
	public void enter_password_click_on_login() throws IOException {
		loginpage.passwordTxtField();
		loginpage.loginButton();
	}

	@Then("^click on Profile$")
	public void click_on_Profile() throws InterruptedException {
		Thread.sleep(2000);
		profilepage.account();
	}

	@When("^clicks on E-Gift vocher$")
	public void clicks_on_E_Gift_vocher() throws InterruptedException {
		Thread.sleep(2000);
		profilepage.eGiftVocher();
	}

	@Then("^Gift vocher page is displayed$")
	public void gift_vocher_page_is_displayed() {
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("Gift vocher page is displayed");
		driver.close();

	}

}
