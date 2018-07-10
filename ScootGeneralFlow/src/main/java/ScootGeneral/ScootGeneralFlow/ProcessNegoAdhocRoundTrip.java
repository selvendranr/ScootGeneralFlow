package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class ProcessNegoAdhocRoundTrip extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String response="a[title='Response']";
	String process="li[class='processDashBoard']";
	String inputID = "input[name=requestId]";
	String searchBtn = "button[class=x-btn-center]";
	String comformBtn="//span[.='Yes']";
	String processImage="tbody tr:nth-of-type(2) td:nth-of-type(15)>div>img";
	String processImagep1= "//td[div='GRP";
	String processImagep2= "']/following-sibling::td[14]/div/img";
	//String passengerDetails="']/following-sibling::td[6]/div";
		
		
	String fareLoad="//a[starts-with(@id,'displayFlightAdultFareBallon')]";
	
	String selectFlightImage="//td[div='1']/following-sibling::td[17]/div/img[@data-qtip='Add flight']";
	String secondPart="/../../preceding-sibling::td[6]/div";

	String flightSelected="button[class=x-btn-center]";
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	String clickOK="button[class=x-btn-center]";
	
	String okAtrerApprove="//span[.='OK']";
	
	String okAfterSelectFlight="//span[text()='OK']";
	
	String fareEvaluated="//label[contains(@id,'fareEvaluatedId-labelEl')]//following-sibling::div[1]/div/a";
	String fareAdult="//label[contains(@id,'totalFare-labelEl')]//following-sibling::div[1]/div";
	
	String fareChild="//label[contains(@id,'childTotalFare-labelEl')]//following-sibling::div[1]/div";
	String fareInfant="//label[contains(@id,'infantTotalFare-labelEl')]//following-sibling::div[1]/div";
	String approveBtn="span[id=approve-btnInnerEl][class=x-btn-inner]";
	
	String grpId="//label[contains(text(),'Request id :')]/following-sibling::div[1]/div";
	String grpName="//label[contains(text(),'Group name :')]/following-sibling::div[1]/div";
	String reqName="//label[contains(text(),'Requestor name:')]/following-sibling::div[1]/div";
	String reqType="//label[contains(text(),'Request type :')]/following-sibling::div[1]/div";
	String tripType="//label[contains(text(),'Trip type :')]/following-sibling::div[1]/div";
	String reqDate="//label[contains(text(),'Requested date:')]/following-sibling::div[1]/div";
	
	String onwardTrip="//div[@id='requestDetailsGrids']/div[2]/div/table/tbody/tr[2]/td[2]/div";
	String returnTrip="//div[@id='requestDetailsGrids']/div[2]/div/table/tbody/tr[3]/td[2]/div";
	String tab="(//button[starts-with(@id,'tab-')])";
	
	String getToolTip="a[id=paxDetailsLink]";
	String logOut="a[class=logout]";
	
	String allPassenger,paymentValidity;
	String groupId,groupName,requestorName,requestTYpe,tripTypeV;
	String onwardDeat,returnDeat;
	
	WebElement wbEle;
  	Select select;
	 
	//Boolean secondFlight=false;
	private Login login;
	
 	public ProcessNegoAdhocRoundTrip(WebDriver driver) {
		this.driver = driver;
	}
	
	public void processAdHocRequest(String groupID) throws IOException {
		
		groupID=groupID.replaceAll("[^\\.0123456789]","");
		login=new Login(driver);
		login.doLogin(3);
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);		
		waitExplicitlyByLocator(driver,response,"cssselector",60);
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
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
	 	 	 waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
 
	 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click Process Menu Processing is not displayed");
		 	}
		System.out.println("Adhoc Round trip Group Request Processsing is started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,inputID,"cssselector",30);
	
		
	findEle(driver,inputID,"cssselector").sendKeys(groupID);
		
		
		findEle(driver,searchBtn,"cssselector").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
 			 waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
 	 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click Search Processing is not displayed");
		 	}
	
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
			 
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
	 		
			waitExplicitlyByLocator(driver,processing,"xpath",5);
 	 		waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
 
	 		}
		 	catch(TimeoutException e){
		 		System.out.println("Before conform Popup Processing is not displayed");
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
			waitExplicitlyByLocator(driver,processing,"xpath",5);
 	 		waitExplicitlyNotByLocator(driver,processing,"xpath",500);
 			}
		 	catch(TimeoutException e){
		 		System.out.println("After Conform Processing is not displayed");
		 	}
		groupId=findEle(driver,grpId,"xpath").getText();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	} 
		
	 
	 
		try{
 			 waitExplicitlyByLocator(driver,selectFlightImage+secondPart,"xpath",5);
	 
			 findEle(driver,selectFlightImage+secondPart,"xpath").click();
		} 
 	catch(TimeoutException e){
 		System.out.println("Fare is not loaded for 1");
  
 	}
		try{
			waitExplicitlyByLocator(driver,processing,"xpath",5);
 	 		 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
 			}
		 	catch(TimeoutException e){
		 		System.out.println("Fare Already Loaded");
		 	}
		 
		
		try{	
 			waitExplicitlyByLocator(driver,selectFlightImage+secondPart+fareLoad,"xpath",60);
 			 findEle(driver,selectFlightImage+secondPart+fareLoad,"xpath").click();

		
			 
		}
		 	catch(TimeoutException e){
		 		System.out.println("Fare is not loaded for 1");
 
		 	}
		  
		  
		  try {
		Thread.sleep(1000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		
		waitExplicitlyByLocator(driver,selectFlightImage,"xpath",30);
		
		findEle(driver,selectFlightImage,"xpath").click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		



		
		 findEle(driver,tab+"[2]","xpath").sendKeys(Keys.RETURN);
		 
		 try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
 		 
			}
		 	catch(TimeoutException e){
		 		System.out.println("Tab Not Loaded");
		 	}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		try{
		findEle(driver,selectFlightImage+secondPart,"xpath").click();
		}
		catch(NoSuchElementException e){
			System.out.println("Second Flight is automatically selected");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//findEle(driver,selectFlightImage+secondPart,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
	 
		 
			}
		 	catch(TimeoutException e){
		 		System.out.println("2 processing is not displayed ");
		 	}
		try{
 			waitExplicitlyByLocator(driver,selectFlightImage+secondPart+fareLoad,"xpath",20);
 			}
		 	catch(TimeoutException e){
		 		System.out.println(" 2 Fare Already Loaded");
	 	 	}
			  
		  try {
		Thread.sleep(1000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		try{
		waitExplicitlyByLocator(driver,selectFlightImage,"xpath",30);
		
		findEle(driver,selectFlightImage,"xpath").click();
		}
	 	catch(TimeoutException e){
	 		System.out.println("Flight is Automatically selected for Sector 2");
 	 	}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 

		
		waitExplicitlyByLocator(driver,approveBtn,"cssselector",30);
			JavascriptExecutor executor3=(JavascriptExecutor)driver;		
		WebElement webEle=findEle(driver,approveBtn,"cssselector");
		executor3.executeScript("arguments[0].click();",webEle);
	 	try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(isAlertPresent())
		{
			System.out.println("alertpresent and accepted");
		}
		else
		{
			System.out.println("Alert Not Present");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(isAlertPresent())
		{
			System.out.println("alertpresent and accepted");
		}
		else
		{
			System.out.println("Alert Not Present");
		}
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
	 		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
		 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Approve Processing is not displayed");
		 	}
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
		waitExplicitlyByLocator(driver,okAtrerApprove,"xpath",120);		
	 		webEle=findEle(driver,okAtrerApprove,"xpath");
		executor3.executeScript("arguments[0].click();",webEle);
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		waitExplicitlyByLocator(driver,logOut,"cssselector",30);	

		webEle=findEle(driver,logOut,"cssselector");
		executor3.executeScript("arguments[0].click();",webEle);
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
	 		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
		  	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}


			
		System.out.println("Requst COmpleted ");	
		
	
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
	
	
	public boolean isAlertPresentDismis() 
	{ 
	    try 
	    { 
	      Alert a1=driver.switchTo().alert();
	      
	     
	      System.out.println(a1.getText());
	        
	        a1.dismiss();
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    {
	        return false; 
	    }   
	}
}

	

