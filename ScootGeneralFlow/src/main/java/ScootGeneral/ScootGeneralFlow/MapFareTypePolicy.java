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

public class MapFareTypePolicy extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String settings="a[title='Fare setup']";
	String fareTypeSettings="+ul>li:nth-of-type(1)";
	String mapMatrix="ul>li[class='faresetPolicyQueryBox']>a";

	String create="//span[text()='Create']/..";
	String requestWindow="createPolicy_FARETYPE-body";
	
	
	String origin="//li[text()='Origin']";
	String destination="//li[text()='Destination']";
	//String noOfGuest="//li[text()='No of pax (A+C)']";
	String tripType="//li[text()='Trip type']";
	String CurrencyType="//li[text()='Currency type']";
	String departDate="//li[text()='Departure date']";
	String airlineCode="//li[text()='Airline code']";
	String loginID="//li[text()='Login id']";
	String requestType="//li[text()='Request type']";

	String addSelected="button[data-qtip='Add to Selected']";	
	String policyName="#policyName_FARETYPE-bodyEl>input";
	
	String staticMatrix="#matrixId_FARETYPE-bodyEl>input";
	String startDate="#startDate_FARETYPE-triggerWrap";
	String endDate="#endDate_FARETYPE-triggerWrap";
	String today="//span[text()='Today']/..";
	String nextMonth="//div[@class='x-datepicker-next']";
	
	String originCon="#sourceCondition_FARETYPE-bodyEl>input";
	String destCon="#destinationCondition_FARETYPE-bodyEl>input";
	String noOfPaxCon="#noOfPaxCondition_FARETYPE-bodyEl>input";
	String tripTypeCon="#tripTypeCondition_FARETYPE-bodyEl>input";
	String requestTypeCon="#requestTypeCondition_FARETYPE-bodyEl>input";


	String originTxt="#source_FARETYPE-bodyEl>input";
	String destTxt="#destination_FARETYPE-bodyEl>input";
	String tripTypeTxt="#tripType_FARETYPE-bodyEl>input";
	String requestTypeTxt="#requestType_FARETYPE-bodyEl>input";

	String addSector="#addAnotherFlightDetailsId-body>img";
	String join="#sectorRowJoin_FARETYPE-bodyEl>input";
	String orginCont2="#sourceCondition_FARETYPE_1-bodyEl>input";
	String orginTxt2="#source_FARETYPE_1-bodyEl>input";
	String destCont2="#destinationCondition_FARETYPE_1-bodyEl>input";
	String destTxt2="#destination_FARETYPE_1-bodyEl>input";
	
	String join2="#sectorRowJoin_FARETYPE_1-bodyEl>input";	
	String orginCont3="#sourceCondition_FARETYPE_2-bodyEl>input";
	String orginTxt3="#source_FARETYPE_2-bodyEl>input";
	String destCont3="#destinationCondition_FARETYPE_2-bodyEl>input";
	String destTxt3="#destination_FARETYPE_2-bodyEl>input";
	String changeStatus="//img[@data-qtip='Change status' and not(contains(@class,'INACTIVE'))]";
	String conformBox="//span[text()='Do you want to deactivate this policy?']";
	String yesBtn="//span[text()='Yes']/..";
	String okBtn="//span[text()='OK']/..";
	String optP1="//li[text()='";
	String optP2="']";	
	
	String createBtn="//span[text()='Submit']/..";
	
	String sucessMsg="//span[text()='Policy created successfully']";
	String sucessOk="//span[text()='OK']";
	
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	String logOut="a[class=logout]";

	String policyNameV,staticMatrixV,tripTypeV,requestTypeV;
	String origin1V,destination1V,origin2V,destination2V,origin3V,destination3V;
	String sucessMsgV;
	 Select select;
	
	
	 Login login;
	
	public MapFareTypePolicy(WebDriver driver) {
		this.driver = driver;
	}
	
	public void mapFareTypePolicy(String reqMatx,String trip,String reqType,String filePath,String delemiter) throws IOException {
		
		  
		//login=new Login(driver);
		// login.doLogin(7);
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
		findEle(driver,settings+fareTypeSettings,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,mapMatrix,"cssselector").click();
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",3);
			 
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
		
	/*	List<WebElement> activeNode=driver.findElements(By.xpath(changeStatus));
		
		for(int i=0;i<activeNode.size();i++){
			try{
				activeNode=driver.findElements(By.xpath(changeStatus));
			}catch(NoSuchElementException e){
				
			}
		
			activeNode.get(i).click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitExplicitlyByLocator(driver,yesBtn,"xpath",10);
			findEle(driver,yesBtn,"xpath").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitExplicitlyByLocator(driver,okBtn,"xpath",10);
			findEle(driver,okBtn,"xpath").click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
		findEle(driver,create,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",3);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Create Link is not displayed");
		 	}
		
		
		waitExplicitlyByLocator(driver,requestWindow,"id",30);
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
	
		 
		waitExplicitlyByLocator(driver,policyName,"cssselector",10);
		findEle(driver,policyName,"cssselector").sendKeys("FareTypePolicy"+getRandomNumber(50,150));
		policyNameV=findEle(driver,policyName,"cssselector").getAttribute("value");
		
		findEle(driver,staticMatrix,"cssselector").sendKeys(reqMatx);
		staticMatrixV=findEle(driver,staticMatrix,"cssselector").getAttribute("value");
		
		
		
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
	 
		waitExplicitlyByLocator(driver,sucessMsg,"xpath",30);
		sucessMsgV=findEle(driver,sucessMsg,"xpath").getText();		
		//String sucessOk="//span[text()='OK']";
		findEle(driver,sucessOk,"xpath").click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 //	waitExplicitlyByLocator(driver,logOut,"cssselector",30);
	 //	findEle(driver,logOut,"cssselector").click();


System.out.println( policyNameV+"\n"+staticMatrixV+"\n"+origin1V+"\n"+destination1V+"\n"+tripTypeV+"\n"+requestTypeV);

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

	

