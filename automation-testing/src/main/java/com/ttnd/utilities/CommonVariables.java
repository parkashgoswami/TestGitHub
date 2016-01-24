package com.ttnd.utilities;

import java.util.ArrayList;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CommonVariables {

	
	public static ThreadLocal<ExtentReports> extent = new ThreadLocal<ExtentReports>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<String> reportName = new ThreadLocal<String>();
	public static String reportsDirEnv;
	public static String reportsDirDevice;
	//public static String reportsDirReport;
	public static ArrayList<String> deviceList = new ArrayList<String>();
	public static double randomNum;
	
}
