package com.zestmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.util.BrowserUtil;

public class FlipkartPage {

	WebDriver driver;
	BrowserUtil browserUtil;
	
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
		this.driver.get("https://www.flipkart.com/");
	    browserUtil.hardPause(3);
		closePopOffButton.click();
		browserUtil.waitForElementToBeVisible(searchBox, 10);
		searchBox.sendKeys("Apple iPhone XR (64GB) - Yellow");
		searchButton.click();
		browserUtil.waitForElementToBeClickable(iphoneLink, 10);
		iphoneLink.click();
		browserUtil.switchToWindow(3);
		browserUtil.waitForElementToBeVisible(finalIphonePrice, 10);
		String iphonePrice = finalIphonePrice.getText().replaceAll("[^\\d ]", "");
		return Integer.parseInt(iphonePrice);	
	}

}
