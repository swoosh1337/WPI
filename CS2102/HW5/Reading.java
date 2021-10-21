
public class Reading {
	 private Time time; // hours and minutes
	 private int temp;
	 
	    public Reading(Time time, int temp){
	    	this.time=time;
	    	this.temp=temp;
	    	
	    }
	    public int getTemp() {
	    	return this.temp;
	    }
	    public double getTime() {
	    	return this.time.getTime();
	    }
	    public double getTimeMinutes() {
	    	return this.time.getMinutes();
	    }
	    public double getTimeHours() {
	    	return this.time.getHours();
	    }
}
