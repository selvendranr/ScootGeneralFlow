package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pack.base.TestBaseSetup;

public class ProcessDateRangeOneWay extends TestBaseSetup {
	
protected WebDriver driver;

	String response="a[title='Response']";
	String process="li[class='processDashBoard']";
	String inputID = "input[name=requestId]";
	String searchBtn = "button[class=x-btn-center]";
  	String processImage="tbody tr:nth-of-type(2) td:nth-of-type(15)>div>img";
	String processImagep1= "//td[div='GRP";
	String processImagep2= "']/following-sibling::td[14]/div/img";
	//String passengerDetails="']/following-sibling::td[6]/div";
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	
	String grpId="//label[contains(text(),'Request id :')]/following-sibling::div[1]/div";
	//String grpName="//label[contains(text(),'Group name :')]/following-sibling::div[1]/div";
	String reqName="//label[contains(text(),'Requestor name:')]/following-sibling::div[1]/div";

	String reqType="//label[contains(text(),'Request type :')]/following-sibling::div[1]/div";
	String reqDate="//label[contains(text(),'Requested date:')]/following-sibling::div[1]/div";
	
	String comformBtn="//span[.='Yes']";
	String toRunBatch="Run batch now";
	String information="//div/span[contains(text(),'Series request')]";
	String informationBtn="//em/button/span[contains(text(),'OK')]";
	String closeBtn="//span[contains(text(),'View group request history')]/../following-sibling::div/img";	
	String validityLink="a[id='groupLevelValidityLink']";
	String closeLaterPayment="div[id=paymentPercentage0]+div+img";
	String fareVal="div[id='fareValidity-bodyEl'] input";
	String payVal="div[id='paymentValidity-bodyEl'] input";
	String nameVal="div[id='passengerValidity-bodyEl'] input";
	String fareType="div[id='fareValidityType-bodyEl']>input";
	String payType="div[id='paymentValidityType-bodyEl']>input";
	String nameType="div[id='passenegerValidityType-bodyEl']>input";
	String fareExpType="div[id='fareExpiryType-bodyEl']>input";
	String payExpTye="div[id='paymentExpiryType-bodyEl']>input";
	String nameExpType="div[id='passengerExpiryType-bodyEl']>input";
	
	
	//String increaseToSen="div[id=paymentPercentage-bodyEl] input";
	String updateValidity="//button/span[contains(text(),'Update')]";

	
	String selectFlightImage="//td/div[text()='";
	String selectFlightImage2="']/../following-sibling::td[11]/div/div[@class='x-grid-row-checker']";	
	String totalNoOfPax="//label[contains(text(),'No of pax :')]/following-sibling::div[1]/div";
	String expectedFare="//label[contains(text(),'Expected fare:')]/following-sibling::div[1]/div";
	String origin="//div[@id='showFlightDetailsId-body']/div[2]/div[3]/div/table/tbody/tr[2]/td[2]/div";
	String destination="//div[@id='showFlightDetailsId-body']/div[2]/div[3]/div/table/tbody/tr[2]/td[3]/div";
	String flightNo="//div[@id='showFlightDetailsId-body']/div[2]/div[3]/div/table/tbody/tr[2]/td[4]/div";
	String totalFare="label[id='dispTotalFare-labelEl']+div div";
	String ssrFare="div[id='ssrFare-bodyEl'] div";
	String adultFare="label[id='displayAdultFare-labelEl']+div div";
	String childFare="label[id='displayChildFare-labelEl']+div div";
	String infantFare="label[id='displayInfantFare-labelEl']+div div";
	String evaluatedFare="a[id=displacemetFareBreakup]";
	String evaluatedFareAjust="label[id='baseFare-labelEl']+div input";
	//String discountPrice="label[id='displayDiscount-labelEl']+div div";
	String flightScheduleMtrixVerify="//a/span[starts-with(@id,'selectedFlightMatrixText')]";
	String flightScheduleMtrixCheckBox="//span/input[starts-with(@id,'CHECK_selectedFlights_')]";

		
	String submitSD="//button/span[text()='Submit']/..";
	
	String requestedFare="//label[contains(text(),'Fare requested:')]/following-sibling::div[1]/div";
	String fareEvaluated="label[id=fareEvaluatedId-labelEl]+div div a";
	String fareAdult="label[id=totalFare-labelEl]+div div";
	
	String fareChild="label[id=childTotalFare-labelEl]+div div";
	String fareInfant="label[id=infantTotalFare-labelEl]+div div";
	String approveBtn="span[id=approve-btnInnerEl][class=x-btn-inner]";
	
	
	
	String acceptClose="button[aria-label='Close']";
	String behalfOfAgnet="img[data-qtip='Respond on behalf of agent'][src='images/agent.png']";


	
	String okAtrerApprove="//span[.='OK']";
	
	String logOut="a[class=logout]";
	
	String allPassenger;
	 
	String fareTypeV,payTypeV,nameTypeV,fareExpTypeV,payExpTyeV,nameExpTypeV;
	String groupIdV,groupNameV,requestTypeV,requestorNameV,requestDateV;
	String expFareV,flightNoV,originV,destV,requestedFareV;

	String responseDateV,respondedByV,fareRequestedV,remarksV,cancelPolicyV,expiryDateV;


	WebElement wbEle;

 
	private Login login;
	 
	
	 
	public ProcessDateRangeOneWay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void processSeriesRequest(String groupID) throws IOException {
		
		groupID=groupID.replaceAll("[^\\.0123456789]","");
		login=new Login(driver);
		login.doLogin(3);
		
		waitExplicitlyByLocator(driver,response,"cssselector",30);
		findEle(driver,response,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		findEle(driver,process,"cssselector").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
	 		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
	 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
		System.out.println("Series One Way Group Request Processsing is started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,inputID,"cssselector",30);
	
		
		findEle(driver,inputID,"cssselector").sendKeys(groupID);
		
		
		findEle(driver,searchBtn,"cssselector").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
	 		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
	 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Search Processing is not displayed");
		 	}
	

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,processImage,"cssselector",30);
	//	allPassenger=findEle(driver,processImagep1+groupID+passengerDetails,"xpath").getText();
	 
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
	 		
			waitExplicitlyByLocator(driver,processing,"xpath",5);
		 	  waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
		 		}
		 	catch(TimeoutException e){
		 		System.out.println("Before conform Processing is not displayed");
		 	}

		
		if(findEle(driver,comformBtn,"xpath").isDisplayed())
		{
	
		waitExplicitlyByLocator(driver,comformBtn,"xpath",30);	
		findEle(driver,comformBtn,"xpath").click();
		}
		
		else
		{
			System.out.println("Conform box is not displayed ");
		}
		
		
	 	try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			  waitExplicitlyNotByLocator(driver,processing,"xpath",500);
		 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Conform Processing is not displayed");
		 	}
		groupIdV=findEle(driver,grpId,"xpath").getText();
		//groupNameV=findEle(driver,grpName,"xpath").getText();
		requestorNameV=findEle(driver,reqName,"xpath").getText();
		requestTypeV=findEle(driver,reqType,"xpath").getText();
		requestDateV=findEle(driver,reqDate,"xpath").getText();
		 
		try{
			 waitExplicitlyByLocator(driver,toRunBatch,"linktext",50);
			 findEle(driver,toRunBatch,"linktext").click();
		  
	 		 waitExplicitlyByLocator(driver,information,"xpath",600);
	 			System.out.println(findEle(driver,information,"xpath").getText());
			  	 waitExplicitlyByLocator(driver,informationBtn,"xpath",10);
			 	findEle(driver,informationBtn,"xpath").click();

			 	}
		 	catch(TimeoutException e){
		 		System.out.println("Run Batch is not displayed is not displayed");
		 	}

			 
	 
 		 	try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

Actions act = new Actions(driver);
act.moveToElement(findEle(driver,closeBtn,"xpath")).click().build().perform();
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();

		try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
	 		  waitExplicitlyNotByLocator(driver,processing,"xpath",500);
	 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After reopen processing is not displayed");
		 	}
		 
		waitExplicitlyByLocator(driver,validityLink,"cssselector",150);	
		
			
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}



	
		 waitExplicitlyByLocator(driver,selectFlightImage+"1"+selectFlightImage2,"xpath",30);
			findEle(driver,selectFlightImage+"1"+selectFlightImage2,"xpath").click();


		try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		waitExplicitlyByLocator(driver,"("+flightScheduleMtrixVerify+")[1]","xpath",30);
			
			List<WebElement> scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
			System.out.println(scheduleMatrix.size());
			/*JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", scheduleMatrix.get(0));
			try{
		 		
				waitExplicitlyByLocator(driver,processing,"xpath",50);
				 processingTime.start();
				  waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
				  processingTime.stop();
				  processingTimeV=processingTimeV+processingTime.getTime();
				  processingTime.reset();	
				}
			 	catch(TimeoutException e){
			 		System.out.println("Flight Window is not displayed");
			 	}

			 waitExplicitlyByLocator(driver,submitSD,"xpath",10);

	
			WebElement webEle=findEle(driver,submitSD,"xpath");
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", webEle);
			*/
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<WebElement> li1=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
				try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			for(int i=0;i<li1.size();i++)
			{
				li1=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
				
				executor.executeScript("arguments[0].click();", li1.get(i));
				
				
				
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		waitExplicitlyByLocator(driver,approveBtn,"cssselector",30);	
		
		JavascriptExecutor executor3=(JavascriptExecutor)driver;
		
		WebElement webEle=findEle(driver,approveBtn,"cssselector");
		executor3.executeScript("arguments[0].click();",webEle);
		



		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(isAlertPresent())
		{
			System.out.println("alertpresent and Accepted");
		}
		else
		{
			System.out.println("Alert Not Present");
		}
		 
	try{
 		waitExplicitlyByLocator(driver,okAtrerApprove,"xpath",120);	
 
		webEle=findEle(driver,okAtrerApprove,"xpath");
		executor3.executeScript("arguments[0].click();",webEle);
	}
 	catch(TimeoutException e){
 		System.out.println("Success Message is not displayed");
 	 	}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		waitExplicitlyByLocator(driver,logOut,"cssselector",30);	

	
		webEle=findEle(driver,logOut,"cssselector");
		executor3.executeScript("arguments[0].click();",webEle);
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
 			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
	 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
	
		System.out.println("Requst COmpleted ");	
		
	 			
			
			
			
			
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
