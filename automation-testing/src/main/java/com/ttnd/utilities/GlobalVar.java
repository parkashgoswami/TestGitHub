package com.ttnd.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class GlobalVar {
	
	
	public static String LOGIN_EMAIL = "richak123@gmail.com";
	public static String LOGIN_PASSWORD = "admin123";

	protected static Properties properties;
	public static final String FAME_ENVIRONMENT="QA";
	public static final String FAME_SCREENSHOTS="images";
	public static final String SCREENSHOTNAME="ScreenShot_";
	

	public static final String TESTSUITE_FILE_NAME= "TestSuite.xlsx";
	public static final String TESTDATA_FILE_NAME= "BlogMintTestData.xlsx";
	public static final String EXTENT_CONFIG_FILE= System.getProperty("user.dir") + "/extent-config.xml";

	
	public static final String REPORT_FOLDER_ROOT_NAME = "AutomationReports";
	public static final String CONSOLIDATED_REPORT_FILE_NAME = "index.html";
	public static final String REPORT_FILE_NAME = "Execution_Report.html";
	
	//public static final String REPORT_FOLDER = "/Users/intelligrape";
	public static final String REPORT_FOLDER = System.getProperty("user.home");
	public static final String REPORT_FOLDER_FOR_ENVIRONMENT = REPORT_FOLDER + "/" + REPORT_FOLDER_ROOT_NAME + "/" + FAME_ENVIRONMENT;

	public static final String RESOURCE_TEST_DATA_FOLDER = System.getProperty("user.dir") + "/src/test/resources/TestData/";
	public static final String REPORT_RESOURCES_FOLDER = System.getProperty("user.dir") + "/src/test/resources/resources";
	
	public static  Xls_Reader xlreader = new Xls_Reader(RESOURCE_TEST_DATA_FOLDER+TESTDATA_FILE_NAME);


	}
