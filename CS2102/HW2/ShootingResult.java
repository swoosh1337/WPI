import java.util.LinkedList;


public class ShootingResult implements IEvent{
	
LinkedList<ShootingRound>ListOfShootingRound= new LinkedList<ShootingRound>();

ShootingResult() {
	this.ListOfShootingRound= new LinkedList<ShootingRound>();
}


// takes a ShootingRound and adds to the list

public void addRoundToList(ShootingRound r) {
	this.ListOfShootingRound.addFirst(r);
	
}
// returns the points earned by the athlete in shooting depending on number of hits
public double pointsEarned() {	
	 return this.sumOfPoints(this.ListOfShootingRound);
}

public double sumOfPoints (LinkedList<ShootingRound> ListOfShootingRound) {
    double pointSum=0;
  
    for ( ShootingRound r : this.ListOfShootingRound ) {
      pointSum = pointSum + r.numofhits;
    }
    return pointSum;
  }


public ShootingRound bestRound() {
	double max =0;
	ShootingRound best = new ShootingRound(0);
	
	for(ShootingRound r: this.ListOfShootingRound){
		   if(r.numofhits>max) {
		       best=r;  
		}
		   
			   
		   }
	return best;
}
}

