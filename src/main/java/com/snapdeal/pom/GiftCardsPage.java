package com.snapdeal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardsPage {
	@FindBy(xpath = "//div[@class=\"product-tuple-image \"]/a")
	private WebElement giftcard;

	@FindBy(xpath = "//div[@id=\"buy-button-id\"]/span")
	private WebElement buynow;

	@FindBy(id = "recipientName")
	private WebElement recipientname;

	@FindBy(id = "recipientEmail")
	private WebElement recipientemail;

	@FindBy(id = "giftingMessage")
	private WebElement giftmessage;

	@FindBy(xpath = "//span[@class=\"checkbox-material\"]/span")
	private WebElement checkbox;

	@FindBy(id = "customerName")
	private WebElement nametxtfield;

	@FindBy(id = "delivery-modes-continue")
	private WebElement saveandcontinue;

	@FindBy(id = "make-payment")
	private WebElement proceedtopay;

	@FindBy(id = "creditcard-continue")
	private WebElement paybtn;

	public GiftCardsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void giftCard() {
		giftcard.click();
	}

	public void buyNowBtn() {
		buynow.click();
	}

	public void recipientName() {
		recipientname.sendKeys("Divya");

	}

	public void recipientEmail() {
		recipientemail.sendKeys("mdivyadiv@gmail.com");

	}

	public void giftMessage() {
		giftmessage.sendKeys("Gift");
	}

	public void checkBox() {
		checkbox.click();
	}

	public void nameTxtField() {
		nametxtfield.sendKeys("Divya");
	}

	public void saveAndContinuebtn() {

		saveandcontinue.click();

	}

	public void proceedToPayBtn() {
		proceedtopay.click();
	}

	public void payBtn() {
		paybtn.click();
	}
}
