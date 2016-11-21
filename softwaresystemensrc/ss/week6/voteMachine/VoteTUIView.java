package ss.week6.voteMachine;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class VoteTUIView implements VoteView, Observer {
	
	private String VOTE = "VOTE";
	private String ADDPARTY = "ADDPARTY";
	private String VOTES = "VOTES";
	private String PARTIES = "PARTIES";
	private String EXIT = "EXIT";
	private String HELP = "HELP";
	private VoteMachine voteMachine;
	
	public VoteTUIView(VoteMachine voteMachine) {
		this.voteMachine = voteMachine;
	}
	
	public void start() {
		boolean notEmpty = true;
		System.out.println("Welcome");
		Scanner in = new Scanner(System.in);
		while(notEmpty) {
			String command = in.next();
			if (command.equals(VOTE)) {
				voteMachine.vote(in.next());
			}
			if (command.equals(ADDPARTY)) {
				voteMachine.addParty(in.next());
			}
			if (command.equals(VOTES)) {
				voteMachine.getVotes();
			}
			if (command.equals(PARTIES)) {
				voteMachine.getParties();
			}
			if (command.equals(EXIT)) {
				System.out.println("Thank you for using");
				notEmpty = false;
			}
			if (command.equals(HELP)) {
				System.out.println("Use on of the following commands:");
				System.out.println("VOTE: Make a vote");
				System.out.println("ADDPARTY: Add a party");
				System.out.println("VOTES: Show all votes");
				System.out.println("PARTIES: Show all parties");
				System.out.println("EXIT: Exits voting");
				System.out.println("HELP: This menu");
			}
		}
		in.close();
	}
	
	public void showVotes(Map<String, Integer> votes) {
		System.out.println(votes);
	}
	
	public void showParties(List<String> parties) {
		System.out.println(parties);
	}
	
	public void showError(String error) {
		System.out.println(error);
	}
	
	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("vote")) {
			System.out.println("A vote was added");
		}
		if (arg1.equals("party")) {
			System.out.println("A party was added");
		}
	}
}
