package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pack.base.TestBaseSetup;

public class ProcessNegotiateAdhocOneWay extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String response="a[title='Response']";
	String process="li[class='processDashBoard']";
	String inputID = "input[name=requestId]";
	String searchBtn = "button[class=x-btn-center]";
	String comformBtn="//span[.='Yes']";
	
 	String processImage="tbody tr:nth-of-type(2) td:nth-of-type(16)>div>img";
	String processImagep1= "//td[div='GRP";
	String processImagep2= "']/following-sibling::td[15]/div/img";  	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	String fareLoad="//a[starts-with(@id,'displayFlightAdultFareBallon')]";	
	String selectFlightImage="//td[div='1']/following-sibling::td[16]/div/img[@data-qtip='Add flight']";
	String secondPart="/../../preceding-sibling::td[5]/div";
	String flightSelected="button[class=x-btn-center]";

	
	String clickOK="button[class=x-btn-center]";
	
	String okAtrerApprove="//span[.='OK']/..";
	String okAfterSelectFlight="//span[text()='OK']/..";


	String approveBtn="span[id=approve-btnInnerEl][class=x-btn-inner]";


	String grpId="//label[contains(text(),'Request id :')]/following-sibling::div[1]/div";
	String grpName="//label[contains(text(),'Group name :')]/following-sibling::div[1]/div";
	String reqName="//label[contains(text(),'Requestor name:')]/following-sibling::div[1]/div";
	String reqType="//label[contains(text(),'Request type :')]/following-sibling::div[1]/div";
	String tripType="//label[contains(text(),'Trip type :')]/following-sibling::div[1]/div";
	String reqDate="//label[contains(text(),'Requested date:')]/following-sibling::div[1]/div";

	String logOut="a[class=logout]";
	
	String displacementFare="displacementFareEdit";
	String displacementFareRemark="displacementFareRemarks";
	String displacementSubmit="#displacementFareRemarks+div button";
	String conformBtn="//span[text()='Yes']/..";
	
	
	String groupId,groupName,requestorName,requestTYpe,tripTypeV;
	
	 private Login login;
	 
	 Actions act;


	
	
	public ProcessNegotiateAdhocOneWay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void processAdHocRequest(String groupID) throws IOException {
		
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
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
		 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
	 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
		System.out.println("Adhoc One Way Group Request Processsing is started");
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
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
			 waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
			  	}
		 	catch(TimeoutException e){
		 		System.out.println("After Search Processing is not displayed");
		 	}
	

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,processImage,"cssselector",30);
	//	allPassenger=findEle(driver,processImagep1+groupID+passengerDetails,"xpath").getText();
	 
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
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
	 		  waitExplicitlyNotByLocator(driver,processing,"xpath",500);
	 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Conform Processing is not displayed");
		 	}
		
		groupId=findEle(driver,grpId,"xpath").getText();
		groupName=findEle(driver,grpName,"xpath").getText();
		requestorName=findEle(driver,reqName,"xpath").getText();
		requestTYpe=findEle(driver,reqType,"xpath").getText();
		tripTypeV=findEle(driver,tripType,"xpath").getText();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}




		findEle(driver,selectFlightImage+secondPart,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
	 		waitExplicitlyNotByLocator(driver,processing,"xpath",120);
			 waitExplicitlyByLocator(driver,selectFlightImage+secondPart+fareLoad,"xpath",10);
			 
			}
		 	catch(TimeoutException e){
		 		System.out.println("Fare Already Loaded");
		 	}
		 
		
		
		  
		 waitExplicitlyByLocator(driver,selectFlightImage+secondPart+fareLoad,"xpath",120);  
		  try {
		Thread.sleep(3000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		 
		 // act=new Actions(driver);
		 // act.moveToElement(findEle(driver,selectFlightImage+secondPart+fareLoad,"xpath")).doubleClick().build().perform();
		  
		//  editFare();
		  waitExplicitlyByLocator(driver,selectFlightImage,"xpath",30);
		
		  findEle(driver,selectFlightImage,"xpath").click();
		
			try {
				Thread.sleep(5000);
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
			System.out.println(" Alert present Accepted  ");
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
			System.out.println("alertpresent and Dismissed");
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

	
		webEle=findEle(driver,logOut,"cssselector");
		executor3.executeScript("arguments[0].click();",webEle);
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
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
	
	
	public boolean isAlertPresentDismiss() 
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
	
	
	
	
	
 public void editFare(){
	 
	  
	 float fareInt;
	 waitExplicitlyByLocator(driver,displacementFare,"name",50);
	 fareInt=Float.parseFloat(findEle(driver,displacementFare,"name").getAttribute("value"));	
	 fareInt--;
	 findEle(driver,displacementFare,"name").clear();
	 findEle(driver,displacementFare,"name").sendKeys(""+fareInt);
	 findEle(driver,displacementFareRemark,"name").sendKeys("Test Fare Change");
		
	 findEle(driver,displacementSubmit,"cssselector").click();	
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
	 waitExplicitlyByLocator(driver,okAfterSelectFlight,"xpath",30);
	 findEle(driver,okAfterSelectFlight,"xpath").click();	
	 
	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
 }
	

	


	


}

	

