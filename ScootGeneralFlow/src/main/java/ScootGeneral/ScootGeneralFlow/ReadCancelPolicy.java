 package ScootGeneral.ScootGeneralFlow;

import java.io.FileNotFoundException;
import java.io.IOException;

import pack.base.ReadCancelPolicyInput;

public class ReadCancelPolicy {
	
	ReadCancelPolicyInput read;
	
	 String slNoV,noOfPaxV,tripTypeV,requestTypeV,runningModeV;


	
	 public int rIndex;
	 
	public void readRecord(String filePath) throws FileNotFoundException,IOException{
	
			read = new ReadCancelPolicyInput();

			try {
				read.getExcelData(filePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rIndex=read.rIndex;
			
			
			getValue(rIndex);
			System.out.println( slNoV+"\t"+noOfPaxV+"\t"+tripTypeV+"\t"+runningModeV);
			
	 
			System.out.println("Before");
			System.out.println( slNoV+"\t"+noOfPaxV+"\t"+tripTypeV+"\t"+runningModeV);
			System.out.println("After");
			
			 
	
	}
	


	
	
	
		public void getValue(int recordNo){
			slNoV=read.getDetails("SLNO",recordNo);			
			noOfPaxV=read.getDetails("NOOFPAX",recordNo);	
			tripTypeV=read.getDetails("TRIPTYPE",recordNo);	
			requestTypeV=read.getDetails("REQUESTTYPE",recordNo);				
			runningModeV=read.getDetails("RUNNINGMODE",recordNo);
		


			 
		}
		

		 


		
}
