package dss.week3.hotel;

import java.io.PrintStream;

public class Bill {
	
	@SuppressWarnings("unused")
	private PrintStream bill;
	private double totalPrice;

	public static interface Item {
		public double getAmount();
	}
	
	public Bill(PrintStream theOutStream){
		this.bill = theOutStream;
		this.totalPrice = 0;
	}
	
	public void newItem(Item item){
		double price = item.getAmount();
		this.totalPrice += price;
		
		Format.printLine("Item Added:", price);
	}
	
	public double getSum(){
		return this.totalPrice;
	}
	
	public void close(){
		Format.printLine("Total:", this.getSum());
	}	
}