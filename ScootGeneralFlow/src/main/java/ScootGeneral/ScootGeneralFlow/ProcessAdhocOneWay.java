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

public class ProcessAdhocOneWay extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String response="a[title='Response']";
	String process="li[class='processDashBoard']";
	String inputID = "input[name=requestId]";
	String searchBtn = "button[class=x-btn-center]";
	String comformBtn="//span[.='Yes']";
	

	String processImage="tbody tr:nth-of-type(2) td:nth-of-type(15)>div>img";
	String processImagep1= "//td[div='GRP";
	String processImagep2= "']/following-sibling::td[15]/div/img";
	//String passengerDetails="']/following-sibling::td[6]/div";
		

	String closeBtn="#viewTransactionHistoryWindow>div:first-of-type>div>div>div:last-of-type>img";		
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	String fareLoad="//a[starts-with(@id,'displayFlightAdultFareBallon')]";
	
	String selectFlightImage="//td[div='1']/following-sibling::td[16]/div/img[@data-qtip='Add flight']";
	String selectedFlightImage="//td[div='1']/following-sibling::td[16]/div/img[@data-qtip='Selected flight']";

	String secondPart="/../../preceding-sibling::td[5]/div";
	String discountColumn="/../../preceding-sibling::td[4]/div";
	
	String fareDeatails="acceptedFareDeatils";//id
	String discountTab="#selectedFlightTabPanelId>div:nth-of-type(2)>div:first-of-type button";
	String adultDispFare="//a[starts-with(@id,'displayAdultFareBallon')]";
	String childDispFare="//a[starts-with(@id,'displayChildFareBallon')]";
	String dispFareEdit="displacementFareEdit";
	String adultNewFare="//div[starts-with(@aria-describedby,'displayAdultNewFare')]";
	String childNewFare="//div[starts-with(@aria-describedby,'displayChildNewFare')]";
	String adultDiscountFare="//label[contains(text(),'Adult Discount')]/following-sibling::div[1]/div";
	String childDiscountFare="//label[contains(text(),'Child Discount')]/following-sibling::div[1]/div";
	String discountDeatails="Discount details";
	String viewDiscountPolicy="viewDiscountPolicyDetailsWindow";
	String discountApplied="//div[starts-with(@style,'background-color:')]";
	String bookedLoadFactor="//label[text()='Calculated booked load factor:']/following-sibling::div[1]/div";
	String daysToDepart="//label[text()='Calculated booked load factor:']/../preceding-sibling::div[1]/div[1]/div";
	String disPolicyName="//label[text()='Policy name:']/following-sibling::div[1]/div";
	String disMatrixName="//label[text()='Matrix name:']/following-sibling::div[1]/div";
	String disMatrixType="//label[text()='Matrix type:']/following-sibling::div[1]/div";
	String loadFactorType="//label[text()='Load factor type:']/following-sibling::div[1]/div";
	
	String closeDiscountDetails="//span[text()='Discount details']/../following-sibling::div/img";
	String closeFareDeails="//span[text()='Fare details']/../following-sibling::div/img";
	String closeRequstHist="//span[contains(text(),'View group request history')]/../following-sibling::div/img";
	
	String fareTypeSF="div[class='popover-content']>div>table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(7)";
	String fareTypePublicSF="div[class='popover-content']>div>table[class='currentChangeRequestBallon'] tr:nth-of-type(2)>td:nth-of-type(6)";
	
	String dispFareSF="div[class='popover-content']>div>span:first-of-type";
	String staticFareSF="div[class='popover-content']>div>span:nth-of-type(2)";
	String bitPriceSF="div[class='popover-content']>div>span:last-of-type";
	String departDateSF="#selectedFlightGrid-body>div>table tr:nth-of-type(2) td:nth-of-type(5)";
	String currentLFSF="/../../preceding-sibling::td[8]/div";
	
	
	
	
	String flightSelected="button[class=x-btn-center]";

	
	String clickOK="button[class=x-btn-center]";
	
	String okAtrerApprove="//span[.='OK']";
	String okAfterSelectFlight="//span[text()='OK']";


	String approveBtn="span[id=approve-btnInnerEl][class=x-btn-inner]";

	String cancelPolicy="Cancellation policy";
	String cancelLabel="div[id='cancelPolicy-bodyEl']>div>div>div>div>div>label";
	String cancelInput="div[id='cancelPolicy-bodyEl']>div>div>div>div>div>input";
	String submitBtn="//span[text()='Submit']/..";
	String closeCancel="//span[text()='Cancellation policy']/../following-sibling::div/img";
	
	String validityLink="validityLink";   //ID
	String policyName="#viewTransactionHistoryWindow+div+div+div+div+div+div>table tr:first-of-type th";
	String fareValitity="#viewTransactionHistoryWindow+div+div+div+div+div+div>table tr:nth-of-type(2) th";
	String paymentValitity="#viewTransactionHistoryWindow+div+div+div+div+div+div>table tr:nth-of-type(3) th";
	String nameListValitity="#viewTransactionHistoryWindow+div+div+div+div+div+div>table tr:last-of-type th";
	
	
	String grpId="//label[contains(text(),'Request id :')]/following-sibling::div[1]/div";
	String grpName="//label[contains(text(),'Group name :')]/following-sibling::div[1]/div";
	String reqName="//label[contains(text(),'Requestor name:')]/following-sibling::div[1]/div";
	String reqType="//label[contains(text(),'Request type :')]/following-sibling::div[1]/div";
	String tripType="//label[contains(text(),'Trip type :')]/following-sibling::div[1]/div";
	String reqDate="//label[contains(text(),'Requested date:')]/following-sibling::div[1]/div";

	String logOut="a[class=logout]";
	

	String groupId,groupName,requestorName,requestTYpe,tripTypeV;
	
	String cancelPolicyNameV;
	
	String policyNameV,fareValitityV,paymentValitityV,nameListValitityV;
	String discountV;
	String adultDispFareV,childDispFareV,adultNewFareV,childNewFareV,adultDiscountFareV,childDiscountFareV;
	String discountAppliedV,bookedLoadFactorV,daysToDepartV,disPolicyNameV,disMatrixNameV,disMatrixTypeV,loadFactorTypeV;

	String fareTypeSFV,dispFareSFV,staticFareSFV,bitPriceSFV,departDateSFV;
	String loadFactorV;
	
	WebElement wbEle;	
	
	float adultActualF,childActualF,adultNewFareF,childNewFareF,adultDiscountF,childDiscountF;
	float discountF;
	float adultCalculatedDiscountF,childCalculatedDiscountF;
	float adultCalculatedNewFareF,childCalculatedNewFareF;
	float dispFareSFF,staticFareSFF,bitPriceSFF;

	int loadFactorI,daysToDepartI;
	private Login login;
 	Select select;
 	public ProcessAdhocOneWay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void processAdHocRequest(String groupID,String policyType) throws IOException {
		
		groupID=groupID.replaceAll("[^\\.0123456789]","");
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
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",50);
		 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
		 	 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Logout Processing is not displayed");
		 	}
		System.out.println("Adhoc One Way Group Request Processsing is started");
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
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
	//	allPassenger=findEle(driver,processImagep1+groupID+passengerDetails,"xpath").getText();
	 
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
	 		
			waitExplicitlyByLocator(driver,processing,"xpath",15);
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
			 waitExplicitlyByLocator(driver,processing,"xpath",15);
	 		  waitExplicitlyNotByLocator(driver,processing,"xpath",500);
	 			 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Conform Processing is not displayed");
		 	}
		
		groupId=findEle(driver,grpId,"xpath").getText();
		groupName=findEle(driver,grpName,"xpath").getText();
		requestorName=findEle(driver,reqName,"xpath").getText();
		requestTYpe=findEle(driver,reqType,"xpath").getText();
		tripTypeV=findEle(driver,tripType,"xpath").getText();
		
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
	
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 findEle(driver,closeRequstHist,"xpath").click();
	 
		// Actions act = new Actions(driver);
		 //act.moveToElement(findEle(driver,closeBtn,"cssselector")).click().build().perform();
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		/*


		findEle(driver,selectFlightImage+secondPart,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,processing,"xpath",50);
 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
			 waitExplicitlyByLocator(driver,selectFlightImage+secondPart+fareLoad,"xpath",10);
	 
			}
		 	catch(TimeoutException e){
		 		System.out.println("Fare Already Loaded");
		 	}
		 
		
		
		  
		  
		  try {
		Thread.sleep(1000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		
		waitExplicitlyByLocator(driver,selectFlightImage,"xpath",30);
		
		findEle(driver,selectFlightImage,"xpath").click();
		
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
		if(isAlertPresentDismiss())
		{
			System.out.println("alertpresent and Dismissed");
		}
		else
		{
			System.out.println("Alert Not Present");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(isAlertPresent())
		{
			System.out.println("alertpresent and Dismissed");
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
	
		waitExplicitlyByLocator(driver,okAtrerApprove,"xpath",120);		
		webEle=findEle(driver,okAtrerApprove,"xpath");
		executor3.executeScript("arguments[0].click();",webEle);
		
		*/
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

		
		System.out.println( policyNameV+"\n"+fareValitityV+"\n"+paymentValitityV+"\n"+nameListValitityV);

	}
	
	
	public void checkValidity(){
		 waitExplicitlyByLocator(driver,validityLink,"id",50);
		 //Actions act=new Actions(driver);
		// act.moveToElement(findEle(driver,validityLink,"id")).build().perform();
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
		  

		
			System.out.println( policyNameV+"\n"+fareValitityV+"\n"+paymentValitityV+"\n"+nameListValitityV);

	}
	

	
	public void checkDiscountPolicy(){
		Actions act;	
		 waitExplicitlyByLocator(driver,selectFlightImage,"xpath",120);
		findEle(driver,selectFlightImage+secondPart,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
	 
			}
		 	catch(TimeoutException e){
		 		System.out.println("Process Bar is not displayed ");
		 	}
		try{
		 waitExplicitlyByLocator(driver,selectFlightImage+secondPart+"/a","xpath",120);
		}
	 	catch(TimeoutException e){
	 		System.out.println("Fare is not Loaded  ");
	 	}
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,selectFlightImage,"xpath").click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discountV=findEle(driver,selectedFlightImage+discountColumn,"xpath").getText();
		if(discountV.contains("%")){
		act=new Actions(driver);
		act.moveToElement(findEle(driver,selectedFlightImage+secondPart+fareLoad,"xpath")).doubleClick().build().perform();
		//WebElement webEle=findEle(driver,selectedFlightImage+secondPart+fareLoad,"xpath");
		//doubleClick(webEle);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 waitExplicitlyByLocator(driver,fareDeatails,"id",60);
		findEle(driver,discountTab,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adultDispFareV=findEle(driver,adultDispFare,"xpath").getText();
		childDispFareV=findEle(driver,childDispFare,"xpath").getText();
		adultNewFareV=findEle(driver,adultNewFare,"xpath").getText();
		childNewFareV=findEle(driver,childNewFare,"xpath").getText();
		adultDiscountFareV=findEle(driver,adultDiscountFare,"xpath").getText(); 
		childDiscountFareV=findEle(driver,childDiscountFare,"xpath").getText(); 
		childDiscountFareV=findEle(driver,childDiscountFare,"xpath").getText(); 
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
		 findEle(driver,closeFareDeails,"xpath").click();
		 System.out.println(adultDispFareV+"\t"+childDispFareV+"\t"+adultNewFareV+"\t"+childNewFareV+"\t"+adultDiscountFareV+"\t"+childDiscountFareV);

		 System.out.println(discountAppliedV+"\t"+bookedLoadFactorV+"\t"+daysToDepartV+"\t"+disPolicyNameV+"\t"+disMatrixNameV+"\t"+disMatrixTypeV+"\t"+loadFactorTypeV);		
		 discountCalculation();
		}
		else {
			System.out.println("Discount is NA");
		}
		
	}
	
	
	public void checkStaticPolicy(){
		Actions act;	
		 waitExplicitlyByLocator(driver,selectFlightImage,"xpath",120);
		findEle(driver,selectFlightImage+secondPart,"xpath").click();
		try{
			 waitExplicitlyByLocator(driver,processing,"xpath",5);
 			 waitExplicitlyNotByLocator(driver,processing,"xpath",120);
	 
			}
		 	catch(TimeoutException e){
		 		System.out.println("Process Bar is not displayed ");
		 	}
		try{
		 waitExplicitlyByLocator(driver,selectFlightImage+secondPart+"/a","xpath",120);
		}
	 	catch(TimeoutException e){
	 		System.out.println("Fare is not Loaded  ");
	 	}
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,selectFlightImage,"xpath").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadFactorV=findEle(driver,selectedFlightImage+currentLFSF,"xpath").getText();
		loadFactorI=Integer.parseInt(loadFactorV);
		act=new Actions(driver);
		act.moveToElement(findEle(driver,selectedFlightImage+secondPart+fareLoad,"xpath")).doubleClick().build().perform();
		//WebElement webEle=findEle(driver,selectedFlightImage+secondPart+fareLoad,"xpath");
		//doubleClick(webEle);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		act.moveToElement(findEle(driver,selectedFlightImage+secondPart+fareLoad,"xpath")).release();
		 waitExplicitlyByLocator(driver,fareDeatails,"id",60);
		findEle(driver,discountTab,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		adultDispFareV=findEle(driver,adultDispFare,"xpath").getText();
		childDispFareV=findEle(driver,childDispFare,"xpath").getText();
		//findEle(driver,dispFareEdit,"name").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Point coordinates=findEle(driver,adultDispFare,"xpath").getLocation();
		// try {
		 //	Robot robot = new Robot();
		 //	robot.mouseMove(x, y);
		 //	robot.mouseMove(coordinates.x+10,coordinates.y);
		// } catch (AWTException e1) {
		 //TODO Auto-generated catch block
		 	//e1.printStackTrace();
		// }
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].onmouseover()", findEle(driver,adultDispFare,"xpath"));

		// act=new Actions(driver);
		//act.moveToElement(findEle(driver,adultDispFare,"xpath")).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}

		try{
		waitExplicitlyByLocator(driver,fareTypeSF,"cssselector",10);
		fareTypeSFV=findEle(driver,fareTypeSF,"cssselector").getText();
		dispFareSFV=findEle(driver,dispFareSF,"cssselector").getText();
		staticFareSFV=findEle(driver,staticFareSF,"cssselector").getText();
		bitPriceSFV=findEle(driver,bitPriceSF,"cssselector").getText();

		}catch(TimeoutException e){
			System.out.println("Public fare exception e");
			fareTypeSFV=findEle(driver,fareTypePublicSF,"cssselector").getText();
			dispFareSFV=findEle(driver,dispFareSF,"cssselector").getText();
			//staticFareSFV=findEle(driver,staticFareSF,"cssselector").getText();
			bitPriceSFV=findEle(driver,bitPriceSF,"cssselector").getText();

	
		}
		
			departDateSFV=findEle(driver,departDateSF,"cssselector").getText();
		daysToDepartI=calculateDays(departDateSFV);	
		 
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 findEle(driver,closeFareDeails,"xpath").click();
		System.out.println("All the values are");
		System.out.println( fareTypeSFV+"\t"+dispFareSFV+"\t"+staticFareSFV+"\t"+bitPriceSFV+"\t"+departDateSFV+"\t"+loadFactorV);
		System.out.println(loadFactorI+"\t"+daysToDepartI);
		
		saticFareCalculation();
	}

	
	
/*	
	public void doubleClick(WebElement element) {
		try {
			Actions action = new Actions(driver).doubleClick(element);
			action.build().perform();

			System.out.println("Double clicked the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable "
					+ e.getStackTrace());
		}
	}
	*/
	
	
	public void discountCalculation(){
			
		adultActualF=Float.parseFloat(adultDispFareV.substring(adultDispFareV.indexOf("(")+1, adultDispFareV.indexOf("+")));
		childActualF=Float.parseFloat(childDispFareV.substring(childDispFareV.indexOf("(")+1, childDispFareV.indexOf("+")));
		adultNewFareF=Float.parseFloat(adultNewFareV.substring(adultNewFareV.indexOf("(")+1, adultNewFareV.indexOf("+")));
		childNewFareF=Float.parseFloat(childNewFareV.substring(childNewFareV.indexOf("(")+1, childNewFareV.indexOf("+")));
		adultDiscountF=Float.parseFloat(adultDiscountFareV);		
		childDiscountF=Float.parseFloat(childDiscountFareV);
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
	
	public void saticFareCalculation(){
		adultActualF=Float.parseFloat(adultDispFareV.substring(adultDispFareV.indexOf("(")+1, adultDispFareV.indexOf("+")));
		childActualF=Float.parseFloat(childDispFareV.substring(childDispFareV.indexOf("(")+1, childDispFareV.indexOf("+")));
		dispFareSFV=dispFareSFV.substring(dispFareSFV.indexOf(":")+1);
		dispFareSFV=dispFareSFV.replaceAll("\\s+", "");
		dispFareSFF=Float.parseFloat(dispFareSFV);
		if(staticFareSFV != null && !staticFareSFV.isEmpty()) {
		staticFareSFV=staticFareSFV.substring(staticFareSFV.indexOf(":")+1);
		staticFareSFV=staticFareSFV.replaceAll("\\s+", "");
		staticFareSFF=Float.parseFloat(staticFareSFV);
		}
		bitPriceSFV=bitPriceSFV.substring(bitPriceSFV.indexOf(":")+1);
		bitPriceSFV=bitPriceSFV.replaceAll("\\s+", "");
		bitPriceSFF=Float.parseFloat(bitPriceSFV);

		System.out.println("Actual Fare" + adultActualF);
		System.out.println("Displayed Disp Fare" + dispFareSFF);
		System.out.println("Displayed Static Fare" + staticFareSFF);
		System.out.println("Displayed Bit price Fare" + bitPriceSFF);
				
		 
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

	

