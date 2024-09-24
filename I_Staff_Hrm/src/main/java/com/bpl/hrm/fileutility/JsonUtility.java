package com.bpl.hrm.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class contains method to read common data from json file.
 * 
 * @author Anant
 */
public class JsonUtility {
	/**
	 * This method helps user to get data from json file.
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fir = new FileReader("./configueAppData/appCommonData.json");
		JSONParser parser = new JSONParser();
		Object ob = parser.parse(fir);
		JSONObject map = (JSONObject) ob;
		String data = (String) map.get(key);
		return data;
	}
}
