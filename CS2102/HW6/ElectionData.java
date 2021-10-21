import java.util.LinkedList;
import java.util.HashMap;

class ElectionData {

	private HashMap<String, Candidate> election = new HashMap<String, Candidate>();
	private LinkedList<String> names = new LinkedList<String>();

	public ElectionData() {

	}
	public int getFirst(String a) {
		return election.get(a).getVoteFirst();
	}
	public int getSecond(String a) {
		return election.get(a).getVoteSecond();
	}
	public int getThird(String a) {
		return election.get(a).getVoteThird();
	}
	public LinkedList<String> getNames() {
		LinkedList<String> hell = new LinkedList<String>(election.keySet());
		return hell;
		// return hell;
	}

	public String findWinnerMostFirstVotes() {

		double numTotalVotes = 0;

		for (int i = 0; i < names.size(); i++) {
			numTotalVotes += (double )election.get(names.get(i)).getVoteFirst();
		}

		double half = numTotalVotes / 2.0;
		System.out.println("total "+ numTotalVotes+"   half   "+ half);
		LinkedList<String> a = new LinkedList<String>();
		for (int i = 0; i < names.size(); i++) {
			double comp = election.get(names.get(i)).getVoteFirst();
			System.out.println(comp);
			if (comp > half) {
				a.add(names.get(i));
			//System.out.println(election.get(names.get(i)).getName() +"   "+ comp);
			}
		}
		if (a.size() == 1)
			return a.getFirst();
		else
			return "Runoff required";


	}

	public String findWinnerMostPoints() {
		//System.out.println(election.get("Kote").getVoteFirst());
		//System.out.println(election.get(i);
		int first = ((election.get(names.get(0)).getVoteFirst()) * 3) + 
					((election.get(names.get(0)).getVoteSecond()) * 2) +
					(election.get(names.get(0)).getVoteThird());
		String firstName = election.get(names.get(0)).getName();
		
		//System.out.println(election.get(names.get(0)).getName()+"   "+ first);
		
		for (int i = 1; i < names.size(); i++) {
			int second = ((election.get(names.get(i)).getVoteFirst()) * 3) +
						 ((election.get(names.get(i)).getVoteSecond()) * 2) + 
						 (election.get(names.get(i)).getVoteThird());
			
			//System.out.println(election.get(names.get(i)).getName() + "     " + second);
			
			if (first < second) {
				first = second;
				firstName = election.get(names.get(i)).getName();
			}
		}
		//System.out.println(firstName+"   "+ election.get(firstName).getVoteFirst());
		return firstName;

	}


	public void addCandidate(String name) throws CandidateExistsException {

		if (election.get(name) != null) {
			{
				throw new CandidateExistsException(name);
			}
		} else {
			election.put(name, new Candidate(name));
			names.add(name);
		}
	}

	public void processVote(String one, String two, String three)
			throws UnknownCandidateException, DuplicateVotesException {
		if (election.get(one) == null) {
			throw new UnknownCandidateException(one);
		}
		if (election.get(two) == null) {
			throw new UnknownCandidateException(two);
		}
		if (election.get(three) == null) {
			throw new UnknownCandidateException(three);
		}

		if (one.equals(two))
			throw new DuplicateVotesException(two);
		if (one.equals(three))
			throw new DuplicateVotesException(three);
		if (two.equals(three))
			throw new DuplicateVotesException(three);
		election.get(one).addVoteFirst();
		election.get(two).addVoteSecond();
		election.get(three).addVoteThird();
	}

}