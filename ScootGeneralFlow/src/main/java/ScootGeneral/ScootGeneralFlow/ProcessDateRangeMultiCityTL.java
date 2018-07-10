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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;






































import pack.base.TestBaseSetup;

public class ProcessDateRangeMultiCityTL extends TestBaseSetup {
	
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

	String tab="(//button[starts-with(@id,'tab-')])";
	
	String fareTypeSF="table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(7)";
	String fareTypePublicSF="table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(8)";
	
	String dispFareSF="table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(2)";
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

	String discount2V;
	String totalFare2V,eveFare2V,adultDispFare2V,childDispFare2V,evaluatedTxt2V,discountFareWithPercent2V,discountFare2V,discountPercent2V;
	String discountApplied2V,bookedLoadFactor2V,daysToDepart2V,disPolicyName2V,disMatrixName2V,disMatrixType2V,loadFactorType2V;
	String discount3V;
	String totalFare3V,eveFare3V,adultDispFare3V,childDispFare3V,evaluatedTxt3V,discountFareWithPercent3V,discountFare3V,discountPercent3V;
	String discountApplied3V,bookedLoadFactor3V,daysToDepart3V,disPolicyName3V,disMatrixName3V,disMatrixType3V,loadFactorType3V;

	WebElement wbEle;

	float adultActualF,childActualF,adultNewFareF,childNewFareF;
	float discountF;
	float adultCalculatedDiscountF,childCalculatedDiscountF;
	float adultCalculatedNewFareF,childCalculatedNewFareF;
	float adultActual2F,childActual2F,adultNewFare2F,childNewFare2F;
	float discount2F;
	float adultCalculatedDiscount2F,childCalculatedDiscount2F;
	float adultCalculatedNewFare2F,childCalculatedNewFare2F;
	float adultActual3F,childActual3F,adultNewFare3F,childNewFare3F;
	float discount3F;
	float adultCalculatedDiscount3F,childCalculatedDiscount3F;
	float adultCalculatedNewFare3F,childCalculatedNewFare3F;

	//Static Declatation
	String totalFareSFV,eveFareSFV,dispFareSFV,departDateSFV,currentLFSFV,fareTypeSFV;
	float eveFareSFF;
	float dispFareSFF;
	int loadFactorI,daysToDepartI;

	String totalFareSFV2,eveFareSFV2,dispFareSFV2,departDateSFV2,currentLFSFV2,fareTypeSFV2;
	float eveFareSFF2;
	float dispFareSFF2;
	int loadFactorI2,daysToDepartI2;
	
	String totalFareSFV3,eveFareSFV3,dispFareSFV3,departDateSFV3,currentLFSFV3,fareTypeSFV3;
	float eveFareSFF3;
	float dispFareSFF3;
	int loadFactorI3,daysToDepartI3;

	int firstLk,secondLk,thirdLk;
	private Login login;
	Select select;
	String groupID;
	 
	public ProcessDateRangeMultiCityTL(WebDriver driver) {
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
		 
			findEle(driver,submitBtn,"xpath").click();
			
		 
		}
		
		
		public void checkValidity(){
			 waitExplicitlyByLocator(driver,validityLink,"id",50);
			 //Actions act=new Actions(driver);
			 //act.moveToElement(findEle(driver,validityLink,"id")).build().perform();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].onmouseover()", findEle(driver,validityLink,"id"));

			 
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
			evaluatedTxtV=findEle(driver,evaluatedTxt,"cssselector").getAttribute("value");
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
			
			List<WebElement> li1=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
			try {
			Thread.sleep(2000);
			} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}		
			firstLk=li1.size();		
			
			findEle(driver,tab+"[2]","xpath").sendKeys(Keys.RETURN);	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			 try{
				 waitExplicitlyByLocator(driver,processing,"xpath",5);
	 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
	 	 
				}
			 	catch(TimeoutException e){
			 		System.out.println("Tab 2 Not Loaded");
			 	}
				waitExplicitlyByLocator(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath",30);
				findEle(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath").click();			
				
			

			try {
					Thread.sleep(5000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			 
			
				scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
				System.out.println(scheduleMatrix.size());
				secondLk=scheduleMatrix.size();
				
				js.executeScript("arguments[0].click();", scheduleMatrix.get(firstLk));
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
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
			
		totalFare2V=findEle(driver,totalFare,"cssselector").getText();
		eveFare2V=findEle(driver,eveFare,"id").getText();			
		adultDispFare2V=findEle(driver,adultDispFare,"cssselector").getText();
		childDispFare2V=findEle(driver,childDispFare,"cssselector").getText();
		evaluatedTxt2V=findEle(driver,evaluatedTxt,"cssselector").getAttribute("value");
		discountFareWithPercent2V=findEle(driver,discountFare,"cssselector").getText();

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

		 bookedLoadFactor2V=findEle(driver,bookedLoadFactor,"xpath").getText();
		 daysToDepart2V=findEle(driver,daysToDepart,"xpath").getText();
		 disPolicyName2V=findEle(driver,disPolicyName,"xpath").getText();
		 disMatrixName2V=findEle(driver,disMatrixName,"xpath").getText();
		 disMatrixType2V=findEle(driver,disMatrixType,"xpath").getText(); 
		 loadFactorType2V=findEle(driver,loadFactorType,"xpath").getText(); 
		 discountApplied2V=findEle(driver,discountApplied,"xpath").getText(); 

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
		 System.out.println(adultDispFare2V+"\t"+childDispFare2V+"\t"+evaluatedTxt2V+"\t"+discountFare2V);

		 System.out.println(discountApplied2V+"\t"+bookedLoadFactor2V+"\t"+daysToDepart2V+"\t"+disPolicyName2V+"\t"+disMatrixName2V+"\t"+disMatrixType2V+"\t"+loadFactorType2V);		
		 discountCalculation2();
		}
		catch(TimeoutException e){
			System.out.println("Discount is Not applied for Return");
		}
				
		//===========Third Sector starts
		
		List<WebElement> li2=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
		try {
		Thread.sleep(2000);
		} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}		
		secondLk=li2.size();		
		
		findEle(driver,tab+"[3]","xpath").sendKeys(Keys.RETURN);	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
 	 
			}
		 	catch(TimeoutException e){
		 		System.out.println("Tab 2 Not Loaded");
		 	}
			waitExplicitlyByLocator(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[3]","xpath",30);
			findEle(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[3]","xpath").click();			
			
		

		try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		 
		
			scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
			System.out.println(scheduleMatrix.size());
			thirdLk=scheduleMatrix.size();
			
			js.executeScript("arguments[0].click();", scheduleMatrix.get(secondLk));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
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
		
	totalFare3V=findEle(driver,totalFare,"cssselector").getText();
	eveFare3V=findEle(driver,eveFare,"id").getText();			
	adultDispFare3V=findEle(driver,adultDispFare,"cssselector").getText();
	childDispFare3V=findEle(driver,childDispFare,"cssselector").getText();
	evaluatedTxt3V=findEle(driver,evaluatedTxt,"cssselector").getAttribute("value");
	discountFareWithPercent3V=findEle(driver,discountFare,"cssselector").getText();

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

	 bookedLoadFactor3V=findEle(driver,bookedLoadFactor,"xpath").getText();
	 daysToDepart3V=findEle(driver,daysToDepart,"xpath").getText();
	 disPolicyName3V=findEle(driver,disPolicyName,"xpath").getText();
	 disMatrixName3V=findEle(driver,disMatrixName,"xpath").getText();
	 disMatrixType3V=findEle(driver,disMatrixType,"xpath").getText(); 
	 loadFactorType3V=findEle(driver,loadFactorType,"xpath").getText(); 
	 discountApplied3V=findEle(driver,discountApplied,"xpath").getText(); 

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
	 System.out.println(adultDispFare3V+"\t"+childDispFare3V+"\t"+evaluatedTxt3V+"\t"+discountFare3V);

	 System.out.println(discountApplied3V+"\t"+bookedLoadFactor3V+"\t"+daysToDepart3V+"\t"+disPolicyName3V+"\t"+disMatrixName3V+"\t"+disMatrixType3V+"\t"+loadFactorType3V);		
	 discountCalculation3();
	}
	catch(TimeoutException e){
		System.out.println("Discount is Not applied for Sector 3");
	}
		//===========Third sector ends 
		}

		public void discountCalculation(){
				
			adultActualF=Float.parseFloat(adultDispFareV.substring(adultDispFareV.indexOf("(")+1, adultDispFareV.indexOf("+")));
			childActualF=Float.parseFloat(childDispFareV.substring(childDispFareV.indexOf("(")+1, childDispFareV.indexOf("+")));
			adultNewFareF=Float.parseFloat(adultDispFareV.substring(adultDispFareV.lastIndexOf("(")+1, adultDispFareV.lastIndexOf("+")));
			childNewFareF=Float.parseFloat(childDispFareV.substring(childDispFareV.lastIndexOf("(")+1, childDispFareV.lastIndexOf("+")));
			
			discountFareV=discountFareWithPercentV.substring(0, discountFareWithPercentV.indexOf("(")-1);		 
			discountFareV=discountFareV.replaceAll("[^\\.0123456789]","");
			System.out.println("Test"+discountFareV);
			discountPercentV=discountFareWithPercentV.substring(discountFareWithPercentV.indexOf("("));		//
			discountPercentV=discountPercentV.replaceAll("[^\\.0123456789]","");
			System.out.println("Test 2 "+discountPercentV);
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

	
		 public void discountCalculation2(){
				
				adultActual2F=Float.parseFloat(adultDispFare2V.substring(adultDispFare2V.indexOf("(")+1, adultDispFare2V.indexOf("+")));
				childActual2F=Float.parseFloat(childDispFare2V.substring(childDispFare2V.indexOf("(")+1, childDispFare2V.indexOf("+")));
				adultNewFare2F=Float.parseFloat(adultDispFare2V.substring(adultDispFare2V.lastIndexOf("(")+1, adultDispFare2V.lastIndexOf("+")));
				childNewFare2F=Float.parseFloat(childDispFare2V.substring(childDispFare2V.lastIndexOf("(")+1, childDispFare2V.lastIndexOf("+")));
				
				discountFare2V=discountFareWithPercent2V.substring(0, discountFareWithPercent2V.indexOf("(")-1);		 
				discountFare2V=discountFare2V.replaceAll("[^\\.0123456789]","");
				discountPercent2V=discountFareWithPercent2V.substring(discountFareWithPercent2V.indexOf("("));		//
				discountPercent2V=discountPercent2V.replaceAll("[^\\.0123456789]","");
		
				discount2F=Float.parseFloat(discountApplied2V);
				
				adultCalculatedDiscount2F=(adultActual2F*discount2F)/100;
				//adultCalculatedDiscount2F=(float) Math.round(adultCalculatedDiscount2F);
				childCalculatedDiscount2F=(childActual2F*discount2F)/100;
				//childCalculatedDiscount2F=(float) Math.round(childCalculatedDiscount2F);
				System.out.println("Actual adult "+ adultActual2F);
				System.out.println("Actual child "+ childActual2F);
				
				System.out.println("Displayed adult "+ adultNewFare2F);
				System.out.println("Displayed child "+ childNewFare2F);
				
				System.out.println("Calculated adult Discount "+ adultCalculatedDiscount2F);
				System.out.println("Calculated child Discount"+ childCalculatedDiscount2F);
				
				adultCalculatedNewFare2F=adultActual2F-adultCalculatedDiscount2F;
				childCalculatedNewFare2F=childActual2F-childCalculatedDiscount2F;
				
				System.out.println("Calculated adult New Fare "+ adultCalculatedNewFare2F);
				System.out.println("Calculated child New Fare"+ childCalculatedNewFare2F);


			}
		 public void discountCalculation3(){
				
				adultActual3F=Float.parseFloat(adultDispFare3V.substring(adultDispFare3V.indexOf("(")+1, adultDispFare3V.indexOf("+")));
				childActual3F=Float.parseFloat(childDispFare3V.substring(childDispFare3V.indexOf("(")+1, childDispFare3V.indexOf("+")));
				adultNewFare3F=Float.parseFloat(adultDispFare3V.substring(adultDispFare3V.lastIndexOf("(")+1, adultDispFare3V.lastIndexOf("+")));
				childNewFare3F=Float.parseFloat(childDispFare3V.substring(childDispFare3V.lastIndexOf("(")+1, childDispFare3V.lastIndexOf("+")));
				
				discountFare3V=discountFareWithPercent3V.substring(0, discountFareWithPercent3V.indexOf("(")-1);		 
				discountFare3V=discountFare3V.replaceAll("[^\\.0123456789]","");
				discountPercent3V=discountFareWithPercent3V.substring(discountFareWithPercent3V.indexOf("("));		//
				discountPercent3V=discountPercent3V.replaceAll("[^\\.0123456789]","");
		
				discount3F=Float.parseFloat(discountApplied3V);
				
				adultCalculatedDiscount3F=(adultActual3F*discount3F)/100;
				//adultCalculatedDiscount3F=(float) Math.round(adultCalculatedDiscount3F);
				childCalculatedDiscount3F=(childActual3F*discount3F)/100;
				//childCalculatedDiscount3F=(float) Math.round(childCalculatedDiscount3F);
				System.out.println("Actual adult 3 "+ adultActual3F);
				System.out.println("Actual child 3 "+ childActual3F);
				
				System.out.println("Displayed adult 3 "+ adultNewFare3F);
				System.out.println("Displayed child 3 "+ childNewFare3F);
				
				System.out.println("Calculated adult Discount  3"+ adultCalculatedDiscount3F);
				System.out.println("Calculated child Discount 3 "+ childCalculatedDiscount3F);
				
				adultCalculatedNewFare3F=adultActual3F-adultCalculatedDiscount3F;
				childCalculatedNewFare3F=childActual3F-childCalculatedDiscount3F;
				
				System.out.println("Calculated adult New Fare 3 "+ adultCalculatedNewFare3F);
				System.out.println("Calculated child New Fare 3 "+ childCalculatedNewFare3F);


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
		js1 = (JavascriptExecutor) driver;
		 js1.executeScript("arguments[0].onmouseout()", findEle(driver,eveFare,"id"));
		 try {
			 Thread.sleep(1000);
		 } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
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
		driver.navigate().refresh();
		recall();
		//Second Sector
		/*
		List<WebElement> li1=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
		try {
		Thread.sleep(2000);
		} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}		
		firstLk=li1.size();		
		*/
		findEle(driver,tab+"[2]","xpath").sendKeys(Keys.RETURN);	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
 	 
			}
		 	catch(TimeoutException e){
		 		System.out.println("Tab 2 Not Loaded");
		 	}
			waitExplicitlyByLocator(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath",30);
			findEle(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath").click();			
			
		

		try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		 
		
			scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
			System.out.println(scheduleMatrix.size());
			secondLk=scheduleMatrix.size();
			
			js.executeScript("arguments[0].click();", scheduleMatrix.get(0));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	 
		 
			
			waitExplicitlyByLocator(driver,flightDeatails,"id",30);

			try {
		Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			totalFareSFV2=findEle(driver,totalFare,"cssselector").getText();
			eveFareSFV2=findEle(driver,eveFare,"id").getText();
			adultDispFare2V=findEle(driver,adultDispFare,"cssselector").getText();
			childDispFare2V=findEle(driver,childDispFare,"cssselector").getText();
			departDateSFV2=findEle(driver,departDateSF,"cssselector").getText();
			currentLFSFV2=findEle(driver,currentLFSF,"cssselector").getText();
			loadFactorI2=Integer.parseInt(currentLFSFV2);
			daysToDepartI2=calculateDays(departDateSFV2);	
			
			 JavascriptExecutor js2= (JavascriptExecutor) driver;
			 js2.executeScript("arguments[0].onmouseover()", findEle(driver,eveFare,"id"));
			 try {
				 Thread.sleep(2000);
			 } catch (InterruptedException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
try{
 waitExplicitlyByLocator(driver,fareTypePublicSF,"cssselector",30);
fareTypeSFV2=findEle(driver,fareTypePublicSF,"cssselector").getText();
dispFareSFV2=findEle(driver,dispFareSF,"cssselector").getText();			
}catch(TimeoutException e){
	System.out.println("Static Fare is applied");
	waitExplicitlyByLocator(driver,fareTypeSF,"cssselector",30);
	fareTypeSFV2=findEle(driver,fareTypeSF,"cssselector").getText();
	dispFareSFV2=findEle(driver,dispFareSF,"cssselector").getText();			

}
//js2 = (JavascriptExecutor) driver;
//js2.executeScript("arguments[0].onmouseout()", findEle(driver,eveFare,"id"));
try {
	 Thread.sleep(1000);
} catch (InterruptedException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
}			 
findEle(driver,closeFlightDeails,"xpath").click();

System.out.println(totalFareSFV2+"\t"+eveFareSFV2+"\t"+adultDispFare2V+"\t"+childDispFare2V+"\t"+dispFareSFV2+"\t"+departDateSFV2+"\t"+currentLFSFV2+"\t"+fareTypeSFV2);
System.out.println("no of days to depart "+daysToDepartI2);
System.out.println("current load factor "+loadFactorI2);
saticFareCalculation2();
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
driver.navigate().refresh();
recall();

/*
List<WebElement> li2=driver.findElements(By.xpath(flightScheduleMtrixCheckBox));
try {
Thread.sleep(2000);
} catch (InterruptedException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}		
secondLk=li2.size();		
*/
findEle(driver,tab+"[3]","xpath").sendKeys(Keys.RETURN);	
try {
	Thread.sleep(1000);
} catch (InterruptedException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
 try{
	 waitExplicitlyByLocator(driver,processing,"xpath",5);
		 waitExplicitlyNotByLocator(driver,processing,"xpath",120);

	}
 	catch(TimeoutException e){
 		System.out.println("Tab 2 Not Loaded");
 	}
	waitExplicitlyByLocator(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath",30);
	findEle(driver,"("+selectFlightImage+"1"+selectFlightImage2+")[2]","xpath").click();			
	


try {
		Thread.sleep(5000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
 

	scheduleMatrix=driver.findElements(By.xpath(flightScheduleMtrixVerify));
	System.out.println(scheduleMatrix.size());
	//thirdLk=scheduleMatrix.size();
	
	js.executeScript("arguments[0].click();", scheduleMatrix.get(0));
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}	 
 
	
	waitExplicitlyByLocator(driver,flightDeatails,"id",30);

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	totalFareSFV3=findEle(driver,totalFare,"cssselector").getText();
	eveFareSFV3=findEle(driver,eveFare,"id").getText();
	adultDispFare3V=findEle(driver,adultDispFare,"cssselector").getText();
	childDispFare3V=findEle(driver,childDispFare,"cssselector").getText();
	departDateSFV3=findEle(driver,departDateSF,"cssselector").getText();
	currentLFSFV3=findEle(driver,currentLFSF,"cssselector").getText();
	loadFactorI3=Integer.parseInt(currentLFSFV3);
	daysToDepartI3=calculateDays(departDateSFV3);	
	
	 JavascriptExecutor js3= (JavascriptExecutor) driver;
	 js3.executeScript("arguments[0].onmouseover()", findEle(driver,eveFare,"id"));
	 try {
		 Thread.sleep(2000);
	 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 }
try{
waitExplicitlyByLocator(driver,fareTypePublicSF,"cssselector",30);
fareTypeSFV3=findEle(driver,fareTypePublicSF,"cssselector").getText();
dispFareSFV3=findEle(driver,dispFareSF,"cssselector").getText();			
}catch(TimeoutException e){
System.out.println("Static Fare is applied");
waitExplicitlyByLocator(driver,fareTypeSF,"cssselector",30);
fareTypeSFV3=findEle(driver,fareTypeSF,"cssselector").getText();
dispFareSFV3=findEle(driver,dispFareSF,"cssselector").getText();			

}
	 
findEle(driver,closeFlightDeails,"xpath").click();

System.out.println(totalFareSFV3+"\t"+eveFareSFV3+"\t"+adultDispFare3V+"\t"+childDispFare3V+"\t"+dispFareSFV3+"\t"+departDateSFV3+"\t"+currentLFSFV3+"\t"+fareTypeSFV3);
System.out.println("no of days to depart "+daysToDepartI3);
System.out.println("current load factor "+loadFactorI3);
saticFareCalculation3();
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
//TODO Auto-generated catch block
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
		public void saticFareCalculation2(){
			adultActual2F=Float.parseFloat(adultDispFare2V.substring(adultDispFare2V.indexOf("(")+1, adultDispFare2V.indexOf("+")));
			childActual2F=Float.parseFloat(childDispFare2V.substring(childDispFare2V.indexOf("(")+1, childDispFare2V.indexOf("+")));
		
			dispFareSFF2=Float.parseFloat(dispFareSFV2);


			System.out.println("Actual Fare" + adultActual2F);
			System.out.println("Displayed Disp Fare" + dispFareSFF2);

			
			 
		}
		public void saticFareCalculation3(){
			adultActual2F=Float.parseFloat(adultDispFare2V.substring(adultDispFare2V.indexOf("(")+1, adultDispFare2V.indexOf("+")));
			childActual2F=Float.parseFloat(childDispFare2V.substring(childDispFare2V.indexOf("(")+1, childDispFare2V.indexOf("+")));
		
			dispFareSFF2=Float.parseFloat(dispFareSFV3);


			System.out.println("Actual Fare" + adultActual2F);
			System.out.println("Displayed Disp Fare" + dispFareSFF2);

			
			 
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
		
		public void recall(){
			waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
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
			findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
			try{
		 		
				waitExplicitlyByLocator(driver,processing,"xpath",5);
	 			  waitExplicitlyNotByLocator(driver,processing,"xpath",1000);
		 			}
			 	catch(TimeoutException e){
			 		System.out.println("Before conform Processing is not displayed");
			 	}
			 waitExplicitlyByLocator(driver,validityLink,"id",60);

			
		}
	
	}
