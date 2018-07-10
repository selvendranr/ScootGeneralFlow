package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pack.base.DiscountMatrixFormat;
import pack.base.TestBaseSetup;


public class CreateDiscountMatrix extends TestBaseSetup {
	
protected WebDriver driver;
	
	String requestWindowFirst="requestDetailsGrid";
	String settings="a[title='Fare setup']";
	String discountFare="+ul>li:nth-of-type(3)";
	String createMatrix="ul>li[class='createDiscountMatrix']>a";
	
	String matrixPanel="createDicountMatrixPanel"; //id


	String profileName="newDiscountProfileName";			//name
	String profileType="#discountProfileType-bodyEl>input";
	String profileSelect="#discountProfileType-triggerWrap";
	String percentOnBF="//li[text()='Discount percentage on base fare']";
	String amountOnBF="//li[text()='Discount amount on base fare']";
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
	
	String discountDetails="discountMatrixDetails";
	
	String matrixField="#generateDiscountMatrixDetailsGrid-body>div>table tr:nth-of-type"; //2 to last
	String firstRow="//input[contains(@name,'/0_ALL')]";
	//	String secondRow="//input[contains(@name,'/0_ALL')]";
	String updateBtn="//span[text()='Update']/..";
	
	String submitBtn="generateDiscountMatrixSubmit-btnEl"; //id

	String sucessMsg="setInfoMessage"; //id
	String sucessOk="//div[@id='setInfoMessage']/../following-sibling::div/button";
	
	List<DiscountMatrixFormat> timeMatrixList= new ArrayList<DiscountMatrixFormat>();
	DiscountMatrixFormat dl;
	
	int LF[];
	
	String processing="//span[text()='Loading data, please wait...']";
	String loadingImg="img[title='Loading...']";

	

	String profileNameV,profileTypeV,loadFactorTypeV;
	
	String loadFactorV;

	String payTypeV;
	String daysToDepartV,fareValV,fareValTypeV,payVal1V,payValType1V,payValPer1V,payVal2V,payValType2V,payValPer2V,payVal3V,payValType3V,payValPer3V,ticketValV,ticketValTypeV;
	String sucessMsgV;
	int percent=30;
	
	private Login login;
	
	public CreateDiscountMatrix(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createMatrix() throws IOException {
		
		  
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
		findEle(driver,settings+discountFare,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,createMatrix,"cssselector").click();
		
		try{
			 waitExplicitlyByLocator(driver,loadingImg,"cssselector",10);
			 
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
		 
		findEle(driver,profileName,"name").sendKeys("discountTest"+getRandomNumber(10,100));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profileNameV=findEle(driver,profileName,"name").getAttribute("value");
		
		findEle(driver,profileSelect,"cssselector").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findEle(driver,percentOnBF,"xpath").click();
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
			for(int j=1;j<=5;j++){
				
				findEle(driver,"("+firstRow+")["+j+"]","xpath").sendKeys(""+percent);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				percent++;
				
				


				
			}
			
			findEle(driver,updateBtn,"xpath").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int localToInsert;
			localToInsert=percent;
			dl=new DiscountMatrixFormat(daysToVal[i-1],(localToInsert-5),(localToInsert-4),(localToInsert-3),(localToInsert-2),(localToInsert-1));
			timeMatrixList.add(dl);

			
			
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

	

