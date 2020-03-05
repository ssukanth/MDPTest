package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.selenium.utils.ApiUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MDPReportService extends ApiUtils {
	
JSONObject mdpPatientServiceEndpoints=(JSONObject)credentialJson.get("reportservice");
	
private final String CONTENT="content";
private final String TAG="tag";
private final String ADDITIONALINFO="additionalInfo";
private final String REPORTENTITYID="id";
private final String REFENTITYID="referencedUID";
private final String CREATEDAT="createdAt";
private final String CREATEDBy="createdBy";




	
public final String getCREATEDBy() {
	return CREATEDBy;
}

public final JSONObject getMdpPatientServiceEndpoints()
{
	return mdpPatientServiceEndpoints;
}



public final String getCONTENT() 
{
	return CONTENT;
}



public final String getTAG() 
{
	return TAG;
}



public final String getADDITIONALINFO()
{
	return ADDITIONALINFO;
}



public final String getREPORTENTITYID() 
{
	return REPORTENTITYID;
}



public final String getREFENTITYID()
{
	return REFENTITYID;
}



public final String getCREATEDAT()
{
	return CREATEDAT;
}



	public  String  createReport_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/Reports.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.MDPReportService").newInstance();
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
	
	public Response postReport(String reportLevel,String entityId,Map<String,Object>alterVals) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ParseException
	{
		String baseUri=(String)credentialJson.get("baseuri");
		test.get().log(Status.DEBUG, "The Uri is:"+baseUri);
		RequestSpecification httpReq=createReq(baseUri);
		String endPoint="";
		switch(reportLevel.toLowerCase())
		{
		case "study": endPoint=((String) mdpPatientServiceEndpoints.get("createreport_study")).replace("EntityId", entityId);
			
						break;
		case "series": endPoint=((String) mdpPatientServiceEndpoints.get("createreport_series")).replace("EntityId", entityId);
						break;
		case "exam": endPoint=((String) mdpPatientServiceEndpoints.get("createreport_exam")).replace("EntityId", entityId);
						break;
		}
		exeData.add("\nEffective End Point:"+endPoint);
		test.get().log(Status.DEBUG, "The Effective End Point is :"+endPoint);
		String payLoad =createReport_Body_Builder(alterVals);
		exeData.add("\nPayload:"+payLoad);
		httpReq.body(payLoad);
		Response res=httpReq.request(io.restassured.http.Method.POST,endPoint);
		test.get().log(Status.DEBUG, "The Response of the post report:\n"+res.asString());
		exeData.add("\nThe Response is :"+res.asString());
		return res;
	}

	public Response getAllReports(String reportLevel,String entityId, String createdAt)
	{
		String baseUri=(String)credentialJson.get("baseuri");
		test.get().log(Status.DEBUG, "The Uri is:"+baseUri);
		RequestSpecification httpReq=createReq(baseUri);
		String endPoint="";
		switch(reportLevel.toLowerCase())
		{
		case "study": endPoint=((String) mdpPatientServiceEndpoints.get("getallreports_study")).replace("EntityId", entityId);
			
						break;
		case "series": endPoint=((String) mdpPatientServiceEndpoints.get("getallreports_series")).replace("EntityId", entityId);
						break;
		case "exam": endPoint=((String) mdpPatientServiceEndpoints.get("getallreports_exam")).replace("EntityId", entityId);
						break;
		}
		exeData.add("\nEffective End Point:"+endPoint);
		test.get().log(Status.DEBUG, "The Effective End Point is :"+endPoint);
		exeData.add("\n The Query Param:"+createdAt);
		test.get().log(Status.DEBUG, "The Query param is:"+createdAt);
		if(createdAt!=null || createdAt!="")httpReq.queryParam("CreatedAt", createdAt);
		Response res=httpReq.request(io.restassured.http.Method.GET,endPoint);
		exeData.add("\nThe Response is :"+res.asString());
		test.get().log(Status.DEBUG, "The Response is :"+res.asString());
		return res;

	}
	
	public Response deleteAllReports(String reportLevel,String entityId)
	{
		String baseUri=(String)credentialJson.get("baseuri");
		RequestSpecification httpReq=createReq(baseUri);
		String endPoint="";
		switch(reportLevel.toLowerCase())
		{
		case "study": endPoint=((String) mdpPatientServiceEndpoints.get("getallreports_study")).replace("EntityId", entityId);
			
						break;
		case "series": endPoint=((String) mdpPatientServiceEndpoints.get("getallreports_series")).replace("EntityId", entityId);
						break;
		case "exam": endPoint=((String) mdpPatientServiceEndpoints.get("getallreports_exam")).replace("EntityId", entityId);
						break;
		}
		exeData.add("\nEffective End Point:"+endPoint);
		test.get().log(Status.DEBUG, "The Effective End Point is :"+endPoint);
		Response res=httpReq.request(io.restassured.http.Method.DELETE,endPoint);
		exeData.add("\nThe Response is :"+res.asString());
		test.get().log(Status.DEBUG, "The Response is :"+res.asString());
		return res;

	}
	
	public Response getReport(String reportLevel,String entityId,String reportId)
	{
		String baseUri=(String)credentialJson.get("baseuri");
		RequestSpecification httpReq=createReq(baseUri);
		String endPoint=null;
		switch(reportLevel.toLowerCase())
		{
		case "study":if(reportId!="")
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_study")).replace("EntityId", entityId)).replace("Reportid", reportId);
				
						}else
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_study")).replace("EntityId", entityId)).replace("/Reportid","");

						}
								
						break;
		case "series": if(reportId!="")
							{
								endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_series")).replace("EntityId", entityId)).replace("Reportid", reportId);
					
							}else
							{
								endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_series")).replace("EntityId", entityId)).replace("/Reportid","");
					
							}
						break;
		case "exam":if(reportId!="")
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_exam")).replace("EntityId", entityId)).replace("Reportid", reportId);
				
						}else
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_exam")).replace("EntityId", entityId)).replace("/Reportid","");
				
						} 
						break;
		}
		exeData.add("\nEffective End Point:"+endPoint);
		test.get().log(Status.DEBUG, "The Effective End Point is :"+endPoint);
		Response res=httpReq.request(io.restassured.http.Method.GET,endPoint);
		exeData.add("The Response is :"+res.asString());
		test.get().log(Status.DEBUG, "The Response is :"+res.asString());
		return res;
		
	}
	
	
	public Response deleteReport(String reportLevel,String entityId,String reportId)
	{
		String baseUri=(String)credentialJson.get("baseuri");
		RequestSpecification httpReq=createReq(baseUri);
		String endPoint=null;
		switch(reportLevel.toLowerCase())
		{
		case "study":if(reportId!="")
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_study")).replace("EntityId", entityId)).replace("Reportid", reportId);
				
						}else
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_study")).replace("EntityId", entityId)).replace("/Reportid","");

						}
								
						break;
		case "series": if(reportId!="")
							{
								endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_series")).replace("EntityId", entityId)).replace("Reportid", reportId);
					
							}else
							{
								endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_series")).replace("EntityId", entityId)).replace("/Reportid","");
					
							}
						break;
		case "exam":if(reportId!="")
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_exam")).replace("EntityId", entityId)).replace("Reportid", reportId);
				
						}else
						{
							endPoint=(((String) mdpPatientServiceEndpoints.get("getreport_exam")).replace("EntityId", entityId)).replace("/Reportid","");
				
						} 
						break;
		}
		
		exeData.add("\nEffective End Point:"+endPoint);
		test.get().log(Status.DEBUG, "The Effective End Point is :"+endPoint);
		Response res=httpReq.request(io.restassured.http.Method.DELETE,endPoint);
		exeData.add("The Response is :"+res.asString());
		test.get().log(Status.DEBUG, "The Response is :"+res.asString());
		return res;
		
	}
	
	
}
