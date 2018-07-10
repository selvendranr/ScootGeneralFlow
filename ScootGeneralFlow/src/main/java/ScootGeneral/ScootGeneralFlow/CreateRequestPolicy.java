package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import pack.base.TestBaseSetup;

public class CreateRequestPolicy extends TestBaseSetup {
	
protected WebDriver driver;
	
 	String requestWindowFirst="requestDetailsGrid";
	String settings="a[title='Settings']";
	String requestSetting="+ul>li:nth-of-type(3)";
	String requestCriteria="li[class='viewRequestCriteria']";
	
	String searchBtn="#searchRequestCriteria-body+div>div>div:first-of-type button";
	String requestCriteriaList="requestCriteriaGrid";
	String create="//span[text()='Create']/..";
	String requestCriteriaWindow="div[id='searchRequestCriteria']";
	
	String paxCount="//li[text()='Passenger count']";
	String addSelected="button[data-qtip='Add to Selected']";	
	String criteriaName="#criteriaNameRequestCriteria-bodyEl>input";
	
	String guestMin="passengerCountMin_REQUESTCRITERIA";
	String guestMax="passengerCountMax_REQUESTCRITERIA";
	//String infantMin="infantCountMin_REQUESTCRITERIA";
	//String infantMax="infantCountMax_REQUESTCRITERIA";
	
	String createBtn="(//span[text()='Create']/..)[2]";
	
	String sucessMsg="//span[text()='Request Criteria created successfully']";
	String sucessOk="//span[text()='OK']";
	
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	

	String criteriaNameV,guestMinV,guestMaxV,infantMinV,infantMaxV;
	String sucessMsgV;
	
	private Login login;
	
	public CreateRequestPolicy(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createCriteria() throws IOException {
		
		  
		login=new Login(driver);
		login.doLogin(7);
		
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
		findEle(driver,requestCriteria,"cssselector").click();
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Menu Loading Image is not displayed");
		 	}
		 waitExplicitlyByLocator(driver,requestCriteriaList,"id",30);
		
		findEle(driver,searchBtn,"cssselector").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waitExplicitlyByLocator(driver,requestCriteriaList,"id",20);
		
		findEle(driver,create,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Create Link is not displayed");
		 	}
		
		
		waitExplicitlyByLocator(driver,requestCriteriaWindow,"cssselector",30);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		findEle(driver,paxCount,"xpath").click();
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
		waitExplicitlyByLocator(driver,criteriaName,"cssselector",10);
		findEle(driver,criteriaName,"cssselector").sendKeys("requestCriteria"+getRandomNumber(10,50));
		criteriaNameV=findEle(driver,criteriaName,"cssselector").getAttribute("value");
		
		findEle(driver,guestMin,"name").sendKeys(""+getRandomNumber(10,15));
		guestMinV=findEle(driver,guestMin,"name").getAttribute("value");
		findEle(driver,guestMax,"name").sendKeys(""+getRandomNumber(25,35));
		guestMaxV=findEle(driver,guestMax,"name").getAttribute("value");

		//findEle(driver,infantMin,"name").sendKeys(""+1);
		//infantMinV=findEle(driver,infantMin,"name").getAttribute("value");
		//findEle(driver,infantMax,"name").sendKeys(""+2);
		//infantMaxV=findEle(driver,infantMax,"name").getAttribute("value");
	
		findEle(driver,"("+create+")[2]","xpath").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
		waitExplicitlyByLocator(driver,sucessMsg,"xpath",60);
		sucessMsgV=findEle(driver,sucessMsg,"xpath").getText();
		findEle(driver,sucessOk,"xpath").click();
		}catch(TimeoutException e){
			System.out.println(e);
		}
		 
		
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

	

