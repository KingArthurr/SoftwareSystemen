package ss.week2.hotel;

import ss.week2.hotel.Guest;
import ss.week2.hotel.Password;
import ss.week2.hotel.Room;
import ss.week2.hotel.Safe;

public class Hotel {
	public String name;
	public String guest;
	private Password password;
	//@ public invariant freerooms >= 0;
	public int freerooms;
	public Room room1;
	public Room room2;
	public Safe safe1;
	public Safe safe2;
	
	//@ pure
	public String getName() {
		return name;
	}
	//@ ensures freerooms == 2 && this.name == name;
	//@ ensures room1.getNumber() == 101 && room2.getNumber() == 102;
	public Hotel(String name) {
		this.name = name;
		password = new Password();
		freerooms = 2;
		room1 = new Room(101);
		room2 = new Room(102);
	}
	
	//@ requires password != null && guestName != null;
	public Room checkIn(String password, String guestName) {
		assert password != null && guestName != null : "Password or guestName is null";
		Room freeRoom = getFreeRoom();
		if (this.password.testWord(password) && freeRoom != null && this.getRoom(guestName) == null){
			Guest newGuest = new Guest(guestName);
			newGuest.checkin(freeRoom);
			return freeRoom;
		} else {
			return null;
		}
	}
	
	//@ requires guestName != null;	
	//@ ensures getRoom(guestName).getSafe().isActive() == false;
	//@ ensures getRoom(guestName).getGuest().getRoom() == null;
	public void checkOut(String guestName) {
		assert guestName != null;
		Room roomOfGuest = getRoom(guestName);
		
		if (roomOfGuest != null) {
			roomOfGuest.getSafe().deactivate();
			roomOfGuest.getGuest().checkout();
		}
	}
	
	//@ requires room1.getGuest() == null || room2.getGuest() == null;
	//@ ensures \result == room1 || \result == room2 || \result == null;
	public Room getFreeRoom() {
		if (room1.getGuest() == null) {
				return room1;
			}
			else if (room2.getGuest() == null){
				return room2;
			}
			else {
				return null;
			}
	}
	
	//@ requires g != null;
	//@ ensures \result == room1 || \result == room2;
	public Room getRoom(String g) {
		Guest guest1 = room1.getGuest();;
		Guest guest2 = room2.getGuest();
		
		
		if (guest1 != null && guest1.getName().equals(g)) { 
			return room1;
		} 
		else if (guest2 != null && guest2.getName().equals(g)) {
			return room2;
		} 
		else {
			return null;
		}
		 
	}
	
	//@ pure
	public Password getPassword() {
		return password;
	}
	
	public String toString() {
		return "Hotel: " + getName() + "\n  Rooms:\n    " + room1 + "\n    " + room2;
	}
}