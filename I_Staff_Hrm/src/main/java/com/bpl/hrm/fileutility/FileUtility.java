package com.bpl.hrm.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class contains method to get common data from properties file.
 * 
 * @author Anant
 */
public class FileUtility {
	/**
	 * This method helps user to get data from properties file.
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./configueAppData/commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
}
