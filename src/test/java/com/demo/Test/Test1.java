package com.demo.Test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.common.BrowserFactory;
import com.demo.common.CommonUtils;
import com.demo.pages.AccountSettingsPage;
import com.demo.pages.LoginPage;
import com.demo.pages.PostLoginPage;
import com.demo.pages.SearchPage;
import com.demo.pages.SearchResultPage;

public class Test1 {
	
	
	
	@Test (priority=1, description = "Trivago")	
	public void test_Requirement1() throws InterruptedException {

		WebDriver driver;
		BrowserFactory browserFactory = new BrowserFactory();
		CommonUtils commonutils = new CommonUtils();
		LoginPage loginPage = new LoginPage();
		PostLoginPage postLoginPage = new PostLoginPage();
		AccountSettingsPage accountSettingsPage= new AccountSettingsPage();
		
		browserFactory.launchUrlChrome("https://www.trivago.in/");
		driver = browserFactory.getDriver();
		Thread.currentThread().sleep(2000);
		commonutils.getElementByXpath(driver,loginPage.loginXpath).click();
		
		//driver.navigate().to("https://access.trivago.com/oauth/en-IN/login");
		
		Thread.currentThread().sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPage.createNewAccId)));
		
	
		commonutils.getElementById(driver,loginPage.createNewAccId).click();
		wait.until(ExpectedConditions.visibilityOf(commonutils.getElementById(driver,loginPage.emailId)));
		
		 //driver.manage().deleteAllCookies();
		 Thread.currentThread().sleep(1000);
		String userName = commonutils.randomUserName();
		commonutils.getElementById(driver,loginPage.emailId).sendKeys(userName+Keys.TAB);
		Thread.currentThread().sleep(1000);
		commonutils.getElementById(driver,loginPage.passwordId).sendKeys(commonutils.randomPassword()+Keys.TAB);
		Thread.currentThread().sleep(1000);
		
		commonutils.getElementById(driver,loginPage.registerButtonId).click();
		wait.until(ExpectedConditions.visibilityOf(commonutils.getElementByXpath(driver,postLoginPage.headerXpath)));
		
		driver.findElement(By.xpath("//*[text()='"+userName+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(commonutils.getElementByXpath(driver,postLoginPage.accountSettingsXpath)));
		
		commonutils.getElementByXpath(driver,postLoginPage.accountSettingsXpath).click();
		wait.until(ExpectedConditions.visibilityOf(commonutils.getElementByXpath(driver,accountSettingsPage.accountPageHeaderXpath)));
		
		// Creating ticket
		
		Select errorTopic = new Select(commonutils.getElementById(driver,accountSettingsPage.errorTopicsId));
		errorTopic.selectByVisibleText("I found an error while using trivago");
		
		Select errorType = new Select(commonutils.getElementById(driver,accountSettingsPage.errorEncounterId));
		errorType.deselectByIndex(3);
		
		commonutils.getElementById(driver, accountSettingsPage.subjectId).sendKeys("Test1111"+Keys.TAB);
		commonutils.getElementById(driver, accountSettingsPage.descId).sendKeys("Test1111"+Keys.TAB);
		commonutils.getElementById(driver, accountSettingsPage.hotelNameId).sendKeys("Test1111"+Keys.TAB);
		commonutils.getElementById(driver, accountSettingsPage.bookingSiteId).sendKeys("Test1111"+Keys.TAB);
		commonutils.getElementById(driver, accountSettingsPage.checkInDateId).click();
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver, accountSettingsPage.dateXpath).click();
		Thread.currentThread().sleep(500);
		
		String imgPath = System.getProperty("user.dir")+ "\\src\\test\\resources\\hotel.jpg";
		
		commonutils.getElementByName(driver, accountSettingsPage.attachmentName).sendKeys(imgPath);
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver, accountSettingsPage.sendMsgBtnXpath).click();
		Thread.currentThread().sleep(5000);
		org.testng.asserts.SoftAssert  softAssert = new org.testng.asserts.SoftAssert();
		
		softAssert.assertEquals(commonutils.getElementByXpath(driver,accountSettingsPage.successMsgXpath).isDisplayed(), true, "ticket not created");

		softAssert.assertAll();
	}
	
	@Test
	public void test_Requirement2() throws InterruptedException
	{
		
		WebDriver driver;
		BrowserFactory browserFactory = new BrowserFactory();
		CommonUtils commonutils = new CommonUtils();
		
		browserFactory.launchUrlChrome("https://www.trivago.in/");
		driver = browserFactory.getDriver();
		Thread.currentThread().sleep(2000);
		
		SearchPage searchPage = new SearchPage();
		commonutils.getElementById(driver,searchPage.destinationId).sendKeys("Goa"+Keys.TAB); // enter Goa
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver,searchPage.checkinDateXpath).click(); //click checkin date
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver,searchPage.fromDateXpath).click();// set checkin
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver,searchPage.toDateXpath).click(); // set checkout
		Thread.currentThread().sleep(500);
		

		commonutils.getElementByXpath(driver,searchPage.roomXpath).click();
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver,searchPage.adultsInputId).clear();
		commonutils.getElementByXpath(driver,searchPage.adultsInputId).sendKeys("1"+Keys.TAB); //enter 1 adult
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver,searchPage.applyXpath).click();
		Thread.currentThread().sleep(500);
		
		commonutils.getElementByXpath(driver,searchPage.searchXpath).click();// click on search
		Thread.currentThread().sleep(500);
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchPage.hotelOptionXpath)));
		
		
		commonutils.getElementByXpath(driver,searchPage.hotelOptionXpath).click();// click on hotels filter
		Thread.currentThread().sleep(500);
		
		
		
		commonutils.getElementByXpath(driver,searchPage.hotelRatingDdXpath).click();
		Thread.currentThread().sleep(500);
		commonutils.getElementByXpath(driver,searchPage.ratingXpath).click(); //click 8.5 and above rating
		Thread.currentThread().sleep(500);
		
		
		//since 'Azaya Beach Resort Goa' is not visible, selecting  'The Leela Goa'
		
		Assert.assertTrue(driver.findElements(By.xpath(searchPage.leelaGoaXpath)).size()>0, "The Leela Goa is not listed"); // if leela hotel is not listed script should fail
		
		//hence using hard assert
		
		commonutils.getElementByXpath(driver,searchPage.leelaViewDealXpath).click(); 
		Thread.currentThread().sleep(5000);
		
		// booking.com page opened
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1)); // switching to new tab
		    
		    SearchResultPage  searchResultPage = new SearchResultPage();
		    
		    commonutils.getElementByXpath(driver,searchResultPage.leelaSeeAvailaiblityXpath).click();
			Thread.currentThread().sleep(500);
			
			Select roomNo = new Select( commonutils.getElementByXpath(driver,searchResultPage.lagoonTerraceRoomDDXpath));
			
			roomNo.selectByIndex(1); // select 1 room
			
			
			commonutils.getElementByXpath(driver,searchResultPage.reserveButtonXpath).click();
			Thread.currentThread().sleep(500);
			
			
			commonutils.getElementById(driver,searchResultPage.firstNameId).sendKeys("TestUser"+Keys.TAB); 
			Thread.currentThread().sleep(500);
		
		
			commonutils.getElementById(driver,searchResultPage.lastNameId).sendKeys("lname"+Keys.TAB); 
			Thread.currentThread().sleep(500);
			
			commonutils.getElementById(driver,searchResultPage.lastNameId).sendKeys("lname"+Keys.TAB); 
			Thread.currentThread().sleep(500);
			String userName = commonutils.randomUserName();
			
			commonutils.getElementById(driver,searchResultPage.emailId).sendKeys(userName+Keys.TAB); 
			
			commonutils.getElementById(driver,searchResultPage.emailConfirmId).sendKeys(userName+Keys.TAB); 
			Thread.currentThread().sleep(500);
			
			commonutils.getElementById(driver,searchResultPage.mailGuestRadioId).click(); 
			Thread.currentThread().sleep(500);
			
			commonutils.getElementById(driver,searchResultPage.finalDetailsXpath).click(); 
			Thread.currentThread().sleep(5000);
			
			commonutils.getElementById(driver,searchResultPage.phoneId).sendKeys("9483322212"+Keys.TAB); 
			Thread.currentThread().sleep(500);
			
			commonutils.getElementById(driver,searchResultPage.cardNoId).sendKeys("431982912390"+Keys.TAB); 
			Thread.currentThread().sleep(500);
			
			commonutils.getElementById(driver,searchResultPage.cardNoId).sendKeys("431982912390"+Keys.TAB); 
			Thread.currentThread().sleep(500);
		
			
			Select expDate = new Select( commonutils.getElementById(driver,searchResultPage.ccMonthDDId));
			expDate.selectByIndex(3); 
			
			Select expDateYear = new Select( commonutils.getElementById(driver,searchResultPage.ccYearDDId));
			expDate.selectByIndex(2); 
			
			commonutils.getElementById(driver,searchResultPage.cvcId).sendKeys("321"+Keys.TAB); 
			Thread.currentThread().sleep(500);
			
			commonutils.getElementByXpath(driver,searchResultPage.completeBookingBtnXpath).click(); 
			Thread.currentThread().sleep(500);
			
			// unable to proceed after this step since it is asking for valid credit card details
			
	}

}
