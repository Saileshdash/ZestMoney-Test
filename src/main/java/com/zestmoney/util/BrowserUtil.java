package com.zestmoney.util;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtil {

	WebDriver driver;
	WebDriverWait wait;
	Wait<WebDriver> fluentWait; 
	Actions actions;
	private static final TestLogger LOGGER = TestLogger.getLogger(BrowserUtil.class);
	public BrowserUtil(WebDriver driver){
		this.driver = driver;
		actions = new Actions(driver);
	}

	public void waitForElementToBeVisible(WebElement element, int timeDuration) {
		LOGGER.logInfo("Waiting for Element to be visible.");
		wait = new WebDriverWait(driver, timeDuration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void fluentWaitForElement(WebElement element) {

		this.fluentWait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(StaleElementReferenceException.class);

		fluentWait.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return element.isDisplayed();
			}
		});
	}

	public void waitForElementToBeClickable(WebElement element, int timeDuration) {
		wait = new WebDriverWait(driver, timeDuration);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void switchToWindow(int windowNumber) {
		Set<String> windowIDs =  driver.getWindowHandles();
		Iterator<String> iterator = windowIDs.iterator();
		int count = 0;
		String windowId = "";
		while(count < windowNumber) {
			windowId = iterator.next();
			count++;
		}
		driver.switchTo().window(windowId);
	}
	
	public void hardPause(int sec) {
		try {
			Thread.sleep(sec * 1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mouseOverAndClcik(WebElement element) {
		
		actions.moveToElement(element).click().build().perform();
	}
	
	public void selectRating(WebElement element, Integer rating) {
		if(rating.equals(1)) {
			actions.moveToElement(element, -50, 0).click().build().perform();
		}else if(rating.equals(2)) {
			actions.moveToElement(element, -25, 0).click().build().perform();
		}else if(rating.equals(3)) {
			actions.moveToElement(element, 0, 0).click().build().perform();
		}else if(rating.equals(4)) {
			actions.moveToElement(element, 25, 0).click().build().perform();
		}else if(rating.equals(5)) {
			actions.moveToElement(element, 50, 0).click().build().perform();
		}
	}
	
	public void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
}
