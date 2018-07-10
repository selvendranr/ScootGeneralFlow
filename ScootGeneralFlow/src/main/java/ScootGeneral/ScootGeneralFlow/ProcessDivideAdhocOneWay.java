package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class ProcessDivideAdhocOneWay extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String response="a[title='Response']";
	String groupChangeRequest="li[class='groupChangeRequestQueryBox']";
	String inputID = "input[name=requestId]";
	String searchBtn = "div[id='dashBoardDivGroupChange-body']+div>div>div:first-of-type button";
	String comformBtn="//span[.='Yes']";
	
 	String processImagep1= "//td[div='GRP";
	String processImagep2= "']/following-sibling::td[9]/div/img[@data-qtip='Old request']";
	 
		
	
	//-----------------Left Column details------------------------------//
	String changeWindow="changeGroupRequestWindow";//Id

	//-----------------TIME LIMIT details------------------------------//
	String requestID="//label[text()='Request id:']/following-sibling::div/div";
	String requestType="//label[text()='Request type:']/following-sibling::div/div";// CSS
	String tripTye="//label[text()='Trip type:']/following-sibling::div/div";// CSS
	String currentStatus="//label[text()='Current status:']/following-sibling::div/div";// CSS

	String adultCurr="#alternateFlightForm-body>div:nth-of-type(4)>div>div>div>div>div:first-of-type>div:first-of-type";
	String childCurr="#alternateFlightForm-body>div:nth-of-type(4)>div>div>div>div>div:nth-of-type(3)>div:first-of-type";
	String infantCurr="#alternateFlightForm-body>div:nth-of-type(4)>div>div>div>div>div:nth-of-type(5)>div:first-of-type";
//	String adultTxt="newAdultCount";//Name
//	String childTxt="newChildCount";//Name
//	String infantTxt="newInfantCount";//Name
 	String adultReq="#alternateFlightForm-body>div:nth-of-type(6)>div>div>div>div>div:first-of-type>div:first-of-type";
 	String childReq="#alternateFlightForm-body>div:nth-of-type(6)>div>div>div>div>div:nth-of-type(3)>div:first-of-type";
 	String infantReq="#alternateFlightForm-body>div:nth-of-type(6)>div>div>div>div>div:nth-of-type(5)>div:first-of-type";
	String adultNew="#alternateFlightForm-body>div:nth-of-type(8)>div>div>div>div>div:first-of-type>div:first-of-type";
 	String childNew="#alternateFlightForm-body>div:nth-of-type(8)>div>div>div>div>div:nth-of-type(3)>div:first-of-type";
 	String infantNew="#alternateFlightForm-body>div:nth-of-type(8)>div>div>div>div>div:nth-of-type(5)>div:first-of-type";
 	
 	String status ="//label[text()='Status:']/following-sibling::div[1]/div";

	String userRemark="//label[text()='User remarks:']/following-sibling::div[1]/div";
	String approveRemark="//label[text()='Approver remarks:']/following-sibling::div[1]/div";
	
	String conformMsg="//span[text()='Are you sure that you want to approve this request?']";
	String suceedYes="//span[text()='Yes']/..";
	String suceedMsg="//span[text()='Request approved successfully']";
	String suceedOk="//span[text()='OK']/..";
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	String closeBtn="(//div/img[starts-with(@id,'tool-')])[2]";	

	String logOut="a[class=logout]";
	
	String requestIDV,requestTypeV,tripTyeV,currentStatusV;
	String adultCurrV,childCurrV,infantCurrV,adultNewV,childNewV,infantNewV;
	String statusV,userRemarkV,approveRemarkV;
	String parantRequestIdV;

	WebElement wbEle;	
 
	private Login login;
	 
	Select select;
 	
	
	public ProcessDivideAdhocOneWay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void processDivideRequest(String groupID) throws IOException {
		
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
		findEle(driver,groupChangeRequest,"cssselector").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
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
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
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
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);	 
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
		 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",150);
	 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
		waitExplicitlyByLocator(driver,changeWindow,"id",120);	
		
		requestIDV=findEle(driver,requestID,"xpath").getText();
		requestTypeV=findEle(driver,requestType,"xpath").getText();	
		tripTyeV=findEle(driver,tripTye,"xpath").getText();
		currentStatusV=findEle(driver,currentStatus,"xpath").getText();
			
		adultCurrV=findEle(driver,adultCurr,"cssselector").getText();
		childCurrV=findEle(driver,childCurr,"cssselector").getText();
		infantCurrV=findEle(driver,infantCurr,"cssselector").getText();
		

		// findEle(driver,adultNew+":nth-of-type(2)","cssselector").click();
		// findEle(driver,childNew+":nth-of-type(2)","cssselector").click();
		// findEle(driver,infantNew+":nth-of-type(2)","cssselector").click();

		
		adultNewV=findEle(driver,adultNew,"cssselector").getText();
		childNewV=findEle(driver,childNew,"cssselector").getText();
		infantNewV=findEle(driver,infantNew,"cssselector").getText();


		System.out.println(adultCurrV+"\t"+childCurrV+"\t"+infantCurrV+"\t"+adultNewV+"\t"+childNewV+"\t"+infantNewV);
		
		statusV=findEle(driver,status,"xpath").getText();
		userRemarkV=findEle(driver,userRemark,"xpath").getText();
		approveRemarkV=findEle(driver,approveRemark,"xpath").getText();
		

		parantRequestIdV= approveRemarkV.substring(approveRemarkV.indexOf("G")).trim();
		System.out.println("Parent Request Id is "+parantRequestIdV);
	
		Actions act = new Actions(driver);
		act.moveToElement(findEle(driver,closeBtn,"xpath")).click().build().perform();
	
			 

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	waitExplicitlyByLocator(driver,logOut,"cssselector",30);
		 WebElement	wbEle=findEle(driver,logOut,"cssselector");	
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", wbEle);
	
		System.out.println("Requst COmpleted ");	
		
	 	}
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	      Alert a1=driver.switchTo().alert();
	      
	     String s1=a1.getText();
	      System.out.println(s1);

	      	a1.accept();
	       
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    {
	        return false; 
	    }   
	}
	
	

	
	
	
	
	
	

	


	


}

	

