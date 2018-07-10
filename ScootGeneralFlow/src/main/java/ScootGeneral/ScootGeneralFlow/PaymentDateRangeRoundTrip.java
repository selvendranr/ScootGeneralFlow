package ScootGeneral.ScootGeneralFlow;
 
import org.apache.commons.lang3.time.StopWatch; 
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


import pack.base.TestBaseSetup;

public class PaymentDateRangeRoundTrip extends TestBaseSetup {
	
	protected WebDriver driver;
	String requestInfo="a[title='Request info']";
	String makePayment="li[class='makePaymentUser']>a";	//link Text	
	 
	//String groupName="input[id=requestGroupName][name=requestGroupName]";
	String groupId="input[id=requestMasterId][name=requestMasterId]";
	//String tripType = "select[id=requestType][name=requestType]";
	String searchBtn = "a.btn.custom-btn.mar-top-30";
	//Search
	String viewDetails1="//td/p[text()[contains(.,'";
	String viewDetails2="')]]/../../td[6]/a[contains(text(),'Make payment')]";
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

		
	//-----------------Request Details------------------------------//
	String grpId="div.approved-flight-hdr.mar-top-none+table tbody tr:nth-of-type(2) td:first-of-type>p>span";
	String accFarePerPax="div.approved-flight-hdr.mar-top-none+table tbody tr:nth-of-type(2) td:nth-of-type(2) span";
	String totalFare="div.approved-flight-hdr.mar-top-none+table tbody tr:nth-of-type(2) td:nth-of-type(3)";
	String pnr="div.approved-flight-hdr.mar-top-none+table tbody tr:nth-of-type(2) td:nth-of-type(3) a";
	

	
	String agentId="select[id='agentName']";	
	String makePaymentBtn="//input[@value='Submit' and not(@id='sendRequest')]";
	
	
	String succedMassage="div[id*='container-']>span[id*='component-']";
	String succedMsgOkBtn="//span[text()='OK']/..";
	String thankYou="div[class='thankyou-alert-box']";	
	String logOut="a[class=logout]";
	
	
	String grpIdIDOnPayPage,accFarePerPaxOnPayPage,totalFareOnPayPage,pnrOnPayPage;
	 	 
	StopWatch processingTime = new StopWatch();	
	double pageLoadTimeV,paymentSubmitTimeV;
	Login login;
	 
	Select select;
	public PaymentDateRangeRoundTrip(WebDriver driver) {
		this.driver = driver;
	}
	
	public void makePayment(String reqId) {

	//	driver.navigate().refresh();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		login=new Login(driver);
		login.doLogin(1);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	waitExplicitlyByLocator(driver,requestInfo,"cssselector",60);	 
		 findEle(driver,requestInfo,"cssselector").click();
	 

		try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			waitExplicitlyByLocator(driver,makePayment,"cssselector",30);				
				findEle(driver,makePayment,"cssselector").click();
				try{
					 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
					 processingTime.start();
					  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
					  processingTime.stop();
					  pageLoadTimeV=pageLoadTimeV+processingTime.getTime();
					  processingTime.reset();	
				 	}
				 	catch(TimeoutException e){
				 		System.out.println("After Munu Click Processing is not displayed");
				 	}
		
	 	String onlyNo=reqId.replaceAll("[^\\.0123456789]","");
		findEle(driver,groupId,"cssselector").sendKeys(onlyNo);
		
		waitExplicitlyByLocator(driver,searchBtn,"cssselector",30);
		 
		 findEle(driver,searchBtn,"cssselector").click();
		
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
				 processingTime.start();
				  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
				  processingTime.stop();
				  pageLoadTimeV=pageLoadTimeV+processingTime.getTime();
				  processingTime.reset();	
			 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Search  Processing is not displayed");
			 	}
			waitExplicitlyByLocator(driver,viewDetails1+reqId+viewDetails2,"xpath",30);
			findEle(driver,viewDetails1+reqId+viewDetails2,"xpath").click();
		
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
				 processingTime.start();
				  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
				  processingTime.stop();
				  pageLoadTimeV=pageLoadTimeV+processingTime.getTime();
				  processingTime.reset();	
			 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Make Payment Link Processing  is not displayed");
			 	}
			 waitExplicitlyByLocator(driver,grpId,"cssselector",50);
		//---------------------Get the values of Request Details-----------------------------//
				grpIdIDOnPayPage=findEle(driver,grpId,"cssselector").getText();
				accFarePerPaxOnPayPage=findEle(driver,accFarePerPax,"cssselector").getText();
				totalFareOnPayPage=findEle(driver,totalFare,"cssselector").getText();

			
				select =new Select(findEle(driver,agentId,"cssselector"));
				select.selectByIndex(1);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 findEle(driver,makePaymentBtn,"xpath").click();
		

					try{
						 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
						 processingTime.start();
						  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",2000);
						  processingTime.stop();
						  paymentSubmitTimeV=paymentSubmitTimeV+processingTime.getTime();
						  processingTime.reset();	
					 	}
					 	catch(TimeoutException e){
					 		System.out.println("After Search  Processing is not displayed");
					 	}	
					
					
				
					try{
					 waitExplicitlyByLocator(driver,succedMassage,"cssselector",50);	
					 findEle(driver,succedMsgOkBtn,"xpath").click();
					 
					 waitExplicitlyByLocator(driver,thankYou,"cssselector",50);	
						

		
					}catch(TimeoutException e){
				 		System.out.println("After Submit Success is not displayed");
				 	}
					 



		
	
	}


	
	

	
}
