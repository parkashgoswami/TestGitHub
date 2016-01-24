package com.ttnd.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class Keywords{


	public static void WaitForElement(AppiumDriver<MobileElement> driver, By locator, int timeOut) throws NoSuchElementException{
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			//		wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
		}catch(TimeoutException te){
			System.err.println(te.getClass().getSimpleName());
		}catch(NoSuchElementException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/*
	 * Overloaded WaitForElement
	 */
	public static void WaitForElement(AppiumDriver<MobileElement> driver, By titleLocator) {
		WaitForElement(driver, titleLocator, 20);
	}



	public static boolean isElementFound(AppiumDriver<MobileElement> driver, By element) throws NoSuchElementException{
		try{
			if(!driver.findElements(element).isEmpty()) {
				return true;
			}else{
				return false;
			}
		}catch(NoSuchElementException e){
			throw e;
		}catch(Exception e){
			return false;
		}

	}



	public static void clickinElementsByText(AndroidDriver<MobileElement> driver, By ElementsID, String ElementText){
		boolean noElementFound = false;
		try{
			List<MobileElement> elements = driver.findElements(ElementsID);
			for(MobileElement element : elements){
				if(element.getAttribute("text").equals(ElementText)){
					noElementFound = true;
					element.click();
					break;
				}
			}
			if(noElementFound==false){
				throw new FrameworkException("No element found : " + ElementText);
			}
		}
		catch(NoSuchElementException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}

	public static void clickElement(AppiumDriver<MobileElement> driver, By locator){

		WaitForElement(driver, locator);
		try{
			driver.findElement(locator).click();
		}
		catch(Exception e){
			reportTestStep(false, "Unable to click on " + locator, true, driver);
		}
	}


	public static void sendKeys(AppiumDriver<MobileElement> driver, By locator, String text){

		WaitForElement(driver, locator);
		try{
			driver.findElement(locator).sendKeys(text);
		}
		catch(Exception e){
			reportTestStep(false, "Unable to send text on " + locator, true, driver);
		}
	}

	public static String GetElementAttributeValue(AppiumDriver<MobileElement> driver, MobileElement mobileElement, String attribute)
	{
		try
		{
			if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase("checked"))
				return mobileElement.getAttribute(attribute);
			else if(attribute.equalsIgnoreCase("onScreen"))
				return String.valueOf(mobileElement.getAttribute(attribute));

		}catch(Exception e){
			reportTestStep(false, "Cannot get text attribute : " + e, true, driver);

			throw new FrameworkException();	
		}
		return null;

	}

	public static MobileElement findElement(AppiumDriver<MobileElement> driver, By locator, int timeOuts){
		MobileElement mobileElement = null;
		WebDriverWait wait;
		try
		{
			if (timeOuts > 0)
				WaitForElement(driver, locator,timeOuts);

			mobileElement = driver.findElement(locator);
			return mobileElement;

		}
		catch(Exception e){
			reportTestStep(false, "Cannot find element : " + e.getMessage(), true, driver);

			throw new FrameworkException();

		}	
	}



	public static String GetElementText(AppiumDriver<MobileElement> driver,By locator)
	{
		MobileElement mobileElement = findElement(driver, locator, 20);
		return(GetElementAttributeValue(driver, mobileElement, "text"));

	}


	public static void reportTestStep(boolean status, String message,boolean attachScreenshot, AppiumDriver<MobileElement> dr2) {


		if(attachScreenshot==true && status==true){
			CommonVariables.test.get().log(LogStatus.PASS, message);
			captureScreeshotToReport(dr2);
			CommonVariables.test.get().log(LogStatus.PASS, "Snapshot below: " + CommonVariables.test.get().addScreenCapture(CommonVariables.randomNum+".png"));

		}
		else if(attachScreenshot==false && status==true){
			CommonVariables.test.get().log(LogStatus.PASS, message);

		}
		if(attachScreenshot==true && status==false){
			CommonVariables.test.get().log(LogStatus.FAIL, message);
			captureScreeshotToReport(dr2);
			CommonVariables.test.get().log(LogStatus.PASS, "Snapshot below: " + CommonVariables.test.get().addScreenCapture(CommonVariables.randomNum+".png"));
			System.err.println(message);

		}
		else if(attachScreenshot==false && status==false){
			CommonVariables.test.get().log(LogStatus.FAIL, message);
			System.err.println(message);
		}


	}


	public static String captureScreeshotToReport(AppiumDriver<MobileElement> dr){
		CommonVariables.randomNum = Math.random();

		File srcFiler=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFiler, new File(CommonVariables.reportsDirDevice + "/"+CommonVariables.randomNum +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return(CommonVariables.reportsDirDevice + "\\"+CommonVariables.randomNum +".png").toString();

	}

	public static void HideKeyboard(AppiumDriver<MobileElement> dr){
		dr.navigate().back();
		
	//	dr.hideKeyboard();
	}
}
