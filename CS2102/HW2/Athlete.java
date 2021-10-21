public class Athlete {
	String name;
	ShootingResult shootingresult;
	SkiingResult skiingresult;
	public Athlete(String name ,ShootingResult shootingresult, SkiingResult skiingresult) {
		this.name=name;
		this.shootingresult=shootingresult;
		this.skiingresult=skiingresult;
	}
	
// returns the skier with the lower Skiing score
public Athlete betterSkiier (Athlete two) {
	if(this.skiingresult.pointsEarned()< two.skiingresult.pointsEarned())
		return this;
	else return two;
}

// returns true if Athletes shooting score is higher or skiing score is 
// lower than the input Athletes
public boolean hasBeaten(Athlete two) {
	return ((this.shootingresult.pointsEarned() > two.shootingresult.pointsEarned()) 
			||
			(this.skiingresult.pointsEarned() < two.skiingresult.pointsEarned()));
}
}