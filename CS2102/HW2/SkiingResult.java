
public class SkiingResult extends AbsForResults implements IEvent {
	
	ShootingResult result;

	SkiingResult(double time, int position, ShootingResult result) {
		super(time, position);
		this.result = result;
	}

	// returns modified time of athlete considering his/her number of missed shots
	double addShootingPenalties(ShootingResult r) {
		double score = 0;
		for (ShootingRound s : r.ListOfShootingRound) {
			score = score + (20 * (5 - s.numofhits));
		}
		return this.time + score;
	}

	// returns points earned by athlete considering his/her number
	// of missed shots and position
	public double pointsEarned() {
		double timeM = this.addShootingPenalties(result); // addShootingPenalties returns time(double)
		if (this.position == 1)
			return (timeM - 10);
		if (this.position == 2)
			return (timeM - 7);
		if (this.position == 3)
			// return (this.time -3);
			return (timeM - 3);
		else
			return timeM;
	}
}
