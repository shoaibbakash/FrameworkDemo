
package com.demo.pages;

public class SearchPage {
	
	public String destinationId= "querytext";
	public String checkinDateXpath = "//*[text()='Check in']/../..";
	public String fromDateXpath = "//*[text()='December 2020']/../../../..//span[text()='25']/../../..";
	public String toDateXpath = "//*[text()='December 2020']/../../../..//span[text()='27']/../../..";
	public String roomXpath = "//span[contains(text(),'Room')]/..";
	public String adultsInputId ="adults-input";
	public String applyXpath ="//button[text()='Apply' and not(@id='filter-apply-handler')]";
	public String searchXpath = "//span[text()='Search']";
	
	public String hotelOptionXpath ="//*[@value='Hotel']";
	public String hotelRatingDdXpath ="//strong[contains(text(),'Guest rating')]/..";
	public String ratingXpath = "//*[text()='8.5']";
	
	public String leelaGoaXpath = "//*[text()='The Leela Goa']";
	public String leelaViewDealXpath= "//*[text()='The Leela Goa']/../../../..//*[text()='View Deal']";
	

}
