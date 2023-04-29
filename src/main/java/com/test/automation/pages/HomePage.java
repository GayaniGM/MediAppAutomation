/**
 * 
 */
package com.test.automation.pages;

import org.openqa.selenium.By;
import org.testng.asserts.Assertion;

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
	By btn_Home = By.xpath("//android.view.View[@selected='true']");
	By lbl_ProfileHeader = By.xpath("//android.view.View[@text='Profile']");
	By btn_myAppointments = By.xpath("(//android.widget.Button[@clickable='true'])[1]");
	By btn_addAppointments = By.xpath("(//android.widget.Button[@clickable='true'])[2]");
	By txt_myAppointments = By.xpath("//android.widget.TextView[@text='My Appointments']");
	By txt_addAppointments = By.xpath("//android.widget.TextView[@text='Add Appointments']");
	
	//Methods
	public void ClickOnMYAppointments() {
		
		mobiledriver.findElement(btn_myAppointments).click();
	}
	
	public void ValidateHeaderText(String expecteValue) {
		
		Assertion assertion = new Assertion();
		String header = mobiledriver.findElement(lbl_HomeHeader).getText();
		assertion.assertEquals(header, expecteValue, "Title Doesn't match");
		
	}
	
	public void ValidateMyAppointmentsButtonText(String expecteValue) {
		
		Assertion assertion = new Assertion();
		String header = mobiledriver.findElement(txt_myAppointments).getText();
		assertion.assertEquals(header, expecteValue, "Title Doesn't match");
		
	}
	
	public void ValidateAddAppointmentsButtonText(String expecteValue) {
		
		Assertion assertion = new Assertion();
		String header = mobiledriver.findElement(txt_addAppointments).getText();
		assertion.assertEquals(header, expecteValue, "Title Doesn't match");
		
	}
	
	public void ValidateProfIcon() {
		
		Assertion assertion = new Assertion();
		assertion.assertTrue(mobiledriver.findElement(btn_Profile).getAttribute("selected") != null);
		
		
	}
	
	public void ValidateHomeIcon() {
		
		Assertion assertion = new Assertion();
		assertion.assertTrue(mobiledriver.findElement(btn_Home).isDisplayed());
		
		
	}

}
