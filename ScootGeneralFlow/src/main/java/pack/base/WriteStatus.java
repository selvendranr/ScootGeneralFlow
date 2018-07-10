package pack.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WriteStatus {
		protected WebDriver driver;
		public WriteStatus(WebDriver driver) {
		this.driver = driver;
	}

	
	
	
	public void  writeExcelData(String fileName,List<UpdateStatusFormat> statusList)throws Exception {
	       
		int row,col,sheetNo;

		try {

            FileInputStream file = new FileInputStream(new File(fileName));

            Workbook workbook = null;
            HSSFSheet sheet=null;
            Cell cell = null;


 	            if(fileName.endsWith("xlsx")){
 	            workbook = new XSSFWorkbook(file);
 	        }else if(fileName.endsWith("xls")){
 	            workbook = new HSSFWorkbook(file);
 	        }else{
 	           // throw new Exception("invalid file name, should be xls or xlsx");
 	        }
 	      
          
 	        


	    Iterator<UpdateStatusFormat> iterator = statusList.iterator();        
	      while(iterator.hasNext()){
	        	UpdateStatusFormat reportToExel = iterator.next();
	        	
	 	
	        	row=Integer.parseInt(reportToExel.getRowNo());
	        	col	=Integer.parseInt(reportToExel.getColNo());	
	        	sheetNo	=Integer.parseInt(reportToExel.getSheetNo());	
	        	
	        	 sheet = (HSSFSheet) workbook.getSheetAt(sheetNo);
	        	
	        
	        	//cell = sheet.getRow(row).getCell(col);
	        	// cell.setCellValue(reportToExel.getStatus());
	        	
	        	
	        	 HSSFRow sheetrow = sheet.getRow(row);
		            if(sheetrow == null){
		                sheetrow = sheet.createRow(row);
		            }
		            //Update the value of cell
		            cell = sheetrow.getCell(col);
		            if(cell == null){
		                cell = sheetrow.createCell(col);
		            }
		            cell.setCellValue(reportToExel.getStatus());


	        }
	            

        //lets write the excel data to file now
	        FileOutputStream fos = new FileOutputStream(fileName);
	        workbook.write(fos);
	        fos.close();
	        System.out.println(fileName + " written successfully");
	        workbook.close(); 
	        
	        
	        
	        
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    }

}
