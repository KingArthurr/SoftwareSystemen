package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {
	
	private PartyList partyList;
	private VoteList voteList;
	private VoteView view;
	
	public VoteMachine() {
		partyList = new PartyList();
		voteList = new VoteList();
		view = new VoteGUIView(this); // change T=G

		partyList.addObserver(view);
		voteList.addObserver(view);
	}
	
	public static void main(String[] args) {
		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();
	}
	
	public void start() {
		view.start();
	}
	
	public void addParty(String party) {
		partyList.addParty(party);
	}
	
	public void vote(String party) {
		if (!(partyList.hasParty(party))) {
			System.out.println("Party does not exist.");
		} else voteList.addVote(party);
	}
	
	public void getVotes() {
		Map<String,Integer> votes = voteList.getVotes();
		view.showVotes(votes);
	}
	
	public void getParties() {
		List<String> parties = partyList.getParties();
		view.showParties(parties);
	}
}
