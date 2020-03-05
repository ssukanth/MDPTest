package com.selenium.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mdp.api.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;


public class TestTrackers extends TestBase implements ITestListener{
	
	String testTagName;

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
        testTagName=context.getCurrentXmlTest().getName();
        System.out.println("Running the method for the test:"+testTagName);

    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println((" Test Suite is ending!"));
        extent.flush();
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        exeData.add("TestCaseName:"+result.getMethod().getMethodName());
        test.set(extentTest);
       // String x=t.getCurrentXmlTest().getName();
		
        System.out.println("Re-assiging the test to :"+testTagName);
    	//test.get().assignCategory(testTagName);
    	test.get().assignCategory(testGName);
        exeData.add("The Sequence of the execution data as follows");
        exeData.add("Admin name(if applicable):\nPasswrod\nBaseuri\nendpoint: or queryparam:\nconstructedpayload"
        		+ "\nResponse");
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    	getDriver().quit();

    }
 
    @Override
    public synchronized void onTestFailure (ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
        exeData.add("\nThe Issues was :"+result.getThrowable() );
        logFails(true,result);
      
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
        test.get().log(Status.SKIP, "The Test Case Is Skipped");
        test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
    
public void logFails(boolean takeScreenshot,ITestResult result)
{
	  String pat="";
	  File src=null;
      try {
 
      		
				String x=getReportFileLocation(platform);
				File fil=null;
				LogConfig originalLogConfig=null;
				OutputStream filOut;
				switch(platform)
				{
				case MAC:
					System.out.println("The screenshot location is :"+x.substring(0,x.lastIndexOf("/")));
		        	 pat=x.substring(0,x.lastIndexOf("/"))+"/"+result.getMethod().getMethodName()+".png";
		        	 originalLogConfig= RestAssured.config().getLogConfig();
		             //FileWriter fileWriter;
		            
		        	 
//		        	 try {
//		                  filOut = new FileOutputStream(x.substring(0,x.lastIndexOf("/"))+"/"+result.getMethod().getMethodName()+".log");
//		             } catch (IOException e) {
//		                 throw new UncheckedIOException(e);
//		             }
//		        	 PrintStream printStream = new PrintStream(filOut, true);
//		             RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(printStream).enablePrettyPrinting(false));
		         
		             fil= new File(x.substring(0,x.lastIndexOf("/"))+"/"+result.getMethod().getMethodName()+".log");
		             break;
				case WINDOWS:
					System.out.println("The screenshot location is :"+x.substring(0,x.lastIndexOf("\\")));
		        	 pat=x.substring(0,x.lastIndexOf("\\"))+"\\"+result.getMethod().getMethodName()+".png";
		        	 originalLogConfig = RestAssured.config().getLogConfig(); 
		             fil= new File(x.substring(0,x.lastIndexOf("\\"))+"\\"+result.getMethod().getMethodName()+".log");
		             break;
				}
				try (FileWriter writer = new FileWriter(fil);
	                BufferedWriter bw = new BufferedWriter(writer)) {
	               
					for(int i=0;i<exeData.size();i++)
					{
						if(exeData.get(i)!=null)
						{
							bw.write(exeData.get(i));
							bw.newLine();
						}else
						{
							System.out.println("There is a null value in te exedata file");
						}
					}
	               

	           } catch (IOException e) {
	               System.err.format("IOException: %s%n", e);
	           }

			 if(takeScreenshot)
		     {
		    		   src=((TakesScreenshot)driver.get()).getScreenshotAs(OutputType.FILE);  
		    	      	FileUtils.copyFile(src, new File(pat));
		    	      	test.get().addScreenCaptureFromPath(pat);
		     }

      	exeData=null;
      	getDriver().quit();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("WebDriver Exception occured while taking the screen shot");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException occured while taking the screen shot");

			e.printStackTrace();
		}
      

}

}
