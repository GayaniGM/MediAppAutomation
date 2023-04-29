/**
 * 
 */
package com.test.automation.testsuites;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.automation.pages.CommonPage;
import com.test.automation.pages.HomePage;
import com.test.automation.pages.MyAppointmentsPage;
import com.test.automation.utility.TestBase;
import com.test.automation.utility.WriteintoExcel;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author GayaniGunawardhana
 *
 */
public class TC_004 {
	

private static final Logger LOGGER = LoggerFactory.getLogger(TC_004.class);
	
	AndroidDriver mobiledriver;
	MyAppointmentsPage appointmentPage = new MyAppointmentsPage(mobiledriver);
	TestBase initialization = new TestBase(mobiledriver);
	CommonPage common = new CommonPage(mobiledriver);
	HomePage home = new HomePage(mobiledriver);
	
	@SuppressWarnings({ "resource", "unused" })
	@Test(priority = 0, description = "UI - Verification of Add Appointments user flow")
	public void tc_004() throws Exception{
		
		LOGGER.info("Starting test case tc004...");
		Reporter.log("Starting test case tc004...");
		
		
		//Get absolute file path
		 Path path = Paths.get("src\\main\\java\\com\\test\\automation\\data\\tc_006.xlsx");
	     Path absolutePath = path.toAbsolutePath();

		//Access file
		FileInputStream fs = new FileInputStream(absolutePath.toString());

        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        
		//Launch Application
        initialization.OpenBaseApplication();
        LOGGER.info("Opened base application successfully.");
        Reporter.log("Opened base application successfully.");
        

        //Validate Home Page header
		/*
		 * home.ValidateHeaderText(sheet.getRow(0).getCell(0).toString());
		 * LOGGER.info("Verified Home page header text successfully.");
		 * Reporter.log("Verified Home page header text successfully.");
		 */
        
        
        //Click on Add appointment
        appointmentPage.ClickOnAddAppointment();
        LOGGER.info("Clicked On Add Appointment button.");
        Reporter.log("Clicked On Add Appointment button.");
        

        //Verify Add Appointments option
		/*
		 * appointmentPage.VerifyAddAppointmentHeader();
		 * LOGGER.info("Verified Add Appointment header successfully.");
		 * Reporter.log("Verified Add Appointment header successfully.");
		 */
        double memory = TestBase.measureMemoryUsage();
        WriteintoExcel.writeToExcel(memory);
        
        //Verify Add appointments detail page
		  appointmentPage.VerifyAddAppointmentDetailsPage();
		  LOGGER.info("Verified Add Appointment details page successfully.");
		  Reporter.log("Verified Add Appointment details page successfully.");
		 
        
        initialization.tearDown();
        LOGGER.info("Test case tc004 execution completed successfully.");
        Reporter.log("Test case tc004 execution completed successfully.");
        
    
        
	}
	
	
}

