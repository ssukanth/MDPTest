package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.aventstack.extentreports.Status;
import com.selenium.utils.ApiUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MDPAccount extends ApiUtils {
	
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		exeData.add("AuthToken="+authToken);
		httpReq.auth().oauth2(authToken);
		test.get().log(Status.DEBUG, "The requqest aithenticated using the authcode"+authToken);
	
		httpReq.contentType("application/json");
	}
	
	
	public String createAccount_Body_Builder(String name,String email,String sapId,String MdpAppId, String alternateEmail) throws IOException, ParseException 
	{
		String payLoad="/src/test/java/com/mdp/api/modals/CreateAccount.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);

			jObj.replace("name", name);
			jObj.replace("email", email);
			jObj.replace("mdpAppId", MdpAppId);
			jObj.replace("sapId", sapId);
			jObj.replace("alternateEmail", alternateEmail);
			exeData.add(jObj.toString());
			return jObj.toString();
		
	}
	
	public String updateAccount_Body_Builder(String name,String sapId,String MdpAppId,Map<String,String> updateFiledvalue) throws IOException, ParseException 
	{
		String payLoad="/src/test/java/com/mdp/api/modals/CreateAccount.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
			jObj.replace("name", name);
			jObj.replace("mdpAppId", MdpAppId);
			jObj.replace("sapId", sapId);
			for(Map.Entry<String, String>e:updateFiledvalue.entrySet()) {
				jObj.replace(e.getKey(), e.getValue());
			}
			exeData.add(jObj.toString());
			return jObj.toString();
		
	}
	
	
	
	public Response postCreateAccount(boolean defName,String authToken,String name,String email,String MdpAppId,String sapId,String alternateEmail) throws NumberFormatException, IOException, ParseException
	{
		if(defName)
		{
			test.get().log(Status.DEBUG, "CreateAccount with default generated mandatory values");

			name="TestAccount"+genCurDateString();
			sapId="TestSapId"+genCurDateString();
		}

		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		test.get().log(Status.DEBUG, "The mandatory values for the create account is :"+name+"_"+sapId);
		String payload= createAccount_Body_Builder(name, email, sapId, MdpAppId, alternateEmail);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("createAccount"));
		res = httpReq.request(Method.POST,(String)credentialJson.get("createAccount"));	
		return res;
	}
	
	public Response putUpdateAccount(boolean defName,String authToken,String name,String MdpAppId,String sapId,Map<String,String> updateFiledvalue) throws NumberFormatException, IOException, ParseException
	{
		if(defName)
		{
			test.get().log(Status.DEBUG, "CreateAccount with default generated mandatory values");

			name="TestAccount"+genCurDateString();
			sapId="TestSapId"+genCurDateString();
		}

		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		test.get().log(Status.DEBUG, "The mandatory values for the create account is :"+name+"_"+sapId);
		String payload= updateAccount_Body_Builder(name, sapId, MdpAppId, updateFiledvalue);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("updateAccount"));
		res = httpReq.request(Method.PUT,(String)credentialJson.get("updateAccount"));	
		return res;
	}
	
	
	public Response getVerifySapidExists(String authToken,String sapID)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+sapID);
		exeData.add((String)credentialJson.get("sapidCheck"));
		Response res = httpReq
				.queryParam("sapId", sapID)
				.request(Method.GET,(String)credentialJson.get("sapidCheck"));	
		return res;
		
	}
	
	public Response getAccounts(String authToken)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add((String)credentialJson.get("getAccounts"));
		Response res = httpReq
				.request(Method.GET,(String)credentialJson.get("getAccounts"));	
		return res;
		
	}
	public Response getAccount(String authToken,String accId)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+accId);
		exeData.add((String)credentialJson.get("getAccount"));
		Response res = httpReq
				.queryParam("accountId", accId)
				.request(Method.GET,(String)credentialJson.get("getAccount"));	
		return res;
		
	}
	
	
	


}
