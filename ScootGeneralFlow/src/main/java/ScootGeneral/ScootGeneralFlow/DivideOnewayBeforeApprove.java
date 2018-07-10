package ScootGeneral.ScootGeneralFlow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pack.base.TestBaseSetup;

public class DivideOnewayBeforeApprove extends TestBaseSetup {
	
protected WebDriver driver;
	
	
	String modify="a[title='Modify request']";
	String divide="li[class='groupChangeQueryBoxDD']>a";	//link Text
	
	
	 String groupName="input[id=requestGroupName][name=requestGroupName]";
	String groupId="input[id=requestMasterId][name=requestMasterId]";
	String pnr = "pnr";
	String searchBtn = "a.btn.custom-btn.mar-top-30";
	//Search
	String divide1="//td/p[text()[contains(.,'";
	String divide2="')]]/../../td[5]";


	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";
	
	
	String logOut="a[class=logout]";
	
	String requestStatusV;
	
 	private Login login;
 	Select select;
	public DivideOnewayBeforeApprove(WebDriver driver) {
		this.driver = driver;
	}
	
	public void divideRequest(String reqId) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		login=new Login(driver);
		login.doLogin(1);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		waitExplicitlyByLocator(driver,modify,"cssselector",60);	
		findEle(driver,modify,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waitExplicitlyByLocator(driver,divide,"cssselector",30);	
			
			findEle(driver,divide,"cssselector").click();
			try{
				 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",150);
			 	 	}
			 	catch(TimeoutException e){
			 		System.out.println("After Logout Processing is not displayed");
			 	}
		waitExplicitlyByLocator(driver,groupId,"cssselector",120);	
		//findEle(driver,groupName,"cssselector").sendKeys(grpName);
		String onlyNo=reqId.replaceAll("[^\\.0123456789]","");
		findEle(driver,groupId,"cssselector").sendKeys(onlyNo);
		
		
		waitExplicitlyByLocator(driver,pnr,"id",60);	

		//webEle=findEle(driver,tripType,"cssselector");
		//select=new Select(webEle);
		
		//select.selectByValue("adhoc");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitExplicitlyByLocator(driver,searchBtn,"cssselector",30);	
		
		 findEle(driver,searchBtn,"cssselector").click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,divide1+reqId+divide2,"xpath",30);	
	 
		requestStatusV	=findEle(driver,divide1+reqId+divide2,"xpath").getText();	


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	waitExplicitlyByLocator(driver,logOut,"cssselector",30);
	 WebElement	wbEle=findEle(driver,logOut,"cssselector");	
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", wbEle);

		
	
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


}
