package ss.week3;

public class Format {
	
	public static String printLine(String text, double amount) {
		return String.format("%-32s \u20ac %8.2f", text, amount); // Print the string with 2 decimals and maxium 8 width
	
/*	public static void printLine(String text, double amount) {
		return System.out.printf("%-20.20s %8.2f\n", text, amount); */
	}
	
	public static void main (String[] args) {
		System.out.println(printLine("text1", 1.00));
		System.out.println(printLine("other text", -12.12));
		System.out.println(printLine("something", 0.20));
	}

}

// \u20ac is Euro sign