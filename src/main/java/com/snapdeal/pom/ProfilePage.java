package com.snapdeal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	@FindBy(xpath = "//div[@class=\"accountInner\"]/span")
	private WebElement account;

	@FindBy(xpath = "//div[@class=\"dropdownAccount\"]/div/ul/li/a")
	private WebElement orders;
	
	@FindBy(linkText = "Shortlist")
	private WebElement shortlist;

	@FindBy(linkText = "SD Cash")
	private WebElement sdcash;

	@FindBy(linkText = "E-Gift Voucher")
	private WebElement egiftvocher;

	@FindBy(linkText = "//li[@class=\"accountInfoNonLoggedIn logoutNew\"]/a")
	private WebElement logout;

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void account() {
		account.click();
	}

	public void orders() throws InterruptedException {
		Thread.sleep(3000);
		orders.click();

	}

	public void shortList() {
		shortlist.click();
	}

	public void sdCash() {
		sdcash.click();
	}

	public void eGiftVocher() {
		egiftvocher.click();

	}

	public void logOut() {
		logout.click();
	}

}
