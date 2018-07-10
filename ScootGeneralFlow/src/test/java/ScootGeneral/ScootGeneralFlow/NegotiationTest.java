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

import pack.base.NegotiatePolicyFormat;
import pack.base.ReadNegotiationPolicyInput;
import pack.base.ReadRootPath;
import pack.base.TestBaseSetup;
import pack.base.UpdateStatusFormat;
import pack.base.WriteTestCaseStatus;


public class NegotiationTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadNegotiationPolicyInput read;
	private MapNegotiationPolicy map;
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
	
	private AcceptRequest accept;
	private AcceptSeriesDateRangeOneway acceptSeries;
	
	private ProcessNegotiateAdhocOneWay processNegoOneWay;
	private ProcessNegotiateAdhocRoundTrip processNegoRoundTrip;
	private ProcessNegotiateAdhocMultiCity processNegoMultiCity;
	
	private NegotiateDateRangeOneWay processNegoDateRangeOneWay;
	
	String inputFile="InputFile\\Negotiation Policy Input.xls";
	String reportexcelFile="DataDrivenReport\\Settings Menu Policy Check.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";
	
	private String slNo,noOfPax,tripType,requestType,noOfTime;
	private boolean runningMode=false;
	private String sucessMsgMap,policyNameMap,tripTypeMap,requestTypeMap,noOfTimeMap;
	private String originMap1,destinationMap1,originMap2,destinationMap2,originMap3,destinationMap3;
	private String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	private String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
 	
	private List<NegotiatePolicyFormat> inputList=new ArrayList<NegotiatePolicyFormat>();


	private List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	private WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	private UpdateStatusFormat rf;
	private ReadRootPath readRoot=new ReadRootPath();
	private String rootPath=readRoot.getPath();

	private int negoLimit,negoInit=1;
	private int negotiatedTimes,rowOrder;
	private int indexOfInput;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test(priority=0)
	@Parameters({"indexVal"})
	public void readInput(int indexVal) throws IOException {
		indexOfInput=indexVal;
		read=new ReadNegotiationPolicyInput ();
		read.getExcelData(rootPath+inputFile);
		inputList=read.inputList;
		slNo=inputList.get(indexOfInput).getSlNo();
		noOfPax=inputList.get(indexOfInput).getNoOfPax();
		tripType=inputList.get(indexOfInput).getTripType();
		requestType=inputList.get(indexOfInput).getRequestType();
		noOfTime=inputList.get(indexOfInput).getNoOfTime();
		negoLimit=Integer.parseInt(noOfTime);
		if(inputList.get(indexOfInput).getRunningMode().equalsIgnoreCase("Yes")){
			runningMode=true;	
		}
		
		System.out.println(slNo+"\t"+tripType+"\t"+requestType+"\t"+runningMode);

	}
	
	
	@Test(priority=1)
	public void mapPolicy() throws IOException {
		if(runningMode){
		map=new MapNegotiationPolicy(driver);
		map.mapPolicy(tripType,requestType,noOfTime,sectorInput,delimeter);

		policyNameMap=map.policyNameV;
		originMap1=map.origin1V;
		destinationMap1=map.destination1V;
		originMap2=map.origin2V;
		destinationMap2=map.destination2V;
		originMap3=map.origin3V;
		destinationMap3=map.destination3V;

		//noOfPaxMap=map.noOfPaxV;
		tripTypeMap=map.tripTypeV;
		requestTypeMap=map.requestTypeV;
		noOfTimeMap=map.noTimeV;
		sucessMsgMap=map.sucessMsgV;
		}else {
			driver.close();
		}
		 
	}

		
	 
	@Test(dependsOnMethods = "mapPolicy",priority=2)
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
				 verifyPolicy(2);
				break;
				
			case "ROUNDTRIP":
				raiseRoundTrip();
				 verifyPolicy(5);
				break;
			
			case "MULTICITY":
				raiseMultiCity();	
				 verifyPolicy(8);
				break;
		
			
			}
			break;
			
		case "SERIES":
			switch(tripType){
			case "ONEWAY":
				raiseSeriesOneway();
				 verifyPolicy(11);
				break;
				
			case "ROUNDTRIP":
				raiseSeriesRoundTrip();		
				 verifyPolicy(14);
				break;
			
			case "MULTICITY":
				raiseSeriesMultiCity();		
				 verifyPolicy(17);
				break;
		
			
			}
			break;
	
		case "CONFERENCE":
			System.out.println("Conference is not available as of now ");
			break;
			
			
		}
 
		}
		
	
	}
	 
	@Test(dependsOnMethods = "mapPolicy",priority=3)
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
			processOneway=new ProcessNegoAdhocOneWay(driver);
			try {
				processOneway.processAdHocRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
				 
			 break;
			
		case "ROUNDTRIP":
			processRoundTrip=new ProcessNegoAdhocRoundTrip(driver);
			try {
				processRoundTrip.processAdHocRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
			break;
		
		case "MULTICITY":
			processMultiCity=new ProcessNegoAdhocMultiCity(driver);
			try {
				processMultiCity.processAdHocRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		  
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
			
			break;
			
		case "ROUNDTRIP":
			processSeriesRoundTrip=new ProcessDateRangeRoundTrip(driver);
			try {
				processSeriesRoundTrip.processSeriesRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		
		case "MULTICITY":
			processSeriesMultiCity=new ProcessDateRangeMultiCity(driver);
			try {
				processSeriesMultiCity.processSeriesRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
	
		
			}
		 break;
		
		}	
		 
		}
		
	}
	 
	@Test(dependsOnMethods = "mapPolicy",priority=4)
	public void acceptAndNegotiate()
	{
		
		
		if(runningMode){
		
		String tripType,reqType;
		reqType=requestTypeMap.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeMap.toUpperCase();
		tripType=tripType.replaceAll("\\s+", "");
		
		switch(reqType){
		case "ADHOC":
			accept=new AcceptRequest(driver);
			accept.acceptRequest( reqId,0,noOfTime);		
			break;

		case "SERIES":
			acceptSeries=new AcceptSeriesDateRangeOneway(driver);
			acceptSeries.acceptRequest(  reqId,0,noOfTime);	
			break;
		
		}
		
		 
		
		}
	 
	 
		 	
	}

	@Test(dependsOnMethods = "mapPolicy",priority=4)
	public void negotiate()
	{	if(runningMode){
		String tripType,reqType;	 
		reqType=requestTypeMap.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeMap.toUpperCase();
		tripType=tripType.replaceAll("\\s+", "");
	
	
		for(int i=1;i<=negoLimit;i++){
		
		
	switch(reqType){
	
	case "ADHOC":
		 
		switch(tripType){
		case "ONEWAY":
			processNegoOneWay=new ProcessNegotiateAdhocOneWay(driver);
			try {
				processNegoOneWay.processAdHocRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 			 
			 break;
			
		case "ROUNDTRIP":
			processNegoRoundTrip=new ProcessNegotiateAdhocRoundTrip(driver);
			try {
				processNegoRoundTrip.processAdHocRequest(reqId );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case "MULTICITY":
			processNegoMultiCity=new ProcessNegotiateAdhocMultiCity(driver);
			try {
				processNegoMultiCity.processAdHocRequest(reqId );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 break;
		
			 
		 
		
		}
		 break;
		case "SERIES":
		switch(tripType){
		
		

		case "ONEWAY":
			processNegoDateRangeOneWay=new NegotiateDateRangeOneWay(driver);
			try {
				processNegoDateRangeOneWay.processSeriesRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
			
		case "ROUNDTRIP":
			processNegoDateRangeOneWay=new NegotiateDateRangeOneWay(driver);
			try {
				processNegoDateRangeOneWay.processSeriesRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		
		case "MULTICITY":
			processNegoDateRangeOneWay=new NegotiateDateRangeOneWay(driver);
			try {
				processNegoDateRangeOneWay.processSeriesRequest(reqId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
			   
		
			}
		 break;
		}	
	switch(reqType){
	case "ADHOC":
		accept=new AcceptRequest(driver);
		accept.acceptRequest( reqId,i,noOfTime);		
		break;

	case "SERIES":
		acceptSeries=new AcceptSeriesDateRangeOneway(driver);
		acceptSeries.acceptRequest(  reqId,i,noOfTime);	
		break;
	
	}
	
	negotiatedTimes=i;
		}//for Loop End	
		
		verifyPolicy2();	
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
			oneway.adHocGroupRequest(originMap1,destinationMap1,noOfPax);
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
		roundTrip.adHocGroupRequest(originMap1,destinationMap1,noOfPax);
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
		multiCity.adHocGroupRequest(originMap1,destinationMap1,noOfPax,rootPath+sectorInput,delimeter);
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
		seriesOneway.seriesDateRangeRequest(originMap1,destinationMap1,noOfPax);
		reqId=seriesOneway.requestID;
	}
	public void raiseSeriesRoundTrip(){
		seriesRoundTrip=new SeriesDateRangeRoundTripRequest(driver);
		seriesRoundTrip.seriesDateRangeRequest(originMap1,destinationMap1,noOfPax);
		reqId=seriesRoundTrip.requestID;
	}
	public void raiseSeriesMultiCity(){
		seriesMultiCity=new SeriesDateRangeMultiCityRequest(driver);
		seriesMultiCity.seriesDateRangeRequest(originMap1,destinationMap1,noOfPax,rootPath+sectorInput,delimeter);
		reqId=seriesMultiCity.requestID;
	}
	
	
	
	
	 
	public void verifyPolicy(int i){
		if(reqId.contains("GRP")){
			rf=new UpdateStatusFormat(reqId,  ""+i,"6","3");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat(reqId,  ""+i,"6","3");
			reportList.add(rf);
		 

		}
		try{
			Assert.assertEquals(sucessMsgMap	, "Policy created successfully");
			rf=new UpdateStatusFormat("Pass", ""+i,"5","3");
			reportList.add(rf);			
			rowOrder=i+1;

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+i,"5","3");
			reportList.add(rf);
			rowOrder=i+1;

		}
		
		

	}
	 
	public void verifyPolicy2(){
		
		try{
			Assert.assertEquals(""+negotiatedTimes	, noOfTime);
			rf=new UpdateStatusFormat("Pass", ""+rowOrder,"5","3");
			reportList.add(rf);		
			System.out.println(negotiatedTimes);
			System.out.println(noOfTime);

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+rowOrder,"5","3");
			reportList.add(rf);
			System.out.println(negotiatedTimes);
			System.out.println("False"+noOfTime);
	 
			
		}
		
	}
	
	}

