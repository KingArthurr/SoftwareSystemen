package ss.week3.hotel;

/**
 * Hotel guest with name, room(number) and checkin/checkout.
 *  * @author Maarten, Reinier
 */

public class Guest {
    
    // ------------------ Instance variables ----------------
    
    public String name;
    public Room room;
    
    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Guest</code> with the given name, without a room.
     * @param n name new <code>Guest</code>
     */
    
    public Guest(String n){
        this.name = n;
    }
    
    // ------------------ Queries --------------------------

    /**
     * Returns the name of this <code>Guest</code>.
     */
    
    
    public String getName(){
        return this.name;
    }

    /**
     * Returns the current room the <code>Guest</code> is living in.
     * @return the room of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code> 
     *         is not currently renting
     */

    public Room getRoom(){
        return this.room;
    }
    
    /**
     * Assign the name to the <code>Guest</code>.
     * @return the name of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code> 
     *         is not currently renting
     */
    
    public String toString(){
        return "Guest: "+getName();
    }
    
    /**
     * Check a new guest in to a empty room    
     * @param r the room the <code>Guest</code> is renting
     * @return true if checkin succeeded, or false if the guest already has a room or r already has a guest.
     */
    
    public boolean checkin(Room r){
        if(this.room==null && r.getGuest()==null){
            this.room = r;
            r.setGuest(this);
            return true;
        }
        return false;
    }
    
    /**
     * Check a guest out and set the guest and the room back to null
     * @return true if checkout succeeded, or false if guest does not have a room.
     */
    
    public boolean checkout(){
        if(this.room!=null && this.room.getGuest()==this){
            this.room.setGuest(null);
            this.room = null;
            return true;
        }
        return false;
    }
    
}
