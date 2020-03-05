

package com.selenium.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.FileInputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Capabilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;

public class SeleniumUtils extends AbstractWebDriverEventListener
{   
	public static HashMap<String,List<String> >tokenMaps=new HashMap<String,List<String>>();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static List<String>exeData;
    public static Platform platform;
    public static String reportFileName = getReportFilename();
//    protected static String macPath = System.getProperty("user.dir")+ "/Reports";
//    protected static String windowsPath = System.getProperty("user.dir")+ "\\Reports";
//    protected static String macReportFileLoc = macPath + "/" + reportFileName+"/AutomationResult.html";
//    protected static String winReportFileLoc = windowsPath + "\\" + reportFileName+"\\AutomationResult.html";
 //   protected static ExtentReports extent = ReportGenerator.createInstance();
    
    
	  protected static String macPath ;
	  protected static String windowsPath ;
	  protected static String macReportFileLoc;
	  protected static String winReportFileLoc;
	  protected static ExtentReports extent ;

    protected static JSONObject testData;
    public static JSONObject credentialJson;
    public static String getReportFilename()
    {
    	SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date d= new Date();
    	String  sb= sd.format(d);
    	System.out.println("The Report file name is:"+sb.replace("-", "_").replace(" ", "_").replace(":", ""));
    	return "TestRun"+sb.replace("-", "_").replace(" ", "").replace(":", "");  	
    }
    
    public static String getReportFileLocation (Platform platform) {
        String reportFileLocation = null;
        System.out.println("the platform is :"+platform);
        switch (platform) {
            case MAC:
                reportFileLocation = macReportFileLoc;
                createReportPath(macPath);
                System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
                break;
            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
                break;
            default:
                System.out.println("ExtentReport path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
    }
   
    public static void sleepTimer(int tim) {
        try {
            Thread.sleep(tim * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleepTimer(double tim) {
       int ti=(int)tim * 1000;
    	try {
            Thread.sleep(ti);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void waitForEle( WebDriver ap,  MobileElement ele,  int timeout,  String eleStatus) {
        final WebDriverWait wt = new WebDriverWait((WebDriver)ap, (long)timeout);
        final String upperCase;
        switch (upperCase = eleStatus.toUpperCase()) {
            case "CLICKABLE": {
                wt.until((Function)ExpectedConditions.elementToBeClickable((WebElement)ele));
                break;
            }
            case "VISIBLE": {
                wt.until((Function)ExpectedConditions.visibilityOf((WebElement)ele));
                break;
            }
            default:
                break;
        }
    }
    

    
    public Capabilities buildCapabilities(final String dType, final String platform, final String version, final String id, final String apkLoc) throws IOException {
        final String runEnv = System.getProperty("user.dir");
        System.out.println("The Run Env is :" + runEnv);
        final DesiredCapabilities caps = new DesiredCapabilities();
        if (runEnv.contains("Users")||runEnv.toLowerCase().indexOf("c:")>-1) {
            caps.setCapability("platformName", platform);
            if (platform.equalsIgnoreCase("ios")) {
                caps.setCapability("udid", id);
                System.out.println("An ios device");
            }
            else if (!dType.equalsIgnoreCase("device")) {
                caps.setCapability("avd", id);
                System.out.println("An android device");
            }
            if (!platform.equalsIgnoreCase("ios") && dType.equalsIgnoreCase("device")) {
                caps.setCapability("udid", id);
                System.out.println("An device");
            }
            caps.setCapability("deviceName", "AutoDevice");
            caps.setCapability("platformVersion", version);
            caps.setCapability("newCommandTimeout", 200);
            if(Character.getNumericValue(version.charAt(0))>=6) {
            	System.out.println("The version is greater than 6 so using caps u2");
                caps.setCapability("automationName", "uiautomator2");
            }
            caps.setCapability("adbExecTimeout", 50000);
            caps.setCapability("clearSystemFiles", true);
            caps.setCapability("app", apkLoc);
            caps.setCapability("noReset",false);
            caps.setCapability("fullReset", true);
            caps.setCapability("autoGrantPermissions", true);
            
            
        }
        return (Capabilities)caps;
    }
 
    public String[][] readExcel( String fileLoc,  String sheetName) throws InvalidFormatException, IOException {
         File fil = new File(fileLoc);
        FileInputStream fis = null;
         OPCPackage pkg = OPCPackage.open(fil);
        Workbook wb = null;
        fis = new FileInputStream(fil);
        wb = (Workbook)new XSSFWorkbook(pkg);
         Sheet sh = wb.getSheet(sheetName);
         int rc = sh.getPhysicalNumberOfRows();
         int cc = sh.getRow(0).getPhysicalNumberOfCells();
        System.out.println("The no of rows is :" + rc);
        System.out.println("The no of  cells " + cc);
         String[][] edata = new String[rc - 1][cc];
        for (int i = 1; i < rc; ++i) {
             Row cRow = sh.getRow(i);
            for (int j = 0; j < cc; ++j) {
                cRow.getCell(j).setCellType(CellType.STRING);
                edata[i - 1][j] = cRow.getCell(j).getStringCellValue();
            }
        }
        wb.close();
        fis.close();
        return edata;
    } 
    
    public static List<WebElement> getElements( WebDriver dri,  String idType,  String idloc,  int minEleCnt) throws Exception {
        List<WebElement>eles=null;
    	 WebElement mEle = null;
        try {
        	for(int i=0;i<10;i++)
        	{
        		sleepTimer(2);
        		switch (idType.toLowerCase()) {
                case "name": 
                	System.out.println("Find the element using Name");
                    eles = dri.findElements(By.name(idloc));
                    break;
                
                case "xpath":
                	System.out.println("Find the element using Xpath");
                    eles = dri.findElements(By.xpath(idloc));
                    break;
                
                case "id": 
                	System.out.println("Find the element using ID");
                    eles = dri.findElements(By.id(idloc));
                    break;
                
                case "css": 
                	System.out.println("Find the element using CSS");
                    eles= dri.findElements(By.cssSelector(idloc));
                    break;
                
            }
        		if(eles.size()>=minEleCnt)
        		{
        			System.out.println("The list has been loaded");
        			break;
        			
        		}else
        		{
        			System.out.println("The list yet to load......");
            		sleepTimer(3);

        		}
        	}
        	test.get().log(Status.INFO, "Found the list of :"+eles.size()+" for the path"+idloc);
        	return eles;
        }
        catch (Exception e) {
            if (Thread.currentThread().getStackTrace()[1].getClassName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[2].getClassName())) {
                System.out.println("The calling method belongs to same class");
                throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[3].getClassName() + " Due to :" + e.getMessage());
            }
            throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + "Due to :" + e.getMessage());
        }
        
    }
    
    
    public static WebElement getElement( WebDriver dri,  String idType,  String idloc,  int waitTime) throws Exception {
         WebDriverWait initWait = new WebDriverWait(dri, waitTime);
        try {
            return initWait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(final WebDriver input) {
                    WebElement ele = null;
                    switch (idType.toLowerCase()) {
                        case "name": 
                        	System.out.println("Find the element using Name");
                        	
                            ele = dri.findElement(By.name(idloc));
                            break;
                        
                        case "xpath": 
                        	System.out.println("Find the element using xpath");
                            ele = dri.findElement(By.xpath(idloc));
                            break;
                        
                        case "id": 
                        	System.out.println("Find the element using ID");
                            ele = dri.findElement(By.id(idloc));
                            break;
                        
                        case "css": 
                        	System.out.println("Find the element using CSS");
                            ele = dri.findElement(By.cssSelector(idloc));
                            break;
                            
                        case "partiallinktext"  :System.out.println("Find the element using Partiallinktext");   
                        	ele=dri.findElement(By.partialLinkText(idloc));break;
                        	
                        case "linktext"  :System.out.println("Find the element using linktext");   
                    		ele=dri.findElement(By.linkText(idloc));break;
                        case "tagname" : System.out.println("Finding the element using tagname");	
                        	ele=dri.findElement(By.tagName(idloc));break;
                    }
                   // test.get().log(Status.INFO, "Found the element with locator: "+idloc);
                    return ele;
                }
            });
        }
        catch (Exception e) {
            //test.get().log(Status.INFO, "Unable to find the element with locator: "+idloc);

            if (Thread.currentThread().getStackTrace()[1].getClassName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[2].getClassName())) {
                System.out.println("The calling method belongs to same class");
                throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[3].getClassName() + " Due to :" + e.getMessage());
            }
            throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + "Due to :" + e.getMessage());
        }
    }
    
    public void clickBy( WebDriver dri,  String idType,  String idloc,  int waitTime) throws Exception 
    {
    	  WebElement ele = getElement(dri, idType, idloc, waitTime);
          try {
              new WebDriverWait(dri,15).until(ExpectedConditions.elementToBeClickable(ele))
              	.click();
              test.get().log(Status.INFO, "Clicked on the Element");
          }
          catch (Exception e) {
              test.get().log(Status.INFO, "Unable to click on the Element");
              if (Thread.currentThread().getStackTrace()[1].getClassName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[2].getClassName())) {
                  System.out.println("The calling method belongs to same class");
                  throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[3].getClassName() + " Due to :" + e.getMessage());
              }
              throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + " Due to :" + e.getMessage());
          }
    }
    
    public void sendKeys( WebDriver dri,  String idType,  String idloc,  int waitTime, final String data) throws Exception {
        System.out.println("The title of the window is  :"+dri.getTitle());
    	WebElement ele = getElement(dri, idType, idloc, waitTime);
        try {
            new WebDriverWait(dri,15).until(ExpectedConditions.elementToBeClickable(ele))
            	.sendKeys(new CharSequence[] { data });
        }
        catch (Exception e) {
        	 if (Thread.currentThread().getStackTrace()[1].getClassName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[2].getClassName())) {
                 System.out.println("The calling method belongs to same class");
                 throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[3].getClassName() + " Due to :" + e.getMessage());
             }
        	throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + " Due to :" + e.getMessage());
        }
    }
    
    public String getDateString()
    {
    	String dtStr="";
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
    	dtStr=sd.format(d).replace("-", "").replace(" ", "").replace(":", "");
    	return dtStr;    	
    }
    
    public String spotColor(String rgbVal)
    {
    	String colr="";
    	String colStr[]=rgbVal.replace("(", "-").replace(")", "").split("-")[1].split(",");
      	if(Integer.parseInt(colStr[0].trim())>Integer.parseInt(colStr[1].trim()) &&Integer.parseInt(colStr[0].trim())>Integer.parseInt(colStr[2].trim()))
      	{
      		colr="RED";
      		System.out.println("RED");
      	}else if(Integer.parseInt(colStr[1].trim())>Integer.parseInt(colStr[2].trim()) &&Integer.parseInt(colStr[1].trim())>Integer.parseInt(colStr[0].trim()))
      	{
      		colr="GREEN";
      		System.out.println("GREEN");
      	}else
      	{
      		colr="BLUE";
      		System.out.println("BLUE");
      	}
      	
      	return colr;

    }
    
    public void jsMovetoEle(WebDriver dri, WebElement ele,String act) throws Exception
    {
    	JavascriptExecutor js=(JavascriptExecutor) dri;
    	
    	try {
    		switch(act.toLowerCase())
    		{
    		case "move":js.executeScript("arguments[0].scrollIntoView(true);", ele);break;
    		case "click":js.executeScript("arguments[0].click();", ele);break;
    		case "refresh" :js.executeScript("history.go(0)");
    		}
    		
    	}catch(Exception e)
    	{
    		System.out.println(e.getMessage());
            throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + " Due to :" + e.getMessage());

    	}
    }
    
    
    public void jsMovetoEleBy(WebDriver dri,  String idType,  String idloc,  int waitTime,String act) throws Exception
    {
    	JavascriptExecutor js=(JavascriptExecutor) dri;
    	WebElement ele=getElement(dri, idType, idloc, waitTime);
    	sleepTimer(1);
    	try {
    		switch(act.toLowerCase())
    		{
    		case "move":js.executeScript("arguments[0].scrollIntoView(true);", ele);break;
    		case "click":js.executeScript("arguments[0].click();", ele);break;
    		}
    		
    	}catch(Exception e)
    	{
    		System.out.println(e.getMessage());
            throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + " Due to :" + e.getMessage());

    	}
    }
    
    
    public static Platform getCurrentPlatform () {
        if (platform == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                platform = Platform.LINUX;
            } else if (operSys.contains("mac")) {
                platform = Platform.MAC;
            }
        }
        return platform;
    }
    
   
    
    
    public static void createReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }
    
    public String getText(WebDriver dri,  String idType,  String idloc,  int waitTime) throws Exception
    {
    	WebElement ele= null;
    	boolean stale=true;
    		for(int i=0;i<5;i++)
    		{
    			try
    			{
    				ele=getElement(dri, idType, idloc, waitTime);
    				System.out.println("The element is found");
    				stale=false;
    				break;
    			}catch(StaleElementReferenceException see)
    			{
    				System.out.println("The element is statle so waiting for some time");
    				sleepTimer(3);
    			}
    		}
    	
    	 try {
    		 if(stale) throw new StaleElementReferenceException("Element stale ");
    		 System.out.println("Performing the operation");
    		 String retVal=ele.getText();
    		// String retVal=ele.getAttribute("innerText");
    		 for(int i=0;i<15;i++)
    		 {
    			 if(retVal.equalsIgnoreCase("")) {
    				 System.out.println("The text has not populated so wating....");
    				 sleepTimer(2);
    			 }else
    			 {
    				 break;
    			 }
    		 }
    		 return retVal;
         }
         catch (Exception e) {
        	 if (Thread.currentThread().getStackTrace()[1].getClassName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[2].getClassName())) {
                 System.out.println("The calling method belongs to same class");
                 throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[3].getClassName() + " Due to :" + e.getMessage());
             }
        	 throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + " Due to :" + e.getMessage());
         }
    }
    
    public String getAttr(WebDriver dri,  String idType,  String idloc,  int waitTime,String attr) throws Exception
    {
    	WebElement ele= getElement(dri, idType, idloc, waitTime);
    	
    	 try {
    		 return ele.getAttribute(attr);
         }
         catch (Exception e) {
        	 if (Thread.currentThread().getStackTrace()[1].getClassName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[2].getClassName())) {
                 System.out.println("The calling method belongs to same class");
                 throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[3].getClassName() + " Due to :" + e.getMessage());
             }
        	 throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + " Due to :" + e.getMessage());
         }
    }
    
    public boolean dateDiff(int maxDiff,String evalDateString) throws ParseException
    	{
    		 SimpleDateFormat sd= new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");
    		 Date d1=sd.parse(evalDateString);
    		  Date d2=sd.parse(sd.format(new Date()));
    		  int timeDif=(int)((d2.getTime()-d1.getTime())/(60*1000));
    		  System.out.println();
    		  if(timeDif>=maxDiff) return false;
    		  return true;
    	}
    
    
  
    
    public void clickEle(WebDriver dri,WebElement ele,int Timeout) throws Exception
    {
    	
    	try {
            new WebDriverWait(dri,Timeout).until(ExpectedConditions.elementToBeClickable(ele))
            	.click();
            test.get().log(Status.INFO, "Clicked on the Element");
        }
        catch (Exception e) {
            test.get().log(Status.INFO, "Unable to click on the Element");
            if (Thread.currentThread().getStackTrace()[1].getClassName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[2].getClassName())) {
                System.out.println("The calling method belongs to same class");
                throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[3].getClassName() + " Due to :" + e.getMessage());
            }
            throw new Exception("The error occured at:" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " Of the class :" + Thread.currentThread().getStackTrace()[2].getClassName() + " Due to :" + e.getMessage());
        }
    	
    }
    
    public void waitUntilRefreshed(WebDriver dri,WebElement ele)
    {
    	WebDriverWait ww= new WebDriverWait(dri,30);
    	ww.until(ExpectedConditions.refreshed(new ExpectedCondition<String >() {
    		public String  apply(WebDriver dr) {
    			return ele.getText();
    		}
		}));
    }
    
    public void clearCacheJs(WebDriver dri)
    {
    	JavascriptExecutor js = (JavascriptExecutor) dri;
    	 
        System.out.println("--Local Storage Clear Start--");
     
        js.executeScript(String.format("window.localStorage.clear();"));
     
        js.executeScript(String.format("window.sessionStorage.clear();"));
     
        System.out.println("--Local Storage Clear End--");
    }
    
    public JSONObject[][]getTestData(String testCaseId)
    {
    	JSONArray jTestdata=(JSONArray) testData.get(testCaseId);
    	int colSize=((JSONObject)jTestdata.get(0)).size();
    	System.out.println("The col size is:"+colSize);
    	JSONObject[][] testD=new JSONObject[jTestdata.size()][1];
    	for(int i=0;i<jTestdata.size();i++)
    	{
    		testD[i][0]=(JSONObject)jTestdata.get(i);
    	}
    	System.out.println(testD.length);
    	System.out.println(testD[0].length);
    	return testD;
    	
    }
    
   
    
    public void writeToTxt(String filLoc,String txt) throws IOException
    {
    	
    	 FileWriter fw=new FileWriter(filLoc);    
         fw.write(txt);    
         fw.close();    
    	
    }
    
    public String genCurDateString()
    {
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    	String str=sd.format(d).replace("-", "").replace(" ", "_");
    	System.out.println("Generated the date string :"+str);
    	return str;
    	
    }
    
    public String genCurDateString(String dateformat)
    {
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat(dateformat);
    	String str=sd.format(d).replace("-", "").replace(" ", "");
    	System.out.println("Generated the date string :"+str);
    	return str;
    	
    }
    
    public String getCurdateInMSFormat()
    {
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	return sd.format(d);
    	
    }
    
    public String getFutdateInMSFormat(int noofFuturedates)
    {
    	Calendar cal=Calendar.getInstance();
    	cal.add(Calendar.DATE,noofFuturedates );
    	SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	return sd.format(cal.getTime());	
    }
 
    public WebDriver getChromeBrowser(boolean headLess) throws IOException
    {
    	WebDriver dri=null;
    	String effLoc=null;
    	switch (platform) {
        case MAC:
        	effLoc="/src/test/resources/Drivers/Macos/chromedriver80";
            break;
        case WINDOWS:
        	effLoc="/src/test/resources/Drivers/Windows/chromedriver.exe";
            break;
        default:
            System.out.println("ExtentReport path has not been set! There is a problem!\n");
            break;
    }
    	System.out.println("the Efeectinve loc for the selenium Driver is :"+effLoc);
    	System.setProperty("webdriver.chrome.driver",
    			new File(".").getCanonicalPath() +effLoc );
    			
    			
    	if(headLess)
    	{
    		ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			dri = new ChromeDriver(chromeOptions);	
    	}else
    	{
    		dri=new ChromeDriver();
    	}
    	dri.manage().window().maximize();
    	return dri;
    }
    
    
    public String getHourString()
    {
    	
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("HH");
    	String hrs=sd.format(d);
    	if(hrs.length()<2) hrs="0"+hrs;
    	return  hrs;
    }
    
    public String getDayString()
    {
    	
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("dd");
    	return  sd.format(d);
    }
    
    public String getSecString()
    {
    	
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("ss");
    	return  sd.format(d);
    }
    
    
    public String getYearString()
    
    {
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("yyyy");
    	return sd.format(d);
    }
    
    public String getMinString()
    {
    	
    	Date d= new Date();
    	SimpleDateFormat sd= new SimpleDateFormat("mm");
    	String mins=sd.format(d);
    	if(mins.length()<2) mins="0"+mins;
    	return  mins;
    }
   
   public void assertVal(Object act,Object exp)
   {
	   test.get().log(Status.DEBUG, "The Actual is :"+act+"\n the Expected is :"+exp);
	   Assert.assertEquals(act, exp);  
   }
 
}
