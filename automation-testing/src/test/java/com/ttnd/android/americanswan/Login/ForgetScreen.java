package com.ttnd.android.americanswan.Login;

import org.openqa.selenium.By;

import com.ttnd.android.americanswan.BaseScreens.BaseScreen;
import com.ttnd.android.americanswan.HomeScreen.HomeScreen;
import com.ttnd.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ForgetScreen extends BaseScreen {

	public ForgetScreen(AppiumDriver<MobileElement> driver) {
		super(driver, Dialoglocator);
		// TODO Auto-generated constructor stub
	}
	/*public ForgetScreen(MobileElement driver) {
		super(driver, Dialoglocator);
		// TODO Auto-generated constructor stub
	}
	
	public ForgetScreen clickForget(String email){
		driver.findElement(EmailEditTabLocator).sendKeys(email);
		//driver.back();
		//reportTestStep(true, "Entered email id");
		//driver.hideKeyboard();
		//reportTestStep(true, "Entered passsword");
		Keywords.clickElementByID(driver, ResetPasswordlocator);
		
		return new ForgetScreen(driver);
	}*/
	static By Dialoglocator = By.id("com.americanswan:id/txt_dialog_message");
	By EmailEditTabLocator = By.id("com.americanswan:id/editTextEmail");
	By ResetPasswordlocator = By.id("com.americanswan:id/resetPassword]");
}
