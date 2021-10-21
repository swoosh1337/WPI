 import java.util.LinkedList;
 
public class Competition {
int numOfShootingRounds;
LinkedList<Athlete>ListOfAthletes = new LinkedList<Athlete>();

Competition(int numOfShootingRounds){
	this.numOfShootingRounds=numOfShootingRounds;
	this.ListOfAthletes=new LinkedList<Athlete>();
}
//takes an Athlete and adds to the list

public void addAthleteToList(Athlete a) {
	this.ListOfAthletes.addFirst(a);
	
}

LinkedList<String> ShootingDNF(){
	LinkedList<String>NamesOfAthletes=new LinkedList<String>();
	
	for(Athlete a : this.ListOfAthletes) {
		if(a.shootingresult.ListOfShootingRound.size()<numOfShootingRounds) {
			NamesOfAthletes.add(a.name);
		}
	}
	return NamesOfAthletes;
	
	
}

public double  skiingScoreForAthlete(String name) {
	
	double score=0;
	for(Athlete a : this.ListOfAthletes) {
		if(a.name == name) {
			score=a.skiingresult.pointsEarned();
		}
	
	}
	return score;
}
//returns true if any athlete had better skiing score in competition one than in competition two
boolean anySkiingImprovement(Competition two) {
	for (Athlete s: this.ListOfAthletes) {
		if (s.skiingresult.pointsEarned() > two.skiingScoreForAthlete(s.name)){
					return true;
					}
			}
	return false;
}

}
