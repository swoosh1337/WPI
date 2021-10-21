

public class Athlete {
	ShootingResult shootres;
	SkiingResult skiingres;
	
	Athlete(ShootingResult shootres,SkiingResult skiingres){
		this.shootres=shootres;
		this.skiingres=skiingres;
	}
	
	
	
public 	Athlete betterSkiier(Athlete anotherathlete) {
if(this.skiingres.pointsEarned() > anotherathlete.skiingres.pointsEarned()) {
	
	return anotherathlete;
	
}
else return this ;
	
}
//returns true if Athletes shooting score is higher or skiing score is 
	// lower than the input Athletes
public boolean hasBeaten(Athlete two) {
	return ((this.shootres.pointsEarned() > two.shootres.pointsEarned()) 
			||
			(this.skiingres.pointsEarned() < two.skiingres.pointsEarned()));
}
	

}