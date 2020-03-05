package com.selenium.utils;


import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import com.aventstack.extentreports.Status;
import com.sun.mail.imap.protocol.FLAGS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

public class MailBox extends ApiUtils{
	
	
	public static String getContent(String mailType,String email, String password,String folderName,String subj,String reqStr,String endStr,String contType,boolean replaceSp) throws Exception {
		Folder folder=null;
		String result=null;

		//Store Store=null;
		System.out.println("The req and the endstr are :"+reqStr+" "+endStr+" to Check in the folder: "+folderName);
	/*	Properties props = System.getProperties();
		Store store=null;
		if(mailType.equalsIgnoreCase("gmail"))
		{
			props.setProperty("mail.store.protocol", "imaps");
			Session session = Session.getInstance(props, null);
			store = session.getStore("imaps");
			store.connect("imap.gmail.com", email, password);
		}*/
		/*Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");*/
		switch(mailType.toLowerCase()) {
		case "gmail":
			//if(store==null)
			//{
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				 props.put("mail.smtp.socketFactory.port", "586");
				 props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
				 props.put("mail.smtp.auth", "true");
				 props.put("mail.smtp.port", "586");
				 props.put("mail.smtp.ssl.enable", "false");
				 props.put("mail.smtp.starttls.enable", "true");
				 props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				Session session = Session.getInstance(props);
				store = session.getStore("imaps");
				store.connect("imap.gmail.com", email, password);
			//}
			folder = store.getFolder(folderName);
			
			
			System.out.println("Total Message:" + folder.getMessageCount());
			for(int i=0;i<10;i++)
			{	
				folder.open(Folder.READ_WRITE);
				if(folder.getUnreadMessageCount()<1)
				{
					System.out.println("No new mail found as yet waiting.......");
					Thread.sleep(10000);
					folder.close();
					
				}else
				{
					System.out.println("Unread messages found");
					break;
				}
			}
			System.out.println("Unread Message:" + folder.getUnreadMessageCount());
			Message[] messages = null;
			boolean isMailFound = false;
			Message mailFromProx = null;
			// for getting the mail with specified subject
			for (int i = 0; i <= 5; i++) {
				messages = folder.search(new SubjectTerm(".*"+subj+".*"), folder.getMessages());
				if (messages.length == 0) {
					Thread.sleep(10000);
				}
			}
			//For Getting the unread mails
			for (Message mail : messages) {
				if (!mail.isSet(Flags.Flag.SEEN)) {
					mailFromProx = mail;
					System.out.println("Total Messages: " + mailFromProx.getMessageNumber());
					isMailFound = true;
				}
			}
			if (!isMailFound) {
				test.get().log(Status.ERROR, "There are no new emails received in the box subject line"+subj);
				throw new Exception("No New Mails found");

			} else {
				//loc for reading the content of themail to a Stringbuffer
				String line;
				StringBuffer buffer = new StringBuffer();
				BufferedReader reader = new BufferedReader(new InputStreamReader(mailFromProx.getInputStream()));
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				System.out.println(buffer);
				if(contType.equalsIgnoreCase("html") && replaceSp )
				{
					System.out.println("The content is html and the special characters needs tobe replaced");
					buffer=new StringBuffer(buffer.toString().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " "));
					System.out.println(buffer);
				}
				
				
				int x=buffer.toString().indexOf(reqStr)+reqStr.length();
				int y=buffer.toString().substring(x).indexOf(endStr)+x;
				System.out.println(x+":"+y);
				result = buffer.toString().substring(x,y);
				test.get().log(Status.DEBUG, "The generated link in the email  for verification"+result);
				System.out.println(result);
				
				}
			break;
			default:System.out.println("No Access Methods Defined For The Mail Bo Type:"+mailType);
		}
		
		return result.trim();
	}
	
	
	public static void markAllMailsRead(String userName,String pwd, String folderName) throws MessagingException, IOException
	{
		System.out.println("Reading all the mails for the folder:"+folderName);
		
		//Store store=null;
		/*Properties props = System.getProperties(); 
		 props.setProperty("mail.store.protocol", "imaps");
		Session session = Session.getInstance(props, null);*/
		/*Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); 
		Session session = Session.getInstance(prop);

			store = session.getStore("imaps");
			store.connect("imap.gmail.com", userName, pwd);*/
		//if(store2==null)
		//{
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			 props.put("mail.smtp.socketFactory.port", "586");
			 props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
			 props.put("mail.smtp.auth", "true");
			 props.put("mail.smtp.port", "586");
			 props.put("mail.smtp.ssl.enable", "false");
			 props.put("mail.smtp.starttls.enable", "true");
			 props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			Session session = Session.getInstance(props);
			store2 = session.getStore("imaps");
			store2.connect("imap.gmail.com", userName, pwd);
		//}
		 Folder folder = store2.getFolder(folderName);  
		  
		 if (!folder.exists()) {  
		 System.out.println(folderName+" not found you idiot");  
		 System.exit(0);  
		 }    
		 folder.open(Folder.READ_WRITE);  
		 Message[] msg = folder.getMessages(); 
	
		 int x=folder.getMessageCount();
		 for(int i=1;i<=msg.length;i++)
		 {
			 folder.getMessage(i).setFlag(FLAGS.Flag.SEEN, true);
		 }
		  
		  folder.close(true);  
		  store2.close();
		  System.out.println("Unread All The Messages In The INBOX");
		
		/* Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(userName, password);
	                    }
	                });*/
	}

public void readYahooMail(String userName,String pwd) throws MessagingException
{
	// (1) mail server info
    String host = "pop.mail.yahoo.com";
//    String user = "USERNAME";
//    String password = "PASSWORD";

    // (2) connect to my pop3 inbox in read-only mode
    Properties properties = System.getProperties();
    Session session = Session.getDefaultInstance(properties);
    Store store = session.getStore("pop3");
    store.connect(host, userName, pwd);
    Folder inbox = store.getFolder("inbox");
    inbox.open(Folder.READ_ONLY);

    // (3) create a search term for all "unseen" messages
    Flags seen = new Flags(Flags.Flag.SEEN);
    FlagTerm unseenFlagTerm = new FlagTerm(seen, false);

    // (4) create a search term for all recent messages
    Flags recent = new Flags(Flags.Flag.RECENT);
    FlagTerm recentFlagTerm = new FlagTerm(recent, true);

    // (5) combine the search terms with a JavaMail AndTerm:
    //     http://java.sun.com/developer/onlineTraining/JavaMail/contents.html#JavaMailFetching
    SearchTerm searchTerm = new AndTerm(unseenFlagTerm, recentFlagTerm);
    Message[] messages = inbox.search(searchTerm);
    
    if (messages.length == 0) System.out.println("No messages found.");

    for (int i = 0; i < messages.length; i++) {
      System.out.println("Message " + (i + 1));
      System.out.println("From : " + messages[i].getFrom()[0]);
      System.out.println("Subject : " + messages[i].getSubject());
      System.out.println("Sent Date : " + messages[i].getSentDate());
      System.out.println();
    }

    inbox.close(true);
    store.close();
	
}
	
	
}
