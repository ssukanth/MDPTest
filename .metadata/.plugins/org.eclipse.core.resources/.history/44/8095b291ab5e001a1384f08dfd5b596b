package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.aventstack.extentreports.Status;
import com.selenium.utils.ApiUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MDPStorageService extends ApiUtils {
	
	public final JSONObject getMdpStorageServiceEndpoints() {
		return mdpStorageServiceEndpoints;
	}

	
	JSONObject mdpStorageServiceEndpoints=(JSONObject)credentialJson.get("storageservice");
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		
		httpReq.auth().oauth2(authToken);
		httpReq.contentType("application/json");
		test.get().log(Status.DEBUG, "Authenticated the request with auth:"+authToken);
		exeData.add("AuthToken = "+authToken);
	}

	public  String  createStorage_Body_Builder(Map<String, Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/Study.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		
		if(alterVal!=null)
		{
			payL=changePayloadAttrVal(jObj, alterVal);
		}
		//return jObj.toString();
		return payL;
	}
	
	
	public Response postCreateStorage(boolean defVals, String accId, Map<String, Object> alterVal) throws IOException, ParseException
	{
		RestAssured.useRelaxedHTTPSValidation();
		Map<String, Object>m2=null;
		
		if(defVals)
		{
			alterVal.put("STUDYINSTANCEUID", "Id#"+getDateString());
		}
		
		String payload=createStorage_Body_Builder(alterVal);
		RestAssured.baseURI = (String) credentialJson.get("baseuri");
		System.out.println("The Base uri is: "+(String) credentialJson.get("baseuri"));
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		httpReq.contentType("application/json");
		httpReq.body(payload);
		exeData.add("Payload: "+payload);
		System.out.println("The end point is: "+(String)mdpStorageServiceEndpoints.get("createstorage"));
		String effEnd=((String)mdpStorageServiceEndpoints.get("createstorage")).replace("accountId", accId);
		exeData.add("Endpoint: "+effEnd);
		Response res=httpReq.request(Method.POST, effEnd);
		System.out.println("The response for POST create study is: ");
		System.out.println(res.asString());
		exeData.add("Response: "+res.asString());
		return res;
	}
	
	public Response createStorageForAccount(String accId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpStorageServiceEndpoints.get("createstorage")).replace("accountId", accId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point "+effEnd);
		Response res=httpReq.request(Method.POST, effEnd);
		test.get().log(Status.DEBUG, "The res is:\n"+res.asString());
		exeData.add("The res is:\n"+res.asString());
		return res;	
	}
	
	public Response getStorageForAccount(String accId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpStorageServiceEndpoints.get("getstorage")).replace("accountId", accId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point "+effEnd);
		Response res=httpReq.request(Method.GET, effEnd);
		test.get().log(Status.DEBUG, "The res is:\n"+res.asString());
		exeData.add("The res is:\n"+res.asString());
		return res;	
	}
	
	public Response editStorageForAccount(String accId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpStorageServiceEndpoints.get("editstorage")).replace("accountId", accId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point "+effEnd);
		Response res=httpReq.request(Method.PUT, effEnd);
		test.get().log(Status.DEBUG, "The res is:\n"+res.asString());
		exeData.add("The res is:\n"+res.asString());
		return res;	
	}
	
	public Response deleteStorageForAccount(String accId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpStorageServiceEndpoints.get("deletestorage")).replace("accountId", accId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point "+effEnd);
		Response res=httpReq.request(Method.DELETE, effEnd);
		test.get().log(Status.DEBUG, "The res is:\n"+res.asString());
		exeData.add("The res is:\n"+res.asString());
		return res;	
	}

}
