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
import pack.base.FareTypeMatrixFormat;
import pack.base.ReadFareSettingInput;
import pack.base.ReadRootPath;
import pack.base.TestBaseSetup;
import pack.base.UpdateStatusFormat;
import pack.base.WriteTestCaseStatus;


public class StaticFareTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadFareSettingInput read;
	private CreateFareTypeMatrix createFT;
	private MapFareTypePolicy mapFT;
	private CreateStaticFareMatrix createSF;
	private MapStaticFarePolicy mapSF;
	
	
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
 	
	String inputFile="InputFile\\Static Fare Settings.xls";
	String reportexcelFile="DataDrivenReport\\Fare Settup.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";
	
	private String slNo,tripType,requestType;
	private boolean runningMode=false;
	private String fareTypeMatrix,sucessMsgFT;
	private String policyNameMap,staticMatrixMap,origin1Map,destination1Map,origin2Map,destination2Map,origin3Map,destination3Map,tripTypeMap,requestTypeMap;
	private String sucessMsgMap;
	private String staticFareMatrix,sucessMsgSF;
	private String policyNameMap2,staticMatrixMap2,origin1Map2,destination1Map2,origin2Map2,destination2Map2,origin3Map2,destination3Map2,tripTypeMap2,requestTypeMap2;
	private String sucessMsgMap2;

	private String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	private String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
	
	private  int loadFactorI,daysToDepartI;
	private String fareTypeSFV,dispFareSFV,staticFareSFV,bitPriceSFV,departDateSFV;
	private String loadFactorV;
	private float adultActualF;//,childActualF;
	private float dispFareSFF,staticFareSFF,bitPriceSFF;	
	
	private int loadFactorI2,daysToDepartI2;
	private String fareTypeSFV2,dispFareSFV2,staticFareSFV2,bitPriceSFV2,departDateSFV2;
	private String loadFactorV2;
	private float adultActualF2;//,childActualF2;
	private float dispFareSFF2,staticFareSFF2,bitPriceSFF2;
	
	private int loadFactorI3,daysToDepartI3;
	private String fareTypeSFV3,dispFareSFV3,staticFareSFV3,bitPriceSFV3,departDateSFV3;
	private String loadFactorV3;
	private float adultActualF3;//,childActualF3;
	private float dispFareSFF3,staticFareSFF3,bitPriceSFF3;
	
	String fareTypeAsFareTypeMatrix;
	int staticFareAsStaticFareMatrix=0;
	
	String fareTypeAsFareTypeMatrix2;
	int staticFareAsStaticFareMatrix2=0;
	
	String fareTypeAsFareTypeMatrix3;
	int staticFareAsStaticFareMatrix3=0;




	List<FareTypeMatrixFormat> fareTypeMatrixList= new ArrayList<FareTypeMatrixFormat>();
	int lfFT[];
	List<DiscountMatrixFormat> staticMatrixList= new ArrayList<DiscountMatrixFormat>();
	int lfSF[];
	
	List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	UpdateStatusFormat rf;
	ReadRootPath readRoot=new ReadRootPath();
	String rootPath=readRoot.getPath();

	private List<FareSettingsFormat> inputList=new ArrayList<FareSettingsFormat>();
	
	private int indexOfInput;


	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test(priority=0)
	@Parameters({"indexVal"})
	public void readInput(int indexVal) throws IOException {
		indexOfInput=indexVal;

		read=new ReadFareSettingInput ();
		read.getExcelData(rootPath+inputFile);
		inputList=read.inputList;
		slNo=inputList.get(indexOfInput).getSlNo();
		tripType=inputList.get(indexOfInput).getTripType();
		requestType=inputList.get(indexOfInput).getRequestType();
		if(inputList.get(indexOfInput).getRunningMode().equalsIgnoreCase("Yes")){
			runningMode=true;	
		}
		
	

	}
	
	@Test(priority=1)
	public void createPolicy() throws IOException {
		
				 
		if(runningMode){

	 
		createFT=new CreateFareTypeMatrix(driver);
		createFT.createMatrix();
		fareTypeMatrix=createFT.profileNameV;
		fareTypeMatrixList=createFT.fareTypeMatrixList;
		sucessMsgFT=createFT.sucessMsgV;
		lfFT=createFT.LF;
		for(int i=0;i<lfFT.length;i++){
			System.out.println(lfFT[i]);
			}
		}else{
			driver.close();
		}
		}

	@Test(dependsOnMethods = "createPolicy",priority=2)
	public void mapPolicy() throws IOException {
		if(runningMode){
		mapFT=new MapFareTypePolicy(driver);
		mapFT.mapFareTypePolicy(fareTypeMatrix,tripType,requestType,sectorInput,delimeter);
		
	 
		policyNameMap=mapFT.policyNameV;
		staticMatrixMap=mapFT.staticMatrixV;
		origin1Map=mapFT.origin1V;
		destination1Map=mapFT.destination1V;
		origin2Map=mapFT.origin2V;
		destination2Map=mapFT.destination2V;
		origin3Map=mapFT.origin3V;
		destination3Map=mapFT.destination3V;
		tripTypeMap=mapFT.tripTypeV;
		requestTypeMap=mapFT.requestTypeV;
		sucessMsgMap=mapFT.sucessMsgV;
		System.out.println("Test"+tripTypeMap);
		}
	}
	@Test(dependsOnMethods = "createPolicy",priority=3)
	public void crateStaticMatrix() throws IOException {
		if(runningMode){
		createSF=new CreateStaticFareMatrix(driver);
		createSF.createMatrix();
		staticFareMatrix=createSF.profileNameV;
		staticMatrixList=createSF.staticMatrixList;
		sucessMsgSF=createSF.sucessMsgV;
		lfSF=createSF.LF;
		for(int i=0;i<lfSF.length;i++){
			System.out.println(lfSF[i]);
			}
		}
		}
	@Test(dependsOnMethods = "createPolicy",priority=4)
	public void mapSFPolicy() throws IOException {
		if(runningMode){
		mapSF=new MapStaticFarePolicy(driver);
		mapSF.mapSFPolicy(staticFareMatrix,tripType,requestType,sectorInput,delimeter);
		
	 
		policyNameMap2=mapSF.policyNameV;
		staticMatrixMap2=mapSF.staticMatrixV;
		origin1Map2=mapSF.origin1V;
		destination1Map2=mapSF.destination1V;
		origin2Map2=mapSF.origin2V;
		destination2Map2=mapSF.destination2V;
		origin3Map2=mapSF.origin3V;
		destination3Map2=mapSF.destination3V;
		tripTypeMap2=mapSF.tripTypeV;
		requestTypeMap2=mapSF.requestTypeV;
		sucessMsgMap2=mapSF.sucessMsgV;
		System.out.println("Test"+tripTypeMap);
		}

	}
		
	
	@Test(dependsOnMethods = "createPolicy",priority=5)
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
	 
	@Test(dependsOnMethods = "createPolicy",priority=6)
	public void process()
	{	if(runningMode){
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
				processOneway.processAdHocRequest(reqId,"staticfare");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loadFactorI=processOneway.loadFactorI;
			daysToDepartI=processOneway.daysToDepartI;
			fareTypeSFV=processOneway.fareTypeSFV;
			dispFareSFV=processOneway.dispFareSFV;
			staticFareSFV=processOneway.staticFareSFV;
			bitPriceSFV=processOneway.bitPriceSFV;
			departDateSFV=processOneway.departDateSFV;
			loadFactorV=processOneway.loadFactorV;
			adultActualF=processOneway.adultActualF;
			//childActualF=processOneway.childActualF;
			dispFareSFF=processOneway.dispFareSFF;
			staticFareSFF=processOneway.staticFareSFF;
			bitPriceSFF=processOneway.bitPriceSFF;

			verifyStaticFarePolicy();			 
			updateStatus(2);
			 break;
			
		case "ROUNDTRIP":
			processRoundTrip=new ProcessAdhocRoundTrip(driver);
			try {
				processRoundTrip.processAdHocRequest(reqId,"staticfare");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			loadFactorI=processRoundTrip.loadFactorI;
			daysToDepartI=processRoundTrip.daysToDepartI;
			fareTypeSFV=processRoundTrip.fareTypeSFV;
			dispFareSFV=processRoundTrip.dispFareSFV;
			staticFareSFV=processRoundTrip.staticFareSFV;
			bitPriceSFV=processRoundTrip.bitPriceSFV;
			departDateSFV=processRoundTrip.departDateSFV;
			loadFactorV=processRoundTrip.loadFactorV;
			adultActualF=processRoundTrip.adultActualF;
			//childActualF=processRoundTrip.childActualF;
			dispFareSFF=processRoundTrip.dispFareSFF;
			staticFareSFF=processRoundTrip.staticFareSFF;
			bitPriceSFF=processRoundTrip.bitPriceSFF;
			verifyStaticFarePolicy();			 
			updateStatus(13);
			loadFactorI2=processRoundTrip.loadFactorI2;
			daysToDepartI2=processRoundTrip.daysToDepartI2;
			fareTypeSFV2=processRoundTrip.fareTypeSF2V;
			dispFareSFV2=processRoundTrip.dispFareSF2V;
			staticFareSFV2=processRoundTrip.staticFareSF2V;
			bitPriceSFV2=processRoundTrip.bitPriceSF2V;
			departDateSFV2=processRoundTrip.departDateSF2V;
			loadFactorV2=processRoundTrip.loadFactor2V;
			adultActualF2=processRoundTrip.adultActual2F;
			//childActualF2=processRoundTrip.childActual2F;
			dispFareSFF2=processRoundTrip.dispFareSFF2;
			staticFareSFF2=processRoundTrip.staticFareSFF2;
			bitPriceSFF2=processRoundTrip.bitPriceSFF2;
			verifyStaticFarePolicy2();			 
			updateStatus2(23);

			break;
		
		case "MULTICITY":
			processMultiCity=new ProcessAdhocMultiCity(driver);
			try {
				processMultiCity.processAdHocRequest(reqId,"staticfare");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			loadFactorI=processMultiCity.loadFactorI;
			daysToDepartI=processMultiCity.daysToDepartI;
			fareTypeSFV=processMultiCity.fareTypeSFV;
			dispFareSFV=processMultiCity.dispFareSFV;
			staticFareSFV=processMultiCity.staticFareSFV;
			bitPriceSFV=processMultiCity.bitPriceSFV;
			departDateSFV=processMultiCity.departDateSFV;
			loadFactorV=processMultiCity.loadFactorV;
			adultActualF=processMultiCity.adultActualF;
			//childActualF=processMultiCity.childActualF;
			dispFareSFF=processMultiCity.dispFareSFF;
			staticFareSFF=processMultiCity.staticFareSFF;
			bitPriceSFF=processMultiCity.bitPriceSFF;
			verifyStaticFarePolicy();			 
			updateStatus(30);
			loadFactorI2=processMultiCity.loadFactorI2;
			daysToDepartI2=processMultiCity.daysToDepartI2;
			fareTypeSFV2=processMultiCity.fareTypeSF2V;
			dispFareSFV2=processMultiCity.dispFareSF2V;
			staticFareSFV2=processMultiCity.staticFareSF2V;
			bitPriceSFV2=processMultiCity.bitPriceSF2V;
			departDateSFV2=processMultiCity.departDateSF2V;
			loadFactorV2=processMultiCity.loadFactor2V;
			adultActualF2=processMultiCity.adultActual2F;
			//childActualF2=processMultiCity.childActual2F;
			dispFareSFF2=processMultiCity.dispFareSFF2;
			staticFareSFF2=processMultiCity.staticFareSFF2;
			bitPriceSFF2=processMultiCity.bitPriceSFF2;
			verifyStaticFarePolicy2();			 
			updateStatus2(40);
			loadFactorI3=processMultiCity.loadFactorI3;
			daysToDepartI3=processMultiCity.daysToDepartI3;
			fareTypeSFV3=processMultiCity.fareTypeSF3V;
			dispFareSFV3=processMultiCity.dispFareSF3V;
			staticFareSFV3=processMultiCity.staticFareSF3V;
			bitPriceSFV3=processMultiCity.bitPriceSF3V;
			departDateSFV3=processMultiCity.departDateSF3V;
			loadFactorV3=processMultiCity.loadFactor3V;
			adultActualF3=processMultiCity.adultActual3F;
			//childActualF3=processMultiCity.childActual3F;
			dispFareSFF3=processMultiCity.dispFareSFF3;
			staticFareSFF3=processMultiCity.staticFareSFF3;
			bitPriceSFF3=processMultiCity.bitPriceSFF3;

			verifyStaticFarePolicy3();	
			updateStatus3(46);
			break;
	
		
		}
		break;
		
		case "SERIES":
			switch(tripType){	

			case "ONEWAY":
				processSeriesOW=new ProcessDateRangeOneWayTL(driver);
				try {
					processSeriesOW.processSeriesRequest(reqId,"staticfare");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				loadFactorI=processSeriesOW.loadFactorI;
				daysToDepartI=processSeriesOW.daysToDepartI;
				fareTypeSFV=processSeriesOW.fareTypeSFV;
				dispFareSFV=processSeriesOW.dispFareSFV;
				//staticFareSFV=processSeriesOW.staticFareSFV;
				//bitPriceSFV=processSeriesOW.bitPriceSFV;
				departDateSFV=processSeriesOW.departDateSFV;
				//loadFactorV=processSeriesOW.loadFactorV;
				adultActualF=processSeriesOW.adultActualF;
				//childActualF=processSeriesOW.childActualF;
				dispFareSFF=processSeriesOW.dispFareSFF;
				//staticFareSFF=processSeriesOW.staticFareSFF;
				//bitPriceSFF=processSeriesOW.bitPriceSFF;
				
				verifyStaticFarePolicy();			 
				updateStatus(53);
				break;				
			 
				   
			case "ROUNDTRIP":
				processSeriesRT=new ProcessDateRangeRoundTripTL(driver);
				try {
					processSeriesRT.processSeriesRequest(reqId,"staticfare");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			loadFactorI=processSeriesRT.loadFactorI;
			daysToDepartI=processSeriesRT.daysToDepartI;
			fareTypeSFV=processSeriesRT.fareTypeSFV;
			dispFareSFV=processSeriesRT.dispFareSFV;
			departDateSFV=processSeriesRT.departDateSFV;
			adultActualF=processSeriesRT.adultActualF;
			//childActualF=processSeriesRT.childActualF;
			dispFareSFF=processSeriesRT.dispFareSFF;
			verifyStaticFarePolicy();			 
			updateStatus(64);			 
			loadFactorI2=processSeriesRT.loadFactorI2;
			daysToDepartI2=processSeriesRT.daysToDepartI2;
			fareTypeSFV2=processSeriesRT.fareTypeSFV2;
			dispFareSFV2=processSeriesRT.dispFareSFV2;
			departDateSFV2=processSeriesRT.departDateSFV2;
			adultActualF2=processSeriesRT.adultActual2F;
			//childActualF2=processSeriesRT.childActual2F;
			dispFareSFF2=processSeriesRT.dispFareSFF2;
			verifyStaticFarePolicy2();			 
			updateStatus2(74);

				 break;	 	 	

			 
			
			case "MULTICITY":
				processSeriesMT=new ProcessDateRangeMultiCityTL(driver);
				try {
					processSeriesMT.processSeriesRequest(reqId,"staticfare");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				loadFactorI=processSeriesMT.loadFactorI;
				daysToDepartI=processSeriesMT.daysToDepartI;
				fareTypeSFV=processSeriesMT.fareTypeSFV;
				dispFareSFV=processSeriesMT.dispFareSFV;
				departDateSFV=processSeriesMT.departDateSFV;
				adultActualF=processSeriesMT.adultActualF;
				//childActualF=processSeriesMT.childActualF;
				dispFareSFF=processSeriesMT.dispFareSFF;
				verifyStaticFarePolicy();			 
				updateStatus(81);			 
				loadFactorI2=processSeriesMT.loadFactorI2;
				daysToDepartI2=processSeriesMT.daysToDepartI2;
				fareTypeSFV2=processSeriesMT.fareTypeSFV2;
				dispFareSFV2=processSeriesMT.dispFareSFV2;
				departDateSFV2=processSeriesMT.departDateSFV2;
				adultActualF2=processSeriesMT.adultActual2F;
				//childActualF2=processSeriesMT.childActual2F;
				dispFareSFF2=processSeriesMT.dispFareSFF2;
				verifyStaticFarePolicy2();			 
				updateStatus2(91);			 
				loadFactorI3=processSeriesMT.loadFactorI3;
				daysToDepartI3=processSeriesMT.daysToDepartI3;
				fareTypeSFV3=processSeriesMT.fareTypeSFV3;
				dispFareSFV3=processSeriesMT.dispFareSFV3;
				departDateSFV3=processSeriesMT.departDateSFV3;
				adultActualF3=processSeriesMT.adultActual3F;
				//childActualF3=processSeriesMT.childActual3F;
				dispFareSFF3=processSeriesMT.dispFareSFF3;
				verifyStaticFarePolicy3();			 
				updateStatus3(97);

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



	public void verifyStaticFarePolicy(){
		try{
		int bookedLFT,daysToDepartT;
		bookedLFT=loadFactorI;
		daysToDepartT=daysToDepartI;
		int lFIndex = 0,discountIndex=0; 
		for(int i=0;i<lfFT.length;i++){
			if(i<lfFT.length-1){
			if(lfFT[i]<=bookedLFT&&lfFT[i+1]>bookedLFT){
				lFIndex=lfFT[i];
			}
			}else if(i==lfFT.length-1){
				 
					if(lfFT[i]<=bookedLFT){
						lFIndex=lfFT[i];
					}
					 
			}	
		}
		
		for(int j=0;j<fareTypeMatrixList.size();j++){
			if(j<fareTypeMatrixList.size()-1){
				
				if(fareTypeMatrixList.get(j).getDaysToDepart()<=daysToDepartT&&fareTypeMatrixList.get(j+1).getDaysToDepart()>daysToDepartT){
					discountIndex=j;
				}
				
			}else if(j==fareTypeMatrixList.size()-1){
				if(fareTypeMatrixList.get(j).getDaysToDepart()<=daysToDepartT){
					discountIndex=j;
				}
			}
					
		}
		System.out.println("X axis"+lFIndex);
		System.out.println("Y axis"+discountIndex);

		switch(lFIndex){
	 
		case 5:
			fareTypeAsFareTypeMatrix= fareTypeMatrixList.get(discountIndex).getFirstCol();
			staticFareAsStaticFareMatrix=staticMatrixList.get(discountIndex).getFirstCol();
			break;
			
		case 10:
			fareTypeAsFareTypeMatrix= fareTypeMatrixList.get(discountIndex).getSecondCol();
			staticFareAsStaticFareMatrix=staticMatrixList.get(discountIndex).getSecondCol();
			break;
		case 15:
			fareTypeAsFareTypeMatrix= fareTypeMatrixList.get(discountIndex).getThirdCol();
			staticFareAsStaticFareMatrix=staticMatrixList.get(discountIndex).getThirdCol();
			break;
		case 20:
			fareTypeAsFareTypeMatrix= fareTypeMatrixList.get(discountIndex).getFourthCol();
			staticFareAsStaticFareMatrix=staticMatrixList.get(discountIndex).getFourthCol();
			break;
		case 50:
			fareTypeAsFareTypeMatrix= fareTypeMatrixList.get(discountIndex).getFifthCol();
			staticFareAsStaticFareMatrix=staticMatrixList.get(discountIndex).getFifthCol();
			break;
			
			default:
				System.out.println("Some thing error");

		
		
		
		}
		
		System.out.println("The Fare Type as per Matric"+fareTypeAsFareTypeMatrix);
		System.out.println("The Static Fare as per Matric"+staticFareAsStaticFareMatrix);
		}catch(NumberFormatException e){
			System.out.println("Not Captured for sector 1 ");
		}
	
	}




	public void verifyStaticFarePolicy2(){
		try{
		int bookedLFT,daysToDepartT;
		bookedLFT=loadFactorI2;
		daysToDepartT=daysToDepartI2;
		int lFIndex = 0,discountIndex=0; 
		for(int i=0;i<lfFT.length;i++){
			if(i<lfFT.length-1){
			if(lfFT[i]<=bookedLFT&&lfFT[i+1]>bookedLFT){
				lFIndex=lfFT[i];
			}
			}else if(i==lfFT.length-1){
				 
					if(lfFT[i]<=bookedLFT){
						lFIndex=lfFT[i];
					}
					 
			}	
		}
		
		for(int j=0;j<fareTypeMatrixList.size();j++){
			if(j<fareTypeMatrixList.size()-1){
				
				if(fareTypeMatrixList.get(j).getDaysToDepart()<=daysToDepartT&&fareTypeMatrixList.get(j+1).getDaysToDepart()>daysToDepartT){
					discountIndex=j;
				}
				
			}else if(j==fareTypeMatrixList.size()-1){
				if(fareTypeMatrixList.get(j).getDaysToDepart()<=daysToDepartT){
					discountIndex=j;
				}
			}
					
		}
		System.out.println("X axis"+lFIndex);
		System.out.println("Y axis"+discountIndex);

		switch(lFIndex){
	 
		case 5:
			fareTypeAsFareTypeMatrix2= fareTypeMatrixList.get(discountIndex).getFirstCol();
			staticFareAsStaticFareMatrix2=staticMatrixList.get(discountIndex).getFirstCol();
			break;
			
		case 10:
			fareTypeAsFareTypeMatrix2= fareTypeMatrixList.get(discountIndex).getSecondCol();
			staticFareAsStaticFareMatrix2=staticMatrixList.get(discountIndex).getSecondCol();
			break;
		case 15:
			fareTypeAsFareTypeMatrix2= fareTypeMatrixList.get(discountIndex).getThirdCol();
			staticFareAsStaticFareMatrix2=staticMatrixList.get(discountIndex).getThirdCol();
			break;
		case 20:
			fareTypeAsFareTypeMatrix2= fareTypeMatrixList.get(discountIndex).getFourthCol();
			staticFareAsStaticFareMatrix2=staticMatrixList.get(discountIndex).getFourthCol();
			break;
		case 50:
			fareTypeAsFareTypeMatrix2= fareTypeMatrixList.get(discountIndex).getFifthCol();
			staticFareAsStaticFareMatrix2=staticMatrixList.get(discountIndex).getFifthCol();
			break;
			
			default:
				System.out.println("Some thing error");

		
		
		
		}
		
		System.out.println("The Fare Type as per Matric"+fareTypeAsFareTypeMatrix2);
		System.out.println("The Static Fare as per Matric"+staticFareAsStaticFareMatrix2);
		}catch(NumberFormatException e){
			System.out.println("Not Captured for sector 1 ");
		}
		
	
	}




	public void verifyStaticFarePolicy3(){
		try{
		int bookedLFT,daysToDepartT;
		bookedLFT=loadFactorI3;
		daysToDepartT=daysToDepartI3;
		int lFIndex = 0,discountIndex=0; 
		for(int i=0;i<lfFT.length;i++){
			if(i<lfFT.length-1){
			if(lfFT[i]<=bookedLFT&&lfFT[i+1]>bookedLFT){
				lFIndex=lfFT[i];
			}
			}else if(i==lfFT.length-1){
				 
					if(lfFT[i]<=bookedLFT){
						lFIndex=lfFT[i];
					}
					 
			}	
		}
		
		for(int j=0;j<fareTypeMatrixList.size();j++){
			if(j<fareTypeMatrixList.size()-1){
				
				if(fareTypeMatrixList.get(j).getDaysToDepart()<=daysToDepartT&&fareTypeMatrixList.get(j+1).getDaysToDepart()>daysToDepartT){
					discountIndex=j;
				}
				
			}else if(j==fareTypeMatrixList.size()-1){
				if(fareTypeMatrixList.get(j).getDaysToDepart()<=daysToDepartT){
					discountIndex=j;
				}
			}
					
		}
		System.out.println("X axis"+lFIndex);
		System.out.println("Y axis"+discountIndex);

		switch(lFIndex){
	 
		case 5:
			fareTypeAsFareTypeMatrix3= fareTypeMatrixList.get(discountIndex).getFirstCol();
			staticFareAsStaticFareMatrix3=staticMatrixList.get(discountIndex).getFirstCol();
			break;
			
		case 10:
			fareTypeAsFareTypeMatrix3= fareTypeMatrixList.get(discountIndex).getSecondCol();
			staticFareAsStaticFareMatrix3=staticMatrixList.get(discountIndex).getSecondCol();
			break;
		case 15:
			fareTypeAsFareTypeMatrix3= fareTypeMatrixList.get(discountIndex).getThirdCol();
			staticFareAsStaticFareMatrix3=staticMatrixList.get(discountIndex).getThirdCol();
			break;
		case 30:
			fareTypeAsFareTypeMatrix3= fareTypeMatrixList.get(discountIndex).getFourthCol();
			staticFareAsStaticFareMatrix3=staticMatrixList.get(discountIndex).getFourthCol();
			break;
		case 50:
			fareTypeAsFareTypeMatrix3= fareTypeMatrixList.get(discountIndex).getFifthCol();
			staticFareAsStaticFareMatrix3=staticMatrixList.get(discountIndex).getFifthCol();
			break;
			
			default:
				System.out.println("Some thing error");

		
		
		
		}
		
		System.out.println("The Fare Type as per Matric"+fareTypeAsFareTypeMatrix3);
		System.out.println("The Static Fare as per Matric"+staticFareAsStaticFareMatrix3);
		}catch(NumberFormatException e){
			System.out.println("Not Captured for sector 3 ");
		}
		
	
	}





	public void updateStatus(int rowNo){
		if(sucessMsgSF.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;
		} 
		
		if(sucessMsgMap2.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;

		}else{
			rf=new UpdateStatusFormat("Fail", ""+rowNo,"5","1");
			reportList.add(rf);
			rowNo++;
		} 
		
		if(sucessMsgFT.contains("successfully")){
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
		
		
		String policyType=fareTypeAsFareTypeMatrix.toUpperCase();
		policyType=policyType.replaceAll("\\s+", "");
		
		switch(policyType){
		
		case "TIEREDFARE":{
			if(fareTypeSFV.contains("Tiered fare")&&fareTypeSFV.contains(policyNameMap)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			if(fareTypeSFV.contains(policyNameMap2)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			int staticFareCalCul=staticFareAsStaticFareMatrix;
			try{
				Assert.assertEquals(adultActualF	, staticFareCalCul);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			try{
				Assert.assertEquals(adultActualF	, staticFareCalCul);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
		 
			}
			break;
		case "DYNAMICFARE":{

			if(fareTypeSFV.contains("Public fare")&&fareTypeSFV.contains(policyNameMap)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			if(!fareTypeSFV.contains(policyNameMap2)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			
			try{
				Assert.assertEquals(adultActualF	, dispFareSFF);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			try{
				Assert.assertEquals(adultActualF	, dispFareSFF);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}




			
		}
			break;
			default:
				rf=new UpdateStatusFormat("Matrix is not matched with Matrix",""+rowNo,"6","1");
				reportList.add(rf);
				
		}


	}

	public void updateStatus2(int rowNo){


		
		
		String policyType=fareTypeAsFareTypeMatrix.toUpperCase();
		policyType=policyType.replaceAll("\\s+", "");
		
		switch(policyType){
		
		case "TIEREDFARE":{
			if(fareTypeSFV2.contains("Tiered fare")&&fareTypeSFV.contains(policyNameMap)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			if(fareTypeSFV2.contains(policyNameMap2)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			int staticFareCalCul=staticFareAsStaticFareMatrix2;
			try{
				Assert.assertEquals(adultActualF2	, staticFareCalCul);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			try{
				Assert.assertEquals(adultActualF2	, staticFareCalCul);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			
			
			}
			break;
		case "DYNAMICFARE":{

			if(fareTypeSFV2.contains("Dynamic fare")&&fareTypeSFV2.contains(policyNameMap)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			if(!fareTypeSFV2.contains(policyNameMap2)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			
			try{
				Assert.assertEquals(adultActualF2	, dispFareSFF2);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			try{
				Assert.assertEquals(adultActualF2	, dispFareSFF2);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}

	
			
		}
			break;
			default:
				rf=new UpdateStatusFormat("Matrix is not matched with Matrix",""+rowNo,"6","1");
				reportList.add(rf);
				
		}


	}

	public void updateStatus3(int rowNo){


		
		
		String policyType=fareTypeAsFareTypeMatrix.toUpperCase();
		policyType=policyType.replaceAll("\\s+", "");
		
		switch(policyType){
		
		case "TIEREDFARE":{
			if(fareTypeSFV3.contains("Tiered fare")&&fareTypeSFV.contains(policyNameMap)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			if(fareTypeSFV3.contains(policyNameMap2)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			int staticFareCalCul=staticFareAsStaticFareMatrix3;
			try{
				Assert.assertEquals(adultActualF3	, staticFareCalCul);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			try{
				Assert.assertEquals(adultActualF3	, staticFareCalCul);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
	
		
			}
			break;
		case "DYNAMICFARE":{

			if(fareTypeSFV3.contains("Dynamic fare")&&fareTypeSFV3.contains(policyNameMap)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			if(!fareTypeSFV3.contains(policyNameMap2)){
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}else{
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;			
			}
			
			try{
				Assert.assertEquals(adultActualF3	, dispFareSFF3);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			try{
				Assert.assertEquals(adultActualF3	, dispFareSFF3);
				rf=new UpdateStatusFormat("Pass",""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;

			}catch(Throwable t){
				rf=new UpdateStatusFormat("Fail",  ""+rowNo,"5","1");
				reportList.add(rf);
				rowNo++;
			}
			 
		
			
		}
			break;
			default:
				rf=new UpdateStatusFormat("Matrix is not matched with Matrix",""+rowNo,"6","1");
				reportList.add(rf);
				
		}


	}

}

