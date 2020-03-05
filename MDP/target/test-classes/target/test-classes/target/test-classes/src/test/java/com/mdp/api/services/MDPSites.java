package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.aventstack.extentreports.Status;
import com.selenium.utils.ApiUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MDPSites extends ApiUtils {
	
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		httpReq.auth().oauth2(authToken);
		exeData.add("AuthToken ="+authToken);
		test.get().log(Status.DEBUG, "The requqest aithenticated using the authcode"+authToken);
		httpReq.contentType("application/json");
	}
	
	
	public String createSite_Body_Builder(String name,String accId,Map<String,String> updateFiledvalue) throws IOException, ParseException 
	{
		String payLoad="/src/test/java/com/mdp/api/modals/CreateSite.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		jObj.replace("name", name);
		jObj.replace("accountId", accId);
		if(!(updateFiledvalue==null)) {
			for(Map.Entry<String, String>e:updateFiledvalue.entrySet())
			{
				jObj.replace(e.getKey(), e.getValue());
			}
		}
		
			exeData.add(jObj.toString());
			return jObj.toString();
	}
	
	public Response postCreateSite(boolean defName,String authToken,String name,String accId,Map<String,String> updateFiledvalue) throws IOException, ParseException
	{
		Response res=null;
		if(defName)
		{
			test.get().log(Status.DEBUG, "CreateAccount with default generated mandatory values");

			name="TestSite"+genCurDateString();
		}

		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		test.get().log(Status.DEBUG, "The mandatory values for the create Site is :"+name+"_AccountId:"+accId);
		String payload= createSite_Body_Builder(name,accId,updateFiledvalue );
		httpReq.body(payload);
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("createSite"));
		res = httpReq.request(Method.POST,(String)credentialJson.get("createSite"));//request(typeofReq,uri to hit)	
		return res;	
	}
	
	public Response putUpdateSite(String authToken,String siteId,String name,String accId,Map<String,String> updateFiledvalue) throws IOException, ParseException
	{
		Response res=null;
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		test.get().log(Status.DEBUG, "The mandatory values for the create Site is :"+name+"_AccountId:"+accId);
		String payload= createSite_Body_Builder(name,accId,updateFiledvalue );
		httpReq.body(payload);
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("createSite"));
		res = httpReq.request(Method.POST,(String)credentialJson.get("createSite"));	
		return res;	
	}
	
	
	
	
	public Response getSitesByAccId(String authToken, String accId)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+accId);
		exeData.add((String)credentialJson.get("getSites"));
		Response res = httpReq
				.queryParam("accountId", accId)
				.request(Method.GET,(String)credentialJson.get("getSites"));	
		return res;
		
	}


	public Response getSitesByAppId(String authT) {
		System.out.println("Authenticating the case creatino using the auth:"+authT);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authT);
		exeData.add((String)credentialJson.get("getSites"));
		Response res = httpReq
				.request(Method.GET,(String)credentialJson.get("getSites"));	
		return res;
	}
	
	
	public Response getSiteBySiteId(String authToken, String siteId)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+siteId);
		exeData.add((String)credentialJson.get("getSite"));
		Response res = httpReq
				.queryParam("siteId", siteId)
				.request(Method.GET,(String)credentialJson.get("getSite"));	
		return res;
		
	}
	
	public Response getSiteByAccIdAndSiteId(String authToken, String accId,String siteId)
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = (String) credentialJson.get("baseUri");
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		exeData.add("QueryParam_"+accId);
		exeData.add((String)credentialJson.get("getSites"));
		Response res = httpReq
				.queryParam("accountId", accId)
				.queryParam("siteId", siteId)
				.request(Method.GET,(String)credentialJson.get("getSites"));	
		return res;
		
	}
	
	
	
	

}
