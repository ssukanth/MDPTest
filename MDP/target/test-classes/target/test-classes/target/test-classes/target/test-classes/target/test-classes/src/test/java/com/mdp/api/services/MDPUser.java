package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.Status;
import com.selenium.utils.ApiUtils;
import com.selenium.utils.TestVars;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MDPUser extends ApiUtils {
	
	

	public void request_Authenticate(RequestSpecification httpReq,String authToken)
	{
		
		httpReq.auth().oauth2(authToken);
		httpReq.contentType("application/json");
		test.get().log(Status.DEBUG, "Authenticated the request with auth:"+authToken);
		exeData.add("AuthToken = "+authToken);
	}

	
	public String mdpAdmin_Body_Builder(boolean payTypeValid,String email,String MdpAppId,@Optional String zeissUserType,@Optional String roleId,@Optional String siteId,@Optional String accountId,@Optional String alternateEmail) throws IOException, ParseException 
	{
		String payLoad="/src/test/java/com/mdp/api/modals/MDPCreateUserAdmin.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		if(payTypeValid)
		{
			test.get().log(Status.DEBUG, "Creating the Admin user with default valid admin user");
			jObj.replace("email", email);
			jObj.replace("mdpAppId", MdpAppId);
		}else
		{
			jObj.replace("email", email);
			jObj.replace("mdpAppId", MdpAppId);
			jObj.replace("roleId", roleId);
			jObj.replace("siteId", siteId);
			jObj.replace("alternateEmail", alternateEmail);
			jObj.replace("zeissIdUserType", zeissUserType);	
		}
		//JSONObject jObj_Patient=(JSONObject) jObj.get("Patient");
		//JSONObject jObj_PHistory=(JSONObject) jObj_Patient.get("History");
		//exeData.add(jObj.toString());
		exeData.add(jObj.toString());
		return jObj.toString();
		
	}
	
	public String mdpCreateUSer_Body_Builder(String email,String MdpAppId, String zeissUserType, String roleId, String siteId, String accountId, String alternateEmail) throws IOException, ParseException 
	{
		String payLoad="/src/test/java/com/mdp/api/modals/MDPCreateUserAdmin.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
			jObj.replace("email", email);
			jObj.replace("mdpAppId", MdpAppId);
			jObj.replace("roleId", roleId);
			jObj.replace("siteId", siteId);
			jObj.replace("accountId", accountId);
			jObj.replace("alternateEmail", alternateEmail);
			jObj.replace("zeissIdUserType", zeissUserType);	
			exeData.add(jObj.toString());
			return jObj.toString();
		
	}
	
	
	
	public Response createUserMDPAdmin(String authToken,boolean payTypeValid,String email,String MdpAppId, String zeissUserType, String roleId, String siteId, String accountId, String alternateEmail) throws NumberFormatException, IOException, ParseException
	{
		
		
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		String payload=mdpAdmin_Body_Builder(payTypeValid, email, MdpAppId, zeissUserType, roleId, siteId, accountId, alternateEmail);
		test.get().log(Status.DEBUG, "Creating the admin user with payload:"+payload);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("createUser"));
		res = httpReq.request(Method.POST,(String)credentialJson.get("createUser"));	
		return res;
	}
	public Response createUserMDPUser(boolean defMailString,String authToken,String email,String MdpAppId, String zeissUserType, String roleId, String siteId, String accountId, String alternateEmail) throws NumberFormatException, IOException, ParseException
	{
		if(defMailString)
		{
			
			
			email="zeiss0719+"+genCurDateString()+"@gmail.com";
			test.get().log(Status.DEBUG, "Creating the user with defualt generated email:"+email);
		}
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		String payload=mdpCreateUSer_Body_Builder(email, MdpAppId, zeissUserType, roleId, siteId, accountId, alternateEmail);
		test.get().log(Status.DEBUG, "Created users with the payload"+payload);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("createUser"));
		res = httpReq.request(Method.POST,(String)credentialJson.get("createUser"));
		

		return res;
	}
	
	
	public Response getIsUserExists(String authToken,String userMail)
	{
		
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		exeData.add((String) credentialJson.get("baseUri"));
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		httpReq.queryParam("email", userMail);
		exeData.add("QueryParam_"+userMail);
		request_Authenticate(httpReq, authToken);
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("isUserExists"));
		Response res = httpReq.request(Method.GET,(String)credentialJson.get("isUserExists"));	
		exeData.add(res.asString());
		return res;
		
	}
	
	
	public Response getUser(String authToken,String userId)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		System.out.println("Getting the user for the user id :"+userId);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+userId);
		exeData.add((String)credentialJson.get("getUser"));
		Response res = httpReq
				.queryParam("userId", userId)
				.request(Method.GET,(String)credentialJson.get("getUser"));	
		return res;
		
	}
	
	
	public Response getUsers(String authToken)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add((String)credentialJson.get("getUsers"));
		Response res = httpReq
				.request(Method.GET,(String)credentialJson.get("getUsers"));	
		return res;
		
	}
	//idAndType - this will be an array with the id as 0 entry and idtype (Account or site or rolename) as 1th entry
	public Response getUsers(String authToken, String[] idAndType)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		String id=idAndType[0];
		String idType="";
		switch(idAndType[1])
		{
		case "account":idType="accountId" ;break;
		case "site":idType="siteId" ;break;
		case "rolename":idType="roleName" ;break;
		
		}
		exeData.add("QueryParam :"+idType+"="+id);
		exeData.add((String)credentialJson.get("getUsers"));
		Response res = httpReq
				.queryParam(idType, id)
				.request(Method.GET,(String)credentialJson.get("getUsers"));	
		return res;
		
	}
	
	public Response getUsers(String authToken,String accId,String siteId)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+accId);
		exeData.add("QueryParam_"+siteId);
		exeData.add((String)credentialJson.get("getUsers"));
		Response res = httpReq
				.queryParam("accountId"+accId)
				.queryParam("siteId"+siteId)
				.request(Method.GET,(String)credentialJson.get("getUsers"));	
		return res;
		
	}
	
	public Response getUsers(String authToken,String accId,String siteId,String role)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+accId);
		exeData.add("QueryParam_"+siteId);
		exeData.add("QueryParam_"+role);
		exeData.add((String)credentialJson.get("getUsers"));
		Response res = httpReq
				.queryParam("accountId"+accId)
				.queryParam("siteId"+siteId)
				.queryParam("roleName"+role)
				.request(Method.GET,(String)credentialJson.get("getUsers"));	
		return res;
		
	}

	
	
	
	
	
	
	

}
