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
import pack.base.TestBaseSetup;

public class SeriesDateRangeOneWayRequestPolicy extends TestBaseSetup {
	
protected WebDriver driver;
//String requestWindowFirst="requestDetailsGrid";
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
String groupName = "input[id=requestGroupName]";
String selectCategory="select[id='groupCategoryValue']";
String oneWayTrip = "label[for='tripType_oneWay'] span";
String origin = "input[id=sourceVal0]";
String destination= "input[id=destinationVal0]";
String departAdult="input[id=noOfAdult0]";
String departChild="input[id=noOfChild0]";
//String departInfant="input[id=noOfInfant0]";
String departExpectedFare="input[id=expectedFare0]";
String selectDate="input[id='widgetProceedBtn_0']";


String dateRange="input[id='dateRange0']";
String specificDate="input[id=specificDate]";

String departStart="input[id=startDateDisplay0]";
String departEnd="input[id=endDateDisplay0]";
String returnStart="input[id=startDateDisplay1]";
String returnEnd="input[id=endDateDisplay1]";
String datePickerMonth="select[class=ui-datepicker-month]";
String datePickerYear="select[class=ui-datepicker-year]";
String departureDateday="div[id=ui-datepicker-div]";
String calenderIcon="a.calendar-icon.day-preference-cal";
String daySelect="div.day-pref-panel label:nth-of-type";
String proceed="input[id='dateSelectionSubmit0']";
String proceed2="input[id='dateSelectionSubmit1']";

//String selectFlight="div[id=searchedFlightDetails10]";
String selectFlight="div[id=searchedFlightDetails";
String createList="input[id='widgetProceedBtn_2']";

String remarks="textarea[id=remarks]";
String submitButton="#commonRemarksDynamic>div input";
String succedMassage="div[id=setInfoMessage]";
String succedMsgOkBtn="button.btn.btnbgthemecolor";
String logOut="a[class=logout]";
String requestID;

String errorMsg="//div[@id='setInfoMessageError']";
String errorMsgOk="/../following-sibling::div/button";
String sucessMsg="//div[@id='setInfoMessage']";


String requestor;
String groupNameV,originV,destinationV,reqStartDate,reqEndDate,adultV,childV,infantV,expectedFareV,remarkV;
String timeStamp;
String paxMinimumError1V,paxMinimumError2V,paxMaxError1V,paxMaxError2V;
String infantMaxErrorV,infantMinimumErrorV;

int noPaxMnN, noPaxMxN,noInfantMnN,noInfantMxN; 

private Login login;
private Select select;
private Actions act;
WebElement wbEle;	
public SeriesDateRangeOneWayRequestPolicy(WebDriver driver) {
	this.driver = driver;
}

public void seriesDateRangeRequest(String org,String dest,String noPaxMn,String noPaxMx,String noInfantMn,String noInfantMx) {
	
	login=new Login(driver);
	login.doLogin(1);
	
	
	//waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);

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
		Thread.sleep(2000);
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
	waitExplicitlyByLocator(driver,groupName,"cssselector",20);
	findEle(driver,groupName,"cssselector").sendKeys(grpName);
	groupNameV=findEle(driver,groupName,"cssselector").getAttribute("value");
	select=new Select(findEle(driver,selectCategory,"cssselector"));
	select.selectByValue(""+getRandomNumber(1,12));	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	findEle(driver,oneWayTrip,"cssselector").click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
	
	  noPaxMnN=Integer.parseInt(noPaxMn);
	  noPaxMxN=Integer.parseInt(noPaxMx);
	  noInfantMnN=Integer.parseInt(noInfantMn);
	  noInfantMxN=Integer.parseInt(noInfantMx);	  
	  paxInput(noPaxMnN-1,0,noInfantMnN);	  
	  
	  String sFare=""+getRandomNumber(100,120); 
	
	  findEle(driver,departExpectedFare,"cssselector").sendKeys(sFare);
	  expectedFareV=findEle(driver,departExpectedFare,"cssselector").getAttribute("value");
	
	  findEle(driver,selectDate,"cssselector").click();
	  
	  waitExplicitlyByLocator(driver,errorMsg,"xpath",30);	
	  paxMinimumError1V=findEle(driver,errorMsg,"xpath").getText();
		findEle(driver,errorMsg+errorMsgOk,"xpath").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  paxInput(noPaxMnN-4,3,noInfantMnN);
		  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  findEle(driver,selectDate,"cssselector").click();	 
		  waitExplicitlyByLocator(driver,errorMsg,"xpath",30);	
		  paxMinimumError2V=findEle(driver,errorMsg,"xpath").getText();
		  findEle(driver,errorMsg+errorMsgOk,"xpath").click();
		  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  paxInput(noPaxMxN+1,0,noInfantMnN);
			  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  findEle(driver,selectDate,"cssselector").click();
			  waitExplicitlyByLocator(driver,errorMsg,"xpath",30);	
			  paxMaxError1V=findEle(driver,errorMsg,"xpath").getText();
			  findEle(driver,errorMsg+errorMsgOk,"xpath").click();
			  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  paxInput(noPaxMxN,1,noInfantMnN);
				  try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  findEle(driver,selectDate,"cssselector").click();
				  waitExplicitlyByLocator(driver,errorMsg,"xpath",30);	
				  paxMaxError2V=findEle(driver,errorMsg,"xpath").getText();
				  findEle(driver,errorMsg+errorMsgOk,"xpath").click();



				  try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  paxInput(noPaxMxN,0,noInfantMnN-1);
					  try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
					  findEle(driver,selectDate,"cssselector").click();
					  waitExplicitlyByLocator(driver,errorMsg,"xpath",30);	
					  infantMinimumErrorV=findEle(driver,errorMsg,"xpath").getText();
					  findEle(driver,errorMsg+errorMsgOk,"xpath").click();

					  try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  paxInput(noPaxMxN,0,noInfantMxN+1);
						  try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						  findEle(driver,selectDate,"cssselector").click();
						  
						  waitExplicitlyByLocator(driver,errorMsg,"xpath",30);	
						  infantMaxErrorV=findEle(driver,errorMsg,"xpath").getText();
						  findEle(driver,errorMsg+errorMsgOk,"xpath").click();
		  
						  try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							  paxInput(noPaxMxN,0,noInfantMxN);
							  findEle(driver,selectDate,"cssselector").click();
							  try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	  
	  waitExplicitlyByLocator(driver,dateRange,"cssselector",60);	
	
	  findEle(driver,dateRange,"cssselector").sendKeys(Keys.SPACE);
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	  
	  findEle(driver,departStart,"cssselector").click();
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
	int randomDate=getRandomNumber(1,23);
	String sDate=""+randomDate;  
	 
	  for (WebElement cell: columns){  
	   //Select 13th Date   
	   if (cell.getText().equals(sDate)){  
		   
	   cell.findElement(By.linkText(sDate)).click();  
	   break;  
	   }  
	  }
	  
	  reqStartDate=findEle(driver,departStart,"cssselector").getAttribute("value");
	 
		findEle(driver,departEnd,"cssselector").click();
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
		  reqEndDate=findEle(driver,departEnd,"cssselector").getAttribute("value");  
		 
		  waitExplicitlyByLocator(driver,calenderIcon,"cssselector",60);		  
	 
	/*
	  findEle(driver,calenderIcon,"cssselector").click();
	  
	  try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	 
	  Actions act=new Actions(driver);
	  for(int i=1;i<=6;i++)
	  {
		  if((i%2)==0)
		  {
			  act.moveToElement(findEle(driver,daySelect+"("+i+") input","cssselector")).click().build().perform();
		  }
	  }*/
	  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  waitExplicitlyByLocator(driver,proceed,"cssselector",60);
		
		  findEle(driver,proceed,"cssselector").click();
		  
		  
		  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  waitExplicitlyByLocator(driver,proceed2,"cssselector",60);
			
		  findEle(driver,proceed2,"cssselector").click();
			  
		  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  
		  String f1;
		  f1=""+getRandomNumber(1,3); 
		  f1=""+1; 
			/*	waitExplicitlyByLocator(driver,selectFlight+f1+"0]","cssselector",30);
			findEle(driver,selectFlight+f1+"0]","cssselector").click();
			*/
		  waitExplicitlyByLocator(driver,selectFlight+"_"+f1+"_0]","cssselector",60);
			findEle(driver,selectFlight+"_"+f1+"_0]","cssselector").click();

		  	  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  findEle(driver,createList,"cssselector").click();
				  
			  
		  waitExplicitlyByLocator(driver,remarks,"cssselector",10);    
		  

   	 findEle(driver,remarks,"cssselector").sendKeys("Test Booking");
	    	 
	    	 remarkV=findEle(driver,remarks,"cssselector").getAttribute("value");    
	         
	    	 findEle(driver,submitButton,"cssselector").sendKeys(Keys.ENTER);
	    	  try {
	    			Thread.sleep(5000);
	    		} catch (InterruptedException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		 	
			  waitExplicitlyByLocator(driver,succedMassage,"cssselector",60);	
 		     
	     		     
	    		     
	    wbEle=findEle(driver,succedMassage,"cssselector");
	    				
	    	
	   requestID=wbEle.getText();
	    			      
	    				
	    requestID= requestID.substring(requestID.indexOf("G")).trim();
	    System.out.println("Adhoc One Way Groupt Request has been send"+requestID);
	    				
	    	findEle(driver,succedMsgOkBtn,"cssselector").click();	
	  	  waitExplicitlyByLocator(driver,logOut,"cssselector",60);	
		     
				 wbEle=findEle(driver,logOut,"cssselector");	
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", wbEle);
			 
			 
			 
}

public void paxInput(int adultVal,int childVal,int infantVal){
	 
	findEle(driver,departAdult,"cssselector").clear();
	  findEle(driver,departAdult,"cssselector").sendKeys(""+adultVal);
	  adultV=findEle(driver,departAdult,"cssselector").getAttribute("value");	
	  findEle(driver,departChild,"cssselector").clear();
	  findEle(driver,departChild,"cssselector").sendKeys(""+childVal);
	  childV=findEle(driver,departChild,"cssselector").getAttribute("value");
	 // findEle(driver,departInfant,"cssselector").clear();
	//  findEle(driver,departInfant,"cssselector").sendKeys(""+infantVal);
	//  infantV=findEle(driver,departInfant,"cssselector").getAttribute("value");
	  
	  
}

	




}
