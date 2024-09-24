package com.bpl.hrm.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable methods to generate random numbers and system
 * date.
 * 
 * @author Anant
 */
public class JavaUtility {
	/**
	 * This method generates and returns a random number.
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	/**
	 * This method generates and returns current system date.
	 * 
	 * @return
	 */
	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateObj);
		return date;
	}

	/**
	 * This method generates and returns date in required formate
	 * 
	 * @param days
	 * @return
	 */
	public String getRequiredDateYYYYDDMM(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateObj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requiredDate = sim.format(cal.getTime());
		return requiredDate;
	}
}
