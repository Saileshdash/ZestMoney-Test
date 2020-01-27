package com.zestmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.util.BrowserUtil;
import com.zestmoney.util.TestLogger;

public class FlipkartPage {

	WebDriver driver;
	BrowserUtil browserUtil;
	private static final TestLogger LOGGER = TestLogger.getLogger(FlipkartPage.class);
	public FlipkartPage(WebDriver driver){
		this.driver = driver;
		browserUtil = new BrowserUtil(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how = How.NAME, using="q")
	public WebElement searchBox;

	@FindBy(how = How.XPATH, using="//button[@type='submit']")
	public WebElement searchButton;
	
	@FindBy(how = How.ID, using="loginbutton")
	public WebElement loginButton;
	
	@FindBy(how = How.XPATH, using="(//button)[2]")
	public WebElement closePopOffButton;
	

	@FindBy(how = How.XPATH, using="//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	public WebElement iphoneLink;

	@FindBy(how = How.XPATH, using="//div[@class='_1vC4OE _3qQ9m1']")
	public WebElement finalIphonePrice;
	
	public Integer getIphonePrice() throws Exception {
		LOGGER.logInfo("Navigate to Url : https://www.flipkart.com .");
		this.driver.get("https://www.flipkart.com/");
		LOGGER.logInfo("wait for 3 seconds.");
	    browserUtil.hardPause(3);
	    LOGGER.logInfo("Close pop off button.");
		closePopOffButton.click();
		browserUtil.waitForElementToBeVisible(searchBox, 10);
		LOGGER.logInfo("Enter \"Apple iPhone XR (64GB) - Yellow\" in search box.");
		searchBox.sendKeys("Apple iPhone XR (64GB) - Yellow");
		LOGGER.logInfo("Click on search button.");
		searchButton.click();
		browserUtil.waitForElementToBeClickable(iphoneLink, 10);
		LOGGER.logInfo("Click on iphone link.");
		iphoneLink.click();
		LOGGER.logInfo("Navigate to iphone details page.");
		browserUtil.switchToWindow(3);
		browserUtil.waitForElementToBeVisible(finalIphonePrice, 10);
		String iphonePrice = finalIphonePrice.getText().replaceAll("[^\\d ]", "");
		LOGGER.logInfo("Price of Iphone in Flipkart is : "+Integer.parseInt(iphonePrice));
		return Integer.parseInt(iphonePrice);	
	}

}
