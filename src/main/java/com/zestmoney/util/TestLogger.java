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
	
	public void logDebug(final String message) {
		logger.debug(message);
		Reporter.log(message);
	}

	public void logError(final String message) {
		logger.error(message);
		Reporter.log(message);
	}

	public void logFatal(final String message) {
		logger.fatal(message);
		Reporter.log(message);
	}

	
	public void logInfo(final String message) {
		logger.info(message);
		Reporter.log(message);
	}

	public void logSetupStep(final String message) {
		logInfo("SetUp: " + message);
	}

	
	public void logTearDownStep(final String message) {
		logInfo("TearDown: " + message);
	}
	public void logTestStep(final String message) {
		logInfo(message);
	}

	
	public void logTestVerificationStep(final String message) {
		logInfo("Verification: " + message);
	}

	
	public void logWarn(final String message) {
		logger.warn(message);
		Reporter.log(message);
	}

	
	
	
}
