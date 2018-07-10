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

public class ProcessDownSizeSeriesOneWay extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String response="a[title='Response']";
	String groupChangeRequest="li[class='groupChangeRequestQueryBox']";
	String inputID = "input[name=requestId]";
	String searchBtn = "div[id='dashBoardDivGroupChange-body']+div>div>div:first-of-type button";
	String comformBtn="//span[.='Yes']";
	
	//String processImage="tbody tr:nth-of-type(2) td:nth-of-type(15)>div>img";
	String processImagep1= "//td[div='GRP";
	String processImagep2= "']/following-sibling::td[9]/div/img";
	//String passengerDetails="']/following-sibling::td[6]/div";

		
	
	//-----------------Left Column details------------------------------//
	String changeWindow="changeGroupRequestWindow";//Id

	//-----------------TIME LIMIT details------------------------------//
	String requestID="//label[text()='Request id:']/following-sibling::div/div";
	String requestType="//label[text()='Request type:']/following-sibling::div/div";// CSS
	String adultCurr="//label[text()='No of adult:']/following-sibling::div/div";
	String childCurr="//label[text()='No of child:']/following-sibling::div/div";
	//String infantCurr="//label[text()='No of infant:']/following-sibling::div/div";
//	String adultTxt="newAdultCount";//Name
//	String childTxt="newChildCount";//Name
//	String infantTxt="newInfantCount";//Name
//	String adultNew="#newAdultCount-triggerWrap>div";
//	String childNew="#newChildCount-triggerWrap>div";
//	String infantNew="#newInfantCount-triggerWrap>div";
	String status="//label[starts-with(@id,'displayfield-') and text()='Status:']/following-sibling::div/div";
	String approverRemarks="//label[text()='Approver remarks:']/following-sibling::div/div";
	

	//String userRemark="userRemarks";
	//String approveReqBtn="//span[text()='Approve request']/..";
	
	//String conformMsg="//span[text()='Are you sure that you want to approve this request?']";
	//String suceedYes="//span[text()='Yes']/..";
	//String suceedMsg="//span[text()='Request approved successfully']";
	//String suceedOk="//span[text()='OK']/..";
	//String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	String closeBtn="(//div/img[starts-with(@id,'tool-')])[2]";	
	
	String logOut="a[class=logout]";
	
	String requestIDV,requestTypeV;
	String adultCurrV,childCurrV,infantCurrV,adultNewV,childNewV,infantNewV;
	
	String statusV,approverRemarksV;


	WebElement wbEle;	
 
	private Login login;
	 
	Select select;
 	
	
	public ProcessDownSizeSeriesOneWay(WebDriver driver) {
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
		
		
		adultCurrV=findEle(driver,adultCurr,"xpath").getText();
		childCurrV=findEle(driver,childCurr,"xpath").getText();
		//infantCurrV=findEle(driver,infantCurr,"xpath").getText();
		

		// findEle(driver,adultNew+":nth-of-type(2)","cssselector").click();
		// findEle(driver,childNew+":nth-of-type(2)","cssselector").click();
		// findEle(driver,infantNew+":nth-of-type(2)","cssselector").click();

		
		adultNewV=findEle(driver,"("+adultCurr+")[2]","xpath").getText();
		childNewV=findEle(driver,"("+childCurr+")[2]","xpath").getText();
		//infantNewV=findEle(driver,"("+infantCurr+")[2]","xpath").getText();

		System.out.println(adultCurrV+"\t"+childCurrV+"\t"+infantCurrV+"\t"+adultNewV+"\t"+childNewV+"\t"+infantNewV);
		statusV=findEle(driver, status ,"xpath").getText();
		approverRemarksV=findEle(driver, approverRemarks ,"xpath").getText();
		 /*
		findEle(driver,userRemark,"name").sendKeys("Down Size Test");
		findEle(driver,approveReqBtn,"xpath").click();
		
		waitExplicitlyByLocator(driver,conformMsg,"xpath",30);	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		findEle(driver,suceedYes,"xpath").click();


		
		waitExplicitlyByLocator(driver,suceedMsg,"xpath",30);		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,suceedOk,"xpath").click();

			*/ 
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

	

