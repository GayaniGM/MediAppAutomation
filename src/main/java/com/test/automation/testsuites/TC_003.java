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
public class TC_003 {

	private static final Logger LOGGER = LoggerFactory.getLogger(TC_003.class);
	
	AndroidDriver mobiledriver;
	MyAppointmentsPage appointmentPage = new MyAppointmentsPage(mobiledriver);
	
	@SuppressWarnings({ "resource", "unused" })
	@Test(priority = 0, description = "UI - Verification of MY Appointments user flow")
	public void tc_003() throws Exception{
		
		LOGGER.info("Starting test case tc003...");
		Reporter.log("Starting test case tc003...");

		TestBase initialization = new TestBase(mobiledriver);
		CommonPage common = new CommonPage(mobiledriver);
		HomePage home = new HomePage(mobiledriver);
		
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
        
        
        //Validate My Appointments button
        home.ValidateMyAppointmentsButtonText(sheet.getRow(5).getCell(0).toString());
        LOGGER.info("Verified My Appointments button text successfully.");
        Reporter.log("Verified My Appointments button text successfully.");
        
        //Validate Add Appointments button
        home.ValidateAddAppointmentsButtonText(sheet.getRow(6).getCell(0).toString());
        LOGGER.info("Verified Add Appointments button text successfully.");
        Reporter.log("Verified Add Appointments button text successfully.");
        
        //Validate that Home icon is selected by default
        home.ValidateHomeIcon();
        LOGGER.info("Verified Home icon is defaultly selected.");
        Reporter.log("Verified Home icon is defaultly selected.");
        
        //Validate that Profile icon is Available
        home.ValidateProfIcon();
        LOGGER.info("Verified Availability of Profile Icon.");
        Reporter.log("Verified Availability of Profile Icon.");
        
		TestBase.measureStartupTime();
		//TestBase.measurePageLoadTime();
		//TestBase.measureAppCrash();
        double memory = TestBase.measureMemoryUsage();
        WriteintoExcel.writeToExcel(memory);
        
        //Click on My Appointments button
        home.ClickOnMYAppointments();
        LOGGER.info("Clicked on My Appointments button.");
        Reporter.log("Clicked on My Appointments button.");
        
        //Verify My Appointments header
        appointmentPage.VerifyMyAppointmentsHeader(sheet.getRow(1).getCell(0).toString());
        LOGGER.info("Verified My Appointments Page Header.");
        Reporter.log("Verified My Appointments Page Header.");
        
        double memory1 = TestBase.measureMemoryUsage();
        WriteintoExcel.writeToExcel(memory1);
        
        //Verify Find new Appointment button
        appointmentPage.VerifyFindNewAppointment(sheet.getRow(4).getCell(0).toString());
        LOGGER.info("Verified Find New Appointments button text sucessfully.");
        Reporter.log("Verified Find New Appointments button text sucessfully.");
        
        //Verify Appointment counts
        appointmentPage.MyAppointmentCount();
        int getAppoinmentCount = appointmentPage.appointmentCount;
        LOGGER.info(getAppoinmentCount + " Number of Appointments are currently available.");
        Reporter.log(getAppoinmentCount + " Number of Appointments are currently available.");
        
        double memory2 = TestBase.measureMemoryUsage();
        WriteintoExcel.writeToExcel(memory2);
        
        
        //Click on First appointment
        appointmentPage.ClickOnFirstAppointment();
        LOGGER.info("Opened available first appointment.");
        Reporter.log("Opened available first appointment.");
        
        //Verify header page
        appointmentPage.ValidateViewAppointment(sheet.getRow(3).getCell(0).toString());
        LOGGER.info("Verified View Appointments page header.");
        Reporter.log("Verified View Appointments page header.");
        
        double memory3 = TestBase.measureMemoryUsage();
        WriteintoExcel.writeToExcel(memory3);
        
        //Verify View appointment detail page
        appointmentPage.VerifyViewAppointmentPage();
        LOGGER.info("Verified View Appointments page details.");
        Reporter.log("Verified View Appointments page details.");
     
        
        //Click on Update Running Number
        appointmentPage.ClickONUpdateRunningNumber();
        LOGGER.info("Clicked on Update Running number button.");
        Reporter.log("Clicked on Update Running number button.");
        
        //Verify Update running number page
        appointmentPage.VerifyUpdateRunninNumberPage();
        LOGGER.info("Verified Update Running number detail page.");
        Reporter.log("Verified Update Running number detail page.");
        
        
        initialization.tearDown();
        LOGGER.info("Test case tc003 execution completed successfully.");
        Reporter.log("Test case tc003 execution completed successfully.");
        
	}
	
}
