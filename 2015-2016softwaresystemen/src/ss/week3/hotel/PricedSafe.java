package ss.week3.hotel;

import ss.week3.Format;

public class PricedSafe extends Safe implements Bill.Item {
	
	private double price;
	
	public PricedSafe(double fee) {
		price = fee;
	}
	
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return Format.printLine("Price of the safe: €", price);
	}
}
