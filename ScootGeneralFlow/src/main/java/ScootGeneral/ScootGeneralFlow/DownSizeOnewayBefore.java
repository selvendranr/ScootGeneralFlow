package ScootGeneral.ScootGeneralFlow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class DownSizeOnewayBefore extends TestBaseSetup {
	
protected WebDriver driver;
	
	
	String modify="a[title='Modify request']";
	String downSize="li[class='groupChangeQueryBoxDS']>a";	//link Text
	
	
	// String groupName="input[id=requestGroupName][name=requestGroupName]";
	String groupId="input[id=queryBoxRequestMasterId]";
	String pnr = "pnr";
	String searchBtn = "a.btn.custom-btn.mar-top-30";
	//Search
	String downSize1="//td/p[text()[contains(.,'";
	String downSize2="')]]/../../td[5]/a[contains(text(),'Downsize')]";
		
	//-----------------Left Column details------------------------------//
	String changeWindow="changeGroupRequestWindow";//Id

	//-----------------TIME LIMIT details------------------------------//
	String requestID="//label[text()='Request id:']/following-sibling::div/div";
	String requestType="//label[text()='Request type:']/following-sibling::div/div";// CSS
	String adultCurr="//label[text()='No of adult:']/following-sibling::div/div";
	//String childCurr="//label[text()='No of child:']/following-sibling::div/div";
//	String infantCurr="//label[text()='No of infant:']/following-sibling::div/div";
	String adultTxt="newAdultCount";//Name
	//String childTxt="newChildCount";//Name
//	String infantTxt="newInfantCount";//Name
	String adultNew="#newAdultCount-triggerWrap>div";
//	String childNew="#newChildCount-triggerWrap>div";
//	String infantNew="#newInfantCount-triggerWrap>div";

	String userRemark="userRemarks";
	String sendReqBtn="//span[text()='Send request']/..";
	
	String suceedMsg="//span[text()='Request approved successfully']";
	String suceedOk="//span[text()='OK']/..";
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	
	String logOut="a[class=logout]";
	
	String requestIDV,requestTypeV;
	String adultCurrV,childCurrV,infantCurrV,adultNewV,childNewV,infantNewV;
	String suceedMsgV;
	
 	private Login login;
	private WebElement webEle;
	Select select;
	public DownSizeOnewayBefore(WebDriver driver) {
		this.driver = driver;
	}
	
	public void downRequest(String reqId) {
		
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

		waitExplicitlyByLocator(driver,downSize,"cssselector",30);	
			
			findEle(driver,downSize,"cssselector").click();
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
			 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",150);
			 	 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Selection  Processing is not displayed");
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
		waitExplicitlyByLocator(driver,downSize1+reqId+downSize2,"xpath",30);	
		webEle=findEle(driver,downSize1+reqId+downSize2,"xpath");
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
	waitExplicitlyByLocator(driver,changeWindow,"id",120);	
	
	requestIDV=findEle(driver,requestID,"xpath").getText();
	requestTypeV=findEle(driver,requestType,"xpath").getText();
	
	
	adultCurrV=findEle(driver,adultCurr,"xpath").getText();
	//childCurrV=findEle(driver,childCurr,"xpath").getText();
	//infantCurrV=findEle(driver,infantCurr,"xpath").getText();
	

	 findEle(driver,adultNew+":nth-of-type(2)","cssselector").click();
	// findEle(driver,childNew+":nth-of-type(2)","cssselector").click();
	// findEle(driver,infantNew+":nth-of-type(2)","cssselector").click();

	
	adultNewV=findEle(driver,adultTxt,"name").getAttribute("value");
//	childNewV=findEle(driver,childTxt,"name").getAttribute("value");
	//infantNewV=findEle(driver,infantTxt,"name").getAttribute("value");

	System.out.println(adultCurrV+"\t"+childCurrV+"\t"+infantCurrV+"\t"+adultNewV+"\t"+childNewV+"\t"+infantNewV);
	
	findEle(driver,userRemark,"name").sendKeys("Down Size Test");
	findEle(driver,sendReqBtn,"xpath").click();
	
	waitExplicitlyByLocator(driver,suceedMsg,"xpath",30);		
	suceedMsgV=findEle(driver,suceedMsg,"xpath").getText();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	findEle(driver,suceedOk,"xpath").click();

		 

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
