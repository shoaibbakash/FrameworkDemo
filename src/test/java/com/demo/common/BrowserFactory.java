package com.demo.common;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	public WebDriver currentDriver = null;
	
	public void launchUrlChrome(String url) throws InterruptedException
	{
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
         
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 options.setPageLoadStrategy(PageLoadStrategy.NONE);
		 options.addArguments("--disable-gpu");
		 options.addArguments("disable-infobars");
		 options.addArguments("--disable-dev-shm-usage");
		 options.addArguments("--disable-application-cache");
		 //options.addArguments("incognito");
		 options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\ext\\chromedriver.exe");
		 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 ChromeDriver driver = new ChromeDriver(capabilities);
		 driver.manage().window().maximize();
		 
		 Thread.currentThread().sleep(2000);
		 
		 driver.get(url);  
		 Thread.currentThread().sleep(5000);
		 
		 driver.manage().deleteAllCookies();
		 Thread.currentThread().sleep(5000);
		 
		currentDriver=driver;
		
	}
	
	public WebDriver getDriver()
	{
		return currentDriver;
	}

}
