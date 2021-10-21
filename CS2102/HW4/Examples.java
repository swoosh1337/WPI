import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {


		DataHeap myHeap= new DataHeap (4);
		
		
		IBinTree myHeap1 = new DataBT(4, new MtBT(), new DataBT(5));

		HeapTester H1 = new HeapTester();	
		HeapTester H2 = new HeapTester();	
		IHeap heap = new DataHeap(4);
		IBinTree L1= new DataHeap(6);
		IBinTree R1= new DataHeap(7);
		DataBT B1 = new DataBT(5, L1,R1);
		IBinTree myHeap2 = new DataBT(5, L1, R1);
		IHeap L2= new DataHeap(6);
		IHeap R2= new DataHeap(7);
		IHeap B2 = new DataHeap(5,L2, R2);
		DataHeap myHeap3= new DataHeap (5);
		
		
	@Test
		  public void test1(){
		   assertTrue(H1.addEltTester(myHeap,5,myHeap.addElt(5)));
		  }
	@Test
	  public void test2(){
	   assertTrue(H1.addEltTester(myHeap.addElt(6),7, myHeap.addElt(6).addElt(7)));
	  }
	@Test
	  public void test3(){

	   assertTrue(H1.addEltTester(B2, 7, myHeap3.addElt(7).addElt(6).addElt(7)));
	  }
	@Test
	  public void test4(){
		//System.out.println(B2.hasElt(6));

	   assertTrue(H1.addEltTester(B2, 7, B2.addElt(7)));
	  }
	@Test
	  public void test5(){
	   assertTrue(H1.addEltTester(new MtHeap(), 4, myHeap ));
	  }

	@Test
	  public void test6(){

	   assertTrue(H1.addEltTester(myHeap,5,myHeap.addElt(5)));

	  }

	@Test
	  public void test7(){
	   assertTrue(H1.remMinEltTester(myHeap, myHeap.remMinElt()));
	  }
	@Test
	  public void test8(){
	   assertTrue(H1.remMinEltTester(myHeap, new MtHeap()));
	  }
	@Test
	  public void test9(){

	   assertTrue(H1.remMinEltTester(B2, B2.remMinElt()));
	  }
	@Test
	  public void test10(){
		assertTrue(H1.remMinEltTester(myHeap3.addElt(7).addElt(6).addElt(7), 
				myHeap3.addElt(7).addElt(6).addElt(7).remMinElt()));

	  }
	@Test
	  public void test11(){

	   assertTrue(H1.remMinEltTester(myHeap.addElt(6), new DataHeap(6)));
	  }
		// tests the areBothHeaps method
 // @Test
		  public void test22(){
			assertTrue(true);
		    assertTrue(B1.checker1());
		   // assertTrue(!H1.areBothHeaps(B1, new DataBT(8, L1, R1)));
		   // assertTrue(H1.areBothHeaps(B1, new DataBT(5, L1, R1)));
		    //assertTrue(!H1.areBothHeaps(B1, new DataBT(7, L1, R1)));
		  }

		/*  DataBT Data1 = new DataBT(7);
			DataBT Data2 = new DataBT(8, new DataBT(9),new DataBT(9));
			DataBT Data3 = new DataBT(9,(new DataBT(10,new DataBT(11),new MtBT())),new MtBT());
			DataBT Data4 = new DataBT(9,new MtBT(),new DataBT(10,new MtBT(),new DataBT(12)));
			MtBT  EmptyData = new MtBT();
			DataBT Data5 = new DataBT(9,new DataBT(10),new DataBT(11,new MtBT(),new DataBT(13)));
			DataBT Data6 = new DataBT(9,new DataBT(10,new DataBT(11),new MtBT()),new DataBT(10));
			DataBT Data7 = new DataBT(9,new DataBT(9),new DataBT(9));
			
			LinkedList<Integer>List2 = new LinkedList<Integer>();
			LinkedList<Integer>List3 = new LinkedList<Integer>();
			LinkedList<Integer>List4 = new LinkedList<Integer>();
			LinkedList<Integer>List5 = new LinkedList<Integer>();
			LinkedList<Integer>List6 = new LinkedList<Integer>();
			LinkedList<Integer>List7 = new LinkedList<Integer>();
			LinkedList<Integer>List8 = new LinkedList<Integer>();
			LinkedList<Integer>List9 = new LinkedList<Integer>();
			@Test
			public void test() {
				List2.add(7);
				assertEquals(List2,Data1.Convert());
			}
			
			@Test
		
			public void test111() {
				List3.add(8);
				List3.add(9);
				List3.add(9);
				
				assertEquals(List3,Data2.Convert());
			}
			
			@Test
			public void test222() {
				List4.add(9);
				List4.add(10);
				List4.add(11);
				
				assertEquals(List4,Data3.Convert());
			}
			
			@Test
			public void test33() {
				List5.add(9);
				List5.add(10);
				List5.add(12);
				
				assertEquals(List5,Data4.Convert());
			}
			
			@Test
			public void test44 () {
				assertEquals(List6,EmptyData.Convert());
			}
			
			@Test
			public void test55() {
				List6.add(9);
				List6.add(10);
				List6.add(11);
				List6.addLast(13);
				
				assertEquals(List6,Data5.Convert());
			}
			@Test
			public void test66() {
				List7.add(9);
				List7.add(10);
				List7.add(11);
				List7.add(10);
				System.out.println(Data6.Convert());
				assertEquals(List7,Data6.Convert());
			}
			
			@Test
			public void test77() {
				List7.add(9);
				List7.add(9);
				List7.add(9);
				System.out.println(Data7.Convert());
				assertEquals(List7, Data7.Convert());
			}
			@Test
			public void test777() {
				
				assertEquals(List7, EmptyData.Convert());
			}*/
		
	}


