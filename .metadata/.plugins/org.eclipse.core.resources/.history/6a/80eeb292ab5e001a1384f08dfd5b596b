package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class AdminUserService_Mdpapps extends ApiUtils {
	
	JSONObject mdpAdminUserService_MDPApps=(JSONObject)(((Map)credentialJson.get("adminuserservice")).get("mdpapps"));

	private final String NAME="name";
	private final String CONFIGURATION="configuration";
	private final String ZEISSIDCONFIGURATION="zeissIdConfiguration";
	private final String CLIENTID="zeissIdConfiguration[0].ClientId";
	private final String RESMDPID="mdpappId";
	private final String RESNAME="name";
	private final String RESZIESSID="zeissIdConfiguration[0].ClientId";
	private final String RESGETLL_NAME="items[0].name";
	private final String RESGETMDPAPP_NAME="name";
			
	

	public final JSONObject getMdpAdminUserService_MDPApps() {
		return mdpAdminUserService_MDPApps;
	}

	public final String getRESGETMDPAPP_NAME() {
		return RESGETMDPAPP_NAME;
	}

	public final String getRESGETLL_NAME() {
		return RESGETLL_NAME;
	}

	public final String getCLIENTID() {
		return CLIENTID;
	}

	public final String getRESMDPID() {
		return RESMDPID;
	}

	public final String getRESNAME() {
		return RESNAME;
	}

	public final String getRESZIESSID() {
		return RESZIESSID;
	}

	public final String getNAME() {
		return NAME;
	}

	public final String getCONFIGURATION() {
		return CONFIGURATION;
	}

	public final String getZEISSIDCONFIGURATION() {
		return ZEISSIDCONFIGURATION;
	}

	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		httpReq.header(
	              "Authorization",
	              "Bearer " + authToken);
		httpReq.contentType("application/json");
	             
	}
	
	private  String  createApp_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/AdminUserService_MDPApp.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.AdminUserService_Mdpapps").newInstance();
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
	
	private  String  editApp_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/AdminUserService_MDPApp_Edit.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.AdminUserService_Mdpapps").newInstance();
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
		}else
		{
			payL=jObj.toString();
		}
		return payL;
	}
	
	public Response post_CreateMDPApp(boolean defName,boolean defClid,String authToken,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
		if(defName)
		{
			
			String nam="zeiss0719+"+genCurDateString();
			test.get().log(Status.DEBUG, "Creating the app with the default name"+nam);
			alterVals.put("NAME", nam);
		}
		if(defClid)
		{
			String effClientId="9ec53cca-baad-"+getYearString()+"-b"+getDayString()+"c-6ff3c"+getHourString()+"b"+getMinString()+getSecString();
			alterVals.put("CLIENTID", effClientId);	
			test.get().log(Status.DEBUG, "Creating the app with the default CleintId"+effClientId);
		}
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=createApp_Body_Builder(alterVals);
		System.out.println(mdpAdminUserService_MDPApps.get("createapp"));
		String effEnd=((String)mdpAdminUserService_MDPApps.get("createapp"));
		exeData.add("\nThe Effective end point is :"+effEnd);
		exeData.add("\n payload"+payload);
		test.get().log(Status.DEBUG, "The Effective end point is :"+effEnd);
		test.get().log(Status.DEBUG, "Created users with the payload"+payload);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		res = httpReq.request(Method.POST,effEnd);
		exeData.add("\n Response Code:"+res.getStatusCode());
		exeData.add("\nResponse:"+res.asString());
		test.get().log(Status.DEBUG, "\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\nResponse:"+res.asString());
		System.out.println("\nResponse:"+res.asString());
		return res;
	}
	
	
	public Response get_AllApps(String atn,String zId)
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, atn);
		System.out.println("The end point is :"+(String)mdpAdminUserService_MDPApps.get("getapps"));
		String effEnd=((String)mdpAdminUserService_MDPApps.get("getapps"));
		if(zId!=null) {
			test.get().log(Status.DEBUG, "The QueryParams for Update are :"+zId);
			System.out.println("We have the query paramas");
			httpReq.queryParam("ZeissId", zId);
			test.get().log(Status.DEBUG, "The Effective Endointwith qParam is :"+effEnd+"?ZeissId="+zId);
			exeData.add("\nThe Effective Endointwith qParam is :"+effEnd+"?ZeissId="+zId);
		}else
		{
			test.get().log(Status.DEBUG, "There Are no query params for updating");
			exeData.add("Endpoint:"+effEnd);
			test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		}
		
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The respnse is :"+res.asString());
		test.get().log(Status.DEBUG, "The res is :\n"+res.asString());
		return res;
		
	}
	
	
	public void checkRecordsInGetAllApps(String atn,String attrName,Response res,List<String>l) throws Exception
	{
		List<String>listOfPatIds=null;
		JSONParser jp=new JSONParser();
		JSONObject jHead=(JSONObject)(jp.parse(res.getHeader("x-pagination")));
		test.get().log(Status.DEBUG, "The Attribute For checking Getting In Respnse:"+attrName);
		test.get().log(Status.DEBUG, "The List of Items for search"+l.toString());
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
			request_Authenticate(hReq, atn);
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
	
	public Response getApp(String atn,String mdpId)	
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, atn);
		System.out.println("The end point is :"+(String)mdpAdminUserService_MDPApps.get("getapp"));
		String effEnd=((String)mdpAdminUserService_MDPApps.get("getapp"));
		if(mdpId!=null)
		{
			test.get().log(Status.DEBUG, "The QueryParams for Update are :"+mdpId);
			System.out.println("We have the query paramas");
			effEnd=effEnd+"/"+mdpId;
				
		}
		else
		{
			test.get().log(Status.DEBUG, "There Are no path params for updating");
		}
		exeData.add("Endpoint:"+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The respnse is :"+res.asString());
		test.get().log(Status.DEBUG, "The res is :\n"+res.asString());
		return res;

		
	}
	
	
	public Response put_EditMDPApp(String authToken,String mdpAppId,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=editApp_Body_Builder(alterVals);
		System.out.println(mdpAdminUserService_MDPApps.get("putapp"));
		String effEnd=((String)mdpAdminUserService_MDPApps.get("putapp"));
		if(mdpAppId!=null)
		{
			test.get().log(Status.DEBUG, "The QueryParams for Update are :"+mdpAppId);
			System.out.println("We have the query paramas");
			effEnd=effEnd+"/"+mdpAppId;
			
				
		}
		else
		{
			test.get().log(Status.DEBUG, "There Are no path params for updating");
		}
		
		exeData.add("\nThe Effective end point is :"+effEnd);
		exeData.add("\n payload"+payload);
		test.get().log(Status.DEBUG, "The Effective end point is :"+effEnd);
		test.get().log(Status.DEBUG, "Created users with the payload"+payload);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		exeData.add((String)credentialJson.get("createUser"));
		res = httpReq.request(Method.PUT,effEnd);
		exeData.add("\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\nResponse:"+res.asString());
		System.out.println("\nResponse:"+res.asString());
		return res;
	}
	


}
