import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



	public class Examples {
		public Examples(){}
		    
		   ShootingRounds Shoot1  =new ShootingRounds(3);
		   ShootingRounds Shoot2  =new ShootingRounds(5);
		   ShootingRounds Shoot3  =new ShootingRounds(1);
		   ShootingRounds Shoot4  =new ShootingRounds(4); 
		   
		   ShootingRounds Shoot5  =new ShootingRounds(0);
		   ShootingRounds Shoot6  =new ShootingRounds(5);
		   ShootingRounds Shoot7  =new ShootingRounds(2);
		   ShootingRounds Shoot8  =new ShootingRounds(4);
		   
		   ShootingRounds Shoot9  =new ShootingRounds(5);
		   ShootingRounds Shoot10 =new ShootingRounds(5);
		   ShootingRounds Shoot11 =new ShootingRounds(5);
		   ShootingRounds Shoot12 =new ShootingRounds(5); 
		   
		   ShootingRounds Shoot13  =new ShootingRounds(0);
		   ShootingRounds Shoot14  =new ShootingRounds(5);
		   ShootingRounds Shoot15 =new ShootingRounds(2);
		   ShootingRounds Shoot16  =new ShootingRounds(4);
		    
		   ShootingResult SR1 =new ShootingResult (Shoot1,Shoot2,Shoot3,Shoot4);
		   ShootingResult SR2 =new ShootingResult (Shoot5,Shoot6,Shoot7,Shoot8);
		   ShootingResult SR3 =new ShootingResult (Shoot9,Shoot10,Shoot11,Shoot12);
		   ShootingResult SR4 =new ShootingResult (Shoot13,Shoot14,Shoot15,Shoot16);
		   
		   SkiingResult SKR1 =new SkiingResult (2.3,1,SR1);
;		   SkiingResult SKR2 =new SkiingResult (2,2,SR2);
		   SkiingResult SKR3 =new SkiingResult (2.3,3,SR3);
		   SkiingResult SKR4 =new SkiingResult (2,4,SR4);
		   
		   Athlete Ath1 = new Athlete (SR1,SKR1);
		   Athlete Ath2 =new Athlete (SR2,SKR2);
		   
		   @Test
		   public void penatltiesMethodCheck1() {
			   assertEquals(142.3,SKR1.addShootingPenalties(SR1));
		   }
		   @Test
		   public void penaltiesMethodCheck2() {
			   assertEquals(182,SKR2.addShootingPenalties(SR2));
		   }
		   @Test
		   public void pointsEarnedTest1() {
			   assertEquals(13,SR1.pointsEarned());
		   }
		   @Test
		   public void pointsEarnedTest2() {
			   assertEquals(11,SR2.pointsEarned());
		   }
		   @Test 
		   public void pointsEarnedTest3() {
			   
			   assertEquals(132.3,SKR1.pointsEarned());
		   }
		   @Test
		   public void pointsEarnedTest4() {
			  assertEquals(175,SKR2.pointsEarned());
		   }
		   @Test 
		   public void pointsEarnedTest5() {
			   assertEquals(-0.7,SKR3.pointsEarned(),.0000001);
		   }
		   @Test
		   public void pointsEarnedTest6() {
			   assertEquals(182,SKR4.pointsEarned());
		   }
		   @Test
		   public void betterSkieerTest1() {
			   assertEquals(Ath1,Ath1.betterSkiier(Ath2));
		   }
		   @Test
		   public void betterSkieerTest2() {
			   assertEquals(Ath1,Ath2.betterSkiier(Ath1));
		   }
		   
		   @Test
		   public void hasBeatenTest1() {
			   assertTrue(Ath1.hasBeaten(Ath2));
		   }
		   @Test
		   public void hasBeatenTest2() {
			   assertFalse(Ath2.hasBeaten(Ath1));
		   }
	}


