package com.mdp.api.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mdp.api.services.ApplicationUserService_AccountService;
import com.mdp.visu.web.pages.Web_MailVerificationPage;
import com.selenium.utils.MailBox;

import io.restassured.response.Response;

public class ApplicationUserService_AccountServiceTests extends TestBase{

	 @DataProvider(name="TC133_Accounts_Test01_PostAccountWithValidDataUsingSSCAdmin")
	 public  JSONObject[][] TC133_Accounts_Test01_PostAccountWithValidDataUsingSSCAdmin() throws IOException, InvalidFormatException
	 {	  
	  	return getTestData("TC133_Accounts_Test01_PostAccountWithValidDataUsingSSCAdmin","accountservice");
	 }
	@Test(dataProvider="TC133_Accounts_Test01_PostAccountWithValidDataUsingSSCAdmin",groups= {"accountservice"},enabled=true)
  public void tC133_Accounts_Test01_PostAccountWithValidDataUsingSSCAdmin(JSONObject j) throws Exception {
		MailBox.markAllMailsRead("zeiss0719@gmail.com","zeiss2017","MDP");;
		WebDriver dri=getDriver();
		String authUser=(String) j.get("authusername");
		String authPwd=(String) j.get("Test123!");
		Map<String,Object>m= (Map)j.get("jsonobjects");		
		String atn= getIdToken(dri, authUser ,authPwd,(String)j.get("sscusercleintid"));
		ApplicationUserService_AccountService appUser=new ApplicationUserService_AccountService();
		Response res=appUser.post_CreateAccount(true, true, atn, m);
		Assert.assertEquals(res.getStatusCode(), Integer.parseInt((String)j.get("expCode")));
		String resAcId=res.jsonPath().getString(appUser.getResAccId());
		String resName=res.jsonPath().getString(appUser.getACCOUNTNAME());
		String resEmail=res.jsonPath().getString(appUser.getEMAIL());
		List<String> l=Arrays.asList(resAcId,resName,resEmail);
		dynamicCredentials.put("tC133_Accounts_Test01_PostAccountWithValidDataUsingSSCAdmin", l);
		
	}
	
	
}
