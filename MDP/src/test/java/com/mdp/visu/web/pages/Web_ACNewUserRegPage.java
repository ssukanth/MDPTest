package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selenium.utils.SeleniumUtils;



public class Web_ACNewUserRegPage extends SeleniumUtils{
	protected WebDriver wDriver=null;
	public Web_ACNewUserRegPage(WebDriver dri)
	{
		PageFactory.initElements(dri, this);
		this.wDriver=dri;
		System.out.println("Initialized the NewUserReg Page");
	}
	
	protected String btn_InviteUser="input#saveUser";
	protected String select_Site="select#ddlsiteid";
	protected String edit_fName="input#FirstName";
	protected String edit_lName="input#LastName";
	protected String edit_Email="input#Email";
	protected String edit_Username="input#UserName";
	protected String edit_Phone="input#PhoneNumber";
	protected String select_Role="select#RoleType";
	
	
	
	public void selectSite(String siteName) throws Exception
	{
		Select site= new Select(getElement(wDriver, "css", select_Site, 30));
		site.selectByVisibleText(siteName);
	}
	
	public void selectRole(String role ) throws Exception
	{
		Select site= new Select(getElement(wDriver, "css", select_Role, 30));
		switch(role.toLowerCase())
		{
			case "uploader" :System.out.println("Selecting The Uploader");
				site.selectByValue("2");break;
			case "acadmin" :System.out.println("Selecting The ACAdmin");
				site.selectByValue("7");break;
			case "frontdesk" :System.out.println("Selecting The Frontdesk");
				site.selectByValue("8");break;
		}
	}
	
	public String addUser(String siteName,String role,String userName,String mail,String pwd ) throws Exception
	{
		String effectiveUserName="";
		effectiveUserName=mail+getDateString().substring(5)+"@gmail.com";
		System.out.println("The effective user mail is :"+effectiveUserName);
		WebElement saveBtn=getElement(wDriver, "css", btn_InviteUser, 60);
		selectSite(siteName);
		sendKeys(wDriver, "css", edit_fName, 5, userName);
		sendKeys(wDriver, "css", edit_lName, 5, "LastName");
		sendKeys(wDriver, "css", edit_Email, 5,effectiveUserName);
		sendKeys(wDriver, "css", edit_Username, 5, userName+getDateString().substring(5));
		sendKeys(wDriver, "css", edit_Phone, 5, "9999999999");
		selectRole(role);
		clickBy(wDriver, "css", btn_InviteUser, 5);
		new Web_AdminHomepage(wDriver);
		return effectiveUserName;
	}
	

}
