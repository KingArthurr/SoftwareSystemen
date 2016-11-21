package ss.week3.hotel;

/** 
 * Function for creating and handling a Guest in our hotel
 * @author Jelle
 * @version 0.8
 */
public class Guest {
	// --- Intance Vars ---
	
	private String name;
	private Room room;

	// --- Constructor ---
	
	/**
	 * Creates a new <code>Guest</code> with a given name
	 * @param n, the name of our new <code>Guest</code>
	 */
	public Guest(String n) {
		this.name = n;
	}
	
	// --- Commands ---
	
	/**
	 * Puts a guest into a certain room. Checks whether or not the room is available, and if the guest already has a room or not
	 * @return a boolean whether or not the checkin was succesful
	 */
	
	public boolean checkin(Room r) {
		if (r.getGuest() == null) {
			r.setGuest(this);
			room = r;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Puts a <code>Guest</code> out of a room
	 * @return a boolean whether the checkout was succesful or not
	 */
	public boolean checkout() {
		if (this.getRoom() != null) {
			room.setGuest(null);
			if (room.getGuest() == null) {
				room = null;
			}
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// --- Queries ---
	
	/**
	 * Returns the name of the guest
	 * @return name of our <code>Guest</code>
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * A query to get the roomnumber our <code>Guest</code> in is
	 * @return the room number of our <code>Guest</code>.
	 */
	public Room getRoom() {
		return room;
	}
	
    public String toString() {
        return "Guest " + this.getName();
    }
	
}
