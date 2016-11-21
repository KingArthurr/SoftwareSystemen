package ss.week3.hotel;

import java.io.*;

import ss.week3.hotel.Bill;

public class Bill {
	
	//Nested interface of Item
	public static interface Item {
		
		public double getAmount();
	}
	
	// --- Instance Variables ---
	
	private PrintStream outStream;
	private double sum = 0.0;
	
	// --- Constructor ---
	
	public Bill(PrintStream theOutStream) {
		outStream = theOutStream;
	}
	
	// --- Methods ---
	
	public void close() {
		/*System.out.println(outStream);*/
		if (outStream != null) {
			outStream.println("Total costs are: €" + this.getSum());
		}
	}
	public double getSum() {
		return sum;
	}
	
	public void newItem(Bill.Item item) {
		sum = sum + item.getAmount(); //'the amount will be added to the sum of the Bill'
		if (outStream != null) { //'If there is an output'
			outStream.println(item); //'the item will be printed on this output'
		}
	}

}
