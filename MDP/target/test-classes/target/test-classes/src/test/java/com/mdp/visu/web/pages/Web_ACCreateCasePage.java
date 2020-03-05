package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;


public class Web_ACCreateCasePage extends SeleniumUtils {

	protected WebDriver webDriver=null;
	protected String edit_ParentId="txtpatientId";
	protected String link_Home="span[class*='glyphicon-home']";
	public Web_ACCreateCasePage(WebDriver dri) {
		PageFactory.initElements(dri, this);
		this.webDriver=dri;
	}
	
	public String getPatientId() throws Exception
	{
		return getAttr(webDriver, "id", edit_ParentId, 30,"value");
	}
	
	public Web_AcUploaderHomePage gotoHome() throws Exception
	{
		clickBy(webDriver, "css", link_Home, 15);
		return new Web_AcUploaderHomePage(webDriver);
	}

}
