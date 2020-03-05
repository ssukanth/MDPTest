package com.mdp.api.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mdp.api.services.AdminUserService_AdminUser;
import com.mdp.visu.web.pages.Web_MailVerificationPage;
import com.selenium.utils.MailBox;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import java.util.*;  
public class AdminUserService_AdminUserTests extends TestBase {
 
	 @DataProvider(name="TC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1")
	 public  JSONObject[][] TC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1",groups= {"adminuserservice"},enabled=true)
  public void tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1(JSONObject j) throws Exception {
		MailBox.markAllMailsRead("zeiss0719@gmail.com","zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String entId=res.jsonPath().getString("id");
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "MED CONVIVO","href=\"","&language","html",false);
		System.out.println("The link for Activtion is :"+y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(null);
		mv.verifyMail(y,effMail,"Test123!");
		List<String> l=Arrays.asList(effMail,"Test123!",entId);
		dynamicCredentials.put("tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1", l);
		
	}
	
	 @DataProvider(name="TC201_AdminUser_Test02_CreateAppAdminSibblingWithUserType2")
	 public  JSONObject[][] TC201_AdminUser_Test02_CreateAppAdminSibblingWithUserType2() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test02_CreateAppAdminSibblingWithUserType2","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test02_CreateAppAdminSibblingWithUserType2",groups= {"adminuserservice"},enabled=false)//Obselete
  public void tC201_AdminUser_Test02_CreateAppAdminSibblingWithUserType2(JSONObject j) throws Exception {
		new MailBox().markAllMailsRead("zeiss0719@gmail.com", "zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		System.out.println("The Response Code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "MED CONVIVO","href=\"","&language","html",false);
		Assert.assertEquals(y,"");
		System.out.println("The link for Activtion is :"+y);
	}
	
	 @DataProvider(name="TC201_AdminUser_Test03_CreateAppAdminSibblingWithUserType3")
	 public  JSONObject[][] TC201_AdminUser_Test03_CreateAppAdminSibblingWithUserType3() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test03_CreateAppAdminSibblingWithUserType3","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test03_CreateAppAdminSibblingWithUserType3",groups= {"adminuserservice"},enabled=false) //Obselete
  public void tC201_AdminUser_Test03_CreateAppAdminSibblingWithUserType3(JSONObject j) throws Exception {
		new MailBox().markAllMailsRead("zeiss0719@gmail.com", "zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.jsonPath().getString("id"), null);
	}
	
	
	 @DataProvider(name="TC201_AdminUser_Test04_CreateSSCAdminWithUserType1")
	 public  JSONObject[][] TC201_AdminUser_Test04_CreateSSCAdminWithUserType1() throws IOException, InvalidFormatException
	 {	  
		 System.out.println("Testing ");
	  	return getTestData("TC201_AdminUser_Test04_CreateSSCAdminWithUserType1","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test04_CreateSSCAdminWithUserType1",groups= {"adminuserservice","adminuserput"},enabled=true)
  public void tC201_AdminUser_Test04_CreateSSCAdminWithUserType1(JSONObject j) throws Exception {
		MailBox.markAllMailsRead("zeiss0719@gmail.com", "zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String entId=res.jsonPath().getString("id");
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "MED CONVIVO","href=\"","&language","html",false);
		System.out.println("The link for Activtion is :"+y);
		Web_MailVerificationPage mv=new Web_MailVerificationPage(null);
		mv.verifyMail(y,effMail,"Test123!");
		List<String> l=Arrays.asList(effMail,"Test123!",entId);
		dynamicCredentials.put("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1", l);
		
	}
	
	 @DataProvider(name="TC201_AdminUser_Test05_CreateSSCAdminWithUserType2")
	 public  JSONObject[][] TC201_AdminUser_Test05_CreateSSCAdminWithUserType2() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test05_CreateSSCAdminWithUserType2","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test05_CreateSSCAdminWithUserType2",groups= {"adminuserservice"},enabled=false)//obselete
  public void tC201_AdminUser_Test05_CreateSSCAdminWithUserType2(JSONObject j) throws Exception {
		new MailBox().markAllMailsRead("zeiss0719@gmail.com", "zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		String y=MailBox.getContent("gmail","zeiss0719@gmail.com", "zeiss2017","MDP", "MED CONVIVO","href=\"","&language","html",false);
		System.out.println("The Response Code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		Assert.assertEquals(y,"");
		System.out.println("The link for Activtion is :"+y);
	}
	
	 @DataProvider(name="TC201_AdminUser_Test06_CreateSSCAdminWithUserType3")
	 public  JSONObject[][] TC201_AdminUser_Test06_CreateSSCAdminWithUserType3() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test06_CreateSSCAdminWithUserType3","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test06_CreateSSCAdminWithUserType3",groups= {"adminuserservice"},enabled=false) //Obselete
  public void tC201_AdminUser_Test06_CreateSSCAdminWithUserType3(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		//Assert.assertEquals(res.jsonPath().getString("id"), null); As the app should allow user type 3 creation also -Sai
	}
	
	

	/* Commented as these are invalid scenarios
	 *  @DataProvider(name="TC201_AdminUser_Test07_CreateAccountAdminWithMDPAdmin")
	 
	 public  JSONObject[][] TC201_AdminUser_Test07_CreateAccountAdminWithMDPAdmin() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test07_CreateAccountAdminWithMDPAdmin");
	 }
	@Test(dataProvider="TC201_AdminUser_Test07_CreateAccountAdminWithMDPAdmin",groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test07_CreateAccountAdminWithMDPAdmin(JSONObject j) throws Exception {
		MailBox.markAllMailsRead("zeiss0719@gmail.com", "zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
	}
	
	 @DataProvider(name="TC201_AdminUser_Test08_CreateSiteAdminWithMDPAdmin")
	 public  JSONObject[][] TC201_AdminUser_Test08_CreateSiteAdminWithMDPAdmin() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test08_CreateSiteAdminWithMDPAdmin");
	 }
	@Test(dataProvider="TC201_AdminUser_Test08_CreateSiteAdminWithMDPAdmin",groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test08_CreateSiteAdminWithMDPAdmin(JSONObject j) throws Exception {
		new MailBox().markAllMailsRead("zeiss0719@gmail.com", "zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
	}*/
	
	 @DataProvider(name="TC201_AdminUser_Test09_CreateSSCAdminWithSSCAdmin")
	 public  JSONObject[][] TC201_AdminUser_Test09_CreateSSCAdminWithSSCAdmin() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test09_CreateSSCAdminWithSSCAdmin","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test09_CreateSSCAdminWithSSCAdmin",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test09_CreateSSCAdminWithSSCAdmin(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		Map<String,Object>m= new HashMap<String,Object>();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)credentialJson.get("dakarclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
	}
	
	
	 @DataProvider(name="TC201_AdminUser_Test10_CreateAccountAdminWithSSCAdmin")
	 public  JSONObject[][] TC201_AdminUser_Test10_CreateAccountAdminWithSSCAdmin() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test10_CreateAccountAdminWithSSCAdmin","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test10_CreateAccountAdminWithSSCAdmin",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test10_CreateAccountAdminWithSSCAdmin(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		Map<String,Object>m= new HashMap<String,Object>();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)credentialJson.get("dakarclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
	}
	
	 @DataProvider(name="TC201_AdminUser_Test11_CreateSiteAdminWithSSCAdmin")
	 public  JSONObject[][] TC201_AdminUser_Test11_CreateSiteAdminWithSSCAdmin() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test11_CreateSiteAdminWithSSCAdmin","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test11_CreateSiteAdminWithSSCAdmin",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test11_CreateSiteAdminWithSSCAdmin(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)credentialJson.get("dakarclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
	}
	
	 @DataProvider(name="TC201_AdminUser_Test12_CreateAppAdminWithExistingMDPAdminMail")
	 public  JSONObject[][] TC201_AdminUser_Test12_CreateAppAdminWithExistingMDPAdminMail() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test12_CreateAppAdminWithExistingMDPAdminMail","adminuserservice");
	 }
	//@Test(dataProvider="TC201_AdminUser_Test12_CreateAppAdminWithExistingMDPAdminMail",dependsOnMethods= {"tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1"},groups= {"adminuserservice"},enabled=true)
		@Test(dataProvider="TC201_AdminUser_Test12_CreateAppAdminWithExistingMDPAdminMail",groups= {"adminuserservice"},enabled=true)
	 public void tC201_AdminUser_Test12_CreateAppAdminWithExistingMDPAdminMail(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		//m2.put("EMAIL", dynamicCredentials.get("TC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1").get(0));
		m2.put("EMAIL", "MDPAdmin@id.zeiss.com");
		Response res=aUser.post_CreateUserMDPUser(false,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test13_CreateAppAdminWithExistingSSCAdminMail")
	 public  JSONObject[][] TC201_AdminUser_Test13_CreateAppAdminWithExistingSSCAdminMail() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test13_CreateAppAdminWithExistingSSCAdminMail","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test13_CreateAppAdminWithExistingSSCAdminMail",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test13_CreateAppAdminWithExistingSSCAdminMail(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		m2.put("EMAIL", dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1").get(0));
		Response res=aUser.post_CreateUserMDPUser(false,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test14_CreateSSCAdminWithExistingMDPAdminMail")
	 public  JSONObject[][] TC201_AdminUser_Test14_CreateSSCAdminWithExistingMDPAdminMail() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test14_CreateSSCAdminWithExistingMDPAdminMail","adminuserservice");
	 }
	//@Test(dataProvider="TC201_AdminUser_Test14_CreateSSCAdminWithExistingMDPAdminMail",dependsOnMethods= {"tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1"},groups= {"adminuserservice"},enabled=true)
		@Test(dataProvider="TC201_AdminUser_Test14_CreateSSCAdminWithExistingMDPAdminMail",dependsOnMethods= {"tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1"},groups= {"adminuserservice"},enabled=true)

	 public void tC201_AdminUser_Test14_CreateSSCAdminWithExistingMDPAdminMail(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		m2.put("EMAIL", dynamicCredentials.get("tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1").get(0));
		//m2.put("EMAIL","MDPAdmin@id.zeiss.com");
		Response res=aUser.post_CreateUserMDPUser(false,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test15_CreateSSCAdminWithExistingSSCAdminMail")
	 public  JSONObject[][] TC201_AdminUser_Test15_CreateSSCAdminWithExistingSSCAdminMail() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test15_CreateSSCAdminWithExistingSSCAdminMail","adminuserservice");
	 }
	//@Test(dataProvider="TC201_AdminUser_Test15_CreateSSCAdminWithExistingSSCAdminMail",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
		@Test(dataProvider="TC201_AdminUser_Test15_CreateSSCAdminWithExistingSSCAdminMail",groups= {"adminuserservice"},enabled=true)

	public void tC201_AdminUser_Test15_CreateSSCAdminWithExistingSSCAdminMail(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
	//m2.put("EMAIL", dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1").get(0));
		m2.put("EMAIL","MDPAdmin@id.zeiss.com");
		Response res=aUser.post_CreateUserMDPUser(false,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	
	 @DataProvider(name="TC201_AdminUser_Test16_CreateMDPAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2")
	 public  JSONObject[][] TC201_AdminUser_Test16_CreateMDPAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test16_CreateMDPAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test16_CreateMDPAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=false)//Obselete
 public void tC201_AdminUser_Test16_CreateMDPAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");	
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test17_CreateSSCAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2")
	 public  JSONObject[][] TC201_AdminUser_Test17_CreateSSCAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test17_CreateSSCAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2");
	 }
	@Test(dataProvider="TC201_AdminUser_Test17_CreateSSCAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=false) //Obselete
 public void tC201_AdminUser_Test17_CreateSSCAdminWithEmailAsUniqueAndNoAlternateEmailForUserType2(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test18_CreateMDPAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2")
	 public  JSONObject[][] TC201_AdminUser_Test18_CreateMDPAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test18_CreateMDPAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2");
	 }
	@Test(dataProvider="TC201_AdminUser_Test18_CreateMDPAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=false) //Obselte
 public void tC201_AdminUser_Test18_CreateMDPAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test19_CreateSSCAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2")
	 public  JSONObject[][] TC201_AdminUser_Test19_CreateSSCAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test19_CreateSSCAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2");
	 }
	@Test(dataProvider="TC201_AdminUser_Test19_CreateSSCAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=false)//Obselte
 public void tC201_AdminUser_Test19_CreateSSCAdminWithEmailAsUniqueAndExistingAlternateEmailForUserType2(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test20_CreateMDPAdminWithClientIdNull")
	 public  JSONObject[][] TC201_AdminUser_Test20_CreateMDPAdminWithClientIdNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test20_CreateMDPAdminWithClientIdNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test20_CreateMDPAdminWithClientIdNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test20_CreateMDPAdminWithClientIdNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test21_CreateMDPAdminWithRoleIdNull")
	 public  JSONObject[][] TC201_AdminUser_Test21_CreateMDPAdminWithRoleIdNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test21_CreateMDPAdminWithRoleIdNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test21_CreateMDPAdminWithRoleIdNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test21_CreateMDPAdminWithRoleIdNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test22_CreateMDPAdminWithUserTypeNull")
	 public  JSONObject[][] TC201_AdminUser_Test22_CreateMDPAdminWithUserTypeNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test22_CreateMDPAdminWithUserTypeNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test22_CreateMDPAdminWithUserTypeNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test22_CreateMDPAdminWithUserTypeNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test23_CreateMDPAdminWithClientIdRandom")
	 public  JSONObject[][] TC201_AdminUser_Test23_CreateMDPAdminWithClientIdRandom() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test23_CreateMDPAdminWithClientIdRandom","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test23_CreateMDPAdminWithClientIdRandom",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test23_CreateMDPAdminWithClientIdRandom(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test24_CreateMDPAdminWithRoleIdRandom")
	 public  JSONObject[][] TC201_AdminUser_Test24_CreateMDPAdminWithRoleIdRandom() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test24_CreateMDPAdminWithRoleIdRandom","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test24_CreateMDPAdminWithRoleIdRandom",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test24_CreateMDPAdminWithRoleIdRandom(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test25_CreateMDPAdminWithUserTypeRandom")
	 public  JSONObject[][] TC201_AdminUser_Test25_CreateMDPAdminWithUserTypeRandom() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test25_CreateMDPAdminWithUserTypeRandom","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test25_CreateMDPAdminWithUserTypeRandom",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test25_CreateMDPAdminWithUserTypeRandom(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test26_CreateMDPAdminWithMDPAppIdNull")
	 public  JSONObject[][] TC201_AdminUser_Test26_CreateMDPAdminWithMDPAppIdNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test26_CreateMDPAdminWithMDPAppIdNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test26_CreateMDPAdminWithMDPAppIdNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test26_CreateMDPAdminWithMDPAppIdNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test27_CreateMDPAdminWithMDPAppIdInvalid")
	 public  JSONObject[][] TC201_AdminUser_Test27_CreateMDPAdminWithMDPAppIdInvalid() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test27_CreateMDPAdminWithMDPAppIdInvalid","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test27_CreateMDPAdminWithMDPAppIdInvalid",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
	public void TC201_AdminUser_Test27_CreateMDPAdminWithMDPAppIdInvalid(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test28_CreateMDPAdminWithInvalidemailId")
	 public  JSONObject[][] TC201_AdminUser_Test28_CreateMDPAdminWithInvalidemailId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test28_CreateMDPAdminWithInvalidemailId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test28_CreateMDPAdminWithInvalidemailId",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
	public void TC201_AdminUser_Test28_CreateMDPAdminWithInvalidemailId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(false,true, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test29_CreateMDPAdminWithoutContactDetails")
	 public  JSONObject[][] TC201_AdminUser_Test29_CreateMDPAdminWithoutContactDetails() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test29_CreateMDPAdminWithoutContactDetails","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test29_CreateMDPAdminWithoutContactDetails",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
	public void TC201_AdminUser_Test29_CreateMDPAdminWithoutContactDetails(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(false,true, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	 @DataProvider(name="TC201_AdminUser_Test30_CreateSSCAdminWithoutClientIdAsNull")
	 public  JSONObject[][] TC201_AdminUser_Test30_CreateSSCAdminWithoutClientIdAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test30_CreateSSCAdminWithoutClientIdAsNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test30_CreateSSCAdminWithoutClientIdAsNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test30_CreateSSCAdminWithoutClientIdAsNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test31_CreateSSCAdminWithRoleidNull")
	 public  JSONObject[][] TC201_AdminUser_Test31_CreateSSCAdminWithRoleidNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test31_CreateSSCAdminWithRoleidNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test31_CreateSSCAdminWithRoleidNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test31_CreateSSCAdminWithRoleidNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test32_CreateSSCAdminWithUserTypeNull")
	 public  JSONObject[][] TC201_AdminUser_Test32_CreateSSCAdminWithUserTypeNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test32_CreateSSCAdminWithUserTypeNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test32_CreateSSCAdminWithUserTypeNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test32_CreateSSCAdminWithUserTypeNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test33_CreateSSCAdminWithCleintIdRandom")
	 public  JSONObject[][] TC201_AdminUser_Test33_CreateSSCAdminWithCleintIdRandom() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test33_CreateSSCAdminWithCleintIdRandom","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test33_CreateSSCAdminWithCleintIdRandom",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test33_CreateSSCAdminWithCleintIdRandom(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test34_CreateSSCAdminWithRoleIdRandom")
	 public  JSONObject[][] TC201_AdminUser_Test34_CreateSSCAdminWithRoleIdRandom() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test34_CreateSSCAdminWithRoleIdRandom","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test34_CreateSSCAdminWithRoleIdRandom",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test34_CreateSSCAdminWithRoleIdRandom(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test35_CreateSSCAdminWithUsertypeRandom")
	 public  JSONObject[][] TC201_AdminUser_Test35_CreateSSCAdminWithUsertypeRandom() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test35_CreateSSCAdminWithUsertypeRandom","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test35_CreateSSCAdminWithUsertypeRandom",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test35_CreateSSCAdminWithUsertypeRandom(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test36_CreateSSCAdminWithMDPAppIdNull")
	 public  JSONObject[][] TC201_AdminUser_Test36_CreateSSCAdminWithMDPAppIdNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test36_CreateSSCAdminWithMDPAppIdNull","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test36_CreateSSCAdminWithMDPAppIdNull",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test36_CreateSSCAdminWithMDPAppIdNull(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test37_CreateSSCAdminWithMDPAppIdInvalid")
	 public  JSONObject[][] TC201_AdminUser_Test37_CreateSSCAdminWithMDPAppIdInvalid() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test37_CreateSSCAdminWithMDPAppIdInvalid","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test37_CreateSSCAdminWithMDPAppIdInvalid",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
	public void tC201_AdminUser_Test37_CreateSSCAdminWithMDPAppIdInvalid(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test38_CreateSSCAdminWithInvalidemailId")
	 public  JSONObject[][] TC201_AdminUser_Test38_CreateSSCAdminWithInvalidemailId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test38_CreateSSCAdminWithInvalidemailId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test38_CreateSSCAdminWithInvalidemailId",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
	public void tC201_AdminUser_Test38_CreateSSCAdminWithInvalidemailId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(false,true, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test39_CreateSSCAdminWithoutContactDetails")
	 public  JSONObject[][] TC201_AdminUser_Test39_CreateSSCAdminWithoutContactDetails() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test39_CreateSSCAdminWithoutContactDetails","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test39_CreateSSCAdminWithoutContactDetails",dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},groups= {"adminuserservice"},enabled=true)
	public void tC201_AdminUser_Test39_CreateSSCAdminWithoutContactDetails(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));

		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		Response res=aUser.post_CreateUserMDPUser(false,true, atn, (String)j.get("mdpappid"),m2);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	/* ***************************End Of Post Admin Service****************************
	 **********************************************************************************
	 ******************************Start Of Get All Admins Service**********************/
	
	 @DataProvider(name="TC201_AdminUser_Test01_GetAdminUsers")
	 public  JSONObject[][] TC201_AdminUser_Test01_GetAdminUsers() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test01_GetAdminUsers","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test01_GetAdminUsers",groups= {"adminuserservice"},enabled=true)
  public void tC201_AdminUser_Test01_GetAdminUsers(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		ArrayList<String> emailList=new ArrayList<String>();
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		emailList.add(res.jsonPath().getString(aUser.getEMAIL()));
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), null);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		aUser.checkRecordsInGetAllUsers(atn,aUser.getRESEMAIL(), res2, emailList);
		
	}
	
	@DataProvider(name="TC201_AdminUser_Test02_GetAdminUsersAndVerifyHeaderDataInbody")
	 public  JSONObject[][] TC201_AdminUser_Test02_GetAdminUsersAndVerifyHeaderDataInbody() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test02_GetAdminUsersAndVerifyHeaderDataInbody","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test02_GetAdminUsersAndVerifyHeaderDataInbody",groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test02_GetAdminUsersAndVerifyHeaderDataInbody(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		ArrayList<String> emailList=new ArrayList<String>();
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		emailList.add(res.jsonPath().getString(aUser.getEMAIL()));
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), null);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		test.get().log(Status.DEBUG, "The Header DAta Is :"+res2.getHeader("totalPages"));
		String x=res2.getHeader("totalPages");
		test.get().log(Status.DEBUG, "The total Pages Value in the headers is :"+x);
		Assert.assertEquals(x, null);
		
	}
	
	@DataProvider(name="TC201_AdminUser_Test03_GetAdminUsersWithFirstNameFilter")
	 public  JSONObject[][] TC201_AdminUser_Test03_GetAdminUsersWithFirstNameFilter() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test03_GetAdminUsersWithFirstNameFilter","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test03_GetAdminUsersWithFirstNameFilter",groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test03_GetAdminUsersWithFirstNameFilter(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		ArrayList<String> emailList=new ArrayList<String>();
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		String fname="FirstName"+getDateString();
		m2.put("firstname",fname );
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		emailList.add(res.jsonPath().getString(aUser.getEMAIL()));
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("firstname", fname);
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		aUser.checkRecordsInGetAllUsers(atn,aUser.getRESEMAIL(), res2, emailList);
		
	}
	
	@DataProvider(name="TC201_AdminUser_Test04_GetAdminUsersWithLastNameFilter")
	 public  JSONObject[][] TC201_AdminUser_Test04_GetAdminUsersWithLastNameFilter() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test04_GetAdminUsersWithLastNameFilter","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test04_GetAdminUsersWithLastNameFilter",groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test04_GetAdminUsersWithLastNameFilter(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		ArrayList<String> emailList=new ArrayList<String>();
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		String lname="LastName"+getDateString();
		m2.put("lastname",lname);
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		emailList.add(res.jsonPath().getString(aUser.getEMAIL()));
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("lastname", lname);
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		aUser.checkRecordsInGetAllUsers(atn,aUser.getRESEMAIL(), res2, emailList);
		
	}
	
	@DataProvider(name="TC201_AdminUser_Test05_GetAdminUsersWithFirstAndLastNameFilter")
	 public  JSONObject[][] TC201_AdminUser_Test05_GetAdminUsersWithFirstAndLastNameFilter() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test05_GetAdminUsersWithFirstAndLastNameFilter","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test05_GetAdminUsersWithFirstAndLastNameFilter",groups= {"adminuserservice"},enabled=true)
 public void tC201_AdminUser_Test05_GetAdminUsersWithFirstAndLastNameFilter(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		ArrayList<String> emailList=new ArrayList<String>();
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		String fname="FirstName"+getDateString();
		String lname="LastName"+getDateString();
		m2.put("firstname",fname);
		m2.put("lastname",lname );
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		emailList.add(res.jsonPath().getString(aUser.getEMAIL()));
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("firstname",fname);
		m3.put("lastname",lname );
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		aUser.checkRecordsInGetAllUsers(atn,aUser.getRESEMAIL(), res2, emailList);
		
	}
	
	@DataProvider(name="TC201_AdminUser_Test06_GetAdminUsersWithUsingSSCAdminAuth")
	 public  JSONObject[][] TC201_AdminUser_Test06_GetAdminUsersWithUsingSSCAdminAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test06_GetAdminUsersWithUsingSSCAdminAuth","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test06_GetAdminUsersWithUsingSSCAdminAuth",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
public void TC201_AdminUser_Test06_GetAdminUsersWithUsingSSCAdminAuth(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		test.get().log(Status.DEBUG, "The List of Credetials from the depending test are :"+cList.toString());
		String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), null);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		
	}
	
	
	@DataProvider(name="TC201_AdminUser_Test07_GetAdminUsersWithPageSizeGrt10")
	 public  JSONObject[][] TC201_AdminUser_Test07_GetAdminUsersWithPageSizeGrt10() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test07_GetAdminUsersWithPageSizeGrt10","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test07_GetAdminUsersWithPageSizeGrt10",groups= {"adminuserservice"},enabled=true)
public void tC201_AdminUser_Test07_GetAdminUsersWithPageSizeGrt10(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("pagesize", "15");
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		int x=((List)res2.jsonPath().get(aUser.getRESEMAIL())).size();
		test.get().log(Status.DEBUG, "The Size of the returned array is :"+x);
		if(x!=15)
		{
			throw new Exception("The Page Size is not as expected as 15");
			
		}
		
	}
	
	@DataProvider(name="TC201_AdminUser_Test08_GetAdminUsersWithPageSizeLs10")
	 public  JSONObject[][] TC201_AdminUser_Test08_GetAdminUsersWithPageSizeLs10() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test08_GetAdminUsersWithPageSizeLs10","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test08_GetAdminUsersWithPageSizeLs10",groups= {"adminuserservice"},enabled=true)
public void tC201_AdminUser_Test08_GetAdminUsersWithPageSizeLs10(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("pagesize", "9");
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		int x=((List)res2.jsonPath().get(aUser.getRESEMAIL())).size();
		test.get().log(Status.DEBUG, "The Size of the returned array is :"+x);
		if(x!=9)
		{
			throw new Exception("The Page Size is not as expected as 9");
			
		}
	}
	
	@DataProvider(name="TC201_AdminUser_Test09_GetAdminUsersWithPageSizeGrt31")
	 public  JSONObject[][] TC201_AdminUser_Test09_GetAdminUsersWithPageSizeGrt31() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test09_GetAdminUsersWithPageSizeGrt31","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test09_GetAdminUsersWithPageSizeGrt31",groups= {"adminuserservice"},enabled=true)
public void tC201_AdminUser_Test09_GetAdminUsersWithPageSizeGrt31(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("pagesize", "31");
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		int x=((List)res2.jsonPath().get(aUser.getRESEMAIL())).size();
		test.get().log(Status.DEBUG, "The Size of the returned array is :"+x);
		if(x!=30)
		{
			throw new Exception("The Page Size is not as expected as 30");
			
		}
	}
	
	@DataProvider(name="TC201_AdminUser_Test10_GetAdminUsersWithPageSize0")
	 public  JSONObject[][] TC201_AdminUser_Test10_GetAdminUsersWithPageSize0() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test10_GetAdminUsersWithPageSize0","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test10_GetAdminUsersWithPageSize0",groups= {"adminuserservice"},enabled=true)
public void tC201_AdminUser_Test10_GetAdminUsersWithPageSize0(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("pagesize", "0");
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		if(((List)res2.jsonPath().get(aUser.getRESEMAIL())).size()<0)
		{
			throw new Exception("The Page Size is not as expected as 0");
			
		}
	}

	@DataProvider(name="TC201_AdminUser_Test11_GetAdminUsersWithCountryFilter")
	 public  JSONObject[][] TC201_AdminUser_Test11_GetAdminUsersWithCountryFilter() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test11_GetAdminUsersWithCountryFilter","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test11_GetAdminUsersWithCountryFilter",groups= {"adminuserservice"},enabled=true)
public void tC201_AdminUser_Test11_GetAdminUsersWithCountryFilter(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();	
		ArrayList<String> emailList=new ArrayList<String>();
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Map<String,Object>m2=(Map<String,Object>) j.get("jsonobjects");
		m2.put(aUser.getFIRSTNAME(), "FirstName"+getDateString());
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),m2);
		emailList.add(res.jsonPath().getString(aUser.getEMAIL()));
		Map<String,String>m3=new HashMap<String,String>();
		m3.put("country", res.jsonPath().getString(aUser.getCOUNTRY()));
		Response res2=aUser.get_AllAdmins(atn,(String)j.get("mdpappid"), m3);
		Assert.assertEquals(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		aUser.checkRecordsInGetAllUsers(atn,aUser.getRESEMAIL(), res2, emailList);
		
	}
	
	/* ***************************End Of Get All AdminsService****************************
	 **********************************************************************************
	 ******************************Start Of Get  Admin Service**********************/
	
	
	 @DataProvider(name="TC201_AdminUser_Test01_GetMDPAdminWithEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test01_GetMDPAdminWithEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test01_GetMDPAdminWithEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test01_GetMDPAdminWithEntityId",groups= {"adminuserservice"},enabled=true)
  public void tC201_AdminUser_Test01_GetMDPAdminWithEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		/*commenting the below code so as the sibbling creation is  not  working
		 * Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String effId=res.jsonPath().getString("id");* */
		String effId="06ef970f-4afd-490b-a0fe-42361b7a55a4";
		test.get().log(Status.DEBUG, "The Entiyt Id to find is "+effId);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effId);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		assertEquals(res2.jsonPath().getString("id"), effId);

	}
	
	 @DataProvider(name="TC201_AdminUser_Test02_GetSSCAdminWithEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test02_GetSSCAdminWithEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test02_GetSSCAdminWithEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test02_GetSSCAdminWithEntityId",groups= {"adminuserservice"},enabled=true)
  public void tC201_AdminUser_Test02_GetSSCAdminWithEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String effId=res.jsonPath().getString("id");
		test.get().log(Status.DEBUG, "The Mail and the entity Id from res:"+effMail+" and "+effId);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effId);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		assertEquals(res2.jsonPath().getString("id"), effId);

	}
	
	 @DataProvider(name="TC201_AdminUser_Test03_GetMDPAdminWithEmailId")
	 public  JSONObject[][] TC201_AdminUser_Test03_GetMDPAdminWithEmailId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test03_GetMDPAdminWithEmailId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test03_GetMDPAdminWithEmailId",groups= {"adminuserservice"},enabled=true)
  public void tC201_AdminUser_Test03_GetMDPAdminWithEmailId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		/*commenting the below code so as the sibbling creation is  not  working
		 * Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String effId=res.jsonPath().getString("id");* */
		String effMail="MDPAdmin@id.zeiss.com";
		test.get().log(Status.DEBUG, "The Entiyt Id to find is "+effMail);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effMail);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		assertEquals(res2.jsonPath().getString(aUser.getEMAIL()), effMail);

	}
	
	 @DataProvider(name="TC201_AdminUser_Test04_GetSSCAdminWithEmailId")
	 public  JSONObject[][] TC201_AdminUser_Test04_GetSSCAdminWithEmailId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test04_GetSSCAdminWithEmailId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test04_GetSSCAdminWithEmailId",groups= {"adminuserservice"},enabled=true)
  public void tC201_AdminUser_Test04_GetSSCAdminWithEmailId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String effId=res.jsonPath().getString("id");
		test.get().log(Status.DEBUG, "The Mail and the entity Id from res:"+effMail+" and "+effId);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effMail);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		assertEquals(res2.jsonPath().getString(aUser.getEMAIL()), effMail);

	}
	
	 @DataProvider(name="TC201_AdminUser_Test05_GetAccountAdminWithEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test05_GetAccountAdminWithEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test05_GetAccountAdminWithEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test05_GetAccountAdminWithEntityId",groups= {"adminuserservice"},enabled=false)//application user service apis are to be used for creating account and site admins
  public void tC201_AdminUser_Test05_GetAccountAdminWithEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String effId=res.jsonPath().getString("id");
		test.get().log(Status.DEBUG, "The Mail and the entity Id from res:"+effMail+" and "+effId);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effId);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		assertEquals(res2.jsonPath().getString("id"), effId);

	}

	
	 @DataProvider(name="TC201_AdminUser_Test06_GetSiteAdminWithEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test06_GetSiteAdminWithEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test06_GetSiteAdminWithEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test06_GetSiteAdminWithEntityId",groups= {"adminuserservice"},enabled=false)//application user service apis are to be used for creating account and site admins
  public void tC201_AdminUser_Test06_GetSiteAdminWithEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		String effId=res.jsonPath().getString("id");
		test.get().log(Status.DEBUG, "The Mail and the entity Id from res:"+effMail+" and "+effId);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effId);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		assertEquals(res2.jsonPath().getString("id"), effId);

	}
	
	
	 @DataProvider(name="TC201_AdminUser_Test07_GetSSCAdminWithEntityIdUsingSSCAdminAuth")
	 public  JSONObject[][] TC201_AdminUser_Test07_GetSSCAdminWithEntityIdUsingSSCAdminAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test07_GetSSCAdminWithEntityIdUsingSSCAdminAuth","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test07_GetSSCAdminWithEntityIdUsingSSCAdminAuth",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
  public void tC201_AdminUser_Test07_GetSSCAdminWithEntityIdUsingSSCAdminAuth(JSONObject j) throws Exception {
		//ssc creation
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		Map<String,Object>m= new HashMap<String,Object>();		
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.post_CreateUserMDPUser(true,false, atn, (String)j.get("mdpappid"),(Map<String,Object>) j.get("jsonobjects"));
		String effMail=res.jsonPath().getString(aUser.getEMAIL());
		//getting ssc admin using ssc admin
		WebDriver dri2=getDriver();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		test.get().log(Status.DEBUG, "The List of Credetials from the depending test are :"+cList.toString());
		String atn2= getIdToken(dri2, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
		//dri2.quit(); commenting as the driver is the same session for both the above steps
		Response res2=aUser.getAdmin(atn2, (String)j.get("mdpappid"), effMail);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
	}
	
	 @DataProvider(name="TC201_AdminUser_Test08_GetSSCAdminWithInvalidMDPIdAndValidEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test08_GetSSCAdminWithInvalidMDPIdAndValidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test08_GetSSCAdminWithInvalidMDPIdAndValidEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test08_GetSSCAdminWithInvalidMDPIdAndValidEntityId",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
  public void tC201_AdminUser_Test08_GetSSCAdminWithInvalidMDPIdAndValidEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		String effId=cList.get(0);
		test.get().log(Status.DEBUG, "The entity and "+effId);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effId);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test09_GetSSCAdminWithvalidMDPIdAndInValidEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test09_GetSSCAdminWithvalidMDPIdAndInValidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test09_GetSSCAdminWithvalidMDPIdAndInValidEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test09_GetSSCAdminWithvalidMDPIdAndInValidEntityId",groups= {"adminuserservice"},enabled=true)
  public void tC201_AdminUser_Test09_GetSSCAdminWithvalidMDPIdAndInValidEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		String effId="6652d8ea-dd1b-4c9a-ab33-95c7424cc206";//invalid id
		test.get().log(Status.DEBUG, "The ntity Id  and "+effId);
		Response res2=aUser.getAdmin(atn, (String)j.get("mdpappid"), effId);
		assertVal(res2.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	
	
	/* ***************************End Of Get  AdminsService****************************
	 **********************************************************************************
	 ******************************Start Of Put  Admin Service**********************/
	
	
	 @DataProvider(name="TC201_AdminUser_Test01_PutMDPAdminWithEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test01_PutMDPAdminWithEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test01_PutMDPAdminWithEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test01_PutMDPAdminWithEntityId",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1"},enabled=true)
  public void tC201_AdminUser_Test01_PutMDPAdminWithEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test01_CreateAppAdminSibblingWithUserType1");
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.put_EditUserMDPUser(cList.get(2), atn, (String)j.get("mdpappid"), null);
		assertVal(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test02_PutSSCAdminWithEntityId")
	 public  JSONObject[][] TC201_AdminUser_Test02_PutSSCAdminWithEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test02_PutSSCAdminWithEntityId","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test02_PutSSCAdminWithEntityId",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
  public void tC201_AdminUser_Test02_PutSSCAdminWithEntityId(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.put_EditUserMDPUser(cList.get(2), atn, (String)j.get("mdpappid"), null);
		assertVal(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	
	 @DataProvider(name="TC201_AdminUser_Test03_PutSSCAdminWithEntityIdUsingSSCAdminAuth")
	 public  JSONObject[][] TC201_AdminUser_Test03_PutSSCAdminWithEntityIdUsingSSCAdminAuth() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test03_PutSSCAdminWithEntityIdUsingSSCAdminAuth","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test03_PutSSCAdminWithEntityIdUsingSSCAdminAuth",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
  public void tC201_AdminUser_Test03_PutSSCAdminWithEntityIdUsingSSCAdminAuth(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		test.get().log(Status.DEBUG, "The List of Credetials from the depending test are :"+cList.toString());
		String atn= getIdToken(dri, cList.get(0) ,cList.get(1),(String)j.get("sscusercleintid"));
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.put_EditUserMDPUser(cList.get(2), atn, (String)j.get("mdpappid"), null);
		assertVal(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test04_PutSSCAdminWithEntityIdWithContact1")
	 public  JSONObject[][] TC201_AdminUser_Test04_PutSSCAdminWithEntityIdWithContact1() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test04_PutSSCAdminWithEntityIdWithContact1","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test04_PutSSCAdminWithEntityIdWithContact1",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
  public void TC201_AdminUser_Test04_PutSSCAdminWithEntityIdWithContact1(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.put_EditUserMDPUser(cList.get(2), atn, (String)j.get("mdpappid"), null);
		assertVal(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test05_PutSSCAdminWithEntityIdWithContact3")
	 public  JSONObject[][] TC201_AdminUser_Test05_PutSSCAdminWithEntityIdWithContact3() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test05_PutSSCAdminWithEntityIdWithContact3","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test05_PutSSCAdminWithEntityIdWithContact3",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
  public void tC201_AdminUser_Test05_PutSSCAdminWithEntityIdWithContact3(JSONObject j) throws Exception {
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.put_EditUserMDPUser(cList.get(2), atn, (String)j.get("mdpappid"), null);
		assertVal(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	
	 @DataProvider(name="TC201_AdminUser_Test06_PutSSCAdminWithEntityIdWithContact0")
	 public  JSONObject[][] TC201_AdminUser_Test06_PutSSCAdminWithEntityIdWithContact0() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC201_AdminUser_Test06_PutSSCAdminWithEntityIdWithContact0","adminuserservice");
	 }
	@Test(dataProvider="TC201_AdminUser_Test06_PutSSCAdminWithEntityIdWithContact0",groups= {"adminuserservice"},dependsOnMethods= {"tC201_AdminUser_Test04_CreateSSCAdminWithUserType1"},enabled=true)
  public void tC201_AdminUser_Test06_PutSSCAdminWithEntityIdWithContact0(JSONObject j) throws Exception {
		System.out.println("Executing the test for skipped scenario");
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authuser");
		String atn= getIdToken(dri, authUser ,(String)((Map) credentialJson.get(authUser)).get("pwd"), (String)credentialJson.get("mdpopsclid"));
		List<String>cList=dynamicCredentials.get("tC201_AdminUser_Test04_CreateSSCAdminWithUserType1");
		AdminUserService_AdminUser aUser=new AdminUserService_AdminUser();
		Response res=aUser.put_EditUserMDPUser(cList.get(2), atn, (String)j.get("mdpappid"), null);
		assertVal(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));

	}
	

	
}