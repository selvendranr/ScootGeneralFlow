package ScootGeneral.ScootGeneralFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pack.base.PolicySettingsFormat;
import pack.base.ReadPolicySettingsInput;
import pack.base.ReadRootPath;
import pack.base.TestBaseSetup;
import pack.base.UpdateStatusFormat;
import pack.base.WriteTestCaseStatus;


public class RequestPolicySettingsTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadPolicySettingsInput read;
	private CreateRequestPolicy create;
	private MapRequestPolicy map;	 
	private AdhocOneWayRequestPolicy oneway;
	private AdhocRoundTripRequestPolity roundTrip;
	private AdhocMultiCityRequestPolicy multiCity;
	
	private SeriesDateRangeOneWayRequestPolicy seriesOneway;
	private SeriesDateRangeRoundTripRequestPolicy seriesRoundTrip;
	private SeriesDateRangeMultiCityRequestPolicy seriesMultiCity;


	String inputFile="InputFile\\Request Policy Input.xls";
	String reportexcelFile="DataDrivenReport\\Settings Menu Policy Check.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";

	private String slNo,tripType,requestType;
	private boolean runningMode=false;

	String criteriaName,guestMin,guestMax,infantMin,infantMax;
 
	String policyNameMap,requestMatrixMap,tripTypeMap,requestTypeMap;
	String originMap1,destinationMap1,originMap2,destinationMap2,originMap3,destinationMap3;
	
	String groupNameReq,origin1Req,destination1Req,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;

	String origin2Req,destination2Req,origin3Req,destination3Req;
	String paxMinimumError1,paxMinimumError2,paxMaxError1,paxMaxError2,infantMaxError,infantMinimumError;
	String requestID;
	String sucessMsg,sucessMsgMap;
	
	List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	 List<PolicySettingsFormat> inputList=new ArrayList<PolicySettingsFormat>();
	 private int indexOfInput;
	WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	UpdateStatusFormat rf;
	ReadRootPath readRoot=new ReadRootPath();
	String rootPath=readRoot.getPath();


	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	@Test
	@Parameters({"indexVal"})
	public void createPolicy(int indexVal) throws IOException {
		
		read=new ReadPolicySettingsInput ();
		read.getExcelData(rootPath+inputFile);
		indexOfInput=indexVal;
		inputList=read.inputList;
		slNo=inputList.get(indexOfInput).getSlNo();		 
		tripType=inputList.get(indexOfInput).getTripType();
		requestType=inputList.get(indexOfInput).getRequestType();
		if(inputList.get(indexOfInput).getRunningMode().equalsIgnoreCase("Yes")){
			runningMode=true;	
		}
	
		if(runningMode){
		create=new CreateRequestPolicy(driver);
		create.createCriteria();
		criteriaName=create.criteriaNameV;
		guestMin=create.guestMinV;
		guestMax=create.guestMaxV;
		  infantMin=""+0; 
		 infantMax=""+0;
	
		
		// infantMin=create.infantMinV; 
		// infantMax=create.infantMaxV;
		//infantMin="0"; 
		//infantMax="0";
		sucessMsg=create.sucessMsgV;
		}else{
			driver.close();
		}
	
		
	}

	@Test(dependsOnMethods = "createPolicy",priority=1)
	public void mapPolicy() throws IOException {
		map=new MapRequestPolicy(driver);
		map.mapCriteria(tripType,requestType,criteriaName,sectorInput,delimeter);
		policyNameMap=map.policyNameV;
		requestMatrixMap=map.requestMatrixV;
		originMap1=map.origin1V;
		destinationMap1=map.destination1V;
		originMap2=map.origin2V;
		destinationMap2=map.destination2V;		 
		originMap3=map.origin3V;
		destinationMap3=map.destination3V;	
		tripTypeMap=map.tripTypeV;
		requestTypeMap=map.requestTypeV;
		sucessMsgMap=map.sucessMsgV;
	}

		
	  
	@Test(dependsOnMethods = "createPolicy",priority=2)
	public void raiseRequest() throws IOException {
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
	
		default:
			System.out.println("Invalid Trip");
		
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


		oneway =new AdhocOneWayRequestPolicy(driver);
		oneway.adHocGroupRequest(originMap1,destinationMap1,guestMin,guestMax,infantMin,infantMax);
		groupNameReq=oneway.groupNameV;
		origin1Req=oneway.originV;
		destination1Req=oneway.destinationV;
		adultReq=oneway.adultV;
		childReq=oneway.childV;
		infantReq=oneway.infantV;
		expectedReq=oneway.expectedFareV;
		reqId=oneway.requestID;
		remarkReq=oneway.remarkV;
	
		paxMinimumError1=oneway.paxMinimumError1V;
		paxMinimumError2=oneway.paxMinimumError2V;
		paxMaxError1=oneway.paxMaxError1V;
		paxMaxError2=oneway.paxMaxError2V;
		infantMaxError=oneway.infantMaxErrorV;
		infantMinimumError=oneway.infantMinimumErrorV;
		requestID=oneway.requestID;
		System.out.println(paxMinimumError1+"\n"+paxMinimumError2+"\n"+paxMaxError1+"\n"+paxMaxError2+"\n"+infantMaxError+"\n"+infantMinimumError);
		 verifyPolicy(1);
}

public void raiseRoundTrip(){
	
	roundTrip =new AdhocRoundTripRequestPolity(driver);
	roundTrip.adHocGroupRequest(originMap1,destinationMap1,guestMin,guestMax,infantMin,infantMax);
	groupNameReq=roundTrip.groupNameV;
	origin1Req=roundTrip.originV;
	destination1Req=roundTrip.destinationV;
	adultReq=roundTrip.adultV;
	childReq=roundTrip.childV;
	infantReq=roundTrip.infantV;
	expectedReq=roundTrip.expectedFareV;
	reqId=roundTrip.requestID;
	remarkReq=roundTrip.remarkV;
	paxMinimumError1=roundTrip.paxMinimumError1V;
	paxMinimumError2=roundTrip.paxMinimumError2V;
	paxMaxError1=roundTrip.paxMaxError1V;
	paxMaxError2=roundTrip.paxMaxError2V;
	infantMaxError=roundTrip.infantMaxErrorV;
	infantMinimumError=roundTrip.infantMinimumErrorV;
	requestID=roundTrip.requestID;

	System.out.println(paxMinimumError1+"\n"+paxMinimumError2+"\n"+paxMaxError1+"\n"+paxMaxError2+"\n"+infantMaxError+"\n"+infantMinimumError);
	 verifyPolicy(9);
}

public void raiseMultiCity(){
	multiCity =new AdhocMultiCityRequestPolicy(driver);
	multiCity.adHocGroupRequest(originMap1,destinationMap1,guestMin,guestMax,infantMin,infantMax,rootPath+sectorInput,delimeter);
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
	
	
	paxMinimumError1=multiCity.paxMinimumError1V;
	paxMinimumError2=multiCity.paxMinimumError2V;
	paxMaxError1=multiCity.paxMaxError1V;
	paxMaxError2=multiCity.paxMaxError2V;
	infantMaxError=multiCity.infantMaxErrorV;
	infantMinimumError=multiCity.infantMinimumErrorV;
	requestID=multiCity.requestID;


	System.out.println(paxMinimumError1+"\n"+paxMinimumError2+"\n"+paxMaxError1+"\n"+paxMaxError2+"\n"+infantMaxError+"\n"+infantMinimumError);
	 verifyPolicy(17);
}

public void raiseSeriesOneway(){
	
	seriesOneway =new SeriesDateRangeOneWayRequestPolicy(driver);
	seriesOneway.seriesDateRangeRequest(originMap1,destinationMap1,guestMin,guestMax,infantMin,infantMax);

	paxMinimumError1=seriesOneway.paxMinimumError1V;
	paxMinimumError2=seriesOneway.paxMinimumError2V;
	paxMaxError1=seriesOneway.paxMaxError1V;
	paxMaxError2=seriesOneway.paxMaxError2V;
	infantMaxError=seriesOneway.infantMaxErrorV;
	infantMinimumError=seriesOneway.infantMinimumErrorV;
	requestID=seriesOneway.requestID;
	
	 
	verifyPolicySeries(25);

}
	

public void raiseSeriesRoundTrip(){
	seriesRoundTrip =new SeriesDateRangeRoundTripRequestPolicy(driver);
	seriesRoundTrip.seriesDateRangeRequest(originMap1,destinationMap1,guestMin,guestMax,infantMin,infantMax);

	paxMinimumError1=seriesRoundTrip.paxMinimumError1V;
	paxMinimumError2=seriesRoundTrip.paxMinimumError2V;
	paxMaxError1=seriesRoundTrip.paxMaxError1V;
	paxMaxError2=seriesRoundTrip.paxMaxError2V;
	infantMaxError=seriesRoundTrip.infantMaxErrorV;
	infantMinimumError=seriesRoundTrip.infantMinimumErrorV;
	requestID=seriesRoundTrip.requestID;

	
	verifyPolicySeries(33);
	
}

public void raiseSeriesMultiCity(){
	seriesMultiCity =new SeriesDateRangeMultiCityRequestPolicy(driver);
	seriesMultiCity.seriesDateRangeRequest(originMap1,destinationMap1,guestMin,guestMax,infantMin,infantMax,rootPath+sectorInput,delimeter);

	paxMinimumError1=seriesMultiCity.paxMinimumError1V;
	paxMinimumError2=seriesMultiCity.paxMinimumError2V;
	paxMaxError1=seriesMultiCity.paxMaxError1V;
	paxMaxError2=seriesMultiCity.paxMaxError2V;
	infantMaxError=seriesMultiCity.infantMaxErrorV;
	infantMinimumError=seriesMultiCity.infantMinimumErrorV;
	requestID=seriesMultiCity.requestID;
  
	verifyPolicySeries(41);
	
}


public void verifyPolicy(int i){
	
	if(requestID.contains("GRP")){
		rf=new UpdateStatusFormat(requestID,  ""+i,"7","2");
		reportList.add(rf);
		 

	}else{
		rf=new UpdateStatusFormat(requestID,  ""+i,"7","2");
		reportList.add(rf);
	 

	}
	

	
	if(paxMinimumError1.contains("The number of guests should be greater than or equal to")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}

	if(paxMinimumError2.contains("The number of guests should be greater than or equal to")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(infantMinimumError.contains("The minimum number of infant should be")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(paxMaxError1.contains("Total number of guests should not exceed")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(paxMaxError2.contains("Total number of guests should not exceed")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(infantMaxError.contains("The number of infant should not exceed")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	

	if(requestID.contains("GRP")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		 

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
	 

	}
	
  
}



public void verifyPolicySeries(int i){
	
	if(requestID.contains("GRP")){
		rf=new UpdateStatusFormat(requestID,  ""+i,"7","2");
		reportList.add(rf);
		 

	}else{
		rf=new UpdateStatusFormat(requestID,  ""+i,"7","2");
		reportList.add(rf);
	 

	}
	

	
	if(paxMinimumError1.contains("The number of guests should be greater than or equal to")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}

	if(paxMinimumError2.contains("The number of guests should be greater than or equal to")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(infantMinimumError.contains("The minimum number of infant should be")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(paxMaxError1.contains("Total number of guests should not exceed")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(paxMaxError2.contains("Total number of guests should not exceed")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}
	if(infantMaxError.contains("The number of infant should not exceed")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
		i++;

	}

	if(requestID.contains("GRP")){
		rf=new UpdateStatusFormat("Pass",  ""+i,"6","2");
		reportList.add(rf);
		 

	}else{
		rf=new UpdateStatusFormat("Fail",  ""+i,"6","2");
		reportList.add(rf);
	 

	}

	
  
}

}



