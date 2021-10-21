
public class ShootingResult implements IEvent{
ShootingRounds round1;
ShootingRounds round2;
ShootingRounds round3;
ShootingRounds round4;

ShootingResult(ShootingRounds round1,ShootingRounds round2,ShootingRounds round3,ShootingRounds round4){
	this.round1=round1;
	this.round2=round2;
	this.round3=round3;
	this.round4=round4;

}
// returns the points earned by the athlete in shooting depending on number of hits
public double pointsEarned() {
	
return (this.round1.numofhits+this.round2.numofhits+this.round3.numofhits+this.round4.numofhits);	
}

}
