import java.util.LinkedList;

public class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

//returns a MaxHzReport list of max data of each day in the input month from the input data
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  
	  LinkedList<MaxHzReport> report = new LinkedList<MaxHzReport>(); // creates a return list
	  
	  for(int i =0; i<data.size(); i++) {
		  if(isDate(data.get(i)) && extractMonth(data.get(i))==month) // checks if data double is a date of needed month
		  {
			  double max = 0; //creates variable max to keep track of max data
			  for(int j =i+1; j<data.size();j++) {
				  if(isDate(data.get(j))) {// checks if the data is another date
					  break; 				// if true finish the loop
					  } 
				  if(data.get(j)>max)   // checks if data is more than max of that date
				  { max = data.get(j);} // if true make the new data the max
			  }
			  report.add(new MaxHzReport(data.get(i), max)); // add the new date and max to the return date
		  }
	  }
	  
	  return report; // return the list
  }
}