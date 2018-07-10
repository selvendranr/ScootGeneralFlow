package ScootGeneral.ScootGeneralFlow;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pack.base.ReadRequestorType;
import pack.base.ReadTravelAgent;
import pack.base.SectorGenerator;
import pack.base.TestBaseSetup;

public class AdhocRoundTripModifyRequest extends TestBaseSetup {
	
protected WebDriver driver;
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
//String groupName = "input[id=requestGroupName]";


String roundTrip = "label[for=tripType_two] a";
String origin = "input[id=sourceVal0]";
String destination= "input[id=destinationVal0]";
String departureDateTxt="input[id=travelDateDisplay0]";
String returnDateTxt="input[id=travelDateDisplay1]";
String departureDateMonth="select[class=ui-datepicker-month]";
String departureDateYear="select[class=ui-datepicker-year]";
String departureDateday="div[id=ui-datepicker-div]";

String adult="input[id=noOfAdult]";
//String child="input[id=noOfChild]";
//String infant="input[id=noOfInfant]";
String expectedFare="input[id=passengerFare]";
String selectFlight="div[id=searchedFlightDetails";
//String groupCategory="select[id=groupCategoryValue]";

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



Select select=null;
Actions act=null;
private Login login;

WebElement wbEle;	
public AdhocRoundTripModifyRequest(WebDriver driver) {
	this.driver = driver;
}

public void adHocGroupRequest(String filePath,String delemiter) {
	
	login=new Login(driver);
	login.doLogin(1);
	
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
	waitExplicitlyByLocator(driver,roundTrip,"cssselector",120);
	System.out.println("Travel User");		
break;	
default:
System.out.println("Invalid");	
	
}
	/*String grpName=generateFirstName();
	waitExplicitlyByLocator(driver,roundTrip,"cssselector",60);
	findEle(driver,groupName,"cssselector").sendKeys(grpName);
	groupNameV=findEle(driver,groupName,"cssselector").getAttribute("value");
	*/
	SectorGenerator sector=new SectorGenerator();
	String[] sectorDetails=sector.sectorGenerator(filePath, delemiter);
	System.out.println("Length"+sectorDetails.length);

	
	int temp=getRandomNumber(0,(sectorDetails.length)-1);
	
	String org=sectorDetails[temp];
	String dest=sectorDetails[temp+1];


	findEle(driver,roundTrip,"cssselector").click();
	findEle(driver,origin,"cssselector").sendKeys(org);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		findEle(driver,origin,"cssselector").sendKeys(Keys.ENTER);
		originV=findEle(driver,origin,"cssselector").getAttribute("value");
		
		findEle(driver,destination,"cssselector").sendKeys(dest);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	findEle(driver,destination,"cssselector").sendKeys(Keys.ENTER);
	destinationV=findEle(driver,destination,"cssselector").getAttribute("value");
	
	findEle(driver,departureDateTxt,"cssselector").click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	waitExplicitlyByLocator(driver,departureDateMonth,"cssselector",30);
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
			
	 WebElement dateWidget = findEle(driver,departureDateday,"cssselector"); 
	 // List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
	  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
	int randomDate=getRandomNumber(1,25);
	String sDate=""+randomDate;  
	 
	  for (WebElement cell: columns){  
	   //Select 13th Date   
	   if (cell.getText().equals(sDate)){  
		   
	   cell.findElement(By.linkText(sDate)).click();  
	   break;  
	   }  
	  }
	  
		findEle(driver,returnDateTxt,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waitExplicitlyByLocator(driver,departureDateMonth,"cssselector",30);


		selectMonth= new Select(findEle(driver,departureDateMonth,"cssselector"));
		//month=1;
		
		//selectMonth.selectByIndex(month);
		
		
			dateWidget = findEle(driver,departureDateday,"cssselector"); 
		 columns=dateWidget.findElements(By.tagName("td"));  
		 randomDate=randomDate+2;//getRandonmNuber(1,28);
		sDate=""+randomDate;  
		 
		  for (WebElement cell: columns){  
		   //Select 13th Date   
		   if (cell.getText().equals(sDate)){  
			   
		   cell.findElement(By.linkText(sDate)).click();  
		   break;  
		   }  
		  }
		  
		  
		  paxInput(getRandomNumber(11,19),getRandomNumber(1,5),getRandomNumber(1,3));
		
		  
		  /*
		  String adultVal,childVal,infantVal,sFare;
		  adultVal=""+getRandonmNuber(11,15);
		  findEle(driver,adult,"cssselector").sendKeys(adultVal);
		  adultV=findEle(driver,adult,"cssselector").getAttribute("value");
		  childVal=""+getRandonmNuber(1,4);
		  findEle(driver,child,"cssselector").sendKeys(childVal);
		  childV=findEle(driver,child,"cssselector").getAttribute("value");
		  infantVal=""+getRandonmNuber(1,3);
		  findEle(driver,infant,"cssselector").sendKeys(infantVal);
		  infantV=findEle(driver,infant,"cssselector").getAttribute("value");
		  
		  */
		  String  sFare=""+getRandomNumber(100,120);  
		  
		  findEle(driver,expectedFare,"cssselector").sendKeys(sFare);
		  expectedFareV=findEle(driver,expectedFare,"cssselector").getAttribute("value");
		  try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

		  String f1,f2;
		//  f1=""+getRandomNumber(1,3); 
		//  f2=""+getRandomNumber(1,3); 
		  
		  f1=""+1; 
		  f2=""+1; 
	  
		  
		  
		  
		/*	waitExplicitlyByLocator(driver,selectFlight+f1+"0]","cssselector",30);

			findEle(driver,selectFlight+f1+"0]","cssselector").click();
			waitExplicitlyByLocator(driver,selectFlight+f2+"1]","cssselector",30);

			findEle(driver,selectFlight+f2+"1]","cssselector").click();
			*/
		  waitExplicitlyByLocator(driver,selectFlight+"_"+f1+"_0]","cssselector",30);

			findEle(driver,selectFlight+"_"+f1+"_0]","cssselector").click();
			waitExplicitlyByLocator(driver,selectFlight+"_"+f2+"_1]","cssselector",30);

			findEle(driver,selectFlight+"_"+f2+"_1]","cssselector").click();
		/*	
		  Select select=new Select(findEle(driver,groupCategory,"cssselector"));
		  
		  select.selectByValue("1");
		  groupCategoryV=select.getFirstSelectedOption().getText();
		 */

		  findEle(driver,remarks,"cssselector").sendKeys("Test Booking");
		  remarkV=findEle(driver,remarks,"cssselector").getAttribute("value");
		 

		 // List<WebElement> btn1=driver.findElements(By.cssSelector(submitButton));
		 // btn1.get(1).sendKeys(Keys.ENTER);
		  findEle(driver,submitButton,"cssselector").sendKeys(Keys.ENTER);
	  
	     try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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

public void paxInput(int adultVal,int childVal,int infantVal){
	 
	findEle(driver,adult,"cssselector").clear();
	  findEle(driver,adult,"cssselector").sendKeys(""+adultVal);
	  adultV=findEle(driver,adult,"cssselector").getAttribute("value");	
	  //findEle(driver,child,"cssselector").clear();
	 // findEle(driver,child,"cssselector").sendKeys(""+childVal);
	 // childV=findEle(driver,child,"cssselector").getAttribute("value");
	 // findEle(driver,infant,"cssselector").clear();
	 // findEle(driver,infant,"cssselector").sendKeys(""+infantVal);
	 // infantV=findEle(driver,infant,"cssselector").getAttribute("value");
	  
	  
}

	  
}
	