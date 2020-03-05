package com.mdp.api.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mdp.api.services.MDPSites;
import com.selenium.utils.TestVars;

import io.restassured.response.Response;

public class MDPSiteTests extends TestBase {

 @DataProvider(name="tcMDPCreateSite")
 public  JSONObject[][] datatcMDPCreateSite() throws IOException, InvalidFormatException
 {	  
	  	return getTestData("tcMDPCreateSite");
 }
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"com.mdp.api.tests.MDPAccountTests.tcMDPCreateAc"},enabled=true)
  public void tcMDPCreateSite(JSONObject j) throws Exception
  {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.postCreateSite(true, authT, "", dynamicCredentials.get("tcMDPCreateAc").get(0),null);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		List l= Arrays.asList(res.jsonPath().get("id"),res.jsonPath().get("name"));
		dynamicCredentials.put("tcMDPCreateSite", l);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	  
  }
 //Test Cases for the get sites
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSitesMDPAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("admin").get(0);
		String adminPwd=dynamicCredentials.get("admin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAppId(authT);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);

 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSitesSSCAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAppId(authT);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSitesAcAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("acadmin").get(0);
		String adminPwd=dynamicCredentials.get("acadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAppId(authT);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"com.mdp.api.tests.MDPUserTests.tcMDPCreateSiteAdmin"},enabled=true)
 public void tcMDPGetSitesSitedmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("siteadmin").get(0);
		String adminPwd=dynamicCredentials.get("siteadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAppId(authT);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);		
 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSitesMDPAccountIdAndMDPAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("admin").get(0);
		String adminPwd=dynamicCredentials.get("admin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAccId(authT,dynamicCredentials.get("tcMDPCreateAc").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSitesMDPAccountIdAndMDPSSCAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAccId(authT,dynamicCredentials.get("tcMDPCreateAc").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSitesMDPAccountIdAndMDPACAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("acadmin").get(0);
		String adminPwd=dynamicCredentials.get("acadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAccId(authT,dynamicCredentials.get("tcMDPCreateAc").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"com.mdp.api.tests.MDPUserTests.tcMDPCreateSiteAdmin"},enabled=true)
 public void tcMDPGetSitesMDPAccountIdAndSiteAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("siteadmin").get(0);
		String adminPwd=dynamicCredentials.get("siteadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSitesByAccId(authT,dynamicCredentials.get("tcMDPCreateAc").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 
 
 
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSiteMDPSiteIdAndMDPAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("admin").get(0);
		String adminPwd=dynamicCredentials.get("admin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSiteBySiteId(authT, dynamicCredentials.get("tcMDPCreateSite").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		//validation needs to added
		
 }
 
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSiteMDPSiteIdAndSSCAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSiteBySiteId(authT, dynamicCredentials.get("tcMDPCreateSite").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"tcMDPCreateSite"},enabled=true)
 public void tcMDPGetSiteWithSiteIdAndMDPACAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("acadmin").get(0);
		String adminPwd=dynamicCredentials.get("acadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSiteBySiteId(authT, dynamicCredentials.get("tcMDPCreateSite").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 //We need to script this one after the site admin has been created
 @Test(dataProvider="tcMDPCreateSite",groups= {"mdpt"},dependsOnMethods={"com.mdp.api.tests.MDPUserTests.tcMDPCreateSiteAdmin"},enabled=true)
 public void tcMDPGetSiteWithSiteIdAndMDPSiteAdmin(JSONObject j) throws Exception
 {
	  	TestVars gt= getTestVars();
	  	String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("siteadmin").get(0);
		String adminPwd=dynamicCredentials.get("siteadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+adminUser+"_"+appId);
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPSites mdpSite=new MDPSites();
		Response res=mdpSite.getSiteBySiteId(authT, dynamicCredentials.get("tcMDPCreateSite").get(0));
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().getString("id").contains(dynamicCredentials.get("tcMDPCreateSite").get(0)), true);
		Assert.assertEquals(res.jsonPath().getString("name").contains(dynamicCredentials.get("tcMDPCreateSite").get(1)), true);
		
 }
 
 

 
 
}
