package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import pack.base.TestBaseSetup;
import pack.base.TimeLimitFormat;


public class CreateTimeLineMatrixSplitPayment extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String settings="a[title='Settings']";
	String timeLine="+ul>li:nth-of-type(2)";
	String timeLinList="li[class='timeLineMatrixNameList']>a";
	
	String timeLineSearch="timeLineQueryBox-body"; //id

	String create="//span[text()='Create']/..";
	String timeLineMatrixName="newTimeLineProfileName";			//name
	String timeLineMatrixValidity="#timeLineProfileType-bodyEl>div:first-of-type+input";
	String timeLineMatrixValSelect="#timeLineProfileType-triggerWrap";
	String newValidity="//li[text()='New Validities']";
	String cloneValidity="//li[text()='Clone Validities']";
	String nextBtn="#newTimeLineDetailsForm-body+div>div button";
	String fareValidity="fareValidity";	//name
	String fareValidityType="fareValidityType";
	
	String typeVal1="//li[text()='";
	String typeVal2="']";
	
	
	String addSymbol="#displayCurrency+img";
	
	String paymentVal="paymentValidity";
	String paymentValType="paymentValidityType-triggerWrap";
	String percentage="paymentPercentage";
	// second Part
	
	String paymentVal1="paymentValidity0";
	String paymentValType1="paymentValidityType0-triggerWrap";
	String percentage1="paymentPercentage0";
	
	String paymentVal2="paymentValidity1";
	String paymentValType2="paymentValidityType1-triggerWrap";
	String percentage2="paymentPercentage1";
	
	String paymentVal3="paymentValidity2";
	String paymentValType3="paymentValidityType2-triggerWrap";
	String percentage3="paymentPercentage2";
	
	String paymentVal4="paymentValidity3";
	String paymentValType4="paymentValidityType3-triggerWrap";
	String percentage4="paymentPercentage3";

	
	String ticketVal="passengerValidity";
	String ticketValType="passenegerValidityType-triggerWrap";
	
	
	String daysToDeparture="daysToDeparture"; // name
	String payTypeTxt="#paymentDepositType-bodyEl>input";
	String payTypeSelect="#paymentDepositType-triggerWrap";
	String percent="//li[text()='Percentage']";
	String absolute="//li[text()='Absolute']";

	
	
	String add="addDays-btnEl"; //add
	
	String generatePolicy="#timeLineMatrixGrid-body+div>div>div:last-of-type button";


	String sucessMsg="//span[text()='The time limit matrix created successfully']";
	String sucessOk="//span[text()='OK']";
	
	List<TimeLimitFormat> timeMatrixList= new ArrayList<TimeLimitFormat>();
	TimeLimitFormat tl;
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	

	String timeLineMatrixNameV,timeLineMatrixValidityV;

	String payTypeV;
	String daysToDepartV,fareValV,fareValTypeV,payVal1V,payValType1V,payValPer1V,payVal2V,payValType2V,payValPer2V,payVal3V,payValType3V,payValPer3V,ticketValV,ticketValTypeV;

	private Login login;
	
	public CreateTimeLineMatrixSplitPayment(WebDriver driver) {
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
		findEle(driver,timeLineSearch,"id").click();
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

		String daysToVal[]={"1","10","20","30","60","300"};
		String val[]={"Hour(s)","Hour(s)","Day(s)","Day(s)","Day(s)","Week(s)"};
		 
		for(int i=0;i<6;i++){
		waitExplicitlyByLocator(driver,daysToDeparture,"name",30);
	
		findEle(driver,daysToDeparture,"name").clear();
		findEle(driver,daysToDeparture,"name").sendKeys(""+daysToVal[i]);
		daysToDepartV=findEle(driver,daysToDeparture,"name").getAttribute("value");
		
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
		findEle(driver,fareValidity,"name").sendKeys("1");
		fareValV=findEle(driver,fareValidity,"name").getAttribute("value");
		if(i==0){
		findEle(driver,fareValidityType,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test"+val[i]);
		
		List values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));
		System.out.println("size"+values.size());
		findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+values.size()+"]","xpath").click();
		 
		fareValTypeV=val[i];
	
		findEle(driver,paymentVal,"name").clear();
		findEle(driver,paymentVal,"name").sendKeys("1");
		payVal1V=findEle(driver,paymentVal,"name").getAttribute("value");
		findEle(driver,paymentValType,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
		findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+values.size()+"]","xpath").click();
		payValType1V=val[i];
		findEle(driver,percentage,"name").clear();
		findEle(driver,percentage,"name").sendKeys("25");
		payValPer1V=findEle(driver,percentage,"name").getAttribute("value");
		
		findEle(driver,addSymbol,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		findEle(driver,paymentVal1,"name").clear();
		findEle(driver,paymentVal1,"name").sendKeys("1");
		payVal2V=findEle(driver,paymentVal1,"name").getAttribute("value");
		findEle(driver,paymentValType1,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
		findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+values.size()+"]","xpath").click();
		payValType2V=val[i];
		findEle(driver,percentage1,"name").clear();
		findEle(driver,percentage1,"name").sendKeys("25");
		payValPer2V=findEle(driver,percentage1,"name").getAttribute("value");

		
		findEle(driver,addSymbol,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		findEle(driver,paymentVal2,"name").clear();
		findEle(driver,paymentVal2,"name").sendKeys("1");
		payVal3V=findEle(driver,paymentVal2,"name").getAttribute("value");
		findEle(driver,paymentValType2,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
		findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+values.size()+"]","xpath").click();
		payValType3V=val[i];
		//findEle(driver,percentage2,"name").clear();
		//findEle(driver,percentage2,"name").sendKeys("25");
		payValPer3V=findEle(driver,percentage2,"name").getAttribute("value");
		
		
		
		findEle(driver,ticketVal,"name").clear();
		findEle(driver,ticketVal,"name").sendKeys("1");
		ticketValV=findEle(driver,ticketVal,"name").getAttribute("value");
		findEle(driver,ticketValType,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
		findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+values.size()+"]","xpath").click();
		ticketValTypeV=val[i];

		findEle(driver,add,"id").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		tl=new TimeLimitFormat(daysToDepartV,fareValV,fareValTypeV,payVal1V,payValType1V,payValPer1V,payVal2V,payValType2V,payValPer2V,payVal3V,payValType3V,payValPer3V,ticketValV,ticketValTypeV);
		timeMatrixList.add(tl);
		}else{
			
			findEle(driver,fareValidityType,"id").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			List values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));
			System.out.println("size"+values.size());
			findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+1+"]","xpath").click();
			 
			fareValTypeV=val[i];
		
			findEle(driver,paymentVal,"name").clear();
			findEle(driver,paymentVal,"name").sendKeys("1");
			payVal1V=findEle(driver,paymentVal,"name").getAttribute("value");
			findEle(driver,paymentValType,"id").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
			findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+2+"]","xpath").click();
			payValType1V=val[i];
			findEle(driver,percentage,"name").clear();
			findEle(driver,percentage,"name").sendKeys("25");
			payValPer1V=findEle(driver,percentage,"name").getAttribute("value");
			if(i<=1)
			findEle(driver,addSymbol,"cssselector").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
			findEle(driver,paymentVal3,"name").clear();
			findEle(driver,paymentVal3,"name").sendKeys("1");
			payVal2V=findEle(driver,paymentVal3,"name").getAttribute("value");
			findEle(driver,paymentValType3,"id").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
			findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+4+"]","xpath").click();
			payValType2V=val[i];
			findEle(driver,percentage3,"name").clear();
			findEle(driver,percentage3,"name").sendKeys("25");
			payValPer2V=findEle(driver,percentage3,"name").getAttribute("value");

			if(i<=1)
			findEle(driver,addSymbol,"cssselector").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 
			findEle(driver,paymentVal4,"name").clear();
			findEle(driver,paymentVal4,"name").sendKeys("1");
			payVal3V=findEle(driver,paymentVal4,"name").getAttribute("value");
			findEle(driver,paymentValType4,"id").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
			findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+5+"]","xpath").click();
			payValType3V=val[i];
			//findEle(driver,percentage2,"name").clear();
			//findEle(driver,percentage2,"name").sendKeys("25");
			payValPer3V=findEle(driver,percentage4,"name").getAttribute("value");
			
			
			
			findEle(driver,ticketVal,"name").clear();
			findEle(driver,ticketVal,"name").sendKeys("1");
			ticketValV=findEle(driver,ticketVal,"name").getAttribute("value");
			findEle(driver,ticketValType,"id").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			values=driver.findElements(By.xpath(typeVal1+val[i]+typeVal2));		
			findEle(driver,"("+typeVal1+val[i]+typeVal2+")["+3+"]","xpath").click();
			ticketValTypeV=val[i];
			
			findEle(driver,add,"id").click();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tl=new TimeLimitFormat(daysToDepartV,fareValV,fareValTypeV,payVal1V,payValType1V,payValPer1V,payVal2V,payValType2V,payValPer2V,payVal3V,payValType3V,payValPer3V,ticketValV,ticketValTypeV);
			timeMatrixList.add(tl);

			
		}
		

		 
		}
		
		findEle(driver,generatePolicy,"cssselector").click();
		waitExplicitlyByLocator(driver,sucessMsg,"xpath",30);
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

	

