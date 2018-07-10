package ScootGeneral.ScootGeneralFlow;



import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

 















import pack.base.ReadRequestorType;
import pack.base.ReadTravelAgent;
import pack.base.TestBaseSetup;

public class AdhocOneWayCancelPolicy extends TestBaseSetup {
	
protected WebDriver driver;

//String requestWindowFirst="requestDetailsGrid";
String newBooking="New booking";
String adhocRequest="Adhoc group request";
String selectUserBy="select[id='usertype']";
String userValue="corporateId";
String selectTravelAgency="input[id=corporateDetails]"; 
String travelAgencyName="Travel agency ";
String travelAgencyName2="//li/a[text()='";
String selectUser="select[id='userEmailId']";
String agentValue="Travel Agent";
String agentEmail="label[id='userEmail']";
String groupName = "input[id=requestGroupName]";
String oneWayTrip = "label[for='tripType_one'] span";
String origin = "input[id=sourceVal0]";
String destination= "input[id=destinationVal0]";
String departureDateTxt="input[id=travelDateDisplay0]";
String departureDateMonth="select[class=ui-datepicker-month]";
String departureDateYear="select[class=ui-datepicker-year]";
String departureDateday="div[id=ui-datepicker-div]";
String adult="input[id=noOfAdult]";
String child="input[id=noOfChild]";
//String infant="input[id=noOfInfant]";
String expectedFare="input[id=passengerFare]";
//String selectFlight="div[id=searchedFlightDetails10]";
String selectFlight="div[id=searchedFlightDetails";

String groupCategory="select[id=groupCategoryValue]";

String errorMsg="//div[@id='setInfoMessageError']";
String errorMsgOk="/../following-sibling::div/button";
String sucessMsg="//div[@id='setInfoMessage']";



String remarks="textarea[id=remarks]";
String submitButton="input[id=sendRequest]";
String succedMassage="div[id=setInfoMessage]";
String succedMsgOkBtn="button.btn.btnbgthemecolor";
String logOut="a[class=logout]";
String requestID;
String requestor;
String groupNameV,originV,destinationV,adultV,childV,infantV,expectedFareV,groupCategoryV,remarkV;
String paxMinimumError1V,paxMinimumError2V,paxMaxError1V,paxMaxError2V;
String infantMaxErrorV,infantMinimumErrorV;

int noPaxInt; 

String tempSource,tempDest;


private Login login;
Select select=null;
Actions act=null;
WebElement wbEle;	
public AdhocOneWayCancelPolicy(WebDriver driver) {
	this.driver = driver;
}

public void adHocGroupRequest(String org,String dest,String noPax) {
	
	
	login=new Login(driver);
	login.doLogin(1);
	//waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
	
	waitExplicitlyByLocator(driver,newBooking,"linktext",60);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	findEle(driver,newBooking,"linktext").click();	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	findEle(driver,adhocRequest,"linktext").click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ReadRequestorType readRequestor=new ReadRequestorType();	
	requestor=readRequestor.getUserType();
	requestor=requestor.toUpperCase();
	switch(requestor){
	case "AU":{
		System.out.println("Airline User");

	waitExplicitlyByLocator(driver,selectUserBy,"cssselector",20);	
	select=new Select(findEle(driver,selectUserBy,"cssselector"));
	select.selectByValue(userValue);
	
	String code,name;
	ReadTravelAgent readTravelAgent=new ReadTravelAgent();	
	code=readTravelAgent.getIATACode();
	name=readTravelAgent.getTAName();
	findEle(driver,selectTravelAgency,"cssselector").sendKeys(code);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	act=new Actions(driver);
	act.moveToElement( findEle(driver,travelAgencyName2+name+"']","xpath")).click().build().perform();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	select=new Select(findEle(driver,selectUser,"cssselector"));
	//select.selectByVisibleText(agentValue);
		select.selectByIndex(1);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	break;
	case "TA":
		waitExplicitlyByLocator(driver,groupName,"cssselector",120);
		System.out.println("Travel User");		
	break;	
	default:
	System.out.println("Invalid");	
		
	}	
	String grpName=generateFirstName();
	waitExplicitlyByLocator(driver,groupName,"cssselector",60);
	findEle(driver,groupName,"cssselector").sendKeys(grpName);
	groupNameV=findEle(driver,groupName,"cssselector").getAttribute("value");
	


	
	findEle(driver,oneWayTrip,"cssselector").click();
	tempSource=org;
	tempSource=tempSource.substring(tempSource.indexOf("(")+1,tempSource.indexOf(")"));

	System.out.println(tempSource);
	findEle(driver,origin,"cssselector").sendKeys(tempSource);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		 findEle(driver,origin,"cssselector").sendKeys(Keys.ENTER);
	//tempSource=org;
	//tempSource=tempSource.substring(0, tempSource.indexOf("(")-3);
	//findEle(driver,tempSource,"partiallink").click();

	
		originV=findEle(driver,origin,"cssselector").getAttribute("value");
		tempDest=dest;
		tempDest=tempDest.substring(tempDest.indexOf("(")+1, tempDest.indexOf(")"));
		System.out.println(tempDest);
	findEle(driver,destination,"cssselector").sendKeys(tempDest);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 findEle(driver,destination,"cssselector").sendKeys(Keys.ENTER);
//	tempDest=dest;
//	tempDest=tempDest.substring(0, tempDest.indexOf("(")-3);
	
//	findEle(driver,tempDest,"partiallink").click();

	
	destinationV=findEle(driver,destination,"cssselector").getAttribute("value");
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	findEle(driver,departureDateTxt,"cssselector").click();
	Select selectMonth= new Select(driver.findElement(By.cssSelector(departureDateMonth)));
	List<WebElement> options=selectMonth.getOptions();
	if(options.size()<=3 ){
	
		Select selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
		selectYear.selectByIndex(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	selectMonth= new Select(driver.findElement(By.cssSelector(departureDateMonth)));
	}

	selectMonth.selectByIndex(getRandomNumber(1,3));
		
	 WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));  
	 // List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
	  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
	int randomDate=getRandomNumber(1,28);
	String sDate=""+randomDate;  
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  for (WebElement cell: columns){  
	   //Select 13th Date   
	   if (cell.getText().equals(sDate)){  
		   
	   cell.findElement(By.linkText(sDate)).click();  
	   break;  
	   }  
	  }
	  
	  noPaxInt=Integer.parseInt(noPax);

	  paxInput(noPaxInt-1,1,0);
	  
		/*  String noPaxMn,infantVal,sFare;
		  adultVal=""+getRandonmNuber(11,15);
		  findEle(driver,adult,"cssselector").sendKeys(adultVal);
		  adultV=findEle(driver,adult,"cssselector").getAttribute("value");
		  childVal=""+getRandonmNuber(1,4);
		  findEle(driver,child,"cssselector").sendKeys(childVal);
		  childV=findEle(driver,child,"cssselector").getAttribute("value");
		  infantVal=""+getRandonmNuber(1,3);
		  findEle(driver,infant,"cssselector").sendKeys(infantVal);
		  infantV=findEle(driver,infant,"cssselector").getAttribute("value");
		  
		  noPax,String noInfant
		  */
		  String sFare=""+getRandomNumber(90,120); 
		  findEle(driver,expectedFare,"cssselector").sendKeys(sFare);
		  expectedFareV=findEle(driver,expectedFare,"cssselector").getAttribute("value");
		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		  
		  String f1;
		//  f1=""+getRandomNumber(1,3); 
		  f1=""+1; 
			 
	 
			/*	waitExplicitlyByLocator(driver,selectFlight+f1+"0]","cssselector",30);
			findEle(driver,selectFlight+f1+"0]","cssselector").click();
			*/
		  waitExplicitlyByLocator(driver,selectFlight+"_"+f1+"_0]","cssselector",60);
			findEle(driver,selectFlight+"_"+f1+"_0]","cssselector").click();

		  
		  


		 select=new Select(findEle(driver,groupCategory,"cssselector"));
		  
		  select.selectByValue("1");
		  groupCategoryV=select.getFirstSelectedOption().getText();
		 
		  findEle(driver,remarks,"cssselector").sendKeys("Test Booking");
		  remarkV=findEle(driver,remarks,"cssselector").getAttribute("value");
	  
	  
	  
	 

		   

		  List<WebElement> btn1=driver.findElements(By.cssSelector(submitButton));
		  btn1.get(1).sendKeys(Keys.ENTER);
		//  findEle(driver,submitButton,"cssselector").sendKeys(Keys.ENTER);
	  	  
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
	 	
	     
	 	waitExplicitlyByLocator(driver,succedMassage,"cssselector",120);
	     
	     wbEle=findEle(driver,succedMassage,"cssselector");
			
			
			requestID=wbEle.getText();
		      
			
			requestID= requestID.substring(requestID.indexOf("G")).trim();
			System.out.println("Adhoc One Way Groupt Request has been send"+requestID);
			
			 findEle(driver,succedMsgOkBtn,"cssselector").click();	
			 
			 
			 	waitExplicitlyByLocator(driver,logOut,"cssselector",30);
			 	wbEle=findEle(driver,logOut,"cssselector");	
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", wbEle);
			 

			 
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

	

	public void paxInput(int adultVal,int childVal,int infantVal){
		 
		findEle(driver,adult,"cssselector").clear();
		  findEle(driver,adult,"cssselector").sendKeys(""+adultVal);
		  adultV=findEle(driver,adult,"cssselector").getAttribute("value");	
		  findEle(driver,child,"cssselector").clear();
		  findEle(driver,child,"cssselector").sendKeys(""+childVal);
		  childV=findEle(driver,child,"cssselector").getAttribute("value");
		//  findEle(driver,infant,"cssselector").clear();
		//  findEle(driver,infant,"cssselector").sendKeys(""+infantVal);
		//  infantV=findEle(driver,infant,"cssselector").getAttribute("value");
		  
		  
	}

}
