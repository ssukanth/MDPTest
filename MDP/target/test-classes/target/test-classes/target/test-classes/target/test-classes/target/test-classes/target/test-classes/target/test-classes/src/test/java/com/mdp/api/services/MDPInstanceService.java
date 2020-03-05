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

public class MDPInstanceService extends ApiUtils {
	
	private String INSTANCEID="id";
	private String INSTANCEUID = "InstanceUID";
	private String SERIESKEY = "seriesKey";
	private String SOPCLASSUID = "sopClassUid";
	private String BULKDATA = "bulkData";
	private String FRAMENUMBER = "bulkData[0].frameNumber";
	private String DATAURL = "bulkData[0].dataURL";
	private String THUMBNAILICON = "bulkData[0].thumbnailIcon";
	private String IMAGELATERALITY = "imageLaterality";
	private String ADDITIONALINFORMATION = "additionalInformation";
	private String OBSERVATIONDTO = "observationDto";
	private String CREATEDDATETIME = "createdDateTime";
	
	
	public final String getINSTANCEID() {
		return INSTANCEID;
	}
	
	public final String getINSTANCEUID() {
		return INSTANCEUID;
	}

	public final String getSERIESKEY() {
		return SERIESKEY;
	}

	public final String getSOPCLASSUID() {
		return SOPCLASSUID;
	}
	
	public final String getBULKDATA() {
		return BULKDATA;
	}

	public final String getFRAMENUMBER() {
		return FRAMENUMBER;
	}

	public final String getDATAURL() {
		return DATAURL;
	}
	
	public final String getTHUMBNAILICON() {
		return THUMBNAILICON;
	}
	
	public final String getADDITIONALINFORMATION(){
		return ADDITIONALINFORMATION;
	}
	
	public final String getIMAGELATERALITY(){
		return IMAGELATERALITY;
	}
	
	public final String getOBSERVATIONDTO(){
		return OBSERVATIONDTO;
	}
	
	public final String getCREATEDDATETIME(){
		return CREATEDDATETIME;
	}
	
	public final JSONObject getMdpInstanceServiceEndpoints() {
		return mdpInstanceServiceEndpoints;
	}

	
	JSONObject mdpInstanceServiceEndpoints=(JSONObject)credentialJson.get("instanceservice");
	
	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		
		httpReq.auth().oauth2(authToken);
		httpReq.contentType("application/json");
		test.get().log(Status.DEBUG, "Authenticated the request with auth:"+authToken);
		exeData.add("AuthToken = "+authToken);
	}

	public  String  createInstance_Body_Builder(Map<String, Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/Instance.json";
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
	
	public  String  editInstance_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/EditInstance.json";
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
	
	
	public Response postCreateInstance(boolean defVals, String studId, Map<String, Object> alterVal) throws IOException, ParseException
	{
		RestAssured.useRelaxedHTTPSValidation();
		Map<String, Object>m2=null;
		
		if(defVals)
		{
			alterVal.put("INSTANCEUID", "Id#"+getDateString());
		}
		
		String payload=createInstance_Body_Builder(alterVal);
		RestAssured.baseURI = (String) credentialJson.get("baseuri");
		System.out.println("The Base uri is: "+(String) credentialJson.get("baseuri"));
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		httpReq.contentType("application/json");
		httpReq.body(payload);
		exeData.add("Payload: "+payload);
		System.out.println("The end point is: "+(String)mdpInstanceServiceEndpoints.get("createinstance"));
		String effEnd=((String)mdpInstanceServiceEndpoints.get("createinstance")).replace("studyId", studId);
		exeData.add("Endpoint: "+effEnd);
		Response res=httpReq.request(Method.POST, effEnd);
		System.out.println("The response for POST create Instance is: ");
		System.out.println(res.asString());
		exeData.add("Response: "+res.asString());
		return res;
	}
	
	public Response get_AllInstances(String studId, Map<String,String>qParams)
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		System.out.println("The end point is: "+(String)mdpInstanceServiceEndpoints.get("createinstance"));
		String effEnd=((String)mdpInstanceServiceEndpoints.get("getinstances")).replace("studyId", studId);
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
	
	public void checkRecordsInGetAllInstancesResponse(String attrName, Response res, List<String>l) throws Exception
	{
		List<String>listOfInstIds=null;
		
		JSONParser jp=new JSONParser();
		//JSONObject jHead=(JSONObject)(jp.parse(res.getHeader("x-pagination")));
		
		//test.get().log(Status.DEBUG, "The header of the response is: "+jHead.toJSONString());
		//test.get().log(Status.DEBUG, "Total Number of pages for search: "+jHead.get("totalPages"));
		//String nextLink=(String)jHead.get("nextPageLink");
		List<String>l2=new ArrayList<String>();
		
		mainloop:while(l.size()!=0 )
		{
			listOfInstIds=res.jsonPath().getList(attrName);
			test.get().log(Status.DEBUG, "The size of the return list is: "+listOfInstIds.size());

			for(int i=0;i<l.size();i++)
			{
				System.out.println("The listofStudIds: "+listOfInstIds);
				System.out.println("Whether Array list or string: "+l.get(i));
				if(listOfInstIds.contains(l.get(i))) {
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
	
	public Response getInstanceById(String studId,String instId)
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpInstanceServiceEndpoints.get("getinstance")).replace("studyId", studId).replace("id", instId);
		exeData.add("Effective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit "+httpReq.toString()+" with effective end point "+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		test.get().log(Status.DEBUG, "The res is:\n"+res.asString());
		exeData.add("The res is:\n"+res.asString());
		return res;
		
	}
	
	public Response postEditInstanceDetails(String studId, String instId, Map<String, Object> alterVal) throws IOException, ParseException
	{
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		String effEnd=((String)mdpInstanceServiceEndpoints.get("editinstance")).replace("studyId", studId).replace("id", instId);
		exeData.add("\nEffective End Point: "+effEnd);
		test.get().log(Status.DEBUG, "The url trying to hit"+httpReq.toString()+"with effective end point"+effEnd);
		//httpReq.queryParam("id", sId);
		String payLoad=editInstance_Body_Builder(alterVal);
		httpReq.body(payLoad);
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The response for edit Instance is :\n"+res.asString());
		test.get().log(Status.DEBUG, "The response for edit Instance is :\n"+res.asString());
		return res;
	}

}
