package com.bpl.hrm.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains reusable methods to get/read data from excel and send
 * data to excel file.
 * 
 * @author Anant
 */
public class ExcelUtility {
	/**
	 * This method helps user to read data from excel file.
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * This method helps user to get total number of rows available in excel sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	/**
	 * This method helps user to send data to excel sheet.
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataIntoExce(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testdata/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
