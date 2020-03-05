package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;
import com.selenium.utils.TestVars;




public class Web_AcUploaderHomePage  extends SeleniumUtils{
	protected WebDriver wDriver=null;
	
	public Web_AcUploaderHomePage(WebDriver dri)
	{
		PageFactory.initElements(dri, this);
		this.wDriver=dri;
		
	}
	
	protected String link_Logout="Logout";
	protected String card_CreateCase="//span[text()='Create New Case']";
	protected String card_ViewEditCase="//span[text()='View or Edit Case Library']";
	protected String caseCnt="span#spncount";
	
	
	public Web_ACUserViewEditCasePage clickViewCard(TestVars gt) throws Exception
	{
		//gt.setCnt1(getElement(wDriver, "css", caseCnt, 60).getText());
		clickBy(wDriver, "xpath", card_ViewEditCase, 5);
		
		return new Web_ACUserViewEditCasePage(wDriver);
	}

	
	public Web_ACCreateCasePage clickCreateCase() throws Exception
	{
		clickBy(wDriver, "xpath", card_CreateCase, 5);
		return new Web_ACCreateCasePage(wDriver);	
	}
	

	public Web_LoginPage logout() throws Exception {
		return new Web_Navbar(wDriver).logout();
		
	}
	
	

}
