
public class SkiingResult implements IEvent {
double time;
int position;
ShootingResult result;


SkiingResult(double time,int position,ShootingResult result){
	this.time=time;
	this.position=position;
	this.result=result;
}
// returns  modified time of athlete considering his/her number of missed shots
double addShootingPenalties (ShootingResult r) {
	return (this.time+((20 *(5- r.round1.numofhits))+(20 * (5-r.round2.numofhits))+(20*(5-r.round3.numofhits))+(20*(5-r.round4.numofhits))));
}
// returns points earned by athlete considering his/her number of missed shots and position
public double pointsEarned() {
	
double x = this.addShootingPenalties(result); 
	if(this.position==1) {
		return (x - 10 );
	} if(this.position==2) {
		return (x - 7);
	}if(this.position==3) {
		return (x -3);
	}else return x;
}
}


