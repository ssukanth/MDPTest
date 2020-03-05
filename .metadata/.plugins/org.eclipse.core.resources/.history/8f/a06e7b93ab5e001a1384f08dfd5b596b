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

public class MDPStudyService extends ApiUtils {
	
	private String STUDYID="id";
	private String APPTYPE="applicationType";
	private String STUDYINSTANCEUID = "studyInstanceUID";
	private String SERIESINSTANCEUID = "series[0].seriesInstanceUID";
	private String STUDYIMPRESSIONSCONTENTDESCRIPTION = "impressions[0].contentDesription";
	private String STUDYADDITIONALINFO = "additionalInfo";
	private String SERIES = "series";
	private String IMPRESSIONS = "impressions";
	private String REQUESTEDPROCEDUREID = "requestedProcedure.id";
	private String REQUESTEDPROCEDURESCHEDULEDSTEPSID = "requestedProcedure.scheduledSteps[0].id";
	private String SERIESPERFORMEDSTEPID = "series[0].performedStepId";
	private String SERIESSCHEDULEDSTEPSID = "series[0].scheduledStepsIds[0]";
	private String CREATEDDATETIME = "createdDateTime";
	
	
	public final String getSTUDYID() {
		return STUDYID;
	}
	
	public final String getAPPTYPE() {
		return APPTYPE;
	}

	public final String getSTUDYINSTANCEUID() {
		return STUDYINSTANCEUID;
	}

	public final String getSERIESINSTANCEUID() {
		return SERIESINSTANCEUID;
	}

	public final String getSTUDYIMPRESSIONSCONTENTDESCRIPTION() {
		return STUDYIMPRESSIONSCONTENTDESCRIPTION;
	}

	public final String getSTUDYADDITIONALINFO() {
		return STUDYADDITIONALINFO;
	}
	
	public final String getSERIES() {
		return SERIES;
	}
	
	public final String getIMPRESSIONS() {
		return IMPRESSIONS;
	}
	
	public final String getREQUESTEDPROCEDUREID(){
		return REQUESTEDPROCEDUREID;
	}
	
	public final String getREQUESTEDPROCEDURESCHEDULEDSTEPSID(){
		return REQUESTEDPROCEDURESCHEDULEDSTEPSID;
	}
	
	public final String getSERIESPERFORMEDSTEPID(){
		return SERIESPERFORMEDSTEPID;
	}
	
	public final String getSERIESSCHEDULEDSTEPSID(){
		return SERIESSCHEDULEDSTEPSID;
	}
	
	public final String getCREATEDDATETIME(){
		return CREATEDDATETIME;
	}
	
	public final JSONObject getMdpStudyServiceEndpoints() {
		return mdpStudyServiceEndpoints;
	}

	
	JSONObject mdpStudyServiceEndpoints=(JSONObject)credentialJson.get("studyservice");
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		
		httpReq.auth().oauth2(authToken);
		httpReq.contentType("application/json");
		test.get().log(Status.DEBUG, "Authenticated the request with auth:"+authToken);
		exeData.add("AuthToken = "+authToken);
	}

	public  String  createStudy_Body_Builder(Map<String, Object> alterVal) throws IOException, ParseException
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
	
	public  String  editStudy_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/EditStudy.json";
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
	
	
	public Response postCreateStudy(boolean defVals, String patId, Map<String, Object> alterVal) throws IOException, ParseException
	{
		RestAssured.useRelaxedHTTPSValidation();
		Map<String, Object>m2=null;
		
		if(defVals)
		{
			alterVal.put("STUDYINSTANCEUID", "Id#"+getDateString());
		}
		
		String payload=createStudy_Body_Builder(alterVal);
		RestAssured.baseURI = (String) credentialJson.get("baseuri");
		System.out.println("The Base uri is: "+(String) credentialJson.get("baseuri"));
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		httpReq.contentType("application/json");
		httpReq.body(payload);
		exeData.add("Payload: "+payload);
		System.out.println("The end point is: "+(String)mdpStudyServiceEndpoints.get("createstudy"));
		String effEnd=((String)mdpStudyServiceEndpoints.get("createstudy")).replace("patientId", patId);
		exeData.add("Endpoint: "+effEnd);
		Response res=httpReq.request(Method.POST, effEnd);
		System.out.println("The response for POST create study is: ");
		System.out.println(res.asString());
		exeData.add("Response: "+res.asString());
		return res;
	}
	
	public Response get_AllStudies(String patId, Map<String,String>qParams)
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		System.out.println("The end point is: "+(String)mdpStudyServiceEndpoints.get("createstudy"));
		String effEnd=((String)mdpStudyServiceEndpoints.get("getstudies")).replace("patientId", patId);
		exeData.add("Endpoint: "+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point: "+effEnd);
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
	
	public void checkRecordsInGetAllStudiesResponse(String attrName, Response res, List<String>l) throws Exception
	{
		List<String>listOfStudIds=null;
		
		JSONParser jp=new JSONParser();
		//JSONObject jHead=(JSONObject)(jp.parse(res.getHeader("x-pagination")));
		
		//test.get().log(Status.DEBUG, "The header of the response is: "+jHead.toJSONString());
		//test.get().log(Status.DEBUG, "Total Number of pages for search: "+jHead.get("totalPages"));
		//String nextLink=(String)jHead.get("nextPageLink");
		List<String>l2=new ArrayList<String>();
		
		mainloop:while(l.size()!=0 )
		{
			listOfStudIds=res.jsonPath().getList(attrName);
			test.get().log(Status.DEBUG, "The size of the return list is: "+listOfStudIds.size());

			for(int i=0;i<l.size();i++)
			{
				System.out.println("The listofStudIds: "+listOfStudIds);
				System.out.println("Whether Array list or string: "+l.get(i));
				if(listOfStudIds.contains(l.get(i))) {
					l2.add(l.get(i));
					System.out.println("Record found: "+l.get(i));
					test.get().log(Status.DEBUG, "Record found: "+l.get(i));
				}
			}
			l.removeAll(l2);
			/*
			//if(nextLink==null) break mainloop;
			//test.get().log(Status.DEBUG, "The url of the next link is: "+nextLink);
			exeData.add("The url of the next link is :"+nextLink);
			RequestSpecification hReq=RestAssured.given().log().all();
			res=hReq.request(Method.GET,nextLink.replace("http", "https"));
			hReq=null;
			nextLink=null;
			System.out.println(res.getHeaders());
			jHead=(JSONObject)(jp.parse(res.getHeader("x-Pagination")));
			test.get().log(Status.DEBUG, "Searching in Current PageNumber: "+jHead.get("currentPage"));
			test.get().log(Status.DEBUG, "The header of the response is: "+jHead.toJSONString());
			nextLink=(String)jHead.get("nextPageLink");
			*/
			
		}
		test.get().log(Status.DEBUG, "The record removed and res list is: "+l);
		
		if(l.size()>0)
		{
			throw new Exception ("The records "+l.toString()+" were not found");
		}
	}
	
	public Response getStudyById(String patId,String studEntityId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpStudyServiceEndpoints.get("getstudy")).replace("patientId", patId).replace("id", studEntityId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point "+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		test.get().log(Status.DEBUG, "The res is:\n"+res.asString());
		exeData.add("The res is:\n"+res.asString());
		return res;
		
	}
	
	public Response postEditStudyDetails(String patId, String sId, Map<String, Object> alterVal) throws IOException, ParseException
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpStudyServiceEndpoints.get("editstudy")).replace("patientId", patId).replace("id", sId);
		exeData.add("\nEffective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit"+httpReq.toString()+"with effective end point"+effEnd);
		//httpReq.queryParam("id", sId);
		String payLoad=editStudy_Body_Builder(alterVal);
		httpReq.body(payLoad);
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The response for edit Study is :\n"+res.asString());
		test.get().log(Status.DEBUG, "The response for edit Study is :\n"+res.asString());
		return res;
	}

}
