package ScootGeneral.ScootGeneralFlow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver; 
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pack.base.DownSizeFormat;
import pack.base.ReadDownSizeInput;
import pack.base.ReadRootPath;
import pack.base.TestBaseSetup;
import pack.base.UpdateStatusFormat;
import pack.base.WriteTestCaseStatus;

public class UpSizeRequestTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadDownSizeInput read;
	
	private AdhocOneWayModifyRequest oneway;
	private AdhocRoundTripModifyRequest roundTrip;
	private AdhocMultiCityModifyRequest multiCity;
	private UpSizeOnewayBefore upSize;
	private ProcessUpSizeAdhocOneWay processUpSize;
	
	private UpSizeSeriesOnewayBefore upsizeSeries;
	
	private ProcessNegoAdhocOneWay processOneway;
	private ProcessNegoAdhocRoundTrip processRoundTrip;
	private ProcessNegoAdhocMultiCity processMultiCity;
	
	private UpSizeOnewayAfter upsizeAdhocOnewayAfter;

	
	private UpSizeSeriesOnewayAfterApprove upsizeSeriesOnewayAfter;
	private UpSizeSeriesRoundTripAfterApprove upsizeSeriesRoundAfter;
	private UpSizeSeriesMulticityAfterApprove upsizeSeriesMultiCityAfter;

	private UpSizeSeriesOnewayAfterAccept upsizeSeriesOnewayAfterAccept;
	private UpSizeSeriesRoundTripAfterAccept upsizeSeriesRoundAfterAccept;
	 
	
	private SeriesDateRangeOneWayModifyRequest seriesOneway;
	private SeriesDateRangeRoundTripModifyRequest seriesRoundTrip;
	private SeriesDateRangeMultiCityModifyRequest seriesMultiCity;
	
	private ProcessDateRangeOneWay processSeriesOneway;
	private ProcessDateRangeRoundTrip processSeriesRoundTrip;
	private ProcessDateRangeMultiCity processSeriesMultiCity;
	
 
	
	private AcceptRequestDownSizeOneway accept;
	private AcceptSeriesDateRangeDownSizeOneway acceptSeries;
	
 
	String inputFile="InputFile\\UpSize.xls";
	String reportexcelFile="DataDrivenReport\\Modify Request.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";
	
	
	private String slNo,when,scenario,tripTypeRead,requestType;
	private boolean runningMode=false;
	
	String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
 	
	String suceedMsg,suceedMsgProcessPage;
	String adultCurr,childCurr,infantCurr,adultNew,childNew,infantNew;
	String adultBeforeApprove,childBeforeApprove,infantBeforeApprove,adultNewBeforeApprove,childNewBeforeApprove,infantNewBeforeApprove;
	String adultProcess,childProcess,infantProcess,adultNewProcess,childNewProcess,infantNewProcess;
	
	String newRequestId;

	List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	UpdateStatusFormat rf;
	ReadRootPath readRoot=new ReadRootPath();
	String rootPath=readRoot.getPath();
	
	List<DownSizeFormat> inputList=new ArrayList<DownSizeFormat>();
	 private int indexOfInput;


	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	@Parameters({"indexVal"})
	@Test
	public void readUpSizeInput(int indexVal) throws IOException {
		
		indexOfInput=indexVal;
		read=new ReadDownSizeInput ();
		try {
			read.getExcelData(rootPath+inputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputList=read.inputList;
		slNo=inputList.get(indexOfInput).getSlNo();
		when=inputList.get(indexOfInput).getWhen();
		scenario=inputList.get(indexOfInput).getScenario();
		tripTypeRead=inputList.get(indexOfInput).getTripType();
		requestType=inputList.get(indexOfInput).getRequestType();
		if(inputList.get(indexOfInput).getRunningMode().equalsIgnoreCase("Yes")){
			runningMode=true;	
		}
		
		System.out.println(slNo+"\t"+tripTypeRead+"\t"+requestType+"\t"+runningMode);	

	}

	 
	@Test(dependsOnMethods = "readUpSizeInput",priority=1)
	public void raiseRequest() throws IOException {
		if(runningMode){
		String tripType,reqType;
		reqType=requestType.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeRead.toUpperCase();
		tripType=tripType.replaceAll("\\s+", "");
		
		switch(reqType){
		case "ADHOC":
			switch(tripType){
			case "ONEWAY":
				raiseOneway();				 
				break;
				
			case "ROUNDTRIP":
				raiseRoundTrip();
				 
				break;
			
			case "MULTICITY":
				raiseMultiCity();	
				 
				break;
		
			
			}
			break;
			
		case "SERIES":
			switch(tripType){
			case "ONEWAY":
				 raiseSeriesOneway();
				 
				break;
				
			case "ROUNDTRIP":
				 raiseSeriesRoundTrip();		
				 
				break;
			
			case "MULTICITY":
				 raiseSeriesMultiCity();		
				break;
		
			
			}
			break;
	
		case "CONFERENCE":
			System.out.println("Conference is not available as of now ");
			break;
			
			
		}
 
		}else{
			driver.close();
		}
		
	
	}
	
	@Test(dependsOnMethods = "readUpSizeInput",priority=2)
	public void upSize() throws IOException {
		if(runningMode){
		String tripType,reqType,whenV,scenarioV;
	
		scenarioV=scenario.toUpperCase();
		scenarioV=scenarioV.replaceAll("\\s+", "");

		
		whenV=when.toUpperCase();
		whenV=whenV.replaceAll("\\s+", "");
		reqType=requestType.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeRead.toUpperCase();
		tripType=tripType.replaceAll("\\s+", "");
		
		switch(scenarioV){
		case "APPROVE": {
			
			switch(whenV){
			case "BEFORE":
				//Before Approve Start
				switch(reqType){
				case "ADHOC":
					switch(tripType){
					case "ONEWAY":
						raiseOnewayUpSizeBeforeApprove("ONEWAY");
						processOnewayUpSizeBeforeApprove("ADHOC","ONEWAY");
						break;
						
					case "ROUNDTRIP":
						raiseOnewayUpSizeBeforeApprove("ROUNDTRIP");
						processOnewayUpSizeBeforeApprove("ADHOC","ROUNDTRIP");
						break;
					
					case "MULTICITY":
						raiseOnewayUpSizeBeforeApprove("MULTICITY");
						processOnewayUpSizeBeforeApprove("ADHOC","MULTICITY");
						break;
				
					
					}
					break;
					
				case "SERIES":
					switch(tripType){
					case "ONEWAY":
						raiseSeriesOnewayUpSizeBeforeApprove("ONEWAY");
						processOnewayUpSizeBeforeApprove("SERIES","ONEWAY");
						break;
						
					case "ROUNDTRIP":
						raiseSeriesOnewayUpSizeBeforeApprove("ROUNDTRIP");
						processOnewayUpSizeBeforeApprove("SERIES","ROUNDTRIP");
						break;
					
					case "MULTICITY":
						raiseSeriesOnewayUpSizeBeforeApprove("MULTICITY");
						processOnewayUpSizeBeforeApprove("SERIES","MULTICITY");
						break;
				
					
					}
					break;
			
				case "CONFERENCE":
					System.out.println("Conference is not available as of now ");
					break;
					
					
				}
				//Before Approver End 
				
			break;
			
			case "AFTER": {
				switch(reqType){
				
				case "ADHOC":
					 
					switch(tripType){
					case "ONEWAY":
						processOneway=new ProcessNegoAdhocOneWay(driver);
						try {
							processOneway.processAdHocRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 		
						raiseAdhocOnewayUpSizeAfterApprove("APPROVE","ONEWAY");	 
						processUpsizeAfterApproveAdhocOneway("APPROVE","ADHOC");
						 break;
						
					case "ROUNDTRIP":
						processRoundTrip=new ProcessNegoAdhocRoundTrip(driver);
						try {
							processRoundTrip.processAdHocRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseAdhocOnewayUpSizeAfterApprove("APPROVE","ROUNDTRIP");
						processUpsizeAfterApproveAdhocRoundTrip("APPROVE","ADHOC");
						break;
					
					case "MULTICITY":
						processMultiCity=new ProcessNegoAdhocMultiCity(driver);
						try {
							processMultiCity.processAdHocRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseAdhocOnewayUpSizeAfterApprove("APPROVE","MULTICITY");
						processUpsizeAfterApproveAdhocMultiCity("APPROVE","ADHOC");
						 break;
				
					
					}
					 break;
					
					case "SERIES":
					switch(tripType){
					
					

					case "ONEWAY":
						processSeriesOneway=new ProcessDateRangeOneWay(driver);
						try {
							processSeriesOneway.processSeriesRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseSeriesOnewayUpSizeAfterApprove();
						//processUpsizeAfterApproveSeriesOneway(); 
						processUpsizeAfterApproveAdhocOneway("APPROVE","SERIES");
						
						break;
						
					case "ROUNDTRIP":
						processSeriesRoundTrip=new ProcessDateRangeRoundTrip(driver);
						try {
							processSeriesRoundTrip.processSeriesRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseSeriesRoundTripUpSizeAfterApprove();
						//processUpsizeAfterApproveSeriesRoundTrip();
						processUpsizeAfterApproveAdhocRoundTrip("APPROVE","SERIES");
						break;
					
					case "MULTICITY":
						processSeriesMultiCity=new ProcessDateRangeMultiCity(driver);
						try {
							processSeriesMultiCity.processSeriesRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						raiseSeriesMultiCityUpSizeAfterApprove();
						//processUpsizeAfterApproveSeriesMultiCity();
						processUpsizeAfterApproveAdhocMultiCity("APPROVE","SERIES");
						break;
				
					
						}
					 break;
					
					}	
				
			}	
			break;
			  }
			}
		break;
		case "ACCEPT": {
		switch(whenV){
		case "AFTER": 	
			switch(reqType){
			
			case "ADHOC":
				 
				switch(tripType){
				case "ONEWAY":
					processOneway=new ProcessNegoAdhocOneWay(driver);
					try {
						processOneway.processAdHocRequest(reqId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 		
					accept=new AcceptRequestDownSizeOneway(driver);
					accept.acceptRequest( reqId);	
					raiseAdhocOnewayUpSizeAfterApprove("ACCEPT","ROUNDTRIP");	 					
					processUpsizeAfterApproveAdhocOneway("ACCEPT","ADHOC");
					break;		 
					
				case "ROUNDTRIP":
					processRoundTrip=new ProcessNegoAdhocRoundTrip(driver);
					try {
						processRoundTrip.processAdHocRequest(reqId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					accept=new AcceptRequestDownSizeOneway(driver);
					accept.acceptRequest( reqId);	
					raiseAdhocOnewayUpSizeAfterApprove("ACCEPT","ROUNDTRIP");
					processUpsizeAfterApproveAdhocRoundTrip("ACCEPT","ADHOC");
					break;	
				
				case "MULTICITY":
					processMultiCity=new ProcessNegoAdhocMultiCity(driver);
					try {
						processMultiCity.processAdHocRequest(reqId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					accept=new AcceptRequestDownSizeOneway(driver);
					accept.acceptRequest( reqId);	
					raiseAdhocOnewayUpSizeAfterApprove("ACCEPT","MULTICITY");
					processUpsizeAfterApproveAdhocMultiCity("ACCEPT","ADHOC");
					break;	
			
				
				}
				 break;
				
				case "SERIES":
				switch(tripType){
				
				

				case "ONEWAY":
					processSeriesOneway=new ProcessDateRangeOneWay(driver);
					try {
						processSeriesOneway.processSeriesRequest(reqId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					acceptSeries=new AcceptSeriesDateRangeDownSizeOneway(driver);
					acceptSeries.acceptRequest(  reqId);	
					raiseSeriesOnewayUpSizeAfterAccept();
					//processUpsizeAfterApproveSeriesOneway();
					processUpsizeAfterApproveAdhocOneway("ACCEPT","SERIES");
					break;
					
				case "ROUNDTRIP":
					processSeriesRoundTrip=new ProcessDateRangeRoundTrip(driver);
					try {
						processSeriesRoundTrip.processSeriesRequest(reqId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					acceptSeries=new AcceptSeriesDateRangeDownSizeOneway(driver);
					acceptSeries.acceptRequest(  reqId);	
					raiseSeriesRoundTripUpSizeAfterAccept();
					//processUpsizeAfterApproveSeriesRoundTrip();
					processUpsizeAfterApproveAdhocRoundTrip("ACCEPT","SERIES");
					break;
				
				case "MULTICITY":
					processSeriesMultiCity=new ProcessDateRangeMultiCity(driver);
					try {
						processSeriesMultiCity.processSeriesRequest(reqId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					acceptSeries=new AcceptSeriesDateRangeDownSizeOneway(driver);
					acceptSeries.acceptRequest(  reqId);	
					raiseSeriesOnewayUpSizeAfterApprove();
					//processUpsizeAfterApproveSeriesMultiCity();
					processUpsizeAfterApproveAdhocMultiCity("ACCEPT","SERIES");
					break;
			
				
					}
				 break;
				
				}
		 
		}
		
		}
			
		}
		}
		}


	@AfterMethod
	public void takeScreenShot(ITestResult testResult) throws IOException {
		if(runningMode){
	if (testResult.getStatus() == ITestResult.FAILURE) {
		//System.out.println("fail"+"\t"+testResult.getName());
		getscreenshot(driver,"failure\\", testResult.getName());
	} else if (testResult.getStatus() == ITestResult.SUCCESS) {
		//System.out.println("pass"+"\t"+testResult.getName());
		getscreenshot(driver,"passed\\", testResult.getName());
	} else if (testResult.getStatus() == ITestResult.SKIP) {
		//System.out.println("skip"+"\t"+testResult.getName());
		getscreenshot(driver,"skipped\\", testResult.getName());
		
	}
	
		}
		
	}	
	
	 

		
	@AfterClass
	public void tearDown() {
		if(runningMode){
		driver.quit();
			
		try {
				write.writeExcelData(rootPath+reportexcelFile, reportList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
	}
	

	public void raiseOneway(){

			oneway =new AdhocOneWayModifyRequest(driver);
			oneway.adHocGroupRequest(rootPath+sectorInput,delimeter);
			groupNameReq=oneway.groupNameV;
			origin1Req=oneway.originV;
			destination1Req=oneway.destinationV;
			adultReq=oneway.adultV;
			childReq=oneway.childV;
			infantReq=oneway.infantV;
			expectedReq=oneway.expectedFareV;
			reqId=oneway.requestID;
			remarkReq=oneway.remarkV;
			
	
	}

	public void raiseRoundTrip(){
		
		roundTrip =new AdhocRoundTripModifyRequest(driver);
		roundTrip.adHocGroupRequest(rootPath+sectorInput,delimeter);
		groupNameReq=roundTrip.groupNameV;
		origin1Req=roundTrip.originV;
		destination1Req=roundTrip.destinationV;
		adultReq=roundTrip.adultV;
		childReq=roundTrip.childV;
		infantReq=roundTrip.infantV;
		expectedReq=roundTrip.expectedFareV;
		reqId=roundTrip.requestID;
		remarkReq=roundTrip.remarkV;		
		
	}
	
	public void raiseMultiCity(){
		multiCity =new AdhocMultiCityModifyRequest(driver);
		multiCity.adHocGroupRequest(rootPath+sectorInput,delimeter);
		groupNameReq=multiCity.groupNameV;
		origin1Req=multiCity.originV1;
		destination1Req=multiCity.destinationV1;
		origin2Req=multiCity.originV2;
		destination2Req=multiCity.destinationV2;
		origin3Req=multiCity.originV3;
		destination3Req=multiCity.destinationV3;

		adultReq=multiCity.adultV;
		childReq=multiCity.childV;
		infantReq=multiCity.infantV;
		expectedReq=multiCity.expectedFareV;
		reqId=multiCity.requestID;
		remarkReq=multiCity.remarkV;
 		
	}
	
	
	public void raiseAdhocOnewayUpSizeAfterApprove(String scenario,String tripType){
		
		  
		 upsizeAdhocOnewayAfter=new UpSizeOnewayAfter(driver);
			upsizeAdhocOnewayAfter.upSizeRequest(reqId);
			newRequestId=upsizeAdhocOnewayAfter.newRequestIDV;

			adultNew=upsizeAdhocOnewayAfter.adultNewV;
			childNew=upsizeAdhocOnewayAfter.childNewV;
			infantNew=upsizeAdhocOnewayAfter.infantNewV;
			scenario=scenario.toUpperCase();			
			tripType=tripType.toUpperCase();
			
			switch(scenario){	
			case "APPROVE":			
			switch(tripType){	
			case "ONEWAY":
				if(newRequestId.contains("GR")){
					rf=new UpdateStatusFormat("Pass",  "14","5","1");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "14","5","1");
					reportList.add(rf);
				} 
			break;
			
			case "ROUNDTRIP":
				if(newRequestId.contains("GR")){
					rf=new UpdateStatusFormat("Pass",  "16","5","1");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "16","5","1");
					reportList.add(rf);
				} 
			break;
			
			case "MULTICITY":
				if(newRequestId.contains("GR")){
					rf=new UpdateStatusFormat("Pass",  "18","5","1");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "18","5","1");
					reportList.add(rf);
				} 
			break;
			
			
			default:
				System.out.println("Trip Type is not Matching Plese check");
		
			}
			break;
			
			case "ACCEPT":			
				switch(tripType){	
				case "ONEWAY":
					if(newRequestId.contains("GR")){
						rf=new UpdateStatusFormat("Pass",  "27","5","1");
						reportList.add(rf);
						 

					}else{
						rf=new UpdateStatusFormat("Fail",  "27","5","1");
						reportList.add(rf);
					} 
				break;
				
				case "ROUNDTRIP":
					if(newRequestId.contains("GR")){
						rf=new UpdateStatusFormat("Pass",  "29","5","1");
						reportList.add(rf);
						 

					}else{
						rf=new UpdateStatusFormat("Fail",  "29","5","1");
						reportList.add(rf);
					} 
				break;
				
				case "MULTICITY":
					if(newRequestId.contains("GR")){
						rf=new UpdateStatusFormat("Pass",  "31","5","1");
						reportList.add(rf);
						 

					}else{
						rf=new UpdateStatusFormat("Fail",  "31","5","1");
						reportList.add(rf);
					} 
				break;
				
				
				default:
					System.out.println("Trip Type is not Matching Plese check");
			
				}
				break;
				
				default:
					System.out.println("Senario is not Matching");
					
			}	
				
				
	}
	
	
	public void raiseSeriesOnewayUpSizeAfterApprove(){
		
		 
		upsizeSeriesOnewayAfter=new UpSizeSeriesOnewayAfterApprove(driver);
		upsizeSeriesOnewayAfter.upSizeRequest(reqId);
		newRequestId=upsizeSeriesOnewayAfter.newRequestIDV;
		adultCurr=upsizeSeriesOnewayAfter.adultCurrV;
		childCurr=upsizeSeriesOnewayAfter.childCurrV;
		infantCurr=upsizeSeriesOnewayAfter.infantCurrV;
		adultNew=upsizeSeriesOnewayAfter.adultNewV;
		childNew=upsizeSeriesOnewayAfter.childNewV;
		infantNew=upsizeSeriesOnewayAfter.infantNewV;
	
			 
	}
	
	public void raiseSeriesRoundTripUpSizeAfterApprove(){
		

	upsizeSeriesRoundAfter=new UpSizeSeriesRoundTripAfterApprove(driver);
	upsizeSeriesRoundAfter.upSizeRequest(reqId);
	newRequestId=upsizeSeriesRoundAfter.newRequestIDV;
	adultCurr=upsizeSeriesRoundAfter.adultCurrV;
	childCurr=upsizeSeriesRoundAfter.childCurrV;
	infantCurr=upsizeSeriesRoundAfter.infantCurrV;
	adultNew=upsizeSeriesRoundAfter.adultNewV;
	childNew=upsizeSeriesRoundAfter.childNewV;
	infantNew=upsizeSeriesRoundAfter.infantNewV;
	
		
	 
		 
	}
	
	public void raiseSeriesMultiCityUpSizeAfterApprove(){
		
		
		upsizeSeriesMultiCityAfter=new UpSizeSeriesMulticityAfterApprove(driver);
		upsizeSeriesMultiCityAfter.upSizeRequest(reqId);
		newRequestId=upsizeSeriesMultiCityAfter.newRequestIDV;
		adultCurr=upsizeSeriesMultiCityAfter.adultCurrV;
		childCurr=upsizeSeriesMultiCityAfter.childCurrV;
		infantCurr=upsizeSeriesMultiCityAfter.infantCurrV;
		adultNew=upsizeSeriesMultiCityAfter.adultNewV;
		childNew=upsizeSeriesMultiCityAfter.childNewV;
		infantNew=upsizeSeriesMultiCityAfter.infantNewV;
		
			
		 
			 
		}
		
	

	public void raiseOnewayUpSizeBeforeApprove(String tripType){
		upSize=new UpSizeOnewayBefore(driver);
		upSize.upSizeRequest(reqId);
		suceedMsg=upSize.suceedMsgV;
		adultCurr=upSize.adultCurrV;
		childCurr=upSize.childCurrV;
		infantCurr=upSize.infantCurrV;
		adultNew=upSize.adultNewV;
		childNew=upSize.childNewV;
		infantNew=upSize.infantNewV;
		
		
		tripType=tripType.toUpperCase();
		switch(tripType){	
		case "ONEWAY":
			if(suceedMsg.contains("successfully")){
				rf=new UpdateStatusFormat("Pass",  "1","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "1","5","1");
				reportList.add(rf);
			} 
		break;
		
		case "ROUNDTRIP":
			if(suceedMsg.contains("successfully")){
				rf=new UpdateStatusFormat("Pass",  "3","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "3","5","1");
				reportList.add(rf);
			} 
		break;
		
		case "MULTICITY":
			if(suceedMsg.contains("successfully")){
				rf=new UpdateStatusFormat("Pass",  "5","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "5","5","1");
				reportList.add(rf);
			} 
		break;
		
		
		default:
			System.out.println("Trip Type is not Matching Plese check");
	
		}
	
		 
	}
	public void processOnewayUpSizeBeforeApprove(String reqType,String tripType){
		 
		
		processUpSize=new ProcessUpSizeAdhocOneWay(driver);
		try {
			processUpSize.processAdHocRequest(reqId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adultBeforeApprove=processUpSize.adultCurrV;
		childBeforeApprove=processUpSize.childCurrV;
		infantBeforeApprove=processUpSize.infantCurrV;
		adultNewBeforeApprove=processUpSize.adultNewV;
		childNewBeforeApprove=processUpSize.childNewV;
		infantNewBeforeApprove=processUpSize.infantNewV;
		suceedMsgProcessPage=processUpSize.suceedMsgV;
		reqType=reqType.toUpperCase();
		tripType=tripType.toUpperCase();
		
		switch(reqType){
		case "ADHOC":
			switch(tripType){	
			case "ONEWAY":
				if(suceedMsgProcessPage.contains("successfully")){
					rf=new UpdateStatusFormat("Pass",  "2","5","1");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "2","5","1");
					reportList.add(rf);
				} 
			break;
			
			case "ROUNDTRIP":
				if(suceedMsgProcessPage.contains("successfully")){
					rf=new UpdateStatusFormat("Pass",  "4","5","1");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "4","5","1");
					reportList.add(rf);
				} 
			break;
			
			case "MULTICITY":
				if(suceedMsgProcessPage.contains("successfully")){
					rf=new UpdateStatusFormat("Pass",  "6","5","1");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "6","5","1");
					reportList.add(rf);
				} 
			break;	
			}
			break;

			case "SERIES":
				switch(tripType){	
				case "ONEWAY":
					if(suceedMsgProcessPage.contains("successfully")){
						rf=new UpdateStatusFormat("Pass",  "8","5","1");
						reportList.add(rf);
						 

					}else{
						rf=new UpdateStatusFormat("Fail",  "8","5","1");
						reportList.add(rf);
					} 
				break;
				
				case "ROUNDTRIP":
					if(suceedMsgProcessPage.contains("successfully")){
						rf=new UpdateStatusFormat("Pass",  "10","5","1");
						reportList.add(rf);
						 

					}else{
						rf=new UpdateStatusFormat("Fail",  "10","5","1");
						reportList.add(rf);
					} 
				break;
				
				case "MULTICITY":
					if(suceedMsgProcessPage.contains("successfully")){
						rf=new UpdateStatusFormat("Pass",  "12","5","1");
						reportList.add(rf);
						 

					}else{
						rf=new UpdateStatusFormat("Fail",  "12","5","1");
						reportList.add(rf);
					} 
				break;	
				}
			break;
		
		default:
			System.out.println("Request Type is not Matching Plese check");
	
		}
	
			
		}
		
		 
	 
	
	
	
	
	public void raiseSeriesOneway(){
		seriesOneway=new SeriesDateRangeOneWayModifyRequest(driver);
		seriesOneway.seriesDateRangeRequest(rootPath+sectorInput,delimeter);
		reqId=seriesOneway.requestID;
	}
	public void raiseSeriesRoundTrip(){
		seriesRoundTrip=new SeriesDateRangeRoundTripModifyRequest(driver);
		seriesRoundTrip.seriesDateRangeRequest(rootPath+sectorInput,delimeter);
		reqId=seriesRoundTrip.requestID;
	}
	public void raiseSeriesMultiCity(){
		seriesMultiCity=new SeriesDateRangeMultiCityModifyRequest(driver);
		seriesMultiCity.seriesDateRangeRequest(rootPath+sectorInput,delimeter);
		reqId=seriesMultiCity.requestID;
	}
 	
	 
/*
	public void processUpsizeAfterApproveSeriesOneway(){
		processSeriesOneway=new ProcessDateRangeOneWay(driver);
		try {
			processSeriesOneway.processSeriesRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
 		 
	}

	
	public void processUpsizeAfterApproveSeriesRoundTrip(){
		processSeriesRoundTrip=new ProcessDateRangeRoundTrip(driver);
		try {
			processSeriesRoundTrip.processSeriesRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
	}
	
	public void processUpsizeAfterApproveSeriesMultiCity(){
		processSeriesMultiCity=new ProcessDateRangeMultiCity(driver);
		try {
			processSeriesMultiCity.processSeriesRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}
	*/
	public void processUpsizeAfterApproveAdhocOneway(String scenario,String reqType){
		processOneway=new ProcessNegoAdhocOneWay(driver);
		try {
				processOneway.processAdHocRequest(newRequestId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();		
						} 	
		scenario=scenario.toUpperCase();
		reqType=reqType.toUpperCase();
		
	
		switch(scenario){	
		case "APPROVE":		
		switch(reqType){	
		case "ADHOC":
			if(newRequestId.contains("GR")){
				rf=new UpdateStatusFormat("Pass",  "15","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "15","5","1");
				reportList.add(rf);
			} 
			break;
			
		case "SERIES":
			if(newRequestId.contains("GR")){
				rf=new UpdateStatusFormat("Pass",  "21","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "21","5","1");
				reportList.add(rf);
			} 
			break;
			
			default:
				System.out.println("Scenatio Missing Plese check");
			
		}
		break;
		case "ACCEPT":	
		switch(reqType){	
		case "ADHOC":
			if(newRequestId.contains("GR")){
				rf=new UpdateStatusFormat("Pass",  "28","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "28","5","1");
				reportList.add(rf);
			} 
			break;
			
		case "SERIES":
			if(newRequestId.contains("GR")){
				rf=new UpdateStatusFormat("Pass",  "34","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "34","5","1");
				reportList.add(rf);
			} 
			break;
			
			default:
				System.out.println("Scenatio Missing Plese check");
			
		}
		break;
		
		default:
			System.out.println("Request Type is mismatch");
		
		
		}
 		 
	}

	
	public void processUpsizeAfterApproveAdhocRoundTrip(String scenario,String reqType){
		processRoundTrip=new ProcessNegoAdhocRoundTrip(driver);
						try {
							processRoundTrip.processAdHocRequest(newRequestId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						scenario=scenario.toUpperCase();
						reqType=reqType.toUpperCase();
						
					
						switch(scenario){	
						case "APPROVE":		
						switch(reqType){	
						case "ADHOC":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "17","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "17","5","1");
								reportList.add(rf);
							} 
							break;
							
						case "SERIES":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "23","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "23","5","1");
								reportList.add(rf);
							} 
							break;
							
							default:
								System.out.println("Scenatio Missing Plese check");
							
						}
						break;
						case "ACCEPT":	
						switch(reqType){	
						case "ADHOC":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "30","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "30","5","1");
								reportList.add(rf);
							} 
							break;
							
						case "SERIES":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "36","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "36","5","1");
								reportList.add(rf);
							} 
							break;
							
							default:
								System.out.println("Scenatio Missing Plese check");
							
						}
						break;
						
						default:
							System.out.println("Request Type is mismatch");
						
						
						}
		  
	}
	
	public void processUpsizeAfterApproveAdhocMultiCity(String scenario,String reqType){
		processMultiCity=new ProcessNegoAdhocMultiCity(driver);
						try {
							processMultiCity.processAdHocRequest(newRequestId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		 
						scenario=scenario.toUpperCase();
						reqType=reqType.toUpperCase();
						
					
						switch(scenario){	
						case "APPROVE":		
						switch(reqType){	
						case "ADHOC":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "19","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "19","5","1");
								reportList.add(rf);
							} 
							break;
							
						case "SERIES":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "25","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "25","5","1");
								reportList.add(rf);
							} 
							break;
							
							default:
								System.out.println("Scenatio Missing Plese check");
							
						}
						break;
						case "ACCEPT":	
						switch(reqType){	
						case "ADHOC":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "32","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "32","5","1");
								reportList.add(rf);
							} 
							break;
							
						case "SERIES":
							if(newRequestId.contains("GR")){
								rf=new UpdateStatusFormat("Pass",  "38","5","1");
								reportList.add(rf);
								 

							}else{
								rf=new UpdateStatusFormat("Fail",  "38","5","1");
								reportList.add(rf);
							} 
							break;
							
							default:
								System.out.println("Scenatio Missing Plese check");
							
						}
						break;
						
						default:
							System.out.println("Request Type is mismatch");
						
						
						}
	}
	


	


	public void raiseSeriesOnewayUpSizeBeforeApprove(String tripType){
		  
		upsizeSeries=new UpSizeSeriesOnewayBefore(driver);
		upsizeSeries.upSizeRequest(reqId);
		suceedMsg=upsizeSeries.suceedMsgV;		
		adultCurr=upsizeSeries.adultCurrV;
		childCurr=upsizeSeries.childCurrV;
		infantCurr=upsizeSeries.infantCurrV;
		adultNew=upsizeSeries.adultNewV;
		childNew=upsizeSeries.childNewV;
		infantNew=upsizeSeries.infantNewV;
		
		tripType=tripType.toUpperCase();
		switch(tripType){	
		case "ONEWAY":
			if(suceedMsg.contains("successfully")){
				rf=new UpdateStatusFormat("Pass",  "7","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "7","5","1");
				reportList.add(rf);
			} 
		break;
		
		case "ROUNDTRIP":
			if(suceedMsg.contains("successfully")){
				rf=new UpdateStatusFormat("Pass",  "9","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "9","5","1");
				reportList.add(rf);
			} 
		break;
		
		case "MULTICITY":
			if(suceedMsg.contains("successfully")){
				rf=new UpdateStatusFormat("Pass",  "11","5","1");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "11","5","1");
				reportList.add(rf);
			} 
		break;
		
		
		default:
			System.out.println("Trip Type is not Matching Plese check");
	
		}
		 
	}

	public void raiseSeriesOnewayUpSizeAfterAccept(){
		
		 
		upsizeSeriesOnewayAfterAccept=new UpSizeSeriesOnewayAfterAccept(driver);
		upsizeSeriesOnewayAfterAccept.upSizeRequest(reqId);
		newRequestId=upsizeSeriesOnewayAfterAccept.newRequestIDV;
		adultCurr=upsizeSeriesOnewayAfterAccept.adultCurrV;
		childCurr=upsizeSeriesOnewayAfterAccept.childCurrV;
		infantCurr=upsizeSeriesOnewayAfterAccept.infantCurrV;
		adultNew=upsizeSeriesOnewayAfterAccept.adultNewV;
		childNew=upsizeSeriesOnewayAfterAccept.childNewV;
		infantNew=upsizeSeriesOnewayAfterAccept.infantNewV;
	
			 
	}
	
	public void raiseSeriesRoundTripUpSizeAfterAccept(){
		

	upsizeSeriesRoundAfterAccept=new UpSizeSeriesRoundTripAfterAccept(driver);
	upsizeSeriesRoundAfterAccept.upSizeRequest(reqId);
	newRequestId=upsizeSeriesRoundAfterAccept.newRequestIDV;
	adultCurr=upsizeSeriesRoundAfterAccept.adultCurrV;
	childCurr=upsizeSeriesRoundAfterAccept.childCurrV;
	infantCurr=upsizeSeriesRoundAfterAccept.infantCurrV;
	adultNew=upsizeSeriesRoundAfterAccept.adultNewV;
	childNew=upsizeSeriesRoundAfterAccept.childNewV;
	infantNew=upsizeSeriesRoundAfterAccept.infantNewV;
	
		
	 
		 
	}
	

}

