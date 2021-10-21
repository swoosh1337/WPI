import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
	Earthquake1 E1 = new Earthquake1();
	Earthquake2 E2 = new Earthquake2();
	LinkedList<Double> noData = new LinkedList<Double>();
	LinkedList<Double> threeDates = new LinkedList<Double>();
	LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> NovReports2 = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> NovReports3 = new LinkedList<MaxHzReport>();

	public EarthquakeExamples() {
		threeDates.add(20151013.0);
		threeDates.add(10.0);
		threeDates.add(5.0);
		threeDates.add(20151020.0);
		threeDates.add(40.0);
		threeDates.add(50.0);
		threeDates.add(45.0);
		threeDates.add(20151101.0);
		threeDates.add(6.0);
		NovReports.add(new MaxHzReport(20151101.0, 6.0));

		threeDates.add(20151201.0);
		threeDates.add(6.0);
		threeDates.add(20151213.0);
		threeDates.add(10.0);
		threeDates.add(5.0);
		threeDates.add(20151220.0);
		threeDates.add(40.0);
		threeDates.add(50.0);
		threeDates.add(45.0);
		NovReports2.add(new MaxHzReport(20151201.0, 6.0));
		NovReports2.add(new MaxHzReport(20151213.0, 10.0));
		NovReports2.add(new MaxHzReport(20151220.0, 50.0));

	}

	@Test
	public void instructorTestEQ() {
		assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
	}
	//modified instructor test for Earthquake2
	@Test
	public void instructorTestEQ2() {
		assertEquals(NovReports, E2.dailyMaxForMonth(threeDates, 11));
	}

	// test Earthquake1
	@Test
	public void testEQ1() {
		// System.out.println(E1.dailyMaxForMonth(threeDates, 12));
		// System.out.println(NovReports2);
		assertEquals(NovReports2, E1.dailyMaxForMonth(threeDates, 12));
	}

	// test Earthquake2
	@Test
	public void testEQ2() {

		assertEquals(NovReports2, E2.dailyMaxForMonth(threeDates, 12));
	}

	// test Earthquake1
	@Test
	public void testEQ3() {

		assertEquals(NovReports3, E1.dailyMaxForMonth(threeDates, 9));
	}

	// test Earthquake2
	@Test
	public void testEQ4() {

		assertEquals(NovReports3, E2.dailyMaxForMonth(threeDates, 9));
	}

	// test Earthquake1
	@Test
	public void testEQ5() {
		assertEquals(NovReports3, E1.dailyMaxForMonth(noData, 9));
	}// test Earthquake2

	@Test
	public void testEQ6() {
		assertEquals(NovReports3, E2.dailyMaxForMonth(noData, 9));
	}
	
/*Subtasks for Problem3
 * 1)Differentiate between a date data and vibration data
 * 2)Check which date in the input list corresponds to the needed month(input)
 * 3)Find the maximum vibration data for each date of the needed month
 * 4)Return list
 * */
}
