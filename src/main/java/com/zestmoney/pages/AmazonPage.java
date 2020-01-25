package com.zestmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.util.BrowserUtil;

public class AmazonPage {
	WebDriver driver;
	BrowserUtil browserUtil;
	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		browserUtil = new BrowserUtil(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how = How.ID, using="twotabsearchtextbox")
	public WebElement searchBox;

	@FindBy(how = How.XPATH, using="//input[@value='Go']")
	public WebElement serachButton;

	@FindBy(how = How.XPATH, 
			using="//a/span[text()='Apple iPhone XR (64GB) - Yellow']")
	public WebElement iphoneLink;
	
	@FindBy(how = How.ID, using="priceblock_ourprice")
	public WebElement dealPrice;
	
	public Double getIphonePrice() throws Exception {
		this.driver.get("https://www.amazon.in/");
		browserUtil.waitForElementToBeVisible(searchBox, 10);
		searchBox.sendKeys("Apple iPhone XR (64GB) - Yellow");
		serachButton.click();
		browserUtil.waitForElementToBeClickable(iphoneLink, 10);
		iphoneLink.click();
		browserUtil.switchToWindow(2);
		browserUtil.waitForElementToBeVisible(dealPrice, 10);
		String iphonePrice = dealPrice.getText().replaceAll("[a-z A-Z \\u20B9 , ]", "").trim();
		return Double.parseDouble(iphonePrice);
		
	}

}
