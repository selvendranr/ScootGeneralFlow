package pack.base;

public class ReportFormat {
		private String actual;
	    private String expected;
	    private String status;
	    private String module;
	     
	    public ReportFormat(String ac, String ex,String st,String ml){
	        this.actual=ac;
	        this.expected=ex;
	        this.status=st;
	        this.module=ml;
	    }
	     
	    public String getActualValue() {
	        return actual;
	    }
	    public void setActualValue(String actual) {
	        this.actual = actual;
	    }
	    public String getExpectedValue() {
	        return expected;
	    }
	    public void setExpectedValue(String expected) {
	        this.expected = expected;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	     
	    public String getModule() {
	        return module;
	    }
	    public void setModule(String module) {
	        this.module = module;
	    }
	    @Override
	    public String toString(){
	        return actual + "::" + expected + "::" +status+ "::" +module;
	    }

}
