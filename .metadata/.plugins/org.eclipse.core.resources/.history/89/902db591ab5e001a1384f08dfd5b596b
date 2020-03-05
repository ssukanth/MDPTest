package com.mdp.api.tests;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mdp.api.services.MDPPatientService;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MDPPatientTests extends TestBase {
	public ArrayList<String>listPatientIds=new ArrayList<String>();
	public ArrayList<String>listPatNames=new ArrayList<String>();
	public ArrayList<String>listDobs=new ArrayList<String>();
	 @DataProvider(name="TC192_CreatePatient_Test01_CreatePatientValid")
	 public  JSONObject[][] TC192_CreatePatient_Test01_CreatePatientValid() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_CreatePatient_Test01_CreatePatientValid","patientservice");
	 }
	@Test(dataProvider="TC192_CreatePatient_Test01_CreatePatientValid",groups= {"patientservice"},enabled=true)
	public void TC192_CreatePatient_Test01_CreatePatientValid(JSONObject j) throws Exception
	{	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		test.get().log(Status.DEBUG, "Ceated the patinet with response :"+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		if(res.getStatusCode()==201) {
			String pId=res.jsonPath().getString(mps.getENTITYID());
			String name=res.jsonPath().getString(mps.getGIVENNAME());
			System.out.println(name);
			listPatientIds.add(res.jsonPath().getString(mps.getPATIENTID()));
			//test.get().log(Status.DEBUG, markup)
			dynamicCredentials=addTextExeData("TC192_CreatePatient_Test01_CreatePatientValid", pId);
			
		}
	}
	
	
	 @DataProvider(name="tC192_Test02_Create_Patient_With_Invalid_less_than_ten_digits")
	 public  JSONObject[][] datatC192_Test02_Create_Patient_With_Invalid_less_than_ten_digits() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test02_Create_Patient_With_Invalid_less_than_ten_digits","patientservice");
	 }
	@Test(dataProvider="tC192_Test02_Create_Patient_With_Invalid_less_than_ten_digits",groups= {"patientservice"},enabled=false)
	public void tC192_CreatePatient_Test02_Create_Patient_With_Invalid_less_than_ten_digits(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	 @DataProvider(name="TC192_Test03_Create_Patient_With_Invalid_more_than_twelve_digits")
	 public  JSONObject[][] datTC192_Test03_Create_Patient_With_Invalid_more_than_twelve_digits() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test03_Create_Patient_With_Invalid_more_than_twelve_digits","patientservice");
	 }
	@Test(dataProvider="TC192_Test03_Create_Patient_With_Invalid_more_than_twelve_digits",groups= {"patientservice"},enabled=false)
	public void TC192_CreatePatient_Test03_Create_Patient_With_Invalid_more_than_twelve_digits(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	 @DataProvider(name="TC192_Test04_Create_Patient_Invalid_Email_Id")
	 public  JSONObject[][] datTC192_Test04_Create_Patient_Invalid_Email_Id() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test04_Create_Patient_Invalid_Email_Id","patientservice");
	 }
	@Test(dataProvider="TC192_Test04_Create_Patient_Invalid_Email_Id",groups= {"patientservice"},enabled=false)//obselete as there is no email validation
	public void tC192_CreatePatient_Test04_Create_Patient_Invalid_Email_Id(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));

	}
	
	 @DataProvider(name="TC192_Test05_Create_Patient_Valid_With_Issuer_Of_PatientId_as_null")
	 public  JSONObject[][] datTC192_Test05_Create_Patient_Valid_With_Issuer_Of_PatientId_as_null() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test05_Create_Patient_Valid_With_Issuer_Of_PatientId_as_null","patientservice");
	 }
	@Test(dataProvider="TC192_Test05_Create_Patient_Valid_With_Issuer_Of_PatientId_as_null",groups= {"patientservice"},enabled=false)//obselete as the issuer of patinet id can be null
	public void tC192_CreatePatient_Test05_Create_Patient_Valid_With_Issuer_Of_PatientId_as_null(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	 @DataProvider(name="TC192_Test06_Create_Patient_With_null_for_PatientId")
	 public  JSONObject[][] datTC192_Test06_Create_Patient_With_null_for_PatientId() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test06_Create_Patient_With_null_for_PatientId","patientservice");
	 }
	@Test(dataProvider="TC192_Test06_Create_Patient_With_null_for_PatientId",groups= {"patientservice"},enabled=true)
	public void tC192_CreatePatient_Test06_Create_Patient_With_null_for_PatientId(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		m.put(mps.getPATIENTID(), "");
		Response res=mps.postCreatePatient(false,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	 @DataProvider(name="TC192_Test07_Create_Patient_With_date_format_mm_dd_yyyy")
	 public  JSONObject[][] datTC192_Test07_Create_Patient_With_date_format_mm_dd_yyyy() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test07_Create_Patient_With_date_format_mm_dd_yyyy","patientservice");
	 }
	@Test(dataProvider="TC192_Test07_Create_Patient_With_date_format_mm_dd_yyyy",groups= {"patientservice"},enabled=true)
	public void tC192_CreatePatient_Test07_Create_Patient_With_date_format_mm_dd_yyyy(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	 @DataProvider(name="TC192_Test08_Create_Patient_With_date_format_yyyy_dd_mm")
	 public  JSONObject[][] TC192_Test08_Create_Patient_With_date_format_yyyy_dd_mm() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test08_Create_Patient_With_date_format_yyyy_dd_mm","patientservice");
	 }
	@Test(dataProvider="TC192_Test08_Create_Patient_With_date_format_yyyy_dd_mm",groups= {"patientservice"},enabled=true)
	public void TC192_CreatePatient_Test08_Create_Patient_With_date_format_yyyy_dd_mm(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	 @DataProvider(name="TC192_Test09_Create_Patient_With_date_format_yyyy_mm_d")
	 public  JSONObject[][] TC192_Test09_Create_Patient_With_date_format_yyyy_mm_d() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test09_Create_Patient_With_date_format_yyyy_mm_d","patientservice");
	 }
	@Test(dataProvider="TC192_Test09_Create_Patient_With_date_format_yyyy_mm_d",groups= {"patientservice"},enabled=true)
	public void TC192_CreatePatient_Test09_Create_Patient_With_date_format_yyyy_mm_d(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));

	}
	
	 @DataProvider(name="TC192_Test10_Create_Patient_With_Invalid_Future_Date")
	 public  JSONObject[][] TC192_Test10_Create_Patient_With_Invalid_Future_Date() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test10_Create_Patient_With_Invalid_Future_Date","patientservice");
	 }
	@Test(dataProvider="TC192_Test10_Create_Patient_With_Invalid_Future_Date",groups= {"patientservice"},enabled=true)
	public void TC192_CreatePatient_Test10_Create_Patient_With_Invalid_Future_Date(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		m.put(mps.getDOB(), getFutdateInMSFormat(1));
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	 @DataProvider(name="TC192_Test11_Create_Patient_Invalid_Gender")
	 public  JSONObject[][] TC192_Test11_Create_Patient_Invalid_Gender() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test11_Create_Patient_Invalid_Gender","patientservice");
	 }
	@Test(dataProvider="TC192_Test11_Create_Patient_Invalid_Gender",groups= {"patientservice"},enabled=true)
	public void tC192_CreatePatient_Test11_Create_Patient_Invalid_Gender(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	 @DataProvider(name="TC192_Test12_Create_Patient_Invalid_Gender_As_null")
	 public  JSONObject[][] TC192_Test12_Create_Patient_Invalid_Gender_As_null() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_Test12_Create_Patient_Invalid_Gender_As_null","patientservice");
	 }
	@Test(dataProvider="TC192_Test12_Create_Patient_Invalid_Gender_As_null",groups= {"patientservice"},enabled=true)
	public void tC192_CreatePatient_Test12_Create_Patient_Invalid_Gender_As_null(JSONObject j) throws Exception
	{
	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	

	
	 @DataProvider(name="TC192_CreatePatient_Test13_CreatePatient_InvalidPayload")
	 public  JSONObject[][] TC192_CreatePatient_Test13_CreatePatient_InvalidPayload() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_CreatePatient_Test13_CreatePatient_InvalidPayload","patientservice");
	 }
	@Test(dataProvider="TC192_CreatePatient_Test13_CreatePatient_InvalidPayload",groups= {"patientservice"},enabled=true)
	public void TC192_CreatePatient_Test13_CreatePatient_InvalidPayload(JSONObject j) throws Exception
	{	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatientInvalid(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		test.get().log(Status.DEBUG, "Ceated the patinet with response :"+res.body().asString());
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
		
	}
	
	
	@DataProvider(name="TC192_CreatePatient_Test14_CreatePatient_DuplicateWithConflictTrue")
	 public  JSONObject[][] TC192_CreatePatient_Test14_CreatePatient_DuplicateWithConflictTrue() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_CreatePatient_Test14_CreatePatient_DuplicateWithConflictTrue","patientservice");
	 }
	@Test(dataProvider="TC192_CreatePatient_Test14_CreatePatient_DuplicateWithConflictTrue",groups= {"patientservice"},enabled=true)
	public void TC192_CreatePatient_Test14_CreatePatient_DuplicateWithConflictTrue(JSONObject j) throws Exception
	{	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		test.get().log(Status.DEBUG, "Ceated the patinet with response :"+res.body().asString());
		Assert.assertEquals(res.getStatusCode(), 201);
		String pId=res.jsonPath().getString(mps.getPATIENTID());
		m.put(mps.getPATIENTID(), pId);
		res=null;
		res=mps.postCreatePatient(false,(String)j.get("accountId"),(String)j.get("conflict"),m );
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));

	}
	
	
	
	@DataProvider(name="TC192_CreatePatient_Test15_CreatePatient_DuplicateWithConflictFalse")
	 public  JSONObject[][] TC192_CreatePatient_Test15_CreatePatient_DuplicateWithConflictFalse() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC192_CreatePatient_Test15_CreatePatient_DuplicateWithConflictFalse","patientservice");
	 }
	@Test(dataProvider="TC192_CreatePatient_Test15_CreatePatient_DuplicateWithConflictFalse",groups= {"patientservice"},enabled=true)
	public void TC192_CreatePatient_Test15_CreatePatient_DuplicateWithConflictFalse(JSONObject j) throws Exception
	{	
		test.get().log(Status.DEBUG, "The Scenario name is :"+j.get("scname"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}	
		Response res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		System.out.println("The responses are ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
		test.get().log(Status.DEBUG, "Ceated the patinet with response :"+res.body().asString());
		Assert.assertEquals(res.getStatusCode(), 201);
		String pId=res.jsonPath().getString(mps.getPATIENTID());
		m.put(mps.getPATIENTID(), pId);
		res=null;
		res=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));

	}
	
	
	
	//GetAllPatients
	
	  @DataProvider(name="TC192_Test01_GetallthepatientsByAcc")
	  public  JSONObject[][] TC192_Test01_GetallthepatientsByAcc() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test01_GetallthepatientsByAcc","patientservice");
	  }
	
	@Test(dataProvider = "TC192_Test01_GetallthepatientsByAcc",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"})
	public void tC192_GetAllPatients_Test01_GetallthepatientsByAcc(JSONObject j) throws Exception
	{
		MDPPatientService mps=new MDPPatientService();
		Response res=res=mps.get_AllPatients((String)j.get("accountId"), null);
		System.out.println("The res for get pat by acc:"+res.asString());
		//verifying whether all the created ids are in the list
		List<String>l=new ArrayList<String>();
		l.addAll(dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid"));
		test.get().log(Status.DEBUG, "The records to search are :"+l);
		mps.checkRecordsInGetAllPatientResponse(mps.getENTITYID(), res, l);
		System.out.println("The data at the end:"+dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid"));
	}
	
	
	  @DataProvider(name="TC192_Test02_GetallthepatientsByAccAndAppType")
	  public  JSONObject[][] TC192_Test02_GetallthepatientsByAccAndAppType() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test02_GetallthepatientsByAccAndAppType","patientservice");
	  }
	
	@Test(dataProvider = "TC192_Test02_GetallthepatientsByAccAndAppType",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"})
	public void tC192_GetAllPatients_Test02_GetallthepatientsByAccAndAppType(JSONObject j) throws Exception
	{
		MDPPatientService mps=new MDPPatientService();
		Map<String,String>mp=(Map<String,String>)j.get("qparams");
		Response res=res=mps.get_AllPatients((String)j.get("accountId"),mp );
		
		//verifying whether all the created ids are in the list
		List<String>l=new ArrayList<String>();
		l.addAll(dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid"));
		test.get().log(Status.DEBUG, "The records to search are :"+l);
		mps.checkRecordsInGetAllPatientResponse(mps.getENTITYID(), res, l);
	}
	
	  @DataProvider(name="TC192_Test03_GetallthepatientsByAccandSearchName")
	  public  JSONObject[][] TC192_Test03_GetallthepatientsByAccandSearchName() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test03_GetallthepatientsByAccandSearchName","patientservice");
	  }
	
	@Test(dataProvider = "TC192_Test03_GetallthepatientsByAccandSearchName",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"})
	public void tC192_GetAllPatients_Test03_GetallthepatientsByAccandSearchName(JSONObject j) throws Exception
	{
		List pEid=new ArrayList();
		List liPname=new ArrayList();
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid"));
		MDPPatientService mps=new MDPPatientService();
		//postcall for pat creation
		Map<String,Object>m= new HashMap<String,Object>();
		for(int i=0;i<5;i++)
		{
			
			m.put(mps.getGIVENNAME(), "GivenName"+getDateString());	
			Response res1=mps.postCreatePatient(false, (String)j.get("accountId"),"false",m );
			liPname.add(res1.jsonPath().getString(mps.getGIVENNAME()));
			pEid.add(res1.jsonPath().getString(mps.getENTITYID()));
			sleepTimer(1);
		}	
		StringBuilder str=null;
		//getcalls
		for(int i=0;i<pEid.size();i++)
		{
			
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("SearchQuery", (String) liPname.get(i));
			Response res=res=mps.get_AllPatients((String)j.get("accountId"),mp );
			Assert.assertEquals(res.getStatusCode(), 200);
			str=new StringBuilder(res.jsonPath().getString(mps.getENTITYID()).replace("[", "").replace("]", ""));
			System.out.println("The xyzis:"+str);
			Assert.assertEquals(str.toString(), pEid.get(i));
			str=new StringBuilder(res.jsonPath().getString(mps.getGIVENNAME()).replace("[", "").replace("]", ""));
			System.out.println("The xyzis:"+str);
			Assert.assertEquals(str.toString(), liPname.get(i));
			test.get().log(Status.DEBUG, "The Record foudn for+"+liPname.get(i));
			
		}
	}
	  @DataProvider(name="TC192_Test04_GetallthepatientsByAccandSearchPatId")
	  public  JSONObject[][] TC192_Test04_GetallthepatientsByAccandSearchPatId() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test04_GetallthepatientsByAccandSearchPatId","patientservice");
	  }
	
	@Test(dataProvider = "TC192_Test04_GetallthepatientsByAccandSearchPatId",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"})
	public void tC192_GetAllPatients_Test04_GetallthepatientsByAccandSearchPatId(JSONObject j) throws Exception
	{
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid"));
		MDPPatientService mps=new MDPPatientService();
		Response res=null;
		for(String pI: listPatientIds)
		{
			Map<String,String>mp=new HashMap<String,String>();
			mp.put("SearchQuery", pI);
			res=mps.get_AllPatients((String)j.get("accountId"),mp );;
			Assert.assertEquals(res.getStatusCode(), 200);
			test.get().log(Status.DEBUG, "The record for the patient id :"+pI+" in the resp: "+res.jsonPath().getString(mps.getPATIENTID()));	
		}
		
	}
	  @DataProvider(name="TC192_Test05_GetallthepatientsByAccandSearchDOB")
	  public  JSONObject[][] TC192_Test05_GetallthepatientsByAccandSearchDOB() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test05_GetallthepatientsByAccandSearchDOB","patientservice");
	  }
	
	@Test(dataProvider = "TC192_Test05_GetallthepatientsByAccandSearchDOB",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"})
	public void TC192_GetAllPatients_Test05_GetallthepatientsByAccandSearchDOB(JSONObject j) throws Exception
	{
		MDPPatientService mps=new MDPPatientService();
		Map<String,Object>m= new HashMap<String,Object>();
		//getcalls
		Map<String,String>mp=(Map<String,String>)j.get("qparams");
		Response res=res=mps.get_AllPatients((String)j.get("accountId"),mp );
		//verifying whether all the created ids are in the list
		test.get().log(Status.DEBUG, "The records to search are :"+listDobs);
		mps.checkRecordsInGetAllPatientResponse(mps.getGIVENNAME(), res, listDobs);
	
	}
	  @DataProvider(name="TC192_Test07_GetallthepatientsByAccandPageSizeLessThan10")
	  public  JSONObject[][] TC192_Test07_GetallthepatientsByAccandPageSizeLessThan10() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test07_GetallthepatientsByAccandPageSizeLessThan10","patientservice");
	  }
	
	@Test(dataProvider = "TC192_Test07_GetallthepatientsByAccandPageSizeLessThan10",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"})
	public void tC192_GetAllPatients_Test07_GetallthepatientsByAccandPageSizeLessThan10(JSONObject j) throws Exception
	{
		System.out.println("The data before taking into list:"+dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid"));
		MDPPatientService mps=new MDPPatientService();
		Map<String,String>mp=(Map<String,String>)j.get("qparams");
		Response res=res=mps.get_AllPatients((String)j.get("accountId"),mp );;
		JSONParser jp= new JSONParser();
		JSONArray resArray=(JSONArray)jp.parse(res.asString());
		Assert.assertEquals(resArray.size(),Integer.parseInt((String)mp.get("PageSize")) );
	}
	
	  @DataProvider(name="TC192_Test08_GetallthepatientsByAccandPageSizeGrtThan10")
	  public  JSONObject[][] TC192_Test08_GetallthepatientsByAccandPageSizeGrtThan10() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test08_GetallthepatientsByAccandPageSizeGrtThan10","patientservice");
	  }
	
	  @Test(dataProvider = "TC192_Test08_GetallthepatientsByAccandPageSizeGrtThan10",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"})
		public void tC192_GetAllPatients_Test08_GetallthepatientsByAccandPageSizeGrtThan10(JSONObject j) throws Exception
		{
			System.out.println("The data before taking into list:"+dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid"));
			MDPPatientService mps=new MDPPatientService();
			Map<String,String>mp=(Map<String,String>)j.get("qparams");
			Response res=res=mps.get_AllPatients((String)j.get("accountId"),mp );;
			JSONParser jp= new JSONParser();
			JSONArray resArray=(JSONArray)jp.parse(res.asString());
			Assert.assertEquals(resArray.size(),Integer.parseInt((String)mp.get("PageSize")) );
		}
	
	  
	  @DataProvider(name="TC192_Test09_GetallthepatientsByAccandAllparams")
	  public  JSONObject[][] TC192_Test09_GetallthepatientsByAccandAllparams() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test09_GetallthepatientsByAccandAllparams","patientservice");
	  }
	
	  @Test(dataProvider = "TC192_Test09_GetallthepatientsByAccandAllparams",dependsOnMethods = {"TC192_CreatePatient_Test01_CreatePatientValid"},groups= {"patientservice"},enabled=true)
		public void tC192_GetAllPatients_Test09_GetallthepatientsByAccandAllparams(JSONObject j) throws Exception
		{
		  	List<String>patis=new ArrayList();
		  	List<String>patnams=new ArrayList();;
		  	List<String>pattype=new ArrayList();;
		  	Response res=null;
			MDPPatientService mps=new MDPPatientService();
			Map<String,String>mp=(Map<String,String>)j.get("qparams");

			Map<String,Object>m= new HashMap<String,Object>();
			for(int i=0;i<5;i++)
			{
				
				m.put(mps.getGIVENNAME(), "GivenName"+getDateString());
				m.put(mps.getAPPTYPE(),"TestApp"+getDateString());
				res=mps.postCreatePatient(true, (String)j.get("accountId"),"false",m );
				sleepTimer(1);
				System.out.println("The res for all the params:"+res.asString());
				patis.add(res.jsonPath().getString(mps.getENTITYID()));
				patnams.add(res.jsonPath().getString(mps.getGIVENNAME()));
				pattype.add(res.jsonPath().getString(mps.getAPPTYPE()));
			}
			
			for(int i=0;i<patis.size();i++)
			{
				StringBuilder str=null;
				mp.put("ApplicationType", pattype.get(i));
				mp.put("SearchQuery", patnams.get(i));
				mp.put("PageSize", "3");
				res=mps.get_AllPatients((String)j.get("accountId"),mp );	
				Assert.assertEquals(res.getStatusCode(), 200);
				str=new StringBuilder(res.jsonPath().getString(mps.getENTITYID()).replace("[", "").replace("]", ""));
				Assert.assertEquals(str.toString(), patis.get(i));
			}	
		}
	  
	  
	  //GetPatient
	  @DataProvider(name="TC192_Test01_GetPatientById")
	  public  JSONObject[][] TC192_Test01_GetPatientById() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test01_GetPatientById");
	  }
	
	  
	  @Test(dataProvider="TC192_Test01_GetPatientById",groups= {"patientservice","patientservice"},enabled=true)
		public void TC192_GetPatientById_Test01_GetPatientById(JSONObject j) throws Exception
		{
			MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobjects")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res=mps.postCreatePatient(true, (String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res.getStatusCode());
			test.get().log(Status.DEBUG, "Ceated the patinet with response :"+res.body().asString());

			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			String pId=null;
			if(res.getStatusCode()==201) {
				test.get().log(Status.PASS, "Ceated the patinet with response :"+res.body().asString());
				pId=res.jsonPath().getString(mps.getENTITYID());
				test.get().log(Status.DEBUG, "Created the patient with data: "+pId);
			}
			Response res2=mps.getPatientById((String)j.get("accountId"), pId);
			String name=res2.jsonPath().getString(mps.getGIVENNAME());
			String sex=res2.jsonPath().getString(mps.getSEX());
			String dob=res2.jsonPath().getString(mps.getDOB());
			String fName=res2.jsonPath().getString(mps.getFAMILYNAME());
			String phNum=res2.jsonPath().getString(mps.getPATIENTPHONE());
			String mail=res2.jsonPath().getString(mps.getPATIENTEMAIL());
			test.get().log(Status.DEBUG, "Returned data: "+pId+"-"+name+"-"+sex+"-"+dob+"-"+fName+"-"+phNum+"-"+mail);
			Assert.assertEquals(name, m.get(mps.getGIVENNAME()));
			Assert.assertEquals(fName, m.get(mps.getFAMILYNAME()));
			//Assert.assertEquals(sex, m.get(mps.getSEX()));
			//Assert.assertEquals(dob, m.get(mps.getDOB()));
			//Assert.assertEquals(phNum, m.get(mps.getPATIENTPHONE()));
			//Assert.assertEquals(mail, m.get(mps.getPATIENTEMAIL()));
			test.get().log(Status.PASS, "Record foudn as expeced using Get Patient");
		}
	  
	  
	  @DataProvider(name="TC192_Test02_GetPatientByIdWithInvalidId")
	  public  JSONObject[][] TC192_Test02_GetPatientByIdWithInvalidId() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test02_GetPatientByIdWithInvalidId","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test02_GetPatientByIdWithInvalidId",groups= {"patientservice"},enabled=true)
		public void tC192_Test02_GetPatientByIdWithInvalidId(JSONObject j) throws Exception
		{
		  MDPPatientService mps=new MDPPatientService();
		 // String validPatEntId=dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid").get(0);
			Response res=mps.getPatientById((String)j.get("accountId"), "12345678-029c-48af-9224-c72f071f6e91");
			Assert.assertEquals(res.getStatusCode(), 404);
		}
	  @Test(groups= {"patientservice"},enabled=true)
		public void TC192_GetPatientById_TC03_GetPatientByIdWithInvalidAccountId() throws Exception
	  {
		  MDPPatientService mps=new MDPPatientService();
		  String validPatEntId=dynamicCredentials.get("TC192_CreatePatient_Test01_CreatePatientValid").get(0);
			Response res=mps.getPatientById("f19bb71e-350a-4b8e-1234-08d753040250", validPatEntId);
			Assert.assertEquals(res.getStatusCode(), 404);
		}
	  
	  
	  //PutPatient
	  @DataProvider(name="TC192_Test01_PutPatient_EditPatientWithMandatoryFields")
	  public  JSONObject[][] TC192_Test01_PutPatient_EditPatientWithMandatoryFields() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test01_PutPatient_EditPatientWithMandatoryFields","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test01_PutPatient_EditPatientWithMandatoryFields",groups= {"patientservice"},enabled=true)
		public void tC192_Test01_PutPatient_EditPatientWithMandatoryFields(JSONObject j) throws Exception
		{
		  
		  // for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			String eId=null;
			String pId=null;
			String gname=null;
			String fname=null;
			String sex=null;
			String dob=null;
			Long ph=null;
			String em=null;
			String apptype=null;
			
			if(res.getStatusCode()==200) {
				eId=res.jsonPath().getString(mps.getENTITYID());
				pId=res.jsonPath().getString(mps.getPATIENTID());
				gname=res.jsonPath().getString(mps.getGIVENNAME());
				fname=res.jsonPath().getString(mps.getFAMILYNAME());
				sex=res.jsonPath().getString(mps.getSEX());
				dob=res.jsonPath().getString(mps.getDOB());
				ph=res.jsonPath().getLong(mps.getPATIENTPHONE());
				em=res.jsonPath().getString(mps.getPATIENTEMAIL());
				apptype=res.jsonPath().getString(mps.getAPPTYPE());	
			}
			
			
			try {
				Assert.assertEquals(pId, res1.jsonPath().get(mps.getPATIENTID()));
				Assert.assertEquals(gname,(String)((Map)j.get("jsonobject1")).get("GIVENNAME"));
				Assert.assertEquals(fname,(String)((Map)j.get("jsonobject1")).get("FAMILYNAME"));
				//Assert.assertEquals(sex, (String)((Map)j.get("jsonobject1")).get("SEX"));
				Assert.assertEquals(dob, (String)((Map)j.get("jsonobject1")).get("DOB"));
				Assert.assertEquals(ph, (Long)((Map)j.get("jsonobject1")).get("PATIENTPHONE"));
				Assert.assertEquals(em, (String)((Map)j.get("jsonobject1")).get("PATIENTEMAIL"));
				Assert.assertEquals(apptype, (String)((Map)j.get("jsonobject1")).get("APPTYPE"));

			}catch(Exception e) {
				exeData.add("Error Caused Due to :"+e.getMessage());
				test.get().log(Status.FAIL, "Error Caused Due to :"+e.getMessage());
				throw new Exception("The fields are not getting updated as expected with Exception : "+e.getMessage());

			}
		}
		//Added From Here
	  
	  
	  @DataProvider(name="TC192_Test02_PutPatient_EditPatientWithMandatoryFieldSexAsNull")
	  public  JSONObject[][] TC192_Test02_PutPatient_EditPatientWithMandatoryFieldSexAsNull() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test02_PutPatient_EditPatientWithMandatoryFieldSexAsNull","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test02_PutPatient_EditPatientWithMandatoryFieldSexAsNull",groups= {"patientservice"},enabled=true)
		public void TC192_Test02_PutPatient_EditPatientWithMandatoryFieldSexAsNull(JSONObject j) throws Exception
		{
		  
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			
		}
	  
	  @DataProvider(name="TC192_Test03_PutPatient_EditPatientWithMandatoryFieldDOBNull")
	  public  JSONObject[][] TC192_Test03_EditPatientWithMandatoryFieldDOBNull() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test03_PutPatient_EditPatientWithMandatoryFieldDOBNull","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test03_PutPatient_EditPatientWithMandatoryFieldDOBNull",groups= {"patientservice"},enabled=true)
		public void tC192_Test03_PutPatient_EditPatientWithMandatoryFieldDOBNull(JSONObject j) throws Exception
		{
		  
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  @DataProvider(name="TC192_Test04_PutPatient_EditPatientWithMandatoryFieldFamilyAndGivenNameNull")
	  public  JSONObject[][] TC192_Test04_PutPatient_EditPatientWithMandatoryFieldFamilyAndGivenNameNull() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test04_PutPatient_EditPatientWithMandatoryFieldFamilyAndGivenNameNull","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test04_PutPatient_EditPatientWithMandatoryFieldFamilyAndGivenNameNull",groups= {"patientservice"},enabled=true)
		public void tC192_Test04_PutPatient_EditPatientWithMandatoryFieldFamilyAndGivenNameNull(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  @DataProvider(name="TC192_Test05_PutPatient_EditPatientWithMandatoryFieldApplicationTypeNull")
	  public  JSONObject[][] TC192_Test05_PutPatient_EditPatientWithMandatoryFieldApplicationTypeNull() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test05_PutPatient_EditPatientWithMandatoryFieldApplicationTypeNull","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test05_PutPatient_EditPatientWithMandatoryFieldApplicationTypeNull",groups= {"patientservice"},enabled=true)
		public void tC192_Test05_PutPatient_EditPatientWithMandatoryFieldApplicationTypeNull(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  @DataProvider(name="TC192_Test06_PutPatient_EditPatientWithMandatoryFieldPatientIdNull")
	  public  JSONObject[][] TC192_Test06_PutPatient_EditPatientWithMandatoryFieldPatientIdNull() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test06_PutPatient_EditPatientWithMandatoryFieldPatientIdNull","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test06_PutPatient_EditPatientWithMandatoryFieldPatientIdNull",groups= {"patientservice"},enabled=true)
		public void tC192_Test06_PutPatient_EditPatientWithMandatoryFieldPatientIdNull(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			//m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  @DataProvider(name="TC192_Test07_PutPatient_EditPatientWithMandatoryFieldPhonenumberNull")
	  public  JSONObject[][] TC192_Test07_PutPatient_EditPatientWithMandatoryFieldPhonenumberNull() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test07_PutPatient_EditPatientWithMandatoryFieldPhonenumberNull","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test07_PutPatient_EditPatientWithMandatoryFieldPhonenumberNull",groups= {"patientservice"},enabled=true)
		public void tC192_Test07_PutPatient_EditPatientWithMandatoryFieldPhonenumberNull(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  @DataProvider(name="TC192_Test08_PutPatient_EditPatientWithMandatoryFieldEmailNull")
	  public  JSONObject[][] TC192_Test08_PutPatient_EditPatientWithMandatoryFieldEmailNull() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test08_PutPatient_EditPatientWithMandatoryFieldEmailNull","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test08_PutPatient_EditPatientWithMandatoryFieldEmailNull",groups= {"patientservice"},enabled=true)
		public void tC192_Test08_PutPatient_EditPatientWithMandatoryFieldEmailNull(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  @DataProvider(name="TC192_Test09_PutPatient_EditPatientWithInvalidDateFormatDDMMYYYHHMMSS")
	  public  JSONObject[][] TC192_Test09_PutPatient_EditPatientWithInvalidDateFormatDDMMYYYHHMMSS() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test09_PutPatient_EditPatientWithInvalidDateFormatDDMMYYYHHMMSS","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test09_PutPatient_EditPatientWithInvalidDateFormatDDMMYYYHHMMSS",groups= {"patientservice"},enabled=true)
		public void TC192_Test09_PutPatient_EditPatientWithInvalidDateFormatDDMMYYYHHMMSS(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			
		}
	  
	  @DataProvider(name="TC192_Test10_PutPatient_EditPatientWithInvalidDateFormatYYYYDDMMSS")
	  public  JSONObject[][] TC192_Test10_PutPatient_EditPatientWithInvalidDateFormatYYYYDDMMSS() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test10_PutPatient_EditPatientWithInvalidDateFormatYYYYDDMMSS","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test10_PutPatient_EditPatientWithInvalidDateFormatYYYYDDMMSS",groups= {"patientservice"},enabled=true)
		public void tC192_Test10_PutPatient_EditPatientWithInvalidDateFormatYYYYDDMMSS(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  @DataProvider(name="TC192_Test11_PutPatient_EditPatientWithInvalidDateFormatDDMMYYY")
	  public  JSONObject[][] TC192_Test11_PutPatient_EditPatientWithInvalidDateFormatDDMMYYY() throws IOException, InvalidFormatException
	  {	  
	  	return getTestData("TC192_Test11_PutPatient_EditPatientWithInvalidDateFormatDDMMYYY","patientservice");
	  }
	
	  
	  @Test(dataProvider="TC192_Test11_PutPatient_EditPatientWithInvalidDateFormatDDMMYYY",groups= {"patientservice"},enabled=true)
		public void tC192_Test11_PutPatient_EditPatientWithInvalidDateFormatDDMMYYY(JSONObject j) throws Exception
		{
		// for creating the patient
		  MDPPatientService mps=new MDPPatientService();
			Map<String,Object>m= new HashMap<String,Object>();
			Object obj = Class.forName("com.mdp.api.services.MDPPatientService").newInstance();
			if(j.get("jsonobject")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m.put((String)method.invoke(obj), e.getValue());
				}	
			}
			
			Response res1=mps.postCreatePatient(true,(String)j.get("accountId"),(String)j.get("conflict"),m );
			System.out.println("The responses are ");
			System.out.println(res1.getStatusCode());
			exeData.add("The status code is :"+res1.getStatusCode());
			test.get().log(Status.DEBUG, "The status code is :"+res1.getStatusCode());
		// for editing the patient info
			
			Map<String,Object>m1= new HashMap<String,Object>();
			if(j.get("jsonobject1")!=null)
			{
				for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobject1")).entrySet())
				{
					java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
					m1.put((String)method.invoke(obj), e.getValue());
				}	
			}
			m1.put(mps.getPATIENTID(), res1.jsonPath().get(mps.getPATIENTID()));
			Response res=mps.putEditPatientDetails((String)j.get("accountId"), res1.jsonPath().getString(mps.getENTITYID()), m1);
			Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
			System.out.println("The status code for the edit patient is :"+res.getStatusCode());
			
		}
	  
	  
	  
	  

}
