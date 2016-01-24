package com.ttnd.android.americanswan.Login;

import org.openqa.selenium.By;

import com.ttnd.android.americanswan.BaseScreens.BaseScreen;
import com.ttnd.android.americanswan.HomeScreen.HomeScreen;
import com.ttnd.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignInScreen extends BaseScreen{
	public SignInScreen(AppiumDriver<MobileElement> driver) {
		super(driver, LoginButtonLocator);
		// TODO Auto-generated constructor stub
	}
	public void clickCancelScreen(){
		Keywords.clickElement(driver, CancelPagelocator);
		Keywords.reportTestStep(true, "Canceled Sign In Screen", false, driver);

		//return new HomePage(driver);
	}

	public FaceBookScreen clickFacebookLoginScreen(){
		Keywords.clickElement(driver, FacebookLoginLocator);
		Keywords.reportTestStep(true, "Clicked on Facebook Login Tab", false, driver);

		return new FaceBookScreen(driver);
	}

	public void sendKeysEmail(String email){
		Keywords.sendKeys(driver, EmailEditTextLocator, email);
		Keywords.HideKeyboard(driver);
		Keywords.reportTestStep(true, "Entered Email ID", false, driver);

	}

	public void sendKeysPassword(String password){
		Keywords.sendKeys(driver, PasswordEditTextlocator, password);
		Keywords.HideKeyboard(driver);
		Keywords.reportTestStep(true, "Entered Password", false, driver);

	}


	public HomeScreen clickSignIn(){
		Keywords.clickElement(driver, LoginButtonLocator);

		Keywords.reportTestStep(true, "Clicked Login Button", false, driver);

		return new HomeScreen(driver);
	}


/*	public void clickRegister(String email , String password){
		driver.findElement(EmailEditTextLocator).sendKeys(email);
		//driver.hideKeyboard();
		//reportTestStep(true, "Entered email id");

		driver.findElement(PasswordEditTextlocator).sendKeys(password);
		//driver.hideKeyboard();
		//reportTestStep(true, "Entered passsword");
		Keywords.clickElementByID(driver, LoginButtonLocator);

		//return new RegisterScreen(driver);
	}*/	

	public ForgetScreen clickForget(String email , String password){
		
		Keywords.clickElement(driver, ForgetLocator);

		return new ForgetScreen(driver);
	}
	By CancelPagelocator = By.id("com.americanswan:id/skip");
	By FacebookLoginLocator = By.id("com.americanswan:id/login_button");
	By GooglePluslocator = By.xpath("//android.widget.Button[@text='Sign in']");
	By EmailEditTextLocator = By.id("com.americanswan:id/editTextEmail");
	By PasswordEditTextlocator = By.id("com.americanswan:id/editTextPassword");
	By ForgetLocator = By.id("com.americanswan:id/forgotPassword");
	static By LoginButtonLocator = By.id("com.americanswan:id/btnLogin");
	By RegisterLocator = By.id("com.americanswan:id/signupNow");

}
