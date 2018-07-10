package pack.base;

public class PolicySettingsFormat{
		private String slNo;	   
	    private String tripType;
	    private String requestType;
	    private String runningMode;
	
	     
	    public PolicySettingsFormat(String slNo,String tripType,String requestType,String run){
	        this.slNo=slNo;
	        this.tripType=tripType;
	        this.requestType=requestType;
	        this.runningMode=run;
	    
	    }
	     
	    public String getSlNo() {
	        return slNo;
	    }
	    public void setSlNo(String slNo) {
	        this.slNo = slNo;
	    }

	    public String getTripType() {
	  	        return tripType;
	  	    }
	  	    public void setTripType(String tripType) {
	  	        this.tripType = tripType;
	  	    }
		    public String getRequestType() {
	  	        return requestType;
	  	    }
	  	    public void setRequestType(String requestType) {
	  	        this.requestType = requestType;
	  	    }
	    public String getRunningMode() {
	        return runningMode;
	    }
	    public void setRunningMode(String runningMode) {
	        this.runningMode = runningMode;
	    }
	    @Override
	    public String toString(){
	        return slNo+ "::" +tripType+ "::" +requestType+ "::" +runningMode;
	    }

}
