package ScootGeneral.ScootGeneralFlow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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

public class DownSizeRequestTest extends TestBaseSetup
   
{
    
	private WebDriver driver;
	private ReadDownSizeInput read;
	
	private AdhocOneWayModifyRequest oneway;
	private AdhocRoundTripModifyRequest roundTrip;
	private AdhocMultiCityModifyRequest multiCity;
	private DownSizeOnewayBefore downSize;
	
	
	private ProcessNegoAdhocOneWay processOneway;
	private ProcessNegoAdhocRoundTrip processRoundTrip;
	private ProcessNegoAdhocMultiCity processMultiCity;
	
	
	private SeriesDateRangeOneWayModifyRequest seriesOneway;
	private SeriesDateRangeRoundTripModifyRequest seriesRoundTrip;
	private SeriesDateRangeMultiCityModifyRequest seriesMultiCity;
	private DownSizeSeriesOnewayBefore downSizeSeries;
	
	
	private ProcessDateRangeOneWay processSeriesOneway;
	private ProcessDateRangeRoundTrip processSeriesRoundTrip;
	private ProcessDateRangeMultiCity processSeriesMultiCity;
	
	private ProcessDownSizeAdhocOneWay processDownSize;
	private ProcessDownSizeSeriesOneWay processSeriesDownSize;
	
	private AcceptRequestDownSizeOneway accept;
	private AcceptSeriesDateRangeDownSizeOneway acceptSeries;
	
	private DownSizeOnewayAfterAccept afterAcceptDownsize;
	

	String inputFile="InputFile\\DownSize.xls";
	String reportexcelFile="DataDrivenReport\\Modify Request.xls";
	String sectorInput="InputFile\\Sector.txt";
	String delimeter="-";
	
	
	private String slNo,when,scenario,tripTypeRead,requestType;
	private boolean runningMode=false;
	String groupNameReq,adultReq,childReq,infantReq,expectedReq,reqId,remarkReq;
	String origin1Req,destination1Req,origin2Req,destination2Req,origin3Req,destination3Req;
 	
	String adultCurr,childCurr,infantCurr,adultNew,childNew,infantNew;
	String adultProcess,childProcess,infantProcess,adultNewProcess,childNewProcess,infantNewProcess;

	List<UpdateStatusFormat> reportList= new ArrayList<UpdateStatusFormat>();
	WriteTestCaseStatus write=new WriteTestCaseStatus(driver);
	UpdateStatusFormat rf;
	ReadRootPath readRoot=new ReadRootPath();
	String rootPath=readRoot.getPath();
	String suceedMsg;
	String seriesSuceedMsg;
	String processAdhocSuceedMsg;
	String approverRemarks;
	String downsizeStatus;
	
	 List<DownSizeFormat> inputList=new ArrayList<DownSizeFormat>();
	 private int indexOfInput;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	@Parameters({"indexVal"})
	@Test
	public void readDownSizeInput(int indexVal) throws IOException {
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

	 
	@Test(dependsOnMethods = "readDownSizeInput",priority=1)
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
	
	@Test(dependsOnMethods = "readDownSizeInput",priority=2)
	public void downSize() throws IOException {
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
						raiseOnewayDownSizeBeforeApprove(tripType);
						
						break;
						
					case "ROUNDTRIP":
						raiseOnewayDownSizeBeforeApprove(tripType);
						break;
					
					case "MULTICITY":
						raiseOnewayDownSizeBeforeApprove(tripType);
						break;
				
					
					}
					break;
					
				case "SERIES":
					switch(tripType){
					case "ONEWAY":
						raiseOnewaySeriesDownSizeBeforeApprove(tripType);
						break;
						
					case "ROUNDTRIP":
						raiseOnewaySeriesDownSizeBeforeApprove(tripType);
						break;
					
					case "MULTICITY":
						raiseOnewaySeriesDownSizeBeforeApprove(tripType);
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
						raiseOnewayDownSizeAfterApprove(tripType);	 
						processOnewayDownSizeAfterApprove(tripType);
						 break;
						
					case "ROUNDTRIP":
						processRoundTrip=new ProcessNegoAdhocRoundTrip(driver);
						try {
							processRoundTrip.processAdHocRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseOnewayDownSizeAfterApprove(tripType);
						processOnewayDownSizeAfterApprove(tripType);
						break;
					
					case "MULTICITY":
						processMultiCity=new ProcessNegoAdhocMultiCity(driver);
						try {
							processMultiCity.processAdHocRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseOnewayDownSizeAfterApprove(tripType);
						processOnewayDownSizeAfterApprove(tripType);
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
						raiseOnewaySeriesDownSizeAfterApprove(tripType);
						processSeriesOnewayDownSizeAfterApprove(tripType);
						break;
						
					case "ROUNDTRIP":
						processSeriesRoundTrip=new ProcessDateRangeRoundTrip(driver);
						try {
							processSeriesRoundTrip.processSeriesRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						raiseOnewaySeriesDownSizeAfterApprove(tripType);
						processSeriesOnewayDownSizeAfterApprove(tripType);
						break;
					
					case "MULTICITY":
						processSeriesMultiCity=new ProcessDateRangeMultiCity(driver);
						try {
							processSeriesMultiCity.processSeriesRequest(reqId);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						raiseOnewaySeriesDownSizeAfterApprove(tripType);
						processSeriesOnewayDownSizeAfterApprove(tripType);
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
					raiseOnewayDownSizeAfterAccept(tripType);
					processOnewayDownSizeAfterAccept(tripType);
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
					raiseOnewayDownSizeAfterAccept(tripType);
					processOnewayDownSizeAfterAccept(tripType);
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
					raiseOnewayDownSizeAfterAccept(tripType);
					processOnewayDownSizeAfterAccept(tripType);
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
					raiseOnewaySeriesDownSizeAccept(tripType);
					processSeriesOnewayDownSizeAfterAccept(tripType);
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
					raiseOnewaySeriesDownSizeAccept(tripType);
					processSeriesOnewayDownSizeAfterAccept(tripType);
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
					raiseOnewaySeriesDownSizeAccept(tripType);
					processSeriesOnewayDownSizeAfterAccept(tripType);
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
	
	 
 
	/*
	 
	@Test(dependsOnMethods = "readDownSizeInput",priority=3)
	public void process()
	{	
		String tripType,reqType;
		reqType=requestType.toUpperCase();
		reqType=reqType.replaceAll("\\s+", "");

		tripType=tripTypeRead.toUpperCase();
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
	 
	*/
	 
	 
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
	
	public void raiseOnewayDownSizeBeforeApprove(String tripType){
		downSize=new DownSizeOnewayBefore(driver);
		downSize.downRequest(reqId);
		adultCurr=downSize.adultCurrV;
		childCurr=downSize.childCurrV;
		infantCurr=downSize.infantCurrV;
		adultNew=downSize.adultNewV;
		childNew=downSize.childNewV;
		infantNew=downSize.infantNewV;	
		suceedMsg=downSize.suceedMsgV;
		updateAdhocBefore(tripType);
		 
	}
	
	public void raiseOnewayDownSizeAfterApprove(String tripType){
		afterAcceptDownsize=new DownSizeOnewayAfterAccept(driver);
		afterAcceptDownsize.downRequest(reqId);
		adultCurr=afterAcceptDownsize.adultCurrV;
		childCurr=afterAcceptDownsize.childCurrV;
		infantCurr=afterAcceptDownsize.infantCurrV;
		adultNew=afterAcceptDownsize.adultNewV;
		childNew=afterAcceptDownsize.childNewV;
		infantNew=afterAcceptDownsize.infantNewV;
		suceedMsg=afterAcceptDownsize.suceedMsgV;
		updateAdhocAfter(tripType); 
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
 	
	public void raiseOnewaySeriesDownSizeBeforeApprove(String tripType){
		downSizeSeries=new DownSizeSeriesOnewayBefore(driver);
		downSizeSeries.downRequest(reqId);
		adultCurr=downSizeSeries.adultCurrV;
		childCurr=downSizeSeries.childCurrV;
		infantCurr=downSizeSeries.infantCurrV;
		adultNew=downSizeSeries.adultNewV;
		childNew=downSizeSeries.childNewV;
		infantNew=downSizeSeries.infantNewV;
		seriesSuceedMsg=downSizeSeries.suceedMsgV;
		updateSeriesBefore(tripType);
	}

	public void raiseOnewaySeriesDownSizeAfterApprove(String tripType){
		downSizeSeries=new DownSizeSeriesOnewayBefore(driver);
		downSizeSeries.downRequest(reqId);
		adultCurr=downSizeSeries.adultCurrV;
		childCurr=downSizeSeries.childCurrV;
		infantCurr=downSizeSeries.infantCurrV;
		adultNew=downSizeSeries.adultNewV;
		childNew=downSizeSeries.childNewV;
		infantNew=downSizeSeries.infantNewV;
		seriesSuceedMsg=downSizeSeries.suceedMsgV;
		updateSeriesAfter(tripType);
	}
	public void raiseOnewaySeriesDownSizeAccept(String tripType){
		downSizeSeries=new DownSizeSeriesOnewayBefore(driver);
		downSizeSeries.downRequest(reqId);
		adultCurr=downSizeSeries.adultCurrV;
		childCurr=downSizeSeries.childCurrV;
		infantCurr=downSizeSeries.infantCurrV;
		adultNew=downSizeSeries.adultNewV;
		childNew=downSizeSeries.childNewV;
		infantNew=downSizeSeries.infantNewV;
		seriesSuceedMsg=downSizeSeries.suceedMsgV;
		updateSeriesAccept(tripType);
	}
	
	public void processOnewayDownSizeAfterApprove(String tripType){
		processDownSize=new ProcessDownSizeAdhocOneWay(driver);
		try {
			processDownSize.processAdHocRequest(reqId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adultProcess=processDownSize.adultCurrV;
		childProcess=processDownSize.childCurrV;
		infantProcess=processDownSize.infantCurrV;
		adultNewProcess=processDownSize.adultNewV;
		childNewProcess=processDownSize.childNewV;
		infantNewProcess=processDownSize.infantNewV;
		processAdhocSuceedMsg=processDownSize.suceedMsgV;
		approverRemarks=processDownSize.approverRemarksV;
		updateProcessAdhocAfter(tripType);
	}

	public void processOnewayDownSizeAfterAccept(String tripType){
		processDownSize=new ProcessDownSizeAdhocOneWay(driver);
		try {
			processDownSize.processAdHocRequest(reqId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adultProcess=processDownSize.adultCurrV;
		childProcess=processDownSize.childCurrV;
		infantProcess=processDownSize.infantCurrV;
		adultNewProcess=processDownSize.adultNewV;
		childNewProcess=processDownSize.childNewV;
		infantNewProcess=processDownSize.infantNewV;
		processAdhocSuceedMsg=processDownSize.suceedMsgV;
		approverRemarks=processDownSize.approverRemarksV;
		updateProcessAdhocAccept(tripType);
	}


	
	
	public void processSeriesOnewayDownSizeAfterApprove(String tripType){
		processSeriesDownSize=new ProcessDownSizeSeriesOneWay(driver);
		try {
			processSeriesDownSize.processSeriesRequest(reqId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adultProcess=processSeriesDownSize.adultCurrV;
		childProcess=processSeriesDownSize.childCurrV;
		infantProcess=processSeriesDownSize.infantCurrV;
		adultNewProcess=processSeriesDownSize.adultNewV;
		childNewProcess=processSeriesDownSize.childNewV;
		infantNewProcess=processSeriesDownSize.infantNewV;
		downsizeStatus=processSeriesDownSize.statusV;	
		updateProcessSeriesApprove(tripType);
		 
	}
	public void processSeriesOnewayDownSizeAfterAccept(String tripType){
		processSeriesDownSize=new ProcessDownSizeSeriesOneWay(driver);
		try {
			processSeriesDownSize.processSeriesRequest(reqId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adultProcess=processSeriesDownSize.adultCurrV;
		childProcess=processSeriesDownSize.childCurrV;
		infantProcess=processSeriesDownSize.infantCurrV;
		adultNewProcess=processSeriesDownSize.adultNewV;
		childNewProcess=processSeriesDownSize.childNewV;
		infantNewProcess=processSeriesDownSize.infantNewV;
		downsizeStatus=processSeriesDownSize.statusV;	
		updateProcessSeriesApprove(tripType);
		 
	}

	public void raiseOnewayDownSizeAfterAccept(String tripType){
		afterAcceptDownsize=new DownSizeOnewayAfterAccept(driver);
		afterAcceptDownsize.downRequest(reqId);
		adultCurr=afterAcceptDownsize.adultCurrV;
		childCurr=afterAcceptDownsize.childCurrV;
		infantCurr=afterAcceptDownsize.infantCurrV;
		adultNew=afterAcceptDownsize.adultNewV;
		childNew=afterAcceptDownsize.childNewV;
		infantNew=afterAcceptDownsize.infantNewV;
		suceedMsg=afterAcceptDownsize.suceedMsgV;
		updateAdhocAccept(tripType);  
		 
	}
	

	public void updateAdhocBefore(String tripType){		
		
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "2","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat("Pass",  "3","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "2","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "9","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat("Pass",  "10","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "9","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "16","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat("Pass",  "17","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "16","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}

	public void updateAdhocAfter(String tripType){		
		
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "4","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "4","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "4","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "4","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "6","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "6","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}

	public void updateAdhocAccept(String tripType){		
		
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "6","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "6","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "13","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "13","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(suceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "20","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "20","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}


	public void updateSeriesBefore(String tripType){		
		
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "23","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat("Pass",  "24","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "23","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "30","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat("Pass",  "31","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "30","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "37","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat("Pass",  "38","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "37","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}


	public void updateSeriesAfter(String tripType){		
		
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "25","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "25","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "32","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "32","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "39","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "39","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}

	public void updateSeriesAccept(String tripType){		
		
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "27","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "27","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "34","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "34","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(seriesSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "41","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "41","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}

public void updateProcessAdhocAfter(String tripType){		
		
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(!StringUtils.isEmpty(processAdhocSuceedMsg)&&processAdhocSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "5","5","0");
			reportList.add(rf);
		

		}else if(StringUtils.isEmpty(processAdhocSuceedMsg)){
			rf=new UpdateStatusFormat("Pass",  "5","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat(approverRemarks,  "5","6","0");
			reportList.add(rf);
			
		}else{
			rf=new UpdateStatusFormat("Fail",  "5","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(!StringUtils.isEmpty(processAdhocSuceedMsg)&&processAdhocSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "12","5","0");
			reportList.add(rf);
		

		}else if(StringUtils.isEmpty(processAdhocSuceedMsg)){
			rf=new UpdateStatusFormat("Pass",  "12","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat(approverRemarks,  "12","6","0");
			reportList.add(rf);
			
		}else{
			rf=new UpdateStatusFormat("Fail",  "12","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(!StringUtils.isEmpty(processAdhocSuceedMsg)&&processAdhocSuceedMsg.contains("successfully")){
			rf=new UpdateStatusFormat("Pass",  "19","5","0");
			reportList.add(rf);
		

		}else if(StringUtils.isEmpty(processAdhocSuceedMsg)){
			rf=new UpdateStatusFormat("Pass",  "19","5","0");
			reportList.add(rf);
			rf=new UpdateStatusFormat(approverRemarks,  "19","6","0");
			reportList.add(rf);
			
		}else{
			rf=new UpdateStatusFormat("Fail",  "19","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}


public void updateProcessAdhocAccept(String tripType){		
	
	tripType=tripType.toUpperCase();
switch(tripType){	
case "ONEWAY":
	if(!StringUtils.isEmpty(processAdhocSuceedMsg)&&processAdhocSuceedMsg.contains("successfully")){
		rf=new UpdateStatusFormat("Pass",  "7","5","0");
		reportList.add(rf);
	

	}else if(StringUtils.isEmpty(processAdhocSuceedMsg)){
		rf=new UpdateStatusFormat("Pass",  "7","5","0");
		reportList.add(rf);
		rf=new UpdateStatusFormat(approverRemarks,  "7","6","0");
		reportList.add(rf);
		
	}else{
		rf=new UpdateStatusFormat("Fail",  "7","5","0");
		reportList.add(rf);
	} 
break;

case "ROUNDTRIP":
	if(!StringUtils.isEmpty(processAdhocSuceedMsg)&&processAdhocSuceedMsg.contains("successfully")){
		rf=new UpdateStatusFormat("Pass",  "14","5","0");
		reportList.add(rf);
	

	}else if(StringUtils.isEmpty(processAdhocSuceedMsg)){
		rf=new UpdateStatusFormat("Pass",  "14","5","0");
		reportList.add(rf);
		rf=new UpdateStatusFormat(approverRemarks,  "14","6","0");
		reportList.add(rf);
		
	}else{
		rf=new UpdateStatusFormat("Fail",  "14","5","0");
		reportList.add(rf);
	} 
break;

case "MULTICITY":
	if(!StringUtils.isEmpty(processAdhocSuceedMsg)&&processAdhocSuceedMsg.contains("successfully")){
		rf=new UpdateStatusFormat("Pass",  "21","5","0");
		reportList.add(rf);
	

	}else if(StringUtils.isEmpty(processAdhocSuceedMsg)){
		rf=new UpdateStatusFormat("Pass",  "21","5","0");
		reportList.add(rf);
		rf=new UpdateStatusFormat(approverRemarks,  "21","6","0");
		reportList.add(rf);
		
	}else{
		rf=new UpdateStatusFormat("Fail",  "21","5","0");
		reportList.add(rf);
	} 
break;


default:
	System.out.println("Trip Type is not Matching Plese check");

}


}


public void updateProcessSeriesApprove(String tripType){		
	  
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(downsizeStatus.equalsIgnoreCase("Approved")){
			rf=new UpdateStatusFormat("Pass",  "26","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "26","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(downsizeStatus.equalsIgnoreCase("Approved")){
			rf=new UpdateStatusFormat("Pass",  "33","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "33","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(downsizeStatus.equalsIgnoreCase("Approved")){
			rf=new UpdateStatusFormat("Pass",  "40","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "40","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}


public void updateProcessSeriesAccept(String tripType){		
	  
		tripType=tripType.toUpperCase();
	switch(tripType){	
	case "ONEWAY":
		if(downsizeStatus.equalsIgnoreCase("Approved")){
			rf=new UpdateStatusFormat("Pass",  "28","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "28","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "ROUNDTRIP":
		if(downsizeStatus.equalsIgnoreCase("Approved")){
			rf=new UpdateStatusFormat("Pass",  "35","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "35","5","0");
			reportList.add(rf);
		} 
	break;
	
	case "MULTICITY":
		if(downsizeStatus.equalsIgnoreCase("Approved")){
			rf=new UpdateStatusFormat("Pass",  "42","5","0");
			reportList.add(rf);
			 

		}else{
			rf=new UpdateStatusFormat("Fail",  "42","5","0");
			reportList.add(rf);
		} 
	break;
	
	
	default:
		System.out.println("Trip Type is not Matching Plese check");

	}
	
	
	}

	
}

