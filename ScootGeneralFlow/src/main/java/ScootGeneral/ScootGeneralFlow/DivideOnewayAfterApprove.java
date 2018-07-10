package ScootGeneral.ScootGeneralFlow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class DivideOnewayAfterApprove extends TestBaseSetup {
	
protected WebDriver driver;
	
	
	String modify="a[title='Modify request']";
	String divide="li[class='groupChangeQueryBoxDD']>a";	//link Text
	
	
	 String groupName="input[id=requestGroupName][name=requestGroupName]";
	String groupId="input[id=requestMasterId][name=requestMasterId]";
	String pnr = "pnr";
	String searchBtn = "a.btn.custom-btn.mar-top-30";
	//Search
	String divide1="//td/p[text()[contains(.,'";
	String divide2="')]]/../../td[5]/a[contains(text(),'Divide')]";
		
	//-----------------Left Column details------------------------------//
	String divideWindow="divideRequestWindow";//Id

	//-----------------TIME LIMIT details------------------------------//
	String requestID="//label[text()='Request id:']/following-sibling::div/div";
	String requestType="//label[text()='Request type:']/following-sibling::div/div";// CSS
	String tripTye="//label[text()='Trip type:']/following-sibling::div/div";// CSS
	String currentStatus="//label[text()='Current status:']/following-sibling::div/div";// CSS
	
	String adultOld="#parentAdultCount-bodyEl>div";//CSS
	String childOld="#parentChildCount-bodyEl>div";//CSS
	//String infantOld="#parentInfantCount-bodyEl>div";//CSS
	
	

	String adultTxt="newAdultCount";//Name
	String childTxt="newChildCount";//Name
	//String infantTxt="newInfantCount";//Name
	//String expectedFare="expectedFare";//Name
	String remarks="userRemarks";//Name
	String divideBtn="#divideRequestWindow-body+div>div button";//id
	
	String conformMsg="//span[text()='Are you sure that you want to divide the request?']";
	String conformMsgOk="//span[text()='Yes']/..";
	String succedMassage="//span[contains(text(),'The request has been divided successfully.')]";
	String succedMsgOkBtn="//span[text()='OK']/..";
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	
	String logOut="a[class=logout]";
	
	String requestIDV,requestTypeV,tripTyeV,currentStatusV;
	String adultCurrV,childCurrV,infantCurrV,adultNewV,childNewV,infantNewV;
	String newRequestIDV;
	
 	private Login login;
	private WebElement webEle;
	Select select;
	public DivideOnewayAfterApprove(WebDriver driver) {
		this.driver = driver;
	}
	
	public void divideRequest(String reqId) {
		
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

		waitExplicitlyByLocator(driver,divide,"cssselector",30);	
			
			findEle(driver,divide,"cssselector").click();
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
		waitExplicitlyByLocator(driver,divide1+reqId+divide2,"xpath",30);	
		webEle=findEle(driver,divide1+reqId+divide2,"xpath");
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
	waitExplicitlyByLocator(driver,divideWindow,"id",120);	
	
	requestIDV=findEle(driver,requestID,"xpath").getText();
	requestTypeV=findEle(driver,requestType,"xpath").getText();	
	tripTyeV=findEle(driver,tripTye,"xpath").getText();
	currentStatusV=findEle(driver,currentStatus,"xpath").getText();
	
	
	
	adultCurrV=findEle(driver,adultOld,"cssselector").getText();
	childCurrV=findEle(driver,childOld,"cssselector").getText();
//	infantCurrV=findEle(driver,infantOld,"cssselector").getText();

	int ad,cd,in;
	
	ad=Integer.parseInt(adultCurrV);
	cd=Integer.parseInt(childCurrV);
//	in=Integer.parseInt(infantCurrV);
	
	ad=ad/2;
	cd=cd/2;
//	in=in/2;
	
	
	
	findEle(driver,adultTxt,"name").clear();
	findEle(driver,childTxt,"name").clear();
	//findEle(driver,infantTxt,"name").clear();

  
	findEle(driver,adultTxt,"name").sendKeys(""+ad);
	findEle(driver,childTxt,"name").sendKeys(""+cd);
	//findEle(driver,infantTxt,"name").sendKeys(""+in);
	
	adultNewV=findEle(driver,adultTxt,"name").getAttribute("value");
	childNewV=findEle(driver,childTxt,"name").getAttribute("value");
	//infantNewV=findEle(driver,infantTxt,"name").getAttribute("value");
	
	//findEle(driver,expectedFare,"name").sendKeys(""+getRandomNumber(100,200));
	findEle(driver,remarks,"name").sendKeys("Test Upsize new request");
	findEle(driver,divideBtn,"cssselector").click();
	
	waitExplicitlyByLocator(driver,conformMsg,"xpath",30);
	findEle(driver,conformMsgOk,"xpath").click();
	
 	waitExplicitlyByLocator(driver,succedMassage,"xpath",120);
    
   
		
		
 	newRequestIDV=findEle(driver,succedMassage,"xpath").getText();
	      
		
 	newRequestIDV= newRequestIDV.substring(newRequestIDV.indexOf("G")).trim();
		System.out.println("Adhoc One Way Groupt Request has been send"+newRequestIDV);
		
		 findEle(driver,succedMsgOkBtn,"xpath").click();	
	 

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
