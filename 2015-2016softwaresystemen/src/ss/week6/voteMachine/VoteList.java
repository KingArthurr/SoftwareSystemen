package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
	
	private Map<String, Integer> votes;
	
	public VoteList() {
		votes = new HashMap<String, Integer>();
	}
	
	public Map<String, Integer> getVotes() {
		return votes;
	}

	public void addVote(String party) {
		votes.put(party, getVotes(party) + 1);
		
		setChanged();
		notifyObservers("vote");
	}
	
	public int getVotes(String partyName) {
		Integer votes;
		votes = this.votes.get(partyName);
		if (votes == null) {
			return 0;
		} else {
			return votes;
		}
	}
}
