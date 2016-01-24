package com.ttnd.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class MtafLogger {
	/*
	 * 
	 Log4J for dynamically generate filename. 
	 It changes its name according to input file name and current date-time. 
	 (So helpful in case you run same file multiple times.)
	 
	 Whenever you want to use logger in your program, Just write these two lines 
	 MtafLogger.setFileName(yourFileName);
	 MtafLogger.getLogger().debug("hello!!");
	 */
	private static Logger log =  Logger.getLogger(MtafLogger.class);
	private static boolean initializationFlag = false;
	private static String fileName;

	private static void intializeLogger(){
		log.setLevel(Level.DEBUG);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		RollingFileAppender appender = new RollingFileAppender();
		appender.setAppend(true);
		appender.setMaxFileSize("1MB");
		appender.setMaxBackupIndex(1);
		appender.setFile(fileName + "_" + dateFormat.format(date) + ".log");

		PatternLayout layOut = new PatternLayout();
		layOut.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
		appender.setLayout(layOut);

		log.addAppender(appender);
	}

	public static Logger getLogger(){
		if(initializationFlag == false){
			intializeLogger();
			initializationFlag = true;
			return MtafLogger.log;
		}
		else{
			return MtafLogger.log;
		}
	}

	public static void setFileName(String fileName){
		MtafLogger.fileName = fileName;

	}
}
