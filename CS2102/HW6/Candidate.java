
public class Candidate {
private String name;
private int numVotesFirst;
private int numVotesSecond;
private int numVotesThird;

public Candidate(String name) {
	this.name=name;
	this.numVotesFirst=0;
	this.numVotesSecond=0;
	this.numVotesThird=0;
}

public String getName() {
	return this.name;
}

public int getVoteFirst() {
	return this.numVotesFirst;
}
public int getVoteSecond() {
	return this.numVotesSecond;
}
public int getVoteThird() {
	return this.numVotesThird;
}


public void addVoteFirst() {
	this.numVotesFirst++;
}
public void addVoteSecond() {
	this.numVotesSecond++;
}

public void addVoteThird() {
	this.numVotesThird++;
}


}
