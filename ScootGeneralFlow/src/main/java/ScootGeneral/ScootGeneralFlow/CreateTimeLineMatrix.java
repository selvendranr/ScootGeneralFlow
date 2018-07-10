package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import pack.base.TestBaseSetup;

public class CreateTimeLineMatrix extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String settings="a[title='Settings']";
	String timeLine="+ul>li:nth-of-type(2)";
	String timeLinList="li[class='timeLineMatrixNameList']>a";
	
	String timeLineSearch="timeLineQueryBox-body"; //id
	String searchBtn="#timeLineQueryBox-body+div>div button";
	String timeLineList="timeLineGridId";
	String create="//span[text()='Create']/..";
	String timeLineMatrixName="newTimeLineProfileName";			//name
	String timeLineMatrixValidity="#timeLineProfileType-bodyEl>div:first-of-type+input";
	String timeLineMatrixValSelect="#timeLineProfileType-triggerWrap";
	String newValidity="//li[text()='New Validities']";
	String cloneValidity="//li[text()='Clone Validities']";
	String nextBtn="#newTimeLineDetailsForm-body+div>div button";
	
	
	String daysToDeparture="daysToDeparture"; // name
	String payTypeTxt="#paymentDepositType-bodyEl>input";
	String payTypeSelect="#paymentDepositType-triggerWrap";
	String percent="//li[text()='Percentage']";
	String absolute="//li[text()='Absolute']";
	String fareValidity="fareValidity";	//name
	String fareValidityType="#fareValidityType-bodyEl>div:first-of-type+input";
	String fareValidityTypeSelect="#fareValidityType-triggerWrap";
	String typeVal1="//li[text()='";
	String typeVal2="']";
	
	String paymentValidity="paymentValidity";	//name
	String paymentValidityType="#paymentValidityType-bodyEl>div:first-of-type+input";
	String paymentValidityTypeSelect="#paymentValidityType-triggerWrap";
	
	String paymentExpiryValidity="#paymentExpiryValidityType-bodyEl>div:first-of-type+input";
	String paymentExpiryValiditySelect="#paymentExpiryValidityType-triggerWrap";
	String expval[]={"//li[text()='Current date']","//li[text()='Date of departure']"};

	
	String paymentPercentTxt="#paymentPercentage-bodyEl>input";
	
	//Currency
	
	String paymentPercentAdd="#displayCurrency+img";
	
	String paymentValidity1="paymentValidity0";	//name
	String paymentValidityType1="#paymentValidityType0-bodyEl>div:first-of-type+input";
	String paymentValidityTypeSelect1="#paymentValidityType0-triggerWrap";

	String paymentExpiryValidity1="#paymentExpiryValidityType0-bodyEl>div:first-of-type+input";
	String paymentExpiryValiditySelect1="#paymentExpiryValidityType0-triggerWrap";
	
	String nameListValidity="passengerValidity";//name 
	String nameListValidityType="#passenegerValidityType-bodyEl>div:first-of-type+input";
	String passengerExpiryValidityType= "#passengerExpiryValidityType-bodyEl>div:first-of-type+input";
	String add="addDays-btnEl"; //add
	String policyType="policyType-triggerWrap"; //id
	String policyTypeVal[]={"Non-cancellaton","Non-refundable","Normal Policy"};
	String materiali="materialization"; //name
	
	String generatePolicy="#timeLineMatrixGrid-body+div>div>div:last-of-type button";


	String sucessMsg="//span[text()='The time limit matrix created successfully']";
	String sucessOk="//span[text()='OK']";
	
	
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	

	String timeLineMatrixNameV,timeLineMatrixValidityV;
	
	String payTypeV,fareValidityV,fareValidityTypeV,paymentValidityV,paymentValidityTypeV,paymentExpiryValidityV,paymentValidity2V,paymentValidityType2V,paymentExpiryValidity2V,nameListValidityV,nameListValidityTypeV,passengerExpiryValidityTypeV;
	String sucessMsgV;
	private Login login;
	
	public CreateTimeLineMatrix(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createTimeLine() throws IOException {
		
		  
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
		findEle(driver,settings+timeLine,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,timeLinList,"cssselector").click();
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Menu Loading Image is not displayed");
		 	}
		waitExplicitlyByLocator(driver,timeLineSearch,"id",10);
		findEle(driver,searchBtn,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 waitExplicitlyByLocator(driver,timeLineList,"id",10);
		 
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
		
		
		waitExplicitlyByLocator(driver,timeLineMatrixName,"name",30);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		findEle(driver,timeLineMatrixName,"name").sendKeys("TimeLineTest"+getRandomNumber(10,100));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		timeLineMatrixNameV=findEle(driver,timeLineMatrixName,"name").getAttribute("value");
		
		findEle(driver,timeLineMatrixValSelect,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,newValidity,"xpath").click();
		timeLineMatrixValidityV=findEle(driver,timeLineMatrixValidity,"cssselector").getAttribute("value");
		findEle(driver,nextBtn,"cssselector").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waitExplicitlyByLocator(driver,daysToDeparture,"name",30);
	
		findEle(driver,daysToDeparture,"name").clear();
		findEle(driver,daysToDeparture,"name").sendKeys(""+getRandomNumber(10,15));
		int typeNo=getRandomNumber(1,3);
		switch(typeNo){
		
		case 1:
			percentage();
			break;
		case 2:
			absolute();
			break;
			
		default:
			System.out.println("Invalid Type ");
			
		}
		
		 
		
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
	
	
	public void absolute(){

		String fareType[]={"Week(s)","Day(s)","Hour(s)"};
		
			findEle(driver,payTypeSelect,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,absolute,"xpath").click();		
		payTypeV=findEle(driver,payTypeTxt,"cssselector").getAttribute("value");
		
		findEle(driver,fareValidity,"name").clear();
		findEle(driver,fareValidity,"name").sendKeys(""+getRandomNumber(1,3));
		fareValidityV=findEle(driver,fareValidity,"name").getAttribute("value");
		
		findEle(driver,fareValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,typeVal1+fareType[getRandomNumber(1,3)]+typeVal2,"xpath").click();
		fareValidityTypeV=findEle(driver,fareValidityType,"cssselector").getAttribute("value");
		
		
		findEle(driver,paymentValidity,"name").clear();
		findEle(driver,paymentValidity,"name").sendKeys(""+getRandomNumber(1,3));
		paymentValidityV=findEle(driver,paymentValidity,"name").getAttribute("value");
	
		findEle(driver,paymentValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+typeVal1+fareType[getRandomNumber(1,3)]+typeVal2+")[2]","xpath").click();
		paymentValidityTypeV=findEle(driver,paymentValidityType,"cssselector").getAttribute("value");

		
		
		findEle(driver,paymentExpiryValidity,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,expval[getRandomNumber(0,1)],"xpath").click();
		paymentExpiryValidityV=findEle(driver,paymentExpiryValidity,"cssselector").getAttribute("value");
 
		findEle(driver,paymentPercentTxt,"cssselector").clear();
		findEle(driver,paymentPercentTxt,"cssselector").sendKeys("50");
		//findEle(driver,paymentPercentAdd,"cssselector").click();

		findEle(driver,paymentValidity1,"name").clear();
		findEle(driver,paymentValidity1,"name").sendKeys(""+getRandomNumber(1,3));
		paymentValidity2V=findEle(driver,paymentValidity1,"name").getAttribute("value");
	
		findEle(driver,paymentValidityTypeSelect1,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+typeVal1+fareType[getRandomNumber(1,3)]+typeVal2+")[3]","xpath").click();
		paymentValidityType2V=findEle(driver,paymentValidityType1,"cssselector").getAttribute("value");

		
		
		findEle(driver,paymentExpiryValiditySelect1,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+expval[0]+")[2]","xpath").click();
		paymentExpiryValidity2V=findEle(driver,paymentExpiryValidity1,"cssselector").getAttribute("value");
 
	 
		
		findEle(driver,nameListValidity,"name").clear();
		findEle(driver,nameListValidity,"name").sendKeys(""+getRandomNumber(1,3));
		nameListValidityV=findEle(driver,nameListValidity,"name").getAttribute("value");
	
		findEle(driver,nameListValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+typeVal1+fareType[getRandomNumber(1,3)]+typeVal2+")[4]","xpath").click();
		nameListValidityTypeV=findEle(driver,nameListValidityType,"cssselector").getAttribute("value");
		
		findEle(driver,passengerExpiryValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+expval[0]+")[3]","xpath").click();
		passengerExpiryValidityTypeV=findEle(driver,passengerExpiryValidityType,"cssselector").getAttribute("value");

		
		
		findEle(driver,add,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,generatePolicy,"cssselector").click();
		
	
		
	}
	
	public void percentage(){
		String fareType[]={"Week(s)","Day(s)","Hour(s)"};
		
			findEle(driver,payTypeSelect,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,percent,"xpath").click();		
		payTypeV=findEle(driver,payTypeTxt,"cssselector").getAttribute("value");
		
		findEle(driver,fareValidity,"name").clear();
		findEle(driver,fareValidity,"name").sendKeys(""+getRandomNumber(1,3));
		fareValidityV=findEle(driver,fareValidity,"name").getAttribute("value");
		
		findEle(driver,fareValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,typeVal1+fareType[getRandomNumber(1,3)]+typeVal2,"xpath").click();
		fareValidityTypeV=findEle(driver,fareValidityType,"cssselector").getAttribute("value");
		
		
		findEle(driver,paymentValidity,"name").clear();
		findEle(driver,paymentValidity,"name").sendKeys(""+getRandomNumber(1,3));
		paymentValidityV=findEle(driver,paymentValidity,"name").getAttribute("value");
	
		findEle(driver,paymentValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+typeVal1+fareType[getRandomNumber(1,3)]+typeVal2+")[2]","xpath").click();
		paymentValidityTypeV=findEle(driver,paymentValidityType,"cssselector").getAttribute("value");

		
		
		findEle(driver,paymentExpiryValidity,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,expval[getRandomNumber(0,1)],"xpath").click();
		paymentExpiryValidityV=findEle(driver,paymentExpiryValidity,"cssselector").getAttribute("value");
 
		findEle(driver,paymentPercentTxt,"cssselector").clear();
		findEle(driver,paymentPercentTxt,"cssselector").sendKeys("25");
		findEle(driver,paymentPercentAdd,"cssselector").click();

		findEle(driver,paymentValidity1,"name").clear();
		findEle(driver,paymentValidity1,"name").sendKeys(""+getRandomNumber(1,3));
		paymentValidity2V=findEle(driver,paymentValidity1,"name").getAttribute("value");
	
		findEle(driver,paymentValidityTypeSelect1,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+typeVal1+fareType[getRandomNumber(1,3)]+typeVal2+")[3]","xpath").click();
		paymentValidityType2V=findEle(driver,paymentValidityType1,"cssselector").getAttribute("value");

		
		
		findEle(driver,paymentExpiryValiditySelect1,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+expval[0]+")[2]","xpath").click();
		paymentExpiryValidity2V=findEle(driver,paymentExpiryValidity1,"cssselector").getAttribute("value");
 
	 
		
		findEle(driver,nameListValidity,"name").clear();
		findEle(driver,nameListValidity,"name").sendKeys(""+getRandomNumber(1,3));
		nameListValidityV=findEle(driver,nameListValidity,"name").getAttribute("value");
	
		findEle(driver,nameListValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+typeVal1+fareType[getRandomNumber(1,3)]+typeVal2+")[4]","xpath").click();
		nameListValidityTypeV=findEle(driver,nameListValidityType,"cssselector").getAttribute("value");
		
		findEle(driver,passengerExpiryValidityType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,"("+expval[0]+")[3]","xpath").click();
		passengerExpiryValidityTypeV=findEle(driver,passengerExpiryValidityType,"cssselector").getAttribute("value");
		
		findEle(driver,policyType,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver, typeVal1+policyTypeVal[getRandomNumber(0,2)]+typeVal2,"xpath").click();
		 
		findEle(driver,materiali,"name").sendKeys(""+getRandomNumber(75,100));


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,add,"id").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,generatePolicy,"cssselector").click();

	}
	
}

	

