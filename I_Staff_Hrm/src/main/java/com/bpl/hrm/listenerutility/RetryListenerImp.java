package com.bpl.hrm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class contains implementation method for tetng IRetryAnalyzer interface.
 * 
 * @author Anant
 */
public class RetryListenerImp implements IRetryAnalyzer {
	// declare global
	int count = 0;
	int limit = 5;

	@Override
	/**
	 * This method helps user to execute failed test case for multiple times upto it
	 * reaches upper limit.
	 */
	public boolean retry(ITestResult result) {

		if (count < limit) {
			count++;
			return true;
		}
		return false;
	}
}
