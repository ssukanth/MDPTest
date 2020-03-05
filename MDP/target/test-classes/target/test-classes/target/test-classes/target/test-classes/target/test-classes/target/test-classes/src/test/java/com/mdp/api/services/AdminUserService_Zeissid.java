package com.mdp.api.services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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

public class AdminUserService_Zeissid extends ApiUtils {
	JSONObject mdpAdminUserService_Zeissid=(JSONObject)(((Map)credentialJson.get("adminuserservice")).get("zid"));

	private final String  CLIENTID="zeissIdConfiguration.ClientId";
	private final String  APICLIENTID="zeissIdConfiguration.ApiClientId";
	private final String  ZEISSIDCONFIGURATION="zeissIdConfiguration";
	
	public final String getZEISSIDCONFIGURATION() {
		return ZEISSIDCONFIGURATION;
	}

	public final JSONObject getMdpAdminUserService_Zeissid() {
		return mdpAdminUserService_Zeissid;
	}

	public final String getCLIENTID() {
		return CLIENTID;
	}

	public final String getAPICLIENTID() {
		return APICLIENTID;
	}

	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
		httpReq.header(
	              "Authorization",
	              "Bearer " + authToken);
		httpReq.contentType("application/json");
	             
	}
	
	private  String  createZeissId_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/AdminUserService_ZeissId.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.AdminUserService_Zeissid").newInstance();
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
	
	private  String  editZeissId_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/AdminUserService_ZeissId.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.AdminUserService_Zeissid").newInstance();
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
	
	public Response post_CreateZeissId(boolean defClid,String mdpAppId,String authToken,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
		if(defClid)
		{
			String effClientId="9ec53cca-baad-"+getYearString()+"-b"+getDayString()+"c-6ff3c"+getHourString()+"b"+getMinString()+getSecString();
			alterVals.put("CLIENTID", effClientId);
			test.get().log(Status.DEBUG, "Creating the app with the default CleintId"+effClientId);
		}
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=createZeissId_Body_Builder(alterVals);
		System.out.println(mdpAdminUserService_Zeissid.get("createid"));
		String effEnd=((String)mdpAdminUserService_Zeissid.get("createid")).replace("mdpappid", mdpAppId);
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
	
	
	
	public Response getZeissId(String atn,String mdpId,String zid)	
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, atn);
		System.out.println("The end point is :"+(String)mdpAdminUserService_Zeissid.get("getid"));
		String effEnd=(((String)mdpAdminUserService_Zeissid.get("putid")).replace("mdpappid", mdpId)).replace("id", zid);
		exeData.add("Endpoint:"+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The respnse is :"+res.asString());
		test.get().log(Status.DEBUG, "The res is :\n"+res.asString());
		return res;

		
	}
	
	
	public Response put_EditZeissId(String authToken,String mdpAppId,String zId,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=editZeissId_Body_Builder(alterVals);
		System.out.println(mdpAdminUserService_Zeissid.get("putid"));
		String effEnd=(((String)mdpAdminUserService_Zeissid.get("putid")).replace("mdpappid", mdpAppId)).replace("id", zId);
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
