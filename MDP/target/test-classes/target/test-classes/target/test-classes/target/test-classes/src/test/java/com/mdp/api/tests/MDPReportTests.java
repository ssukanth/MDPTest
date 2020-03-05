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
import com.mdp.api.services.MDPReportService;
import com.selenium.utils.MailBox;

import io.restassured.response.Response;

public class MDPReportTests extends TestBase {
	 @DataProvider(name="TC191_CreateReport_Study_Test01_CreateReport")
	 public  JSONObject[][] TC191_CreateReport_Study_Test01_CreateReport() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Study_Test01_CreateReport","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Study_Test01_CreateReport",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Study_Test01_CreateReport(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		if(res.getStatusCode()==201) {
			dynamicCredentials=addTextExeData("TC191_CreateReport_Study_Test01_CreateReport", res.jsonPath().getString(rps.getREPORTENTITYID()));
			dynamicCredentials=addTextExeData("TC191_CreateReport_Study_Test01_CreateReport", res.jsonPath().getString(rps.getCREATEDAT()));
			dynamicCredentials=addTextExeData("TC191_CreateReport_Study_Test01_CreateReport", res.jsonPath().getString(rps.getCREATEDBy()));
		}
	}
	
	
	@DataProvider(name="TC191_CreateReport_Study_Test03_CreateReportWithContentNull")
	 public  JSONObject[][] TC191_CreateReport_Study_Test03_CreateReportWithContentNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Study_Test03_CreateReportWithContentNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Study_Test03_CreateReportWithContentNull",groups= {"reportservice"},enabled=false)
	public void tC191_CreateReport_Study_Test03_CreateReportWithContentNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	@DataProvider(name="TC191_CreateReport_Study_Test04_CreateReportWithTagNull")
	 public  JSONObject[][] TC191_CreateReport_Study_Test04_CreateReportWithTagNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Study_Test04_CreateReportWithTagNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Study_Test04_CreateReportWithTagNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Study_Test04_CreateReportWithTagNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Study_Test05_CreateReportWithAdditionalInfoNull")
	 public  JSONObject[][] TC191_CreateReport_Study_Test05_CreateReportWithAdditionalInfoNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Study_Test05_CreateReportWithAdditionalInfoNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Study_Test05_CreateReportWithAdditionalInfoNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Study_Test05_CreateReportWithAdditionalInfoNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Study_Test06_CreateReportWithEntityIdNull")
	 public  JSONObject[][] TC191_CreateReport_Study_Test06_CreateReportWithEntityIdNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Study_Test06_CreateReportWithEntityIdNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Study_Test06_CreateReportWithEntityIdNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Study_Test06_CreateReportWithEntityIdNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("study", "", (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	
	@DataProvider(name="TC191_CreateReport_Study_Test07_CreateReportWithAllAttrAsNull")
	 public  JSONObject[][] TC191_CreateReport_Study_Test07_CreateReportWithAllAttrAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Study_Test07_CreateReportWithAllAttrAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Study_Test07_CreateReportWithAllAttrAsNull",groups= {"reportservice"},enabled=false)//same as study
	public void tC191_CreateReport_Study_Test07_CreateReportWithAllAttrAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("study", "", (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	//Study - Get All Reports
	
	

	@DataProvider(name="TC191_GetAllReports_Study_Test01_GetAllReportsForStudy")
	 public  JSONObject[][] TC191_GetAllReports_Study_Test01_GetAllReportsForStudy() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Study_Test01_GetAllReportsForStudy","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Study_Test01_GetAllReportsForStudy",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Study_Test01_GetAllReportsForStudy(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
			System.out.println("The responses for createreport are ");
			res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			if(res.getStatusCode()==201) {
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				l.add( res.jsonPath().getString(rps.getCREATEDAT()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}		
		res=null;
		res=rps.getAllReports("study", eId, l.get(1));
		res.jsonPath().getList(rps.getREPORTENTITYID());
		Assert.assertEquals((res.jsonPath().getString(rps.getREPORTENTITYID()).replace("[", "").replace("]", "")), l.get(0));
		//Assert.assertEquals(res.jsonPath().getString((rps.getCREATEDAT().replace("[[", "").replace("]]", ""))), l.get(1));
		
	}
	
	@DataProvider(name="TC191_GetAllReports_Study_Test02_GetAllReportsForStudyWithoutCreatedAt")
	 public  JSONObject[][] TC191_GetAllReports_Study_Test02_GetAllReportsForStudyWithoutCreatedAt() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Study_Test02_GetAllReportsForStudyWithoutCreatedAt","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Study_Test02_GetAllReportsForStudyWithoutCreatedAt",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Study_Test02_GetAllReportsForStudyWithoutCreatedAt(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.getAllReports("study", eId, "");
		List<String>lEids=res.jsonPath().getList(rps.getREPORTENTITYID());
		Assert.assertEquals(lEids.size(), 3);
		Assert.assertEquals(lEids.containsAll(l), true);
		
	}


	@Test(groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Study_Test03_GetAllReportsForStudyWithoutEntityId() throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		Response res=rps.getAllReports("study","", "");
		Assert.assertEquals(res.getStatusCode(), 404);
		
	}
	
	@DataProvider(name="TC191_GetAllReports_Study_Test04_GetAllReportsForStudyWithInvalidEntityId")
	 public  JSONObject[][] TC191_GetAllReports_Study_Test04_GetAllReportsForStudyWithInvalidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Study_Test04_GetAllReportsForStudyWithInvalidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Study_Test04_GetAllReportsForStudyWithInvalidEntityId",groups= {"reportservice"},enabled=true)
	public void TC191_GetAllReports_Study_Test04_GetAllReportsForStudyWithInvalidEntityId(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.getAllReports("study", (String)j.get("entityid")+genCurDateString("yy-MM-dd HH-mm-ss"), "");
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));		
	}
	
	
	@DataProvider(name="TC191_GetAllReports_Study_Test05_DeleteAllReportsForStudyWithValidEntityId")
	 public  JSONObject[][] TC191_GetAllReports_Study_Test05_DeleteAllReportsForStudyWithValidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Study_Test05_DeleteAllReportsForStudyWithValidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Study_Test05_DeleteAllReportsForStudyWithValidEntityId",groups= {"reportservice"},enabled=true)
	public void TC191_GetAllReports_Study_Test05_DeleteAllReportsForStudyWithValidEntityId(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.deleteAllReports("study", eId);
		Assert.assertEquals(res.getStatusCode(), 405);

	}
	
	
	@DataProvider(name="TC191_GetAllReports_Study_Test06_GetAllReportsForStudyWithInvalidClustername")
	 public  JSONObject[][] TC191_GetAllReports_Study_Test06_GetAllReportsForStudyWithInvalidClustername() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Study_Test06_GetAllReportsForStudyWithInvalidClustername","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Study_Test06_GetAllReportsForStudyWithInvalidClustername",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Study_Test06_GetAllReportsForStudyWithInvalidClustername(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=rps.getAllReports("series", eId, "");
		Assert.assertEquals(res.getStatusCode(),404);
		res=null;
		res=rps.getAllReports("exam", eId, "");
		Assert.assertEquals(res.getStatusCode(),404);
		
	}
	
	
	//Get Report At Study Level
	
	
	
	@DataProvider(name="TC191_GetReport_Study_Test01_GetReportForStudy")
	 public  JSONObject[][] TC191_GetReport_Study_Test01_GetReportForStudy() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Study_Test01_GetReportForStudy","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Study_Test01_GetReportForStudy",groups= {"reportservice"},enabled=true)
	public void tC191_GetReport_Study_Test01_GetReportForStudy(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		
		res=rps.getReport("Study", eId, rId);
		Assert.assertEquals(res.getStatusCode(),Integer.parseInt((String)j.get("expCode")) );
		Assert.assertEquals(res.jsonPath().getString(rps.getREPORTENTITYID()),rId);
		Assert.assertEquals(res.jsonPath().getString(rps.getREFENTITYID()), eId);
		
	}
	
	
	@DataProvider(name="TC191_GetReport_Study_Test02_GetReportForStudyWithInvalidEntityId")
	 public  JSONObject[][] TC191_GetReport_Study_Test02_GetReportForStudyWithInvalidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Study_Test02_GetReportForStudyWithInvalidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Study_Test02_GetReportForStudyWithInvalidEntityId",groups= {"reportservice"},enabled=true)
	public void tC191_GetReport_Study_Test02_GetReportForStudyWithInvalidEntityId(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		
		res=rps.getReport("Study", (String)j.get("entityid")+genCurDateString("yy-MM-dd HH-mm-ss"), rId);
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_GetReport_Study_Test03_GetReportForStudyWithInvalidReportId")
	 public  JSONObject[][] TC191_GetReport_Study_Test03_GetReportForStudyWithInvalidReportId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Study_Test03_GetReportForStudyWithInvalidReportId","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Study_Test03_GetReportForStudyWithInvalidReportId",groups= {"reportservice"},enabled=true)
	public void TC191_GetReport_Study_Test03_GetReportForStudyWithInvalidReportId(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		String modId=rId.replace(rId.substring(rId.length()-2), "su1");
		test.get().log(Status.DEBUG, "The Original Id:"+rId+"The Modified Invalid Id is :"+modId);
		exeData.add("The Original Id:"+rId+"The Modified Invalid Id is :"+modId);
		res=rps.getReport("Series",eId,modId );
		Assert.assertEquals(res.getStatusCode(), res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));	
	}
	
	
	@DataProvider(name="TC191_GetReport_Study_Test04_GetReportForStudyWithEntityIdAsNull")
	 public  JSONObject[][] TC191_GetReport_Study_Test04_GetReportForStudyWithEntityIdAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Study_Test04_GetReportForStudyWithEntityIdAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Study_Test04_GetReportForStudyWithEntityIdAsNull",groups= {"reportservice"},enabled=true)
	public void TC191_GetReport_Study_Test04_GetReportForStudyWithEntityIdAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.getReport("Study","", rId);
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_GetReport_Study_Test05_GetReportForStudyWithReportIdAsNull")
	 public  JSONObject[][] TC191_GetReport_Study_Test05_GetReportForStudyWithReportIdAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Study_Test05_GetReportForStudyWithReportIdAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Study_Test05_GetReportForStudyWithReportIdAsNull",groups= {"reportservice"},enabled=false)//made obselete as the reportId is path param and without that it will become as getall reports
	public void TC191_GetReport_Study_Test05_GetReportForStudyWithReportIdAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.getReport("Study",eId, "");
		test.get().log(Status.DEBUG, "The Status code for the reportId as null is:"+res.getStatusCode());
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_DeleteReport_Study_Test06_GetReportForStudy")
	 public  JSONObject[][] TC191_DeleteReport_Study_Test06_GetReportForStudy() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_DeleteReport_Study_Test06_GetReportForStudy","reportservice");
	 }
	@Test(dataProvider="TC191_DeleteReport_Study_Test06_GetReportForStudy",groups= {"reportservice"},enabled=true)
	public void TC191_DeleteReport_Study_Test06_GetReportForStudy(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.deleteReport("Study",eId, rId);
		Assert.assertEquals(res.getStatusCode(), res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));	
	}
	
	//Series - Post Report
	
	 @DataProvider(name="TC191_CreateReport_Series_Test01_CreateReport")
	 public  JSONObject[][] TC191_CreateReport_Series_Test01_CreateReport() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Series_Test01_CreateReport","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Series_Test01_CreateReport",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Series_Test01_CreateReport(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	
	@DataProvider(name="TC191_CreateReport_Series_Test03_CreateReportWithContentNull")
	 public  JSONObject[][] TC191_CreateReport_Series_Test03_CreateReportWithContentNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Series_Test03_CreateReportWithContentNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Series_Test03_CreateReportWithContentNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Series_Test03_CreateReportWithContentNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Series_Test04_CreateReportWithTagNull")
	 public  JSONObject[][] TC191_CreateReport_Series_Test04_CreateReportWithTagNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Series_Test04_CreateReportWithTagNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Series_Test04_CreateReportWithTagNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Series_Test04_CreateReportWithTagNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Series_Test05_CreateReportWithAdditionalInfoNull")
	 public  JSONObject[][] TC191_CreateReport_Series_Test05_CreateReportWithAdditionalInfoNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Series_Test05_CreateReportWithAdditionalInfoNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Series_Test05_CreateReportWithAdditionalInfoNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Series_Test05_CreateReportWithAdditionalInfoNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Series_Test06_CreateReportWithEntityIdNull")
	 public  JSONObject[][] TC191_CreateReport_Series_Test06_CreateReportWithEntityIdNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Series_Test06_CreateReportWithEntityIdNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Series_Test06_CreateReportWithEntityIdNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Series_Test06_CreateReportWithEntityIdNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("Series", "", (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	
	
	@DataProvider(name="TC191_CreateReport_Series_Test07_CreateReportWithAllAttrAsNull")
	 public  JSONObject[][] TC191_CreateReport_Series_Test07_CreateReportWithAllAttrAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Series_Test07_CreateReportWithAllAttrAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Series_Test07_CreateReportWithAllAttrAsNull",groups= {"reportservice"},enabled=false)// same as study
	public void tC191_CreateReport_Series_Test07_CreateReportWithAllAttrAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("Series", "", (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	//Get All Reports At Series
	
	@DataProvider(name="TC191_GetAllReports_Series_Test01_GetAllReportsForSeries")
	 public  JSONObject[][] TC191_GetAllReports_Series_Test01_GetAllReportsForSeries() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Series_Test01_GetAllReportsForSeries","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Series_Test01_GetAllReportsForSeries",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Series_Test01_GetAllReportsForSeries(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
			System.out.println("The responses for createreport are ");
			res=rps.postReport("series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			if(res.getStatusCode()==201) {
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				l.add( res.jsonPath().getString(rps.getCREATEDAT()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}		
		res=null;
		res=rps.getAllReports("series", eId, l.get(1));
		res.jsonPath().getList(rps.getREPORTENTITYID());
		Assert.assertEquals((res.jsonPath().getString(rps.getREPORTENTITYID()).replace("[", "").replace("]", "")), l.get(0));
		//Assert.assertEquals(res.jsonPath().getString((rps.getCREATEDAT().replace("[[", "").replace("]]", ""))), l.get(1));
		
	}
	
	@DataProvider(name="TC191_GetAllReports_Series_Test02_GetAllReportsForSeriesWithoutCreatedAt")
	 public  JSONObject[][] TC191_GetAllReports_Series_Test02_GetAllReportsForSeriesWithoutCreatedAt() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Series_Test02_GetAllReportsForSeriesWithoutCreatedAt","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Series_Test02_GetAllReportsForSeriesWithoutCreatedAt",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Series_Test02_GetAllReportsForSeriesWithoutCreatedAt(JSONObject j) throws Exception
	{	System.out.println("Wating  for 1 minute  to make sure executin data is not currupted");
		sleepTimer(61);
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.getAllReports("series", eId, "");
		List<String>lEids=res.jsonPath().getList(rps.getREPORTENTITYID());
		Assert.assertEquals(lEids.size(), 3);
		Assert.assertEquals(lEids.containsAll(l), true);
		
	}


	@Test(groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Series_Test03_GetAllReportsForStudyWithoutEntityId() throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		Response res=rps.getAllReports("series","", "");
		Assert.assertEquals(res.getStatusCode(), 404);
		
	}
	
	@DataProvider(name="TC191_GetAllReports_Series_Test04_GetAllReportsForSeriesWithInvalidEntityId")
	 public  JSONObject[][] TC191_GetAllReports_Series_Test04_GetAllReportsForSeriesWithInvalidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Series_Test04_GetAllReportsForSeriesWithInvalidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Series_Test04_GetAllReportsForSeriesWithInvalidEntityId",groups= {"reportservice"},enabled=true)
	public void TC191_GetAllReports_Series_Test04_GetAllReportsForSeriesWithInvalidEntityId(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.getAllReports("series", (String)j.get("entityid")+genCurDateString("yy-MM-dd HH-mm-ss"), "");
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));		
	}
	
	@DataProvider(name="TC191_GetAllReports_Series_Test05_DeleteAllReportsForStudyWithValidEntityId")
	 public  JSONObject[][] TC191_GetAllReports_Series_Test05_DeleteAllReportsForStudyWithValidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Series_Test05_DeleteAllReportsForStudyWithValidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Series_Test05_DeleteAllReportsForStudyWithValidEntityId",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Series_Test05_DeleteAllReportsForStudyWithValidEntityId(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.deleteAllReports("series", eId);
		Assert.assertEquals(res.getStatusCode(), 405);

	}
	
	
	@DataProvider(name="TC191_GetAllReports_Series_Test06_GetAllReportsForSeriesWithInvalidClustername")
	 public  JSONObject[][] TC191_GetAllReports_Series_Test06_GetAllReportsForSeriesWithInvalidClustername() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Series_Test06_GetAllReportsForSeriesWithInvalidClustername","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Series_Test06_GetAllReportsForSeriesWithInvalidClustername",groups= {"reportservice"},enabled=true)
	public void TC191_GetAllReports_Series_Test06_GetAllReportsForSeriesWithInvalidClustername(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=rps.getAllReports("study", eId, "");
		Assert.assertEquals(res.getStatusCode(),404);
		res=null;
		res=rps.getAllReports("exam", eId, "");
		Assert.assertEquals(res.getStatusCode(),404);
		
	}
	
	//Get Report At Series Level
	
	@DataProvider(name="TC191_GetReport_Series_Test01_GetReportForSeries")
	 public  JSONObject[][] TC191_GetReport_Series_Test01_GetReportForSeries() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Series_Test01_GetReportForSeries","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Series_Test01_GetReportForSeries",groups= {"reportservice"},enabled=true)
	public void tC191_GetReport_Series_Test01_GetReportForSeries(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		
		res=rps.getReport("Series", eId, rId);
		Assert.assertEquals(res.getStatusCode(),Integer.parseInt((String)j.get("expCode")) );
		Assert.assertEquals(res.jsonPath().getString(rps.getREPORTENTITYID()),rId);
		Assert.assertEquals(res.jsonPath().getString(rps.getREFENTITYID()), eId);
		
	}
	
	
	@DataProvider(name="TC191_GetReport_Series_Test02_GetReportForSeriesWithInvalidEntityId")
	 public  JSONObject[][] TC191_GetReport_Series_Test02_GetReportForSeriesWithInvalidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Series_Test02_GetReportForSeriesWithInvalidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Series_Test02_GetReportForSeriesWithInvalidEntityId",groups= {"reportservice"},enabled=true)
	public void tC191_GetReport_Series_Test02_GetReportForSeriesWithInvalidEntityId(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		
		res=rps.getReport("Series", (String)j.get("entityid")+genCurDateString("yy-MM-dd HH-mm-ss"), rId);
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_GetReport_Series_Test03_GetReportForSeriesWithInvalidReportId")
	 public  JSONObject[][] TC191_GetReport_Series_Test03_GetReportForSeriesWithInvalidReportId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Series_Test03_GetReportForSeriesWithInvalidReportId","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Series_Test03_GetReportForSeriesWithInvalidReportId",groups= {"reportservice"},enabled=true)
	public void TC191_GetReport_Series_Test03_GetReportForSeriesWithInvalidReportId(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		String modId=rId.replace(rId.substring(rId.length()-2), "su1");
		test.get().log(Status.DEBUG, "The Original Id:"+rId+"The Modified Invalid Id is :"+modId);
		exeData.add("The Original Id:"+rId+"The Modified Invalid Id is :"+modId);
		res=rps.getReport("Series",eId,modId );
		Assert.assertEquals(res.getStatusCode(), res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));	
	}
	
	
	@DataProvider(name="TC191_GetReport_Series_Test04_GetReportForSeriesWithEntityIdAsNull")
	 public  JSONObject[][] TC191_GetReport_Series_Test04_GetReportForSeriesWithEntityIdAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Series_Test04_GetReportForSeriesWithEntityIdAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Series_Test04_GetReportForSeriesWithEntityIdAsNull",groups= {"reportservice"},enabled=true)
	public void TC191_GetReport_Series_Test04_GetReportForSeriesWithEntityIdAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.getReport("Series","", rId);
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_GetReport_Series_Test05_GetReportForSeriesWithReportIdAsNull")
	 public  JSONObject[][] TC191_GetReport_Series_Test05_GetReportForSeriesWithReportIdAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Series_Test05_GetReportForSeriesWithReportIdAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Series_Test05_GetReportForSeriesWithReportIdAsNull",groups= {"reportservice"},enabled=false)//same reason as the study
	public void TC191_GetReport_Series_Test05_GetReportForSeriesWithReportIdAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.getReport("Series",eId, "");
		test.get().log(Status.DEBUG, "The Status code for the reportId as null is:"+res.getStatusCode());
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_DeleteReport_Series_Test06_GetReportForSeries")
	 public  JSONObject[][] TC191_DeleteReport_Series_Test06_GetReportForSeries() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_DeleteReport_Series_Test06_GetReportForSeries","reportservice");
	 }
	@Test(dataProvider="TC191_DeleteReport_Series_Test06_GetReportForSeries",groups= {"reportservice"},enabled=true)
	public void TC191_DeleteReport_Series_Test06_GetReportForSeries(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("Series", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.deleteReport("Series",eId, rId);
		Assert.assertEquals(res.getStatusCode(), res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));	
	}
	
	
	
	
	//Exam - Post Report
	 @DataProvider(name="TC191_CreateReport_Exam_Test01_CreateReport")
	 public  JSONObject[][] TC191_CreateReport_Exam_Test01_CreateReport() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Exam_Test01_CreateReport","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Exam_Test01_CreateReport",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Exam_Test01_CreateReport(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("study", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		if(res.getStatusCode()==201) {
			dynamicCredentials=addTextExeData("TC191_CreateReport_Exam_Test01_CreateReport", res.jsonPath().getString(rps.getREPORTENTITYID()));
			dynamicCredentials=addTextExeData("TC191_CreateReport_Exam_Test01_CreateReport", res.jsonPath().getString(rps.getCREATEDAT()));
			dynamicCredentials=addTextExeData("TC191_CreateReport_Exam_Test01_CreateReport", res.jsonPath().getString(rps.getCREATEDBy()));
		}
	}
	
	

	
	@DataProvider(name="TC191_CreateReport_Exam_Test03_CreateReportWithContentNull")
	 public  JSONObject[][] TC191_CreateReport_Exam_Test03_CreateReportWithContentNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Exam_Test03_CreateReportWithContentNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Exam_Test03_CreateReportWithContentNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Exam_Test03_CreateReportWithContentNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=rps.postReport("Exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Exam_Test04_CreateReportWithTagNull")
	 public  JSONObject[][] TC191_CreateReport_Exam_Test04_CreateReportWithTagNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Exam_Test04_CreateReportWithTagNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Exam_Test04_CreateReportWithTagNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Exam_Test04_CreateReportWithTagNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=rps.postReport("Exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Exam_Test05_CreateReportWithAdditionalInfoNull")
	 public  JSONObject[][] TC191_CreateReport_Exam_Test05_CreateReportWithAdditionalInfoNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Exam_Test05_CreateReportWithAdditionalInfoNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Exam_Test05_CreateReportWithAdditionalInfoNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Exam_Test05_CreateReportWithAdditionalInfoNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=rps.postReport("Exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	@DataProvider(name="TC191_CreateReport_Exam_Test06_CreateReportWithEntityIdNull")
	 public  JSONObject[][] TC191_CreateReport_Exam_Test06_CreateReportWithEntityIdNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Exam_Test06_CreateReportWithEntityIdNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Exam_Test06_CreateReportWithEntityIdNull",groups= {"reportservice"},enabled=true)
	public void tC191_CreateReport_Exam_Test06_CreateReportWithEntityIdNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("Exam","", (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	
	@DataProvider(name="TC191_CreateReport_Exam_Test07_CreateReportWithAllAttrAsNull")
	 public  JSONObject[][] TC191_CreateReport_Exam_Test07_CreateReportWithAllAttrAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_CreateReport_Exam_Test07_CreateReportWithAllAttrAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_CreateReport_Exam_Test07_CreateReportWithAllAttrAsNull",groups= {"reportservice"},enabled=false)// as the report cant be null and other null scenarios are covered
	public void tC191_CreateReport_Exam_Test07_CreateReportWithAllAttrAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		Map<String,Object>m= new HashMap<String,Object>();		
		System.out.println("The responses are ");
		Response res=rps.postReport("Series", "", (Map)j.get("jsonobjects"));
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	
	//Get All The Reports At Exam 
	
	

	@DataProvider(name="TC191_GetAllReports_Exam_Test01_GetAllReportsForExam")
	 public  JSONObject[][] TC191_GetAllReports_Exam_Test01_GetAllReportsForExam() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Exam_Test01_GetAllReportsForExam","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Exam_Test01_GetAllReportsForExam",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Exam_Test01_GetAllReportsForExam(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			if(res.getStatusCode()==201) {
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				l.add( res.jsonPath().getString(rps.getCREATEDAT()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}		
		res=null;
		res=rps.getAllReports("exam", eId, l.get(1));
		res.jsonPath().getList(rps.getREPORTENTITYID());
		Assert.assertEquals((res.jsonPath().getString(rps.getREPORTENTITYID()).replace("[", "").replace("]", "")), l.get(0));
		//Assert.assertEquals(res.jsonPath().getString((rps.getCREATEDAT()).replace("[[", "")).replace("]]", ""), l.get(1));
		
	}
	
	@DataProvider(name="TC191_GetAllReports_Exam_Test02_GetAllReportsForExamWithoutCreatedAt")
	 public  JSONObject[][] TC191_GetAllReports_Exam_Test02_GetAllReportsForExamWithoutCreatedAt() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Exam_Test02_GetAllReportsForExamWithoutCreatedAt","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Exam_Test02_GetAllReportsForExamWithoutCreatedAt",groups= {"reportservice"},enabled=true)
	public void TC191_GetAllReports_Exam_Test02_GetAllReportsForExamWithoutCreatedAt(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));



		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.getAllReports("exam", eId, "");
		List<String>lEids=res.jsonPath().getList(rps.getREPORTENTITYID());
		Assert.assertEquals(lEids.size(), 3);
		Assert.assertEquals(lEids.containsAll(l), true);
		
	}


	@Test(groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Exam_Test03_GetAllReportsForStudyWithoutEntityId() throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		Response res=rps.getAllReports("exam","", "");
		Assert.assertEquals(res.getStatusCode(), 404);
		
	}
	
	@DataProvider(name="TC191_GetAllReports_Exam_Test04_GetAllReportsForExamWithInvalidEntityId")
	 public  JSONObject[][] TC191_GetAllReports_Exam_Test04_GetAllReportsForExamWithInvalidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Exam_Test04_GetAllReportsForExamWithInvalidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Exam_Test04_GetAllReportsForExamWithInvalidEntityId",groups= {"reportservice"},enabled=true)
	public void TC191_GetAllReports_Exam_Test04_GetAllReportsForExamWithInvalidEntityId(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.getAllReports("exam", (String)j.get("entityid")+genCurDateString("yy-MM-dd HH-mm-ss"), "");
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	
	@DataProvider(name="TC191_GetAllReports_Exam_Test05_DeleteAllReportsForStudyWithValidEntityId")
	 public  JSONObject[][] TC191_GetAllReports_Exam_Test05_DeleteAllReportsForStudyWithValidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Exam_Test05_DeleteAllReportsForStudyWithValidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Exam_Test05_DeleteAllReportsForStudyWithValidEntityId",groups= {"reportservice"},enabled=true)
	public void tC191_GetAllReports_Exam_Test05_DeleteAllReportsForStudyWithValidEntityId(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		System.out.println("The successful report created are :"+m2);
		res=null;
		res=rps.deleteAllReports("exam", eId);
		Assert.assertEquals(res.getStatusCode(), 405);

	}
	
	
	@DataProvider(name="TC191_GetAllReports_Exam_Test06_GetAllReportsForExamWithInvalidClustername")
	 public  JSONObject[][] TC191_GetAllReports_Exam_Test06_GetAllReportsForExamWithInvalidClustername() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetAllReports_Exam_Test06_GetAllReportsForExamWithInvalidClustername","reportservice");
	 }
	@Test(dataProvider="TC191_GetAllReports_Exam_Test06_GetAllReportsForExamWithInvalidClustername",groups= {"reportservice"},enabled=true)
	public void TC191_GetAllReports_Exam_Test06_GetAllReportsForExamWithInvalidClustername(JSONObject j) throws Exception
	{	
		Map<String,List<String>>m2=new HashMap<String,List<String>>();
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		List<String>l=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				l.add( res.jsonPath().getString(rps.getREPORTENTITYID()));
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
		m2.put(eId, l);
		
		System.out.println("The successful report created are :"+m2);
		res=rps.getAllReports("study", eId, "");
		Assert.assertEquals(res.getStatusCode(),404);
		res=null;
		res=rps.getAllReports("series", eId, "");
		Assert.assertEquals(res.getStatusCode(),404);
		
	}
	
	//Get Report At Exam Level
	
	@DataProvider(name="TC191_GetReport_Exam_Test01_GetReportForExam")
	 public  JSONObject[][] TC191_GetReport_Exam_Test01_GetReportForExam() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Exam_Test01_GetReportForExam","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Exam_Test01_GetReportForExam",groups= {"reportservice"},enabled=true)
	public void tC191_GetReport_Exam_Test01_GetReportForExam(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		
		res=rps.getReport("exam", eId, rId);
		Assert.assertEquals(res.getStatusCode(),Integer.parseInt((String)j.get("expCode")) );
		Assert.assertEquals(res.jsonPath().getString(rps.getREPORTENTITYID()),rId);
		Assert.assertEquals(res.jsonPath().getString(rps.getREFENTITYID()), eId);
		
	}
	
	
	@DataProvider(name="TC191_GetReport_Exam_Test02_GetReportForExamWithInvalidEntityId")
	 public  JSONObject[][] TC191_GetReport_Exam_Test02_GetReportForExamWithInvalidEntityId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Exam_Test02_GetReportForExamWithInvalidEntityId","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Exam_Test02_GetReportForExamWithInvalidEntityId",groups= {"reportservice"},enabled=true)
	public void tC191_GetReport_Exam_Test02_GetReportForExamWithInvalidEntityId(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		
		res=rps.getReport("exam", (String)j.get("entityid")+genCurDateString("yy-MM-dd HH-mm-ss"), rId);
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_GetReport_Exam_Test03_GetReportForExamWithInvalidReportId")
	 public  JSONObject[][] TC191_GetReport_Exam_Test03_GetReportForExamWithInvalidReportId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Exam_Test03_GetReportForExamWithInvalidReportId","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Exam_Test03_GetReportForExamWithInvalidReportId",groups= {"reportservice"},enabled=true)
	public void TC191_GetReport_Exam_Test03_GetReportForExamWithInvalidReportId(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		String modId=rId.replace(rId.substring(rId.length()-2), "su1");
		test.get().log(Status.DEBUG, "The Original Id:"+rId+"The Modified Invalid Id is :"+modId);
		exeData.add("The Original Id:"+rId+"The Modified Invalid Id is :"+modId);
		res=rps.getReport("Series",eId,modId );
		Assert.assertEquals(res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));	
	}
	
	
	@DataProvider(name="TC191_GetReport_Exam_Test04_GetReportForExamWithEntityIdAsNull")
	 public  JSONObject[][] TC191_GetReport_Exam_Test04_GetReportForExamWithEntityIdAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Exam_Test04_GetReportForExamWithEntityIdAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Exam_Test04_GetReportForExamWithEntityIdAsNull",groups= {"reportservice"},enabled=true)
	public void TC191_GetReport_Exam_Test04_GetReportForExamWithEntityIdAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));


		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.getReport("exam","", rId);
		Assert.assertEquals( res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_GetReport_Exam_Test05_GetReportForExamWithReportIdAsNull")
	 public  JSONObject[][] TC191_GetReport_Exam_Test05_GetReportForExamWithReportIdAsNull() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_GetReport_Exam_Test05_GetReportForExamWithReportIdAsNull","reportservice");
	 }
	@Test(dataProvider="TC191_GetReport_Exam_Test05_GetReportForExamWithReportIdAsNull",groups= {"reportservice"},enabled=false)// same reason as study
	public void TC191_GetReport_Exam_Test05_GetReportForExamWithReportIdAsNull(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.getReport("exam",eId, "");
		test.get().log(Status.DEBUG, "The Status code for the reportId as null is:"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));
	}
	
	
	@DataProvider(name="TC191_DeleteReport_Exam_Test06_GetReportForExam")
	 public  JSONObject[][] TC191_DeleteReport_Exam_Test06_GetReportForExam() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC191_DeleteReport_Exam_Test06_GetReportForExam","reportservice");
	 }
	@Test(dataProvider="TC191_DeleteReport_Exam_Test06_GetReportForExam",groups= {"reportservice"},enabled=true)
	public void TC191_DeleteReport_Exam_Test06_GetReportForExam(JSONObject j) throws Exception
	{	
		MDPReportService rps=new MDPReportService();	
		sleepTimer(5);
		j.replace("entityid", ((String)j.get("entityid")+getSecString().substring(1)+getMinString()+"."+genCurDateString("yy-MM-dd")+"."+getHourString()));

		Response res=null;
		String eId=null;
		String rId=null;
		for(int i=0;i<3;i++)
		{
			System.out.println("The responses for createreport are ");
			res=rps.postReport("exam", (String)j.get("entityid"), (Map)j.get("jsonobjects"));
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			if(res.getStatusCode()==201) {
				
				rId= res.jsonPath().getString(rps.getREPORTENTITYID());
				eId=res.jsonPath().getString(rps.getREFENTITYID());				
			}			
		}
	
		sleepTimer(3);
		res=rps.deleteReport("exam",eId, rId);
		Assert.assertEquals(res.getStatusCode(),Integer.parseInt((String)j.get("expCode")));	
	}
	
	

	
}
