 package ScootGeneral.ScootGeneralFlow;

import java.io.FileNotFoundException;
import java.io.IOException;

import pack.base.ReadNegotiationPolicyInput;

public class ReadNegotiationPolicy {
	
	ReadNegotiationPolicyInput read;
	
	 String slNoV,noOfPaxV,tripTypeV,requestTypeV,noOfTimeV,runningModeV;


	
	 public int rIndex;
	 
	public void readRecord(String filePath) throws FileNotFoundException,IOException{
	
			read = new ReadNegotiationPolicyInput();

			try {
				read.getExcelData(filePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rIndex=read.rIndex;
			
			
			getValue(rIndex);
			System.out.println( slNoV+"\t"+"\t"+noOfPaxV+"\t"+tripTypeV+"\t"+runningModeV);
			
	 
			System.out.println("Before");
			System.out.println( slNoV+"\t"+"\t"+noOfPaxV+"\t"+tripTypeV+"\t"+runningModeV);
			System.out.println("After");
			
			 
	
	}
	


	
	
	
		public void getValue(int recordNo){
			slNoV=read.getDetails("SLNO",recordNo);			
			noOfPaxV=read.getDetails("NOOFPAX",recordNo);	
			tripTypeV=read.getDetails("TRIPTYPE",recordNo);	
			requestTypeV=read.getDetails("REQUESTTYPE",recordNo);	
			noOfTimeV=read.getDetails("NOOFTIME",recordNo);			
			
			runningModeV=read.getDetails("RUNNINGMODE",recordNo);
		
			 
			
			
			
			
			
			 
		}
		

		 


		
}
