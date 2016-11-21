package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {
	
	private List<String> parties;
	
	public PartyList() {
		parties = new ArrayList<String>();
	}
	
	public void addParty(String party) {
		parties.add(party);
		
		setChanged();
		notifyObservers("party");
	}
	
	public List<String> getParties() {
		return parties;
	}
	
	public boolean hasParty(String party) {
		if (parties.contains(party)) {
			return true;
		} else {
			return false;
		}
	}
}
