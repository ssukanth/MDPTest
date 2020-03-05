package com.mdp.visu.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;

public class Web_MailVerificationPage extends SeleniumUtils {
	
	protected WebDriver webDriver=null;
	private String text_Pwd="newPassword";
	private String text_RePwd="reenterPassword";
	private String rbtn_Accept="tcaccepted_True";
	private String btn_Create="continue";
	private String btn_RegComplete="subscribeButton";
	private String str_Thankyou=".//*[text()='Thank you']";
	
	public Web_MailVerificationPage(WebDriver dri) {
		PageFactory.initElements(dri, this);
		this.webDriver=dri;
	}
	
	public void verifyMail(String url,String userName,String password) throws Exception
	{
		if(webDriver==null) {
			webDriver=getChromeBrowser(false);
		}
		webDriver.get(url);
		sendKeys(webDriver, "id", text_Pwd, 90, password);
		sendKeys(webDriver, "id", text_RePwd, 90, password);
		jsMovetoEleBy(webDriver, "id", rbtn_Accept, 15, "click");
		jsMovetoEleBy(webDriver, "id", btn_Create, 15, "click");
		
//		Web_LoginPage lp=new Web_LoginPage(webDriver);
//		try {
//			
//			lp.login(password, userName);
//			System.out.println("The login screen popped up while verifying");
//			
//		}catch(Exception e)
//		{
//			System.out.println("The Zeissid is working fine");
//		}
		
		jsMovetoEleBy(webDriver, "id", btn_RegComplete, 90, "click");
		System.out.println("Text After Reg"+getAttr(webDriver, "xpath", str_Thankyou, 90, "text"));	
		webDriver.quit();
	}
	

}
