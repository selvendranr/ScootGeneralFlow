package ScootGeneral.ScootGeneralFlow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pack.base.TestBaseSetup;

public class CreateTermsAndCondition extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String settings="a[title='Settings']";
	String termsAndCond="+ul>li:nth-of-type(1)";
	String cancelPolicyList="li[class='cancelPolicyList']";
	
	String calcelList="cancelGridId";
	String searchBtn="#cancelQueryBox-body+div>div button";
	String create="//span[text()='Create']/..";
	String policyName="policyName";
	
	String textStyle="div[id='policyDescription-toolbarWrap']>div>div:nth-of-type(2)>div:first-of-type";
	String frame1="policyDescription-iframeEl";
	String frameTxtArea="policyDescription-textareaEl";
	String setDefault="div[id='defaultStatus-bodyEl']>input";	
	 	
 	
	String createBtn="(//span[text()='Create']/..)[2]";
	
	String sucessMsg="//span[text()='Policy created successfully']";
	String sucessOk="//span[text()='OK']";
	
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	

	String policyNameV;
	
	String sucessMsgV;

	private Login login;
	
	public CreateTermsAndCondition(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createTandC(String inputFile) throws IOException {
		
		  
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
		findEle(driver,settings+termsAndCond,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,cancelPolicyList,"cssselector").click();
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Menu Loading Image is not displayed");
		 	}
		waitExplicitlyByLocator(driver,calcelList,"id",10);
		findEle(driver,searchBtn,"cssselector").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		waitExplicitlyByLocator(driver,calcelList,"id",30);
		//waitExplicitlyByLocator(driver,create,"xpath",10);
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
		
		
		waitExplicitlyByLocator(driver,policyName,"name",30);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		findEle(driver,policyName,"name").sendKeys("TermsAndCond"+generateFirstName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		policyNameV=findEle(driver,policyName,"name").getAttribute("value");
		
		driver.switchTo().frame(0);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
	//	String strLine;
		 
			 
			 
			 
			Path p=Paths.get(inputFile);
			Stream<String> content = null;
			try {
				content = Files.lines(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
		   
		WebElement webEle=findEle(driver,"body","cssselector");
	
		//while ((strLine = br.readLine()) != null)   {
			        
		     //   webEle.sendKeys(strLine);
		        content.forEach(s1-> webEle.sendKeys(s1+"\n"));
		//    }
		
		

 
            
      
		 
		 
	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//webEle.sendKeys("Test");
		//findEle(driver,frameTxtArea,"id").sendKeys("Test");
		//String frame1="policyDescription-iframeEl";
		//String frameTxtArea="policyDescription-textareaEl";

		driver.switchTo().defaultContent();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
		findEle(driver,createBtn,"xpath").click();
	 
		waitExplicitlyByLocator(driver,sucessMsg,"xpath",30);
		sucessMsgV=findEle(driver,sucessMsg,"xpath").getText();
		findEle(driver,sucessOk,"xpath").click();
	 
		
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

	

