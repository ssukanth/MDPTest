package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import java.lang.reflect.*;

public class MDPPatientService extends ApiUtils {
	private String ENTITYID="id";
	private String PATIENTID="patientBasicInfo.patientId";
	private String PATIENTPHONE="patientBasicInfo.contactDetails.phoneNumber";
	private String PATIENTEMAIL="patientBasicInfo.contactDetails.email";
	private String DOB="patientBasicInfo.dateOfBirth";
	private String SEX="patientBasicInfo.sex";
	private String GIVENNAME="patientBasicInfo.patientName.givenName";
	private String FAMILYNAME="patientBasicInfo.patientName.familyName";
	private String GIVENNAMEIDO="patientBasicInfo.patientName.givenNameIdeographic";
	private String FAMILYNAMEIDO="patientBasicInfo.patientName.familyNameIdeographic";
	private String GIVENNAMEPH="patientBasicInfo.patientName.givenNamePhonetic";
	private String FAMILYNAMEPH="patientBasicInfo.patientName.familyNamePhonetic";
	private String APPTYPE="extendedPatient[0].applicationType";
	private String PATIENTSPECIFICINFO="extendedPatient[0].patientSpecificInfo";
	private String ISSUEROFPATIENTID="patientBasicInfo.issuerOfPatientId";
	
	
	public final String getISSUEROFPATIENTID() {
		return ISSUEROFPATIENTID;
	}
	public final String getPATIENTSPECIFICINFO() {
		return PATIENTSPECIFICINFO;
	}

	public final String getAPPTYPE() {
		return APPTYPE;
	}

	public final String getENTITYID() {
		return ENTITYID;
	}

	public final String getPATIENTID() {
		return PATIENTID;
	}

	public final String getPATIENTPHONE() {
		return PATIENTPHONE;
	}

	public final String getPATIENTEMAIL() {
		return PATIENTEMAIL;
	}

	public final String getDOB() {
		return DOB;
	}

	public final String getSEX() {
		return SEX;
	}

	public final String getGIVENNAME() {
		return GIVENNAME;
	}

	public final String getFAMILYNAME() {
		return FAMILYNAME;
	}

	public final String getGIVENNAMEIDO() {
		return GIVENNAMEIDO;
	}

	public final String getFAMILYNAMEIDO() {
		return FAMILYNAMEIDO;
	}

	public final String getGIVENNAMEPH() {
		return GIVENNAMEPH;
	}

	public final String getFAMILYNAMEPH() {
		return FAMILYNAMEPH;
	}

	public final JSONObject getMdpPatientServiceEndpoints() {
		
		return mdpPatientServiceEndpoints;
	}

	
	JSONObject mdpPatientServiceEndpoints=(JSONObject)credentialJson.get("patientservice");
	
	public void request_Authenticate(RequestSpecification httpReq,String authToken)
	{
		
		httpReq.auth().oauth2(authToken);
		httpReq.contentType("application/json");
		test.get().log(Status.DEBUG, "Authenticated the request with auth:"+authToken);
		exeData.add("AuthToken = "+authToken);
	}
	
	public  String  createPatient_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/Patient.json";
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
	
	public  String  createPatient_Invalid_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/InvalidPatient.json";
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
	
	public  String  editPatient_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/EditPatient.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		System.out.println("The values to be changed :"+alterVal);
	if(alterVal!=null)
		{
			payL=changePayloadAttrVal(jObj, alterVal);
		}
		//return jObj.toString();
		return payL;
	}
	
	
	public Response postCreatePatient(boolean defVals,String acId,String conflict,Map<String,Object> alterVal) throws IOException, ParseException
	{
		Map<String ,Object>m2=null;
		if(defVals)
			
		{

			alterVal.put(PATIENTID, "Id#"+getDateString());
		}
		String payload=createPatient_Body_Builder(alterVal);
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		httpReq.queryParam("conflictValidate", conflict);
		test.get().log(Status.DEBUG, "The Payload is :"+payload);
		httpReq.body(payload);
		System.out.println("The end point is :"+(String)mdpPatientServiceEndpoints.get("createpatient"));
		String effEnd=((String)mdpPatientServiceEndpoints.get("createpatient")).replace("accountId", acId);
		exeData.add("Endpoint:"+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		exeData.add("Payload:"+payload);
		Response res=httpReq.request(Method.POST,effEnd);
		System.out.println("The resonse for post create patient is :");
		System.out.println(res.asString());
		exeData.add("Response:"+res.asString());
		return res;
	}
	
	public Response postCreatePatientInvalid(boolean defVals,String acId,String conflict,Map<String,Object> alterVal) throws IOException, ParseException
	{
		Map<String ,Object>m2=null;
		if(defVals)
			
		{

			alterVal.put(PATIENTID, "Id#"+getDateString());
		}
		String payload=createPatient_Invalid_Body_Builder(alterVal);
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		httpReq.queryParam("conflictValidate", conflict);
		test.get().log(Status.DEBUG, "The Payload is :"+payload);
		httpReq.body(payload);
		System.out.println("The end point is :"+(String)mdpPatientServiceEndpoints.get("createpatient"));
		String effEnd=((String)mdpPatientServiceEndpoints.get("createpatient")).replace("accountId", acId);
		exeData.add("Endpoint:"+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		exeData.add("Payload:"+payload);
		Response res=httpReq.request(Method.POST,effEnd);
		System.out.println("The resonse for post create patient is :");
		System.out.println(res.asString());
		exeData.add("Response:"+res.asString());
		return res;
	}
	
	public Response get_AllPatients(String acId,Map<String,String>qParams)
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		System.out.println("The end point is :"+(String)mdpPatientServiceEndpoints.get("createpatient"));
		String effEnd=((String)mdpPatientServiceEndpoints.get("getpatients")).replace("accountId", acId);
		exeData.add("Endpoint:"+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		if(qParams!=null) {
			System.out.println("We have the query paramas");
			for(Map.Entry<String, String>e:qParams.entrySet())
			{
				httpReq.queryParam(e.getKey(), e.getValue());
			}
		}
		
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The respnse is :"+res.asString());
		test.get().log(Status.DEBUG, "The res is :\n"+res.asString());
		return res;
		
	}
	
	public void checkRecordsInGetAllPatientResponse(String attrName,Response res,List<String>l) throws Exception
	{
		List<String>listOfPatIds=null;
		JSONParser jp=new JSONParser();
		JSONObject jHead=(JSONObject)(jp.parse(res.getHeader("x-pagination")));
		test.get().log(Status.DEBUG, "The header of the response is "+jHead.toJSONString());
		test.get().log(Status.DEBUG, "Totla Number of pages for search: "+jHead.get("totalPages"));
		String nextLink=(String)jHead.get("nextPageLink");
		List<String>l2=new ArrayList<String>();
	mainloop:while(l.size()!=0 )
		{
			listOfPatIds=res.jsonPath().getList(attrName);
			test.get().log(Status.DEBUG, "The size of the return list is :"+listOfPatIds.size());

			for(int i=0;i<l.size();i++)
				{
				System.out.println("The listofpats:"+listOfPatIds);
				System.out.println("Whether Array list or string: "+l.get(i));
				if(listOfPatIds.contains(l.get(i))) {
					l2.add(l.get(i));
					System.out.println("Record found: "+l.get(i));
					test.get().log(Status.DEBUG, "Record found: "+l.get(i));
				}
			}
			l.removeAll(l2);
			if(nextLink==null) break mainloop;
			test.get().log(Status.DEBUG, "The url of the next link is :"+nextLink);
			exeData.add("The url of the next link is :"+nextLink);
			RequestSpecification hReq=RestAssured.given().log().all();
			res=hReq.request(Method.GET,nextLink.replace("http", "https"));
			hReq=null;
			nextLink=null;
			System.out.println(res.getHeaders());
			jHead=(JSONObject)(jp.parse(res.getHeader("x-Pagination")));
			test.get().log(Status.DEBUG, "Searching in Current PageNumber: "+jHead.get("currentPage"));
			test.get().log(Status.DEBUG, "The header of the response is "+jHead.toJSONString());
			nextLink=(String)jHead.get("nextPageLink");
			
			
		}
		test.get().log(Status.DEBUG, "The record removed and res list is:"+l);
		
		if(l.size()>0)
		{
			throw new Exception ("The records"+l.toString()+"were not found");
		}
	}
	
	public Response getPatientById(String acId,String patEntityId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpPatientServiceEndpoints.get("getpatient")).replace("accountId", acId).replace("id", patEntityId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit"+httpReq.toString()+"with effective end point"+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		test.get().log(Status.DEBUG, "The res is :\n"+res.asString());
		exeData.add("The res is :\n"+res.asString());
		return res;
		
	}
	
	public Response putEditPatientDetails(String acId,String eId,Map<String,Object> alterVal) throws IOException, ParseException
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpPatientServiceEndpoints.get("putpatient")).replace("accountId", acId);
		exeData.add("\nEffective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit"+httpReq.toString()+"with effective end point"+effEnd);
		httpReq.queryParam("id", eId);
		String payLoad=editPatient_Body_Builder(alterVal);
		exeData.add("The Payload for Put: "+payLoad);
		test.get().log(Status.DEBUG, "The Payload for Put: "+payLoad);
		httpReq.body(payLoad);
		Response res=httpReq.request(Method.PUT,effEnd);
		System.out.println("the Response is :"+res.asString());
		exeData.add("The response for put patient is :\n"+res.asString());
		test.get().log(Status.DEBUG, "The response for put patient is :\n"+res.asString());
		return res;
	}

}
