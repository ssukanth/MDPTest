package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;



public class Web_LoginPage  extends SeleniumUtils{
	protected WebDriver webDriver=null;
	
	public Web_LoginPage(WebDriver dri)
	{
		PageFactory.initElements(dri,this);
		this.webDriver=dri;
		
		
	}
	
	protected String btn_Login="ZeissIDlogin";
	protected String edit_EmailId="signInName";
	protected String edit_Pwd="password";
	protected String btn_Signin="next";
	
	public Object login(String pwd, String uName,String userType) throws Exception
	{
		Object homePage=null;
		clearCacheJs(webDriver);
		clickBy(webDriver, "id", btn_Login, 60);
		sendKeys(webDriver, "id", edit_EmailId, 60, uName);
		sendKeys(webDriver, "id", edit_Pwd, 5, pwd);
		clickBy(webDriver, "id", btn_Signin, 5);
		switch(userType.toLowerCase())
		{
		case "rcuser" :System.out.println("The User is RCUser");
			homePage=new Web_RCUserHomePage(webDriver);break;	
		case "admin" : System.out.println("The User Is Admin");
			homePage= new Web_AdminHomepage(webDriver);break;
		case "icdr" : System.out.println("The User Is Icdr");
			homePage= new Web_AcUploaderHomePage(webDriver);break;
		}
		return homePage;
	}
	// overloaded method for handling the pages without the btnLogin
	public void login(String pwd, String uName) throws Exception
	{
		clearCacheJs(webDriver);
		sendKeys(webDriver, "id", edit_EmailId, 30, uName);
		sendKeys(webDriver, "id", edit_Pwd, 5, pwd);
		clickBy(webDriver, "id", btn_Signin, 5);
		
	}

	
	

}
