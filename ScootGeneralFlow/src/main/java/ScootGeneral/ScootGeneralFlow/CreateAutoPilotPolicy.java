package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class CreateAutoPilotPolicy extends TestBaseSetup {
	
protected WebDriver driver;
	
 
	String settings="a[title='Settings']";
	String autoPilotPolicy="+ul>li[class='autoPilotPolicyQueryBox']";
 

	String create="//span[text()='Create']/..";
	String createPolicyWindow="div[id='createPolicy_AUTOPILOT-body']";
	
	String origin="//li[text()='Origin']";
	String destination="//li[text()='Destination']";
	String noOfGuest="//li[text()='No of guests (A+C)']";
	String tripType="//li[text()='Trip type']";
	String CurrencyType="//li[text()='Currency type']";
	String departDate="//li[text()='Departure date']";
	String airlineCode="//li[text()='Airline code']";
	String loginID="//li[text()='Login id']";
	String requestType="//li[text()='Request type']";
	
	String userType="//li[text()='User type']";
	String tripCategory="//li[text()='Trip category']";

	String addSelected="button[data-qtip='Add to Selected']";	
	String policyName="#policyName_AUTOPILOT-bodyEl>input";
	
	String processTypeTxt="#processType_AUTOPILOT-bodyEl>input";
	String processType="#processType_AUTOPILOT-triggerWrap";
	
	String processVal[]={"//li[text()='Approve only']","//li[text()='Reject only']","//li[text()='Manual process']","//li[text()='Auto decision']","//li[text()='Send for review']"};
	
	//String approve="//li[text()='Approve only']";
	//String reject="//li[text()='Reject only']";
	//String manual="//li[text()='Manual process']";
	//String auto="//li[text()='Auto decision']";
	//String sendForReview="//li[text()='Send for review']";	
 
	String startDate="#startDate_AUTOPILOT-triggerWrap";
	String endDate="#endDate_AUTOPILOT-triggerWrap";
	String today="//span[text()='Today']/..";
	String nextMonth="//div[@class='x-datepicker-next']";
	
	String originCon="#sourceCondition_AUTOPILOT-bodyEl>input";
	String destCon="#destinationCondition_AUTOPILOT-bodyEl>input";
	String loginIdCon="#loginIdCondition_AUTOPILOT-bodyEl>input";
	String noOfPaxCon="#noOfPaxCondition_AUTOPILOT-bodyEl>input";
	
	String originTxt="#source_AUTOPILOT-bodyEl>input";
	String destTxt="#destination_AUTOPILOT-bodyEl>input";
	String loginIdTxt="#loginId_AUTOPILOT-bodyEl>input";
	String noOfPaxTxt="#noOfPax_AUTOPILOT-bodyEl>input";

	
	String optP1="//li[text()='";
	String optP2="']";	
	
	String createBtn="//span[text()='Submit']/..";
	
	String sucessMsg="//span[text()='Policy created successfully']";
	String sucessOk="//span[text()='OK']";
	
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	String logOut="a[class=logout]";

	String policyNameV,originV,destinationV,loginIDV,noOfPaxV,processTypeV;
	
	
	private Login login;
	
	Select select;
	
	
	
	
	public CreateAutoPilotPolicy(WebDriver driver) {
		this.driver = driver;
	}
	
	public void autoPilot(String org,String dest) throws IOException {
		
		  
		 login=new Login(driver);
		 login.doLogin(7);
		driver.navigate().refresh();
		waitExplicitlyByLocator(driver,settings,"cssselector",60);
		findEle(driver,settings,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,settings+autoPilotPolicy,"cssselector").click();

		
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
		
		findEle(driver,create,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Create Link is not displayed");
		 	}
		
		
		waitExplicitlyByLocator(driver,createPolicyWindow,"cssselector",30);
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
		
		 findEle(driver,noOfGuest,"xpath").click();
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
		 
		waitExplicitlyByLocator(driver,policyName,"cssselector",10);
		findEle(driver,policyName,"cssselector").sendKeys("AutoPilotPolicy"+getRandomNumber(10,50));
		policyNameV=findEle(driver,policyName,"cssselector").getAttribute("value");
		
		findEle(driver,processType,"cssselector").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,processVal[getRandomNumber(0,5)],"xpath").click();
		processTypeV=findEle(driver,processTypeTxt,"cssselector").getAttribute("value");
				
		//findEle(driver,approve,"xpath").click();
	
		
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

		findEle(driver,originCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,originTxt,"cssselector").sendKeys(org);
		waitExplicitlyByLocator(driver, optP1+org+optP2 ,"xpath",10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		findEle(driver,optP1+org+optP2,"xpath").click();
		originV=findEle(driver,originTxt,"cssselector").getAttribute("value");
		findEle(driver,destCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,destTxt,"cssselector").sendKeys(dest);
		waitExplicitlyByLocator(driver,"("+optP1+dest+optP2+")[2]","xpath",10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		findEle(driver,"("+optP1+dest+optP2+")[2]","xpath").click();
		destinationV=findEle(driver,destTxt,"cssselector").getAttribute("value");

		findEle(driver,noOfPaxCon,"cssselector").sendKeys("=",Keys.TAB);
		findEle(driver,noOfPaxTxt,"cssselector").sendKeys(""+getRandomNumber(10,15));
	   
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		noOfPaxV=findEle(driver,noOfPaxTxt,"cssselector").getAttribute("value");
		//findEle(driver,loginIdTxt,"cssselector").sendKeys(Keys.TAB);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		findEle(driver,createBtn,"xpath").click();
	 
		waitExplicitlyByLocator(driver,sucessMsg,"xpath",30);
		System.out.println(findEle(driver,sucessMsg,"xpath").getText());		
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


System.out.println( policyNameV+"\n"+originV+"\n"+destinationV+"\n"+loginIDV);

System.out.println("Process Type"+processTypeV);
System.out.println(noOfPaxV);

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

	

