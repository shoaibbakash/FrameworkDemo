package com.demo.common;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	public WebElement getElementById(WebDriver driver, String id)
	{
		return driver.findElement(By.id(id));
	}

	public WebElement getElementByName(WebDriver driver, String name)
	{
		return driver.findElement(By.name(name));
	}
	
	public WebElement getElementByXpath(WebDriver driver, String xpath)
	{
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public String randomUserName()
	{
		return "testuser" + String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000)) + "@gmail.com";
	}
	
	public String randomPassword()
	{
		return "Password!@@1" + String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000));
	}
	
	
}
