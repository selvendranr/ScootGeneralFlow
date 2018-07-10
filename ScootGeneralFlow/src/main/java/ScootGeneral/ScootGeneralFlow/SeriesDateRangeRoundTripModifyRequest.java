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

public class SeriesDateRangeRoundTripModifyRequest extends TestBaseSetup {
	
protected WebDriver driver;
String newBooking="New booking";
String seriesGroup="Series group request";
String selectUserBy="select[id='usertype']";
String userValue="corporateId";
String selectTravelAgency="input[id=corporateDetails]"; 
String travelAgencyName="Travel agency ";
String travelAgencyName2="//li/a[text()='";
String selectUser="select[id='userEmailId']";
String agentValue="Travel Agent";
String agentEmail="label[id='userEmail']";
//String groupName = "input[id=requestGroupName]";
//String selectCategory="select[id='groupCategoryValue']";

String roundTrip = "label[for='tripType_roundTrip'] a";
String origin = "input[id=sourceVal0]";
String destination= "input[id=destinationVal0]";
String departAdult="input[id=noOfAdult0]";
//String departChild="input[id=noOfChild0]";
//String departInfant="input[id=noOfInfant0]";
String departExpectedFare="input[id=expectedFare0]";
String selectDate="input[id='widgetProceedBtn_0']";

String dateRange="input[id='dateRange0']";
String specificDate="input[id=specificDate]";



String departStart="input[id=startDateDisplay0]";
String departEnd="input[id=endDateDisplay0]";
String dayPreference="input[id='dayPreference0']";
String returnStart="input[id=startDateDisplay1]";
String returnEnd="input[id=endDateDisplay1]";
String datePickerMonth="select[class=ui-datepicker-month]";
String datePickerYear="select[class='ui-datepicker-year']";
String departureDateday="div[id=ui-datepicker-div]";

String proceedBtn="input[id='dateSelectionSubmit0']";
String noOfLagDays="input[id='lagDaysContent']";
String proceedBtn2="input[id='dateSelectionSubmit1']";

String headerFirstSector="//div[@id='dateHeaderValue0']/span";
String headerSecondSector="//div[@id='dateHeaderValue1']/span";
String group1StartDate="input[id='travelDateDisplay1_0']";
String group1EndDate="input[id='travelDateDisplay1_1']";
String group2StartDate="input[id='travelDateDisplay2_0']";
String group2EndDate="input[id='travelDateDisplay2_1']";
String group3StartDate="input[id='travelDateDisplay3_0']";
String group3EndDate="input[id='travelDateDisplay3_1']";

String selectFlight="div[id=searchedFlightDetails";
String createBtn="input[id='widgetProceedBtn_2']";
//String groupCategory="select[id=groupCategoryValue]";

String remarks="textarea[id=remarks]";
String submitButton="#commonRemarksDynamic>div input";
String succedMassage="div[id=setInfoMessage]";
String succedMsgOkBtn="button.btn.btnbgthemecolor";
String logOut="a[class=logout]";
String requestID;
String requestor;
String groupNameV,originV,destinationV,adultV,childV,infantV,expectedFareV,remarkV;
String  departStartV,departEndV;
String headerFirstSectorV,headerSecondSectorV,group1StartDateV,group1EndDateV,group2StartDateV,group2EndDateV,group3StartDateV,group3EndDateV;




private Login login;
private Select select=null;
private Actions act=null;

WebElement wbEle;	
public SeriesDateRangeRoundTripModifyRequest(WebDriver driver) {
	this.driver = driver;
}

public void seriesDateRangeRequest(String filePath,String delemiter) {
	
	login=new Login(driver);
	login.doLogin(1);
	waitExplicitlyByLocator(driver,newBooking,"linktext",60);	
	findEle(driver,newBooking,"linktext").click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	findEle(driver,seriesGroup,"linktext").click();
	
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


	waitExplicitlyByLocator(driver,selectUserBy,"cssselector",60);	
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
		Thread.sleep(2000);
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
	/*
	String grpName=generateFirstName();
	waitExplicitlyByLocator(driver,groupName,"cssselector",20);
	findEle(driver,groupName,"cssselector").sendKeys(grpName);
	groupNameV=findEle(driver,groupName,"cssselector").getAttribute("value");
	select=new Select(findEle(driver,selectCategory,"cssselector"));
	select.selectByValue(""+getRandomNumber(1,12));	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	*/
	SectorGenerator sector=new SectorGenerator();
	String[] sectorDetails=sector.sectorGenerator(filePath, delemiter);
	System.out.println("Length"+sectorDetails.length);

	
	int temp=getRandomNumber(0,(sectorDetails.length)-1);
	
	String org=sectorDetails[temp];
	String dest=sectorDetails[temp+1];

	findEle(driver,roundTrip,"cssselector").click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
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
	
	/*
	  String adultVal,childVal,infantVal,sFare;
	  adultVal=""+getRandomNumber(11,15);
	  findEle(driver,departAdult,"cssselector").sendKeys(adultVal);
	  adultV=findEle(driver,departAdult,"cssselector").getAttribute("value");
	  childVal=""+getRandomNumber(1,4);
	  findEle(driver,departChild,"cssselector").sendKeys(childVal);
	  childV=findEle(driver,departChild,"cssselector").getAttribute("value");
	  infantVal=""+getRandomNumber(1,3);
	  findEle(driver,departInfant,"cssselector").sendKeys(infantVal);
	  infantV=findEle(driver,departInfant,"cssselector").getAttribute("value");
	  */
	  
	  paxInput(getRandomNumber(20,30),getRandomNumber(1,5),getRandomNumber(1,3));
		
	  
	  
	  String sFare=""+getRandomNumber(100,120); 
	  findEle(driver,departExpectedFare,"cssselector").sendKeys(sFare);
	  expectedFareV=findEle(driver,departExpectedFare,"cssselector").getAttribute("value");
	
	  findEle(driver,selectDate,"cssselector").click();
	  
	  
	  waitExplicitlyByLocator(driver,dateRange,"cssselector",60);		
	  findEle(driver,dateRange,"cssselector").sendKeys(Keys.SPACE);
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	  
	  findEle(driver,departStart,"cssselector").click();
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Select selectMonth= new Select(driver.findElement(By.cssSelector(datePickerMonth)));
		List<WebElement> options=selectMonth.getOptions();
		if(options.size()<=3 ){
		
			Select selectYear= new Select(driver.findElement(By.cssSelector(datePickerYear)));
			selectYear.selectByIndex(1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		selectMonth= new Select(driver.findElement(By.cssSelector(datePickerMonth)));
		}

		selectMonth.selectByIndex(getRandomNumber(1,3));	
	
	 WebElement dateWidget = findEle(driver,departureDateday,"cssselector");  
	 // List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
	  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
	int randomDate=getRandomNumber(1,10);
	String sDate=""+randomDate;  
	 
	  for (WebElement cell: columns){  
	   //Select 13th Date   
	   if (cell.getText().equals(sDate)){  
		   
	   cell.findElement(By.linkText(sDate)).click();  
	   break;  
	   }  
	  }
	  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	  departStartV=findEle(driver,departStart,"cssselector").getAttribute("value");
	 
	  findEle(driver,departEnd,"cssselector").click();
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		//selectMonth= new Select(findEle(driver,datePickerMonth,"cssselector"));
		
		//selectMonth.selectByIndex(getRandMonth);
		
		
		 dateWidget = findEle(driver,departureDateday,"cssselector");  
		 // List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		 columns=dateWidget.findElements(By.tagName("td"));  
		 randomDate=randomDate+4;
		sDate=""+randomDate;  
		 
		  for (WebElement cell: columns){  
		   //Select 13th Date   
		   if (cell.getText().equals(sDate)){  
			   
		   cell.findElement(By.linkText(sDate)).click();  
		   break;  
		   }  
		  }
		  departEndV=findEle(driver,departEnd,"cssselector").getAttribute("value");  
		  
		 findEle(driver,proceedBtn,"cssselector").click();
		  
		waitExplicitlyByLocator(driver,noOfLagDays,"cssselector",30);
		  
		 findEle(driver,noOfLagDays,"cssselector").sendKeys(""+3);
			
		 findEle(driver,noOfLagDays,"cssselector").sendKeys(Keys.ENTER);
		
		 
		 headerFirstSectorV= findEle(driver,headerFirstSector,"xpath").getText();
		 waitExplicitlyByLocator(driver,headerSecondSector,"xpath",10);		 
		 headerSecondSectorV= findEle(driver,headerSecondSector,"xpath").getText();
		 
		 group1StartDateV= findEle(driver,group1StartDate,"cssselector").getAttribute("value");
		 waitExplicitlyByLocator(driver,group1EndDate,"cssselector",10);		 
		 group1EndDateV= findEle(driver,group1EndDate,"cssselector").getAttribute("value");
	
		 group2StartDateV= findEle(driver,group2StartDate,"cssselector").getAttribute("value");
		 group2EndDateV= findEle(driver,group2EndDate,"cssselector").getAttribute("value");
	 
		 group3StartDateV= findEle(driver,group3StartDate,"cssselector").getAttribute("value");
		 group3EndDateV= findEle(driver,group3EndDate,"cssselector").getAttribute("value");
		 
		 findEle(driver,proceedBtn2,"cssselector").click();
		 
		 

		  String f1,f2;
		  f1=""+getRandomNumber(1,3); 
		  f2=""+getRandomNumber(1,3); 
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

			
			 findEle(driver,createBtn,"cssselector").click();	
			 try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
			 waitExplicitlyByLocator(driver,remarks,"cssselector",30);	
	    	 findEle(driver,remarks,"cssselector").sendKeys("Test Booking");
	    	 
	    	 remarkV=findEle(driver,remarks,"cssselector").getAttribute("value");    
	         
	    	 findEle(driver,submitButton,"cssselector").sendKeys(Keys.ENTER);
	    	 try {
	    			Thread.sleep(5000);
	    		} catch (InterruptedException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	 
	    	 waitExplicitlyByLocator(driver,succedMassage,"cssselector",100); 	
	    		     
	    wbEle=findEle(driver,succedMassage,"cssselector");
	    				
	    				
	   requestID=wbEle.getText();
	    			      
	    				
	    requestID= requestID.substring(requestID.indexOf("G")).trim();
	    System.out.println("Adhoc One Way Groupt Request has been send"+requestID);
	    				
	    	findEle(driver,succedMsgOkBtn,"cssselector").click();	
	    	 waitExplicitlyByLocator(driver,logOut,"cssselector",20); 		 
			 wbEle=findEle(driver,logOut,"cssselector");	
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", wbEle);
			 
			 
			 
}
	

public void paxInput(int adultVal,int childVal,int infantVal){
	 
	findEle(driver,departAdult,"cssselector").clear();
	  findEle(driver,departAdult,"cssselector").sendKeys(""+adultVal);
	  adultV=findEle(driver,departAdult,"cssselector").getAttribute("value");	
	/*  findEle(driver,departChild,"cssselector").clear();
	  findEle(driver,departChild,"cssselector").sendKeys(""+childVal);
	  childV=findEle(driver,departChild,"cssselector").getAttribute("value");
	  */
	  //findEle(driver,departInfant,"cssselector").clear();
	//  findEle(driver,departInfant,"cssselector").sendKeys(""+infantVal);
	 // infantV=findEle(driver,departInfant,"cssselector").getAttribute("value");
	  
	  
}


	

}
