package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;




public class Web_NewUploaderConfPage extends SeleniumUtils{
	protected WebDriver wDriver=null;
	public Web_NewUploaderConfPage(WebDriver dri)
	{
		PageFactory.initElements(dri, this);
		this.wDriver=dri;
	}
	protected String btn_CreateAc="button#continue";
	protected String edit_Pwd1="input#newPassword";
	protected String edit_Pwd2="input#reenterPassword";
	protected String rbtn_Terms="input#tcaccepted_True";
	protected String btn_Complete="button#subscribeButton";
	
	public void acceptTerms(String pwd) throws Exception
	{
		sendKeys(wDriver, "css", edit_Pwd1, 60, pwd);
		sendKeys(wDriver, "css", edit_Pwd2, 60, pwd);
		clickBy(wDriver, "css", rbtn_Terms, 5);
		clickBy(wDriver, "css", btn_CreateAc, 5);
		clickBy(wDriver, "css", btn_Complete, 5);
		
	}


}
