package com.selenium.utils;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverProvider {
   
	protected static ThreadLocal<RemoteWebDriver> dri = new ThreadLocal<>();
	private WebDriverProvider()
	{
		System.out.println("Take The Driver My Lord");
        System.setProperty("webdriver.chrome.driver", "/Users/VISUANDROIDAUTOMATION/ANDROID/src/test/resources/Drivers/chromedriver" );
		dri.set(new ChromeDriver());
	}
	
	public static WebDriverProvider getInstance()
	{
		return new WebDriverProvider();
	}
	
	
	public static WebDriver getDriver() throws IOException
	{
		System.out.println("Returning the configured driver from the factory");
		return dri.get();
	}

}
