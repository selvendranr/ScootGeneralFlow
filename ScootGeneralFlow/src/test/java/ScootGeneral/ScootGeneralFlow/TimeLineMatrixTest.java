package ScootGeneral.ScootGeneralFlow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver; 
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pack.base.CancelPolicyFormat;
import pack.base.ReadCancelPolicyInput;
import pack.base.ReadRootPath;
import pack.base.TestBaseSetup;
import pack.base.UpdateStatusFormat;
import pack.base.WriteTestCaseStatus;


public class TimeLineMatrixTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadCancelPolicyInput read;
	private CreateTimeLineMatrix create;
	private MapTimeLineMatrix map;
	private AdhocOneWayCancelPolicy oneway;
	private AdhocRoundTripCancelPolity roundTrip;
	private AdhocMultiCityCancelPolicy multiCity;
	private ProcessAdhocOneWay processOneway;
	private ProcessAdhocRoundTrip processRoundTrip;
	private ProcessAdhocMultiCity processMultiCity;
	
	private SeriesDateRangeOneWayRequest seriesOneway;
	private SeriesDateRangeRoundTripRequest seriesRoundTrip;
	private SeriesDateRangeMultiCityRequest seriesMultiCity;
	
	
	private ProcessDateRangeOneWayTL processSeriesReq;
 	
	String inputFile="InputFile\\Time Line Matrix Input.xls";
	String reportexcelFile="DataDrivenReport\\Settings Menu Policy Check.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";

	private String slNo,tripType,requestType,noOfPax;
	private boolean runningMode=false;
	String sucessMsgMap,sucessMsg;
	String timeLineMatrixName,timeLineMatrixValidity, payTypeCreate,fareValidityCreate,fareValidityTypeCreate,paymentValidityCreate,paymentValidityTypeCreate,paymentExpiryValidityCreate,paymentValidity2Create,paymentValidityType2Create,paymentExpiryValidity2Create,nameListValidityCreate,nameListValidityTypeCreate,passengerExpiryValidityTypeCreate;
	String policyNameMap,timeLimitMatrixMap,originMap,destinationMap,noOfPaxMap,tripTypeMap,requestTypeMap;
	String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
 	
	String 	 policyNameProcess,fareValitityProcess,paymentValitityProcess,nameListValitityProcess;

	List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	UpdateStatusFormat rf;
	ReadRootPath readRoot=new ReadRootPath();
	String rootPath=readRoot.getPath();
	
	private List<CancelPolicyFormat> inputList=new ArrayList<CancelPolicyFormat>();
	private int indexOfInput;

	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	@Test
	@Parameters({"indexVal"})
	public void createPolicy(int indexVal) throws IOException {
		indexOfInput=indexVal;
		read = new ReadCancelPolicyInput();
		read.getExcelData(rootPath+inputFile);
		inputList=read.inputList;
		slNo=inputList.get(indexOfInput).getSlNo();
		noOfPax=inputList.get(indexOfInput).getNoOfPax();
		tripType=inputList.get(indexOfInput).getTripType();
		requestType=inputList.get(indexOfInput).getRequestType();
		if(inputList.get(indexOfInput).getRunningMode().equalsIgnoreCase("Yes")){
			runningMode=true;	
		}

		if(runningMode){
		create=new CreateTimeLineMatrix(driver);
		create.createTimeLine();
		
		timeLineMatrixName=create.timeLineMatrixNameV;
		payTypeCreate=create.payTypeV;
		fareValidityCreate=create.fareValidityV;
		fareValidityTypeCreate=create.fareValidityTypeV;
		paymentValidityCreate=create.paymentValidityV;
		paymentValidityTypeCreate=create.paymentValidityTypeV;
		paymentExpiryValidityCreate=create.paymentExpiryValidityV;
		paymentValidity2Create=create.paymentValidity2V;
		paymentValidityType2Create=create.paymentValidityType2V;
		paymentExpiryValidity2Create=create.paymentExpiryValidity2V;
		nameListValidityCreate=create.nameListValidityV;
		nameListValidityTypeCreate=create.nameListValidityTypeV;
		passengerExpiryValidityTypeCreate=create.passengerExpiryValidityTypeV;
		sucessMsg=create.sucessMsgV;
		}else{
			driver.close();
		}
		
		}

	@Test(dependsOnMethods = "createPolicy",priority=1)
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
		sucessMsgMap=map.sucessMsgV;
		
		System.out.println("Test"+tripTypeMap);
		}

	}

		
	 
	@Test(dependsOnMethods = "createPolicy",priority=2)
	public void raiseRequest() throws IOException {
		if(runningMode){
		String tripType,reqType;
		reqType=requestTypeMap.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeMap.toUpperCase();
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
		
		}
	}
	 
	@Test(dependsOnMethods = "createPolicy",priority=3)
	public void process()
	{
		if(runningMode){
		String tripType,reqType;	 
		reqType=requestTypeMap.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeMap.toUpperCase();
		tripType=tripType.replaceAll("\\s+", "");
	
	switch(reqType){
	
	case "ADHOC":	 
		switch(tripType){
		case "ONEWAY":
			processOneway=new ProcessAdhocOneWay(driver);
			try {
				processOneway.processAdHocRequest(reqId,"TimeLineMatrix");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 policyNameProcess=processOneway.policyNameV;
			 fareValitityProcess=processOneway.fareValitityV;
			 paymentValitityProcess=processOneway.paymentValitityV;
			 nameListValitityProcess=processOneway.nameListValitityV;
				updateStatus(2);
				verifyPolicy(4);
			 break;
			
		case "ROUNDTRIP":
			processRoundTrip=new ProcessAdhocRoundTrip(driver);
			try {
				processRoundTrip.processAdHocRequest(reqId,"TimeLineMatrix");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 policyNameProcess=processRoundTrip.policyNameV;
			 fareValitityProcess=processRoundTrip.fareValitityV;
			 paymentValitityProcess=processRoundTrip.paymentValitityV;
			 nameListValitityProcess=processRoundTrip.nameListValitityV;
				updateStatus(12);
				verifyPolicy(14);
			break;
		
		case "MULTICITY":
			processMultiCity=new ProcessAdhocMultiCity(driver);
			try {
				processMultiCity.processAdHocRequest(reqId,"TimeLineMatrix");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 policyNameProcess=processMultiCity.policyNameV;
			 fareValitityProcess=processMultiCity.fareValitityV;
			 paymentValitityProcess=processMultiCity.paymentValitityV;
			 nameListValitityProcess=processMultiCity.nameListValitityV;
				updateStatus(22);
				verifyPolicy(24);
			 break;
	
		
		}
		break;
		
		case "SERIES":
			switch(tripType){	

			case "ONEWAY":
				processSeriesReq=new ProcessDateRangeOneWayTL(driver);
				try {
					processSeriesReq.processSeriesRequest(reqId,"TimeLineMatrix");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 policyNameProcess=processSeriesReq.policyNameV;
				 fareValitityProcess=processSeriesReq.fareValitityV;
				 paymentValitityProcess=processSeriesReq.paymentValitityV;
				 nameListValitityProcess=processSeriesReq.nameListValitityV;
					updateStatus(32);
					verifyPolicy(34);
				 break;				
			 
				   
			case "ROUNDTRIP":
				processSeriesReq=new ProcessDateRangeOneWayTL(driver);
				try {
					processSeriesReq.processSeriesRequest(reqId,"TimeLineMatrix");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 policyNameProcess=processSeriesReq.policyNameV;
				 fareValitityProcess=processSeriesReq.fareValitityV;
				 paymentValitityProcess=processSeriesReq.paymentValitityV;
				 nameListValitityProcess=processSeriesReq.nameListValitityV;
					updateStatus(42);
					verifyPolicy(44);
				 break;				

			 
			
			case "MULTICITY":
				processSeriesReq=new ProcessDateRangeOneWayTL(driver);
				try {
					processSeriesReq.processSeriesRequest(reqId,"TimeLineMatrix");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 policyNameProcess=processSeriesReq.policyNameV;
				 fareValitityProcess=processSeriesReq.fareValitityV;
				 paymentValitityProcess=processSeriesReq.paymentValitityV;
				 nameListValitityProcess=processSeriesReq.nameListValitityV;
					updateStatus(52);
					verifyPolicy(54);
				 break;

			
				}
			 break;
			
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
		
	}}
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
	
	

	public void updateStatus(int rowNo){
		
		if(sucessMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;
		} 
		
		if(sucessMsgMap.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;

		}else{
			rf=new UpdateStatusFormat("Fail", ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;
		} 


	}
	
	

	
	
	public void verifyPolicy(int i){
		
		try{
			Assert.assertEquals(policyNameMap	, policyNameProcess);
			rf=new UpdateStatusFormat("Pass", ""+i,"5","0");
			reportList.add(rf);
			i++;

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","0");
			reportList.add(rf);
			System.out.println("1  "+policyNameMap);
			System.out.println("1  "+policyNameProcess);
			System.out.println("1  "+timeLimitMatrixMap);
			i++;

		}
		
		if(fareValitityProcess.contains(fareValidityCreate)){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","0");
			reportList.add(rf);
			i++;
			System.out.println("2  "+fareValitityProcess);
			System.out.println("2  "+fareValidityCreate);
			 
	

		}
		
		if(fareValitityProcess.contains(fareValidityTypeCreate)){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","0");
			reportList.add(rf);
			i++;
			System.out.println("3  "+fareValitityProcess);
			System.out.println("3  "+fareValidityTypeCreate);
		
			
		}
		
		if(paymentValitityProcess.contains(paymentValidityCreate)){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{

			rf=new UpdateStatusFormat("Fail",  ""+i,"5","0");
			reportList.add(rf);
			i++;
			System.out.println("4  "+paymentValitityProcess);
			System.out.println("4  "+paymentValidityCreate);

			
		}
		
		if(paymentValitityProcess.contains(paymentValidityTypeCreate)){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","0");
			reportList.add(rf);
			i++;
			
			System.out.println("5  "+paymentValitityProcess);
			System.out.println("5  "+paymentValidityTypeCreate);


		}
		
		/*if(paymentValitityProcess.toLowerCase().contains(paymentExpiryValidityCreate.toLowerCase() )){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","0");
			reportList.add(rf);
			i++;
		}*/
		
		if(nameListValitityProcess.contains(nameListValidityCreate)){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","0");
			reportList.add(rf);
			i++;
			System.out.println("5  "+nameListValitityProcess);
			System.out.println("5  "+nameListValidityCreate);


		}
		if(nameListValitityProcess.contains(nameListValidityTypeCreate)){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{
			rf=new UpdateStatusFormat("Fail", ""+i,"5","0");
			reportList.add(rf);
			i++;
		}
		
		/* 
		if(nameListValitityProcess.toLowerCase().contains(passengerExpiryValidityTypeCreate.toLowerCase() )){
			rf=new UpdateStatusFormat("Pass",  ""+i,"5","0");
			reportList.add(rf);
			i++;

		}else{
			rf=new UpdateStatusFormat("Fail",""+i,"5","0");
			reportList.add(rf);
			i++;
		}*/
	}
	
	
	}

