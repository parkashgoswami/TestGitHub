//package com.ttnd.utilities;
//
//import com.experitest.selenium.MobileWebDriver;
//
//public class Reporter {
//
//	MobileWebDriver driver;
//	public Reporter(MobileWebDriver driver) {
//		this.driver = driver;
//	}
//	public String captureScreenShot(){
//		return driver.client.capture();
//	}
//	
//	public String captureScreenShot(String strMessage){
//		return driver.client.capture(strMessage);
//	}
//	
//	public static void reportStepPass(String msg, MobileWebDriver driver) {
//		reportStep(msg, true, driver);
//	}
//	public static void reportStepFail(String msg, MobileWebDriver driver) {
//		 reportStep(msg, false, driver);
//	}
//	
//	private static void reportStep(String msg, boolean status, MobileWebDriver driver){
//		 driver.client.setShowReport(true);
//		  driver.client.report(msg, status);
//		  driver.client.setShowReport(false);
//	}
//	
//	
//}
