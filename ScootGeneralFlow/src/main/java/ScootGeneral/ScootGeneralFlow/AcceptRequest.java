package ScootGeneral.ScootGeneralFlow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class AcceptRequest extends TestBaseSetup {
	
protected WebDriver driver;
	
	
	String requestInfo="a[title='Request info']";
	String viewRequest="li[class='viewRequestUser']>a";	//link Text
	
	
	String groupName="input[id=requestGroupName][name=requestGroupName]";
	String groupId="input[id=requestMasterId][name=requestMasterId]";
	String tripType = "select[id=requestType][name=requestType]";
	String searchBtn = "a.btn.custom-btn.mar-top-30";
	//Search
	String viewDetails1="//td/p[text()[contains(.,'";
	String viewDetails2="')]]/../../td[5]/a[contains(text(),'View details')]";
		
	//-----------------Left Column details------------------------------//
	String requestId="//td[contains(text(),'Request id')]/../td[3]";

	//-----------------TIME LIMIT details------------------------------//
	String fareOnRes="//td[contains(text(),'Fare')]/../td[3]";
	String viewRequestDetails="a.view-req-det";// CSS
	String requestDetailsList="//tr[@class='view-req-bg']/td";
	String flightDetails="//tbody[starts-with(@id, 'approvedFlightDetailsRow')]/tr/td";
	String acceptTermCtn="input[id=termsAndConditionsAggree]";
	String acceptBtn="input[value=Accept]";
	String negotiateBtn="negotiationFareView";	//id
	String oldFare="#nagotiateFareAdvised  span";
	String newFareTxt="responseFare"; //Id
	String remarks="reponseRemark";	//id
	String submitBtn="responseButton";	//id
 

	String suceedMsg="div[id=setInfoMessage]";
	String suceedOk="button.btn.btnbgthemecolor";
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	
	String logOut="a[class=logout]";

 	private Login login;
	private WebElement webEle;
	Select select;
	public AcceptRequest(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acceptRequest(String reqId,int nego,String totalNego) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

		waitExplicitlyByLocator(driver,viewRequest,"cssselector",30);	
			
			findEle(driver,viewRequest,"cssselector").click();
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
			 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",150);
			 	 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Logout Processing is not displayed");
			 	}
		waitExplicitlyByLocator(driver,groupId,"cssselector",120);	
		//findEle(driver,groupName,"cssselector").sendKeys(grpName);
		String onlyNo=reqId.replaceAll("[^\\.0123456789]","");
		findEle(driver,groupId,"cssselector").sendKeys(onlyNo);
		
		
		//waitExplicitlyByLocator(driver,tripType,"cssselector",30);	

		//webEle=findEle(driver,tripType,"cssselector");
		//select=new Select(webEle);
		
		//select.selectByValue("adhoc");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitExplicitlyByLocator(driver,searchBtn,"cssselector",30);	
		
		 findEle(driver,searchBtn,"cssselector").click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,viewDetails1+reqId+viewDetails2,"xpath",30);	
		webEle=findEle(driver,viewDetails1+reqId+viewDetails2,"xpath");
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webEle);
		
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}try{
		 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
	 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",150);
 	 	}
	 	catch(TimeoutException e){
	 		System.out.println("After Logout Processing is not displayed");
	 	}
	waitExplicitlyByLocator(driver,requestId,"xpath",30);	
	
	 



			

	webEle=findEle(driver,acceptTermCtn,"cssselector");
	
	executor.executeScript("arguments[0].click();", webEle);
	
	 int total=Integer.parseInt(totalNego);
	 

	
		

		if(nego<total){			
			
			 findEle(driver,negotiateBtn,"id").click();
			 negotiation(""+nego);
			 System.out.println("Negotiation Time"+nego);
		
		}else if(nego>=total){
			findEle(driver,acceptBtn,"cssselector").click();
			 System.out.println("Negotiation Time"+nego);
		}
		
		
	 
		
		 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isAlertPresent() )
		{
			System.out.println("Present and Accepted");
		}
		else 
		{
		System.out.println("Alert Not Present");
		}
		
		if(isAlertPresent() )
		{
			System.out.println("Present and Accepted");
		}
		else 
		{
		System.out.println("Alert Not Present");
		}

			
		try{
		 		 waitExplicitlyByLocator(driver,suceedMsg,"cssselector",1200);
		  	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
	
	

		
		webEle=findEle(driver,suceedMsg,"cssselector");
		System.out.println(webEle.getText());
		
		waitExplicitlyByLocator(driver,suceedOk,"cssselector",10);		
		findEle(driver,suceedOk,"cssselector").click();
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

		
	
	}


	


	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	      Alert a1=driver.switchTo().alert();
	      
	      System.out.println(a1.getText());
	        a1.accept();
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    {
	        return false; 
	    }   
	}
	
	public void negotiation(String reks){
		String str = null;
		Float oldValue;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitExplicitlyByLocator(driver,oldFare,"cssselector",10);		
		str=findEle(driver,oldFare,"cssselector").getText();
		str=str.substring(0, str.indexOf("("));
		
		oldValue=Float.parseFloat(str);
		 
		oldValue=  oldValue-2 ;
		findEle(driver,newFareTxt,"id").sendKeys(""+oldValue);		
		findEle(driver,remarks,"id").sendKeys(reks+" Time Nagotiaton");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	getscreenshot(driver);
		findEle(driver,submitBtn,"id").click();
		//String submitBtn="responseButton";	//id

	}	

}
