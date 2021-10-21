import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Examples {
	public Examples() {

	}
	// method to set up a ballot and cast votes

	ElectionData Setup1() // throws CandidateExistsException
	{

		ElectionData ED = new ElectionData();

		// put candidates on the ballot

		// cast votes

		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");

		} catch (CandidateExistsException e) {
		}
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");

		} catch (UnknownCandidateException e) {
		} catch (DuplicateVotesException b) {
		}

		return (ED);

	}
	// now run a test on a specific election
		@Test
		public void testMostFirstWinner() // throws CandidateExistsException
		{
			assertEquals("gompei", Setup1().findWinnerMostFirstVotes());
		}

		@Test
		public void testMostPoints() // throws CandidateExistsException
		{
			assertEquals("gompei", Setup1().findWinnerMostPoints());
		}
		// checks for CandidateExistsException
		@Test(expected = CandidateExistsException.class)
		public void testCandidateExsistsExcep() throws CandidateExistsException {
			Setup1().addCandidate("gompei");
		}

		// checks for DuplicateVoteException
		@Test(expected = DuplicateVotesException.class)
		public void testDuplicateVoteExcep() throws UnknownCandidateException, DuplicateVotesException {

			Setup1().processVote("gompei", "husky", "gompei");
		}

		// checks for UnkownCandidateException
		@Test(expected = UnknownCandidateException.class)
		public void testUnknownCandExcep() throws UnknownCandidateException, DuplicateVotesException {
			Setup1().processVote("husky", "Husky", "gompei");
		}
	ElectionData Setup2()
	{

		ElectionData ED2 = new ElectionData();

		// put candidates on the ballot

		// cast votes

		try {
			ED2.addCandidate("Elene");
			ED2.addCandidate("Kote");
			ED2.addCandidate("Ana");

		} catch (CandidateExistsException e) {
		}
		try {
			ED2.processVote("Elene", "Ana", "Kote");
			ED2.processVote("Elene", "Kote", "Ana");
			ED2.processVote("Kote", "Ana", "Elene");
			ED2.processVote("Kote", "Ana", "Elene");
			ED2.processVote("Kote", "Ana", "Elene");
			ED2.processVote("Elene", "Ana", "Kote");
			ED2.processVote("Elene", "Kote", "Ana");
			ED2.processVote("Ana", "Kote", "Elene");
			ED2.processVote("Ana", "Kote", "Elene");
			ED2.processVote("Elene","Kote", "Ana");

		} catch (UnknownCandidateException k) {
		} catch (DuplicateVotesException f) {
		}

		return (ED2);

	}
	
	@Test
	public void testMostFirstWinner2() // throws CandidateExistsException
	{
		assertEquals("Runoff required", Setup2().findWinnerMostFirstVotes());
	}
	@Test
	public void testMostPoints2() // throws CandidateExistsException
	{
		//Gompei 2
		//Husky 1
		//Elene 18
		//Kote 20
		//Ana 19

		assertEquals("Kote", Setup2().findWinnerMostPoints());
	}
	ElectionData Setup3()
	{

		ElectionData ED3 = new ElectionData();

		// put candidates on the ballot

		// cast votes

		try {
			ED3.addCandidate("Racket");
			ED3.addCandidate("Java");
			ED3.addCandidate("Python");

		} catch (CandidateExistsException e) {
		}
		try {
			ED3.processVote("Racket", "Java", "Python");
			ED3.processVote("Java", "Racket", "Python");
			ED3.processVote("Racket", "Java", "Python");

		} catch (UnknownCandidateException k) {
		} catch (DuplicateVotesException f) {
		}

		return (ED3);

	}

	@Test
	public void testMostFirstWinner3() // throws CandidateExistsException
	{
		assertEquals("Racket", Setup3().findWinnerMostFirstVotes());
	}
	@Test
	public void testMostPoints3() // throws CandidateExistsException
	{

		assertEquals("Racket", Setup3().findWinnerMostPoints());
	}
	
	


}
