package com.mdp.visu.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.SeleniumUtils;
import com.selenium.utils.TestVars;



public class Web_ACUserViewEditCasePage extends SeleniumUtils {
	protected WebDriver wDriver=null;
	public Web_ACUserViewEditCasePage(WebDriver dri)
	{
		PageFactory.initElements(dri, this);
		this.wDriver=dri;
		
	}
	
	protected String btn_CreateNewCase="button#btnCreateNewCase";
	protected String table_Casedata="div#table_content_rec";
	protected String div_EndRecords="td[class$='end-records']";
	protected String msg_Popup_Gradercomment="#modelPopup > div > div > div.modal-body.text-center > div > p.white-font > span.pull-left";
	protected String msg_Popup_GraderCommentClose=".//div[contains(@class,'height-auto')]/div[@class='modal-header']/.//h4//preceding-sibling::button";
	
	
	
	public String getScreenStatus(TestVars gt) throws Exception
	{
		boolean caseReported=false;
		String st="";

		//boolean caseReported=false;
	major:for(int k=0;k<10;k++)
		{
			getElement(wDriver, "css", div_EndRecords, 45);
			List<WebElement> datarows=null;
			for(int i=0;i<5;i++)
			{
				datarows=getElement(wDriver, "css", table_Casedata, 45).findElements(By.tagName("tr"));
				System.out.println("The number of rows is :"+datarows.size());
				//System.out.println("The count in the application is :"+gt.getCnt1());
//				if(datarows.size()-2==Integer.parseInt(gt.getCnt1()))
//				{
//					System.out.println("the cases got loaded");
//					break;
//				}else
//				{
//					System.out.println("The case are yet to load ");
//					sleepTimer(5);
//				}
			}
			
		

		minor:	for(int j=1;j<datarows.size()-1;j++)
			{
				jsMovetoEle(wDriver, datarows.get(j),"move");
				List<WebElement>cols=datarows.get(j).findElements(By.tagName("td"));
				System.out.println("The case id:"+cols.get(0).getText());
				if(cols.get(0).getText().trim().equalsIgnoreCase(gt.getStrCaseid()))
				{
					System.out.println("The case row is found for:"+gt.getStrCaseid());
	
						jsMovetoEleBy(wDriver, "xpath", "//p[text()='"+gt.getStrCaseid()+"']", 45, "move");
						sleepTimer(3);
						String actStr=cols.get(5).getText().trim();

							if(actStr.equalsIgnoreCase("Reported"))
							{
								st=cols.get(6).findElement(By.tagName("span")).getCssValue("color");
								caseReported=true;
								sleepTimer(3);
								break major;
								
							}else
							{
								System.out.println("The case is not yet Detail Review Pending so waiting for: "+k+" th time");
								jsMovetoEle(wDriver, null, "refresh");
								getElement(wDriver, "css", btn_CreateNewCase, 60);
								sleepTimer(5);
								break minor;
								
							}
							
				}
			}//minor
	}//major for
		
	if(!caseReported)
	{
		System.out.println("The Case has not moved to Detail Review ");
		throw new Exception("Case Not Moved To Detail Review");
	}	
	return st;
	}

	public void clickDownReport(TestVars gt,String expStatus) throws Exception
	{
		boolean caseReported=false;
	major:for(int k=0;k<10;k++)
		{
			getElement(wDriver, "css", div_EndRecords, 45);
			List<WebElement> datarows=null;
			for(int i=0;i<5;i++)
			{
				datarows=getElement(wDriver, "css", table_Casedata, 45).findElements(By.tagName("tr"));
				System.out.println("The number of rows is :"+datarows.size());
				System.out.println("The count in the application is :"+gt.getCnt1());
				if(datarows.size()-2==Integer.parseInt(gt.getCnt1()))
				{
					System.out.println("the cases got loaded");
					break;
				}else
				{
					System.out.println("The case are yet to load ");
					sleepTimer(5);
				}
			}
			
		

		minor:	for(int j=1;j<datarows.size()-1;j++)
			{
				jsMovetoEle(wDriver, datarows.get(j),"move");
				List<WebElement>cols=datarows.get(j).findElements(By.tagName("td"));
				System.out.println("The case id:"+cols.get(0).getText());
				if(cols.get(0).getText().trim().equalsIgnoreCase(gt.getStrCaseid()))
				{
					System.out.println("The case row is found for:"+gt.getStrCaseid());
	
						jsMovetoEleBy(wDriver, "xpath", "//p[text()='"+gt.getStrCaseid()+"']", 45, "move");
						sleepTimer(3);
						if(expStatus.equalsIgnoreCase("download"))
						{
							if(cols.get(5).getText().trim().equalsIgnoreCase("Reported"))
							{
								jsMovetoEle(wDriver, cols.get(8).findElement(By.tagName("img")), "click");
								System.out.println("The status of the case is Reported and clicked on the Download");
								sleepTimer(10);
								caseReported=true;
								break major;
								
							}else
							{
								System.out.println("The case is not yet reported so waiting for: "+k+" th time");
								jsMovetoEle(wDriver, null, "refresh");
								getElement(wDriver, "css", btn_CreateNewCase, 60);
								sleepTimer(5);
								break minor;
								
							}
							
						}else if(expStatus.equalsIgnoreCase("rejected"))
						{
							if(cols.get(5).getText().trim().equalsIgnoreCase("Rejected"))
							{
								System.out.println("The status of the case is Rejected");
								caseReported=true;
								break major;
								
							}else
							{
								System.out.println("The case is not yet Rejected so waiting for: "+k+" th time");
								jsMovetoEle(wDriver, null, "refresh");
								getElement(wDriver, "css", btn_CreateNewCase, 60);
								sleepTimer(4);
								break minor;
								
							}
							
						}else if(expStatus.equalsIgnoreCase("pending"))
						{
							if(cols.get(5).getText().trim().equalsIgnoreCase("Pending"))
							{
								System.out.println("The status of the case is Pending");
								caseReported=true;
								break major;
								
							}else
							{
								System.out.println("The case is not yet Pending so waiting for: "+k+" th time");
								jsMovetoEle(wDriver, null, "refresh");
								getElement(wDriver, "css", btn_CreateNewCase, 60);
								sleepTimer(5);
								break minor;
								
							}
							
						}
	
							
	
				}
			}//minor
	}//major for
		
	if(!caseReported)
	{
		System.out.println("The case did not move into the Change status after long waiting haours");
		throw new Exception("The Case Not Moving Different Status After Successful Review ");
	}

	}
	
	public String getComments(TestVars gt) throws Exception
	{
		String comment="";
		

		//boolean caseReported=false;
	major:for(int k=0;k<10;k++)
		{
			getElement(wDriver, "css", div_EndRecords, 45);
			List<WebElement> datarows=null;
			for(int i=0;i<5;i++)
			{
				datarows=getElement(wDriver, "css", table_Casedata, 45).findElements(By.tagName("tr"));
				System.out.println("The number of rows is :"+datarows.size());
				System.out.println("The count in the application is :"+gt.getCnt1());
				if(datarows.size()-2==Integer.parseInt(gt.getCnt1()))
				{
					System.out.println("the cases got loaded");
					break;
				}else
				{
					System.out.println("The case are yet to load ");
					sleepTimer(5);
				}
			}
			
		

		minor:	for(int j=1;j<datarows.size()-1;j++)
			{
				jsMovetoEle(wDriver, datarows.get(j),"move");
				List<WebElement>cols=datarows.get(j).findElements(By.tagName("td"));
				System.out.println("The case id:"+cols.get(0).getText());
				if(cols.get(0).getText().trim().equalsIgnoreCase(gt.getStrCaseid()))
				{
					System.out.println("The case row is found for:"+gt.getStrCaseid());
	
						jsMovetoEleBy(wDriver, "xpath", "//p[text()='"+gt.getStrCaseid()+"']", 45, "move");
						sleepTimer(3);
						String actStr=cols.get(5).getText().trim();

							if(actStr.equalsIgnoreCase("Reported")||actStr.equalsIgnoreCase("Rejected"))
							{
								jsMovetoEle(wDriver, cols.get(7).findElement(By.tagName("img")), "click");
								comment=getAttr(wDriver, "css", msg_Popup_Gradercomment, 60,"innerText");
								jsMovetoEleBy(wDriver, "xpath", msg_Popup_GraderCommentClose, 10, "click");
								System.out.println("Read the comments and closed the popup");
								sleepTimer(3);
								break major;
								
							}else
							{
								System.out.println("The case is not yet reported so waiting for: "+k+" th time");
								jsMovetoEle(wDriver, null, "refresh");
								getElement(wDriver, "css", btn_CreateNewCase, 60);
								sleepTimer(5);
								break minor;
								
							}
							
						
							
	
				}
			}//minor
	}//major for
		
	if(comment.equalsIgnoreCase(""))
	{
		System.out.println("The Grader Comments not found");
		throw new Exception("The Grader Comments not found");
	}
	System.out.println("The text found in the popup is :"+comment);
	return comment;	
		
	}
	
	
	public Web_AcUploaderHomePage gotoHome() throws Exception
	{
		clickBy(wDriver, "css", new Web_Navbar(wDriver).link_Home, 10);
		System.out.println("Navigating to Uploader Home");
		return new Web_AcUploaderHomePage(wDriver);
	}
	
	
	
}
