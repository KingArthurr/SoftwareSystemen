package ss.week3.hotel;

import ss.week3.hotel.Guest;
import ss.week3.hotel.Room;
import ss.week3.hotel.Password;

// jml kwijtgeraakt door problemen op apparaat partner

public class Hotel {
    
    private String nameHotel;
    private Password password;
    private Room room1;
    private Room room2;
    
    public Hotel(String name) {
        this.nameHotel = name;
        this.room1 = new Room(0);
        this.room2 = new Room(1);
        this.password = new Password();
        
    }
    
    public Room checkIn(String password, String name) {
        if(this.password.testWord(password) && ( (room1.getGuest() == null) || (room2.getGuest() == null) )) {
            Room room = this.getFreeRoom();
            Guest guest = new Guest(name);
            guest.checkin(room);
            return room;
        }
        
        if(this.getFreeRoom() == null){
            return null;
        }
        
        return null;
    }
    
    public void checkOut(String name) {
        if(room1.getGuest() != null && room1.getGuest().getName().equals(name)){
            room1.getGuest().checkout();
            room1.getSafe().deactivate();
        }
        if(room2.getGuest() != null && room2.getGuest().getName().equals(name)){
            room2.getGuest().checkout();
            room2.getSafe().deactivate();
        }
    }
    
    public Room getFreeRoom() {
        if (room1.getGuest() == null) {
            return room1;
        }
        else if (room2.getGuest() == null) {
            return room2;
        }
        else {
            return null;
        }
    }
    
    public Room getRoom(String name) {
        if(room1.getGuest() != null && room1.getGuest().getName().equals(name)) {
            return room1;
            }
        else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) {
            return room2;
        }
        else {
            return null;
        }
    }
    
    //*@pure;
    public Password getPassword() {
        return this.password;
    }
    
    //*@pure;
    public String getName() {
        return this.nameHotel;
    }
    
    // status van elke kluis per kamer mist nog
    public String toString() {
        Guest room1Guest = room1.getGuest();
        Guest room2Guest = room2.getGuest();
        String room1GuestString = "None";
        String room2GuestString = "None";
        if(room1Guest != null){room1GuestString = room1Guest.toString();}
        if(room2Guest != null){room2GuestString = room2Guest.toString();}
        
        String description = "Hotel: "+getName()+"\n"
                + " " + room1.toString() + "\n"
                + "  " + room1GuestString + "\n"
                + "  " + room1.getSafe().toString() + "\n"
                + " " + room2.toString() + "\n"
                + "  " + room2GuestString + "\n"
                + "  " + room2.getSafe().toString() + "\n";
        return description;
    }

}
