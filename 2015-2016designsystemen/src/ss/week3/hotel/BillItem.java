package ss.week3.hotel;

public class BillItem implements Bill.Item {

	private double amount;
	private String item;
	
	public BillItem(String text, double price) {
		this.amount = price;
		this.item = text;
	}
	
	public double getAmount() {
		return amount;
	}

	public String toString() {
		return item;
	}

}
