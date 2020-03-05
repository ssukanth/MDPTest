package com.mdp.api.tests;

import java.io.IOException;
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
import com.mdp.api.services.AdminUserService_AdminUser;
import com.mdp.api.services.AdminUserService_Mdpapps;
import com.mdp.api.services.AdminUserService_Zeissid;
import com.mdp.visu.web.pages.Web_MailVerificationPage;
import com.selenium.utils.MailBox;

import io.restassured.response.Response;

public class AdminUserService_ZeissIdTests extends TestBase {
	String effMdpId;
	 @DataProvider(name="TC201_ZeissId_Test01_PostZeissId")
	 public  JSONObject[][] TC201_ZeissId_Test01_PostZeissId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test01_PostZeissId","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test01_PostZeissId",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
  public void tC201_ZeissId_Test01_PostZeissId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Response res=aZid.post_CreateZeissId(true,effMdpId, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		String effzId=res.jsonPath().getString(aZid.getCLIENTID());
		String entapiId=res.jsonPath().getString(aZid.getAPICLIENTID());
		List<String> l=Arrays.asList(effMdpId,effzId,entapiId);
		dynamicCredentials.put("tC201_ZeissId_Test01_PostZeissId",l);	
	}
	
	
	 @DataProvider(name="TC201_ZeissId_Test02_PostZeissIdWithSSCAdmin")
	 public  JSONObject[][] TC201_ZeissId_Test02_PostZeissIdWithSSCAdmin() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test02_PostZeissIdWithSSCAdmin","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test02_PostZeissIdWithSSCAdmin",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_AdminUserTests.tC201_AdminUser_Test04_CreateSSCAdminWithUserType1","com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
	  public void tC201_ZeissId_Test02_PostZeissIdWithSSCAdmin(JSONObject j) throws Exception {
			WebDriver dri=getDriver();
			List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
			String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
			AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
			String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
			exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
			test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
			Response res=aZid.post_CreateZeissId(true,effMdpId, atn,new HashMap<String,Object>());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

		}
	
	@DataProvider(name="TC201_ZeissId_Test03_PostZeissIdWithNonExistingAppId")
	 public  JSONObject[][] TC201_ZeissId_Test03_PostZeissIdWithNonExistingAppId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test03_PostZeissIdWithNonExistingAppId","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test03_PostZeissIdWithNonExistingAppId",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
 public void tC201_ZeissId_Test03_PostZeissIdWithNonExistingAppId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId="00"+dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0).substring(2);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Response res=aZid.post_CreateZeissId(true,effMdpId, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
			
	}
	
	@DataProvider(name="TC201_ZeissId_Test04_PostZeissIdWithInvalidGuidClientid")
	 public  JSONObject[][] TC201_ZeissId_Test04_PostZeissIdWithInvalidGuidClientid() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test04_PostZeissIdWithInvalidGuidClientid","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test04_PostZeissIdWithInvalidGuidClientid",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
public void tC201_ZeissId_Test04_PostZeissIdWithInvalidGuidClientid(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId="00"+dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0).substring(2);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		String effClientId="9ec53cca-baad-"+getYearString()+"-b"+getDayString()+"c-6ff3c"+getHourString()+"b"+getMinString();
		m.put("CLIENTID", effClientId);
		Response res=aZid.post_CreateZeissId(false,effMdpId, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
			
	}
	
	@DataProvider(name="TC201_ZeissId_Test05_PostZeissIdWithEmptyZeissId")
	 public  JSONObject[][] TC201_ZeissId_Test05_PostZeissIdWithEmptyZeissId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test05_PostZeissIdWithEmptyZeissId","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test05_PostZeissIdWithEmptyZeissId",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp"},enabled=true)
public void tC201_ZeissId_Test05_PostZeissIdWithEmptyZeissId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m=(Map)j.get("jsonobjects");	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Response res=aZid.post_CreateZeissId(true,effMdpId, atn,m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
			
	}
	
	
	/* ***************************End Of Post ZeissId****************************
	 **********************************************************************************
	 ******************************Start Of Get ZeissId**********************/
	
	
	
	@DataProvider(name="TC201_ZeissId_Test01_GetZeissId")
	 public  JSONObject[][] TC201_ZeissId_Test01_GetZeissId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test01_GetZeissId","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test01_GetZeissId",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test01_GetZeissId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		String effZid=dynamicCredentials.get("tC201_ZeissId_Test01_PostZeissId").get(1);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Response res=aZid.getZeissId(atn, effMdpId, effZid);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	@DataProvider(name="TC201_ZeissId_Test02_GetZeissIdWithSSCAuth")
	 public  JSONObject[][] TC201_ZeissId_Test02_GetZeissIdWithSSCAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test02_GetZeissIdWithSSCAuth","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test02_GetZeissIdWithSSCAuth",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_AdminUserTests.tC201_AdminUser_Test04_CreateSSCAdminWithUserType1","com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test02_GetZeissIdWithSSCAuth(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		String effZid=dynamicCredentials.get("tC201_ZeissId_Test01_PostZeissId").get(1);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Response res=aZid.getZeissId(atn, effMdpId, effZid);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	@DataProvider(name="TC201_ZeissId_Test03_GetZeissIdWithValidMDPidButInvalidZid")
	 public  JSONObject[][] TC201_ZeissId_Test03_GetZeissIdWithValidMDPidButInvalidZid() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test03_GetZeissIdWithValidMDPidButInvalidZid","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test03_GetZeissIdWithValidMDPidButInvalidZid",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test03_GetZeissIdWithValidMDPidButInvalidZid(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		String effZid="9ec53cca-baad-"+getYearString()+"-b"+getDayString()+"c-6ff3c"+getHourString()+"b"+getMinString()+getSecString();
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Response res=aZid.getZeissId(atn, effMdpId, effZid);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	@DataProvider(name="TC201_ZeissId_Test04_GetZeissIdWithValidZidButInvalidMDPId")
	 public  JSONObject[][] TC201_ZeissId_Test04_GetZeissIdWithValidZidButInvalidMDPId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test04_GetZeissIdWithValidZidButInvalidMDPId","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test04_GetZeissIdWithValidZidButInvalidMDPId",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test04_GetZeissIdWithValidZidButInvalidMDPId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		test.get().log(Status.DEBUG, "The Valid MDP String is :"+effMdpId);
		effMdpId=effMdpId.substring(0,effMdpId.length()-2)+getSecString();
		test.get().log(Status.DEBUG, "The InValid MDP String is :"+effMdpId);
		String effZid=dynamicCredentials.get("tC201_ZeissId_Test01_PostZeissId").get(1);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Response res=aZid.getZeissId(atn, effMdpId, effZid);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	/* ***************************End Of Get ZeissId****************************
	 **********************************************************************************
	 ******************************Start Of Put ZeissId**********************/
	
	
	
	@DataProvider(name="TC201_ZeissId_Test01_PutZeissId")
	 public  JSONObject[][] TC201_ZeissId_Test01_PutZeissId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test01_PutZeissId","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test01_PutZeissId",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test01_PutZeissId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		String effZid=dynamicCredentials.get("tC201_ZeissId_Test01_PostZeissId").get(1);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		m.put("CLIENTID", effZid);
		Response res=aZid.put_EditZeissId(atn, effMdpId, effZid, m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	@DataProvider(name="TC201_ZeissId_Test04_PutZeissIdWithValidZeissIdButInvalidMdpId")
	 public  JSONObject[][] TC201_ZeissId_Test04_PutZeissIdWithValidZeissIdButInvalidMdpId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test04_PutZeissIdWithValidZeissIdButInvalidMdpId","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test04_PutZeissIdWithValidZeissIdButInvalidMdpId",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test04_PutZeissIdWithValidZeissIdButInvalidMdpId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		test.get().log(Status.DEBUG, "The Valid MDP String is :"+effMdpId);
		effMdpId=effMdpId.substring(0,effMdpId.length()-2)+getSecString();
		test.get().log(Status.DEBUG, "The InValid MDP String is :"+effMdpId);
		String effZid=dynamicCredentials.get("tC201_ZeissId_Test01_PostZeissId").get(1);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		m.put("CLIENTID", effZid);
		Response res=aZid.put_EditZeissId(atn, effMdpId, effZid, m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	@DataProvider(name="TC201_ZeissId_Test05_PutZeissIdWithInvalidConfigKey")
	 public  JSONObject[][] TC201_ZeissId_Test05_PutZeissIdWithInvalidConfigKey() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test05_PutZeissIdWithInvalidConfigKey","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test05_PutZeissIdWithInvalidConfigKey",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test05_PutZeissIdWithInvalidConfigKey(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= (Map)j.get("jsonobjects")	;
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		String effZid=dynamicCredentials.get("tC201_ZeissId_Test01_PostZeissId").get(1);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		m.put("CLIENTID", effZid);
		Response res=aZid.put_EditZeissId(atn, effMdpId, effZid, m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	@DataProvider(name="TC201_ZeissId_Test06_PutZeissIdWithSSCAuth")
	 public  JSONObject[][] TC201_ZeissId_Test06_PutZeissIdWithSSCAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_ZeissId_Test06_PutZeissIdWithSSCAuth","zeissid");
	 }
	@Test(dataProvider="TC201_ZeissId_Test06_PutZeissIdWithSSCAuth",groups= {"zeissid"},dependsOnMethods= {"com.mdp.api.tests.AdminUserService_MdpAppsTests.tC201_MDPApps_Test01_PostMDPApp","tC201_ZeissId_Test01_PostZeissId"},enabled=true)
	public void tC201_ZeissId_Test06_PutZeissIdWithSSCAuth(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
		AdminUserService_Zeissid aZid=new AdminUserService_Zeissid();
		String effMdpId=dynamicCredentials.get("tC201_MDPApps_Test01_PostMDPApp").get(0);
		String effZid=dynamicCredentials.get("tC201_ZeissId_Test01_PostZeissId").get(1);
		exeData.add("The Effective MDPId for Zeissid Updte is :"+effMdpId);
		test.get().log(Status.DEBUG, "The Effective MDPId for Zeissid Updte is :"+effMdpId);
		Map<String,Object>m= new HashMap<String,Object>();	
		m.put("CLIENTID", effZid);
		Response res=aZid.put_EditZeissId(atn, effMdpId, effZid, m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
}
