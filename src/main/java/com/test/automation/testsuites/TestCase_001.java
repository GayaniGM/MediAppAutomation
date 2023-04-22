/**
 * 
 */
package com.test.automation.testsuites;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.automation.pages.HomePage;
import com.test.automation.utility.TestBase;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author GayaniGunawardhana
 *
 */
public class TestCase_001 {
	

	AndroidDriver mobiledriver;
	
	
	@Test(priority = 0, description = "Verify Home and Profile pages")
	public void tc001() throws Exception{
		
		Reporter.log("Starting TestCase_001 .........");
		
		TestBase initialization = new TestBase(mobiledriver);
		initialization.OpenBaseApplication();
		Reporter.log("Opened base application successfully ....");
		
	}
	
	

}
