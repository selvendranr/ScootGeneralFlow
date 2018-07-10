package pack.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadPolicySettingsInput {
	
	
	


	
		 public List<PolicySettingsFormat> inputList=new ArrayList<PolicySettingsFormat>();
		 PolicySettingsFormat inputFormat=null;
		 public int rIndex;
			
	
	public void   getExcelData(String fileName)throws IOException {
		int listSize;
	       
		String slNo=null;	   
	    String tripType=null;
	    String requestType = null;	  
	    String runningMode=null;	 



		try {

            FileInputStream file = new FileInputStream(new File(fileName));

            Workbook workbook = null;
            

            if(fileName.endsWith("xlsx")){
 	            workbook = new XSSFWorkbook(file);
 	        }else if(fileName.endsWith("xls")){
 	            workbook = new HSSFWorkbook(file);
 	        }else{
 	           // throw new Exception("invalid file name, should be xls or xlsx");
 	        }
 	      
            int numberOfSheets = workbook.getNumberOfSheets();
            
            //loop through each of the sheets
            for(int i=0; i < numberOfSheets; i++){
                 
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);
                 
                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {

                	//Get the row object
                    Row row = rowIterator.next();
                     
                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();
                      
                    while (cellIterator.hasNext()) 
                    {
                        //check the cell type and process accordingly
                      Cell nextCell = cellIterator.next();
                      int columnIndex = nextCell.getColumnIndex();
           
                      switch (columnIndex) {
                      case 0:
                      	slNo=(String) getCellValue(nextCell);
                      	break;
                       case 1:
                      	tripType=(String) getCellValue(nextCell);
                      	break;
                      case 2:
                      	requestType=(String) getCellValue(nextCell);
                      	break;
                      case 3:
                      	runningMode=(String) getCellValue(nextCell);
                      	break;

       	

                      }
                  } //end of cell iterator
                     inputFormat = new PolicySettingsFormat(slNo,tripType,requestType,runningMode);
                     inputList.add(inputFormat);
                } //end of rows iterator
                 
                 
            } //end of sheets for loop
             
            //close file input stream
           
             
        } catch (IOException e) {
            e.printStackTrace();
        }
         
       
		
		
		 listSize=inputList.size();
		   System.out.println("No of Lines Are ");
		   System.out.println(listSize);
		
		 int countCA=0;
		   int tempCA=1;
		   while(countCA<1&&tempCA<=listSize){
			   
			   System.out.println(countCA);
			   System.out.println(tempCA);
			   System.out.println(listSize);
			   System.out.println("Test 3");
			   System.out.println(getDetails("RUNNINGMODE",tempCA));

			   if(getDetails("RUNNINGMODE",tempCA).equalsIgnoreCase("YES"))
				   {
				   rIndex=tempCA;
				   countCA++;
				   tempCA++;
				   
				   }
			   else{
				   tempCA++;
				   continue;
			   }
			   
			   
		   }

}
	
	
	
	
	
	 
	public String getDetails(String fieldName,int rowNo){
		String fieldValue = null;
		fieldName=fieldName.toUpperCase();
		 switch (fieldName) {
		 
		 case "SLNO": 
			 fieldValue= inputList.get(rowNo).getSlNo();
			 break;  
		 case "TRIPTYPE": 
			 fieldValue= inputList.get(rowNo).getTripType();
			 break;  
		
		 case "REQUESTTYPE": 
			 fieldValue= inputList.get(rowNo).getRequestType();
			 break;  
			 
		 case "RUNNINGMODE": 
			 fieldValue= inputList.get(rowNo).getRunningMode();
			 break;


		default:
				System.out.println("unknown Field" );
				break;		
	}
		 
	return 	 fieldValue;
		 
}
	
	
	private Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return NumberToTextConverter.toText(cell.getNumericCellValue());
	    }
	 
	    return null;
	}
	
}