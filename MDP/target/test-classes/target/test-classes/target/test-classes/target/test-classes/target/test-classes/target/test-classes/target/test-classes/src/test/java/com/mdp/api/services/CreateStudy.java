package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.selenium.utils.ApiUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateStudy extends ApiUtils {
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		httpReq.auth().oauth2(authToken);
		httpReq.contentType("application/json");
	}
	
	public String request_Body_Builder(boolean normal, boolean auto,String pId, int gen, int intDStatus, String uploaderStr,String acSite,String caseStatus) throws IOException, ParseException 
	{
		String payLoad="";
		if(normal)
		{
			payLoad="/src/test/java/com/mdp/api/modals/CreateStudy2.json";
		}else
		{
			payLoad="/src/test/java/com/mdp/api/modals/CreateStudy.json";

		}
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		JSONObject jObj_Patient=(JSONObject) jObj.get("Patient");
		JSONObject jObj_PHistory=(JSONObject) jObj_Patient.get("History");
		jObj_Patient.replace("PatientId", pId);
		jObj_Patient.replace("Gender", gen);
		jObj_PHistory.replace("DiabeticStatus", intDStatus);
		jObj.replace("CreatedBy", uploaderStr);
		jObj.replace("Status", caseStatus);
		jObj.replace("AcqisitionSiteId", acSite);
		if(auto)
		{
			jObj.replace("ReviewPhase", 1);
		}else
		{
			jObj.replace("ReviewPhase", 0);
		}
		return jObj.toString();
		
	}
	
	public String request_Edit_Builder_Npr(int caseId,String pId, int gen, int intDStatus, String uploaderStr,String acSite,String caseStatus) throws ParseException, IOException
	{
		
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+"/src/test/java/com/visu/web/modals/CreateStudy2.json");
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		jObj.replace("Id", caseId);
		JSONArray jObj_SupplInfo=(JSONArray) jObj.get("SupplementaryInformations");
		((JSONObject) jObj_SupplInfo.get(0)).replace("StudyId", caseId);
		((JSONObject) jObj_SupplInfo.get(0)).replace("Id", caseId);
		JSONObject jObj_Patient=(JSONObject) jObj.get("Patient");
		JSONObject jObj_PHistory=(JSONObject) jObj_Patient.get("History");
		jObj_Patient.replace("PatientId", pId);
		jObj_Patient.replace("Gender", gen);
		jObj_PHistory.replace("DiabeticStatus", intDStatus);
		jObj.replace("CreatedBy", uploaderStr);
		jObj.replace("Status", caseStatus);
		jObj.replace("AcqisitionSiteId", acSite);
		return jObj.toString();
		
	}

	public String request_DeleteCase(int caseId,String uploaderStr,String acSite) throws ParseException, IOException
	{
		
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+"/src/test/java/com/visu/web/modals/CreateStudy2.json");
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		jObj.replace("Id", caseId);
		jObj.replace("Status", "8");
		JSONArray jObj_SupplInfo=(JSONArray) jObj.get("SupplementaryInformations");
		((JSONObject) jObj_SupplInfo.get(0)).replace("StudyId", caseId);
		((JSONObject) jObj_SupplInfo.get(0)).replace("Id", caseId);
		JSONObject jObj_Patient=(JSONObject) jObj.get("Patient");
		JSONObject jObj_PHistory=(JSONObject) jObj_Patient.get("History");
		jObj_Patient.replace("PatientId", "FailedCase");
		jObj.replace("CreatedBy", uploaderStr);
		jObj.replace("AcqisitionSiteId", acSite);
		return jObj.toString();
		
	}
	
	public void rejectCase(String baseUri,String deleteUri,String token,int caseId,String uploaderStr,String acSite) throws ParseException, IOException
	{
		RestAssured.baseURI = baseUri;
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, token);
		 String payload=request_DeleteCase(caseId, uploaderStr, acSite);
		 httpReq.body(payload);
		 Response res2 = httpReq.request(Method.POST,deleteUri);
		 Assert.assertEquals(res2.getStatusCode(), 200);
		 
		
	}
	
	public Response createCase(boolean normal,boolean auto,String baseUri,String authToken,String patId,String gen,String dStatus,String userString,String siteId) throws NumberFormatException, IOException, ParseException
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RestAssured.baseURI = baseUri;
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		String payload=request_Body_Builder(normal,auto,patId, Integer.parseInt(gen), Integer.parseInt(dStatus),userString, siteId,"2");
		httpReq.body(payload);
		Response res =null;
		if(auto)
		{	System.out.println("Running for the auto dr site");
			res = httpReq.request(Method.POST,"/StudyServiceApi/api/AutoDR/SendStudytoAutoDRService");	

			
		}else
		{
			System.out.println("Running for the Manual sire");
			res = httpReq.request(Method.POST,"/StudyServiceApi/api/AcquisitionCenter/CreateStudy");	

		}
	//res = httpReq.request(Method.POST,"/StudyServiceApi/api/AcquisitionCenter/CreateStudy");	
		Assert.assertEquals(res.getStatusCode(), 200);
		return res;
	}
	
	public void editCase(String uri,String authToken,int caseId,String pId, int gen, int dStatus, String userString, String siteId,String caseStatus) throws ParseException, IOException
	{
		System.out.println("Authenticating the case creatino using the auth:"+authToken +"for editing for the case :"+caseId);
		RestAssured.baseURI = uri;
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		request_Authenticate(httpReq, authToken);
		String payload=	request_Edit_Builder_Npr(caseId, pId, gen, dStatus, userString, siteId,caseStatus);
		httpReq.body(payload);
		Response res = httpReq.request(Method.POST,"/StudyServiceApi/api/AcquisitionCenter/CreateStudy");	
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	
	
	
}
