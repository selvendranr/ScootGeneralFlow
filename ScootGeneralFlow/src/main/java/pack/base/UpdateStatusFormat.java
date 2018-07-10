package pack.base;

public class UpdateStatusFormat {
	String			 status;           
	String           rowNo;            
	String           colNo;   
	String 			sheetNo;

	     
	    public UpdateStatusFormat(String status, String rowNo, String colNo,String sheetNo){
	    			this.status= status;          
	    			this.rowNo=rowNo;            
	    			this.colNo=colNo;          
	    			this.sheetNo=sheetNo;

	    }
	     
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
		 public String getRowNo() {
		        return rowNo;
		    }
		public void setRowNo(String rowNo) {
		        this.rowNo = rowNo;
		    }
	    public String getColNo() {
			        return colNo;
			    }
	    public void setColNo(String colNo) {
			        this.colNo = colNo;
			    }
	     
	    public String getSheetNo() {
	        return sheetNo;
	    }
	    public void setSheetNo(String sheetNo) {
	        this.sheetNo = sheetNo;
	    }



	    @Override
	    public String toString(){
	        return status+ "::" + rowNo+ "::" + colNo+ "::" + sheetNo;

	    }

}
