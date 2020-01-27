package com.zestmoney.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zestmoney.pages.AmazonPage;
import com.zestmoney.pages.FlipkartPage;
import com.zestmoney.util.BaseTest;
import com.zestmoney.util.TestLogger;

public class TestIphonePrice extends BaseTest{
	AmazonPage amazonPage; 
	FlipkartPage flipkartPage;
	private static final TestLogger LOGGER = TestLogger.getLogger(TestIphonePrice.class);
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
			LOGGER.logInfo("Price of Iphone in Amazon is less and the price is :" + iphonePriceInAmazon);
		} else {
			LOGGER.logInfo("Price of Iphone in Flipkart is less and the price is :" + iphonePriceInFlipkart);
		}
	}

}
