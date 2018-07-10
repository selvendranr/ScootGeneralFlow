package pack.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadRequestorType {
	
	 
	  String filePath="InputFile\\Whome do you want make request airline user or travel agent.txt";
	  static String userType=null;	  
	  String data;
	  public void getDate(){
		  ReadRootPath readRoot=new ReadRootPath();
		  String rootPath=readRoot.getPath();
	     
	 try {
	        FileInputStream fstream = new FileInputStream(rootPath+filePath);
	        BufferedReader infile = new BufferedReader(new InputStreamReader(fstream));
	        String data1 = new String();
	        while ((data1 = infile.readLine()) != null) 
	        
	        { // use if for reading just 1 line
	        	 
	        	data=data1;
	        }
	    } catch (IOException e) {
	        // Error
	    }
	 
	  
	  }
	  
	  public ReadRequestorType(){
		  getDate();	
		   
		  }
	  
	  public String getUserType() {
		  if(data.equalsIgnoreCase("travel agent"))
	        return "TA";
		  else if(data.equalsIgnoreCase("airline user"))
		        return "AU";
		  else  
		        return "Invalid";
	    }



	    
	 


}
