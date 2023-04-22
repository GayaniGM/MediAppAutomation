/**
 * 
 */
package com.test.automation.pages;

import org.openqa.selenium.By;

import com.test.automation.utility.TestBase;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author GayaniGunawardhana
 *
 */
public class HomePage extends TestBase {
	
	public HomePage(AndroidDriver mobiledriver) {
		super(mobiledriver);
	}
	

	//Page objects
	By lbl_HomeHeader = By.xpath("//android.view.View[@text='Home Page']");
	By btn_Profile = By.xpath("//android.view.View[@selected='false']");
	By lbl_ProfileHeader = By.xpath("//android.view.View[@text='Profile']");
	
	//Methods
	
}
