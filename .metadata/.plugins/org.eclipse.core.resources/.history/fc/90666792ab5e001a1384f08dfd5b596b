package com.selenium.utils;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGenerator extends SeleniumUtils {
	 
//    public static ExtentReports getInstance() {
//        if (extent == null)
//            createInstance();
//        return extent;
//    }
 
    public static ExtentReports createInstance(String reportName, String build) throws UnknownHostException {
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        System.out.println("The Report will be genrated at the loc:"+fileName);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        
        htmlReporter.config().setDocumentTitle(reportName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Report for "+reportName+"Tests Ran On The Build :"+build);
        htmlReporter.getCategoryContextInfo();
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("HostName", InetAddress.getLocalHost().getHostName());
        extent.setSystemInfo("Operating System", platform.toString());
        extent.setSystemInfo("APIServiceName", reportName);
        extent.setSystemInfo("BuildNumber", build);
        extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
        return extent;
    }
 
    
    public static ExtentReports createInstance(String reportName) throws UnknownHostException {
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        System.out.println("The Report will be genrated at the loc:"+fileName);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Report for "+reportName);
        htmlReporter.getCategoryContextInfo();
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("HostName", InetAddress.getLocalHost().getHostName());
        extent.setSystemInfo("Operating System", platform.toString());
        extent.setSystemInfo("APIServiceName", reportName);
       // extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
        extent.setSystemInfo("BuildeDetails: ","");  

        if(credentialJson.get("buildDetails")!=null) {
    	   Map<String,String>m=(Map)credentialJson.get("buildDetails");
    	   for(Map.Entry<String, String>e:m.entrySet())
    	   {
    		   
    	        extent.setSystemInfo(e.getKey(), e.getValue());  
    		   
    	   }
       }
        
        return extent;
    }
    
    
 
   
   

}
