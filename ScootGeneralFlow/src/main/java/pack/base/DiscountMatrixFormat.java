package pack.base;

public class DiscountMatrixFormat {
	private int daysToDepart;	   
	    private int firstCol;
	    private int secondCol;
	    private int thirdCol;
	    private int fourthCol;
	    private int fifthCol;
	

	
	     
	    public DiscountMatrixFormat(int daysToDepart,int firstCol,int secondCol,int thirdCol,int fourthCol,int fifthCol){
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
	    public int getFirstCol() {
	        return firstCol;
	    }
	    public void setFirstCol(int firstCol) {
	        this.firstCol = firstCol;
	    }

	    public int getSecondCol() {
	        return secondCol;
	    }
	    public void setSecondCol(int secondCol) {
	        this.secondCol = secondCol;
	    } 
		    public int getThirdCol() {
	        return thirdCol;
	    }
	    public void setThirdCol(int thirdCol) {
	        this.thirdCol = thirdCol;
	    }
	    public int getFourthCol() {
	  	        return fourthCol;
	  	    }
	  	    public void setFourthCol(int fourthCol) {
	  	        this.fourthCol = fourthCol;
	  	    }
		    public int getFifthCol() {
	  	        return fifthCol;
	  	    }
	  	    public void setFifthCol(int fifthCol) {
	  	        this.fifthCol = fifthCol;
	  	    }



   	
	 
	    @Override
	    public String  toString(){
	        return daysToDepart+ "::" +firstCol+ "::" +secondCol+ "::" +thirdCol+ "::" +fourthCol+ "::" +fourthCol;
	    }

}
