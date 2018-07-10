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

import pack.base.DiscountMatrixFormat;
import pack.base.FareSettingsFormat;
import pack.base.ReadFareSettingInput;
import pack.base.ReadRootPath;
import pack.base.TestBaseSetup;
import pack.base.UpdateStatusFormat;
import pack.base.WriteTestCaseStatus;


public class DiscountFareTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadFareSettingInput read;
	private CreateDiscountMatrix create;
	private MapDiscountPolicy map;
	
	private AdhocOneWayDiscount oneway;
	private AdhocRoundTripDiscount roundTrip;
	private AdhocMultiCityDiscount multiCity;
	private ProcessAdhocOneWay processOneway;
	private ProcessAdhocRoundTrip processRoundTrip;
	private ProcessAdhocMultiCity processMultiCity;
	
	private SeriesDateRangeOneWayDiscount seriesOneway;
	private SeriesDateRangeRoundTripDiscount seriesRoundTrip;
	private SeriesDateRangeMultiCityDiscount seriesMultiCity;
	
	
	private ProcessDateRangeOneWayTL processSeriesOW;
	private ProcessDateRangeRoundTripTL processSeriesRT;
	private ProcessDateRangeMultiCityTL processSeriesMT;
 	
	String inputFile="InputFile\\Discount Fare Settings.xls";
	String reportexcelFile="DataDrivenReport\\Fare Settup.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";

	private String slNo,tripType,requestType;
	private boolean runningMode=false;
	private String discountMatrix,sucessMsg;
	private String policyNameMap,discountMatrixMap,origin1Map,destination1Map,origin2Map,destination2Map,origin3Map,destination3Map,tripTypeMap,requestTypeMap;
	private String sucessMsgMap;
	private String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	private String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
 	
	private String discountApplied,bookedLoadFactor,daysToDepart;

	private float adultActual,adultNewFare,adultDiscount;
	private float discount;
	private float adultCalculatedDiscount;
	private float adultCalculatedNewFare;
	
	private int discountValueCalculated = 0;
	
	private String discountApplied2,bookedLoadFactor2,daysToDepart2;
	private float adultActual2,adultNewFare2,adultDiscount2;
	private float discount2;
	private float adultCalculatedDiscount2;
	private float adultCalculatedNewFare2;	
	private int discountValueCalculated2 = 0;

	private String discountApplied3,bookedLoadFactor3,daysToDepart3;
	private float adultActual3,adultNewFare3,adultDiscount3;
	private float discount3;
	private float adultCalculatedDiscount3;
	private float adultCalculatedNewFare3;	
	private int discountValueCalculated3 = 0;

	private List<DiscountMatrixFormat> discountList= new ArrayList<DiscountMatrixFormat>();
	private int lf[];
	
	private List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	private WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	private UpdateStatusFormat rf;
	private ReadRootPath readRoot=new ReadRootPath();
	private String rootPath=readRoot.getPath();
	
	private List<FareSettingsFormat> inputList=new ArrayList<FareSettingsFormat>();
	private int indexOfInput;


	
	@BeforeClass
	public void setUp() {		 
		driver=getDriver(); 
		
	}
	
	@Parameters({"indexVal"})
	@Test(priority=0)
	public void readInput(int indexVal){
		indexOfInput=indexVal;
		read=new ReadFareSettingInput ();
		try {
			read.getExcelData(rootPath+inputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputList=read.inputList;
		slNo=inputList.get(indexOfInput).getSlNo();
		tripType=inputList.get(indexOfInput).getTripType();
		requestType=inputList.get(indexOfInput).getRequestType();
		if(inputList.get(indexOfInput).getRunningMode().equalsIgnoreCase("Yes")){
			runningMode=true;	
		}
		
		System.out.println(slNo+"\t"+tripType+"\t"+requestType+"\t"+runningMode);	
		
	}
	

	@Test(priority=1)
	public void createPolicy() throws IOException {
		
				//requestType=read.requestTypeV;
		if(runningMode){
	 
		create=new CreateDiscountMatrix(driver);
		create.createMatrix();
		discountMatrix=create.profileNameV;
		discountList=create.timeMatrixList;
		sucessMsg=create.sucessMsgV;
		lf=create.LF;
		for(int i=0;i<lf.length;i++){
			System.out.println(lf[i]);
			}
		}else{
			driver.close();
		}

		
		
		}

	@Test(dependsOnMethods = "createPolicy",priority=2)
	public void mapPolicy() throws IOException {
		if(runningMode){
		map=new MapDiscountPolicy(driver);
		map.mapDiscountPolicy(discountMatrix,tripType,requestType,sectorInput,delimeter);
		
	 
		policyNameMap=map.policyNameV;
		discountMatrixMap=map.discountMatrixV;
		origin1Map=map.origin1V;
		destination1Map=map.destination1V;
		origin2Map=map.origin2V;
		destination2Map=map.destination2V;
		origin3Map=map.origin3V;
		destination3Map=map.destination3V;
		tripTypeMap=map.tripTypeV;
		requestTypeMap=map.requestTypeV;
		sucessMsgMap=map.sucessMsgV;
		System.out.println("Test"+tripTypeMap);
		}

	}

		
	 
	@Test(dependsOnMethods = "createPolicy",priority=3)
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
		
		
	}}
		
	
	}
	 
	@Test(dependsOnMethods = "createPolicy",priority=4)
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
				processOneway.processAdHocRequest(reqId,"DISCOUNT");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			discountApplied=processOneway.discountAppliedV;
			bookedLoadFactor=processOneway.bookedLoadFactorV;
			daysToDepart=processOneway.daysToDepartV;
			adultActual=processOneway.adultActualF;
			//childActual=processOneway.childActualF;
			adultNewFare=processOneway.adultNewFareF;
			//childNewFare=processOneway.childNewFareF;
			adultDiscount=processOneway.adultDiscountF;
			//childDiscount=processOneway.childDiscountF;
			discount=processOneway.discountF;
			adultCalculatedDiscount=processOneway.adultCalculatedDiscountF;
			//childCalculatedDiscount=processOneway.childCalculatedDiscountF;
			adultCalculatedNewFare=processOneway.adultCalculatedNewFareF;
			//childCalculatedNewFare=processOneway.childCalculatedNewFareF;

			 verifyDiscountPolicy();			 
			 updateStatus(2);
			 break;
			
		case "ROUNDTRIP":
			processRoundTrip=new ProcessAdhocRoundTrip(driver);
			try {
				processRoundTrip.processAdHocRequest(reqId,"DISCOUNT");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				discountApplied=processRoundTrip.discountAppliedV;
				bookedLoadFactor=processRoundTrip.bookedLoadFactorV;
				daysToDepart=processRoundTrip.daysToDepartV;
				adultActual=processRoundTrip.adultActualF;
				//childActual=processRoundTrip.childActualF;
				adultNewFare=processRoundTrip.adultNewFareF;
				//childNewFare=processRoundTrip.childNewFareF;
				adultDiscount=processRoundTrip.adultDiscountF;
				//childDiscount=processRoundTrip.childDiscountF;
				discount=processRoundTrip.discountF;
				adultCalculatedDiscount=processRoundTrip.adultCalculatedDiscountF;
				//childCalculatedDiscount=processRoundTrip.childCalculatedDiscountF;
				adultCalculatedNewFare=processRoundTrip.adultCalculatedNewFareF;
				//childCalculatedNewFare=processRoundTrip.childCalculatedNewFareF;
				verifyDiscountPolicy();
				discountApplied2=processRoundTrip.discountApplied2V;
				bookedLoadFactor2=processRoundTrip.bookedLoadFactor2V;
				daysToDepart2=processRoundTrip.daysToDepart2V;
				adultActual2=processRoundTrip.adultActual2F;
				//childActual2=processRoundTrip.childActual2F;
				adultNewFare2=processRoundTrip.adultNewFare2F;
				//childNewFare2=processRoundTrip.childNewFare2F;
				adultDiscount2=processRoundTrip.adultDiscount2F;
				//childDiscount2=processRoundTrip.childDiscount2F;
				discount2=processRoundTrip.discount2F;
				adultCalculatedDiscount2=processRoundTrip.adultCalculatedDiscount2F;
				//childCalculatedDiscount2=processRoundTrip.childCalculatedDiscount2F;
				adultCalculatedNewFare2=processRoundTrip.adultCalculatedNewFare2F;
				//childCalculatedNewFare2=processRoundTrip.childCalculatedNewFare2F;
				verifyDiscountPolicy2();				
				updateStatus(8);
				updateStatus2(13);

			break;
		
		case "MULTICITY":
			processMultiCity=new ProcessAdhocMultiCity(driver);
			try {
				processMultiCity.processAdHocRequest(reqId,"DISCOUNT");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			discountApplied=processMultiCity.discountAppliedV;
			bookedLoadFactor=processMultiCity.bookedLoadFactorV;
			daysToDepart=processMultiCity.daysToDepartV;
			adultActual=processMultiCity.adultActualF;
			//childActual=processMultiCity.childActualF;
			adultNewFare=processMultiCity.adultNewFareF;
			//childNewFare=processMultiCity.childNewFareF;
			adultDiscount=processMultiCity.adultDiscountF;
			//childDiscount=processMultiCity.childDiscountF;
			discount=processMultiCity.discountF;
			adultCalculatedDiscount=processMultiCity.adultCalculatedDiscountF;
			//childCalculatedDiscount=processMultiCity.childCalculatedDiscountF;
			adultCalculatedNewFare=processMultiCity.adultCalculatedNewFareF;
			//childCalculatedNewFare=processMultiCity.childCalculatedNewFareF;
			verifyDiscountPolicy();	
			discountApplied2=processMultiCity.discountApplied2V;
			bookedLoadFactor2=processMultiCity.bookedLoadFactor2V;
			daysToDepart2=processMultiCity.daysToDepart2V;
			adultActual2=processMultiCity.adultActual2F;
			//childActual2=processMultiCity.childActual2F;
			adultNewFare2=processMultiCity.adultNewFare2F;
			//childNewFare2=processMultiCity.childNewFare2F;
			adultDiscount2=processMultiCity.adultDiscount2F;
			//childDiscount2=processMultiCity.childDiscount2F;
			discount2=processMultiCity.discount2F;
			adultCalculatedDiscount2=processMultiCity.adultCalculatedDiscount2F;
			//childCalculatedDiscount2=processMultiCity.childCalculatedDiscount2F;
			adultCalculatedNewFare2=processMultiCity.adultCalculatedNewFare2F;
			//childCalculatedNewFare2=processMultiCity.childCalculatedNewFare2F;
			verifyDiscountPolicy2();	
			discountApplied3=processMultiCity.discountApplied3V;
			bookedLoadFactor3=processMultiCity.bookedLoadFactor3V;
			daysToDepart3=processMultiCity.daysToDepart3V;
			adultActual3=processMultiCity.adultActual3F;
			//childActual3=processMultiCity.childActual3F;
			adultNewFare3=processMultiCity.adultNewFare3F;
			//childNewFare3=processMultiCity.childNewFare3F;
			adultDiscount3=processMultiCity.adultDiscount3F;
			//childDiscount3=processMultiCity.childDiscount3F;
			discount3=processMultiCity.discount3F;
			adultCalculatedDiscount3=processMultiCity.adultCalculatedDiscount3F;
			//childCalculatedDiscount3=processMultiCity.childCalculatedDiscount3F;
			adultCalculatedNewFare3=processMultiCity.adultCalculatedNewFare3F;
			//childCalculatedNewFare3=processMultiCity.childCalculatedNewFare3F;
			verifyDiscountPolicy3();
			updateStatus(17);
			updateStatus2(22);
			updateStatus3(25);
			break;
	
		
		}
		break;
		
		case "SERIES":
			switch(tripType){	

			case "ONEWAY":
				processSeriesOW=new ProcessDateRangeOneWayTL(driver);
				try {
					processSeriesOW.processSeriesRequest(reqId,"DISCOUNT");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				discountApplied=processSeriesOW.discountAppliedV;
				bookedLoadFactor=processSeriesOW.bookedLoadFactorV;
				daysToDepart=processSeriesOW.daysToDepartV;
				adultActual=processSeriesOW.adultActualF;
				//childActual=processSeriesOW.childActualF;
				adultNewFare=processSeriesOW.adultNewFareF;
				//childNewFare=processSeriesOW.childNewFareF;
				//adultDiscount=processSeriesReq.adultDiscountF;
				//childDiscount=processSeriesReq.childDiscountF;
				discount=processSeriesOW.discountF;
				adultCalculatedDiscount=processSeriesOW.adultCalculatedDiscountF;
				//childCalculatedDiscount=processSeriesOW.childCalculatedDiscountF;
				adultCalculatedNewFare=processSeriesOW.adultCalculatedNewFareF;
				//childCalculatedNewFare=processSeriesOW.childCalculatedNewFareF;

				 verifyDiscountPolicy();
				 
				 updateStatus(29);
			 
				 break;				
			 
				   
			case "ROUNDTRIP":
				processSeriesRT=new ProcessDateRangeRoundTripTL(driver);
				try {
					processSeriesRT.processSeriesRequest(reqId,"DISCOUNT");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				discountApplied=processSeriesRT.discountAppliedV;
				bookedLoadFactor=processSeriesRT.bookedLoadFactorV;
				daysToDepart=processSeriesRT.daysToDepartV;
				adultActual=processSeriesRT.adultActualF;
				//childActual=processSeriesRT.childActualF;
				adultNewFare=processSeriesRT.adultNewFareF;
				//childNewFare=processSeriesRT.childNewFareF;
				//adultDiscount=processSeriesReq.adultDiscountF;
				//childDiscount=processSeriesReq.childDiscountF;
				discount=processSeriesRT.discountF;
				adultCalculatedDiscount=processSeriesRT.adultCalculatedDiscountF;
				//childCalculatedDiscount=processSeriesRT.childCalculatedDiscountF;
				adultCalculatedNewFare=processSeriesRT.adultCalculatedNewFareF;
				//childCalculatedNewFare=processSeriesRT.childCalculatedNewFareF;
				verifyDiscountPolicy();
				discountApplied2=processSeriesRT.discountApplied2V;
				bookedLoadFactor2=processSeriesRT.bookedLoadFactor2V;
				daysToDepart2=processSeriesRT.daysToDepart2V;
				adultActual2=processSeriesRT.adultActual2F;
				//childActual2=processSeriesRT.childActual2F;
				adultNewFare2=processSeriesRT.adultNewFare2F;
				//childNewFare2=processSeriesRT.childNewFare2F;
				//adultDiscount2=processSeriesReq.adultDiscount2F;
				//childDiscount2=processSeriesReq.childDiscount2F;
				discount2=processSeriesRT.discount2F;
				adultCalculatedDiscount2=processSeriesRT.adultCalculatedDiscount2F;
				//childCalculatedDiscount2=processSeriesRT.childCalculatedDiscount2F;
				adultCalculatedNewFare2=processSeriesRT.adultCalculatedNewFare2F;
				//childCalculatedNewFare2=processSeriesRT.childCalculatedNewFare2F;

				 
				 verifyDiscountPolicy2();
				 updateStatus(35);
				 updateStatus2(40);
				 break;	 	 	

			 
			
			case "MULTICITY":
				processSeriesMT=new ProcessDateRangeMultiCityTL(driver);
				try {
					processSeriesMT.processSeriesRequest(reqId,"DISCOUNT");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				discountApplied=processSeriesMT.discountAppliedV;
				bookedLoadFactor=processSeriesMT.bookedLoadFactorV;
				daysToDepart=processSeriesMT.daysToDepartV;
				adultActual=processSeriesMT.adultActualF;
				//childActual=processSeriesMT.childActualF;
				adultNewFare=processSeriesMT.adultNewFareF;
				//childNewFare=processSeriesMT.childNewFareF;
				//adultDiscount=processSeriesReq.adultDiscountF;
				//childDiscount=processSeriesReq.childDiscountF;
				discount=processSeriesMT.discountF;
				adultCalculatedDiscount=processSeriesMT.adultCalculatedDiscountF;
				//childCalculatedDiscount=processSeriesMT.childCalculatedDiscountF;
				adultCalculatedNewFare=processSeriesMT.adultCalculatedNewFareF;
				//childCalculatedNewFare=processSeriesMT.childCalculatedNewFareF;

				 verifyDiscountPolicy();

					discountApplied2=processSeriesMT.discountApplied2V;
					bookedLoadFactor2=processSeriesMT.bookedLoadFactor2V;
					daysToDepart2=processSeriesMT.daysToDepart2V;
					adultActual2=processSeriesMT.adultActual2F;
					//childActual2=processSeriesMT.childActual2F;
					adultNewFare2=processSeriesMT.adultNewFare2F;
					//childNewFare2=processSeriesMT.childNewFare2F;
					//adultDiscount2=processSeriesReq.adultDiscount2F;
					//childDiscount2=processSeriesReq.childDiscount2F;
					discount2=processSeriesMT.discount2F;
					adultCalculatedDiscount2=processSeriesMT.adultCalculatedDiscount2F;
					//childCalculatedDiscount2=processSeriesMT.childCalculatedDiscount2F;
					adultCalculatedNewFare2=processSeriesMT.adultCalculatedNewFare2F;
					//childCalculatedNewFare2=processSeriesMT.childCalculatedNewFare2F;
					 verifyDiscountPolicy2();

				 
					discountApplied3=processSeriesMT.discountApplied3V;
					bookedLoadFactor3=processSeriesMT.bookedLoadFactor3V;
					daysToDepart3=processSeriesMT.daysToDepart3V;
					adultActual3=processSeriesMT.adultActual3F;
					//childActual3=processSeriesMT.childActual3F;
					adultNewFare3=processSeriesMT.adultNewFare3F;
					//childNewFare3=processSeriesMT.childNewFare3F;
					//adultDiscount3=processSeriesReq.adultDiscount3F;
					//childDiscount3=processSeriesReq.childDiscount3F;
					discount3=processSeriesMT.discount3F;
					adultCalculatedDiscount3=processSeriesMT.adultCalculatedDiscount3F;
					//childCalculatedDiscount3=processSeriesMT.childCalculatedDiscount3F;
					adultCalculatedNewFare3=processSeriesMT.adultCalculatedNewFare3F;
					//childCalculatedNewFare3=processSeriesMT.childCalculatedNewFare3F;
					 verifyDiscountPolicy3();

					updateStatus(44);
					updateStatus2(49);
					updateStatus3(52);
			 
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



			oneway =new AdhocOneWayDiscount(driver);
			oneway.adHocGroupRequest(origin1Map,destination1Map);
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
		
		roundTrip =new AdhocRoundTripDiscount(driver);
		roundTrip.adHocGroupRequest(origin1Map,destination1Map);
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
		multiCity =new AdhocMultiCityDiscount(driver);
		multiCity.adHocGroupRequest(origin1Map,destination1Map,origin2Map,destination2Map,origin3Map,destination3Map);
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
		seriesOneway=new SeriesDateRangeOneWayDiscount(driver);
		seriesOneway.seriesDateRangeRequest(origin1Map,destination1Map);
		
		reqId=seriesOneway.requestID;
	}
	public void raiseSeriesRoundTrip(){
		seriesRoundTrip=new SeriesDateRangeRoundTripDiscount(driver);
		seriesRoundTrip.seriesDateRangeRequest(origin1Map,destination1Map);
		reqId=seriesRoundTrip.requestID;
	}
	public void raiseSeriesMultiCity(){
		seriesMultiCity=new SeriesDateRangeMultiCityDiscount(driver);
		seriesMultiCity.seriesDateRangeRequest(origin1Map,destination1Map,origin2Map,destination2Map,origin3Map,destination3Map);
		reqId=seriesMultiCity.requestID;
	}
	

	public void verifyDiscountPolicy(){
		try{
		int bookedLFT,daysToDepartT;
		bookedLFT=Integer.parseInt(bookedLoadFactor);
		daysToDepartT=Integer.parseInt(daysToDepart);
		int lFIndex = 0,discountIndex=0; 
		for(int i=0;i<lf.length;i++){
			if(i<lf.length-1){
			if(lf[i]<=bookedLFT&&lf[i+1]>bookedLFT){
				lFIndex=lf[i];
			}
			}else if(i==lf.length-1){
				 
					if(lf[i]<=bookedLFT){
						lFIndex=lf[i];
					}
					 
			}	
		}
		
		for(int j=0;j<discountList.size();j++){
			if(j<discountList.size()-1){
				
				if(discountList.get(j).getDaysToDepart()<=daysToDepartT&&discountList.get(j+1).getDaysToDepart()>daysToDepartT){
					discountIndex=j;
				}
				
			}else if(j==discountList.size()-1){
				if(discountList.get(j).getDaysToDepart()<=daysToDepartT){
					discountIndex=j;
				}
			}
					
		}
		System.out.println("X axis"+lFIndex);
		System.out.println("Y axis"+discountIndex);

		switch(lFIndex){
	 
		case 5:
			discountValueCalculated= discountList.get(discountIndex).getFirstCol();
			break;
			
		case 10:
			discountValueCalculated= discountList.get(discountIndex).getSecondCol();
			break;
		case 15:
			discountValueCalculated= discountList.get(discountIndex).getThirdCol();
			break;
		case 20:
			discountValueCalculated= discountList.get(discountIndex).getFourthCol();
			break;
		case 50:
			discountValueCalculated= discountList.get(discountIndex).getFifthCol();
			break;
			
			default:
				System.out.println("Some thing error");

		
		
		
		}
		
		System.out.println("The Final out put is"+discountValueCalculated);
		System.out.println("The Expected out put is"+discountApplied);
		}catch(NumberFormatException e){
			System.out.println("Not Captured for sector 1 ");
		}
	
	}
	
public void verifyDiscountPolicy2(){
		try{
		int bookedLFT,daysToDepartT;
		bookedLFT=Integer.parseInt(bookedLoadFactor2);
		daysToDepartT=Integer.parseInt(daysToDepart2);
		int lFIndex = 0,discountIndex=0; 
		for(int i=0;i<lf.length;i++){
			if(i<lf.length-1){
			if(lf[i]<=bookedLFT&&lf[i+1]>bookedLFT){
				lFIndex=lf[i];
			}
			}else if(i==lf.length-1){
				 
					if(lf[i]<=bookedLFT){
						lFIndex=lf[i];
					}
					 
			}	
		}
		
		for(int j=0;j<discountList.size();j++){
			if(j<discountList.size()-1){
				
				if(discountList.get(j).getDaysToDepart()<=daysToDepartT&&discountList.get(j+1).getDaysToDepart()>daysToDepartT){
					discountIndex=j;
				}
				
			}else if(j==discountList.size()-1){
				if(discountList.get(j).getDaysToDepart()<=daysToDepartT){
					discountIndex=j;
				}
			}
					
		}
		System.out.println("X axis"+lFIndex);
		System.out.println("Y axis"+discountIndex);

		switch(lFIndex){
	 
		case 5:
			discountValueCalculated2= discountList.get(discountIndex).getFirstCol();
			break;
			
		case 10:
			discountValueCalculated2= discountList.get(discountIndex).getSecondCol();
			break;
		case 15:
			discountValueCalculated2= discountList.get(discountIndex).getThirdCol();
			break;
		case 20:
			discountValueCalculated2= discountList.get(discountIndex).getFourthCol();
			break;
		case 50:
			discountValueCalculated2= discountList.get(discountIndex).getFifthCol();
			break;
			
			default:
				System.out.println("Some thing error");

		
		
		
		}
		
		System.out.println("The Final out put is"+discountValueCalculated2);
		System.out.println("The Expected out put is"+discountApplied2);
		
		}catch(NumberFormatException e){
			System.out.println("Not Captured for sector 2 ");
		}
	}


public void verifyDiscountPolicy3(){
	try{
	int bookedLFT,daysToDepartT;
	bookedLFT=Integer.parseInt(bookedLoadFactor3);
	daysToDepartT=Integer.parseInt(daysToDepart3);
	int lFIndex = 0,discountIndex=0; 
	for(int i=0;i<lf.length;i++){
		if(i<lf.length-1){
		if(lf[i]<=bookedLFT&&lf[i+1]>bookedLFT){
			lFIndex=lf[i];
		}
		}else if(i==lf.length-1){
			 
				if(lf[i]<=bookedLFT){
					lFIndex=lf[i];
				}
				 
		}	
	}
	
	for(int j=0;j<discountList.size();j++){
		if(j<discountList.size()-1){
			
			if(discountList.get(j).getDaysToDepart()<=daysToDepartT&&discountList.get(j+1).getDaysToDepart()>daysToDepartT){
				discountIndex=j;
			}
			
		}else if(j==discountList.size()-1){
			if(discountList.get(j).getDaysToDepart()<=daysToDepartT){
				discountIndex=j;
			}
		}
				
	}
	System.out.println("X axis"+lFIndex);
	System.out.println("Y axis"+discountIndex);

	switch(lFIndex){
 
	case 5:
		discountValueCalculated3= discountList.get(discountIndex).getFirstCol();
		break;
		
	case 10:
		discountValueCalculated3= discountList.get(discountIndex).getSecondCol();
		break;
	case 15:
		discountValueCalculated3= discountList.get(discountIndex).getThirdCol();
		break;
	case 20:
		discountValueCalculated3= discountList.get(discountIndex).getFourthCol();
		break;
	case 50:
		discountValueCalculated3= discountList.get(discountIndex).getFifthCol();
		break;
		
		default:
			System.out.println("Some thing error");

	
	
	
	}
	
	System.out.println("The Final out put is"+discountValueCalculated3);
	System.out.println("The Expected out put is"+discountApplied3);
	}catch(NumberFormatException e){
		System.out.println("Not Captured for sector 3");
	}

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
		int applied=0;

		try{
		 applied=Integer.parseInt(discountApplied);
		
		
		try{
			Assert.assertEquals(applied	, discountValueCalculated);
			rf=new UpdateStatusFormat("Pass",""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;
		}
		
		try{
			Assert.assertEquals(adultCalculatedNewFare,adultNewFare);
			rf=new UpdateStatusFormat("Pass",""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;
		}
		

		}catch(NumberFormatException t){
			System.out.println(t);
		}	
	}
	
public void updateStatus2(int rowNo){
		
	int applied=0;

	try{
	 applied=Integer.parseInt(discountApplied2);
		
		try{
			Assert.assertEquals(applied	, discountValueCalculated2);
			rf=new UpdateStatusFormat("Pass",""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;
		}
		
		try{
			Assert.assertEquals(adultCalculatedNewFare2,adultNewFare2);
			rf=new UpdateStatusFormat("Pass",""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;

		}catch(Throwable t){
			rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","0");
			reportList.add(rf);
			rowNo++;
		}
		
	}catch(NumberFormatException t){
		System.out.println(t);
	}	
		
	}


public void updateStatus3(int rowNo){
	int applied=0;

	try{
	 applied=Integer.parseInt(discountApplied3);
	
	
	
	try{
		Assert.assertEquals(applied	, discountValueCalculated3);
		rf=new UpdateStatusFormat("Pass",""+rowNo,"5","0");
		reportList.add(rf);
		rowNo++;

	}catch(Throwable t){
		rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","0");
		reportList.add(rf);
		rowNo++;
	}
	
	try{
		Assert.assertEquals(adultCalculatedNewFare3,adultNewFare3);
		rf=new UpdateStatusFormat("Pass",""+rowNo,"5","0");
		reportList.add(rf);
		rowNo++;

	}catch(Throwable t){
		rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","0");
		reportList.add(rf);
		rowNo++;
	}
	
	}catch(NumberFormatException t){
		System.out.println(t);
	}
}



}

