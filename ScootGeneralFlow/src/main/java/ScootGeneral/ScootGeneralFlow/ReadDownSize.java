 package ScootGeneral.ScootGeneralFlow;

import java.io.FileNotFoundException;
import java.io.IOException;

import pack.base.ReadDownSizeInput;

public class ReadDownSize {
	
	ReadDownSizeInput read;
	
	 String slNoV,whenV,scenarioV,tripTypeV,requestTypeV,runningModeV;

	
	 public int rIndex;
	 
	public void readRecord(String fileName) throws FileNotFoundException,IOException{
	
			read = new ReadDownSizeInput();

			try {
				read.getExcelData(fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rIndex=read.rIndex;
			
			
			getValue(rIndex);
			System.out.println( slNoV+"\t"+whenV+"\t"+scenarioV+"\t"+tripTypeV+"\t"+runningModeV);
			
			 
			System.out.println("Before");
			System.out.println( slNoV+"\t"+whenV+"\t"+scenarioV+"\t"+tripTypeV+"\t"+runningModeV);
			System.out.println("After");
		
		
	
	}
	


	
	
	
		public void getValue(int recordNo){
			slNoV=read.getDetails("SLNO",recordNo);			
			whenV=read.getDetails("WHEN",recordNo);		 
			scenarioV=read.getDetails("SCENARIO",recordNo);			
			tripTypeV=read.getDetails("TRIPTYPE",recordNo);	
			requestTypeV=read.getDetails("REQUESTTYPE",recordNo);	
			runningModeV=read.getDetails("RUNNINGMODE",recordNo);
		

		
		}
		

		 


		
}
