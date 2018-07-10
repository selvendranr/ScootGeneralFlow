package pack.base;

public class DownSizeFormat {
		private String slNo;	   
	    private String when;
	    private String scenario;
	    private String tripType;
	    private String requestType;
	    private String runningMode;
	
	     
	    public DownSizeFormat(String slNo,String when,String scenario,String tripType,String requestType,String run){
	        this.slNo=slNo;
	        this.when=when;	 
	        this.scenario=scenario;	
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
	    public String getWhen() {
	        return when;
	    }
	    public void setWhen(String when) {
	        this.when = when;
	    }

	    public String getScenario() {
	        return scenario;
	    }
	    public void setScenario(String scenario) {
	        this.scenario = scenario;
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
	        return slNo+ "::" +when+ "::" +scenario+ "::" +tripType+ "::" +runningMode;
	    }

}
