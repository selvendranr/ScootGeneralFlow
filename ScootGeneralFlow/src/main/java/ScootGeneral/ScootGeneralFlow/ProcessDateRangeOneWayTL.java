package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;







































import pack.base.TestBaseSetup;

public class ProcessDateRangeOneWayTL extends TestBaseSetup {
	
protected WebDriver driver;


String requestWindowFirst="requestDetailsGrid";
String response="a[title='Response']";
String process="li[class='processDashBoard']";
String inputID = "input[name=requestId]";
String searchBtn = "button[class=x-btn-center]";


String processImage="tbody tr:nth-of-type(2) td:nth-of-type(15)>div>img";
String processImagep1= "//td[div='GRP";
String processImagep2= "']/following-sibling::td[15]/div/img";
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

	String getVal="div[id=paymentValidity-bodyEl] input";
	String paymentPecent="div[id='paymentPercentage-bodyEl']>input";
	String getVal2="div[id=paymentValidity0-bodyEl] input";
	String addImage="div[id='displayPercent'] + div + img";
	String updateValidity="//span[contains(text(),'Update')]/..";


	String cancelPolicy="Cancellation policy";
	String cancelLabel="div[id='cancelPolicy-bodyEl']>div>div>div>div>div>label";
	String cancelInput="div[id='cancelPolicy-bodyEl']>div>div>div>div>div>input";
	String submitBtn="//span[text()='Submit']/..";
	
	String validityLink="groupLevelValidityLink";   //ID
	String policyName="#viewTransactionHistoryWindow+div+div+div+div>table tr:first-of-type th";
	String fareValitity="#viewTransactionHistoryWindow+div+div+div+div>table tr:nth-of-type(2) th";
	String paymentValitity="#viewTransactionHistoryWindow+div+div+div+div>table tr:nth-of-type(3) th";
	String nameListValitity="#viewTransactionHistoryWindow+div+div+div+div>table tr:last-of-type th";
	String closeCancel="//span[text()='Cancellation policy']/../following-sibling::div/img";

	//String closeBtn="#viewTransactionHistoryWindow>div:first-of-type>div>div>div:last-of-type>img";		
	//String discountColumn="/../../preceding-sibling::td[4]/div";
	
	String flightDeatails="showFlightDetailsId";//id
	String totalFare="#dispTotalFare-bodyEl>div";
	String eveFare="displacemetFareBreakup";
	String adultDispFare="#displayAdultFare-bodyEl>div";
	String childDispFare="#displayAdultFare-bodyEl>div";
	String evaluatedTxt="#baseFare-bodyEl>input";
	String discountFare="#displayDiscount-bodyEl>div";
	String discountDeatails="Discount details";
	String remarks="#dispFareRemark-bodyEl>textarea";
	String viewDiscountPolicy="viewDiscountPolicyDetailsWindow";
	String discountApplied="//div[starts-with(@style,'background-color:')]";
	String bookedLoadFactor="//label[text()='Calculated booked load factor:']/following-sibling::div[1]/div";
	String daysToDepart="//label[text()='Calculated booked load factor:']/../preceding-sibling::div[1]/div[1]/div";
	String disPolicyName="//label[text()='Policy name:']/following-sibling::div[1]/div";
	String disMatrixName="//label[text()='Matrix name:']/following-sibling::div[1]/div";
	String disMatrixType="//label[text()='Matrix type:']/following-sibling::div[1]/div";
	String loadFactorType="//label[text()='Load factor type:']/following-sibling::div[1]/div";
	
	String closeDiscountDetails="//span[text()='Discount details']/../following-sibling::div/img";
	String closeFlightDeails="//span[text()='Flight schedule details']/../following-sibling::div/img";
	String closeRequstHist="//span[contains(text(),'View group request history')]/../following-sibling::div/img";

	String selectFlightImage="//td[div='";
	String selectFlightImage2="']/following-sibling::td[12]/div/div";	
	String flightScheduleMtrixVerify="//a/span[starts-with(@id,'selectedFlightMatrixText')]";
	String flightScheduleMtrixCheckBox="//span/input[starts-with(@id,'CHECK_selectedFlights_')]";
	String submitSD="//span[contains(text(),'Submit')]/..";

	
	String fareTypeSF="table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(7)";
	String fareTypePublicSF="table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(8)";
	
	String dispFareSF="table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(2)";
	//String staticFareSF="div[class='popover-content']>div>span:nth-of-type(2)";
	//String bitPriceSF="div[class='popover-content']>div>span:last-of-type";
	String departDateSF="#selectedFlightGrid-body>div>table tr:nth-of-type(2) td:nth-of-type(5)";
	String currentLFSF="#selectedFlightGrid-body>div>table tr:nth-of-type(2) td:nth-of-type(10)";
	

	

	
	String okAtrerApprove="//span[.='OK']";
	
	String logOut="a[class=logout]";
	
	String allPassenger,paymentValidity;
	String groupId,groupName,requestType,requestorName,requestDate;
	String expFareV,flightNoV,originV,destV,requestedFareV;
	
	String cancelPolicyNameV;
	
	String policyNameV,fareValitityV,paymentValitityV,nameListValitityV;

	String discountV;
	String totalFareV,eveFareV,adultDispFareV,childDispFareV,evaluatedTxtV,discountFareWithPercentV,discountFareV,discountPercentV;
	String discountAppliedV,bookedLoadFactorV,daysToDepartV,disPolicyNameV,disMatrixNameV,disMatrixTypeV,loadFactorTypeV;
	String totalFareSFV,eveFareSFV,adultDispFareSFV,childDispFareSFV,dispFareSFV,departDateSFV,currentLFSFV,fareTypeSFV;
	
	WebElement wbEle;

	float adultActualF,childActualF,adultNewFareF,childNewFareF;
	float discountF;
	float adultCalculatedDiscountF,childCalculatedDiscountF;
	float adultCalculatedNewFareF,childCalculatedNewFareF;

	float eveFareSFF;
	float dispFareSFF;

	int loadFactorI,daysToDepartI;

	private Login login;
	Select select;
	String groupID;
	 
	public ProcessDateRangeOneWayTL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void processSeriesRequest(String groupID,String policyType) throws IOException {
		
		groupID=groupID.replaceAll("[^\\.0123456789]","");
		this.groupID=groupID;
		login=new Login(driver);
		login.doLogin(3);
		
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
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
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",15);
	 		  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
	 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
		System.out.println("Series Group Request Processsing is started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,inputID,"cssselector",30);
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,inputID,"cssselector").sendKeys(groupID);
		
		
		findEle(driver,searchBtn,"cssselector").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
 			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
 		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Search Processing is not displayed");
		 	}
	



		waitExplicitlyByLocator(driver,processImage,"cssselector",30);
	//	allPassenger=findEle(driver,processImagep1+groupID+passengerDetails,"xpath").getText();
	 
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
		
		
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
		 	groupName=findEle(driver,grpName,"xpath").getText();
			requestorName=findEle(driver,reqName,"xpath").getText();
		 	 
		 		try{
		 			 waitExplicitlyByLocator(driver,toRunBatch,"linktext",50);

		 	}
				 	catch(TimeoutException e){
				 		System.out.println("Run Batch is not displayed is not displayed");
				 	}

		 		
				policyType=policyType.toUpperCase();
				
				switch(policyType){
				
				case "TIMELINEMATRIX":
					checkValidity();
					break;
				
				case "CANCEL":
					checkCancelPolicy();
					break;
					
				case "DISCOUNT":
					checkDiscountPolicy();
					break;
				case "STATICFARE":
					checkStaticPolicy();
					break;


				default:
					System.out.println("Invalid Policy");
				}
				//System.out.println( policyNameV+"\n"+fareValitityV+"\n"+paymentValitityV+"\n"+nameListValitityV);

				 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 findEle(driver,closeRequstHist,"xpath").click(); 

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				waitExplicitlyByLocator(driver,logOut,"cssselector",30);	

			
				 findEle(driver,logOut,"cssselector").click();;
			 
				try{
					 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
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
		
	
		

		public void checkCancelPolicy(){
			
			 waitExplicitlyByLocator(driver,cancelPolicy,"linktext",50);
			findEle(driver,cancelPolicy,"linktext").click();
			
			 waitExplicitlyByLocator(driver,cancelInput,"cssselector",50);
			List<WebElement> checkBox=driver.findElements(By.cssSelector(cancelInput));
			List<WebElement> checkBoxLabel=driver.findElements(By.cssSelector(cancelLabel));
			boolean value[]=new boolean[5];
			
			for(int i=0;i<checkBox.size();i++){
				value[i]=Boolean.parseBoolean(checkBox.get(i).getAttribute("aria-checked"));
				 
				if(value[i]){
					System.out.println("is Selected  "+i+"      "+value[i]);
					 
				}
			}
		 
			for(int i=0;i<checkBoxLabel.size();i++){
				
				if(value[i]){
				System.out.println("is Selected"+i+checkBoxLabel.get(i).getText());
				cancelPolicyNameV=checkBoxLabel.get(i).getText();
				}
			}
		 

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			findEle(driver,closeCancel,"xpath").click();			
		 
		}
		
		
		public void checkValidity(){
			 waitExplicitlyByLocator(driver,validityLink,"id",50);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].onmouseover()", findEle(driver,validityLink,"id"));

			 
			// Actions act=new Actions(driver);
			// act.moveToElement(findEle(driver,validityLink,"id")).build().perform();
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 System.out.println("Test"+findEle(driver,policyName,"cssselector").isDisplayed());
			 policyNameV=findEle(driver,policyName,"cssselector").getText();
			 fareValitityV=findEle(driver,fareValitity,"cssselector").getText();
			 paymentValitityV=findEle(driver,paymentValitity,"cssselector").getText();
			 nameListValitityV=findEle(driver,nameListValitity,"cssselector").getText();
			// act.release(findEle(driver,validityLink,"id")).perform();   
			  

			
		 
		}
		
		
		public void checkDiscountPolicy(){
			
		Actions act;
		 	try{
	 			 waitExplicitlyByLocator(driver,toRunBatch,"linktext",5);
				 findEle(driver,toRunBatch,"linktext").click();
				 waitExplicitlyByLocator(driver,information,"xpath",6000);
 					System.out.println(findEle(driver,information,"xpath").getText());
				  	 waitExplicitlyByLocator(driver,informationBtn,"xpath",10);
				 	findEle(driver,informationBtn,"xpath").click();

				 	}
			 	catch(TimeoutException e){
			 		System.out.println("Run Batch is not displayed is not displayed");
			 	}
			
			 
			 findEle(driver,closeRequstHist,"xpath").click();
			
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
							
			 waitExplicitlyByLocator(driver,validityLink,"id",60);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 waitExplicitlyByLocator(driver,selectFlightImage+"1"+selectFlightImage2,"xpath",30);
			findEle(driver,selectFlightImage+"1"+selectFlightImage2,"xpath").click();


			
	waitExplicitlyByLocator(driver,"("+flightScheduleMtrixVerify+")[1]","xpath",30);
			
			List<WebElement> scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
			System.out.println(scheduleMatrix.size());
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", scheduleMatrix.get(0));
			try{
		 		
				waitExplicitlyByLocator(driver,processing,"xpath",5);
	 			  waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
	 				}
			 	catch(TimeoutException e){
			 		System.out.println("Flight Window is not displayed");
			 	}

			 waitExplicitlyByLocator(driver,flightDeatails,"id",30);

					try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
			
			
			try {
				
				 waitExplicitlyByLocator(driver,discountDeatails,"linktext",5);
				
			totalFareV=findEle(driver,totalFare,"cssselector").getText();
			eveFareV=findEle(driver,eveFare,"id").getText();			
			adultDispFareV=findEle(driver,adultDispFare,"cssselector").getText();
			childDispFareV=findEle(driver,childDispFare,"cssselector").getText();
			evaluatedTxtV=findEle(driver,evaluatedTxt,"cssselector").getText();
			discountFareWithPercentV=findEle(driver,discountFare,"cssselector").getText();

			act=new Actions(driver);
			act.moveToElement(findEle(driver,discountDeatails,"linktext")).doubleClick().build().perform();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 waitExplicitlyByLocator(driver,viewDiscountPolicy,"id",60);
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			 bookedLoadFactorV=findEle(driver,bookedLoadFactor,"xpath").getText();
			 daysToDepartV=findEle(driver,daysToDepart,"xpath").getText();
			 disPolicyNameV=findEle(driver,disPolicyName,"xpath").getText();
			 disMatrixNameV=findEle(driver,disMatrixName,"xpath").getText();
			 disMatrixTypeV=findEle(driver,disMatrixType,"xpath").getText(); 
			 loadFactorTypeV=findEle(driver,loadFactorType,"xpath").getText(); 
			 discountAppliedV=findEle(driver,discountApplied,"xpath").getText(); 

			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 findEle(driver,closeDiscountDetails,"xpath").click();
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 findEle(driver,closeFlightDeails,"xpath").click();
			 System.out.println(adultDispFareV+"\t"+childDispFareV+"\t"+evaluatedTxtV+"\t"+discountFareV);

			 System.out.println(discountAppliedV+"\t"+bookedLoadFactorV+"\t"+daysToDepartV+"\t"+disPolicyNameV+"\t"+disMatrixNameV+"\t"+disMatrixTypeV+"\t"+loadFactorTypeV);		
			 discountCalculation();
			}
			catch(TimeoutException e){
				System.out.println("Discount is NA");
			}
			
		}

		public void discountCalculation(){
				
			adultActualF=Float.parseFloat(adultDispFareV.substring(adultDispFareV.indexOf("(")+1, adultDispFareV.indexOf("+")));
			childActualF=Float.parseFloat(childDispFareV.substring(childDispFareV.indexOf("(")+1, childDispFareV.indexOf("+")));
			adultNewFareF=Float.parseFloat(adultDispFareV.substring(adultDispFareV.lastIndexOf("(")+1, adultDispFareV.lastIndexOf("+")));
			childNewFareF=Float.parseFloat(childDispFareV.substring(childDispFareV.lastIndexOf("(")+1, childDispFareV.lastIndexOf("+")));
			
			discountFareV=discountFareWithPercentV.substring(0, discountFareWithPercentV.indexOf("(")-1);		 
			discountFareV=discountFareV.replaceAll("[^\\.0123456789]","");
			discountPercentV=discountFareWithPercentV.substring(discountFareWithPercentV.indexOf("("));		//
			discountPercentV=discountPercentV.replaceAll("[^\\.0123456789]","");
	
			discountF=Float.parseFloat(discountAppliedV);
			
			adultCalculatedDiscountF=(adultActualF*discountF)/100;
			//adultCalculatedDiscountF=(float) Math.round(adultCalculatedDiscountF);
			childCalculatedDiscountF=(childActualF*discountF)/100;
			//childCalculatedDiscountF=(float) Math.round(childCalculatedDiscountF);
			System.out.println("Actual adult "+ adultActualF);
			System.out.println("Actual child "+ childActualF);
			
			System.out.println("Displayed adult "+ adultNewFareF);
			System.out.println("Displayed child "+ childNewFareF);
			
			System.out.println("Calculated adult Discount "+ adultCalculatedDiscountF);
			System.out.println("Calculated child Discount"+ childCalculatedDiscountF);
			
			adultCalculatedNewFareF=adultActualF-adultCalculatedDiscountF;
			childCalculatedNewFareF=childActualF-childCalculatedDiscountF;
			
			System.out.println("Calculated adult New Fare "+ adultCalculatedNewFareF);
			System.out.println("Calculated child New Fare"+ childCalculatedNewFareF);


		}

	
		public void checkStaticPolicy(){

			
		 
			 	try{
		 			 waitExplicitlyByLocator(driver,toRunBatch,"linktext",5);
					 findEle(driver,toRunBatch,"linktext").click();
					 waitExplicitlyByLocator(driver,information,"xpath",6000);
	 					System.out.println(findEle(driver,information,"xpath").getText());
					  	 waitExplicitlyByLocator(driver,informationBtn,"xpath",10);
					 	findEle(driver,informationBtn,"xpath").click();

					 	}
				 	catch(TimeoutException e){
				 		System.out.println("Run Batch is not displayed is not displayed");
				 	}
				
				 
				 findEle(driver,closeRequstHist,"xpath").click();
				
				 try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
								
				 waitExplicitlyByLocator(driver,validityLink,"id",60);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 waitExplicitlyByLocator(driver,selectFlightImage+"1"+selectFlightImage2,"xpath",30);
				findEle(driver,selectFlightImage+"1"+selectFlightImage2,"xpath").click();


				
		waitExplicitlyByLocator(driver,"("+flightScheduleMtrixVerify+")[1]","xpath",30);
				
				List<WebElement> scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
				System.out.println(scheduleMatrix.size());
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", scheduleMatrix.get(0));
				try{
			 		
					waitExplicitlyByLocator(driver,processing,"xpath",5);
		 			  waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
		 				}
				 	catch(TimeoutException e){
				 		System.out.println("Flight Window is not displayed");
				 	}

				 waitExplicitlyByLocator(driver,flightDeatails,"id",30);

						try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
						totalFareSFV=findEle(driver,totalFare,"cssselector").getText();
						eveFareSFV=findEle(driver,eveFare,"id").getText();
						adultDispFareV=findEle(driver,adultDispFare,"cssselector").getText();
						childDispFareV=findEle(driver,childDispFare,"cssselector").getText();
						//childDispFareSFV=findEle(driver,childDispFare,"cssselector").getText();
						departDateSFV=findEle(driver,departDateSF,"cssselector").getText();
						currentLFSFV=findEle(driver,currentLFSF,"cssselector").getText();
						loadFactorI=Integer.parseInt(currentLFSFV);
						daysToDepartI=calculateDays(departDateSFV);	
						
						 JavascriptExecutor js1 = (JavascriptExecutor) driver;
						 js1.executeScript("arguments[0].onmouseover()", findEle(driver,eveFare,"id"));
						 try {
							 Thread.sleep(2000);
						 } catch (InterruptedException e) {
							 // TODO Auto-generated catch block
							 e.printStackTrace();
						 }
		try{
			 waitExplicitlyByLocator(driver,fareTypePublicSF,"cssselector",30);
			fareTypeSFV=findEle(driver,fareTypePublicSF,"cssselector").getText();
			dispFareSFV=findEle(driver,dispFareSF,"cssselector").getText();			
			}catch(TimeoutException e){
				System.out.println("Static Fare is applied");
				waitExplicitlyByLocator(driver,fareTypeSF,"cssselector",30);
				fareTypeSFV=findEle(driver,fareTypeSF,"cssselector").getText();
				dispFareSFV=findEle(driver,dispFareSF,"cssselector").getText();			

			}
						 
		 findEle(driver,closeFlightDeails,"xpath").click();

		 System.out.println(totalFareSFV+"\t"+eveFareSFV+"\t"+adultDispFareV+"\t"+childDispFareV+"\t"+dispFareSFV+"\t"+departDateSFV+"\t"+currentLFSFV+"\t"+fareTypeSFV);
		 System.out.println("no of days to depart "+daysToDepartI);
		 System.out.println("current load factor "+loadFactorI);
		 saticFareCalculation();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public void saticFareCalculation(){
			adultActualF=Float.parseFloat(adultDispFareV.substring(adultDispFareV.indexOf("(")+1, adultDispFareV.indexOf("+")));
			childActualF=Float.parseFloat(childDispFareV.substring(childDispFareV.indexOf("(")+1, childDispFareV.indexOf("+")));
			//dispFareSFV=dispFareSFV.substring(dispFareSFV.indexOf(":")+1);
			//dispFareSFV=dispFareSFV.replaceAll("\\s+", "");
			dispFareSFF=Float.parseFloat(dispFareSFV);


			System.out.println("Actual Fare" + adultActualF);
			System.out.println("Displayed Disp Fare" + dispFareSFF);

			
			 
		}

		
		public int calculateDays(String date_s){
			
			int daysDiff;
			Date date1 = null;		
			SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy HH:mm");		 
			Date dNow = new Date( );		  
			  try {
					date1 = dt.parse(date_s);
					System.out.println("days to depart: " + date1 );				
					 System.out.println("todays date : "+dNow );				 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  long diff = date1.getTime() - dNow.getTime();
			  daysDiff=(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			  daysDiff++;
			  System.out.println ("Days: " +daysDiff);	
			  
			  return daysDiff;
		}
		
	}
