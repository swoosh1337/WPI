//import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

public class DataSmooth1 {
  DataSmooth1(){}
  
  // returns the Smoothed average runtime of episodes of each Show in input Shows list
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> runTimeList = averageFinder(shows); // returns a list of average episode runtimes 
	  														 // of every show in shows list
	  LinkedList<Double> runTimeListLast = new LinkedList<Double>(); // the list to modify and return at the end
	  for(int i = 0; i < runTimeList.size(); i++)
	  {
		  if(i==0) // checking if it is the first of the list
			  runTimeListLast.add(runTimeList.get(i));  
		  else {
		 if(i==runTimeList.size()-1) // checking if it is the last of the list
			  runTimeListLast.add(runTimeList.get(i));
		 else{   // anything below this is not the first or the last
			  runTimeListLast.add((runTimeList.get(i)+
					               runTimeList.get(i+1)+
					               runTimeList.get(i-1)) /3);  // counting the averae of 3 doubles
		  }
	  }
  }
	  return runTimeListLast; // return the list of smoothed average runtimes of each show
	  }
  
//returns the list of average runtime of episodes of every show in the input Shows List
  public LinkedList<Double> averageFinder(LinkedList<Show> shows) 
  {
	  LinkedList<Double> example1 = new LinkedList<Double>(); // the list for output
	  double num=0; // variable to sum up the runtime values in each show
	 double k=0;  // variable to count the number of episodes in the show
	  for(Show s: shows) {
		  for(Episode a: s.episodes) {  // double loop to go through every episode of every show
			   num=num+a.runTime;       // summing the runtimes of every shows
			   k++;						// counting the number of episodes in the show
		  }	 
		  example1.add(num/k);          // adding the average runtime of a show to the return list
		  num=0;						// making the sum variable 0 for a new Show variable
		  k=0; 							// making the counter 0 for a new Show variable
	  }
	  
	  return example1; 					// return the list
  }
}