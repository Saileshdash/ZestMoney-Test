package com.zestmoney.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilities {

	public Properties getProperties(String fileName) throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/"+fileName);
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);
		return properties;
	}

}
