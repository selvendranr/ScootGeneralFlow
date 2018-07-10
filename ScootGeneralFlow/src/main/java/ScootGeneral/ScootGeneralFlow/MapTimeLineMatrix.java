package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pack.base.ReadRootPath;
import pack.base.SectorGenerator;
import pack.base.TestBaseSetup;

public class MapTimeLineMatrix extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String policyWindow="timeLinePolicyMatrixQueryBox";

	String settings="a[title='Settings']";
	String timeLine="+ul>li:nth-of-type(2)";
	String mapTimeLine="li[class='timeLinePolicyMatrixQueryBox']";
	String searchBtn="#timeLinePolicyMatrixQueryBox-body+div>div button";
	String timeLineMatrixList="timeLinePolicyMatrixListGridId-body";
	String timeLimitPolicyWin="div[id='timeLinePolicyMatrixQueryBox-body']";
	String create="//span[text()='Create']/..";
	String createPolicyWin="createPolicy_TIMELINEPOLICY";

		
	
	String origin="//li[text()='Origin']";
	String destination="//li[text()='Destination']";
	String noOfGuest="//li[text()='No of pax (A+C)']";
	String tripType="//li[text()='Trip type']";
	String CurrencyType="//li[text()='Currency type']";
	String departDate="//li[text()='Departure date']";
	String airlineCode="//li[text()='Airline code']";
	String loginID="//li[text()='Login id']";
	String requestType="//li[text()='Request type']";

	String addSelected="button[data-qtip='Add to Selected']";	
	String policyName="policyName_TIMELINEPOLICY";
	String timeLineMatrix="#matrixId_TIMELINEPOLICY-bodyEl>input";
	
	String startDateTxt="#startDate_TIMELINEPOLICY-bodyEl>input";
	String startDate="#startDate_TIMELINEPOLICY-triggerWrap";
	String endDate="#endDate_TIMELINEPOLICY-triggerWrap";
	String today="//span[text()='Today']/..";
	String nextMonth="//div[@class='x-datepicker-next']";
	
	String originCon="#sourceCondition_TIMELINEPOLICY-bodyEl>input";
	String destCon="#destinationCondition_TIMELINEPOLICY-bodyEl>input";
	String noOfPaxCon="#noOfPaxCondition_TIMELINEPOLICY-bodyEl>input";
	String tripTypeCon="#tripTypeCondition_TIMELINEPOLICY-bodyEl>input";
	String requestTypeCon="#requestTypeCondition_TIMELINEPOLICY-bodyEl>input";

	String originTxt="#source_TIMELINEPOLICY-bodyEl>input";
	String destTxt="#destination_TIMELINEPOLICY-bodyEl>input";
	String noOfPaxTxt="#noOfPax_TIMELINEPOLICY-bodyEl>input";
	String tripTypeTxt="#tripType_TIMELINEPOLICY-bodyEl>input";
	String requestTypeTxt="#requestType_TIMELINEPOLICY-bodyEl>input";


	String addSector="#addAnotherFlightDetailsId-body>img";
	String join="#sectorRowJoin_TIMELINEPOLICY-bodyEl>input";
	String orginCont2="#sourceCondition_TIMELINEPOLICY_1-bodyEl>input";
	String orginTxt2="#source_TIMELINEPOLICY_1-bodyEl>input";
	String destCont2="#destinationCondition_TIMELINEPOLICY_1-bodyEl>input";
	String destTxt2="#destination_TIMELINEPOLICY_1-bodyEl>input";
	
	String join2="#sectorRowJoin_TIMELINEPOLICY_1-bodyEl>input";	
	String orginCont3="#sourceCondition_TIMELINEPOLICY_2-bodyEl>input";
	String orginTxt3="#source_TIMELINEPOLICY_2-bodyEl>input";
	String destCont3="#destinationCondition_TIMELINEPOLICY_2-bodyEl>input";
	String destTxt3="#destination_TIMELINEPOLICY_2-bodyEl>input";
	
	String optP1="//li[text()='";
	String optP2="']";	
	
	String createBtn="//span[text()='Submit']/..";
	
	String sucessMsg="//span[text()='Policy created successfully']";
	String sucessOk="//span[text()='OK']";
	
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	String logOut="a[class=logout]";

	String policyNameV,timeLimitMatrixV,noOfPaxV,tripTypeV,requestTypeV;
	String origin1V,destination1V,origin2V,destination2V,origin3V,destination3V;
	String sucessMsgV;
 	Select select;
	
	private Login login;
	
	
	public MapTimeLineMatrix(WebDriver driver) {
		this.driver = driver;
	}
	
	public void mapTimeLinePolicy(String timeLimitMatx,String trip,String reqType,String filePath,String delemiter) throws IOException {
		
		  
		// login=new Login(driver);
		 //login.doLogin(7);
		 driver.navigate().refresh();
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
		
		waitExplicitlyByLocator(driver,settings,"cssselector",60);
		findEle(driver,settings,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,settings+timeLine,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,mapTimeLine,"cssselector").click();
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Menu Loading Image is not displayed");
		 	}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waitExplicitlyByLocator(driver,timeLimitPolicyWin,"cssselector",30);
		findEle(driver,searchBtn,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waitExplicitlyByLocator(driver,timeLineMatrixList,"id",30);
		findEle(driver,create,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Create Link is not displayed");
		 	}
		
		
		waitExplicitlyByLocator(driver,createPolicyWin,"id",30);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		findEle(driver,origin,"xpath").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,addSelected,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 findEle(driver,destination,"xpath").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,addSelected,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* findEle(driver,noOfGuest,"xpath").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			findEle(driver,addSelected,"cssselector").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
			 findEle(driver,tripType,"xpath").click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				findEle(driver,addSelected,"cssselector").click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 findEle(driver,CurrencyType,"xpath").click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView();", findEle(driver,requestType,"xpath"));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					findEle(driver,requestType,"xpath").click();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					findEle(driver,addSelected,"cssselector").click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		 
		waitExplicitlyByLocator(driver,policyName,"name",10);
		findEle(driver,policyName,"name").sendKeys("TimeLimitMatrix"+getRandomNumber(10,50));
		policyNameV=findEle(driver,policyName,"name").getAttribute("value");
		
		findEle(driver,timeLineMatrix,"cssselector").sendKeys(timeLimitMatx);
		timeLimitMatrixV=findEle(driver,timeLineMatrix,"cssselector").getAttribute("value");
		
		
		
		findEle(driver,startDate,"cssselector").click();
		waitExplicitlyByLocator(driver,today,"xpath",10);
		findEle(driver,today,"xpath").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,endDate,"cssselector").click();
		waitExplicitlyByLocator(driver,"("+nextMonth+")[2]","xpath",10);
		findEle(driver,"("+nextMonth+")[2]","xpath").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,""+getRandomNumber(1,25),"linktext").click();

		ReadRootPath readRoot=new ReadRootPath();
		String rootPath=readRoot.getPath();

		SectorGenerator sector=new SectorGenerator();
		String[] sectorDetails=sector.sectorGenerator(rootPath+filePath, delemiter);


		findEle(driver,originCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,originTxt,"cssselector").sendKeys(sectorDetails[0]);
		waitExplicitlyByLocator(driver, optP1+sectorDetails[0]+optP2 ,"xpath",10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		findEle(driver,optP1+sectorDetails[0]+optP2,"xpath").click();
		origin1V=findEle(driver,originTxt,"cssselector").getAttribute("value");
		findEle(driver,destCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,destTxt,"cssselector").sendKeys(sectorDetails[1]);
		waitExplicitlyByLocator(driver,"("+optP1+sectorDetails[1]+optP2+")[2]","xpath",10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		findEle(driver,"("+optP1+sectorDetails[1]+optP2+")[2]","xpath").click();
		destination1V=findEle(driver,destTxt,"cssselector").getAttribute("value");
		//Start End
				if(trip.equalsIgnoreCase("Round trip")){
					findEle(driver,addSector,"cssselector").click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//findEle(driver,join,"cssselector").clear();
					//findEle(driver,join,"cssselector").sendKeys("AND",Keys.TAB);
					findEle(driver,orginCont2,"cssselector").sendKeys("=",Keys.TAB);
					//ReadRootPath readRoot=new ReadRootPath();
					//String rootPath=readRoot.getPath();

					//SectorGenerator sector=new SectorGenerator();
					//String[] sectorDetails=sector.sectorGenerator(rootPath+filePath, delemiter);
				 
					//sectorDetails[1];
					findEle(driver,orginTxt2,"cssselector").sendKeys(sectorDetails[1]);
				//	waitExplicitlyByLocator(driver, optP1+sectorDetails[0]+optP2 ,"xpath",10);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List orgList2=driver.findElements(By.xpath(optP1+sectorDetails[1]+optP2));
						
					findEle(driver,"("+optP1+sectorDetails[1]+optP2+")["+orgList2.size()+"]","xpath").click();
					origin2V=findEle(driver,orginTxt2,"cssselector").getAttribute("value");
					
					findEle(driver,destCont2,"cssselector").sendKeys("=",Keys.TAB);
					findEle(driver,destTxt2,"cssselector").sendKeys(sectorDetails[0]);			 
					//waitExplicitlyByLocator(driver, optP1+sectorDetails[1]+optP2 ,"xpath",10);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List destList2=driver.findElements(By.xpath(optP1+sectorDetails[0]+optP2));	
					System.out.println(destList2.size());
					findEle(driver,"("+optP1+sectorDetails[0]+optP2+")["+destList2.size()+"]","xpath").click();
					destination2V=findEle(driver,destTxt2,"cssselector").getAttribute("value");
					}else if(trip.equalsIgnoreCase("Multi city")){
					findEle(driver,addSector,"cssselector").click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					findEle(driver,addSector,"cssselector").click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					findEle(driver,join,"cssselector").clear();
					//findEle(driver,join,"cssselector").sendKeys("AND",Keys.TAB);
					findEle(driver,orginCont2,"cssselector").sendKeys("=",Keys.TAB);
					//ReadRootPath readRoot=new ReadRootPath();
					//String rootPath=readRoot.getPath();

					//SectorGenerator sector=new SectorGenerator();
					//String[] sectorDetails=sector.sectorGenerator(rootPath+filePath, delemiter);
				 
					//sectorDetails[1];
					findEle(driver,orginTxt2,"cssselector").sendKeys(sectorDetails[2]);
				//	waitExplicitlyByLocator(driver, optP1+sectorDetails[0]+optP2 ,"xpath",10);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List orgList2=driver.findElements(By.xpath(optP1+sectorDetails[2]+optP2));
						
					findEle(driver,"("+optP1+sectorDetails[2]+optP2+")["+orgList2.size()+"]","xpath").click();
					origin2V=findEle(driver,orginTxt2,"cssselector").getAttribute("value");
					
					findEle(driver,destCont2,"cssselector").sendKeys("=",Keys.TAB);
					findEle(driver,destTxt2,"cssselector").sendKeys(sectorDetails[3]);			 
					//waitExplicitlyByLocator(driver, optP1+sectorDetails[1]+optP2 ,"xpath",10);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List destList2=driver.findElements(By.xpath(optP1+sectorDetails[3]+optP2));	
					System.out.println(destList2.size());
					findEle(driver,"("+optP1+sectorDetails[3]+optP2+")["+destList2.size()+"]","xpath").click();
					destination2V=findEle(driver,destTxt2,"cssselector").getAttribute("value");
					findEle(driver,join2,"cssselector").clear();
					//findEle(driver,join2,"cssselector").sendKeys("AND",Keys.TAB);
					findEle(driver,orginCont3,"cssselector").sendKeys("=",Keys.TAB);
					
					findEle(driver,orginTxt3,"cssselector").sendKeys(sectorDetails[4]);
				//	waitExplicitlyByLocator(driver, optP1+sectorDetails[2]+optP2 ,"xpath",10);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List orgList3=driver.findElements(By.xpath(optP1+sectorDetails[4]+optP2));
						
					findEle(driver,"("+optP1+sectorDetails[4]+optP2+")["+orgList3.size()+"]","xpath").click();
					origin3V=findEle(driver,orginTxt3,"cssselector").getAttribute("value");
					
					findEle(driver,destCont3,"cssselector").sendKeys("=",Keys.TAB);
					findEle(driver,destTxt3,"cssselector").sendKeys(sectorDetails[5]);			 
					//waitExplicitlyByLocator(driver, optP1+sectorDetails[3]+optP2 ,"xpath",10);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List destList3=driver.findElements(By.xpath(optP1+sectorDetails[5]+optP2));			
					findEle(driver,"("+optP1+sectorDetails[5]+optP2+")["+destList3.size()+"]","xpath").click();
					destination3V=findEle(driver,destTxt3,"cssselector").getAttribute("value");


				}
		
		/*findEle(driver,noOfPaxCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,noOfPaxTxt,"cssselector").sendKeys(noOfPax);
		//waitExplicitlyByLocator(driver,optP1+noOfPax+optP2,"xpath",10);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		noOfPaxV=findEle(driver,noOfPaxTxt,"cssselector").getAttribute("value");
		findEle(driver,noOfPaxTxt,"cssselector").sendKeys(Keys.TAB);
		 */
				
		findEle(driver,tripTypeCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,tripTypeTxt,"cssselector").sendKeys(trip);
		waitExplicitlyByLocator(driver,optP1+trip+optP2,"xpath",10);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,optP1+trip+optP2,"xpath").click();
		tripTypeV=findEle(driver,tripTypeTxt,"cssselector").getAttribute("value");
		findEle(driver,tripTypeTxt,"cssselector").sendKeys(Keys.TAB);

		
		findEle(driver,requestTypeCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,requestTypeTxt,"cssselector").sendKeys(reqType);
		waitExplicitlyByLocator(driver,optP1+reqType+optP2,"xpath",10);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,optP1+reqType+optP2,"xpath").click();
		requestTypeV=findEle(driver,requestTypeTxt,"cssselector").getAttribute("value");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		findEle(driver,createBtn,"xpath").click();
	 
		waitExplicitlyByLocator(driver,sucessMsg,"xpath",120);
		System.out.println(findEle(driver,sucessMsg,"xpath").getText());		
		sucessMsgV=findEle(driver,sucessMsg,"xpath").getText();
		findEle(driver,sucessOk,"xpath").click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	waitExplicitlyByLocator(driver,logOut,"cssselector",30);
	 	findEle(driver,logOut,"cssselector").click();


System.out.println( policyNameV+"\n"+timeLimitMatrixV+"\n"+origin1V+"\n"+destination1V+"\n"+tripTypeV+"\n"+noOfPaxV);

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
	
	
	public boolean isAlertPresentDismiss() 
	{ 
	    try 
	    { 
	      Alert a1=driver.switchTo().alert();
	      
	     
	      System.out.println(a1.getText());
	        
	        a1.dismiss();
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    {
	        return false; 
	    }   
	}
	
	
	
	
	
	
}

	

