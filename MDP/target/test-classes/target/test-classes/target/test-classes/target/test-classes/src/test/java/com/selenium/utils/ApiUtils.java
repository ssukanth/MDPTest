package com.selenium.utils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Store;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.Status;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import groovy.util.Eval;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils extends SeleniumUtils {
	public static Map<String, List<String>> dynamicCredentials = new HashMap<String,List<String>>();
	public static Store store=null;
	static Store store2=null;
    public static Map<String,JSONObject>testdataMap=new HashMap<String,JSONObject>();
	/* For getting the data from the json file */

	public String generateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

	public void validateSchema(Response res, String schemaFileLoc)

	{

		// res.then().assertThat().body(matchesJsonSchemaInClasspath("MDPCreateUserResponseSchema.JSON"));
		res.then().assertThat().body(matchesJsonSchema(new File(schemaFileLoc)));

	}

	public String getIdToken_old(WebDriver dri2, String uName, String pwd, String aId) throws Exception {
		exeData.add(uName);
		exeData.add(pwd);
		String token = "";
		String authToken = "";
		if (tokenMaps.containsKey(uName) && dateDiff(25, tokenMaps.get(uName).get(2))) {
			authToken = tokenMaps.get(uName).get(0);
			System.out.println("The token already generated for the user");

		} else {
			System.out.println("Genrating the token for the user:" + uName);

			System.setProperty("webdriver.chrome.driver",
			new File(".").getCanonicalPath() + "/src/test/resources/Drivers/Macos/chromedriver80");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			WebDriver dri = new ChromeDriver(chromeOptions);
			dri.get("https://zeissidb2cstage.b2clogin.com/accounts-stage.zeiss.com/oauth2/v2.0/authorize?ui_locales=en&p=B2C_1A_ZeissIdNormalSignIn&response_type=token&state=CfDJ8CU4DhpuSsVArPcSFOuDcVL73cJH9yXGM9rFMnRf70DwmgE_yfXf0NACpq7pCyQ74rPYhfcCdF5ZUQTXTd1fM79D5QX8Bus4NwIBnzH7wcIC10DmZIyhrWEeTf1tlHW5O3SpvMXBgylF612_GG5rKCFmK1Fp2Abbex13iuMSmxx882W3LxCnmuymFepxUbnqHHZuGpxLfCwVB9OL5rsoWj19dFCvGcYfcfe5U9aLkj9_&client_id=6caa0532-8c7e-4772-9bb9-b1a5c3e909c1&scope=6caa0532-8c7e-4772-9bb9-b1a5c3e909c1+openid&redirect_uri=https%3A%2F%2Fid-ip-stage.zeiss.com%2FOAuth%2FAuthorizeCallBack");
			dri.get("https://id-ip-test.zeiss.com/OAuth/Authorize?p=B2C_1A_ZeissIdNormalSignIn&response_type=token&state=&client_id=9ec53cca-baad-4126-b43c-6ff3c61b1107&scope=9ec53cca-baad-4126-b43c-6ff3c61b1107%20openId&redirect_uri=https%3A%2F%2Fvisuhealthdemo.zeiss.com%2F");
			sendKeys(dri, "id", "signInName", 90, uName);
			sendKeys(dri, "id", "password", 15, pwd);
			clickBy(dri, "id", "next", 15);
			getElement(dri, "id", "ZeissIDlogin", 90);
			sleepTimer(3);
			String x = dri.getCurrentUrl();
			System.out.println("Generated : " + x);
			token = x.substring(x.indexOf("=") + 1, x.lastIndexOf("token") - 1);
			test.get().log(Status.DEBUG, "Generated the ID Token for the User :" + uName);
			System.out.println(token);
			System.out.println("Generated the token id");
			// dri.quit();

			RestAssured.useRelaxedHTTPSValidation();
			RestAssured.baseURI = (String) credentialJson.get("baseUri");
			RequestSpecification httpReq = RestAssured.given().when().log().all();

			httpReq.header("Authorization", "bearer " + token);
			httpReq.contentType("application/json");
			JSONObject appId = new JSONObject();
			// appId.put("mdpAppId", "f19bb71e-350a-4b8e-d44f-08d753040250");
			appId.put("mdpAppId", aId);
			httpReq.body(appId);

			System.out.println("The formed url is:" + (String) credentialJson.get("baseUri")
					+ (String) credentialJson.get("authorizeUrl"));
			Response res = httpReq.request(Method.POST, (String) credentialJson.get("authorizeUrl"));
			System.out.println("PRINTING THE REQUREST FOR OGGIN PURPOSE");

			System.out.println("The response code for the auth token :" + res.getStatusCode());
			System.out.println("The response for the auth token is :" + res.body().asString());
			HashMap tok = res.jsonPath().getJsonObject("token");
			String rTok = res.jsonPath().getJsonObject("refreshToken");
			System.out.println("The content of the hash nap is :" + tok);
			List<String> l = new ArrayList<String>();
			l.add(tok.get("accessToken").toString());
			l.add(rTok);
			l.add(new SimpleDateFormat("YYYY-MM-dd HH-mm-ss").format(new Date()).toString());
			tokenMaps.put(uName, l);
			test.get().log(Status.DEBUG, "Generated the AccessToken for the User :" + l);
			authToken = tokenMaps.get(uName).get(0);
			exeData.add(tok.get("accessToken").toString());
			writeToTxt(new File(".").getCanonicalPath() + "/TestData/authTxt.txt", authToken);
			System.out.println(authToken);
			dri.quit();
		}
		return authToken;
	}
	
	public String getIdToken(WebDriver dri, String uName, String pwd, String clientId) throws Exception {
        exeData.add("\nUserName:"+uName);
        exeData.add("\nPassword"+pwd);
        test.get().log(Status.DEBUG, "UserName Used for Genrating the Access token:"+uName);
        String token = "";
        if (tokenMaps.containsKey(uName) && dateDiff(50, tokenMaps.get(uName).get(1))) {
        		token = tokenMaps.get(uName).get(0);
               System.out.println("The token already generated for the user");

        } else {
               System.out.println("Genrating the token for the user:" + uName);
               //dri.get("https://zeissidb2ctest.b2clogin.com/accounts-test.zeiss.com/oauth2/v2.0/authorize?ui_locales=en&p=B2C_1A_ZeissIdNormalSignIn&response_type=token&state=CfDJ8HbUd0rYUXFKuExWEjHVKsTN3GdC5DYdHovh-eoPVc9oUekpcA-RAyR2i22Y2Z8gh5U948EQzvlNFmMjPDoT35QCMJm9DVq17zCAeDl35HO4--g5l63YjjOKj7C4KVHVQZITq7NdSybN2eXM7btXGsqQJk4X7HMHB_sfU95h7VSf-1OY6Iw4-l8ETxjynS12mvvTsSijbMlGPPmoLyHO8-rS_Wwhllk3c6ZQqyxcVst1tqav9LuGZHP4SqIdZjoCokSIp3LPclE7T7bEN2x4tUE&client_id=3D30CCC9-7964-4323-90BB-6D72AA8DC9C6&scope=3D30CCC9-7964-4323-90BB-6D72AA8DC9C6+openId&redirect_uri=https%3A%2F%2Fid-ip-test.zeiss.com%2FOAuth%2FAuthorizeCallBack");
               String effAuthCodeGen="https://zeissidb2ctest.b2clogin.com/accounts-test.zeiss.com/oauth2/v2.0/authorize?ui_locales=en&p=B2C_1A_ZeissIdNormalSignIn&response_type=token&state=CfDJ8HbUd0rYUXFKuExWEjHVKsTN3GdC5DYdHovh-eoPVc9oUekpcA-RAyR2i22Y2Z8gh5U948EQzvlNFmMjPDoT35QCMJm9DVq17zCAeDl35HO4--g5l63YjjOKj7C4KVHVQZITq7NdSybN2eXM7btXGsqQJk4X7HMHB_sfU95h7VSf-1OY6Iw4-l8ETxjynS12mvvTsSijbMlGPPmoLyHO8-rS_Wwhllk3c6ZQqyxcVst1tqav9LuGZHP4SqIdZjoCokSIp3LPclE7T7bEN2x4tUE&client_id="+clientId+"&scope="+clientId+"+openId&redirect_uri=https%3A%2F%2Fid-ip-test.zeiss.com%2FOAuth%2FAuthorizeCallBack";
               test.get().log(Status.DEBUG, "The Auth code Generated With the URL:\n"+effAuthCodeGen);
               dri.get(effAuthCodeGen);
               sendKeys(dri, "id", "signInName", 90, uName);
               sendKeys(dri, "id", "password", 15, pwd);
               clickBy(dri, "id", "next", 15);
               //getElement(dri, "id", "ZeissIDlogin", 90);
               getElement(dri, "xpath", ".//h1[text()='Error']", 45);
               sleepTimer(1);
               String pageText=dri.getPageSource();
               System.out.println("The Generated Page source is :"+pageText);
               token = pageText.substring(pageText.indexOf("token=")+6,pageText.indexOf("=Bearer") - 16);
               System.out.println("The Genrated Token is :"+token);
               exeData.add("The Auth token Used :"+token);
               test.get().log(Status.DEBUG, "The Auth token Used :\n"+token);
               List<String> l = new ArrayList<String>();
               l.add(token);
               l.add(new SimpleDateFormat("YYYY-MM-dd HH-mm-ss").format(new Date()).toString());
               tokenMaps.put(uName, l);
               writeToTxt(new File(".").getCanonicalPath() + "/TestData/authTxt.txt",token);

        }
        return token;
  }

	/*
	 * public JSONObject changePayloadAttrVal(JSONObject
	 * jObj,Map<String,Object>attrVals) {
	 * System.out.println("The values to be changed are :"+attrVals);
	 * test.get().log(Status.DEBUG, "The values to be changed are :"+attrVals);
	 * 
	 * for(Map.Entry<String, Object>e:attrVals.entrySet()) {
	 * System.out.println(e.getValue()); if(e.getValue() instanceof String) {
	 * test.get().log(Status.DEBUG,
	 * "The changing attributes are not under another parent");
	 * jObj.replace(e.getKey(), e.getValue());
	 * test.get().log(Status.DEBUG,"The latest value of the changed attr:"+e.getKey(
	 * )+"="+jObj.get(e.getKey()));
	 * 
	 * }else if(e.getValue() instanceof Map) {
	 * System.out.println("The changing attributes are under another parent");
	 * test.get().log(Status.DEBUG,
	 * "The changing attributes are under another parent"); // the code commented
	 * for testing a better solution JSONObject
	 * jobj2=(JSONObject)jObj.get(e.getKey());
	 * Map<String,String>m2=(Map)e.getValue(); for(Map.Entry<String,
	 * String>e2:m2.entrySet()) { jobj2.replace(e2.getKey(), e2.getValue()); }
	 * 
	 * String k=e.getKey(); Map val=(Map)e.getValue(); Map<String,Object> m2=val;
	 * boolean replaceDone=false; while(!replaceDone) { JSONObject
	 * tempPar=(JSONObject)jObj.get(k); List l2=new ArrayList(m2.values());
	 * if(l2.get(0) instanceof String) { for(Map.Entry<String,
	 * Object>e3:m2.entrySet()) { tempPar.replace(e3.getKey(), e3.getValue());
	 * 
	 * } replaceDone=true;
	 * 
	 * }else if(l2.get(0) instanceof List) {
	 * 
	 * }else if(l2.get(0) instanceof Map) { List<Map.Entry<String, Object>>l3=new
	 * ArrayList(m2.entrySet()); k=l3.get(0).getKey(); m2=(Map)m2.get(k);
	 * 
	 * }
	 * 
	 * } System.out.println("The latest value of the changed attr:"+e.getKey()+"="+
	 * jObj.get(e.getKey()));
	 * test.get().log(Status.DEBUG,"The latest value of the changed attr:"+e.getKey(
	 * )+"="+jObj.get(e.getKey())); }else if(e.getValue() instanceof List) {
	 * test.get().log(Status.DEBUG,
	 * "The changing attributes are under another array object"); JSONArray
	 * ja=(JSONArray)jObj.get(e.getKey()); List<String>li=(List)e.getValue();
	 * JSONObject jobj2=(JSONObject)ja.get(Integer.parseInt(li.get(0)));
	 * jobj2.replace(li.get(1),li.get(2));
	 * test.get().log(Status.DEBUG,"The latest value of the changed attr:"+e.getKey(
	 * )+"="+jObj.get(e.getKey()));
	 * 
	 * } } return jObj;
	 * 
	 * }
	 * 
	 * 
	 * Objective : To chagne the attributes of jsonobject inside json array.
	 * parameters : reqIndex :The index of the object whose attributes\childs have
	 * to be changed. jObj : The complete Json payload read and converted to Json
	 * object arrayName: The name of the JSOn array whose child Json objcts need to
	 * be changed. attrVals :The key value pairs which are json object and value
	 * respectively to be changed.
	 * 
	 * 
	 * 
	 * public JSONObject changePayloadAttrVal(int reqIndex,JSONObject jObj,String
	 * arrayName,Map<String,String>attrVals) {
	 * 
	 * 
	 * test.get().log(Status.DEBUG,
	 * "The changing attributes are a part of a Json array with a parent");
	 * JSONArray jAr=(JSONArray)jObj.get(arrayName); JSONObject
	 * jObj2=(JSONObject)jAr.get(reqIndex); for(Map.Entry<String,
	 * String>e:attrVals.entrySet()) { jObj2.replace(e.getKey(), e.getValue()); }
	 * 
	 * 
	 * return jObj;
	 * 
	 * }
	 */
	public String changePayloadAttrVal(JSONObject jObj, Map<String, Object> attrVals) throws IOException {

		System.out.println("The passed payload map is :"+attrVals);
		System.out.println("The actual json value:" + jObj.toString());
		DocumentContext jso = JsonPath.parse(jObj);
		for (Map.Entry<String, Object> e : attrVals.entrySet())
		{
			String path="$."+e.getKey();
			jso.set(path, e.getValue());
		}
		System.out.println("The actual payload will be ");
		System.out.println(jso.jsonString());
		return jso.jsonString();
	}

	// For Adding the test exe data for further usage across test cases
	public Map<String, List<String>> addTextExeData(String testCaseName, String... listItems) {
		if (dynamicCredentials.get(testCaseName) == null) {
			List<String> l = new ArrayList<String>(Arrays.asList(listItems));
			dynamicCredentials.put(testCaseName, l);

		} else {
			List<String> l2 = dynamicCredentials.get(testCaseName);
			for (String it : listItems) {
				test.get().log(Status.DEBUG, "The list of Exe data already exists");
				test.get().log(Status.DEBUG, "Adding the item" + it);
				l2.add(it);
				System.out.println("Added to the test case data");
			}

		}
		return dynamicCredentials;
	}
	
	
	public RequestSpecification createReq(String baseUri)
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI =baseUri; //;
		System.out.println("The Base uri is :"+baseUri);
		test.get().log(Status.DEBUG, "The BaseUri is :"+baseUri);
		exeData.add("The Base Uri: "+baseUri);
		RequestSpecification httpReq = RestAssured.given().when().log().all();
		httpReq.contentType("application/json");
		return httpReq;
		
	}
	
	public String getBuildNumber(String jKey)
	{
		String buildNum=null;
		Object o=((Map)credentialJson.get(jKey.toLowerCase())).get("build");
		if(o==null)
			{
			buildNum="";
			}else
			{
				buildNum=(String)o;
			}
		return buildNum;
		
	}
	
	 public JSONObject configureTestData(String tDatFileName)
	    {
		 JSONObject tData=null;
		 	if(testdataMap.containsKey(tDatFileName))
		 	{
		 		System.out.println("The Test Data is already configured for the groupname");
		 		tData=testdataMap.get(tDatFileName);
		 		
		 	}else
		 	{
		 		System.out.println("The Test Data is not configured for the groupname");
		 		ApiUtils apiUtils=new ApiUtils();
				JSONParser jp = new JSONParser();
				//String tDatFileName= con.getCurrentXmlTest().getName();
				String jdat="";
				String effFilePath="";
				try {
					effFilePath = new File(".").getCanonicalPath()+"/TestData/"+tDatFileName+".Json";
					jdat = apiUtils.generateStringFromResource(effFilePath);
				} catch (IOException e) {
					System.out.println("Unable to load the file at the location :"+effFilePath);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tData=(JSONObject)jp.parse(jdat);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Unable to load the parse file at the location :"+effFilePath);
					e.printStackTrace();
				}
				testdataMap.put(tDatFileName, tData);
				
		 	}
		 	return tData;
	    	
	    }
	 
	 
	 public JSONObject[][]getTestData(String testCaseId,String groupName)
	    {
		 	testData=configureTestData(groupName);
	    	JSONArray jTestdata=(JSONArray) testData.get(testCaseId);
	    	int colSize=((JSONObject)jTestdata.get(0)).size();
	    	System.out.println("The col size is:"+colSize);
	    	JSONObject[][] testD=new JSONObject[jTestdata.size()][1];
	    	for(int i=0;i<jTestdata.size();i++)
	    	{
	    		testD[i][0]=(JSONObject)jTestdata.get(i);
	    	}
	    	System.out.println(testD.length);
	    	System.out.println(testD[0].length);
	    	return testD;
	    	
	    }
	
	

}
