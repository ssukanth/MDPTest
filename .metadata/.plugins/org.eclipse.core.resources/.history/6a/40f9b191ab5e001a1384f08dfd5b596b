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

public class MDPSeriesService extends ApiUtils {
	
	private String SERIESID="id";
	private String MODALITY="modality";
	private String SERIESINSTANCEUID = "seriesInstanceUID";
	private String SERIESIMPRESSIONS = "impressions";
	private String SERIESADDITIONALINFO = "additionalInfo";
	private String SERIESPERFORMEDSTEPID = "performedStepId";
	private String SERIESSCHEDULEDSTEPSID = "scheduledStepsIds[0]";
	private String CREATEDDATETIME = "createdDateTime";
	
	
	public final String getSERIESID() {
		return SERIESID;
	}
	
	public final String getMODALITY() {
		return MODALITY;
	}

	public final String getSERIESINSTANCEUID() {
		return SERIESINSTANCEUID;
	}

	public final String getSERIESIMPRESSIONS() {
		return SERIESIMPRESSIONS;
	}

	public final String getSERIESADDITIONALINFO() {
		return SERIESADDITIONALINFO;
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
	
	public final JSONObject getMdpSeriesServiceEndpoints() {
		return mdpSeriesServiceEndpoints;
	}

	
	JSONObject mdpSeriesServiceEndpoints=(JSONObject)credentialJson.get("seriesservice");
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		
		httpReq.auth().oauth2(authToken);
		httpReq.contentType("application/json");
		test.get().log(Status.DEBUG, "Authenticated the request with auth: "+authToken);
		exeData.add("AuthToken = "+authToken);
	}

	public  String  createSeries_Body_Builder(Map<String, Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/Series.json";
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
	
	public  String  editSeries_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/Series.json";
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
	
	
	public Response postCreateSeries(boolean defVals, String patId, String studId, Map<String, Object> alterVal) throws IOException, ParseException
	{
		RestAssured.useRelaxedHTTPSValidation();
		Map<String, Object>m2=null;
		
		if(defVals)
		{
			alterVal.put("SERIESINSTANCEUID", "Id#"+getDateString());
		}
		
		String payload=createSeries_Body_Builder(alterVal);
		RestAssured.baseURI = (String) credentialJson.get("baseuri");
		System.out.println("The Base uri is: "+(String) credentialJson.get("baseuri"));
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		httpReq.contentType("application/json");
		httpReq.body(payload);
		exeData.add("Payload: "+payload);
		System.out.println("The end point is: "+(String)mdpSeriesServiceEndpoints.get("createseries"));
		String effEnd=((String)mdpSeriesServiceEndpoints.get("createseries")).replace("patientId", patId).replace("studyId", studId);
		exeData.add("Endpoint: "+effEnd);
		Response res=httpReq.request(Method.POST, effEnd);
		System.out.println("The response for POST create series is: ");
		System.out.println(res.asString());
		exeData.add("Response: "+res.asString());
		return res;
	}
	
	public Response get_AllSeries(String patId, String studId, Map<String,String>qParams)
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		System.out.println("The end point is: "+(String)mdpSeriesServiceEndpoints.get("createseries"));
		String effEnd=((String)mdpSeriesServiceEndpoints.get("getallseries")).replace("patientId", patId).replace("studyId", studId);
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
	
	public void checkRecordsInGetAllSeriesResponse(String attrName, Response res, List<String>l) throws Exception
	{
		List<String>listOfSeriesIds=null;
		
		JSONParser jp=new JSONParser();
		//JSONObject jHead=(JSONObject)(jp.parse(res.getHeader("x-pagination")));
		
		//test.get().log(Status.DEBUG, "The header of the response is: "+jHead.toJSONString());
		//test.get().log(Status.DEBUG, "Total Number of pages for search: "+jHead.get("totalPages"));
		//String nextLink=(String)jHead.get("nextPageLink");
		List<String>l2=new ArrayList<String>();
		
		mainloop:while(l.size()!=0 )
		{
			listOfSeriesIds=res.jsonPath().getList(attrName);
			test.get().log(Status.DEBUG, "The size of the return list is: "+listOfSeriesIds.size());

			for(int i=0;i<l.size();i++)
			{
				System.out.println("The listOfSeriesIds: "+listOfSeriesIds);
				System.out.println("Whether Array list or string: "+l.get(i));
				if(listOfSeriesIds.contains(l.get(i))) {
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
	
	public Response getSeriesById(String patId, String studId, String serId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpSeriesServiceEndpoints.get("getseries")).replace("patientId", patId).replace("studyId", studId).replace("id", serId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point "+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		test.get().log(Status.DEBUG, "The res is:\n"+res.asString());
		exeData.add("The res is:\n"+res.asString());
		return res;
		
	}
	
	public Response postEditSeriesDetails(String patId, String studId, String serId, Map<String, Object> alterVal) throws IOException, ParseException
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpSeriesServiceEndpoints.get("editseries")).replace("patientId", patId).replace("studyId", studId).replace("id", serId);
		exeData.add("\nEffective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point"+effEnd);
		//httpReq.queryParam("id", sId);
		String payLoad=editSeries_Body_Builder(alterVal);
		httpReq.body(payLoad);
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The response for edit Series is :\n"+res.asString());
		test.get().log(Status.DEBUG, "The response for edit Series is :\n"+res.asString());
		return res;
	}

}
