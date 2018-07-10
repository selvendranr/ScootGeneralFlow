package pack.base;

public class TimeLimitFormat {
		private String daysToDepart;	   
	    private String fareVal;
	    private String fareValType;
	    private String payVal1;
	    private String payValType1;
	    private String payValPer1;
	    private String payVal2;
	    private String payValType2;
	    private String payValPer2;
	    private String payVal3;
	    private String payValType3;
	    private String payValPer3;
   	    private String ticketVal;
	    private String ticketValType;

	
	     
	    public TimeLimitFormat(String daysToDepart,String fareVal,String fareValType,String payVal1,String payValType1,String payValPer1,String payVal2,String payValType2,String payValPer2,String payVal3,String payValType3,String payValPer3,String ticketVal,String ticketValType){
	        this.daysToDepart=daysToDepart;
	        this.fareVal=fareVal;	 
	        this.fareValType=fareValType;	
	        this.payVal1=payVal1;
	        this.payValType1=payValType1;
	        this.payValPer1=payValPer1;
	        this.payVal2=payVal2;
	        this.payValType2=payValType2;
	        this.payValPer2=payValPer2;
	        this.payVal3=payVal3;
	        this.payValType3=payValType3;
	        this.payValPer3=payValPer3;
	        this.ticketVal=ticketVal;	 
	        this.ticketValType=ticketValType;
	    
	    }
	     
	    public String getDaysToDepart() {
	        return daysToDepart;
	    }
	    public void setDaysToDepart(String daysToDepart) {
	        this.daysToDepart = daysToDepart;
	    }
	    public String getFareVal() {
	        return fareVal;
	    }
	    public void setFareVal(String fareVal) {
	        this.fareVal = fareVal;
	    }

	    public String getfareValType() {
	        return fareValType;
	    }
	    public void setfareValType(String fareValType) {
	        this.fareValType = fareValType;
	    } 
		    public String getPayVal1() {
	        return payVal1;
	    }
	    public void setPayVal1(String payVal1) {
	        this.payVal1 = payVal1;
	    }
	    public String getPayValType1() {
	  	        return payValType1;
	  	    }
	  	    public void setPayValType1(String payValType1) {
	  	        this.payValType1 = payValType1;
	  	    }
		    public String getPayValPer1() {
	  	        return payValPer1;
	  	    }
	  	    public void setPayValPer1(String payValPer1) {
	  	        this.payValPer1 = payValPer1;
	  	    }

	    public String getPayVal2() {
	        return payVal2;
	    }
	    public void setPayVal2(String payVal2) {
	        this.payVal2 = payVal2;
	    }
	    public String getPayValType2() {
	  	        return payValType2;
	  	    }
	  	    public void setPayValType2(String payValType2) {
	  	        this.payValType2 = payValType2;
	  	    }
		    public String getPayValPer2() {
	  	        return payValPer2;
	  	    }
	  	    public void setPayValPer2(String payValPer2) {
	  	        this.payValPer2 = payValPer2;
	  	    }
	    public String getPayVal3() {
	        return payVal3;
	    }
	    public void setPayVal3(String payVal3) {
	        this.payVal3 = payVal3;
	    }
	    public String getPayValType3() {
	  	        return payValType3;
	  	    }
	  	    public void setPayValType3(String payValType3) {
	  	        this.payValType3 = payValType3;
	  	    }
		    public String getPayValPer3() {
	  	        return payValPer3;
	  	    }
	  	    public void setPayValPer3(String payValPer3) {
	  	        this.payValPer3 = payValPer3;
	  	    }

	    public String getTicketVal() {
	        return ticketVal;
	    }
	    public void setTicketVal(String ticketVal) {
	        this.ticketVal = ticketVal;
	    }
	    public String getTicketValType() {
	        return ticketValType;
	    }
	    public void setTicketValType(String ticketValType) {
	        this.ticketValType = ticketValType;
	    }
   	
	 
	    @Override
	    public String toString(){
	        return daysToDepart+ "::" +fareVal+ "::" +fareValType+ "::" +payVal1+ "::" +payValType1+ "::" +payValType2;
	    }

}
