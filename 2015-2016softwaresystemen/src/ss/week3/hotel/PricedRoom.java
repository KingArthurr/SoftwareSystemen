package ss.week3.hotel;

import ss.week3.Format;

public class PricedRoom extends Room implements Bill.Item {
	
	private double price;
	
	public PricedRoom(int number, double roomPrice, double safePrice) {
		super(number, new PricedSafe(safePrice));
		price = roomPrice;
	}
	
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return super.toString() + Format.printLine("Price of the room per night: €", price);
	}
	

}
