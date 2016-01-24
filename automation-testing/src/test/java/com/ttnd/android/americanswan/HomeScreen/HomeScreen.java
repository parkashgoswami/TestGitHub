package com.ttnd.android.americanswan.HomeScreen;

import org.openqa.selenium.By;

import com.ttnd.android.americanswan.BaseScreens.BaseScreen;
import com.ttnd.driver.AndroidAppiumDriver;
import com.ttnd.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreen extends BaseScreen{

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver, AcountOverviewlocator);		
		
	}
	
	/*public NavigationScreen clickHamburger(){
		Keywords.clickElementByID(driver, Hamburgerlocator);
		//TestBase.reportTestStep(true, "Clicked on Hamburger icon on Home Screen", false, driver);

		return new NavigationScreen(driver);
	}*/
	
	public AccountOverviewScreen clickAccountOverview(){
		
		Keywords.clickElement(driver, AcountOverviewlocator);
		Keywords.reportTestStep(true, "Clicked on Account overview tab on Home Screen", false, driver);
		
		return new AccountOverviewScreen(driver);

	}
	
	/*public void clickSearch(){
		Keywords.clickElementByID(driver, Searchlocator);
		//TestBase.reportTestStep(true, "Clicked on Hamburger icon on Home Screen", false, driver);
	
	}
	public MyBagScreen clickMyBag(){
		Keywords.clickElementByID(driver, MyBaglocator);
		//TestBase.reportTestStep(true, "Clicked on Hamburger icon on Home Screen", false, driver);

		return new MyBagScreen(driver);
	
	}*/
	
	static By AcountOverviewlocator = By.id("com.americanswan:id/app_logo");
	By Hamburgerlocator = By.id("com.americanswan:id/imageview_nav_drawer");
	By Searchlocator = By.id("com.americanswan:id/icon_search");
	By MyBaglocator = By.id("com.americanswan:id/icon_cart");

}