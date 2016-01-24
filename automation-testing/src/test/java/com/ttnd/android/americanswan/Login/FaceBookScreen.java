package com.ttnd.android.americanswan.Login;

import org.openqa.selenium.By;

import com.ttnd.android.americanswan.BaseScreens.BaseScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FaceBookScreen extends BaseScreen {

	public FaceBookScreen(AppiumDriver<MobileElement> driver) {
		super(driver, Titlelocator);
		// TODO Auto-generated constructor stub
	}
	
	static By Titlelocator = By.id("com.americanswan:id/txt_dialog_message");
}
