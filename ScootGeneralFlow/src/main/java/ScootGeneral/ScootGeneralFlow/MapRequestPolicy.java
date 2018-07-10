package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pack.base.ReadRootPath;
import pack.base.SectorGenerator;
import pack.base.TestBaseSetup;

public class MapRequestPolicy extends TestBaseSetup {
	
protected WebDriver driver;
	

	String requestWindowFirst="requestDetailsGrid";
	String settings="a[title='Settings']";
	String requestSetting="+ul>li:nth-of-type(3)";
	String requestPolicy="li[class='requestPolicyQueryBox']";
	
	String searchBtn="#requestPolicyQueryBox-body+div>div>div:first-of-type button";
	String requestPolicyList="requestPolicyGrid-body";
	String create="//span[text()='Create']/..";
	String requestWindow="div[id='createPolicy_REQUESTPOLICY']";
	
	String origin="//li[text()='Origin']";
	String destination="//li[text()='Destination']";
	String departDate="//li[text()='Departure date']";
	String loginID="//li[text()='Login id']";
	String requestType="//li[text()='Request type']";
	String tripType="//li[text()='Trip type']";
	String userType="//li[text()='User type']";
	String tripCategory="//li[text()='Trip category']";

	String addSelected="button[data-qtip='Add to Selected']";	
	String policyName="#policyName_REQUESTPOLICY-bodyEl>input";
	
	String requestMatrix="#matrixId_REQUESTPOLICY-bodyEl>div+input";
	String startDate="#startDate_REQUESTPOLICY-triggerWrap";
	String endDate="#endDate_REQUESTPOLICY-triggerWrap";
	String today="//span[text()='Today']/..";
	String nextMonth="//div[@class='x-datepicker-next']";
	
	String originCon="#sourceCondition_REQUESTPOLICY-bodyEl>input";
	String destCon="#destinationCondition_REQUESTPOLICY-bodyEl>input";
	String tripTypeCon="#tripTypeCondition_REQUESTPOLICY-bodyEl>input";
	String requestTypeCon="#requestTypeCondition_REQUESTPOLICY-bodyEl>input";

	String originTxt="#source_REQUESTPOLICY-bodyEl>input";
	String destTxt="#destination_REQUESTPOLICY-bodyEl>input";
	String tripTypeTxt="#tripType_REQUESTPOLICY-bodyEl>input";
	String requestTypeTxt="#requestType_REQUESTPOLICY-bodyEl>input";
	
	String addSector="#addAnotherFlightDetailsId-body>img";
	String join="#sectorRowJoin_REQUESTPOLICY-bodyEl>input";
	String orginCont2="#sourceCondition_REQUESTPOLICY_1-bodyEl>input";
	String orginTxt2="#source_REQUESTPOLICY_1-bodyEl>input";
	String destCont2="#destinationCondition_REQUESTPOLICY_1-bodyEl>input";
	String destTxt2="#destination_REQUESTPOLICY_1-bodyEl>input";
	
	String join2="#sectorRowJoin_REQUESTPOLICY_1-bodyEl>input";	
	String orginCont3="#sourceCondition_REQUESTPOLICY_2-bodyEl>input";
	String orginTxt3="#source_REQUESTPOLICY_2-bodyEl>input";
	String destCont3="#destinationCondition_REQUESTPOLICY_2-bodyEl>input";
	String destTxt3="#destination_REQUESTPOLICY_2-bodyEl>input";


	
	String optP1="//li[text()='";
	String optP2="']";	
	
	String createBtn="//span[text()='Submit']/..";
	
	String sucessMsg="//span[text()='Policy created successfully']";
	String sucessOk="//span[text()='OK']";
	
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	String logOut="a[class=logout]";

	String policyNameV,requestMatrixV,tripTypeV,requestTypeV,sucessMsgV;
	
 	String origin1V,destination1V,origin2V,destination2V,origin3V,destination3V;
	Select select;
	
	private Login login;
	
	
	public MapRequestPolicy(WebDriver driver) {
		this.driver = driver;
	}
	
	public void mapCriteria(String  trip,String reqType,String reqMatx,String filePath,String delemiter) throws IOException {
		
		  
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
		findEle(driver,settings+requestSetting,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,requestPolicy,"cssselector").click();
		
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
		waitExplicitlyByLocator(driver,requestPolicyList,"id",60);
		findEle(driver,searchBtn,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waitExplicitlyByLocator(driver,requestPolicyList,"id",60);
		findEle(driver,create,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Create Link is not displayed");
		 	}
		
		
		waitExplicitlyByLocator(driver,requestWindow,"cssselector",60);
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
		findEle(driver,policyName,"cssselector").sendKeys("RequestPolicy"+getRandomNumber(10,50));
		policyNameV=findEle(driver,policyName,"cssselector").getAttribute("value");
		
		findEle(driver,requestMatrix,"cssselector").sendKeys(reqMatx);
		requestMatrixV=findEle(driver,requestMatrix,"cssselector").getAttribute("value");
		
		
		
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,optP1+trip+optP2,"xpath",10);
		
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
		System.out.println(findEle(driver,sucessMsg,"xpath").getText());	
		
		sucessMsgV=findEle(driver,sucessMsg,"xpath").getText();
		//String sucessOk="//span[text()='OK']";
		findEle(driver,sucessOk,"xpath").click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	waitExplicitlyByLocator(driver,logOut,"cssselector",30);
	 	findEle(driver,logOut,"cssselector").click();


System.out.println( policyNameV+"\n"+requestMatrixV+"\n"+origin1V+"\n"+destination1V+"\n"+tripTypeV);

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

	

