package com.snapdeal.pom;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//div[@class=\"accountInner\"]/span")
	private WebElement account;

	@FindBy(xpath = "//div[@class=\"dropdownAccount\"]/div/ul/li/a")
	private WebElement orders;

	@FindBy(linkText = "Shortlist")
	private WebElement shortlist;

	@FindBy(xpath = "//div[@class=\"dp-click-widgets\"]/div/div/div[2]/ul/li[8]/a/span")
	private WebElement womensfashion;

	@FindBy(linkText = "Salwar Suits")
	private WebElement salwarsuits;

	@FindBy(xpath = "//div[@class=\"product-desc-rating \"]/a/p")
	private WebElement product;

	@FindBy(xpath = "//div[@id=\"add-cart-button-id\"]/span")
	private WebElement addtocartbtn;

	@FindBy(xpath = "//*[@id=\"cartProductContainer\"]/div/div[2]/div[2]/div/div[2]/div")
	private WebElement viewcart;

	@FindBy(xpath = "//span[@class=\"hook-section rfloat\"]/span/a")
	private WebElement giftcardsicon;

	@FindBy(xpath = "//div[@class=\"dp-click-widgets\"]/div/div/div[2]/ul/li[11]/a/span")
	private WebElement sportsfitness;

	@FindBy(linkText = "Gym Bags")
	private WebElement gymbags;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void account() {
		account.click();
	}

	public void shortList() {
		shortlist.click();
	}

	public void orders() throws InterruptedException {
		Thread.sleep(3000);
		orders.click();

	}

	public void womensFashion() {

		try {
			womensfashion.click();
		} catch (StaleElementReferenceException s) {
			womensfashion.click();
		}

	}

	public void salwarSuits() {
		salwarsuits.click();
	}

	public void product() throws InterruptedException {
		Thread.sleep(4000);
		product.click();
	}

	public void sportsFitness() {

		try {
			sportsfitness.click();
		} catch (StaleElementReferenceException s) {
			sportsfitness.click();
		}

	}

	public void gymBags() {

		gymbags.click();
	}

	public WebElement addToCart() throws InterruptedException {

		return addtocartbtn;

	}

	public void viewCart() {
		viewcart.click();

	}

	public void giftCardsIcon() {
		try {
			giftcardsicon.click();
		} catch (StaleElementReferenceException se) {
			giftcardsicon.click();
		}
	}
}
