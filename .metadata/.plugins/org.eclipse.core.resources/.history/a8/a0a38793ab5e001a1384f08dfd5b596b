package com.selenium.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckforDownload extends SeleniumUtils {
	private int tryGetFileSizeInKB (URL url)
	{
		HttpURLConnection conn = null;
	     try {
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("HEAD");
	         conn.getInputStream();
	         return conn.getContentLength()/1024;
	     } catch (IOException e) {
	         return -1;
	     } finally {
	         conn.disconnect();
	     }
	}
	
	public void waitForDownload(String location) throws IOException
	{
			URL url= new URL(location);
			for(int i=0;i<10;i++)
			{
				try{
					InputStream in = new BufferedInputStream(url.openStream());
					System.out.println("Download has started");
				}catch(FileNotFoundException fnf)
				{
					System.out.println("The file is yet to start download and waoting for "+i+" th time");
					sleepTimer(10);
				}
					
				}
			
			File file = new File(location.split(":")[1].substring(2));
			for(int j=0;j<9;j++)
			{
		        double size = (((double)file.length())/ (1024 * 1024));
		        
		        System.out.println("File size in MB:- " +size );
		        if(size<1.6)
		        {
		        	System.out.println("The download not completed waiting for .."+j);
		        	sleepTimer(5);
		        	
		        	
		        }else
		        {
		        	System.out.println("The file has been downloaded ");
		        	break;
		        }
		 	
			}
		}
			

//	        byte[] buf = new byte[1024];
//	        int n = 0;
//	        String fileToDownload = null;
//	        double updatedFileSize=0;
//	        double totalFileSize = tryGetFileSizeInKB(url)*1024;
//	        int percent;
//	        String[] pathContents=url.getPath().split("\\\\/") ;
//	        if(pathContents != null)
//	        {
//        	fileToDownload =pathContents[pathContents.length-1];
//        	System.out.println("File Name : " + fileToDownload );
//	        }
//        
//             System.out.println("Size : "+ totalFileSize/1024 + " KB");
//     		InputStream in = new BufferedInputStream(url.openStream());
//	        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//		 while (-1 != (n = in.read(buf)))
//		 {
//	            updatedFileSize = updatedFileSize +n;
//	            out.write(buf, 0, n);
//	            percent = (int)Math.round((updatedFileSize/totalFileSize)*100);
//	            if(percent == 100)
//	            	{
//	            		System.out.println("The file is downloaded");
//	            	}
//	        }
//	        out.close();
//	        in.close();
//	        byte[] response = out.toByteArray();
//	        FileOutputStream fos = new FileOutputStream(location);
//	        fos.write(response);
//	        fos.close();
//	}
//	

}
