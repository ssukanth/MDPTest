package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;



public class Web_RCUserHomePage extends SeleniumUtils{
	
protected WebDriver wDriver=null;
	
	public Web_RCUserHomePage(WebDriver dri)
	{
		System.out.println("Initializing the RCUser Homepage");
		PageFactory.initElements(dri,this);
		this.wDriver=dri;	
	}
	protected String link_Logout="//*[text()='Logout']";
	protected String txt_PatientForReviewCount="availablePatientCountSpan";
	protected String btn_Review="a#reviewPatient";
	
	public int getReviewCount() throws Exception
	{
		return Integer.parseInt(getElement(wDriver, "id", txt_PatientForReviewCount, 60).getText());
	}
	public Web_ReviewPage clickReview() throws Exception
	{
		clickBy(wDriver, "css", btn_Review, 30);
		return new Web_ReviewPage(wDriver);
	}

	
	public Web_LoginPage logout() throws Exception
	{
		return new Web_Navbar(wDriver).logout();
	}
	

}
