package com.mdp.api.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mdp.api.services.CreateStudy;
import com.mdp.visu.web.pages.Web_ACCreateCasePage;
import com.mdp.visu.web.pages.Web_ACUserViewEditCasePage;
import com.mdp.visu.web.pages.Web_AcUploaderHomePage;
import com.mdp.visu.web.pages.Web_LoginPage;
import com.mdp.visu.web.pages.Web_RCUserHomePage;
import com.mdp.visu.web.pages.Web_ReviewPage;
import com.selenium.utils.CheckforDownload;
import com.selenium.utils.TestVars;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import io.restassured.response.Response;

public class ACSanityFlowTests extends TestBase {
	
	
  @DataProvider(name="TC4792")
  public  JSONObject[][] dataTC4792() throws IOException, InvalidFormatException
  {	  
  	return getTestData("TC4792");
  }
@Test(dataProvider="TC4792",groups= {"acs","tcs"},enabled=true)
public void tc4792(JSONObject j) throws Exception
{
	//Initializing the test data from the json
	
	TestVars gt= getTestVars();
	WebDriver dri2=getDriver();
	String uploaderName=(String)j.get("uploader");
	String gen=String.valueOf(j.get("gender"));
	String dStatus=String.valueOf(j.get("diabetstatus"));
	String g1=(String)j.get("grader1");
	System.out.println("Running the test for the data");
	System.out.println(uploaderName+"_"+gen+"_"+dStatus+"_"+g1);
	
	//Setup from the credentials file
	String  url=(String) credentialJson.get("url");
	System.out.println("The url is :"+url);
	JSONObject uploaderDets=(JSONObject) credentialJson.get(uploaderName);
	String upwd=(String) uploaderDets.get("pwd");
	String userString=(String) uploaderDets.get("userstring");
	gt.setCaseCreatingUserString(userString);
	String siteId=String.valueOf(uploaderDets.get("siteid"));
	gt.setSiteId(Integer.parseInt(siteId));
	System.out.println("The uploader details are :"+uploaderName+"_"+upwd+"_"+userString+"_"+siteId);
	System.out.println("The ");
	//Generating the authtoken for the upload and edit case api calls
	
	String authT=getIdToken(dri2,uploaderName, upwd,String.valueOf(uploaderDets.get("appId")));
	System.out.println("The authtoken in test class is "+authT);

//	String baseUri=credentialJson.get("baseUri").toString();
//	gt.setBaseUri(baseUri);
//	gt.setDeleteUri((String)credentialJson.get("createStudy"));
//	dri2.get(url);
//	//Ui execution starts from here
//	
//	Web_AcUploaderHomePage acPage= (Web_AcUploaderHomePage) new Web_LoginPage(dri2).login(upwd, uploaderName, "icdr");
//	Web_ACCreateCasePage cc=acPage.clickCreateCase();
//	String patId=String.valueOf(cc.getPatientId()).trim();
//	System.out.println("The generated patient id:"+patId);
//	CreateStudy cs= new CreateStudy();
//	Response res2=	cs.createCase(true,false,baseUri, gt.getAuthToken(), patId, gen, dStatus, userString, siteId);
//	test.get().log(Status.PASS, "Created the case with details :"+res2.body().asString()+"With patient"+patId);
//	System.out.println(res2.body().asString());
//	int caseId=res2.jsonPath().get("StudyId");
//	gt.setStrCaseid(Integer.toString(caseId));
//	 System.out.println("The case id is :"+caseId);
//	 acPage=cc.gotoHome();
//	 Web_RCUserHomePage rcHome=(Web_RCUserHomePage)acPage.logout().login((String)((JSONObject)credentialJson.get(g1)).get("pwd"), g1, "rcuser");
//	 int c=rcHome.getReviewCount();
//	 System.out.println("The count is :"+c);
//	 Web_ReviewPage revPage=rcHome.clickReview();
//	 rcHome=revPage.reviewPatient(2,gt.getStrCaseid()); 
//	 acPage=(Web_AcUploaderHomePage)rcHome.logout().login(upwd,uploaderName, "icdr");
//	 Web_ACUserViewEditCasePage acView=acPage.clickViewCard(gt);
//	 acView.clickDownReport(gt,"download");
//	 CheckforDownload chD= new CheckforDownload();
//	 chD.waitForDownload( "file:///Users/VISUWEBTESTNG/WebTestng/Downloads/"+patId+"_retinareport.pdf");
	 	// implementation for verifying the pdf	 
	}



}
