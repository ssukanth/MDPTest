package com.mdp.api.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mdp.api.services.AdminUserService_Mdpapps;
import com.mongodb.assertions.Assertions;

import io.restassured.response.Response;

public class AdminUserService_MdpAppsTests extends TestBase {
	 @DataProvider(name="TC201_MDPApps_Test01_PostMDPApp")
	 public  JSONObject[][] TC201_MDPApps_Test01_PostMDPApp() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test01_PostMDPApp","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test01_PostMDPApp",groups= {"mdpapps"},enabled=true)
  public void tC201_MDPApps_Test01_PostMDPApp(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		Response res=mdpapp.post_CreateMDPApp(true,true, atn,new HashMap<String ,Object>());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		String effMdpId=res.jsonPath().getString(mdpapp.getRESMDPID());
		String effName=res.jsonPath().getString(mdpapp.getRESNAME());
		String effZid=res.jsonPath().getString(mdpapp.getRESZIESSID());
		List<String> l=Arrays.asList(effMdpId,effName,effZid);
		dynamicCredentials.put("tC201_MDPApps_Test01_PostMDPApp", l);
	}
	
	 @DataProvider(name="TC201_MDPApps_Test02_PostMDPAppWithSSCAdminAuth")
	 public  JSONObject[][] TC201_MDPApps_Test02_PostMDPAppWithSSCAdminAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test02_PostMDPAppWithSSCAdminAuth","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test02_PostMDPAppWithSSCAdminAuth",groups= {"mdpapps"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_AdminUserTests.tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
	  public void tC201_MDPApps_Test02_PostMDPAppWithSSCAdminAuth(JSONObject j) throws Exception {
			WebDriver dri=getDriver();
			List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
			String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
			AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
			Response res=mdpapp.post_CreateMDPApp(true,true, atn,new HashMap<String ,Object>());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

		}
	
	@DataProvider(name="TC201_MDPApps_Test03_PostMDPAppWithExistingZeissIdConfig")
	 public  JSONObject[][] TC201_MDPApps_Test03_PostMDPAppWithExistingZeissIdConfig() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test03_PostMDPAppWithExistingZeissIdConfig","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test03_PostMDPAppWithExistingZeissIdConfig",groups= {"mdpapps"},enabled=true)
 public void tC201_MDPApps_Test03_PostMDPAppWithExistingZeissIdConfig(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		Map<String,Object>jm=(Map)j.get("jsonobjects");
		Response res=mdpapp.post_CreateMDPApp(true,false, atn,jm);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		}
	
	@DataProvider(name="TC201_MDPApps_Test04_PostMDPAppWithExistingAppName")
	 public  JSONObject[][] TC201_MDPApps_Test04_PostMDPAppWithExistingAppName() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test04_PostMDPAppWithExistingAppName","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test04_PostMDPAppWithExistingAppName",groups= {"mdpapps"},dependsOnMethods= {"tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
 public void tC201_MDPApps_Test04_PostMDPAppWithExistingAppName(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		String nam=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(1);
		exeData.add("The Duplicte Name Used Is :"+nam);
		test.get().log(Status.DEBUG, "The Duplicte Name Used Is :"+nam);
		m.put("NAME", nam);
		Response res=mdpapp.post_CreateMDPApp(false,true, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		
	}
	
	@DataProvider(name="TC201_MDPApps_Test05_PostMDPAppWithoutZeissIdConfiguration")
	 public  JSONObject[][] TC201_MDPApps_Test05_PostMDPAppWithoutZeissIdConfiguration() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test05_PostMDPAppWithoutZeissIdConfiguration","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test05_PostMDPAppWithoutZeissIdConfiguration",groups= {"mdpapps"},enabled=true)
public void tC201_MDPApps_Test05_PostMDPAppWithoutZeissIdConfiguration(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		Map<String,Object>jm=(Map)j.get("jsonobjects");
		Response res=mdpapp.post_CreateMDPApp(true,true, atn,jm);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		}
	
	@DataProvider(name="TC201_MDPApps_Test06_PostMDPAppWithConfigurationAsString")
	 public  JSONObject[][] TC201_MDPApps_Test06_PostMDPAppWithConfigurationAsString() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test06_PostMDPAppWithConfigurationAsString","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test06_PostMDPAppWithConfigurationAsString",groups= {"mdpapps"},enabled=true)
 public void tC201_MDPApps_Test06_PostMDPAppWithConfigurationAsString(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		m.put("CONFIGURATION", "config"+getDateString());
		Response res=mdpapp.post_CreateMDPApp(true,true, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		
	}
	
	
	@DataProvider(name="TC201_MDPApps_Test07_PostMDPAppWithNameAsNull")
	 public  JSONObject[][] TC201_MDPApps_Test07_PostMDPAppWithNameAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test07_PostMDPAppWithNameAsNull","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test07_PostMDPAppWithNameAsNull",groups= {"mdpapps"},enabled=true)
public void tC201_MDPApps_Test07_PostMDPAppWithNameAsNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		m.put("NAME", null);
		Response res=mdpapp.post_CreateMDPApp(false,true, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		
	}
	
	@DataProvider(name="TC201_MDPApps_Test08_PostMDPAppWithZeissIdAsJsonObject")
	 public  JSONObject[][] TC201_MDPApps_Test08_PostMDPAppWithZeissIdAsJsonObject() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test08_PostMDPAppWithZeissIdAsJsonObject","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test08_PostMDPAppWithZeissIdAsJsonObject",groups= {"mdpapps"},enabled=true)
public void tC201_MDPApps_Test08_PostMDPAppWithZeissIdAsJsonObject(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= (Map)j.get("jsonobjects");		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		Response res=mdpapp.post_CreateMDPApp(true,true, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		
	}
	
	/* ***************************End Of Post MDPApps****************************
	 **********************************************************************************
	 ******************************Start Of Get All  MDPApps**********************/
	@DataProvider(name="TC201_AdminUser_Test01_GetAllMDPApps")
	 public  JSONObject[][] TC201_AdminUser_Test01_GetAllMDPApps() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test01_GetAllMDPApps","mdpapps");
	 }
	@Test(dataProvider="TC201_AdminUser_Test01_GetAllMDPApps",groups= {"mdpapps"},enabled=true)
	public void tC201_AdminUser_Test01_GetAllMDPApps(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		Response res=mdpapp.get_AllApps(atn, null);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		
	}
	
	@DataProvider(name="TC201_AdminUser_Test02_GetAllMDPAppsWithZeissIdFilter")
	 public  JSONObject[][] TC201_AdminUser_Test02_GetAllMDPAppsWithZeissIdFilter() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test02_GetAllMDPAppsWithZeissIdFilter","mdpapps");
	 }
	@Test(dataProvider="TC201_AdminUser_Test02_GetAllMDPAppsWithZeissIdFilter",groups= {"mdpapps"},dependsOnMethods= {"tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	public void tC201_AdminUser_Test02_GetAllMDPAppsWithZeissIdFilter(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		String effZid=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(2);
		String effname=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(1);
		exeData.add("The ZeissId We Are Seraching for Is:"+effZid);
		test.get().log(Status.DEBUG, "The ZeissId We Are Seraching for Is:"+effZid);
		Response res=mdpapp.get_AllApps(atn, effZid);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		String act=(res.jsonPath().getString(mdpapp.getRESGETMDPAPP_NAME()).replace("[[", "")).replace("]]", "");
		String exp=effname.replace("[", "");
		Assert.assertEquals(act, "["+exp+"]");
	}
	
	
	@DataProvider(name="TC201_MDPApps_Test03_GetAllMDPAppWithSSCAdminAuth")
	 public  JSONObject[][] TC201_MDPApps_Test03_GetAllMDPAppWithSSCAdminAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test03_GetAllMDPAppWithSSCAdminAuth","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test03_GetAllMDPAppWithSSCAdminAuth",groups= {"mdpapps"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_AdminUserTests.tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
	  public void tC201_MDPApps_Test03_GetAllMDPAppWithSSCAdminAuth(JSONObject j) throws Exception {
			WebDriver dri=getDriver();
			List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
			String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
			AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
			Response res=mdpapp.get_AllApps(atn, null);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

		}
	
	
	@DataProvider(name="TC201_AdminUser_Test04_GetAllMDPAppsWithNonExistingZeissId")
	 public  JSONObject[][] TC201_AdminUser_Test04_GetAllMDPAppsWithNonExistingZeissId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test04_GetAllMDPAppsWithNonExistingZeissId","mdpapps");
	 }
	@Test(dataProvider="TC201_AdminUser_Test04_GetAllMDPAppsWithNonExistingZeissId",groups= {"mdpapps"},dependsOnMethods= {"tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	public void tC201_AdminUser_Test04_GetAllMDPAppsWithNonExistingZeissId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		String effZid=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(2);
		String invzid=effZid.substring(0, effZid.length()-4)+getDayString()+getMinString();
		exeData.add("The Invalid ZeissId We Are Seraching for Is:"+invzid);
		test.get().log(Status.DEBUG, "The Invalid ZeissId We Are Seraching for Is:"+invzid);
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		Response res=mdpapp.get_AllApps(atn,invzid );
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		ArrayList a=res.jsonPath().get(mdpapp.getRESMDPID());
		if(a.size()>0)throw new Exception("Getting response for nonexistant zeissId");
		
	}
	
	
	/* ***************************End Of Get All MDPApps****************************
	 **********************************************************************************
	 ******************************Start Of Get MDPApp**********************/
	
	
	
	
	@DataProvider(name="TC201_AdminUser_Test01_GetMDPApp")
	 public  JSONObject[][] TC201_AdminUser_Test01_GetMDPApp() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test01_GetMDPApp","mdpapps");
	 }
	@Test(dataProvider="TC201_AdminUser_Test01_GetMDPApp",groups= {"mdpapps"},dependsOnMethods= {"tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	public void tC201_AdminUser_Test01_GetMDPApp(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		String effname=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(1);
		exeData.add("The MDPId We Are Seraching for Is:"+effMdpId);
		test.get().log(Status.DEBUG, "The MDPId We Are Seraching for Is:"+effMdpId);
		Response res=mdpapp.getApp(atn, effMdpId);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		Assert.assertEquals(res.jsonPath().getString(mdpapp.getNAME()), effname);
	}
	
	
	
	@DataProvider(name="TC201_MDPApps_Test02_GetMDPAppWithSSCAdminAuth")
	 public  JSONObject[][] TC201_MDPApps_Test02_GetMDPAppWithSSCAdminAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test02_GetMDPAppWithSSCAdminAuth","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test02_GetMDPAppWithSSCAdminAuth",groups= {"mdpapps"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_AdminUserTests.tC201_AdminUser_Test04_CreateSSCAdminWithUserType1","tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	  public void tC201_MDPApps_Test02_GetMDPAppWithSSCAdminAuth(JSONObject j) throws Exception {
			WebDriver dri=getDriver();
			List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
			String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
			AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
			String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
			Response res=mdpapp.getApp(atn, effMdpId);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

		}
	
	
	
	/* ***************************End Of Get  MDPApp****************************
	 **********************************************************************************
	 ******************************Start Of Put MDPApp**********************/
	
	@DataProvider(name="TC201_MDPApps_Test01_PutMDPAppWithConfigurationAsEditedValue")
	 public  JSONObject[][] TC201_MDPApps_Test01_PutMDPAppWithConfigurationAsEditedValue() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test01_PutMDPAppWithConfigurationAsEditedValue","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test01_PutMDPAppWithConfigurationAsEditedValue",groups= {"mdpapps"},dependsOnMethods= {"tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	  public void tC201_MDPApps_Test01_PutMDPAppWithConfigurationAsEditedValue(JSONObject j) throws Exception {
			WebDriver dri=getDriver();
			Map<String,Object>m=(Map)j.get("jsonobjects");
			String authUser=(String) j.get("authuser");
			String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
			AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
			String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
			Response res=mdpapp.put_EditMDPApp(atn, effMdpId, m);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

		}
	
	@DataProvider(name="TC201_MDPApps_Test02_PutMDPAppForNonExistingMDPApp")
	 public  JSONObject[][] TC201_MDPApps_Test02_PutMDPAppForNonExistingMDPApp() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test02_PutMDPAppForNonExistingMDPApp","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test02_PutMDPAppForNonExistingMDPApp",groups= {"mdpapps"},dependsOnMethods= {"tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	  public void tC201_MDPApps_Test02_PutMDPAppForNonExistingMDPApp(JSONObject j) throws Exception {
			WebDriver dri=getDriver();
			Map<String,Object>m=(Map)j.get("jsonobjects");
			String authUser=(String) j.get("authuser");
			String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
			AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
			String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
			Response res=mdpapp.put_EditMDPApp(atn, getHourString()+getMinString()+effMdpId.substring(4), new HashMap<String,Object>());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

		}
	
	@DataProvider(name="TC201_MDPApps_Test03_PutMDPAppWithConfigurationAsEmpty")
	 public  JSONObject[][] TC201_MDPApps_Test03_PutMDPAppWithConfigurationAsEmpty() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_MDPApps_Test03_PutMDPAppWithConfigurationAsEmpty","mdpapps");
	 }
	@Test(dataProvider="TC201_MDPApps_Test03_PutMDPAppWithConfigurationAsEmpty",groups= {"mdpapps"},dependsOnMethods= {"tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	  public void tC201_MDPApps_Test03_PutMDPAppWithConfigurationAsEmpty(JSONObject j) throws Exception {
			WebDriver dri=getDriver();
			Map<String,Object>m=(Map)j.get("jsonobjects");
			String authUser=(String) j.get("authuser");
			String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
			AdminUserService_Mdpapps mdpapp=new AdminUserService_Mdpapps();
			String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
			Response res=mdpapp.put_EditMDPApp(atn, effMdpId, m);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

		}

	
}
