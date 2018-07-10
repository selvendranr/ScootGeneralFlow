 package ScootGeneral.ScootGeneralFlow;

import java.io.FileNotFoundException;
import java.io.IOException;

import pack.base.ReadCancelPolicyInput;
import pack.base.ReadFareSettingInput;

public class ReadDiscount {
	
	ReadFareSettingInput read;
	
	 String slNoV,tripTypeV,requestTypeV,runningModeV;


	
	 public int rIndex;
	 
	public void readRecord(String filePath) throws FileNotFoundException,IOException{
	
			read = new ReadFareSettingInput();

			try {
				read.getExcelData(filePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rIndex=read.rIndex;
			
			
			getValue(rIndex);
			System.out.println( slNoV+"\t"+tripTypeV+"\t"+runningModeV);
			
	 
			System.out.println("Before");
			System.out.println( slNoV+"\t"+tripTypeV+"\t"+runningModeV);
			System.out.println("After");
			
			 
	
	}
	


	
	
	
		public void getValue(int recordNo){
			slNoV=read.getDetails("SLNO",recordNo);			
			tripTypeV=read.getDetails("TRIPTYPE",recordNo);	
			requestTypeV=read.getDetails("REQUESTTYPE",recordNo);				
			runningModeV=read.getDetails("RUNNINGMODE",recordNo);
		


			 
		}
		

		 


		
}
