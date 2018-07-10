package pack.base;

public class FareTypeMatrixFormat {
	private int daysToDepart;	   
    private String firstCol;
    private String secondCol;
    private String thirdCol;
    private String fourthCol;
    private String fifthCol;



     
    public FareTypeMatrixFormat(int daysToDepart,String firstCol,String secondCol,String thirdCol,String fourthCol,String fifthCol){
	        this.daysToDepart=daysToDepart;
	        this.firstCol=firstCol;	 
	        this.secondCol=secondCol;	
	        this.thirdCol=thirdCol;
	        this.fourthCol=fourthCol;
	        this.fifthCol=fifthCol;
	    
	    }
	     
    public int getDaysToDepart() {
        return daysToDepart;
    }
    public void setDaysToDepart(int daysToDepart) {
        this.daysToDepart = daysToDepart;
    }
    public String getFirstCol() {
        return firstCol;
    }
    public void setFirstCol(String firstCol) {
        this.firstCol = firstCol;
    }

    public String getSecondCol() {
        return secondCol;
    }
    public void setSecondCol(String secondCol) {
        this.secondCol = secondCol;
    } 
	    public String getThirdCol() {
        return thirdCol;
    }
    public void setThirdCol(String thirdCol) {
        this.thirdCol = thirdCol;
    }
    public String getFourthCol() {
  	        return fourthCol;
  	    }
  	    public void setFourthCol(String fourthCol) {
  	        this.fourthCol = fourthCol;
  	    }
	    public String getFifthCol() {
  	        return fifthCol;
  	    }
  	    public void setFifthCol(String fifthCol) {
  	        this.fifthCol = fifthCol;
  	    }



   	
	 
	    @Override
	    public String  toString(){
	        return daysToDepart+ "::" +firstCol+ "::" +secondCol+ "::" +thirdCol+ "::" +fourthCol+ "::" +fourthCol;
	    }

}
