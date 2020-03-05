package com.mdp.api.tests;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mdp.api.services.MDPStudyService;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MDPStudyTests extends TestBase {
	
	public ArrayList<String>listStudyIds=new ArrayList<String>();
	public ArrayList<String>listStudyInstanceUIds = new ArrayList<String>();
	public ArrayList<String>listSeriesInstanceUIds = new ArrayList<String>();
	
	//POST Request - Create Study Test cases
	
	@DataProvider(name="TC189_TC01_CreateStudy")
	public  JSONObject[][] data189_TC01_CreateStudy() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC01_CreateStudy", "studyservice");
	}
	
	@Test(dataProvider="TC189_TC01_CreateStudy", groups= {"studyservice"}, enabled=true)
	public void TC189_TC01_CreateStudy(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateStudy(true,(String)j.get("patientId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Study with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		if(res.getStatusCode()==201) {
			String studyId=res.jsonPath().getString(mps.getSTUDYID());
			
			listStudyIds.add(res.jsonPath().getString(mps.getSTUDYID()));
			listStudyInstanceUIds.add(res.jsonPath().getString(mps.getSTUDYINSTANCEUID()));
			listSeriesInstanceUIds.add(res.jsonPath().getString(mps.getSERIESINSTANCEUID()));
			//test.get().log(Status.DEBUG, markup)
			dynamicCredentials=addTextExeData("TC189_TC01_CreateStudy", studyId);
			
		}
	}
	
	@DataProvider(name="TC189_TC02_CreateStudyWithInvalidGUIDs")
	public  JSONObject[][] data189_TC02_CreateStudyWithInvalidGUIDs() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC02_CreateStudyWithInvalidGUIDs", "studyservice");
	}
	
	@Test(dataProvider="TC189_TC02_CreateStudyWithInvalidGUIDs", groups= {"studyservice"}, enabled=true)
	public void TC189_TC02_CreateStudyWithInvalidGUIDs(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateStudy(true,(String)j.get("patientId"), m);
		System.out.println("The responses are: "+res.body().asString());
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Study with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC189_TC03_CreateStudyWithInvalidDataFormat")
	public  JSONObject[][] data189_TC03_CreateStudyWithInvalidDataFormat() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC03_CreateStudyWithInvalidDataFormat", "studyservice");
	}
	
	@Test(dataProvider="TC189_TC03_CreateStudyWithInvalidDataFormat", groups= {"studyservice"}, enabled=true)
	public void TC189_TC03_CreateStudyWithInvalidDataFormat(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateStudy(true,(String)j.get("patientId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Study with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC189_TC04_CreateStudyWithNoAppType")
	public  JSONObject[][] data189_TC04_CreateStudyWithNoAppType() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC04_CreateStudyWithNoAppType", "studyservice");
	}
	
	@Test(dataProvider="TC189_TC04_CreateStudyWithNoAppType", groups= {"studyservice"}, enabled=true)
	public void TC189_TC04_CreateStudyWithNoAppType(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateStudy(true,(String)j.get("patientId"), m);
		System.out.println("The response code is: "+res.getStatusCode());
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Response for POST Study: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	//GET Request - Get all Studies Test Cases
	
	@DataProvider(name="TC189_TC05_GetAllStudiesByPatientId")
	public  JSONObject[][] data189_TC05_GetAllStudiesByPatientId() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC05_GetAllStudiesByPatientId", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC05_GetAllStudiesByPatientId", dependsOnMethods = {"TC189_TC01_CreateStudy"}, groups= {"studyservice"})
	public void TC189_TC05_GetAllStudiesByPatientId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPStudyService mps=new MDPStudyService();
		Response res=mps.get_AllStudies((String)j.get("patientId"), null);
		System.out.println("The response for get all Studies by Patient ID is: "+res.asString());
		
		//Verify all the created Ids are in the list
		List<String>l=new ArrayList<String>();
		l.addAll(dynamicCredentials.get("TC189_TC01_CreateStudy"));
		test.get().log(Status.DEBUG, "The records to search are: "+l);
		mps.checkRecordsInGetAllStudiesResponse(mps.getSTUDYID(), res, l);
		System.out.println("The data at the end: "+dynamicCredentials.get("TC189_TC01_CreateStudy"));
	}
	
	@DataProvider(name="TC189_TC06_GetAllStudiesByPatientIdAndFilterByCreatedDate")
	public  JSONObject[][] data189_TC06_GetAllStudiesByPatientIdAndFilterByCreatedDate() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC06_GetAllStudiesByPatientIdAndFilterByCreatedDate", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC06_GetAllStudiesByPatientIdAndFilterByCreatedDate", dependsOnMethods = {"TC189_TC01_CreateStudy"}, groups= {"studyservice"})
	public void TC189_TC06_GetAllStudiesByPatientIdAndFilterByCreatedDate(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPStudyService mps = new MDPStudyService();
		Map<String,Object>m = new HashMap<String,Object>();
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllStudies((String)j.get("patientId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Study with response: "+res.body().asString());
		
		//mps.checkRecordsInGetAllStudiesResponse(mps.getSTUDYID(), res, listStudyIds);
	
	}
	
	@DataProvider(name="TC189_TC07_GetAllStudiesByPatientIdAndFilterByStudyInstanceUID")
	public  JSONObject[][] data189_TC07_GetAllStudiesByPatientIdAndFilterByStudyInstanceUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC07_GetAllStudiesByPatientIdAndFilterByStudyInstanceUID", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC07_GetAllStudiesByPatientIdAndFilterByStudyInstanceUID",dependsOnMethods = {"TC189_TC01_CreateStudy"},groups= {"studyservice"})
	public void TC189_TC07_GetAllStudiesByPatientIdAndFilterByStudyInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC01_CreateStudy"));
		MDPStudyService mps=new MDPStudyService();
		//Response res=null;
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllStudies((String)j.get("patientId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Get All Study with response: "+res.body().asString());
		
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
	
	@DataProvider(name="TC189_TC08_GetAllStudiesByPatientIdAndFilterBySeriesInstanceUID")
	public  JSONObject[][] data189_TC08_GetAllStudiesByPatientIdAndFilterBySeriesInstanceUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC08_GetAllStudiesByPatientIdAndFilterBySeriesInstanceUID", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC08_GetAllStudiesByPatientIdAndFilterBySeriesInstanceUID", dependsOnMethods = {"TC189_TC01_CreateStudy"}, groups= {"studyservice"})
	public void TC189_TC08_GetAllStudiesByPatientIdAndFilterBySeriesInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC01_CreateStudy"));
		MDPStudyService mps=new MDPStudyService();
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
		Response res=mps.get_AllStudies((String)j.get("patientId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Studies by Series Instance UID with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC09_GetAllStudiesByPatientIdAndFilterByDateAndStudyInstanceUID")
	public  JSONObject[][] data189_TC09_GetAllStudiesByPatientIdAndFilterByDateAndStudyInstanceUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC09_GetAllStudiesByPatientIdAndFilterByDateAndStudyInstanceUID", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC09_GetAllStudiesByPatientIdAndFilterByDateAndStudyInstanceUID", dependsOnMethods = {"TC189_TC01_CreateStudy"}, groups= {"studyservice"})
	public void TC189_TC09_GetAllStudiesByPatientIdAndFilterByDateAndStudyInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC01_CreateStudy"));
		MDPStudyService mps=new MDPStudyService();
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
		Response res=mps.get_AllStudies((String)j.get("patientId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Studies with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC10_GetAllStudiesByPatientIdAndFilterByDateAndSeriesInstanceUID")
	public  JSONObject[][] data189_TC10_GetAllStudiesByPatientIdAndFilterByDateAndSeriesInstanceUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC10_GetAllStudiesByPatientIdAndFilterByDateAndSeriesInstanceUID", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC10_GetAllStudiesByPatientIdAndFilterByDateAndSeriesInstanceUID", dependsOnMethods = {"TC189_TC01_CreateStudy"}, groups= {"studyservice"})
	public void TC189_TC10_GetAllStudiesByPatientIdAndFilterByDateAndSeriesInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		System.out.println("The data before taking into list: "+dynamicCredentials.get("TC189_TC01_CreateStudy"));
		MDPStudyService mps=new MDPStudyService();
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
		Response res=mps.get_AllStudies((String)j.get("patientId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Studies filter by Date and Series Instance UID with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC11_GetAllStudiesByPatientIdAndFilterByAllParams")
	public  JSONObject[][] data189_TC11_GetAllStudiesByPatientIdAndFilterByAllParams() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC11_GetAllStudiesByPatientIdAndFilterByAllParams", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC11_GetAllStudiesByPatientIdAndFilterByAllParams", groups= {"studyservice"})
	public void TC189_TC11_GetAllStudiesByPatientIdAndFilterByAllParams(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		RestAssured.useRelaxedHTTPSValidation();
		List<String>studyIds=new ArrayList<String>();
	  	List<String>studyInstanceIds=new ArrayList<String>();
	  	List<String>seriesInstanceIds=new ArrayList<String>();
	  	List<String>studyCreatedDates=new ArrayList<String>();
	  	
	  	MDPStudyService mps=new MDPStudyService();
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
		Response res=mps.get_AllStudies((String)j.get("patientId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Studies filter by Date and Series Instance UID with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC12_GetNoStudiesByPatientId")
	public  JSONObject[][] data189_TC12_GetNoStudiesByPatientId() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC12_GetNoStudiesByPatientId", "studyservice");
	}
	
	//dependsOnMethods = {"TC189_TC01_CreateStudy"},
	@Test(dataProvider = "TC189_TC12_GetNoStudiesByPatientId", groups= {"studyservice"})
	public void TC189_TC12_GetNoStudiesByPatientId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPStudyService mps=new MDPStudyService();
		Response res=mps.get_AllStudies((String)j.get("patientId"), null);
		System.out.println("The response for get all Studies by Patient ID is: "+res.asString());
		
		Assert.assertEquals(res.asString(), "[]");
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Studies filter by Date and Series Instance UID with response: "+res.body().asString());
		
	}
	
	
	@DataProvider(name="TC189_TC13_GetAllStudiesByInvalidPatientId")
	public  JSONObject[][] data189_TC13_GetAllStudiesByInvalidPatientId() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC13_GetAllStudiesByInvalidPatientId", "studyservice");
	}
	
	@Test(dataProvider = "TC189_TC13_GetAllStudiesByInvalidPatientId", groups= {"studyservice"})
	public void TC189_TC13_GetAllStudiesByInvalidPatientId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPStudyService mps=new MDPStudyService();
		Response res=mps.get_AllStudies((String)j.get("patientId"), null);
		System.out.println("The response for get all Studies by Patient ID is: "+res.asString());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	@DataProvider(name="TC189_TC14_GetStudyByStudyId")
	public  JSONObject[][] data189_TC14_GetStudyByStudyId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC14_GetStudyByStudyId", "studyservice");
	}
	@Test(dataProvider="TC189_TC14_GetStudyByStudyId",groups= {"studyservice"}, enabled=true)
	public void TC189_TC14_GetStudyByStudyId(JSONObject j) throws Exception
	{
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		String studyId = createStudy(j, mps, m, obj);
		
		Response res2=mps.getStudyById((String)j.get("patientId"), studyId);
		
		String studyInstanceUId=res2.jsonPath().getString(mps.getSTUDYINSTANCEUID());
		System.out.println("studyInstanceUId: "+studyInstanceUId);
		String seriesInstanceUId=res2.jsonPath().getString(mps.getSERIESINSTANCEUID());
		System.out.println("seriesInstanceUId: "+seriesInstanceUId);
		
		test.get().log(Status.DEBUG, "Returned data: "+studyId+"-"+studyInstanceUId+"-"+seriesInstanceUId);
		//Assert.assertEquals(studyInstanceUId, m.get(mps.getStudyInstanceUID()));
		//Assert.assertEquals(seriesInstanceUId, m.get(mps.getSeriesInstanceUID()));
		Assert.assertEquals(res2.getStatusCode(), 200);
		
		test.get().log(Status.PASS, "Record found as expected using Get Study by id");
	}
	
	@DataProvider(name="TC189_TC15_GetStudyByStudyIdAndDiffPatientId")
	public  JSONObject[][] data189_TC15_GetStudyByStudyIdAndDiffPatientId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC15_GetStudyByStudyIdAndDiffPatientId", "studyservice");
	}
	@Test(dataProvider="TC189_TC15_GetStudyByStudyIdAndDiffPatientId",groups= {"studyservice"}, enabled=true)
	public void TC189_TC15_GetStudyByStudyIdAndDiffPatientId(JSONObject j) throws Exception
	{
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		String studyId = createStudy(j, mps, m, obj);
		
		Response res2=mps.getStudyById((String)j.get("patientId2"), studyId);
		
		Assert.assertEquals(res2.getStatusCode(), 404);
		
		test.get().log(Status.PASS, "Expected Error 404 for PatientID doesnt matched with Study ID");
	}
	
	@DataProvider(name="TC189_TC16_GetStudyByInvalidStudyId")
	public  JSONObject[][] data189_TC16_GetStudyByInvalidStudyId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC16_GetStudyByInvalidStudyId", "studyservice");
	}
	@Test(dataProvider="TC189_TC16_GetStudyByInvalidStudyId",groups= {"studyservice"}, enabled=true)
	public void TC189_TC16_GetStudyByInvalidStudyId(JSONObject j) throws Exception
	{
		MDPStudyService mps=new MDPStudyService();
		
		Response res2=mps.getStudyById((String)j.get("patientId"), (String)j.get("invalidstudyId"));
		
		Assert.assertEquals(res2.getStatusCode(), 400);
		
		test.get().log(Status.PASS, "Expected Error 400 for invalid Study ID in URI");
	}
	
	@DataProvider(name="TC189_TC17_GetStudyByStudyIdAndInvalidPatientId")
	public  JSONObject[][] data189_TC17_GetStudyByStudyIdAndInvalidPatientId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC17_GetStudyByStudyIdAndInvalidPatientId", "studyservice");
	}
	@Test(dataProvider="TC189_TC17_GetStudyByStudyIdAndInvalidPatientId", groups= {"studyservice"}, enabled=true)
	public void TC189_TC17_GetStudyByStudyIdAndInvalidPatientId(JSONObject j) throws Exception
	{
		MDPStudyService mps=new MDPStudyService();
		
		Response res2=mps.getStudyById((String)j.get("invalidpatientId"), (String)j.get("studyId"));
		
		Assert.assertEquals(res2.getStatusCode(), 400);
		
		test.get().log(Status.PASS, "PatientID doesnt matched with Study ID");
	}
	
	@DataProvider(name="TC189_TC18_CreateStudyWithDuplicateStudySeriesInstanceUID")
	public  JSONObject[][] data189_TC18_CreateStudyWithDuplicateStudySeriesInstanceUID() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC18_CreateStudyWithDuplicateStudySeriesInstanceUID", "studyservice");
	}
	
	@Test(dataProvider="TC189_TC18_CreateStudyWithDuplicateStudySeriesInstanceUID", groups= {"studyservice"}, enabled=true)
	public void TC189_TC18_CreateStudyWithDuplicateStudySeriesInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateStudy(true,(String)j.get("patientId"), m);
		
		System.out.println("The responses are: "+res.body().asString());
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Study with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));	
	}
	
	@DataProvider(name="TC189_TC19_EditStudy")
	public  JSONObject[][] data189_TC19_EditStudy() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC19_EditStudy", "studyservice");
	}
	
	@Test(dataProvider="TC189_TC19_EditStudy", groups= {"studyservice"}, enabled=true)
	public void TC189_TC19_EditStudy(JSONObject j) throws Exception
	{
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res1=mps.postCreateStudy(true, (String)j.get("patientId"), m);
		System.out.println("The responses are ");
		System.out.println(res1.getStatusCode());
		exeData.add("The status code is :"+res1.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res1.getStatusCode());
		
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
		Response res=mps.postEditStudyDetails((String)j.get("patientId"), res1.jsonPath().getString(mps.getSTUDYID()), m1);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		System.out.println("The status code for the edit study is: "+res.getStatusCode());
		
	}
	
	@DataProvider(name="TC189_TC20_EditStudywithInvalidPatientStudyID")
	public  JSONObject[][] data189_TC20_EditStudywithInvalidPatientStudyID() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC20_EditStudywithInvalidPatientStudyID", "studyservice");
	}
	
	@Test(dataProvider="TC189_TC20_EditStudywithInvalidPatientStudyID", groups= {"studyservice"}, enabled=true)
	public void TC189_TC20_EditStudywithInvalidPatientStudyID(JSONObject j) throws Exception
	{
		MDPStudyService mps=new MDPStudyService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPStudyService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res1=mps.postCreateStudy(true, (String)j.get("patientId"), m);
		System.out.println("The responses are ");
		System.out.println(res1.getStatusCode());
		exeData.add("The status code is :"+res1.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res1.getStatusCode());
		
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
		Response res=mps.postEditStudyDetails((String)j.get("patientId2"), res1.jsonPath().getString(mps.getSTUDYID()), m1);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		System.out.println("The status code for the edit study is: "+res.getStatusCode());
		
	}
	
	public String createStudy(JSONObject j, MDPStudyService mps, Map<String,Object>m, Object obj) throws Exception
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
		Response res=mps.postCreateStudy(true, (String)j.get("patientId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Study with response :"+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		String studyId=null;
		if(res.getStatusCode()==201) {
			test.get().log(Status.PASS, "Created a Study with response :"+res.body().asString());
			studyId=res.jsonPath().getString(mps.getSTUDYID());
			test.get().log(Status.DEBUG, "Created a Study with data: "+studyId);
		}
		
		return studyId;
	}
	
	
}
