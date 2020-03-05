package com.mdp.api.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mdp.api.services.MDPInstanceService;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MDPInstanceTests extends TestBase {
	
	public ArrayList<String>listInstanceIds=new ArrayList<String>();
	public ArrayList<String>listSOPInstanceUIds = new ArrayList<String>();
	
	//POST Request - Create Instance Test cases
	
	@DataProvider(name="TC190_TC01_CreateInstance")
	public  JSONObject[][] data190_TC01_CreateInstance() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC01_CreateInstance", "instanceservice");
	}
	
	@Test(dataProvider="TC190_TC01_CreateInstance", groups= {"instanceservice"}, enabled=true)
	public void TC190_TC01_CreateInstance(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPInstanceService mps=new MDPInstanceService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateInstance(true, (String)j.get("studyId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Instance with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		if(res.getStatusCode()==201) {
			String instanceId=res.jsonPath().getString(mps.getINSTANCEID());
			
			listInstanceIds.add(res.jsonPath().getString(mps.getINSTANCEID()));
			listSOPInstanceUIds.add(res.jsonPath().getString(mps.getINSTANCEUID()));
			//test.get().log(Status.DEBUG, markup)
			dynamicCredentials=addTextExeData("TC190_TC01_CreateInstance", instanceId);
			
		}
	}
	
	@DataProvider(name="TC190_TC02_CreateInstanceInvalidStudyGUID")
	public  JSONObject[][] data190_TC02_CreateInstanceInvalidStudyGUID() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC02_CreateInstanceInvalidStudyGUID", "instanceservice");
	}
	
	@Test(dataProvider="TC190_TC02_CreateInstanceInvalidStudyGUID", groups= {"instanceservice"}, enabled=true)
	public void TC190_TC02_CreateInstanceInvalidStudyGUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPInstanceService mps=new MDPInstanceService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateInstance(true, (String)j.get("studyId"), m);
		System.out.println("The responses are: "+res.body().asString());
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "POST Instance with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC190_TC03_CreateInstanceInvalidData")
	public  JSONObject[][] data190_TC03_CreateInstanceInvalidData() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC03_CreateInstanceInvalidData", "instanceservice");
	}
	
	@Test(dataProvider="TC190_TC03_CreateInstanceInvalidData", groups= {"instanceservice"}, enabled=true)
	public void TC190_TC03_CreateInstanceInvalidData(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		MDPInstanceService mps=new MDPInstanceService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateInstance(true, (String)j.get("studyId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "POST Instance with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC190_TC04_CreateInstanceWithNoFrameNumber")
	public  JSONObject[][] data190_TC04_CreateInstanceWithNoFrameNumber() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC04_CreateInstanceWithNoFrameNumber", "instanceservice");
	}
	
	@Test(dataProvider="TC190_TC04_CreateInstanceWithNoFrameNumber", groups= {"instanceservice"}, enabled=true)
	public void TC190_TC04_CreateInstanceWithNoFrameNumber(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPInstanceService mps=new MDPInstanceService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateInstance(true, (String)j.get("studyId"), m);
		
		System.out.println("The responses are: "+res.body().asString());
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "POST Instance response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
		if(res.getStatusCode()==201) {
			test.get().log(Status.PASS, "Created the instance with response :"+res.body().asString());
			String pId=res.jsonPath().getString(mps.getBULKDATA());
			test.get().log(Status.DEBUG, "Created the instance with bulk data: "+pId);
			System.out.println(pId);
			
			String frame1=res.jsonPath().getString(mps.getFRAMENUMBER());
			String frame2=res.jsonPath().getString(mps.getFRAMENUMBER());
			
			System.out.println(frame1);
			System.out.println(frame2);
		}

	}
	
	//GET Request - Get all Instances Test Cases
	
	@DataProvider(name="TC190_TC05_GetAllInstancesByStudyId")
	public  JSONObject[][] data190_TC05_GetAllInstancesByStudyId() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC05_GetAllInstancesByStudyId", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC05_GetAllInstancesByStudyId", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC05_GetAllInstancesByStudyId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();
		Response res=mps.get_AllInstances((String)j.get("studyId"), null);
		System.out.println("The response for get all Instance by Study ID is: "+res.asString());
		
		//Verify all the created Ids are in the list
		List<String>l=new ArrayList<String>();
		l.addAll(dynamicCredentials.get("TC190_TC01_CreateInstance"));
		test.get().log(Status.DEBUG, "The records to search are: "+l);
		//mps.checkRecordsInGetAllSeriesResponse(mps.getSERIESID(), res, l);
		System.out.println("The data at the end: "+dynamicCredentials.get("TC190_TC01_CreateInstance"));
	}
	
	@DataProvider(name="TC190_TC06_GetAllInstancesByStudyIdAndFilterByCreatedDate")
	public  JSONObject[][] data190_TC06_GetAllInstancesByStudyIdAndFilterByCreatedDate() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC06_GetAllInstancesByStudyIdAndFilterByCreatedDate", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC06_GetAllInstancesByStudyIdAndFilterByCreatedDate", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC06_GetAllInstancesByStudyIdAndFilterByCreatedDate(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		MDPInstanceService mps = new MDPInstanceService();
		Map<String,Object>m = new HashMap<String,Object>();
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Instances by Study ID and filtered by created data response: "+res.body().asString());
		
		//mps.checkRecordsInGetAllSeriesResponse(mps.getSTUDYID(), res, listStudyIds);
	
	}
	
	@DataProvider(name="TC190_TC07_GetAllInstancesByStudyIdAndFilterBySopClassUID")
	public  JSONObject[][] data190_TC07_GetAllInstancesByStudyIdAndFilterBySopClassUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC07_GetAllInstancesByStudyIdAndFilterBySopClassUID", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC07_GetAllInstancesByStudyIdAndFilterBySopClassUID", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC07_GetAllInstancesByStudyIdAndFilterBySopClassUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC190_TC01_CreateInstance"));
		MDPInstanceService mps=new MDPInstanceService();
		//Response res=null;
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetAllInstancesByStudyIdAndFilterBySopClassUID response: "+res.body().asString());
		
		/*
		for(String sIUid: listStudyInstanceUIds)
		{
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("StudyInstanceUID", sIUid);
			res=mps.get_AllStudies((String)j.get("patientID"), mp);
			Assert.assertEquals(res.getStatusCode(), 200);
			test.get().log(Status.DEBUG, "The record for the Study Instance UID: "+sIUid+" in the response: "+res.jsonPath().getString(mps.getSTUDYINSTANCEUID()));	
		}
		*/
		
	}
	
	@DataProvider(name="TC190_TC08_GetAllInstancesByStudyIdAndFilterBySopInstanceUID")
	public  JSONObject[][] data190_TC08_GetAllInstancesByStudyIdAndFilterBySopInstanceUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC08_GetAllInstancesByStudyIdAndFilterBySopInstanceUID", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC08_GetAllInstancesByStudyIdAndFilterBySopInstanceUID", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC08_GetAllInstancesByStudyIdAndFilterBySopInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC21_CreateStudy"));
		MDPInstanceService mps=new MDPInstanceService();
		/*
		Response res=null;
		for(String sIUid: listSeriesInstanceUIds)
		{
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("SeriesInstanceUID", sIUid);
			res=mps.get_AllStudies((String)j.get("patientID"), mp);
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			test.get().log(Status.DEBUG, "The response :"+res.body().asString());

			Assert.assertEquals(res.getStatusCode(), 200);
			test.get().log(Status.DEBUG, "The record for the Series Instance UID: "+sIUid+" in the response: "+res.jsonPath().getString(mps.getSERIESINSTANCEUID()));	
		}
		*/
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetAllInstancesByStudyIdAndFilterBySopInstanceUID response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC190_TC09_GetAllInstancesByStudyIdAndFilterBySeriesKey")
	public  JSONObject[][] data190_TC09_GetAllInstancesByStudyIdAndFilterBySeriesKey() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC09_GetAllInstancesByStudyIdAndFilterBySeriesKey", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC09_GetAllInstancesByStudyIdAndFilterBySeriesKey", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC09_GetAllInstancesByStudyIdAndFilterBySeriesKey(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC21_CreateStudy"));
		MDPInstanceService mps=new MDPInstanceService();
		/*
		Response res=null;
		for(String sIUid: listSeriesInstanceUIds)
		{
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("SeriesInstanceUID", sIUid);
			res=mps.get_AllStudies((String)j.get("patientID"), mp);
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			test.get().log(Status.DEBUG, "The response :"+res.body().asString());

			Assert.assertEquals(res.getStatusCode(), 200);
			test.get().log(Status.DEBUG, "The record for the Series Instance UID: "+sIUid+" in the response: "+res.jsonPath().getString(mps.getSERIESINSTANCEUID()));	
		}
		*/
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetAllInstancesByStudyIdAndFilterBySeriesKey response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC190_TC10_GetAllInstancesByStudyIdAndFilterByDateAndSopClassUID")
	public  JSONObject[][] data190_TC10_GetAllInstancesByStudyIdAndFilterByDateAndSopClassUID() throws IOException, InvalidFormatException
	{	 
		return getTestData("TC190_TC10_GetAllInstancesByStudyIdAndFilterByDateAndSopClassUID", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC10_GetAllInstancesByStudyIdAndFilterByDateAndSopClassUID", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC10_GetAllInstancesByStudyIdAndFilterByDateAndSopClassUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC190_TC01_CreateInstance"));
		MDPInstanceService mps=new MDPInstanceService();
		/*
		Response res=null;
		for(String sIUid: listStudyInstanceUIds)
		{
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("StudyInstanceUID", sIUid);
			res=mps.get_AllStudies((String)j.get("patientID"), mp);
			Assert.assertEquals(res.getStatusCode(), 200);
			test.get().log(Status.DEBUG, "The record for the Study Instance UID: "+sIUid+" in the response: "+res.jsonPath().getString(mps.getSTUDYINSTANCEUID()));	
		}
		*/
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetAllInstancesByStudyIdAndFilterByDateAndSopClassUID response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC190_TC11_GetAllInstancesByStudyIdAndFilterByDateAndSopInstanceUID")
	public  JSONObject[][] data190_TC11_GetAllInstancesByStudyIdAndFilterByDateAndSopInstanceUID() throws IOException, InvalidFormatException
	{	 
		return getTestData("TC190_TC11_GetAllInstancesByStudyIdAndFilterByDateAndSopInstanceUID", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC11_GetAllInstancesByStudyIdAndFilterByDateAndSopInstanceUID", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC11_GetAllInstancesByStudyIdAndFilterByDateAndSopInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC190_TC01_CreateInstance"));
		MDPInstanceService mps=new MDPInstanceService();
		/*
		Response res=null;
		for(String sIUid: listStudyInstanceUIds)
		{
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("StudyInstanceUID", sIUid);
			res=mps.get_AllStudies((String)j.get("patientID"), mp);
			Assert.assertEquals(res.getStatusCode(), 200);
			test.get().log(Status.DEBUG, "The record for the Study Instance UID: "+sIUid+" in the response: "+res.jsonPath().getString(mps.getSTUDYINSTANCEUID()));	
		}
		*/
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetAllInstancesByStudyIdAndFilterByDateAndSopInstanceUID response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC190_TC12_GetAllSeriesByStudyIdAndFilterByDateAndSeriesKey")
	public  JSONObject[][] data190_TC12_GetAllSeriesByStudyIdAndFilterByDateAndSeriesKey() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC12_GetAllSeriesByStudyIdAndFilterByDateAndSeriesKey", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC12_GetAllSeriesByStudyIdAndFilterByDateAndSeriesKey", dependsOnMethods = {"TC190_TC01_CreateInstance"}, groups= {"instanceservice"})
	public void TC190_TC12_GetAllSeriesByStudyIdAndFilterByDateAndSeriesKey(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		System.out.println("The data before taking into list: "+dynamicCredentials.get("TC190_TC01_CreateInstance"));
		MDPInstanceService mps=new MDPInstanceService();
		/*
		Response res=null;
		for(String sIUid: listSeriesInstanceUIds)
		{
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("SeriesInstanceUID", sIUid);
			res=mps.get_AllStudies((String)j.get("patientID"), mp);
			Assert.assertEquals(res.getStatusCode(), 200);
			test.get().log(Status.DEBUG, "The record for the Series Instance UID: "+sIUid+" in the response: "+res.jsonPath().getString(mps.getSERIESINSTANCEUID()));	
		}
		*/
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetAllSeriesByStudyIdAndFilterByDateAndSeriesKey response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC190_TC13_GetAllInstancesByStudyIdAndFilterByAllParams")
	public  JSONObject[][] data190_TC13_GetAllInstancesByStudyIdAndFilterByAllParams() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC13_GetAllInstancesByStudyIdAndFilterByAllParams", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC13_GetAllInstancesByStudyIdAndFilterByAllParams", groups= {"instanceservice"})
	public void TC190_TC13_GetAllInstancesByStudyIdAndFilterByAllParams(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		RestAssured.useRelaxedHTTPSValidation();
		List<String>instanceIds=new ArrayList<String>();
	  	List<String>sopInstanceIds=new ArrayList<String>();
	  	List<String>sopClassIds=new ArrayList<String>();
	  	List<String>instanceCreatedDates=new ArrayList<String>();
	  	
	  	MDPInstanceService mps=new MDPInstanceService();
	  	/*
	  	Response res=null;
	  	
		Map<String,Object>m= new HashMap<String,Object>();
		for(int i=0;i<5;i++)
		{	
			m.put(mps.getSTUDYINSTANCEUID(), "1.2.840.10008."+getDateString());
			m.put(mps.getSERIESINSTANCEUID(),"1.2.840.10008.01."+getDateString());
			res=mps.postCreateStudy(true, (String)j.get("patientId"), m);
			sleepTimer(1);
			System.out.println("The res for all the params: "+res.asString());
			studyIds.add(res.jsonPath().getString(mps.getSTUDYID()));
			studyInstanceIds.add(res.jsonPath().getString(mps.getSTUDYINSTANCEUID()));
			seriesInstanceIds.add(res.jsonPath().getString(mps.getSERIESINSTANCEUID()));
			
		}
		
		for(int i=0; i<studyIds.size();i++)
		{
			StringBuilder str=null;
			mp.put("CreatedDate", studyCreatedDates.get(i));
			mp.put("StudyInstanceUID", studyInstanceIds.get(i));
			mp.put("SeriesInstanceUID", seriesInstanceIds.get(i));
			res=mps.get_AllStudies((String)j.get("patientId"), mp);	
			Assert.assertEquals(res.getStatusCode(), 200);
			str=new StringBuilder(res.jsonPath().getString(mps.getSTUDYID()).replace("[", "").replace("]", ""));
			Assert.assertEquals(str.toString(), studyIds.get(i));
		}
		*/
	  	
	  	//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllInstances((String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetAllInstancesByStudyIdAndFilterByAllParams response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC190_TC14_GetNoInstancesByStudyId")
	public  JSONObject[][] data190_TC14_GetNoInstancesByStudyId() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC14_GetNoInstancesByStudyId", "instanceservice");
	}
	
	//dependsOnMethods = {"TC189_TC01_CreateStudy"},
	@Test(dataProvider = "TC190_TC14_GetNoInstancesByStudyId", groups= {"instanceservice"})
	public void TC190_TC14_GetNoInstancesByStudyId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();
		Response res=mps.get_AllInstances((String)j.get("studyId"), null);
		System.out.println("The response for_GetNoInstancesByStudyId: "+res.asString());
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.asString(), "[]");
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GetNoInstancesByStudyId response: "+res.body().asString());
		
	}
	
	
	@DataProvider(name="TC190_TC15_GetAllInstancesByInvalidStudyId")
	public  JSONObject[][] data190_TC15_GetAllInstancesByInvalidStudyId() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC15_GetAllInstancesByInvalidStudyId", "instanceservice");
	}
	
	@Test(dataProvider = "TC190_TC15_GetAllInstancesByInvalidStudyId", groups= {"instanceservice"})
	public void TC190_TC15_GetAllInstancesByInvalidStudyId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();
		Response res=mps.get_AllInstances((String)j.get("studyId"), null);
		System.out.println("The response for get all Series by Study ID is: "+res.asString());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	//Test cases for GET Request - Get Instance by instance id
	
	@DataProvider(name="TC190_TC16_GetInstanceByInstanceId")
	public  JSONObject[][] data190_TC16_GetInstanceByInstanceId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC16_GetInstanceByInstanceId", "instanceservice");
	}
	@Test(dataProvider="TC190_TC16_GetInstanceByInstanceId",groups= {"instanceservice"}, enabled=true)
	public void TC190_TC16_GetInstanceByInstanceId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		String instanceId = createInstance(j, mps, m, obj);
		
		Response res2=mps.getInstanceById((String)j.get("studyId"), instanceId);
		
		
		String instanceUId=res2.jsonPath().getString(mps.getINSTANCEUID());
		System.out.println("instanceUId: "+instanceUId);
		
		test.get().log(Status.DEBUG, "Returned data: "+instanceId+"-"+instanceUId);
		//Assert.assertEquals(studyInstanceUId, m.get(mps.getStudyInstanceUID()));
		//Assert.assertEquals(seriesInstanceUId, m.get(mps.getSeriesInstanceUID()));
		Assert.assertEquals(res2.getStatusCode(), 200);
		
		test.get().log(Status.PASS, "Record found as expected using Get Instance by id");
	}
	
	@DataProvider(name="TC190_TC17_GetInstanceByInstanceIdAndDifferentStudyId")
	public  JSONObject[][] data190_TC17_GetInstanceByInstanceIdAndDifferentStudyId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC17_GetInstanceByInstanceIdAndDifferentStudyId", "instanceservice");
	}
	@Test(dataProvider="TC190_TC17_GetInstanceByInstanceIdAndDifferentStudyId",groups= {"instanceservice"}, enabled=true)
	public void TC190_TC17_GetInstanceByInstanceIdAndDifferentStudyId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		String instanceId = createInstance(j, mps, m, obj);
		Response res2=mps.getInstanceById((String)j.get("studyId2"), instanceId);
		
		Assert.assertEquals(res2.getStatusCode(), 404);
		test.get().log(Status.PASS, "Expected Error 404 for Study ID doesnt matched with Instance ID");
	}
	
	@DataProvider(name="TC190_TC18_GetInstanceByInstanceIdInvalidGUID")
	public  JSONObject[][]data190_TC18_GetInstanceByInstanceIdInvalidGUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC190_TC18_GetInstanceByInstanceIdInvalidGUID", "instanceservice");
	}
	@Test(dataProvider="TC190_TC18_GetInstanceByInstanceIdInvalidGUID",groups= {"instanceservice"}, enabled=true)
	public void TC190_TC18_GetInstanceByInstanceIdInvalidGUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res2=mps.getInstanceById((String)j.get("studyId"), (String)j.get("instanceId"));
		
		Assert.assertEquals(res2.getStatusCode(), 404);
		
		test.get().log(Status.PASS, "Expected Error 404 for invalid GUID provided at basr URI");
		test.get().log(Status.DEBUG, "The status code is: "+res2.getStatusCode());
		test.get().log(Status.DEBUG, "Response: "+res2.body().asString());
	}
	
	//Test Cases for PUT Request - Edit an instance by instance id
	
	@DataProvider(name="TC190_TC19_EditInstance")
	public  JSONObject[][] data190_TC19_EditInstance() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC19_EditInstance", "instanceservice");
	}
	
	@Test(dataProvider="TC190_TC19_EditInstance", groups= {"instanceservice"}, enabled=true)
	public void TC190_TC19_EditInstance(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();;
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		
		//Editing Instance
		Map<String,Object>m1= new HashMap<String,Object>();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m1.put((String)method.invoke(obj), e.getValue());
			}	
		}
		Response res=mps.postEditInstanceDetails((String)j.get("studyId"), (String)j.get("instanceId"), m1);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		System.out.println("The status code for the edit Instance is: "+res.getStatusCode());
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC190_TC20_EditInstancewithDifferentIDs")
	public  JSONObject[][] data190_TC20_EditInstancewithDifferentIDs() throws IOException, InvalidFormatException
	{
		return getTestData("TC190_TC20_EditInstancewithDifferentIDs", "instanceservice");
	}
	
	@Test(dataProvider="TC190_TC20_EditInstancewithDifferentIDs", groups= {"instanceservice"}, enabled=true)
	public void TC190_TC20_EditInstancewithDifferentIDs(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPInstanceService mps=new MDPInstanceService();
		Object obj = Class.forName("com.mdp.api.services.MDPInstanceService").newInstance();
		
		//Editing Study
		Map<String,Object>m1= new HashMap<String,Object>();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m1.put((String)method.invoke(obj), e.getValue());
			}	
		}
		Response res=mps.postEditInstanceDetails((String)j.get("studyId"),(String)j.get("instanceId"), m1);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		System.out.println("The status code for the edit Insatnce is: "+res.getStatusCode());
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Response: "+res.body().asString());
		
	}
	
	public String createInstance(JSONObject j, MDPInstanceService mps, Map<String,Object>m, Object obj) throws Exception
	{
		RestAssured.useRelaxedHTTPSValidation();
		/*if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		*/
		Response res=mps.postCreateInstance(true, (String)j.get("studyId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Instance with response :"+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		String instanceId=null;
		if(res.getStatusCode()==201) {
			test.get().log(Status.PASS, "Created a Instance with response :"+res.body().asString());
			instanceId=res.jsonPath().getString(mps.getINSTANCEID());
			test.get().log(Status.DEBUG, "Created a Instance with data: "+instanceId);
		}
		
		return instanceId;
	}

}
