package pack.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SectorGenerator {
	
	public String[] sectorGenerator(String filePath,String delemiter){
		
		


		//String str="D:\\AutomationBackUpFiles\\CoreJavaBackupFiles\\Test.txt";	
		String temp = null ;
		String[] sector=null;
		
		try {
			FileInputStream file=new FileInputStream(filePath);
			BufferedReader br=new BufferedReader(new InputStreamReader(file));
			 String data1 = new String();
			try {
				while((data1=br.readLine())!=null){
					 
					temp=data1;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(temp);
		sector = temp.split(delemiter);
		 for(int i=0;i<sector.length;i++){
			 System.out.println(sector[i]);
		 }
		
		 



		 return sector;
	 
		
	}

}
