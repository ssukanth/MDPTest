package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selenium.utils.SeleniumUtils;


public class Web_AdminHomepage extends SeleniumUtils{
	
	protected WebDriver wDriver=null;
	public Web_AdminHomepage(WebDriver dri)
	{
		PageFactory.initElements(dri, this);
		this.wDriver=dri;
	}
	String link_Logout="logoff";
	String select_AdminMenu="ddlMainMenu";
	String link_ManageUsers="Manage Users";
	String link_AddUser="a[class*='add-user']";
	String select_AccountType="select#ACtype";
	
	public void selectAdminMenuItem(String selChoice) throws Exception
	{
		Select menu= new Select(getElement(wDriver, "id", select_AdminMenu, 30));
		switch(selChoice.toLowerCase())
		{
		case "monitor" :System.out.println("Selecting The Monitor");
						menu.selectByValue("0");break;
		case "manage" :System.out.println("Selecting The Manage");
						menu.selectByValue("1");break;
		case "report" :System.out.println("Selecting The Report");
						menu.selectByValue("2");break;
		}
	}
	
	public void selectAccountType(String acType) throws Exception
	{
		
		Select aType= new Select(getElement(wDriver, "css", select_AccountType, 30));
		switch(acType.toLowerCase())
		{
		case "rc" :System.out.println("Selecting The ACSite");
					aType.selectByValue("RC");break;
		case "ac" :System.out.println("Selecting The RCSite");					System.out.println("The default option was :"+aType.getFirstSelectedOption());

				aType.selectByValue("AC");break;
		case "association" :System.out.println("Selecting The Association");
				aType.selectByValue("ASC");break;
		case "dcp" :System.out.println("Selecting The DCP");
				aType.selectByValue("DCP");break;
		}
		
	}
	
	
	
	
	public Web_ACNewUserRegPage clickAcAdduser() throws Exception
	{
		clickBy(wDriver, "css",select_AccountType , 15);
		selectAccountType("ac");
		clickBy(wDriver, "linktext", link_ManageUsers, 30);
		clickBy(wDriver, "css", link_AddUser, 30);
		return new Web_ACNewUserRegPage(wDriver);
	}
	
	

}
