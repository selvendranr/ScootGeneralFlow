package ScootGeneral.ScootGeneralFlow;



import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

 


















import pack.base.ReadRequestorType;
import pack.base.ReadTravelAgent;
import pack.base.ReportFormat;
import pack.base.SectorGenerator;
import pack.base.TestBaseSetup;

public class AdhocOneWayRequest extends TestBaseSetup {
	
protected WebDriver driver;


String newBooking="a[title='New booking']";
String adhocGrp="li[class='adhocRequest']>a";
String selectUserBy="select[id='usertype']";
String userValue="corporateId";
String selectTravelAgency="input[id=corporateDetails]"; 
String travelAgencyName="Travel agency ";
String travelAgencyName2="//li/a[text()='";
String selectUser="select[id='userEmailId']";
String agentValue="Travel Agent";
String agentEmail="label[id='userEmail']";
//String groupName = "input[id=requestGroupName]";
String oneWayTrip = "label[for='tripType_one'] a";
String origin = "input[id=sourceVal0]";
String destination= "input[id=destinationVal0]";
String departureDateTxt="input[id=travelDateDisplay0]";
String departureDateMonth="select[class=ui-datepicker-month]";
String departureDateYear="select[class=ui-datepicker-year]";
String departureDateday="div[id=ui-datepicker-div]";
String adult="input[id=noOfAdult]";
String child="input[id=noOfChild]";
String infant="input[id=noOfInfant]";
String expectedFare="input[id=passengerFare]";
String processing="//span[text()='Loading data, please wait...']";
String loadingImg="img[title='Loading...']";


String selectFlight="div[id=searchedFlightDetails";


String groupCategory="select[id=groupCategoryValue]";


String sucessMsg="//div[@id='setInfoMessage']";



String remarks="textarea[id=remarks]";
String submitButton="input[id=sendRequest]";
String succedMassage="div[id=setInfoMessage]";
String succedMsgOkBtn="button.btn.btnbgthemecolor";
String logOut="a[class=logout]";
String requestID;
String requestor;
String originV,destinationV,adultV,childV,infantV,expectedFareV,groupCategoryV,remarkV;

private Login login;
Select select=null;
Actions act=null;
WebElement wbEle;	



public AdhocOneWayRequest(WebDriver driver) {
	this.driver = driver;
}

public void adHocGroupRequest(String filePath,String delemiter) {
	
	login=new Login(driver);
	login.doLogin(1);
	waitExplicitlyByLocator(driver,newBooking,"cssselector",60);
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	findEle(driver,newBooking,"cssselector").click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	findEle(driver,adhocGrp,"cssselector").click();
	
	try{
		 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
	 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
	 	 	}
	 	catch(TimeoutException e){
	 		System.out.println("After Logout Processing is not displayed");
	 	}
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
		waitExplicitlyByLocator(driver,oneWayTrip,"cssselector",120);
		System.out.println("Travel User");		
	break;	
	default:
	System.out.println("Invalid");	
		
	}
	/*String grpName=generateFirstName();
	waitExplicitlyByLocator(driver,groupName,"cssselector",60);
	findEle(driver,groupName,"cssselector").sendKeys(grpName);
	groupNameV=findEle(driver,groupName,"cssselector").getAttribute("value");
	*/
	SectorGenerator sector=new SectorGenerator();
	String[] sectorDetails=sector.sectorGenerator(filePath, delemiter);
	System.out.println("Length"+sectorDetails.length);	
	int temp=getRandomNumber(0,(sectorDetails.length)-1);	
	String org=sectorDetails[temp];
	String dest=sectorDetails[temp+1];
	findEle(driver,oneWayTrip,"cssselector").click();

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
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	Select selectMonth= new Select(driver.findElement(By.cssSelector(departureDateMonth)));
	 		List<WebElement> options=selectMonth.getOptions();
		System.out.println(options.size());
	 
	
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
 	  waitExplicitlyByLocator(driver,selectFlight+"_"+1+"_0]","cssselector",60);
 	  paxInput(getRandomNumber(30,35),getRandomNumber(1,5),getRandomNumber(1,3));
	  
	  
	  
	  
	 
	  
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
	  String sFare=""+getRandomNumber(10,20); 
	  findEle(driver,expectedFare,"cssselector").sendKeys(sFare);
	  expectedFareV=findEle(driver,expectedFare,"cssselector").getAttribute("value");
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	  
	  String f1;
	 // f1=""+getRandomNumber(1,3); 
	  f1=""+1; 
 
		/*	waitExplicitlyByLocator(driver,selectFlight+f1+"0]","cssselector",30);
		findEle(driver,selectFlight+f1+"0]","cssselector").click();
		*/
	  waitExplicitlyByLocator(driver,selectFlight+"_"+f1+"_0]","cssselector",60);
		findEle(driver,selectFlight+"_"+f1+"_0]","cssselector").click();

	  
	  
		/*

	 select=new Select(findEle(driver,groupCategory,"cssselector"));
	  
	  select.selectByValue("1");
	  groupCategoryV=select.getFirstSelectedOption().getText();
	 */
	  findEle(driver,remarks,"cssselector").sendKeys("Test Booking");
	  remarkV=findEle(driver,remarks,"cssselector").getAttribute("value");
		 // List<WebElement> btn=driver.findElements(By.cssSelector(submitButton));
		 // btn.get(1).sendKeys(Keys.ENTER);
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
		/*  findEle(driver,child,"cssselector").clear();
		  findEle(driver,child,"cssselector").sendKeys(""+childVal);
		  childV=findEle(driver,child,"cssselector").getAttribute("value");
		  findEle(driver,infant,"cssselector").clear();
		  findEle(driver,infant,"cssselector").sendKeys(""+infantVal);
		  infantV=findEle(driver,infant,"cssselector").getAttribute("value");
		*/  
		  
	}


}
