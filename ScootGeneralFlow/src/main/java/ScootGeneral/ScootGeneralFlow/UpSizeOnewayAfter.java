package ScootGeneral.ScootGeneralFlow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class UpSizeOnewayAfter extends TestBaseSetup {
	
protected WebDriver driver;
	
	
	String modify="a[title='Modify request']";	//Css
	String upSize="li[class='groupChangeQueryBoxUP']>a";	//link Text
	
	
	String groupName="input[id=requestGroupName][name=requestGroupName]";
	String groupId="input[id=requestMasterId][name=requestMasterId]";
	String pnr = "pnr";
	String searchBtn = "a.btn.custom-btn.mar-top-30";
	//Search
	String upSize1="//td/p[text()[contains(.,'";
	String upSize2="')]]/../../td[5]/a[contains(text(),'Upsize')]";
		
	//-----------------Left Column details------------------------------//
	String newrequestWindow="raiseNewGroupRequest";//Id

	//-----------------TIME LIMIT details------------------------------//
	String requestID="//label[text()='Request id:']/following-sibling::div/div";
	//String sector="//label[text()='Sector:']/following-sibling::div/div";// xpath
	String travelDate ="//label[text()='Travel date:']/following-sibling::div/div";
	String noOfPax="//label[text()='Number of guests:']/following-sibling::div/div";// xpath

	String adultTxt="noOfAdult";//Name
	//String childTxt="noOfChild";//Name
	//String infantTxt="noOfInfant";//Name
	 
	String expectedFate="expectedFare";//Name	
	String userRemark="remarks";//name
	String sendReqBtn="raiseRequestBtn-btnEl";//id
	
	String succedMassage="div[id=setInfoMessage]";
	String succedMsgOkBtn="button.btn.btnbgthemecolor";
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	
	String logOut="a[class=logout]";
	
	String requestIDV,travelDateV,noOfPaxV;
	String adultNewV,childNewV,infantNewV;
	
	String newRequestIDV;

	
 	private Login login;
	private WebElement webEle;
	Select select;
	public UpSizeOnewayAfter(WebDriver driver) {
		this.driver = driver;
	}
	
	public void upSizeRequest(String reqId) {
		
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
		}
		
		waitExplicitlyByLocator(driver,modify,"cssselector",60);	
		findEle(driver,modify,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waitExplicitlyByLocator(driver,upSize,"cssselector",30);	
			
			findEle(driver,upSize,"cssselector").click();
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",150);
			 	 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Logout Processing is not displayed");
			 	}
		waitExplicitlyByLocator(driver,groupId,"cssselector",120);	
		//findEle(driver,groupName,"cssselector").sendKeys(grpName);
		String onlyNo=reqId.replaceAll("[^\\.0123456789]","");
		findEle(driver,groupId,"cssselector").sendKeys(onlyNo);
		
		
		waitExplicitlyByLocator(driver,pnr,"id",60);	

	 		
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
		waitExplicitlyByLocator(driver,upSize1+reqId+upSize2,"xpath",30);	
		webEle=findEle(driver,upSize1+reqId+upSize2,"xpath");
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webEle);
		
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}try{
		 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
	 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",150);
 	 	}
	 	catch(TimeoutException e){
	 		System.out.println("After Logout Processing is not displayed");
	 	}
	waitExplicitlyByLocator(driver,newrequestWindow,"id",120);	
	
	requestIDV=findEle(driver,requestID,"xpath").getText();
	//sectorV=findEle(driver,sector,"xpath").getText();
	travelDateV=findEle(driver,travelDate,"xpath").getText();
	noOfPaxV=findEle(driver,noOfPax,"xpath").getText();

	findEle(driver,adultTxt,"name").clear();
	//findEle(driver,childTxt,"name").clear();
	//findEle(driver,infantTxt,"name").clear();
	
	findEle(driver,adultTxt,"name").sendKeys(""+getRandomNumber(5,8));
	//findEle(driver,childTxt,"name").sendKeys(""+getRandomNumber(1,2));
	//findEle(driver,infantTxt,"name").sendKeys(""+getRandomNumber(1,3));

	
	adultNewV=findEle(driver,adultTxt,"name").getAttribute("value");
	//childNewV=findEle(driver,childTxt,"name").getAttribute("value");
	//infantNewV=findEle(driver,infantTxt,"name").getAttribute("value");

	
	findEle(driver,expectedFate,"name").clear();
	findEle(driver,userRemark,"name").clear();
	 
	findEle(driver,expectedFate,"name").sendKeys(""+getRandomNumber(100,300));
	findEle(driver,userRemark,"name").sendKeys("Test Up Size");
	
	findEle(driver,sendReqBtn,"id").click();
	System.out.println(adultNewV+"\t"+childNewV+"\t"+infantNewV);
	
	 	
	waitExplicitlyByLocator(driver,succedMassage,"cssselector",120);
    
	   
	
	
	
	newRequestIDV=findEle(driver,succedMassage,"cssselector").getText();
  

	newRequestIDV= newRequestIDV.substring(newRequestIDV.indexOf("G")).trim();
	System.out.println("Adhoc One Way Groupt Request has been send"+newRequestIDV);
	
	 findEle(driver,succedMsgOkBtn,"cssselector").click();	
 	 

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


}
