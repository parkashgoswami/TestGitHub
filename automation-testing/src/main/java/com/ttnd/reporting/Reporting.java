package com.ttnd.reporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.ttnd.utilities.CommonVariables;
import com.ttnd.utilities.FrameworkException;
import com.ttnd.utilities.GlobalVar;

public class Reporting {
	OutputStream consolidateHtmlFile;
	PrintStream consolidatePrintHtml;
	
	public void generateFinalReport(List<String> deviceList2) {

		openConsolidateFile();

		consolidatePrintHtml.println("<!DOCTYPE html>");
		consolidatePrintHtml.println("<html>");
		consolidatePrintHtml.println("<head>");
		consolidatePrintHtml.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
		consolidatePrintHtml.println("<title>Summary Report</title>");

		consolidatePrintHtml.println("<link rel=\"shortcut icon\" href=\"resources/images/favicon_auto.ico\">");

		consolidatePrintHtml.println("<script type=\"text/javascript\" src='resources/jquery-2.1.0.min.js'></script>");
		consolidatePrintHtml.println("<script type=\"text/javascript\" src='resources/js/chart.min.js'></script>");
		consolidatePrintHtml.println("<script type='text/javascript' src='resources/summary.js'></script>");
		consolidatePrintHtml.println("<script type=\"text/javascript\" src=\"resources/js/bootstrap.js\"></script>");
		consolidatePrintHtml.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/bootstrap.css\">");

		consolidatePrintHtml.println("<style type=\"text/css\">");

		consolidatePrintHtml.println("* {font-family: 'Segoe UI',Tahoma,Helvetica,Sans-Serif;}");

		consolidatePrintHtml.println("#filterField{");
		consolidatePrintHtml.println("float: right;");
		consolidatePrintHtml.println("border-radius: 5px;");
		consolidatePrintHtml.println("padding: 6px;");
		consolidatePrintHtml.println("border: 1px solid #BDBDBD;}");

		consolidatePrintHtml.println(".navbar h3{float: left;}");

		consolidatePrintHtml.println(".navbar .logo{\nfloat: right;\nbackground-image: url(resources/images/logo.png);\nwidth: 100px;\nheight: 30px;" + 
				"\nbackground-repeat: no-repeat;" + 
				"\nbackground-size: contain;" + 
				"\nmargin: 15px auto;}");

		consolidatePrintHtml.println(".navbar .logomf{" +
				"\nfloat: right;" +
				"\nbackground-image: url(resources/images/mf_logo.jpg);" +
				"\nwidth: 100px;" +
				"\nheight: 30px;" +
				"\nbackground-repeat: no-repeat;" +
				"\nbackground-size: contain;" + 
				"\nmargin: 15px auto;}");


		consolidatePrintHtml.println("td .glyphicon{" +
				"\npadding-right: 5px;}");


		consolidatePrintHtml.println(".highlighted {" +
				"\nbackground-color: rgba(255, 230, 0, 0.5);" +
				"\nmargin: 0px;"+
				"\nborder-radius: 3px;}");

		consolidatePrintHtml.println("#noresultrow{" + 
				"\nheight: 50px;" +
				"\ndisplay: table-row;}");

		consolidatePrintHtml.println("#main-report{"+
				"\nwidth: 100%;"+
				"\nheight: 100%;"+ 
				"\ndisplay: none;"+
				"\nposition: fixed;}");


		consolidatePrintHtml.println("#report-iframe{"+
				"\nwidth: 100%;"+
				"\nheight: 100%;"+
				"\nposition: relative;}");

		consolidatePrintHtml.println("/* iFrame overlay buttons */");
		consolidatePrintHtml.println(".floating{" +
				"\nposition: fixed;" +
				"\nz-index: 1;" +
				"\nbackground-color: #f3f3f3;" +
				"\ntext-align: center;" +
				"\npadding: 15px 0px;" +
				"\ncursor: pointer;" +
				"\nwidth: 140px;" +
				"\nwhite-space: nowrap;" +
				"\nfont-size: 11px;" +
				"\nfont-weight: bold;" +
				"\nright: -100px;" +
				"\ntransition: right 0.2s;}");

		consolidatePrintHtml.println(".floating span {" +
				"\nfloat: left;" +
				"\nwidth: 40px;" +
				"\ntext-align: center;}");

		consolidatePrintHtml.println(".floating:hover{"+
				"\nright: 0px;}");

		consolidatePrintHtml.println("#returntomenu {"+
				"\nbottom: 114px;}");

		consolidatePrintHtml.println("#nextbutton{"+
				"\nbottom: 62px;}");

		consolidatePrintHtml.println("#backbutton{"+
				"\nbottom: 10px;}");

		consolidatePrintHtml.println("#search-container{"+
				"\nwidth: 100%;"+
				"\n	height: 50px;"+
				"\n	margin: 0;"+
				"\n	padding: 0;}");

		consolidatePrintHtml.println(".panel .table{"+
				"\nmargin: 0;}");

		consolidatePrintHtml.println(".table tbody tr{"+
				"\ncursor: pointer;}");

		consolidatePrintHtml.println(".table tbody tr:hover{" +
				"\nbackground-color: #f3f3f3;}");

		consolidatePrintHtml.println("#bar-chart-container{" +
				"\nwidth: 50%;"+
				"\n	float: left;}");

		consolidatePrintHtml.println("#pie-chart-container{" +
				"\nwidth: 50%;" +
				"\nfloat: right;}");

		consolidatePrintHtml.println("#noscript{" +
				"\nposition: fixed;" +
				"\nz-index: 10;" +
				"\ntop: 10px;" +
				"\nright: 30px;}");

		consolidatePrintHtml.println("</style></head>");
		consolidatePrintHtml.println("<body>");
		consolidatePrintHtml.println("<noscript><div id='noscript'>Javascript was not detected. Please enable Javascript in this page to access the data in this report.</div></noscript>");

		consolidatePrintHtml.println("<div id='main-menu'>");
		consolidatePrintHtml.println("<nav class=\"navbar navbar-default\">");
		consolidatePrintHtml.println("<div class=\"container-fluid\">");
		consolidatePrintHtml.println("<h3>#Fame Reports</h3>");
		consolidatePrintHtml.println("<a href='http://www.livfame.com' class='logo' target='_BLANK'></a>");
		consolidatePrintHtml.println("</div>");
		consolidatePrintHtml.println("</nav>");

		consolidatePrintHtml.println("<div class='container-fluid'>");

		consolidatePrintHtml.println("<div class='panel panel-default'>");
		consolidatePrintHtml.println("<div class='panel-heading'>Device Specific Reports</div>");
		consolidatePrintHtml.println("<div class='panel-body'>");
		consolidatePrintHtml.println("<table class='table'>");
		consolidatePrintHtml.println("<thead>");
		consolidatePrintHtml.println("<th class='text-center'>#</th>");
		consolidatePrintHtml.println("<th >Device Name</th>");
		consolidatePrintHtml.println("</thead>");
		consolidatePrintHtml.println("<tbody>");

		for (int i = 0; i < deviceList2.size(); i++) {

			consolidatePrintHtml.println("<tr>");
			consolidatePrintHtml.println("<td style='text-align: center;'><span>"+(i+1)+"<span></td>");
			boolean check = new File(GlobalVar.REPORT_FOLDER_FOR_ENVIRONMENT + "/" + deviceList2.get(i), GlobalVar.REPORT_FILE_NAME).exists();
			
			if(check){
				consolidatePrintHtml.println("<td><a href='"+deviceList2.get(i)+"/Execution_Report.html'>"+deviceList2.get(i)+"</a></td>");
			}else{
				consolidatePrintHtml.println("<td><span style=\"color:red\">"+deviceList2.get(i)+ " - Report Not Generated!!" + "</span></td>");
			}
			consolidatePrintHtml.println("</tr>");

		}

		consolidatePrintHtml.println("<tr id=\"noresultrow\" style=\"display: none;\">");
		consolidatePrintHtml.println("<td colspan=\"5\">");
		consolidatePrintHtml.println("<center>No test results were found for the search <b id=\"noresultrow-searchtext\"></b></center>" +
				"\n</td>" +
				"\n</tr>" +
				"\n</tbody>" +
				"\n</table>" +
				"\n</div>" +
				"\n</div>" +
				"\n</div>" +
				"\n</div>" +
				"\n</body>" +
				"\n</html>");


		//copy resources folder from src/test/resources/resources to Env root
		DirectoryCopy(GlobalVar.REPORT_RESOURCES_FOLDER, 
				GlobalVar.REPORT_FOLDER_FOR_ENVIRONMENT   + "/" + "resources");

		//close consolidatePrintHtml
		try {
			consolidateHtmlFile.close();
			consolidateHtmlFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public void openConsolidateFile() {

		try {
			consolidateHtmlFile = new FileOutputStream(new File(
					GlobalVar.REPORT_FOLDER_FOR_ENVIRONMENT + "/" 
							+ GlobalVar.CONSOLIDATED_REPORT_FILE_NAME), true);
		} catch (FileNotFoundException e) {
			throw new FrameworkException(GlobalVar.CONSOLIDATED_REPORT_FILE_NAME + "FileNotFoundException");
		}

		consolidatePrintHtml = new PrintStream(consolidateHtmlFile);
	}

	public static String createResultFolderStructure(String environment) {
		String cDrive = GlobalVar.REPORT_FOLDER;
//		for(File drive:File.listRoots()){
//			System.out.println("-----"+ drive.getPath());
//			if(drive.getPath().contains("c")){
//				cDrive = drive.getPath();
//				break;
//			}
//		}
		//		File reportsDir = new File(new File(System.getProperty("user.dir")).getParent(), "FameReports");
		File reportsParentDir = new File(cDrive, GlobalVar.REPORT_FOLDER_ROOT_NAME);
		//Remove REPORT_FOLDER_ROOT_NAME
		if(!reportsParentDir.exists()){
			System.out.println("Directory does not exist.");
		}else{
			try {
				DeleteDir(reportsParentDir);
			} catch (IOException e) {
				throw new FrameworkException("Unable to Delete dir " + reportsParentDir);
			}
		}
		File reportsDir = new File(reportsParentDir, environment);

		//		System.out.println(device + " Reports Dir " + reportsDir.getAbsolutePath().toString());
		reportsParentDir.mkdirs();
		reportsDir.mkdirs();

		//		File reportTemp = new File(reportsDir, device);
		//		reportTemp.mkdirs();
		return reportsDir.getAbsolutePath();
	}

	private static void DeleteDir(File file) throws IOException{
		if(file.isDirectory()){

			//directory is empty, then delete it
			if(file.list().length==0){

				file.delete();
				System.out.println("Directory is deleted : " 
						+ file.getAbsolutePath());

			}else{

				//list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					//construct the file structure
					File fileDelete = new File(file, temp);

					//recursive delete
					DeleteDir(fileDelete);
				}

				//check the directory again, if empty then delete it
				if(file.list().length==0){
					file.delete();
					System.out.println("Directory is deleted : " 
							+ file.getAbsolutePath());
				}
			}

		}else{
			//if file, then delete it
			file.delete();
			//			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}

	private void DirectoryCopy(String source, String destination) {
		File srcDir = new File(source);
		File destDir = new File(destination);

		try {
			FileUtils.copyDirectory(srcDir, destDir);
		} catch (IOException e) {
			throw new FrameworkException("Unable to Copy resources dir "); 
		}
	}

}
