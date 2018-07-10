package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
 




import pack.base.TestBaseSetup;

public class ProcessDateRangeMultiCity extends TestBaseSetup {
	
protected WebDriver driver;
String requestWindowFirst="requestDetailsGrid";
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
 String grpName="//label[contains(text(),'Group name :')]/following-sibling::div[1]/div";
String reqName="//label[contains(text(),'Requestor name:')]/following-sibling::div[1]/div";
String reqType="//label[contains(text(),'Request type :')]/following-sibling::div[1]/div";
String tripType="//label[contains(text(),'Trip type :')]/following-sibling::div[1]/div";
String reqDate="//label[contains(text(),'Requested date:')]/following-sibling::div[1]/div";
	
String comformBtn="//span[.='Yes']";
String toRunBatch="Run batch now";
String information="//div/span[contains(text(),'Series request')]";
String informationBtn="//em/button/span[contains(text(),'OK')]";
String closeBtn="//span[contains(text(),'View group request history')]/../following-sibling::div/img";	
String validityLink="a[id='groupLevelValidityLink']";
String getVal="div[id=paymentValidity-bodyEl] input";
String paymentPecent="div[id='paymentPercentage-bodyEl']>input";
String getVal2="div[id=paymentValidity0-bodyEl] input";
String addImage="div[id='displayPercent'] + div + img";
String updateValidity="//span[contains(text(),'Update')]/..";

	
	String selectFlightImage="//td[div='";
	String selectFlightImage2="']/following-sibling::td[11]/div/div";	
	String totalNoOfPax="//label[contains(text(),'No of pax :')]/following-sibling::div[1]/div";
	String expectedFare="//label[contains(text(),'Expected fare:')]/following-sibling::div[1]/div";
	String origin="//div[@id='showFlightDetailsId-body']/div[2]/div[3]/div/table/tbody/tr[2]/td[2]/div";
	String destination="//div[@id='showFlightDetailsId-body']/div[2]/div[3]/div/table/tbody/tr[2]/td[3]/div";
	String flightNo="(//td[div='1']/following-sibling::td[3]/div[contains(text(),'VX-')])[1]";
	String totalFare="label[id='dispTotalFare-labelEl']+div div";
	String adultFare="label[id='displayAdultFare-labelEl']+div div";
	String childFare="label[id='displayChildFare-labelEl']+div div";
	String infantFare="label[id='displayInfantFare-labelEl']+div div";
	String evaluatedFare="a[id=displacemetFareBreakup]";
	String evaluatedFareAjust="label[id='baseFare-labelEl']+div input";
	String discountPrice="label[id='displayDiscount-labelEl']+div div";
	String flightScheduleMtrixVerify="//a/span[starts-with(@id,'selectedFlightMatrixText')]";
	String flightScheduleMtrixCheckBox="//span/input[starts-with(@id,'CHECK_selectedFlights_')]";

	String selectFlight1P2="//span[contains(text(),'Group 1')]";
	String selectFlight2P2="//span[contains(text(),'Group 2')]";
	String selectFlight3P2="//span[contains(text(),'Group 3')]";


	String selectFlightP2="/../../following-sibling::td//span/input[starts-with(@id,'CHECK_selectedFlights_')]";
		
	String submitSD="//span[contains(text(),'Submit')]/..";
	
	String requestedFare="//label[contains(text(),'Fare requested:')]/following-sibling::div[1]/div";
	String fareEvaluated="label[id=fareEvaluatedId-labelEl]+div div a";
	String fareAdult="label[id=totalFare-labelEl]+div div";
	
	String fareChild="label[id=childTotalFare-labelEl]+div div";
	String fareInfant="label[id=infantTotalFare-labelEl]+div div";
	String approveBtn="span[id=approve-btnInnerEl][class=x-btn-inner]";
	String tab="(//button[starts-with(@id,'tab-')])";
	String groupP1="//span[contains(text(),'Group ";
	String groupP2="')]";

	
	String okAtrerApprove="//span[.='OK']";
	
	String logOut="a[class=logout]";
	
 	String groupId,groupName,requestType,requestorName,requestDate;
	int firstLk,secondLk,thirdLk;
	 
	WebElement wbEle;
	private Login login;
	
 	public ProcessDateRangeMultiCity(WebDriver driver) {
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
			Thread.sleep(2000);
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
		groupId=findEle(driver,grpId,"xpath").getText();
		//groupNameV=findEle(driver,grpName,"xpath").getText();
		 
			try{
			 waitExplicitlyByLocator(driver,toRunBatch,"linktext",50);
			 findEle(driver,toRunBatch,"linktext").click();
		  
 			 waitExplicitlyByLocator(driver,information,"xpath",12000);
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
	
		 waitExplicitlyByLocator(driver,validityLink,"cssselector",60);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* findEle(driver,validityLink,"cssselector").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		 waitExplicitlyByLocator(driver,getVal,"cssselector",10);
		 findEle(driver,getVal,"cssselector").clear();
		 findEle(driver,getVal,"cssselector").sendKeys("1");
		paymentValidity=findEle(driver,getVal,"cssselector").getAttribute("value");
		System.out.println("payment validity"+paymentValidity);
		findEle(driver,paymentPecent,"cssselector").clear();
		findEle(driver,paymentPecent,"cssselector").sendKeys("25");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		findEle(driver,addImage,"cssselector").click();		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		findEle(driver,getVal2,"cssselector").clear();
		findEle(driver,getVal2,"cssselector").sendKeys("1");
		 
		findEle(driver,updateValidity,"xpath").click();	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		*/
		 waitExplicitlyByLocator(driver,selectFlightImage+"1"+selectFlightImage2,"xpath",30);
			findEle(driver,selectFlightImage+"1"+selectFlightImage2,"xpath").click();


		try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		waitExplicitlyByLocator(driver,"("+flightScheduleMtrixVerify+")[1]","xpath",30);
			
		

			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 	
			findEle(driver,tab+"[2]","xpath").sendKeys(Keys.RETURN);	
			
			 try{	 
				 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			  waitExplicitlyNotByLocator(driver,processing,"xpath",500);
	 
			 
			 }
			 	catch(TimeoutException e){
			 		System.out.println("Tab 2 Not Loaded");
			 	}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			waitExplicitlyByLocator(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath",30);
			findEle(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath").click();	

			
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		 
		


		
			findEle(driver,tab+"[3]","xpath").sendKeys(Keys.RETURN);	
			
			 try{	 waitExplicitlyByLocator(driver,processing,"xpath",5);
	 		  waitExplicitlyNotByLocator(driver,processing,"xpath",500);
	 		 }
			 	catch(TimeoutException e){
			 		System.out.println("Tab 3 Not Loaded");
			 	}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			waitExplicitlyByLocator(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[3]","xpath",30);
			findEle(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[3]","xpath").click();			
			
	JavascriptExecutor executor=null;
		
		try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		System.out.println("Tab 3 Start");
		try{
		List<WebElement> group1Test=driver.findElements(By.xpath(selectFlight1P2));
		
		if(group1Test.size()==3){
			List<WebElement> group1=driver.findElements(By.xpath(selectFlight1P2+selectFlightP2));
			//group1.get(2).click();
			executor=(JavascriptExecutor)driver;	 
			 executor.executeScript("arguments[0].click();",group1.get(2));

			
		}else{
			
			System.out.println("Size of Group 1 is 3"+group1Test.size());
		}
		
		}catch(NoSuchElementException e){
			System.out.println("Goup 1 is not present ");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	 try{
	List<WebElement> group2Test=driver.findElements(By.xpath(selectFlight2P2));
	
	if(group2Test.size()==3){
		List<WebElement> group2=driver.findElements(By.xpath(selectFlight2P2+selectFlightP2));
		//group2.get(2).click();
		
		executor=(JavascriptExecutor)driver;	 
		 executor.executeScript("arguments[0].click();",group2.get(2));

		
	}else{
		
		System.out.println("Size of Group 2 is "+group2Test.size());
	}
	
		
	 }catch(NoSuchElementException e){
			System.out.println("Goup 2 is not present ");
		}
	 
	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	 try{
	List<WebElement> group3Test=driver.findElements(By.xpath(selectFlight3P2));
	
	if(group3Test.size()==3){
		List<WebElement> group3=driver.findElements(By.xpath(selectFlight3P2+selectFlightP2));
		executor=(JavascriptExecutor)driver;	 
		 executor.executeScript("arguments[0].click();",group3.get(2));
		
	}else{
		
		System.out.println("Size of Group 3 is "+group3Test.size());
	}
	
		
	 }catch(NoSuchElementException e){
			System.out.println("Goup 3 is not present ");
		}
	 
	 System.out.println("Tab 3 End");
	 
		findEle(driver,tab+"[1]","xpath").sendKeys(Keys.RETURN); 
	 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 System.out.println("Tab 1 start");
	try{
	List<WebElement> group1Test=driver.findElements(By.xpath(selectFlight1P2));
	
	if(group1Test.size()==3){
		List<WebElement> group1=driver.findElements(By.xpath(selectFlight1P2+selectFlightP2));
		//group1.get(0).click();
		executor=(JavascriptExecutor)driver;	 
		 executor.executeScript("arguments[0].click();",group1.get(0));

	}else{
		
		System.out.println("Size of Group 1 is "+group1Test.size());
	}
	
	}catch(NoSuchElementException e){
		System.out.println("Goup 1 is not present ");
	}
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
 try{
List<WebElement> group2Test=driver.findElements(By.xpath(selectFlight2P2));

if(group2Test.size()==3){
	List<WebElement> group2=driver.findElements(By.xpath(selectFlight2P2+selectFlightP2));
	//group2.get(0).click();
	executor=(JavascriptExecutor)driver;	 
	 executor.executeScript("arguments[0].click();",group2.get(0));

}else{
	
	System.out.println("Size of Group 1 is "+group2Test.size());
}

	
 }catch(NoSuchElementException e){
		System.out.println("Goup 2 is not present ");
	}
 
 try {
		Thread.sleep(1000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
 try{
List<WebElement> group3Test=driver.findElements(By.xpath(selectFlight3P2));

if(group3Test.size()==3){
	List<WebElement> group3=driver.findElements(By.xpath(selectFlight3P2+selectFlightP2));
	//group3.get(0).click();
	executor=(JavascriptExecutor)driver;	 
	 executor.executeScript("arguments[0].click();",group3.get(0));

}else{
	
	System.out.println("Size of Group 1 is "+group3Test.size());
}

	
 }catch(NoSuchElementException e){
		System.out.println("Goup 3 is not present ");
	}
	
 System.out.println("Tab  1 End ");
	 
	findEle(driver,tab+"[2]","xpath").sendKeys(Keys.RETURN); 
	 
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}

try{
List<WebElement> group1Test=driver.findElements(By.xpath(selectFlight1P2));

if(group1Test.size()==3){
	List<WebElement> group1=driver.findElements(By.xpath(selectFlight1P2+selectFlightP2));
	//group1.get(1).click();
	executor=(JavascriptExecutor)driver;	 
	 executor.executeScript("arguments[0].click();",group1.get(1));
	
}else{
	
	System.out.println("Size of Group 1 is "+group1Test.size());
}

}catch(NoSuchElementException e){
	System.out.println("Goup 1 is not present ");
}

try {
	Thread.sleep(1000);
} catch (InterruptedException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
try{
List<WebElement> group2Test=driver.findElements(By.xpath(selectFlight2P2));

if(group2Test.size()==3){
List<WebElement> group2=driver.findElements(By.xpath(selectFlight2P2+selectFlightP2));
//group2.get(1).click();
executor=(JavascriptExecutor)driver;	 
executor.executeScript("arguments[0].click();",group2.get(1));


}else{

System.out.println("Size of Group 1 is "+group2Test.size());
}


}catch(NoSuchElementException e){
	System.out.println("Goup 2 is not present ");
}

try {
	Thread.sleep(1000);
} catch (InterruptedException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
try{
List<WebElement> group3Test=driver.findElements(By.xpath(selectFlight3P2));

if(group3Test.size()==3){
List<WebElement> group3=driver.findElements(By.xpath(selectFlight3P2+selectFlightP2));
executor=(JavascriptExecutor)driver;	 
executor.executeScript("arguments[0].click();",group3.get(1));

}else{

System.out.println("Size of Group 1 is "+group3Test.size());
}


}catch(NoSuchElementException e){
	System.out.println("Goup 3 is not present ");
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
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
	 		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Approve Processing is not displayed");
		 	}
		try{
 		waitExplicitlyByLocator(driver,okAtrerApprove,"xpath",120);	
	 
		webEle=findEle(driver,okAtrerApprove,"xpath");
		executor3.executeScript("arguments[0].click();",webEle);
		}catch(TimeoutException e){
			System.out.println("Success message is not displayed ");
 			 
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
			      
			     String s1=a1.getText();
			      System.out.println(s1);
			        if(s1.contains("Do you wish to verify upsell fare?")){
			       a1.dismiss();
			        }else{
			        	 a1.accept();
			        }
			        return true; 
			    }   // try 
			    catch (NoAlertPresentException Ex) 
			    {
			        return false; 
			    }   
		}
		

		
		
		
	}
