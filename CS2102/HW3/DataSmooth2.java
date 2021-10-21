import java.util.LinkedList;

public class DataSmooth2 {
  DataSmooth2(){}
  
  // returns the Smoothed average runtime of episodes of each Show in input Shows list
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  { 
	  LinkedList<Double> result= new LinkedList<Double>();   // creating the return list
	  if(shows.size()==0)         //checking if the size of the input list is zero
		  return result;		// if it is just return empty list
	  for(int i=1; i<shows.size()-1; i++) {			// runs till size-1 so (i+1) in the code is not out of index  
		result.add((findAverage(shows.get(i))+
					  		findAverage(shows.get(i-1)) +
			   				findAverage(shows.get(i+1))) /3
					  );  // adds the averages of 3 doubles and divided by 3 to the return list
			  
	  }
	  result.addFirst(findAverage(shows.getFirst()));  // adds the average runtime of the first show in shows
	  												   // to return list(unmodified)
	  result.addLast(findAverage(shows.getLast())); // adds the average runtime of the last show in shows
		   											// to return list(unmodified)
	  
	  return result;  // returns the list
  }
  
  // returns the average runtime of episodes in the input Show
  public Double findAverage(Show a) {
	  double sum=0; // creates sum variable
	  double times=0; // creates the number of times counter variable
	  for(Episode b: a.episodes) {
		 sum= sum+ b.runTime;  // adds up the runtimes
		 times++;    // counts the number of episodes in Show
	  }
	 // return sum/a.episodes.size();
	  return sum/times;  // returns the average runtime of episodes in the input Show
  }
}