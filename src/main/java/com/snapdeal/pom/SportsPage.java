package com.snapdeal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportsPage {
	@FindBy(xpath = "//div[@class=\"col-xs-6  favDp product-tuple-listing js-tuple \"]/div[1]/div/span/i")
	private WebElement shortlisticon;

	@FindBy(xpath = "//div[@class=\"product-desc-rating \"]/a/p")
	private WebElement gymproduct;

	@FindBy(xpath = "//div[@class=\"shortlist-cart-item\"]/span")
	private WebElement movetoshortlist;

	@FindBy(xpath = "//div[@class=\"cart-heading clearfix\"]/span/i")
	private WebElement closesymbol;

	public SportsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void shortListIcon() {
		shortlisticon.click();
	}

	public void gymProduct() throws InterruptedException {
		Thread.sleep(3000);
		gymproduct.click();
	}

	public void moveToShortList() throws InterruptedException {
		Thread.sleep(2000);
		movetoshortlist.click();
	}

	public void closeSymbol() throws InterruptedException {
		Thread.sleep(2000);
		closesymbol.click();
	}

}
