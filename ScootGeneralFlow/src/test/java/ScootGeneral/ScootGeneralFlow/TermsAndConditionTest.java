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


public class TermsAndConditionTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadCancelPolicyInput read;
	private CreateTermsAndCondition create;
	private MapTermsAndCondition map;
	private AdhocOneWayCancelPolicy oneway;
	private AdhocRoundTripCancelPolity roundTrip;
	private AdhocMultiCityCancelPolicy multiCity;
	private ProcessAdhocOneWay processOneway;
	private ProcessAdhocRoundTrip processRoundTrip;
	private ProcessAdhocMultiCity processMultiCity;
	//private AcceptRequest acceptReq;
	
	
	private SeriesDateRangeOneWayRequest seriesOneway;
	private SeriesDateRangeRoundTripRequest seriesRoundTrip;
	private SeriesDateRangeMultiCityRequest seriesMultiCity;
	
	private ProcessDateRangeOneWayTL processSeriesReq;
	 
 	
	String inputFile="InputFile\\Cancel Policy Input.xls";
	String inputFileTxt="InputFile\\termsAndConditons.txt";
	String reportexcelFile="DataDrivenReport\\Settings Menu Policy Check.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";

	
	String policyName,sucessMsg;
	private String slNo,tripType,requestType,noOfPax;
	private boolean runningMode=false;
	String policyNameMap,cancelMatrixMap,originMap,destinationMap,noOfPaxMap,tripTypeMap,requestTypeMap;
	String sucessMsgMap;
	
	String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
	
	String cancelPolicyName;
	

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
		//System.out.println(noOfPax);
		//System.out.println(runningMode);
		if(runningMode){
		create=new CreateTermsAndCondition(driver);
		create.createTandC(rootPath+inputFileTxt);
		policyName=create.policyNameV;
		sucessMsg=create.sucessMsgV;
		}else{
			driver.close();
		}
		}

	@Test(dependsOnMethods = "createPolicy",priority=1)
	public void mapPolicy() throws IOException {
		if(runningMode){
		map=new MapTermsAndCondition(driver);
		map.mapCancelPolicy(policyName,tripType,requestType,sectorInput,delimeter);
		
	 
		policyNameMap=map.policyNameV;
		cancelMatrixMap=map.cancelMatrixV;
		originMap=map.origin1V;
		destinationMap=map.destination1V;
		noOfPaxMap=map.noOfPaxV;
		tripTypeMap=map.tripTypeV;
		requestTypeMap=map.requestTypeV;
		sucessMsgMap=map.sucessMsgV;
		
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
			updateStatus(2); 
			break;
			
		case "ROUNDTRIP":
			raiseRoundTrip();
			updateStatus(6); 
			 
			break;
		
		case "MULTICITY":
			raiseMultiCity();
			updateStatus(10);  
			break;
	
		
		}
		break;
		
	case "SERIES":
		switch(tripType){
		case "ONEWAY":
			raiseSeriesOneway();
			updateStatus(14);  			
			break;
			
		case "ROUNDTRIP":
			raiseSeriesRoundTrip();	
			updateStatus(18);  
			break;
		
		case "MULTICITY":
			raiseSeriesMultiCity();	
			updateStatus(22);  
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
				processOneway.processAdHocRequest(reqId,"Cancel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancelPolicyName=processOneway.cancelPolicyNameV;
			
			verifyPolicy(4);
			break;
			
		case "ROUNDTRIP":
			processRoundTrip=new ProcessAdhocRoundTrip(driver);
			try {
				processRoundTrip.processAdHocRequest(reqId,"Cancel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancelPolicyName=processRoundTrip.cancelPolicyNameV;
			verifyPolicy(8);
			break;
		
		case "MULTICITY":
			processMultiCity=new ProcessAdhocMultiCity(driver);
			try {
				processMultiCity.processAdHocRequest(reqId,"Cancel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancelPolicyName=processMultiCity.cancelPolicyNameV; 
			verifyPolicy(12);
			break;
	
		
		}
		break;
		
	case "SERIES":
		switch(tripType){
		
		

		case "ONEWAY":
			processSeriesReq=new ProcessDateRangeOneWayTL(driver);
			try {
				processSeriesReq.processSeriesRequest(reqId,"Cancel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancelPolicyName=processSeriesReq.cancelPolicyNameV;
			verifyPolicy(16);
			
			break;
			
		case "ROUNDTRIP":
			processSeriesReq=new ProcessDateRangeOneWayTL(driver);
			try {
				processSeriesReq.processSeriesRequest(reqId,"Cancel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancelPolicyName=processSeriesReq.cancelPolicyNameV;
			verifyPolicy(20);
			break;
		 
		
		case "MULTICITY":
			processSeriesReq=new ProcessDateRangeOneWayTL(driver);
			try {
				processSeriesReq.processSeriesRequest(reqId,"Cancel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancelPolicyName=processSeriesReq.cancelPolicyNameV;
				verifyPolicy(24);
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
			rf=new UpdateStatusFormat("Pass",  ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;
		} 
		
		if(sucessMsgMap.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;

		}else{
			rf=new UpdateStatusFormat("Fail", ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;
		} 


	}
	
	
	
	
	
	public void verifyPolicy(int i){
		
		try{
			Assert.assertEquals(cancelMatrixMap	, cancelPolicyName);
			rf=new UpdateStatusFormat("Pass", ""+i,"5","1");
			reportList.add(rf);
			 

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","1");
			reportList.add(rf);
			System.out.println("1  "+cancelMatrixMap);
			System.out.println("1  "+cancelPolicyName);
			 
		 

		}
	
	
	}
	
	
	
}



