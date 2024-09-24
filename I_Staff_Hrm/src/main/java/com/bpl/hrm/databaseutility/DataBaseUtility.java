package com.bpl.hrm.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains java database connectivity reusable methods.
 * 
 * @author Anant
 */
public class DataBaseUtility {
	Connection con;

	/**
	 * This method helps user to set connection with database
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @throws Throwable
	 */
	public void getDbconnection(String url, String username, String password) throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
		;
	}

	/**
	 * This method helps user to setting connection with local database
	 * 
	 * @throws Throwable
	 */
	public void getDbconnection() throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		} catch (Exception e) {
		}
		;
	}

	/**
	 * This method helps to close database connection
	 * 
	 * @throws Throwable
	 */
	public void closeDbConnection() throws Throwable {
		try {
			con.close();
		} catch (Exception e) {
		}
		;
	}

	/**
	 * This method helps user to execute select query and fetch data from database
	 * 
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeConSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {
		}
		;
		return result;
	}

	/**
	 * This method helps user to execute non-select query
	 * 
	 * @param query
	 * @return
	 */
	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
		}
		;
		return result;
	}
}
