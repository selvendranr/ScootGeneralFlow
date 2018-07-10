package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




import pack.base.DiscountMatrixFormat;
import pack.base.FareTypeMatrixFormat;
import pack.base.TestBaseSetup;
import pack.base.TimeLimitFormat;



public class DemoTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	 private PromptTestLogin login;
	 
	// private ReadDownSize read;
	// private CreateFareTypeMatrix create;
	//private MapFareTypePolicy map;
	// private ProcessDownSizeAdhocOneWay process;
	 //private AcceptRequestDownSizeOneway accept;
	// private CreateFareTypeMatrix create;
	// PaymentApprove payment;
	// private ProcessDateRangeRoundTripTL processOneway;
	//PaymentAdhocOneWay payment;
	//private UpdateNameListAdhocOneWay namelist;
	//AcceptOnewayRequest accept;
	//CreateDiscountMatrix create;
	//private DownSizeOnewayAfterAccept process;
	//ProcessDownSizeAdhocOneWay	processDownSize;
 //private DownSizeOnewayBefore down;
	//AcceptRequestDownSizeOneway accept;
	 //private CreateTermsAndCondition checkOneway;
	 // private CreateAutoPilotPolicy auto;
	//ProcessAdhocOneWay process; 
	//private CreateTimeLineMatrix create;
	 //   private ProcessAdhocOneWay upsize;
	 // private LoginGetCookies login;

	 //List<FareTypeMatrixFormat> timeMatrixList= new ArrayList<FareTypeMatrixFormat>();
	//String[] test,test2;
	//String fareClassApplied1V,fareClassApplied2V; 
	//int lf,dd;
	//int lf2,dd2;
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	
	@Test
	public void toMakeAdhocOneWayReq() throws IOException {
		
		
		login=new PromptTestLogin(driver);
		login.doLogin(5);

		//read=new ReadDownSize ();
		//read.readRecord("D:\\AutomationBackUpFiles\\CommonBackGroupRMBackupFiles\\InputFile\\DownSize.xls");
		
	// create=new CreateTimeLineMatrixSplitPayment(driver);
		//create.createTimeLine();
		//timeMatrixList=create.timeMatrixList;
	
	//for (TimeLimitFormat object: timeMatrixList) {
	//	    System.out.println(object);
		//}
		//namelist=new UpdateNameListAdhocOneWay(driver) ;
		//namelist.addNameList("GRP00384"); 
		//nameList=new UpdateNameListAdhocOneWay(driver);
		//nameList.addNameList("GRP01407"); 		
		//accept.makePayment("GRP01407");
	 	//private UpdateNameListAdhocOneWay namelist;
		//accept=new AcceptRequestDownSizeOneway (driver);
		
		//accept.acceptRequest("GRP282422");
		//processDownSize=new ProcessDownSizeAdhocOneWay(driver);
		//try {
		//	processDownSize.processAdHocRequest("GRP282416");
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	
	   //process=new DownSizeOnewayAfterAccept(driver);
	  // process.downRequest("GRP282416");
		 //	process.adHocGroupRequest("D:\\AutomationBackUpFiles\\ScootGeneralFlow\\InputFile\\Sector.txt","-");
		 
		/* test=process.classesAvail1;
		 test2=process.classesAvail2;
		 for(Object ob:test){
			 System.out.print(ob);			 
			 
		 }
		 for(Object ob:test2){
			 System.out.print(ob);			 
			 
		 }
		 lf=process.loadFactorI;
		 dd=process.daysToDepartI;
		 fareClassApplied1V=process.fareClassApplied1V;
		 System.out.println(lf);
		 System.out.println(dd);
		 System.out.println(fareClassApplied1V);
		 
		 lf2=process.loadFactorI2;
		 dd2=process.daysToDepartI2;
		 fareClassApplied2V=process.fareClassApplied2V;
		 System.out.println(lf2);
		 System.out.println(dd2);
		 System.out.println(fareClassApplied2V);
		 */

		//  create=new MapNegotiationPolicy (driver);
		//  create.create("Athens (ATH)","Thessaloniki (SKG)","TimeLineTest53","15","One way","Adhoc","4");
		 //UpdateNameListAdhocOneWay namelist;
		
		//create=new CreateFareTypeMatrix(driver);
		// create.createMatrix();
		//  timeMatrixList=create.fareTypeMatrixList;
		 // for (FareTypeMatrixFormat object: timeMatrixList) {
			//     System.out.println(object);
			//  }
		//timeMatrixList=create.timeMatrixList;
		
		//for (DiscountMatrixFormat object: timeMatrixList) {
		//	 	    System.out.println(object);} 
		
	   //upsize =new ProcessAdhocOneWay(driver);
	   //upsize.processAdHocRequest("GRP01021","cancel");
		//  down.upSizeRequest("GRP10461");
		// accept=new AcceptRequestDownSizeOneway(driver);
	//	 accept.acceptRequest( "GRP00310",0,"0");		
	 	//String filePath="\\InputFile\\Sector.txt";
		
		// map=new MapFareTypePolicy(driver);
		// map.mapDiscountPolicy("discountTest65", "Round trip", "Series", filePath, "-");
		//create=new CreateRequestPolicy (driver);
		//create.createCriteria();
		//  map=new MapRequestPolicy(driver);
		//  map.mapCriteria("Athens (ATH)","Thessaloniki (SKG)","Multi city","Adhoc","requestCriteria25","D:\\AutomationBackUpFiles\\CommonBackGroupRMBackupFiles\\InputFile\\Sector.txt","-");

		// checkOneway=new CreateTermsAndCondition (driver);
		// checkOneway.createTandC("D:\\AutomationBackUpFiles\\CommonBackGroupRMBackupFiles\\InputFile\\termsAndConditons.txt");
	
		// auto = new CreateAutoPilotPolicy(driver);
		// auto.autoPilot("Athens (ATH)","Thessaloniki (SKG)");
		
	  	// payment=new PaymentApprove(driver);
	  //	payment.approve("GRP00544");
		//
		//upsize=new UpSizeSeriesOnewayAfterApprove(driver);
		//upsize.upSizeRequest("GRP00555");
		   
			
	}
	


 
	@AfterClass
	public void tearDown() {
		
		driver.quit();


		   		 
	}
	
	
	
	 
	}



