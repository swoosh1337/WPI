import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;


public class Examples {
	
	IDWContainer List1 =  new DailyReportList ();
	WeatherMonitor W1 = new WeatherMonitor(List1 );
	
     Time T1 = new Time (1,30);
     Time T2 = new Time (1,50);
     Time T3 = new Time (1,40);
     Time T4 = new Time (1,60);
     Time T5 = new Time (1,70);
     Time T6 = new Time (1,80);
     
     
	 LinkedList<Reading>Rlist1 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist2 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist3 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist4 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist5 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist6 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist7 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist8 = new LinkedList<Reading>();
	 LinkedList<Reading>Rlist9 = new LinkedList<Reading>();
	 
	 Reading R1= new Reading (T1,50);
	 Reading R2= new Reading (T2,60);
	 Reading R3= new Reading (T3,70);
	 Reading R4= new Reading (T4,80);
	 Reading R5= new Reading (T5,90);
	 Reading R6= new Reading (T6,100);
	 
	 
	 GregorianCalendar  Tazi = new GregorianCalendar( 1999,  4 ,  23);
	 GregorianCalendar  Guga = new GregorianCalendar(1996,2,4);
	 GregorianCalendar  Bob = new GregorianCalendar (2017,1,1);
	 GregorianCalendar  Jhon = new GregorianCalendar (2017,1,10);
	 GregorianCalendar  Kate = new GregorianCalendar (2000,4,25);
	 GregorianCalendar  Arya = new GregorianCalendar (2000,4,30);
	 GregorianCalendar  Scarlett = new GregorianCalendar (2000,4,11);
	
	 
	 
	 
	 @Test
	 public void TestAddReport() {
		 
		 
	 }
	 @Test
	 
	 @Before
	 public void add1() {
		 Rlist1.add(R1);
		 
		 W1.addDailyReport(Tazi, Rlist1);
		 
		 
;	 }
	 
	 @Before 
	 public void add2() {
		Rlist2.add(R1) ;
		Rlist2.add(R2);
		Rlist2.add(R3);
		
		W1.addDailyReport(Guga, Rlist2);
		 
	 }
	 
	 
	 @Before
	 
	 public void add3() {
		 
		 Rlist4.add(R3);
		 Rlist4.add(R4);
		 Rlist5.add(R5);
		 Rlist5.add(R6);
		 
		 W1.addDailyReport(Bob, Rlist4);
         W1.addDailyReport(Jhon, Rlist5);		 
		 
	 }
	 
	 @Before
	 
	 public void add4() {
		 Rlist7.add(R1);
		 Rlist7.add(R2);
		 Rlist8.add(R3);
		 Rlist8.add(R4);
		 Rlist9.add(R5);
		 Rlist9.add(R6);
		 
		 W1.addDailyReport(Kate, Rlist7);
		 W1.addDailyReport(Kate,Rlist8);
		 W1.addDailyReport(Scarlett, Rlist9);
		 
	 }
	
	
	@Test
	public void test1() {
		try {
		assertEquals(W1.averageHighForMonth(4, 1999),50); }catch (NoDateFoundException e) {
			System.out.println("Test1: Error! No Such date found");
		}
	}
		@Test
		public void test2() {
			try {
			assertEquals(W1.averageLowForMonth(4, 1999),50,0.0001); }catch (NoDateFoundException e) {
				System.out.println("Test2: Error! No Such date found");
			}
	}
		
		@Test
		public void test3() {
			try {
				assertEquals(W1.averageHighForMonth(2, 1996),70); } catch (NoDateFoundException e ) {
					System.out.println("Test3: Error! No Such date found");
				}
				}
			
		@Test
		public void test4() {
			
			try {
				assertEquals(W1.averageLowForMonth(2, 1996),50,0.0001); } catch (NoDateFoundException e ) {
					System.out.println("Test4: Error! No Such date found");
				}
				}
		

		@Test
		public void Test5() {
			try {
				assertEquals(W1.averageHighForMonth(1, 2017),90); } catch (NoDateFoundException e ) {
					System.out.println("Test5: Error! No Such date found");
				}
		}
		@Test
		public void Test6() {
			try {
				assertEquals(W1.averageLowForMonth(1, 2017),80,0.001); } catch (NoDateFoundException e ) {
					System.out.println("Test6: Error! No Such date found");
				}
		}
		
		@Test
		public void Test7() {
			try {
				assertEquals(W1.averageHighForMonth(1, 2018),60); } catch (NoDateFoundException e ) {
					System.out.println("Test7: Error! No Such date found");
				}
		}
		
		
		@Test
		public void Test8() {
			try {
				assertEquals(W1.averageHighForMonth(5, 2017),60); } catch (NoDateFoundException e ) {
					System.out.println("Test8: Error! No Such date found");
				}
		}
		@Test
		public void Test9() {
			try {
				assertEquals(W1.averageHighForMonth(2, 2019),60); } catch (NoDateFoundException e ) {
					System.out.println("Test9: Error! No Such date found");
				}
		}
		@Test
		
		public void Test10() {
			try {
				assertEquals(W1.averageHighForMonth(1, 2000),80); } catch (NoDateFoundException e ) {
					System.out.println("Test10: Error! No Such date found");
				}
			
		}
		public void Test11() {
			try {
				assertEquals(W1.averageLowForMonth(1, 2000),70,0.0001); } catch (NoDateFoundException e ) {
					System.out.println("Test11: Error! No Such date found");
				}
		
			
		}
		
}

