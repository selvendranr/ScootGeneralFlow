package ScootGeneral.ScootGeneralFlow;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

 













import pack.base.TestBaseSetup;

public class PaymentApprove extends TestBaseSetup {
	
	protected WebDriver driver;
	String requestWindowFirst="viewPaymentRequestGrid";
	String response="a[title='Response']";
	String processPayment="li[class='paymentRequest']>a";
	String inputID = "requestMasterId";
	String searchBtn = "button[class=x-btn-center]"; 
	 


	 
	String processImagep1= "//td[div='GRP";
	String status="']/following-sibling::td[10]//img";  //data-qtip
	String processImagep2= "']/following-sibling::td[11]//img";
	
	String makePayment="airlinePaymentWindow";

	String paymentInfo="#airlinePaymentForm+div>div:last-of-type tr:last-of-type td:nth-of-type";
	String wireTransfer="//span[text()='Wire transfer']/..";
	String approveBtn="airlineApprovePaymentBtn-btnEl";



	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	String successBtn="//span[text()='OK']/..";
	String logOut="a[class=logout]";

	String statusV;
	String requestIDV,pnrV,noOfGuestV,paymentValidityV,requstedAmountV,totalCostV;
	Select select;
	private Login login;
	
	public PaymentApprove(WebDriver driver) {
		this.driver = driver;
	}
	
	public void approve(String groupID) {

		//driver.navigate().refresh();


		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		groupID=groupID.replaceAll("[^\\.0123456789]","");
		login=new Login(driver);
		login.doLogin(9);
		
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);		
		waitExplicitlyByLocator(driver,response,"cssselector",30);
		findEle(driver,response,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		findEle(driver,processPayment,"cssselector").click();
		
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
		System.out.println("Adhoc One Way Group Request Processsing is started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,inputID,"name",30);
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,inputID,"name").sendKeys(groupID);
		
		
		findEle(driver,searchBtn,"cssselector").click();
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",5);
		 	  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);
		 
		}
		 	catch(TimeoutException e){
		 		System.out.println("After Search Processing is not displayed");
		 	}
	



		waitExplicitlyByLocator(driver,processImagep1+groupID+processImagep2,"xpath",30);
		//	allPassenger=findEle(driver,processImagep1+groupID+passengerDetails,"xpath").getText();
		statusV=findEle(driver,processImagep1+groupID+status,"xpath").getAttribute("data-qtip");
		findEle(driver,processImagep1+groupID+processImagep2,"xpath").click();



		waitExplicitlyByLocator(driver,makePayment,"id",120);
		
		
		requestIDV=findEle(driver,paymentInfo+"(2)","cssselector").getText();
		pnrV=findEle(driver,paymentInfo+"(3)","cssselector").getText();
		noOfGuestV=findEle(driver,paymentInfo+"(4)","cssselector").getText();
		paymentValidityV=findEle(driver,paymentInfo+"(5)","cssselector").getText();
		requstedAmountV=findEle(driver,paymentInfo+"(8)","cssselector").getText();
		totalCostV=findEle(driver,paymentInfo+"(9)","cssselector").getText();
		System.out.println(statusV+"\t"+requestIDV+"\t"+pnrV+"\t"+noOfGuestV+"\t"+paymentValidityV+"\t"+requstedAmountV+"\t"+totalCostV );
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,wireTransfer,"xpath").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,approveBtn,"id").click();
		
		
		waitExplicitlyByLocator(driver,successBtn,"xpath",180);
		
		findEle(driver,successBtn,"xpath").click();
		
	 	waitExplicitlyByLocator(driver,logOut,"cssselector",30);
	 	 
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", findEle(driver,logOut,"cssselector"));
	}


	
	

	
}
