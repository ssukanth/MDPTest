package com.mdp.api.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.hasItem;
import com.aventstack.extentreports.Status;
import com.mdp.api.services.MDPUser;
import com.mdp.visu.web.pages.Web_MailVerificationPage;
import com.selenium.utils.MailBox;
import com.selenium.utils.TestVars;

import io.restassured.response.Response;

public class MDPUserTests extends TestBase {

	 @DataProvider(name="MDP4792")
	  public  JSONObject[][] dataMDP4792() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("MDP4792");
	  }
	@Test(dataProvider="MDP4792",groups= {"mdp"},enabled=true)
	public void tcMDPCreateAdmin(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		
		String adminUser=(String)j.get("admin");
		String mail=(String)j.get("email");
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		System.out.println(adminUser+"_"+mail+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		JSONObject adminDets=(JSONObject) credentialJson.get(adminUser);
		String upwd=(String) adminDets.get("pwd");
		exeData.add(appId);
		//Generating the authtoken for the upload and edit case api calls
		String authT=getIdToken(null,adminUser, upwd,String.valueOf(adminDets.get("appId")));
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		Response res=mdpUser.createUserMDPAdmin(authT, true, mail, appId,"","","","","");
		exeData.add(res.asString());
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		System.out.println(res.body().asString());
		validateSchema(res, new File(".").getCanonicalPath()+"/src/test/resources/Schemas/MDPCreateUserResponseSchema.json");
		
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","INBOX", "VISUHEALTH","href=\"","&language","html",false);
		System.out.println("The content of the mail is :"+y);
		WebDriver dri2=getDriver();
		dri2.get(y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(dri2);
		mail=res.jsonPath().getString("email");
		String userId=res.jsonPath().getString("userId");
		mv.verifyMail(y,mail,"Test123!");
		List<String>l=Arrays.asList(mail,"Test123!",userId);
		dynamicCredentials.put("mdpadmin", l);
		test.get().log(Status.INFO, "The MDPApp Admin Created With :"+userId+"|"+mail);


		}
	
	
	  @DataProvider(name="MDPCreateSSC")
	  public  JSONObject[][] dataMDPCreateSSC() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("MDPCreateSSC");
	  }
	@Test(dataProvider="MDPCreateSSC",groups= {"mdpt"},enabled=true)
	public void tcMDPCreateSSC(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		 
		String adminUser=(String)j.get("admin");
		String mail=(String)j.get("email");
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		System.out.println(adminUser+"_"+mail+"_"+appId);
		
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		JSONObject adminDets=(JSONObject) credentialJson.get(adminUser);
		String upwd=(String) adminDets.get("pwd");
		exeData.add(appId);
		//Generating the authtoken for the upload and edit case api calls
		String authT=getIdToken(null,adminUser, upwd,String.valueOf(adminDets.get("appId")));
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		Response res=mdpUser.createUserMDPUser(true,authT, mail, appId, "1", (String)credentialJson.get("SSCAdmin"), "", "", "test@gmail.com");
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		System.out.println(res.body().asString());
		mail=res.jsonPath().getString("email");
		String userId=res.jsonPath().getString("userId");
		exeData.add(res.asString());
		test.get().log(Status.DEBUG, "Creted the user for data :"+mail+"_"+appId);
		//mdpUser.validateSchema(res);
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "VISUHEALTH","href=\"","&language","html",false);
		System.out.println("The content of the mail is :"+y);
		WebDriver dri2=getDriver();
		dri2.get(y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(dri2);
		
		mv.verifyMail(y,mail,"Test123!");
		List<String>l=Arrays.asList(mail,"Test123!",userId);
		dynamicCredentials.put("sscadmin", l);
		test.get().log(Status.INFO, "The SSC Admin Created With :"+userId+"|"+mail);
		}
	
	
	 @DataProvider(name="MDPCreateAcAdmin")
	  public  JSONObject[][] datatcMDPCreateAcAdmin() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcMDPCreateAcAdmin");
	  }
	@Test(dataProvider="MDPCreateAcAdmin",groups= {"mdpt"},enabled=true,dependsOnMethods= {"com.mdp.api.tests.MDPAccountTests.tcMDPCreateAc"})
	public void tcMDPCreateAcAdmin(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("sscadmin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		String roleID=(String)credentialJson.get("AccountAdmin");
		test.get().log(Status.DEBUG, "Creating User for the role:"+roleID);
		System.out.println("Creating the user for the role:"+roleID);
		Response res=mdpUser.createUserMDPUser(true,authT, "", appId, "1",roleID , "", dynamicCredentials.get("tcMDPCreateAc").get(0), "test@gmail.com");
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The Post for Create Account admin passed with res:"+res.body().asString());
		mail=res.jsonPath().getString("email");
		String userId=res.jsonPath().getString("userId");
		exeData.add(res.asString());
		test.get().log(Status.DEBUG, "Creted the user for data :"+mail+"_"+appId);
		//mdpUser.validateSchema(res);
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "VISUHEALTH","href=\"","&language","html",false);
		System.out.println("The content of the mail is :"+y);
		WebDriver dri2=getDriver();
		dri2.get(y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(dri2);
		mv.verifyMail(y,mail,"Test123!");
		List<String>l=Arrays.asList(mail,"Test123!",userId);
		dynamicCredentials.put("acadmin", l);
		test.get().log(Status.INFO, "The Accountadmin Created With :"+userId+"|"+mail);
		}
	
	
	 @DataProvider(name="tcMDPCreateSiteAdmin")
	  public  JSONObject[][] datatctcMDPCreateSiteAdmin() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcMDPCreateSiteAdmin");
	  }
	@Test(dataProvider="tcMDPCreateSiteAdmin",groups= {"mdpt"},enabled=true,dependsOnMethods= {"com.mdp.api.tests.MDPSiteTests.tcMDPCreateSite"})
	public void tcMDPCreateSiteAdmin(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("sscadmin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		String roleID=(String)credentialJson.get("SiteAdmin");
		test.get().log(Status.DEBUG, "Creating User for the role:"+roleID);
		System.out.println("Creating the user for the role:"+roleID);
		Response res=mdpUser.createUserMDPUser(true,authT, "", appId, "1",roleID , dynamicCredentials.get("tcMDPCreateSite").get(0), dynamicCredentials.get("tcMDPCreateAc").get(0), "test@gmail.com");
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The Post for Create Account admin passed with res:"+res.body().asString());
		mail=res.jsonPath().getString("email");
		String userId=res.jsonPath().getString("userId");
		exeData.add(res.asString());
		test.get().log(Status.DEBUG, "Creted the user for data :"+mail+"_"+appId);
		//mdpUser.validateSchema(res);
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "VISUHEALTH","href=\"","&language","html",false);
		System.out.println("The content of the mail is :"+y);
		WebDriver dri2=getDriver();
		dri2.get(y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(dri2);
		mv.verifyMail(y,mail,"Test123!");
		List<String>l=Arrays.asList(mail,"Test123!",userId);
		dynamicCredentials.put("siteadmin", l);
		test.get().log(Status.INFO, "The SiteAdmin Created With :"+userId+"|"+mail);
		}
	
	
	@Test(dataProvider="tcMDPCreateSiteAdmin",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateSiteAdmin"})
	public void tcMDPCreateUploader(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("siteadmin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		String roleID=(String)credentialJson.get("Uploader");
		test.get().log(Status.DEBUG, "Creating User for the role:"+roleID);
		System.out.println("Creating the user for the role:"+roleID);
		Response res=mdpUser.createUserMDPUser(true,authT, "", appId, "1",roleID , dynamicCredentials.get("tcMDPCreateSite").get(0), dynamicCredentials.get("tcMDPCreateAc").get(0), "test@gmail.com");
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The Post for Create Account admin passed with res:"+res.body().asString());
		mail=res.jsonPath().getString("email");
		String userId=res.jsonPath().getString("userId");
		exeData.add(res.asString());
		test.get().log(Status.DEBUG, "Creted the user for data :"+mail+"_"+appId);
		//mdpUser.validateSchema(res);
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "VISUHEALTH","href=\"","&language","html",false);
		System.out.println("The content of the mail is :"+y);
		WebDriver dri2=getDriver();
		dri2.get(y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(dri2);
		mv.verifyMail(y,mail,"Test123!");
		List<String>l=Arrays.asList(mail,"Test123!",userId);
		test.get().log(Status.INFO, "The Uploader Created With :"+userId+"|"+mail);
		dynamicCredentials.put("uploader", l);
		}
	
	
	@Test(dataProvider="tcMDPCreateSiteAdmin",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateSiteAdmin"})
	public void tcMDPCreateReviewer(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("siteadmin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		String roleID=(String)credentialJson.get("Reviewer");
		test.get().log(Status.DEBUG, "Creating User for the role:"+roleID);
		System.out.println("Creating the user for the role:"+roleID);
		Response res=mdpUser.createUserMDPUser(true,authT, "", appId, "1",roleID , dynamicCredentials.get("tcMDPCreateSite").get(0), dynamicCredentials.get("tcMDPCreateAc").get(0), "test@gmail.com");
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The Post for Create Account admin passed with res:"+res.body().asString());
		mail=res.jsonPath().getString("email");
		String userId=res.jsonPath().getString("userId");
		exeData.add(res.asString());
		test.get().log(Status.DEBUG, "Creted the user for data :"+mail+"_"+appId);
		//mdpUser.validateSchema(res);
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "VISUHEALTH","href=\"","&language","html",false);
		System.out.println("The content of the mail is :"+y);
		WebDriver dri2=getDriver();
		dri2.get(y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(dri2);
		mv.verifyMail(y,mail,"Test123!");
		List<String>l=Arrays.asList(mail,"Test123!",userId);
		test.get().log(Status.INFO, "The Uploader Created With :"+userId+"|"+mail);
		dynamicCredentials.put("reviewer", l);
		}
	
	
	@Test(dataProvider="tcMDPCreateSiteAdmin",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateSiteAdmin"})
	public void tcMDPCreateNurse(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("siteadmin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		String roleID=(String)credentialJson.get("Nurse");
		test.get().log(Status.DEBUG, "Creating User for the role:"+roleID);
		System.out.println("Creating the user for the role:"+roleID);
		Response res=mdpUser.createUserMDPUser(true,authT, "", appId, "1",roleID , dynamicCredentials.get("tcMDPCreateSite").get(0), dynamicCredentials.get("tcMDPCreateAc").get(0), "test@gmail.com");
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The Post for Create Account admin passed with res:"+res.body().asString());
		mail=res.jsonPath().getString("email");
		String userId=res.jsonPath().getString("userId");
		exeData.add(res.asString());
		test.get().log(Status.DEBUG, "Creted the user for data :"+mail+"_"+appId);
		//mdpUser.validateSchema(res);
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "VISUHEALTH","href=\"","&language","html",false);
		System.out.println("The content of the mail is :"+y);
		WebDriver dri2=getDriver();
		dri2.get(y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(dri2);
		mv.verifyMail(y,mail,"Test123!");
		List<String>l=Arrays.asList(mail,"Test123!",userId);
		test.get().log(Status.INFO, "The Uploader Created With :"+userId+"|"+mail);
		dynamicCredentials.put("nurse", l);
		}

	
	

	 @DataProvider(name="tcMDPIsUserExistsUnderSSC")
	  public  JSONObject[][] datatcMDPIsUserExists() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcMDPIsUserExistsUnderSSC");
	  }
	@Test(dataProvider="tcMDPIsUserExistsUnderSSC",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateSSC"})
	public void tcMDPIsUserExistsSSC(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();


		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("sscadmin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String authT=getIdToken(null,mail, adminCreds.get(1),appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		String roleID=(String)credentialJson.get("AccountAdmin");
		test.get().log(Status.DEBUG, "Creating User for the role:"+roleID);
		System.out.println("Creating the user for the role:"+roleID);
		Response res=mdpUser.getIsUserExists(authT, dynamicCredentials.get("sscadmin").get(0));
		exeData.add(res.asString());
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The User Exists pased with res:"+res.asString());
		}
	
	@Test(dataProvider="tcMDPIsUserExistsUnderSSC",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateAcAdmin"})
	public void tcMDPIsUserExistsAcAdmin(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();


		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("acadmin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String authT=getIdToken(null,mail, adminCreds.get(1),appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		String roleID=(String)credentialJson.get("AccountAdmin");
		test.get().log(Status.DEBUG, "Creating User for the role:"+roleID);
		System.out.println("Creating the user for the role:"+roleID);
		Response res=mdpUser.getIsUserExists(authT, dynamicCredentials.get("acadmin").get(0));
		exeData.add(res.asString());
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The User Exists pased with res:"+res.asString());
		}
	
	@Test(dataProvider="MDPCreateAcAdmin",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateSSC"})
	public void tcMDPGetUserUnderMDPAdmin(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get("admin");
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		Response res=mdpUser.getUser(authT, dynamicCredentials.get("sscadmin").get(2));
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		test.get().log(Status.DEBUG, "The Post for Create Account admin passed with res:"+res.body().asString());

		}
	
	//Scripts for Get Users
	 @DataProvider(name="tcMDPGetUsersWithAuthtoken")
	  public  JSONObject[][] datatcMDPGetUsersWithAuthtoken() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcMDPGetUsersWithAuthtoken");
	  }
	@Test(dataProvider="tcMDPGetUsersWithAuthtoken",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateNurse"})
	public void tcMDPGetUsersWithAuthtoken(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		String user=(String)j.get("userType");
		System.out.println("Running the test for the data");
		List<String>adminCreds=dynamicCredentials.get(user);
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		Response res=mdpUser.getUsers(authT);
		System.out.println("The responses are ");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		List<String>userIds=res.jsonPath().get("id");
		
		switch(user)
		{
		case "admin":
			//Assert.assertEquals(userIds.contains(dynamicCredentials.get("admin")), true);
			Assert.assertEquals(userIds.contains(dynamicCredentials.get("sscadmin")), true);
			Assert.assertEquals(userIds.contains(dynamicCredentials.get("acadmin")), true);
			Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
			break;
		case "sscadmin":
			//Assert.assertEquals(userIds.contains(dynamicCredentials.get("sscadmin")), true);
			Assert.assertEquals(userIds.contains(dynamicCredentials.get("acadmin")), true);
			Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
			break;
		case "acadmin":
			//Assert.assertEquals(userIds.contains(dynamicCredentials.get("acadmin")), true);
			Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
			break;
		case "siteadmin":
			//Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
			break;
		
		}
		Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
		Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
		Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
		test.get().log(Status.DEBUG, "The Get Users As :"+user.toUpperCase()+"with response:"+res.body().asString());
		}
	
	
	 @DataProvider(name="tcMDPGetUsersWithAuthtokenAndOneHeirarchyType")
	  public  JSONObject[][] datatcMDPGetUsersWithAuthtokenAndOneHeirarchyType() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcMDPGetUsersWithAuthtokenAndOneHeirarchyType");
	  }
	@Test(dataProvider="tcMDPGetUsersWithAuthtokenAndOneHeirarchyType",groups= {"mdpt"},enabled=true,dependsOnMethods= {"tcMDPCreateNurse"})
	public void tcMDPGetUsersWithAuthtokenAndOneHeirarchyType(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		String user=(String)j.get("userType");
		String locType=(String)j.get("locationType");
		System.out.println("Running the test for the data");
		exeData.add("Running for the data : AppId="+appId+",userType="+user+",EntityType="+locType);
		List<String>adminCreds=dynamicCredentials.get(user);
		String mail=adminCreds.get(0);
		System.out.println(adminCreds.get(0)+"_"+appId);
		//Setup from the credentials file
		String  url=(String) credentialJson.get("url");
		System.out.println("The url is :"+url);
		//Generating the authtoken for the upload and edit case api calls
		String upwd=adminCreds.get(1);
		exeData.add(appId);
		String authT=getIdToken(null,mail,upwd ,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPUser mdpUser=new MDPUser();
		Response res=null;
		List<String>userIds=null;
		switch(user)
		{
		case "admin":
			switch(locType)
			{
				case "account":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateAc").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("acadmin")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
							break;
				case "site":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateSite").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
					break;
				case "roleName":
					JSONArray roles=(JSONArray)j.get("roleName");
					for(int i=0;i<roles.size();i++)
					{
						res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get(roles.get(i)).get(0),locType});
						System.out.println("The responses are ");
						Assert.assertEquals(res.getStatusCode(), 200);
						System.out.println(res.body().asString());
						userIds=res.jsonPath().get("id");
						Assert.assertEquals(userIds.contains(dynamicCredentials.get(roles.get(i))), true);
	
					}
					break;
			}
			break;
		case "sscadmin":
			switch(locType)
			{
				case "account":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateAc").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("acadmin")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
							break;
				case "site":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateSite").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
					break;
				case "roleName":
					JSONArray roles=(JSONArray)j.get("roleName");
					for(int i=0;i<roles.size();i++)
					{
						res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get(roles.get(i)).get(0),locType});
						System.out.println("The responses are ");
						Assert.assertEquals(res.getStatusCode(), 200);
						System.out.println(res.body().asString());
						userIds=res.jsonPath().get("id");
						Assert.assertEquals(userIds.contains(dynamicCredentials.get(roles.get(i))), true);
	
					}
					break;
			}
			break;
		case "acadmin":
			switch(locType)
			{
				case "account":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateAc").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
							break;
				case "site":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateSite").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("siteadmin")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
					break;
				case "roleName":
					JSONArray roles=(JSONArray)j.get("roleName");
					for(int i=0;i<roles.size();i++)
					{
						res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get(roles.get(i)).get(0),locType});
						System.out.println("The responses are ");
						Assert.assertEquals(res.getStatusCode(), 200);
						System.out.println(res.body().asString());
						userIds=res.jsonPath().get("id");
						Assert.assertEquals(userIds.contains(dynamicCredentials.get(roles.get(i))), true);
	
					}
					break;
			}
			break;
			
		case "siteadmin":
			switch(locType)
			{
				case "account":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateAc").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
							Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
							break;
				case "site":
					res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get("tcMDPCreateSite").get(0),locType});
					System.out.println("The responses are ");
					Assert.assertEquals(res.getStatusCode(), 200);
					System.out.println(res.body().asString());
					userIds=res.jsonPath().get("id");
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("uploader")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("reviewer")), true);
					Assert.assertEquals(userIds.contains(dynamicCredentials.get("nurse")), true);
					break;
				case "roleName":
					JSONArray roles=(JSONArray)j.get("roleName");
					for(int i=0;i<roles.size();i++)
					{
						res=mdpUser.getUsers(authT,new String [] {dynamicCredentials.get(roles.get(i)).get(0),locType});
						System.out.println("The responses are ");
						Assert.assertEquals(res.getStatusCode(), 200);
						System.out.println(res.body().asString());
						userIds=res.jsonPath().get("id");
						Assert.assertEquals(userIds.contains(dynamicCredentials.get(roles.get(i))), true);
	
					}
					break;
			}
			break;
		
		}
		
		test.get().log(Status.DEBUG, "The Test For Get User Using "+user+"...for the loc type="+locType);
	
	}
	
	
	
}


