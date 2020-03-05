package com.mdp.visu.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.selenium.utils.SeleniumUtils;


public class Web_ReviewPage  extends SeleniumUtils{
protected WebDriver wDriver=null;
	
	public Web_ReviewPage(WebDriver dri)
	{
		System.out.println("Initializing the RCUser Homepage");
		PageFactory.initElements(dri,this);
		this.wDriver=dri;	
	}
	protected String btn_Submit="button#btnSubmit";
	protected String btn_Refer="button#btnRefer";
	protected String btn_Reject="button#btnCancel";
	protected String btn_PopupRefer="button#btnPopupRefer";
	protected String txt_CaseId="span#CaseId";
	protected String img_Home="img[src*='Home']";
	protected String txt_ReferMsg="textarea#referMessage";
	protected String msg_CaseReferred=".//p[text()='Case Referred Successfully.']";
	protected String btn_PopupOk="//button[text()='Ok']";
	protected String msg_CaseRejected=".//p[text()='Case Rejected Successfully.']";
	protected String imgs_FundusThumbs="img[class*='img-responsive']";
	protected String btn_OD="button#btnOD";
	protected String btn_OS="button#btnOS";
	protected String rbtn_ODNoFindings="//div[@id='navODFindings']/.//input[contains(@id,'NoFindings')]/following-sibling::ins";
	protected String rbtn_OSNoFindings="//div[@id='navOSFindings']/.//input[contains(@id,'NoFindings')]/following-sibling::ins";
	protected String btn_UploadReport="input#btnUploadRepoort";
	protected String txtarea_Recommendations="textarea#txtReccomendation";
	protected String msg_CaseFinalizeSubmitConf="//h4[text()='This case will be submitted']";
	protected String btn_CaseFinalizeSubmitConf_Proceed="button#btnProceed";
	protected String sucmsg_CaseFinalizeSubmit="//h4[text()='This case has been submitted successfully.']";
	protected String btn_GraderMessage="button#btnCaseLog";
	protected String msg_GraderMessage="span[id^='actualmsg']";
	protected String txt_Grader2Update="textarea#txtMessage";
	protected String btn_Grader2AddMsg="input#btnAddMessage";
	protected String icon_GraderMessageClose="div[id='caselog'] i[class*='fa']";
	protected String msg_RejectComments=".//p[text()='Please provide your reject comments']";
	protected String textarea_RejectReason="textarea#rejectMessage";
	protected String btn_RejecPopupReject="button#btnReject";
	protected String sucmsg_CaseRejected=".//p[text()='Case Rejected Successfully.']";
	
	
	public boolean checkforExpectedCase(String caseId) throws Exception
	{
		String cId="";
		boolean caseFound=false;
		for(int i=0;i<10;i++)
		{
			cId=getText(wDriver, "css", txt_CaseId, 60).split(":")[1].trim();
			if(cId.equalsIgnoreCase(caseId))
			{
				System.out.println("Found the expected Case Reviewing");
				caseFound=true;
				break;
				
			}else
			{
				System.out.println("Unexpected Case allocated - Expected :"+caseId+" Actual Case:"+cId);
				jsMovetoEleBy(wDriver, "css", img_Home, 10, "click");
				sleepTimer(4);
				new Web_RCUserHomePage(wDriver).clickReview();
				System.out.println("Clicked Review for"+i+" th time");
			}
			
		}
		return caseFound;
		
	}
	
	public Web_RCUserHomePage referPatient(String msg,String caseId) throws Exception
	{
		Assert.assertEquals(checkforExpectedCase(caseId), true);
		clickBy(wDriver, "css", btn_Refer, 60);
		sendKeys(wDriver, "css", txt_ReferMsg, 60, msg);
		clickBy(wDriver, "css", btn_PopupRefer, 15);
		getElement(wDriver, "xpath", msg_CaseReferred, 60);
		clickBy(wDriver, "xpath", btn_PopupOk, 5);
		System.out.println("The case referred");
		return new Web_RCUserHomePage(wDriver);
	}
	
	
	
	public Web_RCUserHomePage reviewPatient(int noofImages,String caseId) throws Exception
	{
		Assert.assertEquals(checkforExpectedCase(caseId), true);
		List<WebElement> imgList=getElements(wDriver, "css", imgs_FundusThumbs, noofImages);
		jsMovetoEle(wDriver, imgList.get(0),"click");
		jsMovetoEleBy(wDriver, "css", btn_OD, 5, "click");
		jsMovetoEleBy(wDriver, "xpath", rbtn_ODNoFindings, 5, "click");
		System.out.println("The OD Nofindings clicked");
		if(imgList.size()>1)
		{
			jsMovetoEle(wDriver, imgList.get(1),"click");
			jsMovetoEleBy(wDriver, "css", btn_OS, 5, "click");
			jsMovetoEleBy(wDriver, "xpath", rbtn_OSNoFindings, 5, "click");
			System.out.println("The OS Nofindings clicked");	
		}
		jsMovetoEleBy(wDriver, "css", btn_Submit, 5, "click");
		String rec=getText(wDriver, "css", txtarea_Recommendations, 60);
		System.out.println("The recommendations are :"+rec);
		sleepTimer(1);
		jsMovetoEleBy(wDriver, "css", btn_UploadReport, 30, "click");
		getElement(wDriver, "xpath", msg_CaseFinalizeSubmitConf, 60);
		jsMovetoEleBy(wDriver, "css", btn_CaseFinalizeSubmitConf_Proceed, 10, "click");
		sleepTimer(1);
		getElement(wDriver, "xpath", sucmsg_CaseFinalizeSubmit, 60);
		clickBy(wDriver, "xpath", btn_PopupOk, 5);
		System.out.println("The case submitted successfully");
		return new Web_RCUserHomePage(wDriver);
	}

	public boolean verfiyGrader1Comments(String com,String caseId) throws Exception
	{
		Assert.assertEquals(checkforExpectedCase(caseId), true);
		boolean c=false;
		jsMovetoEleBy(wDriver, "css", btn_GraderMessage, 5, "click");
		System.out.println("The expected is :"+com+" and actual is :"+getText(wDriver, "css", msg_GraderMessage, 45));
		if(com.equalsIgnoreCase(getText(wDriver, "css", msg_GraderMessage, 45))){
			c=true;
		}
		
		return c;
	}
	
	public void closeGrader1Message() throws Exception
	{
		jsMovetoEleBy(wDriver, "css", icon_GraderMessageClose, 5, "click");
	}
	
	public Web_RCUserHomePage rejectCase(String caseId,String rejectComments) throws Exception
	{
		Assert.assertEquals(checkforExpectedCase(caseId), true);
		jsMovetoEleBy(wDriver, "css",btn_Reject , 60, "click");
		sendKeys(wDriver, "css", textarea_RejectReason, 60, rejectComments);
		jsMovetoEleBy(wDriver, "css", btn_RejecPopupReject, 10, "click");
		getElement(wDriver, "xpath", sucmsg_CaseRejected, 60);
		jsMovetoEleBy(wDriver, "xpath", btn_PopupOk, 10, "click");
		System.out.println("The case rejected successfully");
		return new Web_RCUserHomePage(wDriver);
		
	}
	
}
