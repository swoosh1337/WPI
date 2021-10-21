//Kavtaradze Elene (ekavtaradze)
//Grigolia Irakli (igrigolia)
//HW3


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples {
	ShowManager1 sm1 = new ShowManager1();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	ShowManager1 sm2 = new ShowManager1();

	ShowManager1 sm3 = new ShowManager1();
	LinkedList<Show> shows2 = new LinkedList<Show>();
	LinkedList<Show> shows3 = new LinkedList<Show>();
	LinkedList<Show> shows4 = new LinkedList<Show>();
	LinkedList<Show> shows5 = new LinkedList<Show>();
	ShowSummary report3 = new ShowSummary();
	ShowSummary report4 = new ShowSummary();
	ShowSummary report5 = new ShowSummary();

	public ShowExamples() {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));
		Show s1 = new Show("Star Trek", 1800, eps1);
		shows.add(s1);
		report1.primetime.add(s1);

		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2);
		shows.add(s2);
		report1.primetime.add(s2);

		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3);
		shows.add(s3);
		report1.daytime.add(s3);

		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4);
		shows.add(s4);
		report1.daytime.add(s4);

		Show s5 = new Show("Elenes show", 2355, eps4); // none
		Show s6 = new Show("Elenes show", 2355, eps4); // none
		Show s7 = new Show("Elenes show", 2355, eps4); // none
		shows2.add(s5);
		shows2.add(s6);
		shows2.add(s7);
		Show s8 = new Show("Elenes show", 600, eps4); // daytime
		Show s9 = new Show("Elenes show", 1700, eps4); // primetime
		Show s10 = new Show("Elenes show", 2300, eps4); // none
		Show s11 = new Show("Elenes show", 2230, eps4); // primetime
		Show s12 = new Show("Elenes show", 1340, eps4); // daytime
		Show s13 = new Show("Elenes show", 1320, eps4); // daytime

		shows3.add(s8);
		shows3.add(s9);
		shows3.add(s10);
		report3.daytime.add(s8);
		report3.primetime.add(s9);

		shows4.add(s9);
		shows4.add(s11);
		shows4.add(s5);
		report4.primetime.add(s9);
		report4.primetime.add(s11);

		shows5.add(s12);
		shows5.add(s13);
		shows5.add(s10);
		report5.daytime.add(s12);
		report5.daytime.add(s13);
	}

	@Test
	public void instructorTestOrganizeShows() {
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}

	// modified for ShowManager2
	@Test
	public void instructorTestOrganizeShows2() {
		ShowSummary report2 = sm2.organizeShows(shows);
		assertEquals(report1, report2);
	}

	// checks organizeShows for ShowManager1 // no daytime or primetime
	@Test
	public void testOrganizeShows1() {
		assertEquals(sm1.organizeShows(shows2), new ShowSummary());
	}

	// checks organizeShows for ShowManager2 // no daytime or primetime
	@Test
	public void testOrganizeShows2() {
		assertEquals(sm2.organizeShows(shows2), new ShowSummary());
	}

	// checks organizeShows for ShowManager1// both primetime and daytime
	@Test
	public void testOrganizeShows3() {
		assertEquals(sm1.organizeShows(shows3), report3);
	}

	// checks organizeShows for ShowManager2// both primetime and daytime
	@Test
	public void testOrganizeShows4() {
		assertEquals(sm2.organizeShows(shows3), report3);
	}

	// checks organizeShows for ShowManager1 // only primetimes
	@Test
	public void testOrganizeShows5() {
		assertEquals(sm1.organizeShows(shows4), report4);
		// System.out.println(sm1.organizeShows(shows2));
	}

	// checks organizeShows for ShowManager2 // only primetimes
	@Test
	public void testOrganizeShows6() {
		assertEquals(sm2.organizeShows(shows4), report4);
		// System.out.println(sm1.organizeShows(shows2));
	}

	// checks organizeShows for ShowManager1// only daytimes
	@Test
	public void testOrganizeShows7() {
		assertEquals(sm1.organizeShows(shows5), report5);
		//System.out.println(report5);
	}

	// checks organizeShows for ShowManager2 // only daytimes
	@Test
	public void testOrganizeShows8() {
		assertEquals(sm2.organizeShows(shows5), report5);
		//System.out.println(report5);
	}

	/*
	 * Subtasks for Problem 1 
	 * 1)Check which shows from input list run during daytime[6:00AM,5:00 PM) or primetime [5:00PM,11:00PM)
	 * 2) If any run during those times add them to a ShowSummary variable
	 * 3) Return that ShowSummary variable
	 */
}
