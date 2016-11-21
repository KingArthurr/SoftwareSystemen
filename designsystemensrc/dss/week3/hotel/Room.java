package dss.week3.hotel;

import dss.week3.hotel.Password;
import dss.week3.hotel.Guest;
import dss.week3.hotel.Safe;

/**
 * Hotel room with number and possibly a guest.
 */
public class Room {
    // ------------------ Instance variables ----------------

    private int number;
    private Guest guest;
    private Safe safe;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param no number of the new <code>Room</code>
     */
    public Room(int no) {
        safe = new Safe(new Password());
        number = no;
    }

    // ------------------ Queries --------------------------
    /**
     * Returns the number of this <code>Room</code>.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     * @return the guest of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code> 
     *         is not currently rented
     */
    public Guest getGuest() {
        return guest;
    }
    
    public Safe getSafe() {
        return safe;
    }
    
    public String toString() {
        return "Room " + getNumber();
    }

    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     * @param g the next guest renting this <code>Room</code>;
     *        if <code>null</code> is passed, this <code>Room</code>
     *        is empty afterwards
     */
    public void setGuest(Guest g) {
        guest = g;
    }
}
