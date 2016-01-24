package com.ttnd.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
//import com.experitest.selenium.MobileApplication;
//import com.experitest.selenium.MobileWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.DragAndDrop;
import com.ttnd.driver.AndroidAppiumDriver;
import com.ttnd.driver.IOSAppiumDriver;
import com.ttnd.reporting.Reporting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class TestBase{
	/**
	 * WebDriver
	 */
	//SEETEST 
	//protected static MobileWebDriver dr;
	//APPIUM
	//protected static IOSDriver<MobileElement> dr;
	protected static AppiumDriver<MobileElement> dr;



	/**
	 * Install App
	 */
	private static boolean installApp = true;

	protected static Properties properties;
	
	public TestBase(){
		properties = new Properties();
		try {
			FileReader reader = new FileReader("GlobalSettings.properties");
			properties.load(reader);
		} 
		catch (IOException e) {
			System.out.println("Failed to load Properties file");
		}
	}

	@BeforeSuite(groups = { "Sanity" })
	public void beforeSuite(){

		
		CommonVariables.reportsDirEnv = Reporting.createResultFolderStructure(GlobalVar.FAME_ENVIRONMENT);	

		startAppiumServer();
		
	}

	@BeforeTest(groups = { "Sanity" })
	@Parameters("deviceName")
	public void beforeTest(String deviceName){

		
		CommonVariables.reportsDirDevice =	setupDeviceReports(CommonVariables.reportsDirEnv, deviceName);
		CommonVariables.reportName.set(CommonVariables.reportsDirDevice);
						
						

		CommonVariables.extent.set(new ExtentReports(CommonVariables.reportName.get()+ "/"+ "Execution_Report" +".html",true));
		CommonVariables.extent.get().loadConfig(new File(GlobalVar.EXTENT_CONFIG_FILE));

		CommonVariables.deviceList.add(deviceName);

	}

	@BeforeClass(groups = { "Sanity" })
	@Parameters("deviceName")
	public void setUpClass(String deviceName) throws Exception {

		//SEETEST
		//dr = new SeetestDriver().getDriver();
		
		if(properties.getProperty("browserName").equalsIgnoreCase("Android"))
			dr = new AndroidAppiumDriver(deviceName).getDriver();
		else if(properties.getProperty("browserName").equalsIgnoreCase("iOS"))
			dr = new IOSAppiumDriver(deviceName).getDriver();

		//SEETEST
		//connectToTestingDevice(deviceName);
		//installAppOnDevice();
		//dr.client.setReporter("xml", "C:\\seetestReport");

	}


	@BeforeMethod(groups = { "Sanity" })
	@Parameters("deviceName")
	public void setUp(String deviceName, Method method) throws Exception {



		System.out.println("Executing " +method.getName());

		System.out.println(CommonVariables.reportName.get());
		CommonVariables.test.set(CommonVariables.extent.get().startTest(this.getClass().getSimpleName() +" "+  method.getName(),method.getName()));

		//LaunchApp();


	}


	@AfterMethod(groups = { "Sanity" })
	public void tearDown() throws Exception {
		CommonVariables.extent.get().endTest(CommonVariables.test.get());
		CommonVariables.extent.get().flush();

	}


	@AfterClass(groups = { "Sanity" })
	public void afterClass(){


		//dr.close();
		dr.quit();
		//dr.releaseClient();


	}

	@AfterTest(groups = { "Sanity" })
	public void afterTest(){
		File htmlFile = new File(CommonVariables.reportName.get()+"/ExecutionReport.html");
		CommonVariables.extent.get().close();

		//driver.quit();
		//dr.close();

		//dr.releaseClient();


	}

	@AfterSuite(groups = { "Sanity" })
	public void afterSuite(){
		new Reporting().generateFinalReport(CommonVariables.deviceList);

		System.out.println(CommonVariables.reportsDirEnv+ "/index.html");
		File htmlFile = new File(CommonVariables.reportsDirEnv+ "/index.html");


		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	//SEETEST
//	public static void reportTestStep(boolean status, String message,boolean attachScreenshot, MobileWebDriver dr) {
//
//		if(attachScreenshot==true && status==true){
//			CommonVariables.test.get().log(LogStatus.PASS, message);
//			captureScreeshotToReport(dr);
//			CommonVariables.test.get().log(LogStatus.PASS, "Snapshot below: " + CommonVariables.test.get().addScreenCapture(CommonVariables.randomNum+".png"));
//
//		}
//		else if(attachScreenshot==false && status==true){
//			CommonVariables.test.get().log(LogStatus.PASS, message);
//
//		}
//		if(attachScreenshot==true && status==false){
//			CommonVariables.test.get().log(LogStatus.FAIL, message);
//			captureScreeshotToReport(dr);
//			CommonVariables.test.get().log(LogStatus.PASS, "Snapshot below: " + CommonVariables.test.get().addScreenCapture(CommonVariables.randomNum+".png"));
//			System.err.println(message);
//
//		}
//		else if(attachScreenshot==false && status==false){
//			CommonVariables.test.get().log(LogStatus.FAIL, message);
//			System.err.println(message);
//		}
//
//
//	}
	
	
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
	
	//SEETEST
//	public static String captureScreeshotToReport(MobileWebDriver dr){
//		dr.client.capture();
//
//		//dr.generateReport();
//		String str = (String) dr.client.getLastCommandResultMap().get("outFile").toString();
//
//		CommonVariables.randomNum = Math.random();
//		Path psource =new File(str).toPath();
//		Path pdest =new File(CommonVariables.reportsDirDevice + "\\"+CommonVariables.randomNum +".png").toPath();
//		System.out.println("---------"+pdest.toString());
//		dr.client.sleep(1000);
//		try {
//			Files.copy(psource,pdest,StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return(pdest.toString());
//	}


	public void LaunchApp() {

		dr.launchApp();
		//dr.resetApp();
		
		//SEETEST
//		MobileApplication app = dr.application(properties.getProperty("android_app_activity"));
//		if (app.equals(null)) {
//			reportTestStep(true, "App Not Launched", false, dr);
//
//		}
//		app.clear();
//		app.launch(true, false);
//		dr.useNativeIdentification();
//		reportTestStep(true, "App Launched Successfully", false, dr);
//		dr.device().sendText("{WAKE}");

	}

	private static String setupDeviceReports(String reportsDir, String deviceName) {
		File reportTemp = new File(reportsDir, deviceName);
		reportTemp.mkdirs();

		return reportTemp.getAbsolutePath();
	}
	
	/*private static String setupImagesReports(String reportsDirDevice, String images) {
		File imagesTemp = new File(reportsDirDevice, images);
		imagesTemp.mkdirs();

		return imagesTemp.getAbsolutePath();
	}*/

	//SEETEST
//	private void installAppOnDevice() {
//
//		if(installApp){
//			//appPath is dependent on Jenkins Workspace
//			//String appPath = GlobalVar.APK_PATH + "\\" + GlobalVar.ANDROID_APK_FILE;
//			//String appPath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + properties.getProperty("android_apk");
//			String appPath = GlobalVar.JENKINS_WORKSPACE + "apk_" + GlobalVar.FAME_ENVIRONMENT + "\\" + GlobalVar.APP_NAME_ANDROID;
//			if(dr.application(appPath).install(true)){
//				installApp = false;
//
//			}else{
//				System.err.println("Unable to install " + appPath);
//			}
//		}else{
//			return;
//		}
//		dr.device().sendText("{WAKE}");
//	}


	//SEETEST
//	private void connectToTestingDevice(String deviceName){
//		try{
//			String connecteddeviceName = dr.setDevice("adb:" + deviceName).getName();
//
//			System.out.println("deviceName "+connecteddeviceName);
//			if(connecteddeviceName.isEmpty()){
//				System.err.println("Unable to setDevice: " + deviceName);
//			}
//		}catch(Exception e){
//			System.err.println("Unable to setDevice: " + deviceName);
//		}
//		System.out.println("Invoke Test on device: " + deviceName + " ");
//	}
	
	private void startAppiumServer(){
		ServerArguments serverArguments = new ServerArguments();
		serverArguments.setArgument("--address", "127.0.0.1");
		serverArguments.setArgument("--no-reset", true);
		serverArguments.setArgument("--local-timezone", true);
		serverArguments.setArgument("--port", "4723");
		serverArguments.setArgument("--session-override", true);

		serverArguments.setArgument("--log", properties.get("appiumLogs"));



		AppiumServer _appiumServer = new AppiumServer(serverArguments);

		if(_appiumServer.isServerRunning()){
			_appiumServer.stopServer();
		}

		_appiumServer.startServer();
	}

}
