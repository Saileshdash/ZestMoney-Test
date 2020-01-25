package com.zestmoney.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zestmoney.pages.AmazonPage;
import com.zestmoney.pages.FlipkartPage;
import com.zestmoney.util.BaseTest;

public class TestIphonePrice extends BaseTest{
	AmazonPage amazonPage; 
	FlipkartPage flipkartPage;
	@BeforeClass
	public void initTestIphonePrice() {
		amazonPage = new AmazonPage(driver);
		flipkartPage = new FlipkartPage(driver);
	}

	@Test
	public void testCompareIphonePrice() throws Exception {
		double iphonePriceInAmazon = amazonPage.getIphonePrice();
		double iphonePriceInFlipkart =  flipkartPage.getIphonePrice();
		if(iphonePriceInAmazon < iphonePriceInFlipkart) {
			System.out.println("Price of Iphone in Amazon is less and the price is :" + iphonePriceInAmazon);
		} else {
			System.out.println("Price of Iphone in Flipkart is less and the price is :" + iphonePriceInFlipkart);
		}
	}

}
