package com.zestmoney.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver; 
	
	@BeforeClass
	public void initBastTest() throws IOException{
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromeDriver\\windows\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown() {
		 driver.quit();
	}
}
