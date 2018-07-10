package ScootGeneral.ScootGeneralFlow;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pack.base.TestBaseSetup;

public class PaymentAdhocOneWay extends TestBaseSetup {
	
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
	
	
	String paymentDetails="//a[text()='Payment details']/../following-sibling::table/tbody[2]";// [1]
	String wireTranfer="Wire Transfer";
	String bankName="bankName";//id
	String accountNo="accountNumber";//id
	String receiptNo="receiptNumberField";
	String calender="a[class='calendar-icon top-2']";
	String today=".ui-datepicker-days-cell-over.ui-datepicker-today a";
	
	
	String agentId="select[id='agentName']";	
	String makePaymentBtn="//input[@value='Submit' and not(@id='sendRequest')]";
	
	
	String succedMassage="setInfoMessageError";
	String succedMsgOkBtn="#confirm-pop-up_error>div>div>div:last-of-type>button";
	 
	String logOut="a[class=logout]";
	
	
	String grpIdIDOnPayPage,accFarePerPaxOnPayPage,totalFareOnPayPage,pnrOnPayPage;
	String slNoV,percentV,amountV,receiptV,paymentValidity,Status;
	 String accountNoV,receiptNoV;

	Select select;
	private Login login;
	
	public PaymentAdhocOneWay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void makePayment(String reqId) {

		//driver.navigate().refresh();
		login=new Login(driver);
		login.doLogin(5);
	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waitExplicitlyByLocator(driver,requestInfo,"cssselector",60);	 
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
					 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);

					 waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);

			 	}
				 	catch(TimeoutException e){
				 		System.out.println("After Munu Click Processing is not displayed");
				 	}
		
	 	String onlyNo=reqId.replaceAll("[^\\.0123456789]","");
		findEle(driver,groupId,"cssselector").sendKeys(onlyNo);
		
		waitExplicitlyByLocator(driver,searchBtn,"cssselector",30);
		 
		 findEle(driver,searchBtn,"cssselector").click();
		
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);

		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);

		 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Search  Processing is not displayed");
			 	}
			waitExplicitlyByLocator(driver,viewDetails1+reqId+viewDetails2,"xpath",30);
			findEle(driver,viewDetails1+reqId+viewDetails2,"xpath").click();
		
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);

	 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Make Payment Link Processing  is not displayed");
			 	}
			 waitExplicitlyByLocator(driver,grpId,"cssselector",50);
		//---------------------Get the values of Request Details-----------------------------//
				grpIdIDOnPayPage=findEle(driver,grpId,"cssselector").getText();
				accFarePerPaxOnPayPage=findEle(driver,accFarePerPax,"cssselector").getText();
				totalFareOnPayPage=findEle(driver,totalFare,"cssselector").getText();
			
				slNoV=findEle(driver,paymentDetails+"/tr[1]/td[1]","xpath").getText();
				percentV=findEle(driver,paymentDetails+"/tr[1]/td[2]","xpath").getText();
				amountV=findEle(driver,paymentDetails+"/tr[1]/td[3]","xpath").getText();
				receiptV=findEle(driver,paymentDetails+"/tr[1]/td[4]","xpath").getText();				
				paymentValidity=findEle(driver,paymentDetails+"/tr[1]/td[5]","xpath").getText();				
				Status=findEle(driver,paymentDetails+"/tr[1]/td[6]","xpath").getText();				

				findEle(driver,wireTranfer,"linktext").click();

				 waitExplicitlyByLocator(driver,bankName,"id",10);
				
				 select=new Select(findEle(driver,bankName,"id"));
				 select.selectByIndex(1);
				 accountNoV= findEle(driver,accountNo,"id").getAttribute("value");
				 findEle(driver,receiptNo,"id").sendKeys(""+getRandomNumber(100,1000));
				 
				 receiptNoV= findEle(driver,receiptNo,"id").getAttribute("value");	 
			
				 findEle(driver,calender,"cssselector").click();
				 try {
					Thread.sleep(2000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 findEle(driver,today,"cssselector").click();
				 


	
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 findEle(driver,makePaymentBtn,"xpath").click();
		

					try{
						 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
							  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",500);

	 	}
					 	catch(TimeoutException e){
					 		System.out.println("After Search  Processing is not displayed");
					 	}	
					
					
				
					try{
					 waitExplicitlyByLocator(driver,succedMassage,"id",120);	
					 findEle(driver,succedMsgOkBtn,"cssselector").click();
					 
					 
						

		
					}catch(TimeoutException e){
				 		System.out.println("After Submit Success is not displayed");
				 	}
					 




					waitExplicitlyByLocator(driver,logOut,"cssselector",30);					 
					 JavascriptExecutor js=(JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", findEle(driver,logOut,"cssselector"));	
	
	}


	
	

	
}
