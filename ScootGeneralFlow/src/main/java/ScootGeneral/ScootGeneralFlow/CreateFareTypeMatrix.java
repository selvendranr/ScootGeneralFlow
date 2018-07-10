package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pack.base.DiscountMatrixFormat;
import pack.base.FareTypeMatrixFormat;
import pack.base.TestBaseSetup;


public class CreateFareTypeMatrix extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String fareSetup="a[title='Fare setup']";
	String fareType="+ul>li:nth-of-type(1)";
	String createMatrix="ul>li[class='createFaresetMatrix']>a";
	
	String matrixPanel="dicountMatrixTabs"; //id


	String profileName="newDiscountProfileName";			//name
	String profileType="#loadFactorType-bodyEl>input";
	String profileSelect="loadFactorType-triggerWrap";
	String bookedLF="//li[text()='Booked load factor']";
	String forecastLF="//li[text()='Forecast load factor']";
	String bothBLFAndFCLF="//li[text()='Both']";
	String loadFactorType="#loadFactorType-bodyEl>input";
	String loadFactorSelect="#loadFactorType-triggerWrap";
	String booked="//li[text()='Booked load factor']";
	String forecast="//li[text()='Forecast load factor']";
	String both="//li[text()='Both']";
	String nextBtn="//span[text()='Next']/..";
	
	String loadFactor="dicountBookingCapacity";	//name
	String focus1="//span[text()='Step 2']/..";
	String focus2="//span[text()='Step 3']/..";
	
	String add="Add";
	
	String nextBtn2="#dicountMatrixTabsStep2-body>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)";
	String daysToDepart="discountDaysToDeparture";//name
	String addDD="#discountDaysToDeparture+div>div>a";	
	String generate="//span[text()='Generate']/..";
	
	 String discountDetails="generateMatrixDetailsGrid";
	
	String matrixField="#generateFaresetMatrixDetailsGrid-body>div>table tr:nth-of-type"; //2 to last
	String firstRow="//input[contains(@name,'/0_ALL')]/../following-sibling::input";
	//	String secondRow="//input[contains(@name,'/0_ALL')]";
	
	String optP1="//li[text()='";
	String optP2="']";
	String fareTypeVal[]={"Dynamic fare","Tiered fare"}; //Dynamic fare
	
	
	String updateBtn="//span[text()='Update']/..";
	
	String submitBtn="generateFaresetMatrixSubmit-btnEl"; //id

	String sucessMsg="setInfoMessage"; //id
	String sucessOk="//div[@id='setInfoMessage']/../following-sibling::div/button";
	
	List<FareTypeMatrixFormat> fareTypeMatrixList= new ArrayList<FareTypeMatrixFormat>();
	FareTypeMatrixFormat dl;
	
	int LF[];
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	

	String profileNameV,profileTypeV,loadFactorTypeV;
	
	String loadFactorV;

	String payTypeV;
	String daysToDepartV,fareValV,fareValTypeV,payVal1V,payValType1V,payValPer1V,payVal2V,payValType2V,payValPer2V,payVal3V,payValType3V,payValPer3V,ticketValV,ticketValTypeV;
	String sucessMsgV;
	int percent=300;
	
	private Login login;
	
	public CreateFareTypeMatrix(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createMatrix() throws IOException {
		
		  
		login=new Login(driver);
		login.doLogin(7);
		
		waitExplicitlyByLocator(driver,requestWindowFirst,"id",160);
			
		waitExplicitlyByLocator(driver,fareSetup,"cssselector",60);
		findEle(driver,fareSetup,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,fareSetup+fareType,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,createMatrix,"cssselector").click();
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",3);
			 
			  waitExplicitlyNotByLocator(driver,loadingImg,"cssselector",120);


		 	}
		 	catch(TimeoutException e){
		 		System.out.println("After Click On Menu Loading Image is not displayed");
		 	}
		waitExplicitlyByLocator(driver,matrixPanel,"id",10);
		//findEle(driver,matrixPanel,"id").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		waitExplicitlyByLocator(driver,profileName,"name",30);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		findEle(driver,profileName,"name").sendKeys("fareTypeMatrix"+getRandomNumber(101,200));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profileNameV=findEle(driver,profileName,"name").getAttribute("value");
		
		findEle(driver,profileSelect,"id").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,bookedLF,"xpath").click();
		profileTypeV=findEle(driver,profileType,"cssselector").getAttribute("value");
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		findEle(driver,loadFactorSelect,"cssselector").click();
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		findEle(driver,booked,"xpath").click();
		loadFactorTypeV=findEle(driver,loadFactorType,"cssselector").getAttribute("value");
		findEle(driver,nextBtn,"xpath").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		
		int bkLF[]={5,10,15,20,50};
		int daysToVal[]={5,10,20,30,60,300};
		//int[] LF=Arrays.asList(bkLF).stream().mapToInt(Integer::parseInt).toArray();
		this.LF=bkLF;
		//String val[]={"Hour(s)","Hour(s)","Day(s)","Day(s)","Day(s)","Week(s)"};
		waitExplicitlyByLocator(driver,loadFactor,"name",30); 
		for(int i=0;i<5;i++){		
		findEle(driver,loadFactor,"name").clear();
		findEle(driver,loadFactor,"name").sendKeys(""+bkLF[i]);
		loadFactorV=findEle(driver,loadFactor,"name").getAttribute("value");
		//LF[i]=Integer.parseInt(bkLF[i]);
		findEle(driver,focus1,"xpath").click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findEle(driver,add,"linktext").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		findEle(driver,nextBtn2,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,daysToDepart,"name",30);
		
		for(int i=0;i<6;i++){		
			findEle(driver,daysToDepart,"name").clear();
			findEle(driver,daysToDepart,"name").sendKeys(""+daysToVal[i]);
			daysToDepartV=findEle(driver,daysToDepart,"name").getAttribute("value");
			findEle(driver,focus2,"xpath").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			findEle(driver,addDD,"cssselector").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		findEle(driver,generate,"xpath").click();
		waitExplicitlyByLocator(driver,matrixField+"("+2+")","cssselector",30);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Actions act;	
		for(int i=1;i<=6;i++){
			act=new Actions(driver);
			act.moveToElement(findEle(driver,matrixField+"("+(i+1)+")","cssselector")).doubleClick().build().perform();
			//findEle(driver,matrixField+"("+(i+1)+")","cssselector").click();
			//findEle(driver,matrixField+"("+(i+1)+")","cssselector").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String temp;
			for(int j=1;j<=5;j++){
				if(i% 2 == 0)
					{temp=fareTypeVal[0];}
				else{temp=fareTypeVal[1];}
				findEle(driver,"("+firstRow+")["+j+"]","xpath").click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//List orgList2=driver.findElements(By.xpath(optP1+temp+optP2));
				
				findEle(driver,"("+optP1+temp+optP2+")["+j+"]","xpath").click();
			
				
				//percent++;
				
				


				
			}
			String value1,value2,value3,value4,value5;
			value1=findEle(driver,"("+firstRow+")["+1+"]","xpath").getAttribute("value");
			value2=findEle(driver,"("+firstRow+")["+2+"]","xpath").getAttribute("value");
			value3=findEle(driver,"("+firstRow+")["+3+"]","xpath").getAttribute("value");
			value4=findEle(driver,"("+firstRow+")["+4+"]","xpath").getAttribute("value");
			value5=findEle(driver,"("+firstRow+")["+5+"]","xpath").getAttribute("value");
			//System.out.println("Values are \n"+value1+"\t"+value2+"\t"+value3+"\t"+value4+"\t"+value5);
			dl=new FareTypeMatrixFormat(daysToVal[i-1],value1,value2,value3,value4,value5);
			fareTypeMatrixList.add(dl);

			findEle(driver,updateBtn,"xpath").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		 
		findEle(driver,submitBtn,"id").click();


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waitExplicitlyByLocator(driver,sucessMsg,"id",120);
		
		sucessMsgV=findEle(driver,sucessMsg,"id").getText();

		findEle(driver,sucessOk,"xpath").click();
		 

	//String sucessOk="//div[@id='setInfoMessage']/../following-sibling::div/button";

		
		
		 
		
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

	

