package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;



public class Web_Navbar extends SeleniumUtils {
	
	protected WebDriver webDriver=null;
	protected String link_Logout="a[title='Logout']";
	protected String link_Home="span[class*='glyphicon-home']";
	public Web_Navbar(WebDriver dri) {
		PageFactory.initElements(dri, this);
		this.webDriver=dri;
	}
	
	public Web_LoginPage logout() throws Exception
	{
		clickBy(webDriver, "css", link_Logout, 30);
		return new Web_LoginPage(webDriver);
	}
	


}
