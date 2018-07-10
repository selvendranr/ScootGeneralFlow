package pack.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadRootPath 

{
	
	 
	  String filePath="D:\\AutomationBackUpFiles\\ScootGeneralFlow\\LoginCredential\\rootPath.txt";
	   
	  String rootPath;
	  public String getPath(){
	     
	 try {
	        FileInputStream fstream = new FileInputStream(filePath);
	        BufferedReader infile = new BufferedReader(new InputStreamReader(fstream));
	        String data1 = new String();
	        while ((data1 = infile.readLine()) != null) 
	        
	        { // use if for reading just 1 line
	        	 
	        	rootPath=data1;
	        }
	    } catch (IOException e) {
	        // Error
	    }
	 
	  return rootPath;
	  }
	  





	    
	 
}
