package ScootGeneral.ScootGeneralFlow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.Age;
import pack.base.TestBaseSetup;

public class UpdateNameListAdhocOneWay extends TestBaseSetup {
	
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
	String groupID="//a[text()='PNR details']/../preceding-sibling::div[1]//tr[2]/td[1]/span";
 	String noOfGust="//a[text()='PNR details']/../preceding-sibling::div[1]//tr[2]/td[2]";
	String paymentStatus="//a[text()='PNR details']/../preceding-sibling::div[1]//tr[2]/td[3]";
	String firstFlightNo="//a[text()='PNR details']/../following-sibling::div[1]//tr[2]/td[1]";
	String firstDepart="//a[text()='PNR details']/../following-sibling::div[1]//tr[2]/td[2]";
	String firstArrival="//a[text()='PNR details']/../following-sibling::div[1]//tr[2]/td[3]";
	String fristNoOfGuest="//a[text()='PNR details']/../following-sibling::div[1]//tr[2]/td[4]";
	String addGuestList="passengerDetailsView";
	String adultFirstNam="input[id=adultFirstName";
	//String adultMiddleNam="input[id=adultMiddleName";
	String adultLastNam="input[id=adultLastName";
	String adultDOB="input[id=adultDobDisplay";
	//String adultAge="input[id=adultAge";
	String adultCitizen="select[id=adultCitizenship";
	String adultPass="input[id=adultPassportNo";
	String adultIssueDate="input[id=adultIssueDateDisplay";
	String adultExpDate="input[id=adultExpiryDateDisplay";
	//String adultEmail="input[id=adultEmailId";
	//String adultMobileNo="input[id=adultMobileNo";	
	//String adultTravelerNo="input[id=adultTravellerNo";
	//String adultFrequentNo="input[id=adultFlyerNo";
	
	
	String childFirstNam="input[id=childFirstName";
	//String childMiddleNam="input[id=childMiddleName";
	String childLastNam="input[id=childLastName";
	String childDOB="input[id=childDobDisplay";
	//String childAge="input[id=childAge";
	String childCitizen="select[id=childCitizenship";
	String childPass="input[id=childPassportNo";
	String childIssueDate="input[id=childIssueDateDisplay";
	String childExpDate="input[id=childExpiryDateDisplay";
	//String childEmail="input[id=childEmailId";
	//String childMobileNo="input[id=childMobileNo";	
	//String childTravelerNo="input[id=childTravellerNo";
	//String childFrequentNo="input[id=childFlyerNo";



	String infantFirstNam="input[id=infantFirstName";
	String infantMiddleNam="input[id=infantMiddleName";
	String infantLastNam="input[id=infantLastName";
	String infantDOB="input[id=infantDobDisplay";	
	String infantAge="input[id=infantAge";
	String infantCitizen="select[id=infantCitizenship";
	String infantPass="input[id=infantPassportNo";
	String infantIssueDate="input[id=infantIssueDateDisplay";
	String infantExpDate="input[id=infantExpiryDateDisplay";
	String infantEmail="input[id=infantEmailId";
	String infantMobileNo="input[id=infantMobileNo";	
	

	
	
	String departureDateMonth="select[class=ui-datepicker-month]";
	String departureDateYear="select[class=ui-datepicker-year]";
	
	String savePaxDetails="input[id=sendPassengerDetails]";
	
	//-----------------Payment details------------------------------//
	String succedMassage="div[id=setInfoMessage]";
	String succedMsgOkBtn="button.btn.btnbgthemecolor";
	String logOut="a[class=logout]";
	
	 
	 

	
	String groupIdInPnrV,groupNameInPnrV,reqTypeInPnrV,reqDateInPnrV,reqStatusInPnrV,requestorInPnrV;
	String flightDetails1V,noOfGuestInPnrV,pnrNoInPnrV;
	String groupIDV,noOfGustV,paymentStatusV;
	String firstFlightNoV,firstDepartV,firstArrivalV,firstNoOfGuestV;
	String source1,dest1,departureDate1,flightNo1;
	
	StopWatch processingTime = new StopWatch();	
	double pageLoadTimeV,guestSubmitTimeV;
	 int noAdult,noChild,noInfant;

	private Login login;
	private WebElement webEle;
	Select select;
	public UpdateNameListAdhocOneWay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addNameList(String reqId) {
		//driver.navigate().refresh();	

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
				waitExplicitlyNotByLocator(driver,requestDetails,"linktext",60);
	 
		//---------------------Get the values of Request Details-----------------------------//
			//	groupIdInPnrV=findEle(driver,groupIdInPnr,"xpath").getText();
			//	groupNameInPnrV=findEle(driver,groupNameInPnr,"xpath").getText();
			//	reqDateInPnrV=findEle(driver,reqDateInPnr,"xpath").getText();
			//	reqStatusInPnrV=findEle(driver,reqStatusInPnr,"xpath").getText();	
			//	requestorInPnrV=findEle(driver,requestorInPnr,"xpath").getText();
			//		
		

		

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
					 waitExplicitlyByLocator(driver,groupID,"xpath",50);					 
				groupIDV=findEle(driver,groupID,"xpath").getText();
				noOfGustV=findEle(driver,noOfGust,"xpath").getText();
				noOfGustV=noOfGustV.substring(noOfGustV.indexOf(":")+1, noOfGustV.indexOf(")")+1);
				paymentStatusV=findEle(driver,paymentStatus,"xpath").getText();
				firstFlightNoV=findEle(driver,firstFlightNo,"xpath").getText();
				firstDepartV=findEle(driver,firstDepart,"xpath").getText();
			//	getscreenshot(driver);
				firstArrivalV=findEle(driver,firstArrival,"xpath").getText();
				//firstNoOfGuestV=findEle(driver,fristNoOfGuest,"cssselector").getText();
				firstNoOfGuestV=noOfGustV;
				
				findEle(driver,addGuestList,"id").click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 waitExplicitlyByLocator(driver,adultFirstNam+"1]","cssselector",50);		
				 

				
				boolean adultPresent=firstNoOfGuestV.contains("A");
				boolean childPresent=firstNoOfGuestV.contains("C");
				boolean infantPresent=firstNoOfGuestV.contains("I");
				if(adultPresent){		
				noAdult=Integer.parseInt((firstNoOfGuestV.substring(firstNoOfGuestV.indexOf("(")+1,firstNoOfGuestV.indexOf("A"))).replaceAll("\\s+", ""));
				}else {noAdult=0;}
				if(childPresent){
					noChild=Integer.parseInt((firstNoOfGuestV.substring(firstNoOfGuestV.indexOf(",")+1, firstNoOfGuestV.indexOf("C"))).replaceAll("\\s+", ""));
				}else {noChild=0;}
				if(infantPresent){
				noInfant=Integer.parseInt((firstNoOfGuestV.substring(firstNoOfGuestV.lastIndexOf(",")+1, firstNoOfGuestV.indexOf("I"))).replaceAll("\\s+", ""));
				}else {noInfant=0;}
				System.out.println(adultPresent+"\t"+childPresent+"\t"+infantPresent);
				System.out.println(noAdult+"\t"+noChild+"\t"+noInfant);
				Select selectYear;
				Select selectMonth;
				 WebElement dateWidget;
				 List<WebElement> columns;
				 int randomDate;
				 String sDate;
				 String dobInStr;
				 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				 
				for(int i=1;i<=noAdult;i++)
				{
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findEle(driver,adultFirstNam+i+"]","cssselector"));
					
					findEle(driver,adultFirstNam+i+"]","cssselector").sendKeys(generateFirstName());
					
				//	findEle(driver,adultMiddleNam+i+"]","cssselector").sendKeys(""+randomCharacter());
					
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
					  dobInStr= findEle(driver,adultDOB+i+"]","cssselector").getAttribute("value");
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					 Date birthDate = null;
					try {
						birthDate = sdf.parse(dobInStr);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 Age age = calculateAge(birthDate);
					 // adultDOB
					 
			//	findEle(driver,adultAge+i+"]","cssselector").sendKeys(""+age);	 
				select=new Select(findEle(driver,adultCitizen+i+"]","cssselector"));	
				select.selectByValue("IN");
				
				findEle(driver,adultPass+i+"]","cssselector").sendKeys("TEST"+getRandomNumber(1000000000,2000000000));
				
				findEle(driver,adultIssueDate+i+"]","cssselector").click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
				
				selectYear.selectByVisibleText(""+getRandomNumber(2000,2015));
				
				
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
				  
				  findEle(driver,adultExpDate+i+"]","cssselector").click();
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
					
					selectYear.selectByVisibleText(""+getRandomNumber(2019,2025));
					
					
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
				  
					//  findEle(driver,adultEmail+i+"]","cssselector").sendKeys(generateFirstName()+"@testmail.com");	  
					  
					//	findEle(driver,adultMobileNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000));	
						
					  
					  
					  
				//findEle(driver,adultTravelerNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000));	
				//findEle(driver,adultFrequentNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000)+"000");	
					
					
				}
				
				for(int i=1;i<=noChild;i++)
				{
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findEle(driver,childFirstNam+i+"]","cssselector"));
					
					findEle(driver,childFirstNam+i+"]","cssselector").sendKeys(generateFirstName());
				//	findEle(driver,adultMiddleNam+i+"]","cssselector").sendKeys(""+randomCharacter());
				//	findEle(driver,childMiddleNam+i+"]","cssselector").sendKeys(""+randomCharacter());
					
					findEle(driver,childLastNam+i+"]","cssselector").sendKeys(generateLastName());
					findEle(driver,childDOB+i+"]","cssselector").click();
					 
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
					
					selectYear.selectByVisibleText(""+getRandomNumber(2009,2015));
					
					
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
					  dobInStr= findEle(driver,childDOB+i+"]","cssselector").getAttribute("value");
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					 Date birthDate = null;
					try {
						birthDate = sdf.parse(dobInStr);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 Age age = calculateAge(birthDate);
					 // ChildDOB
					 
			//	findEle(driver,childAge+i+"]","cssselector").sendKeys(""+age);	 
				select=new Select(findEle(driver,childCitizen+i+"]","cssselector"));	
				select.selectByValue("IN");
				
				findEle(driver,childPass+i+"]","cssselector").sendKeys("TEST"+getRandomNumber(1000000000,2000000000));
				
				findEle(driver,childIssueDate+i+"]","cssselector").click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
				
				selectYear.selectByVisibleText(""+getRandomNumber(2000,2015));
				
				
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
				  
				  findEle(driver,childExpDate+i+"]","cssselector").click();
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
					
					selectYear.selectByVisibleText(""+getRandomNumber(2019,2025));
					
					
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
				  
					//  findEle(driver,childEmail+i+"]","cssselector").sendKeys(generateFirstName()+"@testmail.com");	  
					  
					//	findEle(driver,childMobileNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000));	
						
					  
					  
					  
				//findEle(driver,childTravelerNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000));	
			 //	findEle(driver,childFrequentNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000)+"000");	
					
					
				}
				
				for(int i=1;i<=noInfant;i++)
				{
					
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findEle(driver,infantFirstNam+i+"]","cssselector"));
					
					findEle(driver,infantFirstNam+i+"]","cssselector").sendKeys(generateFirstName());
					findEle(driver,infantMiddleNam+i+"]","cssselector").sendKeys(""+randomCharacter());
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
							
					  dobInStr= findEle(driver,infantDOB+i+"]","cssselector").getAttribute("value");
						 try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						 Date birthDate = null;
						try {
							birthDate = sdf.parse(dobInStr);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 Age age = calculateAge(birthDate);
						 // InfantDOB
						 
					findEle(driver,infantAge+i+"]","cssselector").sendKeys(""+age);	 
					select=new Select(findEle(driver,infantCitizen+i+"]","cssselector"));	
					select.selectByValue("IN");
					
					findEle(driver,infantPass+i+"]","cssselector").sendKeys("TEST"+getRandomNumber(1000000000,2000000000));
					
					findEle(driver,infantIssueDate+i+"]","cssselector").click();
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
					
					selectYear.selectByVisibleText(""+getRandomNumber(2000,2015));
					
					
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
					  
					  findEle(driver,infantExpDate+i+"]","cssselector").click();
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						selectYear= new Select(driver.findElement(By.cssSelector(departureDateYear)));
						
						selectYear.selectByVisibleText(""+getRandomNumber(2019,2025));
						
						
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
					  
						  findEle(driver,infantEmail+i+"]","cssselector").sendKeys(generateFirstName()+"@testmail.com");	  
						  
							findEle(driver,infantMobileNo+i+"]","cssselector").sendKeys(""+getRandomNumber(1000000000,2000000000));	

				}
				
		
	 
				findEle(driver,savePaxDetails,"cssselector").sendKeys(Keys.ENTER);
	
				try{
					 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
					 processingTime.start();
					  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",1500);
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
public Age calculateAge(Date birthDate)
{
    int years = 0;
    int months = 0;
    int days = 0;
    //create calendar object for birth day
    Calendar birthDay = Calendar.getInstance();
    birthDay.setTimeInMillis(birthDate.getTime());
    //create calendar object for current day
    long currentTime = System.currentTimeMillis();
    Calendar now = Calendar.getInstance();
    now.setTimeInMillis(currentTime);
    //Get difference between years
    years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
    int currMonth = now.get(Calendar.MONTH) + 1;
    int birthMonth = birthDay.get(Calendar.MONTH) + 1;
    //Get difference between months
    months = currMonth - birthMonth;
    //if month difference is in negative then reduce years by one and calculate the number of months.
    if (months < 0)
    {
       years--;
       months = 12 - birthMonth + currMonth;
       if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
          months--;
    } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
    {
       years--;
       months = 11;
    }
    //Calculate the days
    if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
       days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
    else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
    {
       int today = now.get(Calendar.DAY_OF_MONTH);
       now.add(Calendar.MONTH, -1);
       days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
    } else
    {
       days = 0;
       if (months == 12)
       {
          years++;
          months = 0;
       }
    }
    //Create new Age object
    return new Age(days, months, years);
 }
	
}
