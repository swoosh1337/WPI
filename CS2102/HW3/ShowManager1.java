import java.util.LinkedList;

public class ShowManager1 {
	// constructor
	ShowManager1() {}
	// returns ShowSummary with shows from the input list sorted into daytime and primetime shows 
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show>daytime = new LinkedList<Show>(); // creates a list for ShowSummary daytime
		LinkedList<Show>primetime = new LinkedList<Show>(); // creates a list for ShowSummary primetime
	    ShowSummary report2 = new ShowSummary (daytime,primetime); // creates a return ShowSummary
		 
		for(Show s: shows) { 
			if(s.broadcastTime >= 600 && s.broadcastTime< 1700) // checks if Show runs during daytime
				daytime.add(s);									// if true adds it to daytime list
			else {
			 if(s.broadcastTime>= 1700 && s.broadcastTime< 2300) // checks if Show runs during primetime
				primetime.add(s); 								 // if true adds it to primetime list
			 }
			
		}
			return  report2; // returns the ShowSummary
	}
	
}
