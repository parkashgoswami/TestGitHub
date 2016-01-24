package com.ttnd.android.americanswan.BaseScreens;

import com.ttnd.utilities.Keywords;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class BaseScreen {

	protected AppiumDriver<MobileElement> driver;

	
	public BaseScreen(AppiumDriver<MobileElement> driver, By locator) {
		this.driver = driver;
		Keywords.WaitForElement(driver, locator);
		
	}

	
}
