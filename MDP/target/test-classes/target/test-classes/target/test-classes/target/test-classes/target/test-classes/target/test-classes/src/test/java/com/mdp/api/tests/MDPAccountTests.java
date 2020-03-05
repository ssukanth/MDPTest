package com.mdp.api.tests;

import java.io.IOException;
import java.util.ArrayList;
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
import com.mdp.api.services.MDPAccount;
import com.selenium.utils.TestVars;
import io.restassured.response.Response;

public class MDPAccountTests extends TestBase {
	protected static String validSapId;
	protected static String validAcId;
	protected static String validAcname;
	  @DataProvider(name="MDPCreateAc")
	  public  JSONObject[][] dataMDPMDPCreateAc() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("MDPCreateAc");
	  }
	@Test(dataProvider="MDPCreateAc",groups= {"mdpt"},dependsOnMethods= {"com.mdp.api.tests.MDPUserTests.tcMDPCreateSSC"},enabled=true)
	public void tcMDPCreateAc(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String mail=(String)j.get("email");
		String appId=(String)j.get("mdpAppId");
		String name=(String)j.get("name");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+mail+"_"+appId+"_"+name);
		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res=mdpAc.postCreateAccount(true,authT, name, mail, appId, "sapId1234", "altmail@gmail.com");
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		validSapId=res.jsonPath().get("sapId");
		validAcId=res.jsonPath().getString("id");
		validAcname=res.jsonPath().getString("name");
		List l= new ArrayList();
		l.add(validAcId);l.add(validSapId);l.add(validAcname);
		dynamicCredentials.put("tcMDPCreateAc", l);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
		
	}
	

	@Test(dataProvider="MDPCreateAc",groups= {"mdpt"},dependsOnMethods= {"tcMDPCreateAc"},enabled=true)
	public void tcMDPUpdateAc(JSONObject j) throws Exception
	{
		//Initializing the test data from the json
		
		TestVars gt= getTestVars();
		String mail=(String)j.get("email");
		String appId=(String)j.get("mdpAppId");
		String name=(String)j.get("name");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+mail+"_"+appId+"_"+name);
		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		Map<String,String> updateFiledvalue=new HashMap<String,String>();
		updateFiledvalue.put("state", "Andhrapradesh");
		updateFiledvalue.put("id","b9eadffa-5362-4da8-78d9-08d778ac1dc5");
		MDPAccount mdpAc=new MDPAccount();
		Response res=mdpAc.putUpdateAccount(false, authT, validAcname, appId, validSapId, updateFiledvalue);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		Assert.assertEquals(res.jsonPath().get("name"), validAcname);
		Assert.assertEquals(res.jsonPath().get("state"), "Andhrapradesh");
		Assert.assertEquals(res.jsonPath().get("id"), "b9eadffa-5362-4da8-78d9-08d778ac1dc5");
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
		}
	
	
	  @DataProvider(name="tcMDPVerifySAPIDExists")
	  public  JSONObject[][] datatcMDPVerifySAPIDExists() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcMDPVerifySAPIDExists");
	  }
	@Test(dataProvider="tcMDPVerifySAPIDExists",groups= {"mdpt"},dependsOnMethods= {"tcMDPCreateAc"},enabled=true)
	public void tcMDPVerifySAPIDExistsMDPAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("admin").get(0);
		String adminPwd=dynamicCredentials.get("admin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+appId);
		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getVerifySapidExists(authT, validSapId);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		System.out.println(res.body().asString());
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.body().asString(), "true");
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	}
	
	
	
	@Test(dataProvider="tcMDPVerifySAPIDExists",groups= {"mdpt"},dependsOnMethods= {"tcMDPCreateAc"},enabled=true)
	public void tcMDPVerifySAPIDExistsSSCAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+appId);
		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getVerifySapidExists(authT, validSapId);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		System.out.println(res.body().asString());
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.body().asString(), "true");
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	}
	
	
	@Test(dataProvider="tcMDPVerifySAPIDExists",groups= {"mdpt"},dependsOnMethods= {"com.mdp.api.tests.MDPUserTests.tcMDPCreateAcAdmin"},enabled=true)
	public void tcMDPVerifySAPIDExistsACAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("acadmin").get(0);
		String adminPwd=dynamicCredentials.get("acadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);
		System.out.println("The test data is :"+appId);
		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getVerifySapidExists(authT, validSapId);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		System.out.println(res.body().asString());
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.body().asString(), "true");
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	}
	
	  @DataProvider(name="tcgetAccountsForSSC")
	  public  JSONObject[][] datatcgetAccountsForSSC() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcgetAccountsForSSC");
	  }
	
	@Test(dataProvider="tcgetAccountsForSSC",groups= {"mdpt"},dependsOnMethods= {"tcMDPCreateAc"},enabled=true)
	public void tcgetAccountsForSSC(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);

		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getAccounts(authT);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		res.then().assertThat().extract().asString().contains(validAcId);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	}
	@Test(dataProvider="tcgetAccountsForSSC",groups= {"mdpt"},dependsOnMethods= {"tcMDPCreateAc"},enabled=true)
	public void tcgetAccountsForMDPAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("admin").get(0);
		String adminPwd=dynamicCredentials.get("admin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);

		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getAccounts(authT);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		res.then().assertThat().extract().asString().contains(validAcId);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	}
	@Test(dataProvider="tcgetAccountsForSSC",groups= {"mdpt"},dependsOnMethods= {"com.mdp.api.tests.MDPUserTests.tcMDPCreateAcAdmin"},enabled=true)
	public void tcgetAccountsForAcAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("acadmin").get(0);
		String adminPwd=dynamicCredentials.get("acadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);

		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getAccounts(authT);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().asString());
		res.then().assertThat().extract().asString().contains(validAcId);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	}
	
	  @DataProvider(name="tcgetAccForSSC")
	  public  JSONObject[][] datatctcgetAccForSSC() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("tcgetAccForSSC");
	  }
	
	@Test(dataProvider="tcgetAccForSSC",groups= {"mdpt"},dependsOnMethods= {"tcMDPCreateAc"},enabled=true)
	public void tcgetAccForMDPAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("admin").get(0);
		String adminPwd=dynamicCredentials.get("admin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);

		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getAccount(authT, validAcId);
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("The responses are ");
		System.out.println(res.body().asString());
		res.then().assertThat().extract().asString().contains(validAcId);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	
	}
	
	@Test(dataProvider="tcgetAccForSSC",groups= {"mdpt"},dependsOnMethods= {"tcMDPCreateAc"},enabled=true)
	public void tcgetAccForSSCAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("sscadmin").get(0);
		String adminPwd=dynamicCredentials.get("sscadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);

		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getAccount(authT, validAcId);
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("The responses are ");
		System.out.println(res.body().asString());
		res.then().assertThat().extract().asString().contains(validAcId);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	
	}
	
	
	@Test(dataProvider="tcgetAccForSSC",groups= {"mdpt"},dependsOnMethods= {"com.mdp.api.tests.MDPUserTests.tcMDPCreateAcAdmin"},enabled=true)
	public void tcgetAccForAcAdmin(JSONObject j) throws Exception
	{
		
		TestVars gt= getTestVars();
		String appId=(String)j.get("mdpAppId");
		System.out.println("Running the test for the data");
		String adminUser=dynamicCredentials.get("acadmin").get(0);
		String adminPwd=dynamicCredentials.get("acadmin").get(1);
		test.get().log(Status.DEBUG, "Craeting account using the ssc admin :"+adminUser);
		System.out.println("The Credentials used for generating the auth token"+adminUser);

		//Generating the authtoken for the upload and edit case api calls
		//WebDriver dri2=getDriver();
		exeData.add(appId);
		String authT=getIdToken(null,adminUser, adminPwd,appId);
		System.out.println("The authtoken in test class is "+authT);
		MDPAccount mdpAc=new MDPAccount();
		Response res= mdpAc.getAccount(authT, validAcId);
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("The responses are ");
		System.out.println(res.body().asString());
		res.then().assertThat().extract().asString().contains(validAcId);
		test.get().log(Status.PASS, "Ceated the account with response :"+res.body().asString());
	
	}
	
	
	
	
	
	
	
	
}
