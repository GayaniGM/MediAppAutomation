/**
 * 
 */
package com.test.automation.testsuites;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.automation.pages.CommonPage;
import com.test.automation.utility.TestBase;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author GayaniGunawardhana
 *
 */
public class tc_001 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(tc_001.class);
	

	
	AndroidDriver mobiledriver;
	
	@SuppressWarnings({ "resource", "unused" })
	@Test(priority = 0, description = "Verify HomePage navigation")
	public void tc001() throws Exception{
		
		LOGGER.info("Starting test case tc001...");
		Reporter.log("Starting test case tc001...");

		TestBase initialization = new TestBase(mobiledriver);
		CommonPage common = new CommonPage(mobiledriver);
		
		//Get absolute file path
		 Path path = Paths.get("src\\main\\java\\com\\test\\automation\\data\\tc_001.xlsx");
	     Path absolutePath = path.toAbsolutePath();

		//Access file
		FileInputStream fs = new FileInputStream(absolutePath.toString());
	
        initialization.OpenBaseApplication();
        LOGGER.info("Opened base application successfully.");
        Reporter.log("Opened base application successfully.");

        common.ClickENButton();
        LOGGER.info("Click on Homepage icon successfully.");
        Reporter.log("Click on Homepage icon successfully.");
        
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        
        common.ValidateTest(sheet.getRow(0).getCell(0).toString());
        LOGGER.info("Validated Home page navigation successfully.");
        Reporter.log("Validated Home page navigation successfully.");
        

		TestBase.measureStartupTime();
		//TestBase.measurePageLoadTime();
		//TestBase.measureAppCrash();
		TestBase.measureMemoryUsage();

        initialization.tearDown();
        LOGGER.info("Test case tc001 execution completed successfully.");
        Reporter.log("Test case tc001 execution completed successfully.");
        

	}

}
