package com.zestmoney.util;

import org.apache.log4j.Logger;
import org.testng.Reporter;


public class TestLogger {
	
	public static TestLogger getLogger(final Class<?> clazz) {
		return new TestLogger(clazz);
	}

	
	private final Logger logger;
	
	TestLogger(final Class<?> clazz) {
		this.logger = Logger.getLogger(clazz);
	}
	
	
	public void logInfo(final String message) {
		logger.info(message);
		Reporter.log(message);
	}
	
	
}
