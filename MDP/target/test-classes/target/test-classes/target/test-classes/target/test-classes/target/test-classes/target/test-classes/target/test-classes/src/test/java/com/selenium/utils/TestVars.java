package com.selenium.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestVars {
	private String strCaseid;
	private String cnt1;
	private String cnt2;
	private String cnt3;
	private String caseCreatingUser;
	private String caseCreatingUserString;
	private int siteId;
	private String authToken;
	private String baseUri;
	private String deleteUri;
	private Map<String,List<String>> runTimeTestData= new HashMap<String,List<String>>();
	private List<String> exeData;
	
	
	
	
	public List<String> getExeData() {
		return exeData;
	}

	public void setExeData(List<String> exeData) {
		this.exeData = exeData;
	}

	public Map<String, List<String>> getRunTimeTestData() {
		return runTimeTestData;
	}

	public void setRunTimeTestData(Map<String, List<String>> runTimeTestData) {
		this.runTimeTestData = runTimeTestData;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	public String getDeleteUri() {
		return deleteUri;
	}

	public void setDeleteUri(String deleteUri) {
		this.deleteUri = deleteUri;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getCaseCreatingUser() {
		return caseCreatingUser;
	}

	public void setCaseCreatingUser(String caseCreatingUser) {
		System.out.println("Setting th euser to :"+caseCreatingUser);
		this.caseCreatingUser = caseCreatingUser;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getCaseCreatingUserString() {
		return caseCreatingUserString;
	}

	public void setCaseCreatingUserString(String caseCreatingUserString) {
		System.out.println("Setting th euser to :"+caseCreatingUser);
		this.caseCreatingUserString = caseCreatingUserString;
	}

	public String getCnt1() {
		return cnt1;
	}

	public void setCnt1(String cnt1) {
		this.cnt1 = cnt1;
	}

	public String getCnt2() {
		return cnt2;
	}

	public void setCnt2(String cnt2) {
		this.cnt2 = cnt2;
	}

	public String getCnt3() {
		return cnt3;
	}

	public void setCnt3(String cnt3) {
		this.cnt3 = cnt3;
	}



	public String getStrCaseid() {
		return strCaseid;
	}

	public void setStrCaseid(String strCaseid) {
		this.strCaseid = strCaseid;
	}
	

}
