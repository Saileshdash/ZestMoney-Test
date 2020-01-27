package com.zestmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.util.BrowserUtil;
import com.zestmoney.util.TestLogger;

public class TripAdvisiorPage {

	WebDriver driver;
	BrowserUtil browserUtil;
	private static final TestLogger LOGGER = TestLogger.getLogger(TripAdvisiorPage.class);
	public TripAdvisiorPage(WebDriver driver){
		this.driver = driver;
		browserUtil = new BrowserUtil(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how = How.XPATH, using="//a[@href='/Hotels']")
	public WebElement hotels;

	@FindBy(how = How.XPATH,  using="//input[@placeholder='Where to?']")
	public WebElement whereTo;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'BasicResult__result')]/span/span)[6]")
	public WebElement searchIcon;


	@FindBy(how = How.XPATH, using="(//div[@class='result-title']/span[contains(text(),'Club Mahindra')])[1]")
	public WebElement firstSearchResult;

	@FindBy(how = How.LINK_TEXT, using="Write a review")
	public WebElement writeReviewButton;

	@FindBy(how = How.ID, using="bubble_rating")
	public WebElement bubbleRating;

	@FindBy(how = How.ID, using="ReviewTitle")
	public WebElement reviewTitle;

	@FindBy(how = How.ID, using="ReviewText")
	public WebElement reviewText;

	@FindBy(how = How.ID, using="qid12_bubbles")
	public WebElement hotelRatingForService;

	@FindBy(how = How.ID, using="qid190_bubbles")
	public WebElement hotelRatingForSleepQuality;

	@FindBy(how = How.ID, using="qid14_bubbles")
	public WebElement hotelRatingForCleanliness;

	@FindBy(how = How.ID, using="qid47_bubbles")
	public WebElement hotelRatingForLocation;

	@FindBy(how = How.ID, using="qid13_bubbles")
	public WebElement hotelRatingForValue;

	@FindBy(how = How.ID, using="qid11_bubbles")
	public WebElement hotelRatingForRooms;

	@FindBy(how = How.ID, using="noFraud")
	public WebElement submitReviewCheckbox;

	@FindBy(how = How.ID, using="SUBMIT")
	public WebElement submitYourReviewButton;

	@FindBy(how = How.XPATH, using="//div[text()='Couples']")
	public WebElement couplesSortOfTrip;

	@FindBy(how = How.XPATH, using="//div[@id='DATE_OF_VISIT']/select")
	public WebElement whenYouTravelDropdown;

	@FindBy(how = How.XPATH, using="(//div[@id='DQ_RATINGS']/div/div/div[1])[1]")
	public WebElement hotelratingforone;

	@FindBy(how = How.XPATH, using="(//div[@id='DQ_RATINGS']/div/div/div[1])[2]")
	public WebElement hotelratingfortwo;

	@FindBy(how = How.XPATH, using="(//div[@id='DQ_RATINGS']/div/div/div[1])[3]")
	public WebElement hotelratingforthree;


	public void selectHotelRatings(WebElement selctvalue, int rating) {
		if(selctvalue.getText().equals("Service")) {
			LOGGER.logInfo("Select hotel rating for services.");
			browserUtil.selectRating(hotelRatingForService, rating);
		}if(selctvalue.getText().equals("Sleep Quality")) {
			LOGGER.logInfo("Select hotel rating for Sleep Quality.");
			browserUtil.selectRating(hotelRatingForSleepQuality, rating);
		}if(selctvalue.getText().equals("Location")) {
			LOGGER.logInfo("Select hotel rating for Location.");
			browserUtil.selectRating(hotelRatingForLocation, rating);
		}if(selctvalue.getText().equals("Cleanliness")) {
			LOGGER.logInfo("Select hotel rating for Cleanliness.");
			browserUtil.selectRating(hotelRatingForCleanliness, rating);
		}if(selctvalue.getText().equals("Value")) {
			LOGGER.logInfo("Select hotel rating for Value.");
			browserUtil.selectRating(hotelRatingForValue, rating);
		}if(selctvalue.getText().equals("Rooms")) {
			LOGGER.logInfo("Select hotel rating for Rooms.");
			browserUtil.selectRating(hotelRatingForRooms, rating);
		}
	}

}

