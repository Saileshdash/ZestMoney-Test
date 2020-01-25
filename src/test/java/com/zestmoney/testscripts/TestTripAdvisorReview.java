package com.zestmoney.testscripts;

import org.openqa.selenium.Point;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zestmoney.pages.AmazonPage;
import com.zestmoney.pages.FlipkartPage;
import com.zestmoney.pages.TripAdvisiorPage;
import com.zestmoney.util.BaseTest;
import com.zestmoney.util.BrowserUtil;

public class TestTripAdvisorReview extends BaseTest{
	TripAdvisiorPage tripAdvisiorPage;
	BrowserUtil browserUtil;
	
	@BeforeClass
	public void initTestIphonePrice() {
		tripAdvisiorPage = new TripAdvisiorPage(driver);
		browserUtil= new BrowserUtil(driver);
	}

	@Test
	public void testTripAdvisorReviewFeature() {
		driver.get("http://www.tripadvisor.in/");
		browserUtil.waitForElementToBeClickable(tripAdvisiorPage.hotels, 10);
		tripAdvisiorPage.hotels.click();
		browserUtil.waitForElementToBeVisible(tripAdvisiorPage.whereTo, 10);
		tripAdvisiorPage.whereTo.sendKeys("Club Mahindra");
		browserUtil.hardPause(3);
		tripAdvisiorPage.searchIcon.click();
		browserUtil.waitForElementToBeClickable(tripAdvisiorPage.firstSearchResult, 10);
		tripAdvisiorPage.firstSearchResult.click();
		browserUtil.switchToWindow(2);
		browserUtil.hardPause(5);
		tripAdvisiorPage.writeReviewButton.click();
		browserUtil.switchToWindow(3);
		browserUtil.waitForElementToBeVisible(tripAdvisiorPage.bubbleRating, 10);
		browserUtil.mouseOverAndClcik(tripAdvisiorPage.bubbleRating);
		tripAdvisiorPage.reviewTitle.sendKeys("Dummy Review Title for Zest Money");
		tripAdvisiorPage.reviewText.sendKeys("Recently I visited Club Mahindra ,Coorg with my family. Everything was spot on right from the rooms, facilities,children's play area. Me and my family visited Club Mahindra, Madikeri on Jan 20-24, 2020. This is a beautiful resort. Set amidst nature, we could see greenery...");
		tripAdvisiorPage.couplesSortOfTrip.click();
		browserUtil.waitForElementToBeVisible(tripAdvisiorPage.whenYouTravelDropdown, 10);
		browserUtil.selectValueFromDropDown(tripAdvisiorPage.whenYouTravelDropdown, "12,2019");
		browserUtil.mouseOverAndClcik(tripAdvisiorPage.hotelRatingForService);
		browserUtil.mouseOverAndClcik(tripAdvisiorPage.hotelRatingForCleanliness);
		browserUtil.mouseOverAndClcik(tripAdvisiorPage.hotelRatingForLocation);
		tripAdvisiorPage.submitReviewCheckbox.click();
		tripAdvisiorPage.submitYourReviewButton.click();
	}
}
