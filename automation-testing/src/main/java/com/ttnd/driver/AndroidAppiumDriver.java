package com.ttnd.driver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class AndroidAppiumDriver {

	AndroidDriver<MobileElement> driver;
	ThreadLocal<AndroidDriver<MobileElement>> dr = new ThreadLocal<AndroidDriver<MobileElement>>();
	File appDir;
	File appAbsolutePath;
	Properties properties;

	private void initPropertiesFile(){

		properties = new Properties();
		try {
			FileReader reader = new FileReader("GlobalSettings.properties");
			properties.load(reader);
		} 
		catch (IOException e) {
			System.out.println("Failed to load Properties file");
		}
	}



	public AndroidAppiumDriver(String deviceName) {
		initPropertiesFile();

		URL serverAddress = null;  
		DesiredCapabilities capabilities = null;
		//AndroidDriver<MobileElement>  driver = null;

			try {
				capabilities= new DesiredCapabilities();
				//capabilities.setCapability("automationName", properties.getProperty("automationName"));
				capabilities.setCapability("platformName", properties.getProperty("platformName"));
				capabilities.setCapability("browserName", properties.getProperty("browserName"));
				capabilities.setCapability("platformVersion",properties.getProperty("platformVersion"));
				capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
				capabilities.setCapability("udid",properties.getProperty("udid"));

				capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
				capabilities.setCapability("app",properties.get("appPath"));
				capabilities.setCapability("noReset", true);
				capabilities.setCapability("--log",properties.get("appiumLogs"));

				serverAddress = new URL(properties.getProperty("host") + ":"+ properties.getProperty("port") + "/wd/hub");
				AndroidDriver<MobileElement>  driver =new AndroidDriver<MobileElement>(serverAddress, capabilities);
				setDriver(driver);
				getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
			} catch (MalformedURLException e) {

			} 

	}


	public void setDriver(AndroidDriver<MobileElement> driver){
		dr.set(driver);
	}

	public AndroidDriver<MobileElement> getDriver() {
		return dr.get();
	}

	

}
