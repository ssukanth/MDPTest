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

public class AdminUserService_AdminUser extends ApiUtils{
	
	JSONObject mdpAdminUserService_AdminUserEndpoints=(JSONObject)(((Map)credentialJson.get("adminuserservice")).get("adminuser"));

	
	private String CLIENTID="clientId";
	private String ROLEID="roleId";
	private String EMAIL="email";
	private String FIRSTNAME="firstName";
	private String LASTNAME="lastName";
	private String CONTACTDETAILS="contactDetails";
	private String ALTERNATEEMAIL="contactDetails[0].alternateEmail";
	private String CONTACTNO="contactDetails[0].contactNo";
	private String ALTERNATENO="contactDetails[0].alternateNo";
	private String TYPE="contactDetails[0].type";
	private String COUNTRY="contactDetails[0].country";
	private String ZEISSIDUSERTYPE="zeissIdUserType";
	
	private String RESENTITYID="items[0].id";
	private String RESROLEID="items[0].roleId";
	private String RESEMAIL="email";
	private String RESFIRSTNAME="items[0].firstName";
	private String RESLASTNAME="items[0].lastName";
	private String RESCONTACTDETAILS="items[0].contactDetails";
	private String RESALTERNATEEMAIL="items[0].contactDetails[0].alternateEmail";
	private String RESCONTACTNO="items[0].contactDetails[0].contactNo";
	private String RESALTERNATENO="items[0].contactDetails[0].alternateNo";
	private String RESTYPE="items[0].contactDetails[0].type";
	private String RESCOUNTRY="items[0].contactDetails[0].country";
	
	
	
	public final String getRESENTITYID() {
		return RESENTITYID;
	}

	public final String getRESROLEID() {
		return RESROLEID;
	}

	public final String getRESEMAIL() {
		return RESEMAIL;
	}

	public final String getRESFIRSTNAME() {
		return RESFIRSTNAME;
	}

	public final String getRESLASTNAME() {
		return RESLASTNAME;
	}

	public final String getRESCONTACTDETAILS() {
		return RESCONTACTDETAILS;
	}

	public final String getRESALTERNATEEMAIL() {
		return RESALTERNATEEMAIL;
	}

	public final String getRESCONTACTNO() {
		return RESCONTACTNO;
	}

	public final String getRESALTERNATENO() {
		return RESALTERNATENO;
	}

	public final String getRESTYPE() {
		return RESTYPE;
	}

	public final String getRESCOUNTRY() {
		return RESCOUNTRY;
	}

	public final String getCOUNTRY() {
		return COUNTRY;
	}
	
	public final String getCLIENTID() {
		return CLIENTID;
	}

	public final String getROLEID() {
		return ROLEID;
	}

	public final String getEMAIL() {
		return EMAIL;
	}

	public final String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public final String getLASTNAME() {
		return LASTNAME;
	}

	public final String getCONTACTDETAILS() {
		return CONTACTDETAILS;
	}

	public final String getALTERNATEEMAIL() {
		return ALTERNATEEMAIL;
	}

	public final String getCONTACTNO() {
		return CONTACTNO;
	}

	public final String getALTERNATENO() {
		return ALTERNATENO;
	}

	public final String getTYPE() {
		return TYPE;
	}

	public final String getZEISSIDUSERTYPE() {
		return ZEISSIDUSERTYPE;
	}


	public void request_Authenticate(RequestSpecification httpReq, String authToken)
	{
//		httpReq.auth().oauth2(authToken);
//		httpReq.contentType("application/json");
		
		httpReq.header(
	              "Authorization",
	              "Bearer " + authToken);
		httpReq.contentType("application/json");
	             
	}
	
	private  String  createAdmin_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/AdminUserService_AdminUser.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.AdminUserService_AdminUser").newInstance();
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
	
	private  String  editAdmin_Body_Builder(Map<String,Object> alterVal) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		String payLoad="/src/test/java/com/mdp/api/modals/AdminUserService_AdminUser_Edit.json";
		String jString=generateStringFromResource(new File(".").getCanonicalPath()+payLoad);
		String payL="";
		JSONParser jp = new JSONParser();
		JSONObject jObj= (JSONObject)jp.parse(jString);
		//constructing the map with absolute json paths and values
		Map<String,Object>altVals2=new HashMap<String,Object>();
		Object obj=Class.forName("com.mdp.api.services.AdminUserService_AdminUser").newInstance();
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
	
	public Response post_CreateUserMDPUser(boolean defMailString,boolean defAltMailString,String authToken,String mdpAppId,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
//		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
//		Map<String,Object>m= new HashMap<String,Object>();	
//		if(alterVals!=null)
//		{
//			for(Map.Entry<String, Object>e:alterVals.entrySet())
//			{
//				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
//				m.put((String)method.invoke(obj), e.getValue());
//			}	
//		}
		if(defMailString)
		{
			
			String email="zeiss0719+"+genCurDateString()+"@gmail.com";
			test.get().log(Status.DEBUG, "Creating the user with defualt generated email:"+email);
			alterVals.put("EMAIL", email);
		}
		if(defAltMailString)
		{
			
			String email="zeiss0719+"+genCurDateString()+"@gmail.com";
			test.get().log(Status.DEBUG, "Creating the user with defualt generated email:"+email);
			alterVals.put("ALTERNATEEMAIL", email);
		}

		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=createAdmin_Body_Builder(alterVals);
		System.out.println(mdpAdminUserService_AdminUserEndpoints.get("creatadmin"));
		String effEnd=((String)mdpAdminUserService_AdminUserEndpoints.get("creatadmin")).replace("mdpappid", mdpAppId);
		exeData.add("\nThe Effective end point is :"+effEnd);
		exeData.add("\n payload"+payload);
		test.get().log(Status.DEBUG, "The Effective end point is :"+effEnd);
		test.get().log(Status.DEBUG, "Created users with the payload"+payload);
		httpReq.body(payload);
		Response res =null;
		System.out.println("Creating the case");
		//exeData.add((String)credentialJson.get("createUser"));
		res = httpReq.request(Method.POST,effEnd);
		exeData.add("\n Response Code:"+res.getStatusCode());
		//exeData.add("\nResponse:"+res.asString());
		test.get().log(Status.DEBUG, "\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\nResponse:"+res.asString());
		System.out.println("\nResponse:"+res.asString());
		return res;
	}
	
	
	public Response get_AllAdmins(String atn,String mdpId,Map<String,String>qParams)
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, atn);
		System.out.println("The end point is :"+(String)mdpAdminUserService_AdminUserEndpoints.get("getadmins"));
		String effEnd=((String)mdpAdminUserService_AdminUserEndpoints.get("getadmins")).replace("mdpappid", mdpId);
		if(qParams!=null) {
			test.get().log(Status.DEBUG, "The QueryParams for Update are :"+qParams);
			System.out.println("We have the query paramas");
			for(Map.Entry<String, String>e:qParams.entrySet())
			{
				switch(e.getKey().toLowerCase())
				{
				case "firstname":httpReq.queryParam("FirstName", e.getValue());
							effEnd=effEnd+"?FirstName="+e.getValue();
							break;
				case "lastname":httpReq.queryParam("LastName", e.getValue());
							effEnd=effEnd+"?LastName="+e.getValue();
							break;
				case "country":httpReq.queryParam("Country", e.getValue());
							effEnd=effEnd+"?Country="+e.getValue();
							break;
				case "pagesize":httpReq.queryParam("PageSize", e.getValue());
							effEnd=effEnd+"?PageSize"+e.getValue();
							break;
				}
					
			}

		}else
		{
			test.get().log(Status.DEBUG, "There Are no query params for updating");
		}
		exeData.add("Endpoint:"+effEnd);
		test.get().log(Status.DEBUG, "The Eff End point:"+effEnd);
		Response res=httpReq.request(Method.GET,effEnd);
		exeData.add("The respnse is :"+res.asString());
		test.get().log(Status.DEBUG, "The res is :\n"+res.asString());
		return res;
		
	}
	
	
	public void checkRecordsInGetAllUsers(String atn,String attrName,Response res,List<String>l) throws Exception
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
	
	public Response getAdmin(String atn,String mdpId,String pathParam)	
	{
		
		RequestSpecification httpReq=createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, atn);
		System.out.println("The end point is :"+(String)mdpAdminUserService_AdminUserEndpoints.get("getadmin"));
		String effEnd=((String)mdpAdminUserService_AdminUserEndpoints.get("getadmin")).replace("mdpappid", mdpId);
		if(pathParam!=null)
		{
			test.get().log(Status.DEBUG, "The QueryParams for Update are :"+pathParam);
			System.out.println("We have the query paramas");
			effEnd=effEnd+"/"+pathParam;
				
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
	
	
	public Response put_EditUserMDPUser(String userId,String authToken,String mdpAppId,Map<String,Object>alterVals) throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{	
		System.out.println("Authenticating the case creatino using the auth:"+authToken);
		RequestSpecification httpReq = createReq((String) credentialJson.get("baseuri"));
		request_Authenticate(httpReq, authToken);
		String payload=editAdmin_Body_Builder(alterVals);
		System.out.println(mdpAdminUserService_AdminUserEndpoints.get("putadmin"));
		String effEnd=((String)mdpAdminUserService_AdminUserEndpoints.get("putadmin")).replace("mdpappid", mdpAppId);
		if(userId!=null)
		{
			test.get().log(Status.DEBUG, "The QueryParams for Update are :"+userId);
			System.out.println("We have the query paramas");
			effEnd=effEnd.replace("userId", userId);
				
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
		//exeData.add((String)credentialJson.get("createUser"));
		res = httpReq.request(Method.PUT,effEnd);
		exeData.add("\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\n Response Code:"+res.getStatusCode());
		test.get().log(Status.DEBUG, "\nResponse:"+res.asString());
		System.out.println("\nResponse:"+res.asString());
		return res;
	}
	

}
