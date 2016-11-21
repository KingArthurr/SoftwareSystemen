package ss.week3.hotel;

public class Format {
	
	public static void printLine(String text, double number){
		System.out.println(String.format("%-30s%10.2f", text, number));
	}
	
	public static void main(String[] args){
		printLine("nul:", 0);
		printLine("Pi:", 3.141592653);
		printLine("The answer to everything:", 42);
		printLine("geboortejaar:", 1701);
	}
	
}