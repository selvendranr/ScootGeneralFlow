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

import pack.base.CancelPolicyFormat;
import pack.base.DownSizeFormat;
import pack.base.ReadCancelPolicyInput;
import pack.base.ReadDownSizeInput;
import pack.base.ReadRootPath;
import pack.base.SectorGenerator;
import pack.base.TestBaseSetup;
import pack.base.TimeLimitFormat;
import pack.base.UpdateStatusFormat;
import pack.base.WriteTestCaseStatus;


public class PartialPaymentTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	
	 
	private ReadCancelPolicyInput read;
	private CreateTimeLineMatrixSplitPayment create;
	private MapTimeLineMatrix map;
	private AdhocOneWayCancelPolicy oneway;
	private AdhocRoundTripCancelPolity roundTrip;
	private AdhocMultiCityCancelPolicy multiCity;
	private ProcessNegoAdhocOneWay processOneway;
	private ProcessNegoAdhocRoundTrip processRoundTrip;
	private ProcessNegoAdhocMultiCity processMultiCity;
	
	private SeriesDateRangeOneWayRequest seriesOneway;
	private SeriesDateRangeRoundTripRequest seriesRoundTrip;
	private SeriesDateRangeMultiCityRequest seriesMultiCity;
	
	
	private ProcessDateRangeOneWay processSeriesOneway;
	private ProcessDateRangeRoundTrip processSeriesRoundTrip;
	private ProcessDateRangeMultiCity processSeriesMultiCity;
	
	private AcceptOnewayRequest accept;
	private AcceptDateRangeOneway acceptSeries;
	
	private PaymentAdhocOneWay payment;
	
	//private PaymentApprove approve;
	
	private UpdateNameListAdhocOneWay nameList;
 	
	String inputFile="InputFile\\Time Line Matrix Input.xls";
	String reportexcelFile="DataDrivenReport\\Settings Menu Policy Check.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";
	private String slNo,noOfPax,tripTypeIP,requestTypeIP;
	private boolean runningMode=false;
 
 
	String timeLineMatrixName,timeLineMatrixValidity, payTypeCreate;
	String policyNameMap,timeLimitMatrixMap,originMap,destinationMap,noOfPaxMap,tripTypeMap,requestTypeMap;
	String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
 	
	int paymentSpilit;

	List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	UpdateStatusFormat rf;
	ReadRootPath readRoot=new ReadRootPath();
	String rootPath=readRoot.getPath();
	
	List<TimeLimitFormat> timeMatrixList= new ArrayList<TimeLimitFormat>();
	List<CancelPolicyFormat> inputList=new ArrayList<CancelPolicyFormat>();
	 private int indexOfInput;

	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	
	@Parameters({"indexVal"})
	@Test
	public void readUpSizeInput(int indexVal) throws IOException {
		
		indexOfInput=indexVal;
		read=new ReadCancelPolicyInput ();
		try {
			read.getExcelData(rootPath+inputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputList=read.inputList;
		slNo=inputList.get(indexOfInput).getSlNo();
		noOfPax=inputList.get(indexOfInput).getNoOfPax();
	 
		tripTypeIP=inputList.get(indexOfInput).getTripType();
		requestTypeIP=inputList.get(indexOfInput).getRequestType();
		if(inputList.get(indexOfInput).getRunningMode().equalsIgnoreCase("Yes")){
			runningMode=true;	
		}
		
		System.out.println(slNo+"\t"+tripTypeIP+"\t"+requestTypeIP+"\t"+runningMode);	

		SectorGenerator sector=new SectorGenerator();
		String[] sectorDetails=sector.sectorGenerator(rootPath+sectorInput, delimeter);
		originMap=sectorDetails[0];
		destinationMap=sectorDetails[1];

	}
	/*
	@Test(dependsOnMethods = "readUpSizeInput",priority=0)
	public void createPolicy() throws IOException {
		if(runningMode){

	 
		create=new CreateTimeLineMatrixSplitPayment(driver);
		create.createTimeLine();
		timeMatrixList=create.timeMatrixList;
		timeLineMatrixName=create.timeLineMatrixNameV;
		payTypeCreate=create.payTypeV;
		}else{
			driver.close();
		}
	
		}

	@Test(dependsOnMethods = "readUpSizeInput",priority=1)
	public void mapPolicy() throws IOException {
		if(runningMode){
		map=new MapTimeLineMatrix(driver);
		map.mapTimeLinePolicy(timeLineMatrixName,tripType,requestType,sectorInput,delimeter);
		
	 
		policyNameMap=map.policyNameV;
		timeLimitMatrixMap=map.timeLimitMatrixV;
		originMap=map.origin1V;
		destinationMap=map.destination1V;
		noOfPaxMap=map.noOfPaxV;
		tripTypeMap=map.tripTypeV;
		requestTypeMap=map.requestTypeV;

		System.out.println("Test"+tripTypeMap);
		}
	}
*/
		
	 
	@Test(dependsOnMethods = "readUpSizeInput",priority=2)
	public void raiseRequest() throws IOException {
		if(runningMode){
			 
		String tripType,reqType;
		reqType=requestTypeIP.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeIP.toUpperCase();
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
	 
	@Test(dependsOnMethods = "readUpSizeInput",priority=3)
	public void process()
	{
		if(runningMode){
			 
		String tripType,reqType;
		reqType=requestTypeIP.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeIP.toUpperCase();
		tripType=tripType.replaceAll("\\s+", "");
	
	
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
			accept=new AcceptOnewayRequest(driver);
			accept.acceptRequest( reqId);
			paymentSpilit=accept.paymentSpilit;

			 break;
			
		case "ROUNDTRIP":
			processRoundTrip=new ProcessNegoAdhocRoundTrip(driver);
			try {
				processRoundTrip.processAdHocRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			accept=new AcceptOnewayRequest(driver);
			accept.acceptRequest( reqId);	
			paymentSpilit=accept.paymentSpilit;

			break;
		
		case "MULTICITY":
			processMultiCity=new ProcessNegoAdhocMultiCity(driver);
			try {
				processMultiCity.processAdHocRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accept=new AcceptOnewayRequest(driver);
			accept.acceptRequest( reqId);	
			paymentSpilit=accept.paymentSpilit;

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
				acceptSeries=new AcceptDateRangeOneway(driver);
				acceptSeries.acceptRequest(  reqId);	
				paymentSpilit=acceptSeries.paymentSpilit;
				 break;				
			 
				   
			case "ROUNDTRIP":
				processSeriesRoundTrip=new ProcessDateRangeRoundTrip(driver);
				try {
					processSeriesRoundTrip.processSeriesRequest(reqId);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				acceptSeries=new AcceptDateRangeOneway(driver);
				acceptSeries.acceptRequest(  reqId);	
				paymentSpilit=acceptSeries.paymentSpilit;
				
				 break;				

			 
			
			case "MULTICITY":
				processSeriesMultiCity=new ProcessDateRangeMultiCity(driver);
				try {
					processSeriesMultiCity.processSeriesRequest(reqId);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				acceptSeries=new AcceptDateRangeOneway(driver);
				acceptSeries.acceptRequest(  reqId);	
				paymentSpilit=acceptSeries.paymentSpilit;
				
				 break;

			
				}
			 break;
			
			}	
		
		
	} 
		
		
	}
	
	@Test(dependsOnMethods = "readUpSizeInput",priority=4)
	public void payment()
	{
		if(false){
			 
		String tripType,reqType;
		reqType=tripTypeIP.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=requestTypeIP.toUpperCase();
		tripType=tripType.replaceAll("\\s+", "");
		
	for(int i=1;i<=paymentSpilit;i++){
	switch(reqType){
	
	case "ADHOC":	 
		switch(tripType){
		case "ONEWAY":
			 
			payment=new PaymentAdhocOneWay(driver);
			payment.makePayment(reqId); 			 
			//approve=new PaymentApprove(driver);
			//approve.approve( reqId);	

			 break;
			
		case "ROUNDTRIP":
			payment=new PaymentAdhocOneWay(driver);
			payment.makePayment(reqId); 			 
			//approve=new PaymentApprove(driver);
			//approve.approve( reqId);	

			break;
		
		case "MULTICITY":
			payment=new PaymentAdhocOneWay(driver);
			payment.makePayment(reqId); 			 
			//approve=new PaymentApprove(driver);
			//approve.approve( reqId);	
			break;
	
		
		}
		break;
		
		case "SERIES":
			switch(tripType){	

			case "ONEWAY":
				payment=new PaymentAdhocOneWay(driver);
				payment.makePayment(reqId); 			 
				//approve=new PaymentApprove(driver);
				//approve.approve( reqId);	

				 break;				
			 
				   
			case "ROUNDTRIP":
				payment=new PaymentAdhocOneWay(driver);
				payment.makePayment(reqId); 			 
				//approve=new PaymentApprove(driver);
				//approve.approve( reqId);	

				 break;				

			 
			
			case "MULTICITY":
				payment=new PaymentAdhocOneWay(driver);
				payment.makePayment(reqId); 			 
				//approve=new PaymentApprove(driver);
				//approve.approve( reqId);	

				 break;

			
				}
			 break;
			
			}	
		
		
		}
		
	}
	
		
	}

	@Test(dependsOnMethods = "readUpSizeInput",priority=5)
	public void nameList()
	{ if(false){
		nameList=new UpdateNameListAdhocOneWay(driver);
		nameList.addNameList(reqId); 
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
		driver.quit();
		 try {
				write.writeExcelData(rootPath+reportexcelFile, reportList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	public void raiseOneway(){


			oneway =new AdhocOneWayCancelPolicy(driver);
			oneway.adHocGroupRequest(originMap,destinationMap,noOfPax);
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
		
		roundTrip =new AdhocRoundTripCancelPolity(driver);
		roundTrip.adHocGroupRequest(originMap,destinationMap,noOfPax);
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
		multiCity =new AdhocMultiCityCancelPolicy(driver);
		multiCity.adHocGroupRequest(originMap,destinationMap,noOfPax,rootPath+sectorInput,delimeter);
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

	
	public void raiseSeriesOneway(){
		seriesOneway=new SeriesDateRangeOneWayRequest(driver);
		seriesOneway.seriesDateRangeRequest(originMap,destinationMap,noOfPax);
		
		reqId=seriesOneway.requestID;
	}
	public void raiseSeriesRoundTrip(){
		seriesRoundTrip=new SeriesDateRangeRoundTripRequest(driver);
		seriesRoundTrip.seriesDateRangeRequest(originMap,destinationMap,noOfPax);
		reqId=seriesRoundTrip.requestID;
	}
	public void raiseSeriesMultiCity(){
		seriesMultiCity=new SeriesDateRangeMultiCityRequest(driver);
		seriesMultiCity.seriesDateRangeRequest(originMap,destinationMap,noOfPax,rootPath+sectorInput,delimeter);
		reqId=seriesMultiCity.requestID;
	}
	
	
	

	}

