package com.zestmoney.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zestmoney.pages.TripAdvisiorPage;
import com.zestmoney.util.BaseTest;
import com.zestmoney.util.BrowserUtil;
import com.zestmoney.util.TestLogger;

public class TestTripAdvisorReview extends BaseTest{
	TripAdvisiorPage tripAdvisiorPage;
	BrowserUtil browserUtil;
	private static final TestLogger LOGGER = TestLogger.getLogger(TestTripAdvisorReview.class);
	
	@BeforeClass
	public void initTestIphonePrice() {
		tripAdvisiorPage = new TripAdvisiorPage(driver);
		browserUtil= new BrowserUtil(driver);
	}

	@Test
	public void testTripAdvisorReviewFeature() {
		LOGGER.logInfo("Navigate to Url : http://www.tripadvisor.in .");
		driver.get("http://www.tripadvisor.in/");
		browserUtil.waitForElementToBeClickable(tripAdvisiorPage.hotels, 10);
		LOGGER.logInfo("Click on hotle tab.");
		tripAdvisiorPage.hotels.click();
		browserUtil.waitForElementToBeVisible(tripAdvisiorPage.whereTo, 10);
		LOGGER.logInfo("Enter \"Club Mahindra\" in where to.");
		tripAdvisiorPage.whereTo.sendKeys("Club Mahindra");
		browserUtil.hardPause(3);
		LOGGER.logInfo("Click on search icon.");
		tripAdvisiorPage.searchIcon.click();
		browserUtil.waitForElementToBeClickable(tripAdvisiorPage.firstSearchResult, 10);
		LOGGER.logInfo("Select first search result.");
		tripAdvisiorPage.firstSearchResult.click();
		LOGGER.logInfo("Navigate to hotel review page.");
		browserUtil.switchToWindow(2);
		browserUtil.hardPause(5);
		LOGGER.logInfo("Click on \"Write a Review\" button.");
		tripAdvisiorPage.writeReviewButton.click();
		LOGGER.logInfo("Navigate to User review edit page.");
		browserUtil.switchToWindow(3);
		browserUtil.waitForElementToBeVisible(tripAdvisiorPage.bubbleRating, 10);
		LOGGER.logInfo("Select hottel over all rating.");
		browserUtil.selectRating(tripAdvisiorPage.bubbleRating,5);
		LOGGER.logInfo("Write tilte in \"Title of your review\" text box.");
		tripAdvisiorPage.reviewTitle.sendKeys("Dummy Review Title for Zest Money");
		LOGGER.logInfo("Write review in \"Your review\" text box.");
		tripAdvisiorPage.reviewText.sendKeys("Recently I visited Club Mahindra ,Coorg with my family. Everything was spot on right from the rooms, facilities,children's play area. Me and my family visited Club Mahindra, Madikeri on Jan 20-24, 2020. This is a beautiful resort. Set amidst nature, we could see greenery...");
		LOGGER.logInfo("Select sort of trip.");
		tripAdvisiorPage.couplesSortOfTrip.click();
		browserUtil.waitForElementToBeVisible(tripAdvisiorPage.whenYouTravelDropdown, 10);
		LOGGER.logInfo("Select trip month and year.");
		browserUtil.selectValueFromDropDown(tripAdvisiorPage.whenYouTravelDropdown, "12,2019");
		tripAdvisiorPage.selectHotelRatings(tripAdvisiorPage.hotelratingforone, 5);
		tripAdvisiorPage.selectHotelRatings(tripAdvisiorPage.hotelratingfortwo, 5);
		tripAdvisiorPage.selectHotelRatings(tripAdvisiorPage.hotelratingforthree, 5);
		LOGGER.logInfo("Check in \"Submit your review\" check box.");
		tripAdvisiorPage.submitReviewCheckbox.click();
		LOGGER.logInfo("click on \"Submit your review\" button.");
		tripAdvisiorPage.submitYourReviewButton.click();
		
	}
}
