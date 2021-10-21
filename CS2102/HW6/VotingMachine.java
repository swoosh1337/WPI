import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

public class VotingMachine {
	
	ElectionData data = new ElectionData();
	
	
	Scanner keyboard = new Scanner(System.in);


	public void printBallot() {
		System.out.println("The candidates are ");
		 
			for(String s:data.getNames())	{
					System.out.println(s);
				}
		
			
	}
	
	public void screen() {
		this.printBallot();
		System.out.println("Who do you want to vote for? type 3 names ");
		String candidate1 = keyboard.next();
		String candidate2 = keyboard.next();
		String candidate3 = keyboard.next();
		try {
		data.processVote(candidate1, candidate2, candidate3) ;
		System.out.println("Your first choice is " + candidate1+"," +"Your second choice is " + candidate2 + "," + "your third choice is " + candidate3);
		} catch ( UnknownCandidateException e) {
			System.out.println("Error! such candidate does not exist! try again");
			this.screen();
		} catch (  DuplicateVotesException e) {
			System.out.println("Error! do not duplicate names  please! try again!");
			this.screen();
		}
			
		
		
		
	}
}