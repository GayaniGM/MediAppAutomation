/**
 * 
 */
package com.test.automation.utility;

import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author GayaniGunawardhana
 *
 */
public class TestBase {
	
	public static AndroidDriver mobiledriver;
	
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
		cap.setCapability("noReset", true);
		
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

}
