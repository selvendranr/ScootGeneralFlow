package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pack.base.TestBaseSetup;

public class NegotiateDateRangeOneWay extends TestBaseSetup {
	
protected WebDriver driver;
	

	String requestWindowFirst="requestDetailsGrid";
	String response="a[title='Response']";
	String process="li[class='processDashBoard']";
	String inputID = "input[name=requestId]";
	String searchBtn = "button[class=x-btn-center]";
	

	String processImage="tbody tr:nth-of-type(2) td:nth-of-type(15)>div>img";
	String processImagep1= "//td[div='GRP";
	String processImagep2= "']/following-sibling::td[15]/div/img";
	//String passengerDetails="']/following-sibling::td[6]/div";

	

	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	String grpId="//label[contains(text(),'Request id :')]/following-sibling::div[1]/div";
	String grpName="//label[contains(text(),'Group name :')]/following-sibling::div[1]/div";
	String reqName="//label[contains(text(),'Requestor name:')]/following-sibling::div[1]/div";
	String reqType="//label[contains(text(),'Request type :')]/following-sibling::div[1]/div";
	String tripType="//label[contains(text(),'Trip type :')]/following-sibling::div[1]/div";
	String reqDate="//label[contains(text(),'Requested date:')]/following-sibling::div[1]/div";

	String comformBtn="//span[.='Yes']";

	String closeBtn="(//div/img[starts-with(@id,'tool-')])[3]";	
	String validityLink="a[id=validityLink]";
	String getVal="div[id=paymentValidity-bodyEl] input";
	String paymentPecent="div[id='paymentPercentage-bodyEl']>input";
	String getVal2="div[id=paymentValidity0-bodyEl] input";
	String addImage="div[id='displayPercent'] + div + img";
	String updateValidity="//span[contains(text(),'Update')]/..";

	
	String selectFlightImage="//td[div='";
	String selectFlightImage2="']/following-sibling::td[12]/div/div";	
 
	String flightScheduleMtrixVerify="//a/span[starts-with(@id,'selectedFlightMatrixText')]/..";
	String flightScheduleMtrixCheckBox="//span/input[starts-with(@id,'CHECK_selectedFlights_')]";

	
	String baseFare="#baseFare-bodyEl>input";
	String dispFareRemark="#dispFareRemark-bodyEl>textarea";	
	String submitSD="//span[text()='Submit']/..";
	String conformBtn="//span[text()='Yes']/..";
	String sucessMsg="//span[text()='Fare is overriden successfully']";
	String sucessOk="//span[text()='OK']/..";

	String takeControl="takeControlBtn-btnEl";

	String approveBtn="button[id='approve-btnEl']";
	

	
	String okAtrerApprove="//span[text()='OK']/..";
	
	String logOut="a[class=logout]";
	
	String allPassenger,paymentValidity;
	String groupId,groupName,requestType,requestorName,requestDate;
	String expFareV,flightNoV,originV,destV,requestedFareV;
	
 	private Login login;
  	 
	public NegotiateDateRangeOneWay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void processSeriesRequest(String groupID) throws IOException {
		
		groupID=groupID.replaceAll("[^\\.0123456789]","");
		login=new Login(driver);
		login.doLogin(3);
		
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
		waitExplicitlyByLocator(driver,response,"cssselector",30);
		findEle(driver,response,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		findEle(driver,process,"cssselector").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",15);
			    waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
			  	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
		System.out.println("Series Group Request Processsing is started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,inputID,"cssselector",30);
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,inputID,"cssselector").sendKeys(groupID);
		
		
		findEle(driver,searchBtn,"cssselector").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
		 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
		 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Search Processing is not displayed");
		 	}
	



		waitExplicitlyByLocator(driver,processImage,"cssselector",30);
	//	allPassenger=findEle(driver,processImagep1+groupID+passengerDetails,"xpath").getText();
	 
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
		
		
		try{
	 		
			waitExplicitlyByLocator(driver,processing,"xpath",50);
			 	  waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
		 			}
		 	catch(TimeoutException e){
		 		System.out.println("Before conform Processing is not displayed");
		 	}

		
		if(findEle(driver,comformBtn,"xpath").isDisplayed())
		{
	
		waitExplicitlyByLocator(driver,comformBtn,"xpath",30);	
		findEle(driver,comformBtn,"xpath").click();
		}
		
		else
		{
			System.out.println("Conform box is not displayed ");
		}
		
		
	 	try{
			 waitExplicitlyByLocator(driver,processing,"xpath",50);
	 		  waitExplicitlyNotByLocator(driver,processing,"xpath",500);
		 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Conform Processing is not displayed");
		 	}
	 		groupId=findEle(driver,grpId,"xpath").getText();
		 	groupName=findEle(driver,grpName,"xpath").getText();
			requestorName=findEle(driver,reqName,"xpath").getText();
		 		 


			 
		  		 	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 waitExplicitlyByLocator(driver,validityLink,"cssselector",60);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		// waitExplicitlyByLocator(driver,selectFlightImage+"1"+selectFlightImage2,"xpath",30);
		//	findEle(driver,selectFlightImage+"1"+selectFlightImage2,"xpath").click();


		try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		//waitExplicitlyByLocator(driver,"("+flightScheduleMtrixVerify+")[1]","xpath",30);
			
		//	List<WebElement> scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
		//	System.out.println(scheduleMatrix.size());
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", scheduleMatrix.get(0));
			//try{
		 		
			//	waitExplicitlyByLocator(driver,processing,"xpath",50);
			// 	waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
			 
			//}
			 //	catch(TimeoutException e){
			 //		System.out.println("Flight Window is not displayed");
			 //	}

			 
			//validityChange();
 		
		//	JavascriptExecutor executor = (JavascriptExecutor)driver;
			// 	try {
			//	Thread.sleep(5000);
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
			
			//List<WebElement> li1=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
			//	try {
			//	Thread.sleep(2000);
			//} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			//}
			//for(int i=0;i<li1.size();i++)
			//{
				//li1=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
				
				//executor.executeScript("arguments[0].click();", li1.get(i));
				
				
				
			//}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 

		waitExplicitlyByLocator(driver,approveBtn,"cssselector",30);
	 		
		findEle(driver,approveBtn,"cssselector").click(); 
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(isAlertPresent())
		{
			System.out.println("alertpresent and Accepted");
		}
		else
		{
			System.out.println("Alert Not Present");
		}

		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
		 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
		  	}
		 	catch(TimeoutException e){
		 		System.out.println("After Approve Processing is not displayed");
		 	}
	
		waitExplicitlyByLocator(driver,okAtrerApprove,"xpath",120);		
		 findEle(driver,okAtrerApprove,"xpath").click(); 
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		waitExplicitlyByLocator(driver,logOut,"cssselector",30);	

	
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();",findEle(driver,logOut,"cssselector"));
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
 			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
	 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
	
		System.out.println("Requst Completed ");	
		
 			
			
		}
		public boolean isAlertPresent() 
		{ 
		    try 
		    { 
		      Alert a1=driver.switchTo().alert();
		      
		     String s1=a1.getText();
		      System.out.println(s1);
		        if(s1.contains("Do you wish to verify upsell fare?")){
		       a1.dismiss();
		        }else{
		        	 a1.accept();
		        }
		        return true; 
		    }   // try 
		    catch (NoAlertPresentException Ex) 
		    {
		        return false; 
		    }   
		}
		
		public void validityChange(){
			//String tempValue;
			float fare1;
			waitExplicitlyByLocator(driver,baseFare,"cssselector",50);
			//tempValue=;
			fare1=Float.parseFloat(findEle(driver,baseFare,"cssselector").getAttribute("value"));
			fare1=fare1-1;
			findEle(driver,baseFare,"cssselector").clear();
			findEle(driver,baseFare,"cssselector").sendKeys(""+fare1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitExplicitlyByLocator(driver,dispFareRemark,"cssselector",50);
			findEle(driver,dispFareRemark,"cssselector").sendKeys("Test for Negotiation");
			
			findEle(driver,submitSD,"xpath").click();
			
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 waitExplicitlyByLocator(driver,conformBtn,"xpath",10);
				 findEle(driver,conformBtn,"xpath").click();	 
				 try{
				 		
					waitExplicitlyByLocator(driver,processing,"xpath",10);
					waitExplicitlyNotByLocator(driver,processing,"xpath",100);
				 	}
				catch(TimeoutException e){
					 		System.out.println("After Edit Fare Processing is not displayed");
					}

				 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			waitExplicitlyByLocator(driver,sucessMsg,"xpath",30);
			System.out.println(findEle(driver,sucessMsg,"xpath").getText());		
			//String sucessOk="//span[text()='OK']";
			findEle(driver,sucessOk,"xpath").click();
			
			
			
		}
		
		
	}
