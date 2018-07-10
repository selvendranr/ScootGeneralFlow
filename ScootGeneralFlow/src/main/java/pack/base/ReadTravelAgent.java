package pack.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTravelAgent 

{
	
	 
	  String filePath="InputFile\\Travel Agency Details.txt";
	  private String IATACode=null,TAName=null;	  
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
	  
	  public ReadTravelAgent(){
		  getDate();	
		  TAName=data.substring(0,data.indexOf("|"));
		  IATACode=data.substring(data.indexOf("|")+1,data.length());	
		  }
	  
	  public String getTAName() {
	        return TAName;
	    }
	    public void setTAName(String TAName) {
	        this.TAName = TAName;
	    }
	    
		  public String getIATACode() {
		        return IATACode;
		    }
		    public void setIATACode(String IATACode) {
		        this.IATACode = IATACode;
		    }

	    
	 
}
