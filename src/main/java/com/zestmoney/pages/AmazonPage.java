package com.zestmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.util.BrowserUtil;
import com.zestmoney.util.TestLogger;

public class AmazonPage {
	WebDriver driver;
	private static final TestLogger LOGGER = TestLogger.getLogger(AmazonPage.class);
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
		LOGGER.logInfo("Navigate to Url : https://www.amazon.com .");
		this.driver.get("https://www.amazon.in/");
		browserUtil.waitForElementToBeVisible(searchBox, 10);
		LOGGER.logInfo("Enter \"Apple iPhone XR (64GB) - Yellow\" in search box.");
		searchBox.sendKeys("Apple iPhone XR (64GB) - Yellow");
		LOGGER.logInfo("Click on search button.");
		serachButton.click();		
		browserUtil.waitForElementToBeClickable(iphoneLink, 10);
		LOGGER.logInfo("Click on iphone link.");
		iphoneLink.click();	
		LOGGER.logInfo("Navigate to iphone details page.");
		browserUtil.switchToWindow(2);
		browserUtil.waitForElementToBeVisible(dealPrice, 10);
		String iphonePrice = dealPrice.getText().replaceAll("[a-z A-Z \\u20B9 , ]", "").trim();
		LOGGER.logInfo("Price of Iphone in Amazon is : "+Double.parseDouble(iphonePrice));
		return Double.parseDouble(iphonePrice);
		
	}

}
