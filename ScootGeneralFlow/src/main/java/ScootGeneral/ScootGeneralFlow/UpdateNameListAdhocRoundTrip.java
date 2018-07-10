package ScootGeneral.ScootGeneralFlow;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class UpdateNameListAdhocRoundTrip extends TestBaseSetup {
	
protected WebDriver driver;
	String requestInfo="a[title='Request info']";
	String addGuest="li[class='addPassengerUser']>a";	//link Text	

	String groupId="input[id=requestMasterId][name=requestMasterId]";
	
	String searchBtn = "a.btn.custom-btn.mar-top-30";
	//Search
	String viewDetails1="//td/p[text()[contains(.,'";
	String viewDetails2="')]]/../../td[7]/a[contains(text(),'Guest details')]";
		
		//-----------------PNR  Details------------------------------//	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	String requestDetails="div[class='request-det-cont']>div:first-of-type";
	String groupIdInPnr="div[class='request-det-cont']>div:nth-of-type(2) tr:nth-of-type(2)>td:nth-of-type(2)";
	String reqTypeInPnr="div[class='request-det-cont']>div:nth-of-type(2) tr:nth-of-type(2)>td:first-of-type>span";
	String reqDateInPnr="div[class='request-det-cont']>div:nth-of-type(2) tr:nth-of-type(2)>td:nth-of-type(2)";
	String reqStatusInPnr="div[class='request-det-cont']>div:nth-of-type(2) tr:nth-of-type(2)>td:nth-of-type(3)";
	String requestorInPnr="div[class='request-det-cont']>div:nth-of-type(2) tr:nth-of-type(2)>td:nth-of-type(4)";
	
	//-----------------Booking Details On PNR details --------------------------//

	String nameListLink="a[id='displaySector_0']";
	
	
	//-----------------Flight Details------------------------------//		
	String groupID="div[class=approved-flight-hdr]+div table tbody tr:last-of-type td:first-of-type span";
	String noOfGust="div[class=approved-flight-hdr]+div table tbody tr:last-of-type td:nth-of-type(2)";
	String paymentStatus="div[class=approved-flight-hdr]+div table tbody tr:last-of-type td:nth-of-type(3) p";
	String firstFlightNo="div[class=approved-flight-hdr]+p+div table tbody tr:last-of-type td:first-of-type p";
	String firstDepart="div[class=approved-flight-hdr]+p+div table tbody tr:last-of-type td:nth-of-type(2) p";
	String firstArrival="div[class=approved-flight-hdr]+p+div table tbody tr:last-of-type td:nth-of-type(3) p";
	String fristNoOfGuest="div[class=approved-flight-hdr]+p+div table tbody tr:last-of-type td:nth-of-type(4)";
	String addGuestList="I wish to enter guest details";
	String adultFirstNam="input[id=adultFirstName";
	String adultLastNam="input[id=adultLastName";
	String adultDOB="input[id=adultDobDisplay";
	String adultTravelerNo="input[id=adultTravellerNo";
	String adultFrequentNo="input[id=adultFlyerNo";
	String childFirstNam="input[id=childFirstName";
	String childLastNam="input[id=childLastName";
	String childDOB="input[id=childDobDisplay";
	String childTravelerNo="input[id=childTravellerNo";
	String childFrequentNo="input[id=childFlyerNo";
	String infantFirstNam="input[id=infantFirstName";
	String infantLastNam="input[id=infantLastName";
	String infantDOB="input[id=infantDobDisplay";
	
	String departureDateMonth="select[class=ui-datepicker-month]";
	String departureDateYear="select[class=ui-datepicker-year]";
	
	String savePaxDetails="input[id=sendPassengerDetails]";
	
	//-----------------Payment details------------------------------//
	String succedMassage="div[id=setInfoMessage]";
	String succedMsgOkBtn="button.btn.btnbgthemecolor";
	String logOut="a[class=logout]";
	

	
	String groupIdInPnrV,reqTypeInPnrV,reqDateInPnrV,reqStatusInPnrV,requestorInPnrV;
	String flightDetails1V,noOfGuestInPnrV,pnrNoInPnrV;
	String groupIDV,noOfGustV,paymentStatusV;
	String firstFlightNoV,firstDepartV,firstArrivalV,firstNoOfGuestV;
	String source1,dest1,departureDate1,flightNo1;
	
	StopWatch processingTime = new StopWatch();	
	double pageLoadTimeV,guestSubmitTimeV;

	private Login login;
	private WebElement webEle;
	Select select;
	public UpdateNameListAdhocRoundTrip(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addNameList(String reqId) {
		driver.navigate().refresh();
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

			waitExplicitlyByLocator(driver,addGuest,"cssselector",30);				
				findEle(driver,addGuest,"cssselector").click();
				try{
					 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
					 processingTime.start();
					  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
					  processingTime.stop();
					  pageLoadTimeV=pageLoadTimeV+processingTime.getTime();
					  processingTime.reset();	
				 	}
				 	catch(TimeoutException e){
				 		System.out.println("After Munu Click Processing is not displayed");
				 	}
		
				String onlyNo=reqId.replaceAll("[^\\.0123456789]","");
				findEle(driver,groupId,"cssselector").sendKeys(onlyNo);
				
				waitExplicitlyByLocator(driver,searchBtn,"cssselector",30);
				 
				 findEle(driver,searchBtn,"cssselector").click();
				
					try{
						 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
						 processingTime.start();
						  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
						  processingTime.stop();
						  pageLoadTimeV=pageLoadTimeV+processingTime.getTime();
						  processingTime.reset();	
					 	}
					 	catch(TimeoutException e){
					 		System.out.println("After Search  Processing is not displayed");
					 	}
			
	
			waitExplicitlyByLocator(driver,viewDetails1+reqId+viewDetails2,"xpath",30);
			findEle(driver,viewDetails1+reqId+viewDetails2,"xpath").click();
		
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
				 processingTime.start();
				  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
				  processingTime.stop();
				  pageLoadTimeV=pageLoadTimeV+processingTime.getTime();
				  processingTime.reset();	
			 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Make Payment Link Processing  is not displayed");
			 	}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				waitExplicitlyByLocator(driver,requestDetails,"cssselector",60);
	 
		//---------------------Get the values of Request Details-----------------------------//
			 	groupIdInPnrV=findEle(driver,groupIdInPnr,"cssselector").getText();
		//	 	groupNameInPnrV=findEle(driver,groupNameInPnr,"cssselector").getText();
			 	reqDateInPnrV=findEle(driver,reqDateInPnr,"cssselector").getText();
			 	reqStatusInPnrV=findEle(driver,reqStatusInPnr,"cssselector").getText();	
			 requestorInPnrV=findEle(driver,requestorInPnr,"cssselector").getText();
			 	
		

		

				 findEle(driver,nameListLink,"cssselector").click();
					try{
						 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
						 processingTime.start();
						  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
						  processingTime.stop();
						  pageLoadTimeV=pageLoadTimeV+processingTime.getTime();
						  processingTime.reset();	
					 	}
					 	catch(TimeoutException e){
					 		System.out.println("Add Guest Link Processing  is not displayed");
					 	}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					 waitExplicitlyByLocator(driver,groupID,"cssselector",50);					 
				groupIDV=findEle(driver,groupID,"cssselector").getText();
				noOfGustV=findEle(driver,noOfGust,"cssselector").getText();
				noOfGustV=noOfGustV.substring(noOfGustV.indexOf(":")+1, noOfGustV.indexOf(")")+1);
				paymentStatusV=findEle(driver,paymentStatus,"cssselector").getText();
				firstFlightNoV=findEle(driver,firstFlightNo,"cssselector").getText();
				firstDepartV=findEle(driver,firstDepart,"cssselector").getText();
				//getscreenshot(driver);
				firstArrivalV=findEle(driver,firstArrival,"cssselector").getText();
				//firstNoOfGuestV=findEle(driver,fristNoOfGuest,"cssselector").getText();
				firstNoOfGuestV=noOfGustV;
				
				findEle(driver,addGuestList,"linktext").click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 waitExplicitlyByLocator(driver,adultFirstNam+"1]","cssselector",50);		


				int noAdult,noInfant;
				
				noAdult=Integer.parseInt((firstNoOfGuestV.substring(firstNoOfGuestV.indexOf("(")+1,firstNoOfGuestV.indexOf("A"))).replaceAll("\\s+", ""));

				noInfant=Integer.parseInt((firstNoOfGuestV.substring(firstNoOfGuestV.lastIndexOf(",")+1, firstNoOfGuestV.indexOf("I"))).replaceAll("\\s+", ""));
				Select selectYear;
				Select selectMonth;
				 WebElement dateWidget;
				 List<WebElement> columns;
				 int randomDate;
				 String sDate;
				for(int i=1;i<=noAdult;i++)
				{
					findEle(driver,adultFirstNam+i+"]","cssselector").sendKeys(generateFirstName());
					findEle(driver,adultLastNam+i+"]","cssselector").sendKeys(generateLastName());
					findEle(driver,adultDOB+i+"]","cssselector").click();
					 
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
					
					selectYear.selectByVisibleText(""+getRandomNumber(1995,2000));
					
					
					selectMonth= new Select(driver.findElement(By.cssSelector(departureDateMonth)));
					
					selectMonth.selectByIndex(getRandomNumber(1,11));
					
					
					dateWidget = driver.findElement(By.id("ui-datepicker-div"));  
					 // List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
					 columns=dateWidget.findElements(By.tagName("td"));  
					 randomDate=getRandomNumber(1,28);
					 sDate=""+randomDate;  
					 
					  for (WebElement cell: columns){  
					   //Select 13th Date   
					   if (cell.getText().equals(sDate)){  
						   
					   cell.findElement(By.linkText(sDate)).click();  
					   break;  
					   }  
					  }
				findEle(driver,adultTravelerNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000));	
			//	findEle(driver,adultFrequentNo+i+"]","cssselector").sendKeys(""+getRandonmNuber(1000000000,2000000000)+"000");	
					
					
				}
				


				for(int i=1;i<=noInfant;i++)
				{
					findEle(driver,infantFirstNam+i+"]","cssselector").sendKeys(generateFirstName());
					findEle(driver,infantLastNam+i+"]","cssselector").sendKeys(generateLastName());
					findEle(driver,infantDOB+i+"]","cssselector").click();
					 
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
					
					selectYear.selectByVisibleText(""+2015);
					
					
					selectMonth= new Select(driver.findElement(By.cssSelector(departureDateMonth)));
					
					selectMonth.selectByIndex(getRandomNumber(7,11));
					
					
					dateWidget = driver.findElement(By.id("ui-datepicker-div"));  
					 // List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
					 columns=dateWidget.findElements(By.tagName("td"));  
					 randomDate=getRandomNumber(1,28);
					 sDate=""+randomDate;  
					 
					  for (WebElement cell: columns){  
					   //Select 13th Date   
					   if (cell.getText().equals(sDate)){  
						   
					   cell.findElement(By.linkText(sDate)).click();  
					   break;  
					   }  
					  }
							
					
				}
				
		
	 
				findEle(driver,savePaxDetails,"cssselector").sendKeys(Keys.ENTER);
	
				try{
					 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
					 processingTime.start();
					  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",500);
					  processingTime.stop();
					  guestSubmitTimeV=guestSubmitTimeV+processingTime.getTime();
					  processingTime.reset();	
				 	}
				 	catch(TimeoutException e){
				 		System.out.println("After Search  Processing is not displayed");
				 	}	 
			
	 waitExplicitlyByLocator(driver,succedMassage,"cssselector",50);		
		

		webEle=findEle(driver,succedMassage,"cssselector");
		System.out.println(webEle.getText());
		 waitExplicitlyByLocator(driver,succedMsgOkBtn,"cssselector",50);
		 findEle(driver,succedMsgOkBtn,"cssselector").click();	
		 waitExplicitlyByLocator(driver,logOut,"cssselector",50);

		 webEle=findEle(driver,logOut,"cssselector");	
				 JavascriptExecutor js=(JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", webEle);
			
	

}

	
}
