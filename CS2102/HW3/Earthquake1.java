import java.util.LinkedList;

public class Earthquake1 {
  Earthquake1(){}
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
  // returns a MaxHzReport list of max data of each day in the input month from the input data
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  double max=0;  //creates variable max to keep track of max data
	  double m =0;   // creates a variable m to store the needed date
	  LinkedList<MaxHzReport>Report1 =new LinkedList<>(); // creates a return list
	  
	  for(int i =0; i<data.size();i++) {
		  if(isDate(data.get(i)) && extractMonth(data.get(i))==month)
			  // checks if data double is a date of needed month
		  {
			  m=data.get(i); // stores the needed date
			  max=data.get(i+1);  // stores the first data of the needed month
			  for(int j=i+1;j<data.size();j++) {
				  if(data.get(j)<= 500) // checks if data is less than 500(a vibration sequence)
				  {
					   if(data.get(j)> max) // checks if the data is more than max data
						   max=data.get(j);   // if true makes the data the max data
				  }
				  if(data.get(j)> 10000000) // checks if the data is more than 10000000(another date)
					  break; 				// if true finish the loop
			  }
			  
		 // MaxHzReport r= new MaxHzReport(m,max); creates
		  Report1.add(new MaxHzReport(m,max)); // add the MaxHzReport with the date data and max vibration 
		  									   // of that date to return list
		  }
	  }

	  return Report1; // returns the list
  }
}