package com.demo.pages;

public class SearchResultPage {
	
	//booking.com is resulting page
	
	public String leelaSeeAvailaiblityXpath ="//*[contains(text(),'The Leela Goa')]/../../../../../..//*[contains(text(),'See availability')]";
	public String lagoonTerraceRoomDDXpath = "//span[contains(text(),'Lagoon Terrace Room')]/../../../../..//select";
	public String reserveButtonXpath ="//*[@class='hprt-reservation-breakfast-message']/..//*[contains(text(),'reserve')]";
	
	public String firstNameId="firstname";
	public String lastNameId="lastname";
	public String emailId="email";
	public String emailConfirmId="email_confirm";
	public String mailGuestRadioId="notstayer_false";
	public String finalDetailsXpath ="//*[contains(text(),'Next: Final details')]";
	
	public String phoneId="phone";
	public String cardNoId = "cc_number";
	public String ccMonthDDId="cc_month";
	public String ccYearDDId="ccYear";
	public String cvcId="cc_cvc";
	public String completeBookingBtnXpath="//*[contains(text(),'Complete booking')]//parent::button[@name='book']";
	

}
