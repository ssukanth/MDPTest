package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.aventstack.extentreports.Status;
import com.selenium.utils.ApiUtils;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApplicationUserService_AccountService extends ApiUtils {
	
	JSONObject mdpAppUserService_Account=(JSONObject)(((Map)credentialJson.get("applicationuserservice")).get("account"));
	private String ACCOUNTNAME ="accountName";
	private String MDPAPPID ="mdpAppId";
	private String ACCOUNTTYPE ="accountType";
	private String CONTACTDETAILS ="contactDetails";
	private String ADDRESSLINE1 ="contactDetails.addressLine1";
	private String ADDRESSLINE2 ="contactDetails.addressLine2";
	private String CITY ="contactDetails.city";
	private String DISTRICT ="contactDetails.district";
	private String STATE ="contactDetails.state";
	private String COUNTRY ="contactDetails.country";
	private String PIN ="contactDetails.postalCode";
	private String EMAIL ="contactDetails.email";
	private String ALTMAIL ="contactDetails.alternateEmail";
	private String CONTACT ="contactDetails.contactNo";
	private String ALTERNATENO ="contactDetails.alternateNo";
	public String classPat=System.getProperty("java.class.path");
	public String resAccId="accountId";

	public JSONObject getMdpAppUserService_Account() {
		return mdpAppUserService_Account;
	}
	public String getClassPat() {
		return classPat;
	}
	public String getResAccId() {
		return resAccId;
	}
	public JSONObject getMdpAdminUserService_Zeissid() {
		return mdpAppUserService_Account;
	}
	public String getACCOUNTNAME() {
		return ACCOUNTNAME;
	}
	public String getMDPAPPID() {
		return MDPAPPID;
	}
	public String getACCOUNTTYPE() {
		return ACCOUNTTYPE;
	}
	public String getCONTACTDETAILS() {
		return CONTACTDETAILS;
	}
	public String getADDRESSLINE1() {
		return ADDRESSLINE1;
	}
	public String getADDRESSLINE2() {
		return ADDRESSLINE2;
	}
	public String getCITY() {
		return CITY;
	}
	public String getDISTRICT() {
		return DISTRICT;
	}
	public String getSTATE() {
		return STATE;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public String getPIN() {
		return PIN;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public String getALTMAIL() {
		return ALTMAIL;
	}
	public String getCONTACT() {
		return CONTACT;
	}
	public String getALTERNATENO() {
		return ALTERNATENO;
	}
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		httpReq.header(
	              "Authorization",
	              "Bearer " + authToken);
		httpReq.contentType("application/json");
	             
	}
	
	private  String  postAccount_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/ApplicationUserService_AccountService.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		//Object obj=Class.forName("com.mdp.api.services.AdminUserService_Zeissid").newInstance();
		System.out.println("The current class path for the main exe is :"+classPat);
		Object obj=Class.forName(classPat).newInstance();

		java.lang.reflect.Method m=null;
		System.out.println("the Values to change are :"+alterVal);
		exeData.add("/nThe Values to change In JSON:"+alterVal);
		test.get().log(Status.DEBUG, "/nThe Values to change In JSON:"+alterVal);
		String effVal=null;
		if(alterVal!=null)
		{
		for(Map.Entry<String, Object>e:alterVal.entrySet())
		{
			 m=obj.getClass().getMethod("get"+e.getKey().toUpperCase());
			effVal=(String)m.invoke(obj);
			System.out.println("the Effective string to modify:"+effVal);
			altVals2.put(effVal, e.getValue());
		}
			exeData.add("\nThe Changed JSONObjects are :"+altVals2);
			payL=changePayloadAttrVal(jObj, altVals2);
		}
		return payL;
	}
	
	private  String  editZeissId_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/AdminUserService_ZeissId.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.AdminUserService_Zeissid").newInstance();
		java.lang.reflect.Method m=null;
		System.out.println("the Values to change are :"+alterVal);
		exeData.add("/nThe Values to change In JSON:"+alterVal);
		test.get().log(Status.DEBUG, "/nThe Values to change In JSON:"+alterVal);
		String effVal=null;
		if(alterVal!=null)
		{
		for(Map.Entry<String, Object>e:alterVal.entrySet())
		{
			 m=obj.getClass().getMethod("get"+e.getKey().toUpperCase());
			effVal=(String)m.invoke(obj);
			System.out.println("the Effective string to modify:"+effVal);
			altVals2.put(effVal, e.getValue());
		}
			exeData.add("\nThe Changed JSONObjects are :"+altVals2);
			payL=changePayloadAttrVal(jObj, altVals2);
		}else
		{
			payL=jObj.toString();
		}
		return payL;
	}
	
	public Response post_CreateAccount(boolean defName,boolean defMail,String authToken,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
		if(defName)
		{
			String effName="Account_"+getDateString();
			alterVals.put("ACCOUNTNAME", effName);
			test.get().log(Status.DEBUG, "Creating the app with the default CleintId"+effName);
		}
		if(defMail)
		{
			
			String email="zeiss0719+"+genCurDateString()+"@gmail.com";
			test.get().log(Status.DEBUG, "Creating the user with defualt generated email:"+email);
			alterVals.put("EMAIL", email);
		}
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=postAccount_Body_Builder(alterVals);
		System.out.println(mdpAppUserService_Account.get("postaccount"));
		String effEnd=((String)mdpAppUserService_Account.get("postaccount"));
		exeData.add("\nThe Effective end point is :"+effEnd);
		exeData.add("\n payload"+payload);
		test.get().log(Status.DEBUG, "The Effective end point is :"+effEnd);
		test.get().log(Status.DEBUG, "Created users with the payload"+payload);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		res = httpReq.request(Method.POST,effEnd);
		exeData.add("\n Response Code:"+res.getStatusCode());
		exeData.add("\nResponse:"+res.asString());
		test.get().log(Status.DEBUG, "\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\nResponse:"+res.asString());
		System.out.println("\nResponse:"+res.asString());
		return res;
	}
	
	
	
	public Response getZeissId(String atn,String mdpId,String zid)	
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, atn);
		System.out.println("The end point is :"+(String)mdpAppUserService_Account.get("getid"));
		String effEnd=(((String)mdpAppUserService_Account.get("putid")).replace("mdpappid", mdpId)).replace("id", zid);
		exeData.add("Endpoint:"+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The respnse is :"+res.asString());
		test.get().log(Status.DEBUG, "The res is :\n"+res.asString());
		return res;

		
	}
	
	
	public Response put_EditZeissId(String authToken,String mdpAppId,String zId,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=editZeissId_Body_Builder(alterVals);
		System.out.println(mdpAppUserService_Account.get("putid"));
		String effEnd=(((String)mdpAppUserService_Account.get("putid")).replace("mdpappid", mdpAppId)).replace("id", zId);
		exeData.add("\nThe Effective end point is :"+effEnd);
		exeData.add("\n payload"+payload);
		test.get().log(Status.DEBUG, "The Effective end point is :"+effEnd);
		test.get().log(Status.DEBUG, "Created users with the payload"+payload);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("createUser"));
		res = httpReq.request(Method.PUT,effEnd);
		exeData.add("\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\nResponse:"+res.asString());
		System.out.println("\nResponse:"+res.asString());
		return res;
	}

	

}
