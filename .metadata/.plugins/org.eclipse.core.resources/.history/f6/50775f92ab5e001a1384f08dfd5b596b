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
import com.mdp.api.services.MDPSeriesService;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MDPSeriesTests extends TestBase {
	
	public ArrayList<String>listSeriesIds=new ArrayList<String>();
	public ArrayList<String>listSeriesInstanceUIds = new ArrayList<String>();
	
	//POST Request - Create Series Test cases
	
	@DataProvider(name="TC189_TC21_CreateSeries")
	public  JSONObject[][] data189_TC21_CreateSeries() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC21_CreateSeries", "seriesservice");
	}
	
	@Test(dataProvider="TC189_TC21_CreateSeries", groups= {"seriesservice"}, enabled=true)
	public void TC189_TC21_CreateSeries(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateSeries(true, (String)j.get("patientId"), (String)j.get("studyId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Series with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		if(res.getStatusCode()==201) {
			String seriesId=res.jsonPath().getString(mps.getSERIESID());
			
			listSeriesIds.add(res.jsonPath().getString(mps.getSERIESID()));
			listSeriesInstanceUIds.add(res.jsonPath().getString(mps.getSERIESINSTANCEUID()));
			//test.get().log(Status.DEBUG, markup)
			dynamicCredentials=addTextExeData("TC189_TC21_CreateSeries", seriesId);
			
		}
	}
	
	@DataProvider(name="TC189_TC22_CreateSeriesWithInvalidGUIDs")
	public  JSONObject[][] data189_TC22_CreateSeriesWithInvalidGUIDs() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC22_CreateSeriesWithInvalidGUIDs", "seriesservice");
	}
	
	@Test(dataProvider="TC189_TC22_CreateSeriesWithInvalidGUIDs", groups= {"seriesservice"}, enabled=true)
	public void TC189_TC22_CreateSeriesWithInvalidGUIDs(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateSeries(true, (String)j.get("patientId"), (String)j.get("studyId"), m);
		System.out.println("The responses are: "+res.body().asString());
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Series with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC189_TC23_CreateSeriesWithInvalidDataFormat")
	public  JSONObject[][] data189_TC23_CreateSeriesWithInvalidDataFormat() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC23_CreateSeriesWithInvalidDataFormat", "seriesservice");
	}
	
	@Test(dataProvider="TC189_TC23_CreateSeriesWithInvalidDataFormat", groups= {"seriesservice"}, enabled=true)
	public void TC189_TC23_CreateSeriesWithInvalidDataFormat(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateSeries(true, (String)j.get("patientId"), (String)j.get("studyId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Series with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC189_TC24_CreateSeriesWithDuplicateSeriesInstanceUID")
	public  JSONObject[][] data189_TC24_CreateSeriesWithDuplicateSeriesInstanceUID() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC24_CreateSeriesWithDuplicateSeriesInstanceUID", "seriesservice");
	}
	
	@Test(dataProvider="TC189_TC24_CreateSeriesWithDuplicateSeriesInstanceUID", groups= {"seriesservice"}, enabled=true)
	public void TC189_TC24_CreateSeriesWithDuplicateSeriesInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.postCreateSeries(true, (String)j.get("patientId"), (String)j.get("studyId"), m);
		
		System.out.println("The responses are: "+res.body().asString());
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Series with response: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));	
	}
	
	//GET Request - Get all Studies Test Cases
	
	@DataProvider(name="TC189_TC25_GetAllSeriesByStudyId")
	public  JSONObject[][] data189_TC25_GetAllSeriesByStudyId() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC25_GetAllSeriesByStudyId", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC25_GetAllSeriesByStudyId", dependsOnMethods = {"TC189_TC21_CreateSeries"}, groups= {"seriesservice"})
	public void TC189_TC25_GetAllSeriesByStudyId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPSeriesService mps=new MDPSeriesService();
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), null);
		System.out.println("The response for get all Series by Study ID is: "+res.asString());
		
		//Verify all the created Ids are in the list
		List<String>l=new ArrayList<String>();
		l.addAll(dynamicCredentials.get("TC189_TC21_CreateSeries"));
		test.get().log(Status.DEBUG, "The records to search are: "+l);
		//mps.checkRecordsInGetAllSeriesResponse(mps.getSERIESID(), res, l);
		System.out.println("The data at the end: "+dynamicCredentials.get("TC189_TC21_CreateSeries"));
	}
	
	@DataProvider(name="TC189_TC26_GetAllSeriesByStudyIdAndFilterByCreatedDate")
	public  JSONObject[][] data189_TC26_GetAllSeriesByStudyIdAndFilterByCreatedDate() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC26_GetAllSeriesByStudyIdAndFilterByCreatedDate", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC26_GetAllSeriesByStudyIdAndFilterByCreatedDate", dependsOnMethods = {"TC189_TC21_CreateSeries"}, groups= {"seriesservice"})
	public void TC189_TC26_GetAllSeriesByStudyIdAndFilterByCreatedDate(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPSeriesService mps = new MDPSeriesService();
		Map<String,Object>m = new HashMap<String,Object>();
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Series with response: "+res.body().asString());
		
		//mps.checkRecordsInGetAllSeriesResponse(mps.getSTUDYID(), res, listStudyIds);
	
	}
	
	@DataProvider(name="TC189_TC27_GetAllSeriesByStudyIdAndFilterBySeriesInstanceUID")
	public  JSONObject[][] data189_TC27_GetAllSeriesByStudyIdAndFilterBySeriesInstanceUID() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC27_GetAllSeriesByStudyIdAndFilterBySeriesInstanceUID", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC27_GetAllSeriesByStudyIdAndFilterBySeriesInstanceUID", dependsOnMethods = {"TC189_TC21_CreateSeries"}, groups= {"seriesservice"})
	public void TC189_TC27_GetAllSeriesByStudyIdAndFilterBySeriesInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC21_CreateSeries"));
		MDPSeriesService mps=new MDPSeriesService();
		//Response res=null;
		
		//getcalls
		Map<String, String>mp = (Map<String, String>)j.get("qparams");
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Get All Series with response: "+res.body().asString());
		
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
	
	@DataProvider(name="TC189_TC28_GetAllSeriesByStudyIdAndFilterByModality")
	public  JSONObject[][] data189_TC28_GetAllSeriesByStudyIdAndFilterByModality() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC28_GetAllSeriesByStudyIdAndFilterByModality", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC28_GetAllSeriesByStudyIdAndFilterByModality", dependsOnMethods = {"TC189_TC21_CreateSeries"}, groups= {"seriesservice"})
	public void TC189_TC28_GetAllSeriesByStudyIdAndFilterByModality(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC21_CreateStudy"));
		MDPSeriesService mps=new MDPSeriesService();
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
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Series by Modality with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC29_GetAllSeriesByStudyIdAndFilterByDateAndSeriesInstanceUID")
	public  JSONObject[][] data189_TC29_GetAllSeriesByStudyIdAndFilterByDateAndSeriesInstanceUID() throws IOException, InvalidFormatException
	{	 
		return getTestData("TC189_TC29_GetAllSeriesByStudyIdAndFilterByDateAndSeriesInstanceUID", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC29_GetAllSeriesByStudyIdAndFilterByDateAndSeriesInstanceUID", dependsOnMethods = {"TC189_TC21_CreateSeries"}, groups= {"seriesservice"})
	public void TC189_TC29_GetAllSeriesByStudyIdAndFilterByDateAndSeriesInstanceUID(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is: "+j.get("testname"));
		
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC189_TC21_CreateSeries"));
		MDPSeriesService mps=new MDPSeriesService();
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
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Series with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC30_GetAllSeriesByStudyIdAndFilterByDateAndModality")
	public  JSONObject[][] data189_TC30_GetAllSeriesByStudyIdAndFilterByDateAndModality() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC30_GetAllSeriesByStudyIdAndFilterByDateAndModality", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC30_GetAllSeriesByStudyIdAndFilterByDateAndModality", dependsOnMethods = {"TC189_TC21_CreateSeries"}, groups= {"seriesservice"})
	public void TC189_TC30_GetAllSeriesByStudyIdAndFilterByDateAndModality(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		System.out.println("The data before taking into list: "+dynamicCredentials.get("TC189_TC21_CreateSeries"));
		MDPSeriesService mps=new MDPSeriesService();
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
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Series filter by Date and Modality with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC31_GetAllSeriesByStudyIdAndFilterByAllParams")
	public  JSONObject[][] data189_TC31_GetAllSeriesByStudyIdAndFilterByAllParams() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC31_GetAllSeriesByStudyIdAndFilterByAllParams", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC31_GetAllSeriesByStudyIdAndFilterByAllParams", groups= {"seriesservice"})
	public void TC189_TC31_GetAllSeriesByStudyIdAndFilterByAllParams(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		RestAssured.useRelaxedHTTPSValidation();
		List<String>studyIds=new ArrayList<String>();
	  	List<String>studyInstanceIds=new ArrayList<String>();
	  	List<String>seriesInstanceIds=new ArrayList<String>();
	  	List<String>studyCreatedDates=new ArrayList<String>();
	  	
	  	MDPSeriesService mps=new MDPSeriesService();
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
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), mp);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//verifying whether all the created ids are in the list
		//test.get().log(Status.DEBUG, "The records to search are: "+listStudyIds);
		
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Series filter by all params with response: "+res.body().asString());
		
	}
	
	@DataProvider(name="TC189_TC32_GetNoSeriesByStudyId")
	public  JSONObject[][] data189_TC32_GetNoSeriesByStudyId() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC32_GetNoSeriesByStudyId", "seriesservice");
	}
	
	//dependsOnMethods = {"TC189_TC01_CreateStudy"},
	@Test(dataProvider = "TC189_TC32_GetNoSeriesByStudyId", groups= {"seriesservice"})
	public void TC189_TC32_GetNoSeriesByStudyId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPSeriesService mps=new MDPSeriesService();
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), null);
		System.out.println("The response for get all Series by Patient ID is: "+res.asString());
		
		Assert.assertEquals(res.asString(), "[]");
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "GET all Series with response: "+res.body().asString());
		
	}
	
	
	@DataProvider(name="TC189_TC33_GetAllSeriesByInvalidStudyId")
	public  JSONObject[][] data189_TC33_GetAllSeriesByInvalidStudyId() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC33_GetAllSeriesByInvalidStudyId", "seriesservice");
	}
	
	@Test(dataProvider = "TC189_TC33_GetAllSeriesByInvalidStudyId", groups= {"seriesservice"})
	public void TC189_TC33_GetAllSeriesByInvalidStudyId(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		
		MDPSeriesService mps=new MDPSeriesService();
		Response res=mps.get_AllSeries((String)j.get("patientId"), (String)j.get("studyId"), null);
		System.out.println("The response for get all Series by Study ID is: "+res.asString());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	@DataProvider(name="TC189_TC34_GetSeriesBySeriesId")
	public  JSONObject[][] data189_TC34_GetSeriesBySeriesId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC34_GetSeriesBySeriesId", "seriesservice");
	}
	@Test(dataProvider="TC189_TC34_GetSeriesBySeriesId",groups= {"seriesservice"}, enabled=true)
	public void TC189_TC34_GetSeriesBySeriesId(JSONObject j) throws Exception
	{
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		String seriesId = createSeries(j, mps, m, obj);
		
		Response res2=mps.getSeriesById((String)j.get("patientId"), (String)j.get("studyId"), seriesId);
		
		
		String seriesInstanceUId=res2.jsonPath().getString(mps.getSERIESINSTANCEUID());
		System.out.println("seriesInstanceUId: "+seriesInstanceUId);
		
		test.get().log(Status.DEBUG, "Returned data: "+seriesId+"-"+seriesInstanceUId);
		//Assert.assertEquals(studyInstanceUId, m.get(mps.getStudyInstanceUID()));
		//Assert.assertEquals(seriesInstanceUId, m.get(mps.getSeriesInstanceUID()));
		Assert.assertEquals(res2.getStatusCode(), 200);
		
		test.get().log(Status.PASS, "Record found as expected using Get Study by id");
	}
	
	@DataProvider(name="TC189_TC35_GetSeriesBySeriesIdAndDiffPatientId")
	public  JSONObject[][]dataC189_TC35_GetSeriesBySeriesIdAndDiffPatientId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC35_GetSeriesBySeriesIdAndDiffPatientId", "seriesservice");
	}
	@Test(dataProvider="TC189_TC35_GetSeriesBySeriesIdAndDiffPatientId",groups= {"seriesservice"}, enabled=true)
	public void TC189_TC35_GetSeriesBySeriesIdAndDiffPatientId(JSONObject j) throws Exception
	{
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		String seriesId = createSeries(j, mps, m, obj);
		
		Response res2=mps.getSeriesById((String)j.get("patientId2"),(String)j.get("studyId"), seriesId);
		
		Assert.assertEquals(res2.getStatusCode(), 404);
		
		test.get().log(Status.PASS, "Expected Error 404 for PatientID doesnt matched with Study ID");
	}
	
	@DataProvider(name="TC189_TC36_GetSeriesBySeriesIdAndDiffStudyId")
	public  JSONObject[][]data189_TC36_GetSeriesBySeriesIdAndDiffStudyId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC36_GetSeriesBySeriesIdAndDiffStudyId", "seriesservice");
	}
	@Test(dataProvider="TC189_TC36_GetSeriesBySeriesIdAndDiffStudyId",groups= {"seriesservice"}, enabled=true)
	public void TC189_TC36_GetSeriesBySeriesIdAndDiffStudyId(JSONObject j) throws Exception
	{
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		String seriesId = createSeries(j, mps, m, obj);
		
		Response res2=mps.getSeriesById((String)j.get("patientId"),(String)j.get("studyId2"), seriesId);
		
		Assert.assertEquals(res2.getStatusCode(), 404);
		
		test.get().log(Status.PASS, "Expected Error 404 for StudyID doesnt matched with Series ID");
	}
	
	@DataProvider(name="TC189_TC37_GetSeriesByInvalidSeriesId")
	public  JSONObject[][] data189_TC37_GetSeriesByInvalidSeriesId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC37_GetSeriesByInvalidSeriesId", "seriesservice");
	}
	@Test(dataProvider="TC189_TC37_GetSeriesByInvalidSeriesId",groups= {"seriesservice"}, enabled=true)
	public void TC189_TC37_GetSeriesByInvalidSeriesId(JSONObject j) throws Exception
	{
		MDPSeriesService mps=new MDPSeriesService();
		
		Response res2=mps.getSeriesById((String)j.get("patientId"), (String)j.get("studyId"), (String)j.get("invalidseriesId"));
		
		Assert.assertEquals(res2.getStatusCode(), 400);
		
		test.get().log(Status.PASS, "Expected Error 400, invalid GUID for Study ID in URI");
	}
	
	@DataProvider(name="TC189_TC38_GetSeriesBySeriesIdAndInvalidStudyId")
	public  JSONObject[][] data189_TC38_GetSeriesBySeriesIdAndInvalidStudyId() throws IOException, InvalidFormatException
	{	  
		return getTestData("TC189_TC38_GetSeriesBySeriesIdAndInvalidStudyId", "seriesservice");
	}
	@Test(dataProvider="TC189_TC38_GetSeriesBySeriesIdAndInvalidStudyId", groups= {"seriesservice"}, enabled=true)
	public void TC189_TC38_GetSeriesBySeriesIdAndInvalidStudyId(JSONObject j) throws Exception
	{
		MDPSeriesService mps=new MDPSeriesService();
		
		Response res2=mps.getSeriesById((String)j.get("patientId"), (String)j.get("invalidstudyId"), (String)j.get("seriesId"));
		
		Assert.assertEquals(res2.getStatusCode(), 400);
		
		test.get().log(Status.PASS, "StudyID is not Valid GUID");
	}
	
	@DataProvider(name="TC189_TC39_EditSeries")
	public  JSONObject[][] data189_TC39_EditSeries() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC39_EditSeries", "seriesservice");
	}
	
	@Test(dataProvider="TC189_TC39_EditSeries", groups= {"seriesservice"}, enabled=true)
	public void TC189_TC39_EditSeries(JSONObject j) throws Exception
	{
		MDPSeriesService mps=new MDPSeriesService();
		Map<String,Object>m= new HashMap<String,Object>();
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res1=mps.postCreateSeries(true, (String)j.get("patientId"), (String)j.get("studyId"), m);
		System.out.println("The responses are ");
		System.out.println(res1.getStatusCode());
		exeData.add("The status code is :"+res1.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res1.getStatusCode());
		
		//Editing Series
		Map<String,Object>m1= new HashMap<String,Object>();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m1.put((String)method.invoke(obj), e.getValue());
			}	
		}
		Response res=mps.postEditSeriesDetails((String)j.get("patientId"), (String)j.get("studyId"), res1.jsonPath().getString(mps.getSERIESID()), m1);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		System.out.println("The status code for the edit series is: "+res.getStatusCode());
		
	}
	
	@DataProvider(name="TC189_TC40_EditSerieswithDifferentIDs")
	public  JSONObject[][] data189_TC40_EditSerieswithDifferentIDs() throws IOException, InvalidFormatException
	{
		return getTestData("TC189_TC40_EditSerieswithDifferentIDs", "seriesservice");
	}
	
	@Test(dataProvider="TC189_TC40_EditSerieswithDifferentIDs", groups= {"seriesservice"}, enabled=true)
	public void TC189_TC40_EditSerieswithDifferentIDs(JSONObject j) throws Exception
	{
		MDPSeriesService mps=new MDPSeriesService();
		Object obj = Class.forName("com.mdp.api.services.MDPSeriesService").newInstance();
		
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
		Response res=mps.postEditSeriesDetails((String)j.get("patientId"), (String)j.get("studyId"),(String)j.get("seriesId"), m1);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		System.out.println("The status code for the edit study is: "+res.getStatusCode());
		
	}
	
	public String createSeries(JSONObject j, MDPSeriesService mps, Map<String,Object>m, Object obj) throws Exception
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
		Response res=mps.postCreateSeries(true, (String)j.get("patientId"), (String)j.get("studyId"), m);
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		test.get().log(Status.DEBUG, "Created the Series with response :"+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		String seriesId=null;
		if(res.getStatusCode()==201) {
			test.get().log(Status.PASS, "Created a Study with response :"+res.body().asString());
			seriesId=res.jsonPath().getString(mps.getSERIESID());
			test.get().log(Status.DEBUG, "Created a Study with data: "+seriesId);
		}
		
		return seriesId;
	}

}
