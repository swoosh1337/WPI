import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples 
{  
  LinkedList<Show> shows = new LinkedList<Show>();
  LinkedList<Double> showResults = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  DataSmooth2 D2 = new DataSmooth2();
  
  LinkedList<Show> shows2 = new LinkedList<Show>();
  LinkedList<Double> showResults2 = new LinkedList<Double>();
  LinkedList<Double> showResults3 = new LinkedList<Double>();
  
  public DataSmoothExamples() 
  {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2));
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4));
		

	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);
	    
	    LinkedList<Episode> eps5 = new LinkedList<Episode>();
		eps5.add(new Episode("Best of Both Worlds", 90));
		eps5.add(new Episode("The Ultimate Computer", 90));
		eps5.add(new Episode("Trials and Tribble-ations", 90));		
		shows2.add(new Show("Star Trek", 1800, eps5)); //90
		
		LinkedList<Episode> eps6 = new LinkedList<Episode>();
		eps6.add(new Episode("Fear of a Bot Planet", 55));
		eps6.add(new Episode("The Why of Fry", 60));
		eps6.add(new Episode("Roswell that Ends Well", 52));
		eps6.add(new Episode("Meanwhile", 72));
		shows2.add(new Show("Futurama", 1900, eps6)); //59.75
		
		LinkedList<Episode> eps7 = new LinkedList<Episode>();
		eps7.add(new Episode("Yakko's World", 2));
		eps7.add(new Episode("Hello Nice Warners", 3));
		eps7.add(new Episode("Where Rodents Dare", 4));
		shows2.add(new Show("Animaniacs", 1630, eps7)); //3
		
		LinkedList<Episode> eps8 = new LinkedList<Episode>();
		eps8.add(new Episode("The Letter W", 497));
		eps8.add(new Episode("The Letter P", 957));
		eps8.add(new Episode("The Letter I", 154));
		shows2.add(new Show("Sesame Street", 900, eps8)); //536
		
	    showResults2.add(90.0);
	    showResults2.add(50.9166); //90+59.75+3
	    showResults2.add(199.583); //59.75+3+536
	    showResults2.add(536.0);
  }
  
  @Test
  public void instructorTestDS() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }
  //modified instructor test for DataSmooth2
  @Test
  public void instructorTestDS2() 
  {
	  LinkedList<Double> runtimes = D2.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }
  
  //test DataSmooth1
  @Test
  public void testDS1() 
  {
	  LinkedList<Episode> eps10 = new LinkedList<Episode>();
		eps10.add(new Episode("The Letter W", 59));
		eps10.add(new Episode("The Letter P", 57));
		eps10.add(new Episode("The Letter I", 58));
		shows2.add(new Show("Sesame Street", 900, eps10)); 
		
	    showResults3.add(90.0);
	    showResults3.add(50.9166); //90+59.75+3
	    showResults3.add(199.583); //59.75+3+536
	    showResults3.add(199.0); //3+536+58
	    showResults3.add(58.0);
	  LinkedList<Double> runtimes = D1.dataSmooth(shows2);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults3.get(i), .01);
	  }
  }
  //test DataSmooth2
  @Test
  public void testDS2() 
  {
	  LinkedList<Episode> eps10 = new LinkedList<Episode>();
		eps10.add(new Episode("The Letter W", 59));
		eps10.add(new Episode("The Letter P", 57));
		eps10.add(new Episode("The Letter I", 58));
		shows2.add(new Show("Sesame Street", 900, eps10)); 
		
	    showResults3.add(90.0);
	    showResults3.add(50.9166); //90+59.75+3
	    showResults3.add(199.583); //59.75+3+536
	    showResults3.add(199.0); //3+536+58
	    showResults3.add(58.0);
	  LinkedList<Double> runtimes = D1.dataSmooth(shows2);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults3.get(i), .01);
	  }
  }
//test DataSmooth1
  @Test
  public void testDS3() 
  {

	  LinkedList<Double> runtimes = D1.dataSmooth(shows2);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults2.get(i), .01);
	  }
  }
//test DataSmooth2
  @Test
  public void testDS4() 
  {

	  LinkedList<Double> runtimes = D2.dataSmooth(shows2);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults2.get(i), .01);
	  }
  }
//test DataSmooth1
  @Test
public void testDS5() 
  {
	  LinkedList<Show> shows4 = new LinkedList<Show>();
	  LinkedList<Double> showResults4 = new LinkedList<Double>();
	  LinkedList<Double> runtimes = D1.dataSmooth(shows4);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults4.get(i), .01);
	  }
  }
//test DataSmooth2
  @Test
public void testDS6() 
  {
	  LinkedList<Show> shows4 = new LinkedList<Show>();
	  LinkedList<Double> showResults4 = new LinkedList<Double>();
	  LinkedList<Double> runtimes1 = D2.dataSmooth(shows4);
	  
	  for(int i = 0; i < runtimes1.size(); i++)
	  {
		  assertEquals(runtimes1.get(i), showResults4.get(i), .01);
	  }
  }
  
  /*SubTasks For Problem 2
   * 1)Find the average runtime of episodes of everyshow in the Show List(input)
   * 2)DUring the data smoothing of the averages identify which data is the first and the last
   * in the list and do not do anything to it
   * 3)if data is not the first of the last find the average of itself and two neighboring datas(doubles)
   * 4)return the smoothed data
   * 
   * (Second solution to this problem mixes the 1 and 2 subtasks together)
   * */

}