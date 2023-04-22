/**
 * 
 */
package com.test.automation.utility;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author GayaniGunawardhana
 *
 */
public class TestBase {
	
	public static AndroidDriver mobiledriver;
	public static final String USERNAME = "gayanimadhushika1";
    public static final String AUTOMATE_KEY = "xqzDbvSfqEXMAmSFr41w";
    public static final String PROJECT_NAME = "APP_AUTOMATE";
	
	public TestBase(AndroidDriver mobiledriver)
	{
		TestBase.mobiledriver = mobiledriver;
	}
	
	@SuppressWarnings("deprecation")
	public void OpenBaseApplication() throws Exception{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("deviceName", "sdk_gphone64_x86_64");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		//cap.setCapability("appPackage", "com.meditrekker");
		//cap.setCapability("appActivity", "com.meditrekker.MainActivity");
		cap.setCapability("noReset", true);
		cap.setCapability("build", "Jenkins Automation build #123");
		
	    // Add the following capabilities to measure your KPIs
		cap.setCapability("newCommandTimeout", 300);
		cap.setCapability("enablePerformanceLogging", true);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("ignoreUnimportantViews", true);
		cap.setCapability("disableAndroidWatchers", true);
		cap.setCapability("skipDeviceInitialization", true);
		cap.setCapability("skipLogcatCapture", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		
		
		try {
			
			mobiledriver = new AndroidDriver(remoteUrl, cap);
			mobiledriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Application Started...........");
	}
	
	
	public void tearDown() {

		mobiledriver.quit();
	}
	
	public static void measureStartupTime() {
	    long startTime = System.currentTimeMillis();
	    // Add your app startup code here
	    long endTime = System.currentTimeMillis();
	    long startupTime = endTime - startTime;
	    System.out.println("Startup time: " + startupTime + " ms");
	}

	public static void measurePageLoadTime() {
	    Map<String, Object> args = new HashMap<>();
	    args.put("duration", "1000");
	    mobiledriver.executeScript("mobile: scroll", args);
	    long startTime = System.currentTimeMillis();
	    // Add your page load code here
	    long endTime = System.currentTimeMillis();
	    long pageLoadTime = endTime - startTime;
	    System.out.println("Page load time: " + pageLoadTime + " ms");
	}

	public static void measureAppCrash() {
	    mobiledriver.executeScript("mobile: crash", Arrays.asList("io.appium.android.apis"));
	}

	public static void measureMemoryUsage() {
	    double memory = (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
	    System.out.println("Memory usage: " + memory + " MB");
	}





}
