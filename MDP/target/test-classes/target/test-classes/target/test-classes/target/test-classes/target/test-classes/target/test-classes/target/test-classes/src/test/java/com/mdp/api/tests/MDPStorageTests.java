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
import com.mdp.api.services.MDPStorageService;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MDPStorageTests extends TestBase {
	
	//POST Request - Create Storage Test cases
	
	@DataProvider(name="TC188_TC01_CreateStorage")
	public  JSONObject[][] data188_TC01_CreateStorage() throws IOException, InvalidFormatException
	{
		return getTestData("TC188_TC01_CreateStorage", "storageservice");
	}
	
	@Test(dataProvider="TC188_TC01_CreateStorage", groups= {"storageservice"}, enabled=true)
	public void TC188_TC01_CreateStorage(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStorageService mps=new MDPStorageService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStorageService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.createStorageForAccount((String)j.get("accountId"));
		System.out.println("The POST response code ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Create Storage Response body: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	//GET Request - GET Storage Test cases
	
	@DataProvider(name="TC188_TC02_GetStorage")
	public  JSONObject[][] data188_TC02_GetStorage() throws IOException, InvalidFormatException
	{
		return getTestData("TC188_TC02_GetStorage", "storageservice");
	}
	
	@Test(dataProvider="TC188_TC02_GetStorage", groups= {"storageservice"}, enabled=true)
	public void TC188_TC02_GetStorage(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStorageService mps=new MDPStorageService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStorageService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.getStorageForAccount((String)j.get("accountId"));
		System.out.println("The GET response code ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Create Storage Response body: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	//PUT Request - Edit Storage Test cases
	
	@DataProvider(name="TC188_TC03_EditStorage")
	public  JSONObject[][] data188_TC03_EditStorage() throws IOException, InvalidFormatException
	{
		return getTestData("TC188_TC03_EditStorage", "storageservice");
	}
	
	@Test(dataProvider="TC188_TC03_EditStorage", groups= {"storageservice"}, enabled=true)
	public void TC188_TC03_EditStorage(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStorageService mps=new MDPStorageService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStorageService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.editStorageForAccount((String)j.get("accountId"));
		System.out.println("The PUT response code ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Edit Storage Response body: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
	//DELETE Request - Delete Storage Test cases
	
	@DataProvider(name="TC188_TC04_DeleteStorage")
	public  JSONObject[][] data188_TC04_DeleteStorage() throws IOException, InvalidFormatException
	{
		return getTestData("TC188_TC04_DeleteStorage", "storageservice");
	}
	
	@Test(dataProvider="TC188_TC04_DeleteStorage", groups= {"storageservice"}, enabled=true)
	public void TC188_TC04_DeleteStorage(JSONObject j) throws Exception
	{
		test.get().log(Status.DEBUG, "The Test name is :"+j.get("testname"));
		MDPStorageService mps=new MDPStorageService();
		Map<String,Object>m= new HashMap<String,Object>();		
		Object obj = Class.forName("com.mdp.api.services.MDPStorageService").newInstance();
		if(j.get("jsonobjects")!=null)
		{
			for(Map.Entry<String, Object>e:((Map<String,Object>)j.get("jsonobjects")).entrySet())
			{
				java.lang.reflect.Method method = obj.getClass().getMethod("get"+e.getKey());
				m.put((String)method.invoke(obj), e.getValue());
			}	
		}
		
		Response res=mps.deleteStorageForAccount((String)j.get("accountId"));
		System.out.println("The DELETE response code ");
		System.out.println(res.getStatusCode());
		test.get().log(Status.DEBUG, "The status code is: "+res.getStatusCode());
		test.get().log(Status.DEBUG, "Delete Storage Response body: "+res.body().asString());

		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String) j.get("expCode")));
	}
	
}
