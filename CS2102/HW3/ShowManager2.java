import java.util.LinkedList;

public class ShowManager2 {
	// constructor
	ShowManager2() {}

	// returns ShowSummary with shows from the input list sorted into daytime and primetime shows 
	public ShowSummary organizeShows(LinkedList<Show> shows) {
	 	LinkedList<Show>cleandDaytime = new LinkedList<Show>(); // creates a list for ShowSummary daytime
		LinkedList<Show>cleandPrimetime = new LinkedList<Show>(); // creates a list for ShowSummary primetime
		LinkedList<Show>restOfList = new LinkedList<Show>(); // creates a list for not daytime
		
		
	    ShowSummary report3 = new ShowSummary (cleandDaytime,cleandPrimetime); // creates a return ShowSummary
	     
	 // picks out the shows that run during daytime, everything else goes to list of rest
	    for(Show s :shows) { 
	    	if(s.broadcastTime >= 600&& s.broadcastTime<= 1700)
				cleandDaytime.add(s); 
	    	    else restOfList.add(s);
	    }
	 // picks out the shows that run during primetime
	  for(Show b: restOfList) {
		  if(b.broadcastTime>= 1700 && b.broadcastTime<=2300) {
				cleandPrimetime.add(b);
				}
	  }
	    
	    
	  return report3;   //returns ShowSummary
		 
	}
	
}