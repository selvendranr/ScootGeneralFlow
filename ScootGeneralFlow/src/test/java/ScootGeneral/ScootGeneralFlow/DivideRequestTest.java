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

public class DivideRequestTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadDownSizeInput read;
	
	private AdhocOneWayModifyRequest oneway;
	private AdhocRoundTripModifyRequest roundTrip;
	private AdhocMultiCityModifyRequest multiCity;

	
	private DivideOnewayBeforeApprove divideBeforeApprove;


	
	private ProcessNegoAdhocOneWay processOneway;
	private ProcessNegoAdhocRoundTrip processRoundTrip;
	private ProcessNegoAdhocMultiCity processMultiCity;
	
	private DivideOnewayAfterApprove divideAdhocOnewayAfter;
	private ProcessDivideAdhocOneWay processDivide;
	private ProcessDivideAdhocOneWayAfterAccept processDivideAfter;
	
	private AcceptRequestDownSizeOneway accept;


	String inputFile="InputFile\\Divide.xls";
	String reportexcelFile="DataDrivenReport\\Modify Request.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";
	
	
	private String slNo,when,scenario,tripTypeRead,requestType;
	private boolean runningMode=false;
	String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
 	
	String requestStatus;
	String adultCurr,childCurr,infantCurr,adultNew,childNew,infantNew;
	String adultBeforeApprove,childBeforeApprove,infantBeforeApprove,adultNewBeforeApprove,childNewBeforeApprove,infantNewBeforeApprove;
	String adultProcess,childProcess,infantProcess,adultNewProcess,childNewProcess,infantNewProcess;
	
	String newRequestId;
	String parantRequestId;
	

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
			
			/*
			case "ONEWAY":
				 raiseSeriesOneway();
				 
				break;
				
			case "ROUNDTRIP":
				 raiseSeriesRoundTrip();		
				 
				break;
			
			case "MULTICITY":
				 raiseSeriesMultiCity();		
				break;
			 */
			
			}
			System.out.println("Series is NA for Divide");
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
						raiseOnewayDivideBeforeApprove();
						break;
						
					case "ROUNDTRIP":
						raiseRoundTripDivideBeforeApprove();
						break;
					
					case "MULTICITY":
						raiseMultiCityDivideBeforeApprove();
						break;
				
					
					}
					break;
					
				case "SERIES":
					switch(tripType){/*
					case "ONEWAY":
						raiseSeriesOnewayUpSizeBeforeApprove();
						processOnewayUpSizeBeforeApprove();
						break;
						
					case "ROUNDTRIP":
						raiseSeriesOnewayUpSizeBeforeApprove();
						processOnewayUpSizeBeforeApprove();
						break;
					
					case "MULTICITY":
						raiseSeriesOnewayUpSizeBeforeApprove();
						processOnewayUpSizeBeforeApprove();
						break;
					*/
					
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
						raiseAdhocOnewayDivideAfterApprove("approve");	 
						processDivideAfterApproveAdhocOneWay();
						 break;
						
					case "ROUNDTRIP":
						processRoundTrip=new ProcessNegoAdhocRoundTrip(driver);
						try {
							processRoundTrip.processAdHocRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseAdhocRoundTripDivideAfterApprove("approve");
						processDivideAfterApproveAdhocRoundTrip();
						break;
					
					case "MULTICITY":
						processMultiCity=new ProcessNegoAdhocMultiCity(driver);
						try {
							processMultiCity.processAdHocRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseAdhocMultiCityDivideAfterApprove("approve");
						processDivideAfterApproveAdhocMultiCity();
						 break;
				
					
					}
					 break;
					
					case "SERIES":
					switch(tripType){
					
					/*

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
						processUpsizeAfterApproveAdhocOneway();
						
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
						processUpsizeAfterApproveAdhocRoundTrip();
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
						processUpsizeAfterApproveAdhocMultiCity();
						break;
				
					*/
						}
					
					System.out.println("Series NA for Divide");
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
					raiseAdhocOnewayDivideAfterApprove("accept");
					processDivideAfterAcceptAdhocOneWay();
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
					raiseAdhocRoundTripDivideAfterApprove("accept");
					processDivideAfterAcceptAdhocRoundTrip();
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
					raiseAdhocMultiCityDivideAfterApprove("accept");
					processDivideAfterAcceptAdhocMultiCity();
					break;	
			
				
				}
				 break;
				
				case "SERIES":
				switch(tripType){
				
				/*

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
					processUpsizeAfterApproveAdhocOneway();
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
					processUpsizeAfterApproveAdhocRoundTrip();
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
					processUpsizeAfterApproveAdhocMultiCity();
					break;
			
					*/
					}
				
				System.out.println("Series request is NA for Divide");
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
	
	
	public void raiseAdhocOnewayDivideAfterApprove(String scenario){
		
		
		divideAdhocOnewayAfter=new DivideOnewayAfterApprove(driver);
			divideAdhocOnewayAfter.divideRequest(reqId);
			newRequestId=divideAdhocOnewayAfter.newRequestIDV;
			adultNew=divideAdhocOnewayAfter.adultNewV;
			childNew=divideAdhocOnewayAfter.childNewV;
			infantNew=divideAdhocOnewayAfter.infantNewV;
	
		scenario=scenario.toUpperCase();
		switch(scenario){	
		case "APPROVE":
			if(newRequestId.contains("GR")){
				rf=new UpdateStatusFormat("Pass",  "5","5","2");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "5","5","2");
				reportList.add(rf);
			} 
			break;
			
		case "ACCEPT":
			if(newRequestId.contains("GR")){
				rf=new UpdateStatusFormat("Pass",  "12","5","2");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "12","5","2");
				reportList.add(rf);
			} 
			break;
			
			default:
				System.out.println("Scenatio Missing Plese check");
			
		}
	}
	public void raiseAdhocRoundTripDivideAfterApprove(String scenario){
		
		
		divideAdhocOnewayAfter=new DivideOnewayAfterApprove(driver);
			divideAdhocOnewayAfter.divideRequest(reqId);
			newRequestId=divideAdhocOnewayAfter.newRequestIDV;
			adultNew=divideAdhocOnewayAfter.adultNewV;
			childNew=divideAdhocOnewayAfter.childNewV;
			infantNew=divideAdhocOnewayAfter.infantNewV;


			scenario=scenario.toUpperCase();
			switch(scenario){	
			case "APPROVE":
				if(newRequestId.contains("GR")){
					rf=new UpdateStatusFormat("Pass",  "7","5","2");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "7","5","2");
					reportList.add(rf);
				} 
				break;
				
			case "ACCEPT":
				if(newRequestId.contains("GR")){
					rf=new UpdateStatusFormat("Pass",  "14","5","2");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "14","5","2");
					reportList.add(rf);
				} 
				break;
				
				default:
					System.out.println("Scenatio Missing Plese check");
				
			}
			 
	}
	public void raiseAdhocMultiCityDivideAfterApprove(String scenario){
		
		
		divideAdhocOnewayAfter=new DivideOnewayAfterApprove(driver);
			divideAdhocOnewayAfter.divideRequest(reqId);
			newRequestId=divideAdhocOnewayAfter.newRequestIDV;
			adultNew=divideAdhocOnewayAfter.adultNewV;
			childNew=divideAdhocOnewayAfter.childNewV;
			infantNew=divideAdhocOnewayAfter.infantNewV;
			scenario=scenario.toUpperCase();
			switch(scenario){	
			case "APPROVE":
				if(newRequestId.contains("GR")){
					rf=new UpdateStatusFormat("Pass",  "9","5","2");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "9","5","2");
					reportList.add(rf);
				} 
				break;
				
			case "ACCEPT":
				if(newRequestId.contains("GR")){
					rf=new UpdateStatusFormat("Pass",  "16","5","2");
					reportList.add(rf);
					 

				}else{
					rf=new UpdateStatusFormat("Fail",  "16","5","2");
					reportList.add(rf);
				} 
				break;
				
				default:
					System.out.println("Scenatio Missing Plese check");
				
			}
			 
	}


	

	public void raiseOnewayDivideBeforeApprove(){
		divideBeforeApprove=new DivideOnewayBeforeApprove(driver);
		divideBeforeApprove.divideRequest(reqId);
		requestStatus=divideBeforeApprove.requestStatusV;
	 
		if(requestStatus.equals("New Request")){
			rf=new UpdateStatusFormat("Pass",  "1","5","2");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "1","5","2");
			reportList.add(rf);
		 

		} 
		
		 
	}
	public void raiseRoundTripDivideBeforeApprove(){
		divideBeforeApprove=new DivideOnewayBeforeApprove(driver);
		divideBeforeApprove.divideRequest(reqId);
		requestStatus=divideBeforeApprove.requestStatusV;
	 
		if(requestStatus.equals("New Request")){
			rf=new UpdateStatusFormat("Pass",  "2","5","2");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "2","5","2");
			reportList.add(rf);
		 

		}  
		
		 
	}
	public void raiseMultiCityDivideBeforeApprove(){
		divideBeforeApprove=new DivideOnewayBeforeApprove(driver);
		divideBeforeApprove.divideRequest(reqId);
		requestStatus=divideBeforeApprove.requestStatusV;
	 
		  
		if(requestStatus.equals("New Request")){
			rf=new UpdateStatusFormat("Pass",  "3","5","2");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "3","5","2");
			reportList.add(rf);
		 

		}  
		 
	}
	
	
	public void processDivideAfterApproveAdhocOneWay(){
		
		processDivide=new ProcessDivideAdhocOneWay(driver);
		 
		try {
			processDivide.processDivideRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parantRequestId=processDivide.parantRequestIdV;
		adultBeforeApprove=processDivide.adultCurrV;
		childBeforeApprove=processDivide.childCurrV;
		infantBeforeApprove=processDivide.infantCurrV;
		adultNewBeforeApprove=processDivide.adultNewV;
		childNewBeforeApprove=processDivide.childNewV;
		infantNewBeforeApprove=processDivide.infantNewV;
		

		if(parantRequestId.equals(reqId)){
				rf=new UpdateStatusFormat("Pass",  "6","5","2");
				reportList.add(rf);
				 

			}else{
				rf=new UpdateStatusFormat("Fail",  "6","5","2");
				reportList.add(rf);
			} 



	}

	
	public void processDivideAfterApproveAdhocRoundTrip(){
		
		processDivide=new ProcessDivideAdhocOneWay(driver);
		 
		try {
			processDivide.processDivideRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parantRequestId=processDivide.parantRequestIdV;
		adultBeforeApprove=processDivide.adultCurrV;
		childBeforeApprove=processDivide.childCurrV;
		infantBeforeApprove=processDivide.infantCurrV;
		adultNewBeforeApprove=processDivide.adultNewV;
		childNewBeforeApprove=processDivide.childNewV;
		infantNewBeforeApprove=processDivide.infantNewV;
		
		if(parantRequestId.equals(reqId)){
			rf=new UpdateStatusFormat("Pass",  "8","5","2");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "8","5","2");
			reportList.add(rf);
		} 

	}

	
	public void processDivideAfterApproveAdhocMultiCity(){
		
		processDivide=new ProcessDivideAdhocOneWay(driver);
		 
		try {
			processDivide.processDivideRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parantRequestId=processDivide.parantRequestIdV;
		adultBeforeApprove=processDivide.adultCurrV;
		childBeforeApprove=processDivide.childCurrV;
		infantBeforeApprove=processDivide.infantCurrV;
		adultNewBeforeApprove=processDivide.adultNewV;
		childNewBeforeApprove=processDivide.childNewV;
		infantNewBeforeApprove=processDivide.infantNewV;
		if(parantRequestId.equals(reqId)){
			rf=new UpdateStatusFormat("Pass",  "10","5","2");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "10","5","2");
			reportList.add(rf);
		} 
	}

	 

	public void processDivideAfterAcceptAdhocOneWay(){
		
		processDivideAfter=new ProcessDivideAdhocOneWayAfterAccept(driver);
		 
		try {
			processDivideAfter.processDivideRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parantRequestId=processDivideAfter.parantRequestIdV;
		adultBeforeApprove=processDivideAfter.adultCurrV;
		childBeforeApprove=processDivideAfter.childCurrV;
		infantBeforeApprove=processDivideAfter.infantCurrV;
		adultNewBeforeApprove=processDivideAfter.adultNewV;
		childNewBeforeApprove=processDivideAfter.childNewV;
		infantNewBeforeApprove=processDivideAfter.infantNewV;
		if(parantRequestId.contains(reqId)){
			rf=new UpdateStatusFormat("Pass",  "13","5","2");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "13","5","2");
			reportList.add(rf);
		} 

	 		
	}

public void processDivideAfterAcceptAdhocRoundTrip(){
		
		processDivideAfter=new ProcessDivideAdhocOneWayAfterAccept(driver);
		 
		try {
			processDivideAfter.processDivideRequest(newRequestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parantRequestId=processDivideAfter.parantRequestIdV;
		adultBeforeApprove=processDivideAfter.adultCurrV;
		childBeforeApprove=processDivideAfter.childCurrV;
		infantBeforeApprove=processDivideAfter.infantCurrV;
		adultNewBeforeApprove=processDivideAfter.adultNewV;
		childNewBeforeApprove=processDivideAfter.childNewV;
		infantNewBeforeApprove=processDivideAfter.infantNewV;

		if(parantRequestId.contains(reqId)){
			rf=new UpdateStatusFormat("Pass",  "15","5","2");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "15","5","2");
			reportList.add(rf);
		} 
	 		
	}
public void processDivideAfterAcceptAdhocMultiCity(){
	
	processDivideAfter=new ProcessDivideAdhocOneWayAfterAccept(driver);
	 
	try {
		processDivideAfter.processDivideRequest(newRequestId);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	parantRequestId=processDivideAfter.parantRequestIdV;
	adultBeforeApprove=processDivideAfter.adultCurrV;
	childBeforeApprove=processDivideAfter.childCurrV;
	infantBeforeApprove=processDivideAfter.infantCurrV;
	adultNewBeforeApprove=processDivideAfter.adultNewV;
	childNewBeforeApprove=processDivideAfter.childNewV;
	infantNewBeforeApprove=processDivideAfter.infantNewV;

	if(parantRequestId.contains(reqId)){
		rf=new UpdateStatusFormat("Pass",  "17","5","2");
		reportList.add(rf);
		 

	}else{
		rf=new UpdateStatusFormat("Fail",  "17","5","2");
		reportList.add(rf);
	} 
 		
}
 


	


}

