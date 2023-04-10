/**
 * 
 */
package com.test.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.test.automation.utility.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author GayaniGunawardhana
 *
 */
@SuppressWarnings("deprecation")
public class CommonPage extends TestBase{

	public CommonPage(AndroidDriver mobiledriver) {
		super(mobiledriver);
	}
	
	//Do not use  annotation FindBy. there is a delay in android than in web
	//So to mitigate we have to use CacheLookup annotation before accessing the element
	//Do not use Page factory model because of this. So  I am using Page Object model
	By btn_EnButtin = By.xpath("//android.widget.Button[@text='EN Button']");
	By btn_EnConfirmation = By.xpath("//android.widget.Button[@text='No, no']");
	
	public void changeRegion(String idf_Name){
		
		mobiledriver.findElement(By.xpath("//android.widget.Button[@text='"+idf_Name+"']"));
	}
	
	public void ClickENButton() {
		
		mobiledriver.findElement(btn_EnButtin).click();
		mobiledriver.findElement(btn_EnConfirmation).click();
	}

	
	public void ScrollUp() {
		
		TouchAction action = new TouchAction(mobiledriver);
		action.press(PointOption.point(176, 1887)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(176, 176)).release().perform();
	}
}
