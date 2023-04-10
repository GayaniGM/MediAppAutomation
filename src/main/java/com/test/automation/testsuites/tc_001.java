/**
 * 
 */
package com.test.automation.testsuites;


import org.testng.annotations.Test;
import com.test.automation.pages.CommonPage;
import com.test.automation.utility.TestBase;

import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

/**
 * @author GayaniGunawardhana
 *
 */
public class tc_001 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(tc_001.class);
	

	
	AndroidDriver mobiledriver;
	
	@Test(priority = 0, description = "Verify EN Button")
	public void tc001() throws Exception{
		
		LOGGER.info("Starting test case tc001...");
        Reporter.log("Starting test case tc001...");
        TestBase initialization = new TestBase(mobiledriver);
        CommonPage common = new CommonPage(mobiledriver);
        
        initialization.OpenBaseApplication();
        LOGGER.info("Opened base application successfully.");
        Reporter.log("Opened base application successfully.");
        common.ClickENButton();
        LOGGER.info("Clicked EN button successfully.");
        Reporter.log("Clicked EN button successfully.");
        initialization.tearDown();
        LOGGER.info("Test case tc001 execution completed successfully.");
        Reporter.log("Test case tc001 execution completed successfully.");
	}

}
