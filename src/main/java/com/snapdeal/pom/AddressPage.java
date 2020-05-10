package com.snapdeal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	@FindBy(id = "dotAccountSavedAddresses")
	private WebElement savedaddress;

	@FindBy(xpath = "//a[text()=\"Add New Address\"]")
	private WebElement addnewaddressbtn;

	@FindBy(id = "zip")
	private WebElement zip;

	@FindBy(id = "fullName")
	private WebElement fullname;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "nearestLandmark")
	private WebElement landmark;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(xpath = "//div[@class=\"sdRadio medium radio-black col-xs-4 pad-lt-0\"]")
	private WebElement homeradiobtn;

	@FindBy(id = "dotaccount-saveAddress-continue")
	private WebElement save;

	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void savedAddress() {
		savedaddress.click();

	}

	public void addNewAddressBtn() {
		addnewaddressbtn.click();

	}

	public void zip() {
		zip.sendKeys("500084");

	}

	public void fullName() {
		fullname.sendKeys("Yash");

	}

	public void address() {
		address.sendKeys("H.No:5-91");

	}

	public void landMark() {
		landmark.sendKeys("Santha bazar");

	}

	public void city() {
		city.sendKeys("Hyerabad");

	}

	public void state() {
		state.sendKeys("Telangana");
}

	public void mobile() {
		mobile.sendKeys("9848523461");

	}

	public void homeRadioBtn() {
		homeradiobtn.click();

	}

	public void save() {
		save.click();

	}
}
