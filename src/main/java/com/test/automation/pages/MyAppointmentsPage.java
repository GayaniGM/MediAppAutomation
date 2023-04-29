/**
 * 
 */
package com.test.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

import com.test.automation.utility.TestBase;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author GayaniGunawardhana
 *
 */
public class MyAppointmentsPage extends TestBase{
	

	public int appointmentCount;
	
	public MyAppointmentsPage(AndroidDriver mobiledriver) {
		super(mobiledriver);
	}
	
	
	//Page Objects
	By lbl_MyAppointments = By.xpath("//android.widget.TextView[@text='My Appointments']");
	By btn_FindNewAppointment = By.xpath("//android.widget.TextView[@text='Find new appointment']");
	By btn_firstAppointment = By.xpath("(//android.widget.TextView[@enabled='true'])[3]");
	By lbl_ViewAppointmentHeader = By.xpath("//android.widget.TextView[@text='View Appointments']");
	By lbl_Hospital = By.xpath("//android.widget.TextView[@text='Hospital']");
	By lbl_Specialization = By.xpath("//android.widget.TextView[@text='Specialization']");
	By lbl_Doctor = By.xpath("//android.widget.TextView[@text='Doctor']");
	By lbl_Date = By.xpath("//android.widget.TextView[@text='Date']");
	By lbl_AppointmentNumber = By.xpath("//android.widget.TextView[@text='Appointment Number']");
	By btn_UpdateRunningNumber = By.xpath("//android.widget.Button[@clickable='true']");
	By lbl_RunningNUmberPageHeader = By.xpath("//android.widget.TextView[@text='Update Running Number']");
	By btn_RunningNUmber = By.xpath("//android.widget.TextView[@text='Update Running Number']");
	By btn_AddAppointment = By.xpath("//android.widget.TextView[@text='Add Appointments']");
	By lbl_AddAppointment = By.xpath("//android.widget.TextView[@text='Add Appointments']");
	By btn_Add = By.xpath("//android.widget.TextView[@text='Add']");
	By lbl_ErrorMessage = By.xpath("//android.widget.TextView[@text='This is required.']");
	
	
	
	
	
	//Methods
	public void MyAppointmentCount() {
		
	    List<WebElement> appointments = mobiledriver.findElements(By.xpath("//android.widget.TextView[@enabled='true']"));
	    appointmentCount = appointments.size();
	    
	    for(int i = 1; i <= appointmentCount; i++) {
	    	
	    	Assertion assertion = new Assertion();
	    	assertion.assertTrue( mobiledriver.findElement(By.xpath("(//android.widget.TextView[@enabled='true'])["+i+"]")).isDisplayed());
	    	
	    }

	    
	}
	
	public void VerifyMyAppointmentsHeader(String expecteValue) {
		
		Assertion assertion = new Assertion();
		String header = mobiledriver.findElement(lbl_MyAppointments).getText();
		assertion.assertEquals(header, expecteValue, "Title Doesn't match");
		
	}
	
	public void VerifyFindNewAppointment(String expecteValue) {
		
		Assertion assertion = new Assertion();
		String header = mobiledriver.findElement(btn_FindNewAppointment).getText();
		assertion.assertEquals(header, expecteValue, "Title Doesn't match");
		
	}
	
	public void ClickOnFirstAppointment() {
		
		mobiledriver.findElement(btn_firstAppointment).click();
	}
	
	public void ValidateViewAppointment(String expecteValue) {
		
		Assertion assertion = new Assertion();
		String header = mobiledriver.findElement(lbl_ViewAppointmentHeader).getText();
		assertion.assertEquals(header, expecteValue, "Title Doesn't match");
		
		
	}
	
	public void VerifyViewAppointmentPage() {
		
		Assertion assertion = new Assertion();
		assertion.assertTrue(mobiledriver.findElement(lbl_Hospital).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_Specialization).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_Doctor).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_Date).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_AppointmentNumber).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(btn_UpdateRunningNumber).isDisplayed());
		
		
	}
	
	public void ClickONUpdateRunningNumber() {
		
		mobiledriver.findElement(btn_UpdateRunningNumber).click();
	}
	
	public void VerifyUpdateRunninNumberPage() {
		
		Assertion assertion = new Assertion();
		assertion.assertTrue(mobiledriver.findElement(lbl_RunningNUmberPageHeader).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(btn_UpdateRunningNumber).isDisplayed());
		
		
	}
	
	public void VerifyAddAppointmentHeader() {
		
		Assertion assertion = new Assertion();
		assertion.assertTrue(mobiledriver.findElement(lbl_AddAppointment).isDisplayed());
	}
	
	public void VerifyAddAppointmentDetailsPage() {
		
		Assertion assertion = new Assertion();
		assertion.assertTrue(mobiledriver.findElement(lbl_Hospital).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_Specialization).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_Doctor).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_Date).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(lbl_AppointmentNumber).isDisplayed());
		assertion.assertTrue(mobiledriver.findElement(btn_Add).isDisplayed());
	}

	public void ClickOnAddButton() {
		
		mobiledriver.findElement(btn_Add).click();
	}
	
	public void VerifyErrorMessage() {
		
		Assertion assertion = new Assertion();
		assertion.assertTrue(mobiledriver.findElement(lbl_ErrorMessage).isDisplayed());
	}
	
	public void ClickOnAddAppointment() {
		
		mobiledriver.findElement(btn_AddAppointment).click();
	}
}
