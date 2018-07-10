package pack.base;

public class LogInCredential {
	 private String userName;
	    private String passWord;
	     
	    public LogInCredential(String un, String pwd){
	        this.userName=un;
	        this.passWord=pwd;
	    }
	     
	    public String getName() {
	        return userName;
	    }
	    public void setPassword(String userName) {
	        this.userName = userName;
	    }
	    public String getPassword() {
	        return passWord;
	    }
	    public void getPassword(String passWord) {
	        this.passWord = passWord;
	    }
	     
	    @Override
	    public String toString(){
	        return userName + "::" + passWord;
	    }

}
