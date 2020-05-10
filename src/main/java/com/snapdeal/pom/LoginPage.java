package com.snapdeal.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.snapdeal.genericlibraries.ExcelFile;

public class LoginPage {
	
	@FindBy(xpath = "//span[text()=\"Sign In\"]")
	private WebElement signin;

	@FindBy(xpath = "//a[text()=\"login\"]")
	private WebElement login;

	@FindBy(id = "userName")
	private WebElement emailtxtfield;

	@FindBy(xpath = "//button[text()=\"continue\"]")
	private WebElement continuebutton;

	@FindBy(xpath = "//input[@id=\"j_password_login_uc\"]")
	private WebElement passwordtxtfield;

	@FindBy(xpath = "//button[@id=\"submitLoginUC\"]")
	private WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void signinButton() {
		signin.click();
	}

	public void login() {
		login.click();
		
	}

	public void emailTxtField() throws IOException {
		emailtxtfield.sendKeys(ExcelFile.getExcelData("emailid"));
	}

	public void continueButton() {
		continuebutton.click();

	}

	public void passwordTxtField() throws IOException {
		passwordtxtfield.sendKeys(ExcelFile.getExcelData("password"));
	}

	public void loginButton() throws IOException {
		loginbutton.click();
	}

}
