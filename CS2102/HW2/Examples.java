import org.junit.Before;
import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {
    public Examples() {}
    	

Competition Comp1 = new Competition(4);
Competition Comp2 = new Competition(4);
	
ShootingRound round1 = new ShootingRound(5);
ShootingRound round2 = new ShootingRound(5);
ShootingRound round3 = new ShootingRound(2);
ShootingRound round4 = new ShootingRound(4);

ShootingResult goodResult = new ShootingResult();
ShootingResult badResult = new ShootingResult();
ShootingResult okayResult = new ShootingResult();




SkiingResult firstSkier = new SkiingResult (85.6, 1, okayResult);
SkiingResult secondSkier = new SkiingResult (92.6, 2, goodResult);
SkiingResult thirdSkier = new SkiingResult (95.0, 3, badResult);
SkiingResult fourthSkier = new SkiingResult (95.0, 4, badResult);

SkiingResult testResult = new SkiingResult(50,1,okayResult);

Athlete Athlete1 = new Athlete("Bob",goodResult, firstSkier);
Athlete Athlete2 = new Athlete("Stephen",okayResult, secondSkier);
Athlete Athlete3 = new Athlete("Robert",badResult, fourthSkier); 



	
@Before
public void addingAthletes1() {
	
Comp1.addAthleteToList(Athlete1);
Comp1.addAthleteToList(Athlete2);
Comp1.addAthleteToList(Athlete3);



}@Before
public void addingAthletes2() {
	Athlete Athlete1 = new Athlete("Bob",goodResult,testResult);
Comp2.addAthleteToList(Athlete1);
Comp2.addAthleteToList(Athlete2);
Comp2.addAthleteToList(Athlete3);
}
@Test
public void test1() {
	

	assertTrue(Comp2.anySkiingImprovement(Comp1));
}

@Test
public void testBestRound() {

assertEquals(goodResult.bestRound(),round1);
}

@Test
public void testAddingRounds() {
	assertEquals(goodResult.ListOfShootingRound.size(),4);
}

@Test
public void testAddingAthletes() {
	assertEquals(Comp1.ListOfAthletes.size(),3);
}


@Test
public void sumOfPoints() {
	assertEquals(goodResult.sumOfPoints(goodResult.ListOfShootingRound),16,0);
}

@Test
public void pointsEarnedForShootingResult() {
	assertEquals(goodResult.pointsEarned(),16,0);
}

@Test 
public void dnfCheck() {
	  goodResult.addRoundToList(round1);
	  goodResult.addRoundToList(round2);
	  goodResult.addRoundToList(round3);
	  goodResult.addRoundToList(round4);
	  badResult.addRoundToList(round1);
	  okayResult.addRoundToList(round2);
	  okayResult.addRoundToList(round3);
	  LinkedList<String>Names=new LinkedList<String>();
	  Names.addFirst("Stephen");
	  Names.addFirst("Robert");
	  assertEquals(Comp1.ShootingDNF(),Names);
	  
	  
}
   @Test
   public void testForSkiingScore() {
	   okayResult.addRoundToList(round1);

	   
	   assertEquals(Comp1.skiingScoreForAthlete("Bob"),75.6,0);
			   
   }
   @Before
   public void  addingRounds() {
   	
   	goodResult.addRoundToList(round1);
   	goodResult.addRoundToList(round2);
   	goodResult.addRoundToList(round3);
   	goodResult.addRoundToList(round4);
   }
   
   @Test
   public void testPenalties() {
	   okayResult.addRoundToList(round1);
	
	   
	   assertEquals(firstSkier.addShootingPenalties(okayResult),85.6,0);
   }

}
